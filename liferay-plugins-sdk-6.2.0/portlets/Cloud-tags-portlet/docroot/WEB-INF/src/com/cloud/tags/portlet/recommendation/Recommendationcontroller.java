package com.cloud.tags.portlet.recommendation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;
import java.util.Map.Entry;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cloud.tags.NoSuchDesignersImagesException;
import com.cloud.tags.common.CommonUtil;
import com.cloud.tags.common.ImpressionTypes;
import com.cloud.tags.common.MailUtil;
import com.cloud.tags.common.util.Constants;
import com.cloud.tags.model.Carts;
import com.cloud.tags.model.CartsDesigners;
import com.cloud.tags.model.Designers;
import com.cloud.tags.model.DesignersImages;
import com.cloud.tags.model.Impressions;
import com.cloud.tags.model.Recommendations;
import com.cloud.tags.model.StoreDeviceMap;
import com.cloud.tags.model.StoreInformationMap;
import com.cloud.tags.service.CartsDesignersLocalServiceUtil;
import com.cloud.tags.service.CartsLocalServiceUtil;
import com.cloud.tags.service.DesignersImagesLocalServiceUtil;
import com.cloud.tags.service.DesignersLocalServiceUtil;
import com.cloud.tags.service.ImpressionsLocalServiceUtil;
import com.cloud.tags.service.RecommendationsLocalServiceUtil;
import com.cloud.tags.service.StoreDeviceMapLocalServiceUtil;
import com.cloud.tags.service.StoreInformationMapLocalServiceUtil;
import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;
/**
 * @author Azam
 * @author Mohammed zaheer
 * Portlet implementation class Recommendationcontroller
 * this class manages each of products added to selected and displayed in designers page
 */
public class Recommendationcontroller extends MVCPortlet {

	private final static Logger _log = Logger
			.getLogger(Recommendationcontroller.class.getName());

	@Override
	public void init() throws PortletException {
		// TODO Auto-generated method stub
		super.init();
	}
	/**
	 * This method manages each product added to CART and stores the values into DB
	 */
	@SuppressWarnings("unchecked")
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		// Future store records into CARt table per userIDs
		UploadPortletRequest uploadPortletRequest = PortalUtil
				.getUploadPortletRequest(resourceRequest);
		HttpSession session = PortalUtil.getHttpServletRequest(resourceRequest)
				.getSession();

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		long loginUserRec = themeDisplay.getUserId();
		if(Validator.isNotNull(session.getAttribute("FIRST-LOGIN-USER"))){
			loginUserRec = Long.parseLong(session.getAttribute("FIRST-LOGIN-USER").toString());
		}

		String loginUser = StringPool.BLANK;

		long storeId = CommonUtil.getStoreIdForDevice(session);

		if(Validator.isNotNull(session.getAttribute("LOGIN-USER"))){
			System.out.println("LOGIN-USER inside recommendations if");
			loginUser = session.getAttribute("LOGIN-USER").toString();
		}

		String cmd = ParamUtil.getString(uploadPortletRequest, "CMD");
		System.out.println("CMD : "+cmd);
		if(cmd.equals("ADDED2CART")){
			_log.info("Insided added cart");



			long productId = ParamUtil.getLong(uploadPortletRequest, "productId");
			session.setAttribute("HISTORY-PATH", "/designers?designId="+productId);

			_log.info("Insided added cart : "+productId);

			String deviceName = StringPool.BLANK;
			String deviceType = StringPool.BLANK;
			String browserName = StringPool.BLANK;
			String deviceWidth = StringPool.BLANK;

			boolean prodAdded = true;

			if(Validator.isNotNull(session.getAttribute("deviceName"))){
				deviceName = session.getAttribute("deviceName").toString();
			}
			if(Validator.isNotNull(session.getAttribute("deviceType"))){
				deviceType = session.getAttribute("deviceType").toString();
			}
			if(Validator.isNotNull(session.getAttribute("browserName"))){
				browserName = session.getAttribute("browserName").toString();
			}
			if(Validator.isNotNull(session.getAttribute("deviceWidth"))){
				deviceWidth = session.getAttribute("deviceWidth").toString();
			}

			HashMap<Long, Designers> cartList = null;// new HashMap<Long,
			// Designers>();
			HashMap<Long, CartsDesigners> cartDesigners = null;


			Designers designers = null;
			try {

				designers = DesignersLocalServiceUtil.getDesigners(productId);

				if (Validator.isNotNull(session.getAttribute("LIFERAY_SHARED_CARTLIST"))) {

					cartList = (HashMap<Long, Designers>) session
							.getAttribute("LIFERAY_SHARED_CARTLIST");

				} else {

					cartList = new HashMap<Long, Designers>();
				}

				if(!cartList.containsKey(productId)){
					cartList.put(productId, designers);
				}else
					prodAdded = false;
				session.setAttribute("LIFERAY_SHARED_CARTLIST", cartList);

				System.out.println("cart List : "+cartList);

			} catch (PortalException e) {
				_log.error(e.getMessage());
			} catch (SystemException e) {
				_log.error(e.getMessage());
			}

			// This is added to track the cart and the designers

			try {

				//logic need to be changed by checking the cart Id exists or not if yes dont create new cart else create new cart obj

				Carts carts = null;

				//System.out.println(session.getAttribute("CARTID"));
				if (Validator.isNotNull(session.getAttribute("CARTID"))) {

					try {
						System.out.println("inside try>>>>>>>>>>>>");
						carts = CartsLocalServiceUtil.getCarts( (Long)session.getAttribute("CARTID"));
						session.setAttribute("CARTID", carts.getCartId());

					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (PortalException e) {
						e.printStackTrace();
					}

				} else {

					carts = CartsLocalServiceUtil.addToCarts(loginUserRec);

					session.setAttribute("CARTID", carts.getCartId());
					try {
						if(Validator.isNotNull(session.getAttribute("LOGIN-USER"))){
							System.out.println("LOGIN-USER inside recommendations if");
							//loginUser = session.getAttribute("LOGIN-USER").toString();
							carts.setSession_id(session.getAttribute("LOGIN-USER").toString());							
						}
						if(Validator.isNotNull(session.getAttribute("LOGINSTAFF"))){
							System.out.println("LOGINSTAFF inside recommendations if");
							carts.setStaffId(session.getAttribute("LOGINSTAFF").toString());
						}
						CartsLocalServiceUtil.updateCarts(carts);
						Impressions impressions = 	ImpressionsLocalServiceUtil.addToImpressions(ImpressionTypes.CARTS.getValue(),
								Long.toString(carts.getCartId()), ImpressionTypes.ADDED.getValue(),loginUser ,
								Long.toString(themeDisplay.getCompanyId()), 
								PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
								deviceName,deviceType,deviceWidth,browserName, storeId);
						if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressions != null){					
							impressions.setStaffId(session.getAttribute("LOGINSTAFF").toString());
							ImpressionsLocalServiceUtil.updateImpressions(impressions);
						}


					}catch (Exception e) {
						e.printStackTrace();
					}
				}



				if (Validator.isNotNull(session.getAttribute("LIFERAY_SHARED_CARTDESIGNERS"))) {

					cartDesigners = (HashMap<Long, CartsDesigners>) session
							.getAttribute("LIFERAY_SHARED_CARTDESIGNERS");

				} else {
					cartDesigners = new HashMap<Long, CartsDesigners>();
				}

				if (cartDesigners.size() == 0 || !cartDesigners.containsKey(productId)) {

					if (Validator.isNotNull(carts)) {

						CartsDesigners cartsDesigners = CartsDesignersLocalServiceUtil
								.addDesignerToCarts(carts.getCartId(), productId,
										true);
						String staffId = null;
						if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")))
							staffId = session.getAttribute("LOGINSTAFF").toString();

						if(staffId != null && cartsDesigners != null){
							cartsDesigners.setStaffId(staffId);
							CartsDesignersLocalServiceUtil.updateCartsDesigners(cartsDesigners);
							/*Map<String, String> salesAssociates = null;
							System.out.println("In reco add cart designers : " +cartsDesigners.getCartDesignerId() +" "+staffId);
							String staffTag = Constants.SALES_ASS_TAG_PREFIX + staffId;
							if(Validator.isNotNull(session.getAttribute(Constants.SALES_ASSOCIATE_LIST))){
								salesAssociates = (HashMap<String, String>) session.getAttribute(Constants.SALES_ASSOCIATE_LIST);				

							}else{
								salesAssociates = new HashMap<String, String>();	
								salesAssociates.put(staffTag, staffTag);
							}
							String staffCartTag = salesAssociates.get(staffTag);
							staffCartTag += "_"+cartsDesigners.getCartDesignerId();
							salesAssociates.put(staffTag,staffCartTag);
							session.setAttribute(Constants.SALES_ASSOCIATE_LIST, salesAssociates);*/
						}



						Impressions impressions =  ImpressionsLocalServiceUtil.addToImpressions(ImpressionTypes.CART_PRODUCT.getValue(), 
								Long.toString(cartsDesigners.getCartDesignerId()), ImpressionTypes.ADDED.getValue(),loginUser , 
								Long.toString(themeDisplay.getCompanyId()), 
								PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
								deviceName,deviceType,deviceWidth,browserName,storeId);
						if(staffId != null && impressions != null){
							impressions.setStaffId(session.getAttribute("LOGINSTAFF").toString());
							ImpressionsLocalServiceUtil.updateImpressions(impressions);
						}

						cartDesigners.put(productId, cartsDesigners);
						session.setAttribute("LIFERAY_SHARED_CARTDESIGNERS",
								cartDesigners);
					}

				}
			} catch (SystemException e) {

				_log.error(e.getMessage());
			}

			if(designers != null){

				DesignersImages designersImages = null;
				try {
					designersImages = DesignersImagesLocalServiceUtil.getByDesignId(designers.getDesignId());
				} catch (NoSuchDesignersImagesException | SystemException e) {
					_log.error(e.getMessage());
				}
				resourceResponse.setContentType("text/html");
				PrintWriter writer = resourceResponse.getWriter();
				JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
				/*JSONArray jsonObjectArrayWidth =  JSONFactoryUtil.createJSONArray(widthJson);
				        JSONArray jsonObjectArrayHeight =  JSONFactoryUtil.createJSONArray(heightJson);*/


				if(prodAdded){

					jsonObject.put("name", designers.getName());
					jsonObject.put("pTitle", designers.getProductTitle());
					jsonObject.put("price", designers.getPrice());


					jsonObject.put("shortDesc", designers.getShortDescription().replaceAll("</br>", ""));
					jsonObject.put("image1", (designersImages != null ? designersImages.getEntity_image1().replace(PortletProps.get("main.image.dimension"),PortletProps.get("list.page.dimension")) : ""));
					jsonObject.put("cartSize", cartList.size());

					JSONArray relatedItems = getRelItems(designers, productId, cartList);
					JSONArray ourEdit = getOurEdit(designers, productId, cartList);
					//System.out.println("relatedItems : "+relatedItems);
					jsonObject.put("relatedItems", relatedItems);

					//System.out.println("Our Edit : "+ourEdit);
					jsonObject.put("ourEdit", ourEdit);

					/*try{
					JSONArray relatedItems = JSONFactoryUtil.createJSONArray();
					JSONArray ourEdit = JSONFactoryUtil.createJSONArray(); 

						List<Recommendations> listRecomm = RecommendationsLocalServiceUtil.getByDesigner1(1, designers.getBarcode(), designers.getCompanyId());
						//List<Designers> itemsByColor = DesignersLocalServiceUtil.getByCompanyId(themeDisplay.getCompanyId())
						System.out.println(designers.getBarcode()+">>>>>>>>>>>>>>>>>>>>>>>>"+listRecomm.size());
						int count =0;

						for(Recommendations recommendations : listRecomm) {
							Designers designer = DesignersLocalServiceUtil.getByCompanyId(recommendations.getCompanyId(), recommendations.getDesigner2());
							if(designer != null && designer.getDesignId() == productId ) continue;
							//if(object.getColors().equalsIgnoreCase(designer.getColors())){
							//count ++;
							//if(count>6) break;

							if(count>=3) break;

							try{
								DesignersImages designerImages = 
										DesignersImagesLocalServiceUtil.getByDesignId(designer.getDesignId());
								String URL = "/designers?designId=";

								URL = URL + designer.getDesignId();

								JSONObject obj = JSONFactoryUtil.createJSONObject();

								obj.put("designId", (designer != null) ? Long.toString(designer.getDesignId()) : "");
								obj.put("image1", (designerImages != null ? designerImages.getEntity_image1() : ""));
								obj.put("url", URL);

								relatedItems.put(obj);
								count ++;
							}catch(Exception e){

							}
						}
						System.out.println("relatedItems : "+relatedItems);
						jsonObject.put("relatedItems", relatedItems);
					}catch(SystemException  e){
						//e.printStackTrace();

					}
					try{
						List<Recommendations> 
						listRecomm = RecommendationsLocalServiceUtil.getByDesigner1(2, designers.getBarcode(), designers.getCompanyId());
						//List<Designers> itemsByColor = DesignersLocalServiceUtil.getByCompanyId(themeDisplay.getCompanyId())
						System.out.println(designers.getBarcode()+">>>>>>>>>>>>>>>>>>>>>>>>"+listRecomm.size());
						int count =0;
						for(Recommendations recommendations : listRecomm) {
							Designers designer = DesignersLocalServiceUtil.getByCompanyId(recommendations.getCompanyId(), recommendations.getDesigner2());
							if(designer != null && designer.getDesignId() == productId ) continue;
							//if(object.getColors().equalsIgnoreCase(designer.getColors())){
							//count ++;
							//if(count>6) break;

							if(count>=3) break;

							try{
								DesignersImages designerImages = 
										DesignersImagesLocalServiceUtil.getByDesignId(designer.getDesignId());
								String URL = "/designers?designId=";

								URL = URL + designer.getDesignId();

								JSONObject obj = JSONFactoryUtil.createJSONObject();

								obj.put("designId", (designer != null) ? Long.toString(designer.getDesignId()) : "");
								obj.put("image1", (designerImages != null ? designerImages.getEntity_image1() : ""));
								obj.put("url", URL);

								ourEdit.put(obj);
								count ++;
							}catch(Exception e){

							}
						}
						System.out.println("Our Edit : "+ourEdit);
						jsonObject.put("ourEdit", ourEdit);
					}catch(SystemException  e){
						e.printStackTrace();

					}*/

					System.out.println("jsonObject : "+jsonObject);
					/*jsonObject.put("width1", jsonObjectArrayWidth);
				        jsonObject.put("height1", jsonObjectArrayHeight);*/
				}
				writer.print(jsonObject.toString());
				writer.flush();
				writer.close();
			}
		}else if(cmd.equals("LIKED")){
			_log.info("Insided liked cart");



			long productId = ParamUtil.getLong(uploadPortletRequest, "productId");
			String deviceName = StringPool.BLANK;
			String deviceType = StringPool.BLANK;
			String browserName = StringPool.BLANK;
			String deviceWidth = StringPool.BLANK;

			if(Validator.isNotNull(session.getAttribute("deviceName"))){
				deviceName = session.getAttribute("deviceName").toString();
			}
			if(Validator.isNotNull(session.getAttribute("deviceType"))){
				deviceType = session.getAttribute("deviceType").toString();
			}
			if(Validator.isNotNull(session.getAttribute("browserName"))){
				browserName = session.getAttribute("browserName").toString();
			}
			if(Validator.isNotNull(session.getAttribute("deviceWidth"))){
				deviceWidth = session.getAttribute("deviceWidth").toString();
			}

			HashMap<Long, Designers> cartList = null;// new HashMap<Long,
			// Designers>();
			//HashMap<Long, CartsDesigners> cartDesigners = null;

			Designers designers = null;
			try {

				designers = DesignersLocalServiceUtil.getDesigners(productId);

				if (Validator.isNotNull(session.getAttribute("LIFERAY_LIKED_CARTLIST"))) {

					cartList = (HashMap<Long, Designers>) session
							.getAttribute("LIFERAY_LIKED_CARTLIST");

				} else {

					cartList = new HashMap<Long, Designers>();
				}
				cartList.put(productId, designers);
				session.setAttribute("LIFERAY_LIKED_CARTLIST", cartList);

				designers.setLiked(designers.getLiked()+1);
				DesignersLocalServiceUtil.updateDesigners(designers);

				Carts carts = CartsLocalServiceUtil.getCarts((Long)session.getAttribute("CARTID"));
				CartsDesigners cartsDesigners = CartsDesignersLocalServiceUtil.findBycartIdDesignId(carts.getCartId(), productId);

				cartsDesigners.setFavorite(true);
				CartsDesignersLocalServiceUtil.updateCartsDesigners(cartsDesigners);	


				_log.info(">>>>>>>>>>>>>"+cartsDesigners.getFavorite());


				Impressions impressions = 	ImpressionsLocalServiceUtil.addToImpressions(ImpressionTypes.CART_PRODUCT.getValue(),
						Long.toString(cartsDesigners.getCartDesignerId()), ImpressionTypes.LIKED.getValue(),loginUser , 
						Long.toString(themeDisplay.getCompanyId()), 
						PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
						deviceName,deviceType,deviceWidth,browserName, storeId);


				if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressions != null){
					impressions.setStaffId(session.getAttribute("LOGINSTAFF").toString());
					ImpressionsLocalServiceUtil.updateImpressions(impressions);
				}

			} catch (PortalException e) {
				_log.error(e.getMessage());
			} catch (SystemException e) {
				_log.error(e.getMessage());
			}
		}else if (cmd.equalsIgnoreCase("sendEmail")) {
			boolean sayDuck = false;

			String emailAddress = uploadPortletRequest.getParameter("email");// ParamUtil.getString(resourceRequest,"email");

			//session.setAttribute("FIRST-EMAIL", emailAddress);
			System.out.println(ParamUtil.getString(uploadPortletRequest,
					"email"));
			//System.out.println(uploadPortletRequest.getAttribute("email"));
			System.out.println("I am here with email address" + emailAddress);


			long userId = CommonUtil.getUserByEmail(emailAddress, themeDisplay.getCompanyId());

			updateUserIdOfCart(session,userId);

			String emailTemplate = PortletProps.get("email.template.data");  // commented for time beaing MailUtil.getContent(PropsUtil.get("cartEmalTemplate"), themeDisplay);

			HashMap<Long, Designers> cartList = null;

			String data = PortletProps.get("email.template.variable");

			StringBuffer buffer = new StringBuffer();

			StringBuffer recoBuffer = new StringBuffer();

			String cartId = StringPool.BLANK;
			if (Validator.isNotNull(session.getAttribute("LIFERAY_SHARED_CARTLIST"
					))) {
				cartList = (HashMap<Long, Designers>) session
						.getAttribute("LIFERAY_SHARED_CARTLIST");

				HashMap<Long, CartsDesigners> list = (HashMap<Long, CartsDesigners>) session
						.getAttribute("LIFERAY_SHARED_CARTDESIGNERS");


				String productIds = CommonUtil.getCartProducts(cartList);

				Map<Long, CartsDesigners> mapsec = new TreeMap<Long, CartsDesigners>(list).descendingMap();
				Map<Long, CartsDesigners> mapnew = new HashMap<Long, CartsDesigners>();
				Map<Long, CartsDesigners> mapadded = new HashMap<Long, CartsDesigners>();
				Set set2 = mapsec.entrySet();
				Iterator iterator2 = set2.iterator();
				while(iterator2.hasNext()) {
					Map.Entry me2 = (Map.Entry)iterator2.next();

					CartsDesigners cartsDesigners = (CartsDesigners)me2.getValue();			              
					CartsDesigners cartsDesigner1 = null;
					try {
						cartsDesigner1 = CartsDesignersLocalServiceUtil.getCartsDesigners(cartsDesigners.getCartDesignerId());
					} catch (PortalException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SystemException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			              
					if(cartsDesigner1.isFavorite()){
						mapnew.put(cartsDesigners.getCartDesignerId(), cartsDesigners);
						System.out.println("Liked Product:>>>>>>"+cartsDesigners.getCartDesignerId());
					}else{
						mapadded.put(cartsDesigners.getCartDesignerId(), cartsDesigners);
						System.out.println("Added Product:>>>>>>"+cartsDesigners.getCartDesignerId());
					}


				}
				mapnew = new TreeMap<Long, CartsDesigners>(mapnew).descendingMap();
				mapadded = new TreeMap<Long, CartsDesigners>(mapadded).descendingMap();


				Collection<CartsDesigners> designersCollection = CommonUtil.mergelikedAdded(mapnew, mapadded).values();

				Map<Long, Designers> map = new HashMap<Long, Designers>();//new TreeMap<Long, Designers>(cartList).descendingMap();
				long d = 1;
				for (CartsDesigners designers3 : designersCollection) {
					_log.info("CartsDesigners######>>>"+designers3.getCartDesignerId());
					Designers designers2;
					try {
						designers2 = DesignersLocalServiceUtil.getDesigners(designers3.getDesignId());
						map.put(d, designers2);
						d++;
					} catch (PortalException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SystemException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				Map<Long, Designers> immpressionMap = new HashMap<Long, Designers>();
				Map<Long, Designers> matchingMap = new HashMap<Long, Designers>();
				Map<Long, Designers> recommendationMap = new HashMap<Long, Designers>();
				Map<Long, Designers> randomMap = new HashMap<Long, Designers>();


				Map<Long, Designers> masterMap = new HashMap<Long, Designers>();


				if(cartList.size()>=1 && cartList.size() <= 3){
					_log.info("************Only 6 products in email list*************************");
					try {
						int i = 6 - cartList.size();
						List<Impressions> impList = ImpressionsLocalServiceUtil.getByImpressionTypeAction(ImpressionTypes.PRODUCT.getValue(), ImpressionTypes.TAPPED.getValue(), session.getAttribute("LOGIN-USER").toString(), Long.toString(themeDisplay.getCompanyId()));
						// From Impression 
						for(Impressions impress : impList){
							if(i>0){
								Designers designers = DesignersLocalServiceUtil.getDesigners(Long.parseLong(impress.getImpressionId()));
								if(Validator.isNotNull(designers)){
									if(!cartList.containsKey(designers.getDesignId()) && !immpressionMap.containsKey(designers.getDesignId())){
										_log.info("Inside impressions  products and Id: "+designers.getDesignId());
										immpressionMap.put(designers.getDesignId(), designers);
										i--;
									}}
							}

						}
						/*// From AF matching with products
							for(Designers designer : map.values()){
								if(i>0){
									String matchingProducts = designer.getMatchWith();

									if(Validator.isNotNull(matchingProducts)){
										String[] matchingProdList = matchingProducts.split("&#44;");
										for(int j=0;j<matchingProdList.length;j++){
											Designers designers = DesignersLocalServiceUtil.getByCompanyId(themeDisplay.getCompanyId(), matchingProdList[j]);
											if(Validator.isNotNull(designers)){
												if(i>0 && !cartList.containsKey(designers.getDesignId()) && !matchingMap.containsKey(designers.getDesignId())){	
													_log.info("Inside matching  products and Id: "+designers.getDesignId());
													matchingMap.put(designers.getDesignId(), designers);
													i--;
												}
											}
										}

									}

								}
							}*/

						List<Designers> recommList = RecommendationsLocalServiceUtil
								.getNimbusRecommendations(loginUser, emailAddress, productIds,
										6, themeDisplay.getCompanyId(), "");

						if(recommList != null && i > 0){
							for(Designers designer : recommList){

								if(i>0 && !cartList.containsKey(designer.getDesignId()) 
										&& !recommendationMap.containsKey(designer.getDesignId())){	
									_log.info("Inside recommendation 6 products and Id: "+designer.getDesignId());

									recommendationMap.put(designer.getDesignId(), designer);
									i--;
								}
							}
						}

						/*for(Designers designer : map.values()){
								if(i>0){
									List<Recommendations> recommList = RecommendationsLocalServiceUtil.getByDesigner1(1, designer.getBarcode(), themeDisplay.getCompanyId());
									for(Recommendations recomm : recommList){
										Designers designers = DesignersLocalServiceUtil.getByCompanyId(themeDisplay.getCompanyId(), recomm.getDesigner2());
										if(Validator.isNotNull(designers)){
											if(i>0 && !cartList.containsKey(designers.getDesignId()) && !recommendationMap.containsKey(designers.getDesignId())){	
												_log.info("Inside recommendation color products and Id: "+designers.getDesignId());

												recommendationMap.put(designers.getDesignId(), designers);
												i--;
											}}
									}
									List<Recommendations> recommListType = RecommendationsLocalServiceUtil.getByDesigner1(2, designer.getBarcode(), themeDisplay.getCompanyId());
									for(Recommendations recomm : recommListType){
										Designers designers = DesignersLocalServiceUtil.getByCompanyId(themeDisplay.getCompanyId(), recomm.getDesigner2());
										if(Validator.isNotNull(designers)){
											if(i>0 && !cartList.containsKey(designers.getDesignId()) && !recommendationMap.containsKey(designers.getDesignId())){
												_log.info("Inside recommendation Type products and Id: "+designers.getDesignId());

												recommendationMap.put(designers.getDesignId(), designers);
												i--;
											}}
									}
									List<Recommendations> recommListCollection = RecommendationsLocalServiceUtil.getByDesigner1(3, designer.getBarcode(), themeDisplay.getCompanyId());
									for(Recommendations recomm : recommListCollection){
										Designers designers = DesignersLocalServiceUtil.getByCompanyId(themeDisplay.getCompanyId(), recomm.getDesigner2());
										if(Validator.isNotNull(designers)){
											if(i>0 && !cartList.containsKey(designers.getDesignId()) && !recommendationMap.containsKey(designers.getDesignId())){	
												_log.info("Inside recommendation collection products and Id: "+designers.getDesignId());
												recommendationMap.put(designers.getDesignId(), designers);
												i--;
											}
										}
									}

								}

							}*/
						/*List<Designers> desigList = DesignersLocalServiceUtil.getDesignerses(0, 1000);
							for(Designers design : desigList){
								if(i>0 && !cartList.containsKey(design.getDesignId()) && !randomMap.containsKey(design.getDesignId())){	
									_log.info("Inside random products and Id: "+design.getDesignId());
									randomMap.put(design.getDesignId(), design);
									i--;
								}

							}*/

					} catch (SystemException | NumberFormatException | ConcurrentModificationException |  PortalException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}else if(cartList.size() >= 4 && cartList.size() <=8){

					_log.info("************Only 9 products in email list*************************");
					try {
						int i = 9 - cartList.size();
						List<Impressions> impList = ImpressionsLocalServiceUtil.getByImpressionTypeAction(ImpressionTypes.PRODUCT.getValue(), ImpressionTypes.TAPPED.getValue(), session.getAttribute("LOGIN-USER").toString(), Long.toString(themeDisplay.getCompanyId()));
						// From Impression 
						for(Impressions impress : impList){
							if(i>0){
								Designers designers = DesignersLocalServiceUtil.getDesigners(Long.parseLong(impress.getImpressionId()));
								if(Validator.isNotNull(designers)){
									if(!cartList.containsKey(designers.getDesignId()) && !immpressionMap.containsKey(designers.getDesignId())){
										_log.info("Inside impressions  products and Id: "+designers.getDesignId());
										immpressionMap.put(designers.getDesignId(), designers);
										i--;
									}}
							}

						}
						/*// From AF matching with products
							for(Designers designer : map.values()){
								if(i>0){
									String matchingProducts = designer.getMatchWith();

									if(Validator.isNotNull(matchingProducts)){
										String[] matchingProdList = matchingProducts.split("&#44;");
										for(int j=0;j<matchingProdList.length;j++){
											Designers designers = DesignersLocalServiceUtil.getByCompanyId(themeDisplay.getCompanyId(), matchingProdList[j]);
											if(Validator.isNotNull(designers)){
												if(i>0 && !cartList.containsKey(designers.getDesignId()) && !matchingMap.containsKey(designers.getDesignId())){	
													_log.info("Inside matching  products and Id: "+designers.getDesignId());
													matchingMap.put(designers.getDesignId(), designers);
													i--;
												}
											}
										}

									}

								}
							}*/

						List<Designers> recommList = RecommendationsLocalServiceUtil
								.getNimbusRecommendations(loginUser, emailAddress, productIds,
										9, themeDisplay.getCompanyId(), "");

						if(recommList != null && i > 0){
							for(Designers designer : recommList){

								if(i>0 && !cartList.containsKey(designer.getDesignId()) 
										&& !recommendationMap.containsKey(designer.getDesignId())){	
									_log.info("Inside recommendation 9 products and Id: "+designer.getDesignId());

									recommendationMap.put(designer.getDesignId(), designer);
									i--;
								}
							}
						}

						/*for(Designers designer : map.values()){
								if(i>0){
									List<Recommendations> recommList = RecommendationsLocalServiceUtil.getByDesigner1(1, designer.getBarcode(), themeDisplay.getCompanyId());
									for(Recommendations recomm : recommList){
										Designers designers = DesignersLocalServiceUtil.getByCompanyId(themeDisplay.getCompanyId(), recomm.getDesigner2());
										if(Validator.isNotNull(designers)){
											if(i>0 && !cartList.containsKey(designers.getDesignId()) && !recommendationMap.containsKey(designers.getDesignId())){	
												_log.info("Inside recommendation color products and Id: "+designers.getDesignId());

												recommendationMap.put(designers.getDesignId(), designers);
												i--;
											}}
									}
									List<Recommendations> recommListType = RecommendationsLocalServiceUtil.getByDesigner1(2, designer.getBarcode(), themeDisplay.getCompanyId());
									for(Recommendations recomm : recommListType){
										Designers designers = DesignersLocalServiceUtil.getByCompanyId(themeDisplay.getCompanyId(), recomm.getDesigner2());
										if(Validator.isNotNull(designers)){
											if(i>0 && !cartList.containsKey(designers.getDesignId()) && !recommendationMap.containsKey(designers.getDesignId())){
												_log.info("Inside recommendation Type products and Id: "+designers.getDesignId());

												recommendationMap.put(designers.getDesignId(), designers);
												i--;
											}}
									}
									List<Recommendations> recommListCollection = RecommendationsLocalServiceUtil.getByDesigner1(3, designer.getBarcode(), themeDisplay.getCompanyId());
									for(Recommendations recomm : recommListCollection){
										Designers designers = DesignersLocalServiceUtil.getByCompanyId(themeDisplay.getCompanyId(), recomm.getDesigner2());
										if(Validator.isNotNull(designers)){
											if(i>0 && !cartList.containsKey(designers.getDesignId()) && !recommendationMap.containsKey(designers.getDesignId())){	
												_log.info("Inside recommendation collection products and Id: "+designers.getDesignId());
												recommendationMap.put(designers.getDesignId(), designers);
												i--;
											}
										}
									}

								}

							}*/
						/*List<Designers> desigList = DesignersLocalServiceUtil.getDesignerses(0, 1000);
							for(Designers design : desigList){
								if(i>0 && !cartList.containsKey(design.getDesignId()) && !randomMap.containsKey(design.getDesignId())){	
									_log.info("Inside random products and Id: "+design.getDesignId());
									randomMap.put(design.getDesignId(), design);
									i--;
								}

							}*/

					} catch (SystemException | NumberFormatException | ConcurrentModificationException | PortalException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				long incrementProduct = 1;
				int addedCount = 1;
				for (Designers designer : map.values()) {
					if(!masterMap.containsValue(designer)){
						masterMap.put(incrementProduct, designer);
						incrementProduct++;
						addedCount++;
					}
				}
				for (Designers designer : immpressionMap.values()) {
					if(!masterMap.containsValue(designer)){
						masterMap.put(incrementProduct, designer);
						incrementProduct++;
					}
				}
				/*for (Designers designer : matchingMap.values()) {
						if(!masterMap.containsValue(designer)){
							masterMap.put(incrementProduct, designer);
							incrementProduct++;
						}
					}*/
				/*for (Designers designer : recommendationMap.values()) {
						if(!masterMap.containsValue(designer)){
							masterMap.put(incrementProduct, designer);
							incrementProduct++;
						}
					}*/
				/*for (Designers designer : randomMap.values()) {
						if(!masterMap.containsValue(designer)){
							masterMap.put(incrementProduct, designer);
							incrementProduct++;
						}
					}*/
				

				List<Designers> masterMapList =new ArrayList<Designers>((Collection<Designers>) masterMap.values());

				int columns = 2; // 2 col table

				for (int start = 0; start < masterMapList.size(); start += columns) {

					int end = Math.min(start + columns, masterMapList.size());
					List<Designers> sublist = masterMapList.subList(start, end);
					int getAddedCount = 1; 			

					for (Designers designer : sublist) {
						DesignersImages designersImages;

						try {	
							String deviceName = StringPool.BLANK;
							String deviceType = StringPool.BLANK;
							String browserName = StringPool.BLANK;
							String deviceWidth = StringPool.BLANK;

							if(Validator.isNotNull(session.getAttribute("deviceName"))){
								deviceName = session.getAttribute("deviceName").toString();
							}
							if(Validator.isNotNull(session.getAttribute("deviceType"))){
								deviceType = session.getAttribute("deviceType").toString();
							}
							if(Validator.isNotNull(session.getAttribute("browserName"))){
								browserName = session.getAttribute("browserName").toString();
							}
							if(Validator.isNotNull(session.getAttribute("deviceWidth"))){
								deviceWidth = session.getAttribute("deviceWidth").toString();
							}

							designersImages = DesignersImagesLocalServiceUtil
									.getByDesignId(designer.getDesignId());
							Impressions impressions = ImpressionsLocalServiceUtil.addToImpressions(ImpressionTypes.EMAILED_RECOMMENDATIONS.getValue(), 
									Long.toString(designer.getDesignId()), ImpressionTypes.SEND.getValue(),loginUser , 
									Long.toString(themeDisplay.getCompanyId()), 
									PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
									deviceName,deviceType,deviceWidth,browserName, storeId);

							if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressions != null){
								impressions.setStaffId(session.getAttribute("LOGINSTAFF").toString());
								ImpressionsLocalServiceUtil.updateImpressions(impressions);
							}

							if(designer.getSayduck() && map.containsValue(designer)){
								sayDuck = true;
							}
							//New Email Template
							CartsDesigners catDesign = CartsDesignersLocalServiceUtil.findBycartIdDesignId(Long.parseLong(session.getAttribute("CARTID").toString()), designer.getDesignId());
							if(Validator.isNotNull(catDesign)){						
								cartId = Long.toString(catDesign.getCartId());
							}

							if((getAddedCount == 1)){
								buffer.append("<table border=\"0\" cellpadding=\"5\" cellspacing=\"0\" width=\"100%\" style=\"margin-bottom:70px;\"><tr>");

							}
							// start code for made google analytics by shiva 04-03-2015
							String generatedURL=""+designer.getPublic_url()+"?c=cloudtags&utm_source=cloudtags&utm_medium=cloudtags-"+cartId+"&utm_campaign=cloudtags&utm_content="+designer.getBarcode()+"";

							if((generatedURL.contains("rfihub.com"))){
								generatedURL=""+designer.getPublic_url()+"?c=cloudtags%26utm_source=cloudtags%26utm_medium=cloudtags-"+cartId+"%26utm_campaign=cloudtags%26utm_content="+designer.getBarcode()+"";													
							}
							// end code for made google analytics by shiva


							buffer.append("<td align=\"center\" valign=\"top\"><a href=\""+generatedURL+"\"><img src=\""+designersImages.getEntity_image1().replace(PortletProps.get("main.image.dimension"),PortletProps.get("list.page.dimension"))+"\" alt=\"Product Image 1\" width=\"290\" border=\"0\" /></a></td>");

							getAddedCount++;

							if(((getAddedCount-1) == sublist.size())){
								buffer.append("</tr>");
							}

						} catch (NoSuchDesignersImagesException e) {
							_log.error(""+e.getMessage());
						} catch (SystemException e) {
							_log.error(""+e.getMessage());
						}					

					} //end display images

					getAddedCount =1;//display details
					for (Designers designer : sublist) {

						if(getAddedCount == 1){
							buffer.append("<tr>");
						}

						// start code for made google analytics by shiva 04-03-2015
						String generatedURL=""+designer.getPublic_url()+"?c=cloudtags&utm_source=cloudtags&utm_medium=cloudtags-"+cartId+"&utm_campaign=cloudtags&utm_content="+designer.getBarcode()+"";

						if((generatedURL.contains("rfihub.com"))){
							generatedURL=""+designer.getPublic_url()+"?c=cloudtags%26utm_source=cloudtags%26utm_medium=cloudtags-"+cartId+"%26utm_campaign=cloudtags%26utm_content="+designer.getBarcode()+"";													
						}
						// end code for made google analytics by shiva

						buffer.append("<td align=\"center\" valign=\"top\" style=\"color:#000000; font-family:'Kameron', Georgia, 'Times New Roman', Times, serif; font-weight:normal; font-size:16px;\">");


						if(designer.getName().length()>35){
							buffer.append(designer.getName().substring(0, 35)+"...");
						}else{
							buffer.append(designer.getName());
						}


						buffer.append("</td>");


						getAddedCount++;


						if(((getAddedCount-1) == sublist.size())){

							buffer.append("</tr>");
						}

					}

					getAddedCount =1; //display buy button
					for (Designers designer : sublist) {						

						if(getAddedCount == 1){
							buffer.append("<tr>");
						}

						// start code for made google analytics by shiva 04-03-2015
						String generatedURL=""+designer.getPublic_url()+"?c=cloudtags&utm_source=cloudtags&utm_medium=cloudtags-"+cartId+"&utm_campaign=cloudtags&utm_content="+designer.getBarcode()+"";

						if((generatedURL.contains("rfihub.com"))){
							generatedURL=""+designer.getPublic_url()+"?c=cloudtags%26utm_source=cloudtags%26utm_medium=cloudtags-"+cartId+"%26utm_campaign=cloudtags%26utm_content="+designer.getBarcode()+"";													
						}
						// end code for made google analytics by shiva

						buffer.append("<td align=\"center\" valign=\"top\" style=\"color:#000000; font-family:'Kameron', Georgia, 'Times New Roman', Times, serif; font-weight:normal; font-size:25px;\">"
								+"&pound;"+designer.getPrice()+"</td>");

						getAddedCount++;


						if(((getAddedCount-1) == sublist.size())){

							buffer.append("</tr>");
						}

					}
					getAddedCount =1;
					for (Designers designer : sublist) {						

						if(getAddedCount == 1){
							buffer.append("<tr>");
						}

						// start code for made google analytics by shiva 04-03-2015
						String generatedURL=""+designer.getPublic_url()+"?c=cloudtags&utm_source=cloudtags&utm_medium=cloudtags-"+cartId+"&utm_campaign=cloudtags&utm_content="+designer.getBarcode()+"";

						if((generatedURL.contains("rfihub.com"))){
							generatedURL=""+designer.getPublic_url()+"?c=cloudtags%26utm_source=cloudtags%26utm_medium=cloudtags-"+cartId+"%26utm_campaign=cloudtags%26utm_content="+designer.getBarcode()+"";													
						}
						// end code for made google analytics by shiva

						buffer.append("<td align=\"center\" valign=\"top\"><a href=\""+generatedURL+"\"><img src=\"https://dry-bastion-8591.herokuapp.com/Email%20Temp/images/button.gif\" alt=\"Buy Now\" width=\"123\" height=\"33\" border=\"0\" /></a></td>");

						getAddedCount++;


						if(((getAddedCount-1) == sublist.size())){

							buffer.append("</tr></table>");
						}

					}

					getAddedCount =1;
					for (Designers designer : sublist) {
						getAddedCount++;

						if(((getAddedCount-1) == sublist.size())){
							//buffer.append("</table>");
						}
					}

				}

				columns = 3; //3 col table
				if(recommendationMap != null && recommendationMap.size() > 0){
					int col = 1;
					recoBuffer.append("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"> <tr> <td align=\"center\" valign=\"top\"> <img src=\"https://ct-made-liferay-v2.s3.amazonaws.com/images/3-hr.gif\" width=\"600\" height=\"62\" alt=\"--\"/> </td></tr></table>");
					recoBuffer.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"10\"><tr> <td colspan=\"3\" style=\"color:#000000; font-family:'Kameron', Georgia, 'Times New Roman', Times, serif; font-weight:normal; font-size:18px; line-height:24px; padding-left:35px;\">Our Edit:</td></tr>");

					List<Designers> recoList =new ArrayList<Designers>((Collection<Designers>) recommendationMap.values());
					System.out.println("recoList : "+recoList.size());
					for (int start = 0; start < recommendationMap.size(); start += columns) {


						int getAddedCount = 1;
						int end = Math.min(start + columns, recommendationMap.size());
						List<Designers> sublist = recoList.subList(start, end);

						for (Designers designer : sublist) {

							DesignersImages designersImages;
							try {	
								String deviceName = StringPool.BLANK;
								String deviceType = StringPool.BLANK;
								String browserName = StringPool.BLANK;
								String deviceWidth = StringPool.BLANK;

								if(Validator.isNotNull(session.getAttribute("deviceName"))){
									deviceName = session.getAttribute("deviceName").toString();
								}
								if(Validator.isNotNull(session.getAttribute("deviceType"))){
									deviceType = session.getAttribute("deviceType").toString();
								}
								if(Validator.isNotNull(session.getAttribute("browserName"))){
									browserName = session.getAttribute("browserName").toString();
								}
								if(Validator.isNotNull(session.getAttribute("deviceWidth"))){
									deviceWidth = session.getAttribute("deviceWidth").toString();
								}

								designersImages = DesignersImagesLocalServiceUtil
										.getByDesignId(designer.getDesignId());
								Impressions impressions = ImpressionsLocalServiceUtil.addToImpressions(
										"EMAILED_RECOMMENDATIONS", Long.toString(designer.getDesignId()),
										"SEND",loginUser , Long.toString(themeDisplay.getCompanyId()), 
										PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
										deviceName,deviceType,deviceWidth,browserName, storeId);

								if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressions != null){
									impressions.setStaffId(session.getAttribute("LOGINSTAFF").toString());
									ImpressionsLocalServiceUtil.updateImpressions(impressions);
								}
								//New Email Template
								CartsDesigners catDesign = CartsDesignersLocalServiceUtil.findBycartIdDesignId(Long.parseLong(session.getAttribute("CARTID").toString()), designer.getDesignId());
								if(Validator.isNotNull(catDesign)){						
									cartId = Long.toString(catDesign.getCartId());
								}
								if((getAddedCount == 1)){
									recoBuffer.append("<tr><td align=\"center\" valign=\"top\">");

								}

								// start code for made google analytics by shiva 04-03-2015
								String generatedURL=""+designer.getPublic_url()+"?c=cloudtags&utm_source=cloudtags&utm_medium=cloudtags-"+cartId+"&utm_campaign=cloudtags&utm_content="+designer.getBarcode()+"";

								if((generatedURL.contains("rfihub.com"))){
									generatedURL=""+designer.getPublic_url()+"?c=cloudtags%26utm_source=cloudtags%26utm_medium=cloudtags-"+cartId+"%26utm_campaign=cloudtags%26utm_content="+designer.getBarcode()+"";													
								}


								recoBuffer.append("<a href=\""+generatedURL+"\"><img style=\"margin-left:5px; margin-right:5px;\" src=\""+designersImages.getEntity_image1().replace(PortletProps.get("main.image.dimension"),PortletProps.get("list.page.dimension"))+"\" width=\"180\" alt=\"#\" border=\"0\" /></a>");
								getAddedCount++;


								if(((getAddedCount-1) == sublist.size())){									
									recoBuffer.append("</td></tr>");
								}
								col++;

							} catch (NoSuchDesignersImagesException e) {
								_log.error(""+e.getMessage());
							} catch (SystemException e) {
								_log.error(""+e.getMessage());
							}
						}

						getAddedCount =1;
						for (Designers designer : sublist) {
							getAddedCount++;

							if(((getAddedCount-1) == sublist.size())){
								//recoBuffer.append("</tbody></table></div>");
							}
						}

					}
					recoBuffer.append("</table>");
				}


			}
			long storeDevId = CommonUtil.getStoreIdForDevice(session);
			String footerStore = "email.template.footer.";
			if(storeDevId == 0){
				footerStore = footerStore+"0";
			}else{
				try {
					StoreDeviceMap sdm = StoreDeviceMapLocalServiceUtil.getStoreDeviceMap(storeDevId);
					StoreInformationMap sim = StoreInformationMapLocalServiceUtil.getStoreInformationMap(sdm.getStoreId());
					footerStore = footerStore+sim.getUuid();
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}

			}
			String footerVar = PortletProps.get("email.template.footer.variable");
			System.out.println("Footer var :"+footerVar);
			String footerTemplate = PortletProps.get(footerStore);
			System.out.println("footerStore : "+footerStore);

			//emailTemplate = emailTemplate.replace(data, buffer.toString());
			String cartListPlaceHolder = PortletProps.get("email.template.cart");
			String recoPlaceHolder = PortletProps.get("email.template.reco");


			//Get unsubscribe link and replace in email template
			String unsubLink = PortletProps.get(Constants.UNSUB_PROPERTY);
			emailTemplate =  emailTemplate.replace(Constants.UNSUBSCRIBE_PH, unsubLink);

			emailTemplate = emailTemplate.replace(cartListPlaceHolder, buffer.toString());
			emailTemplate = emailTemplate.replace(recoPlaceHolder, recoBuffer.toString());

			if(footerVar != null && footerTemplate != null)
				emailTemplate = emailTemplate.replace(footerVar, footerTemplate);

			//System.out.println(buffer.toString());
			//System.out.println("-------------------------------------------------------------------------------------------------------------");
			//System.out.println(recoBuffer.toString());
			/*if(cartList.size()!=0){
					//MailUtil.sendEmail(emailAddress, emailTemplate);
					long storeDevId = CommonUtil.getStoreIdForDevice(session);
					MailUtil.sendEmail(emailAddress, emailTemplate, Long.toString(storeDevId));
				}*/
			
			long cartIdentifier = 0;
			
			if(Validator.isNotNull(session.getAttribute("CARTID")))
			{
				cartIdentifier = (long)session.getAttribute("CARTID");
			}else if(cartId != null && !cartId.isEmpty()){
				cartIdentifier = Long.parseLong(cartId);
			}
			String staffList = CommonUtil.getStaffList(session);
			
			Date sendMailDate = null;
			try {
				String deviceName = StringPool.BLANK;
				String deviceType = StringPool.BLANK;
				String browserName = StringPool.BLANK;
				String deviceWidth = StringPool.BLANK;

				String firstEmail = StringPool.BLANK;
				/*Map<String, String> salesAssociateTags = new HashMap<String, String>() ;
				if(Validator.isNotNull(session.getAttribute(Constants.SALES_ASSOCIATE_LIST))){
					salesAssociateTags = (HashMap<String, String>) session.getAttribute(Constants.SALES_ASSOCIATE_LIST);				

				}*/

				if(Validator.isNotNull(session.getAttribute("deviceName"))){
					deviceName = session.getAttribute("deviceName").toString();
				}
				if(Validator.isNotNull(session.getAttribute("deviceType"))){
					deviceType = session.getAttribute("deviceType").toString();
				}
				if(Validator.isNotNull(session.getAttribute("browserName"))){
					browserName = session.getAttribute("browserName").toString();
				}
				if(Validator.isNotNull(session.getAttribute("deviceWidth"))){
					deviceWidth = session.getAttribute("deviceWidth").toString();
				}

				if(Validator.isNotNull(session.getAttribute("FIRST-EMAIL"))){
					firstEmail = session.getAttribute("FIRST-EMAIL").toString();
				}else{
					session.setAttribute("FIRST-EMAIL", emailAddress);
					firstEmail = emailAddress;
				}
				// Match session email and current email id condition

				if (emailAddress.equalsIgnoreCase(firstEmail)){
					_log.info("Email to owner (firstemail and current email same: "+ emailAddress);
					Impressions impressions = ImpressionsLocalServiceUtil.addToImpressions(ImpressionTypes.EMAIL_NOTIFICATION.getValue(), emailAddress, ImpressionTypes.SEND_MAIL.getValue(),loginUser,
							Long.toString(themeDisplay.getCompanyId()),
							PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
							deviceName,deviceType,deviceWidth,browserName,storeId);

					if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressions != null){
						impressions.setStaffId(session.getAttribute("LOGINSTAFF").toString());
						ImpressionsLocalServiceUtil.updateImpressions(impressions);
					}
					sendMailDate =  impressions.getCreateDate();

					if(cartList != null && cartList.size()!=0){
						//MailUtil.sendEmail(emailAddress, emailTemplate);

						//multistore category "Made_storename format
						StringBuilder multistoreCategory = new StringBuilder(PortletProps.get("sendgrid.multistore.category"));								
						multistoreCategory.append("_"+CommonUtil.getStoreName(storeDevId));
						_log.info("multistoreCategory : "+multistoreCategory.toString());
						//MailUtil.sendEmail(emailAddress, emailTemplate, sendMailDate,Long.toString(storeDevId));
						//MailUtil.sendEmail(emailAddress, emailTemplate, sendMailDate, multistoreCategory.toString());

						String timeStamp =  CommonUtil.getSubjectTimeStamp(sendMailDate, emailAddress, session);
						System.out.println("Time Stamp : "+timeStamp);

						//MailUtil.sendEmail(emailAddress, emailTemplate, timeStamp, multistoreCategory.toString(), salesAssociateTags);
						
						MailUtil.sendEmail(emailAddress, emailTemplate, timeStamp, multistoreCategory.toString(),
								cartIdentifier, userId, staffList);
					}
				}else{
					_log.info("Inside else condition send mail to both email id.. ");
					/*send to friends email*/



					Impressions impressionsFriends = ImpressionsLocalServiceUtil.addToImpressions(ImpressionTypes.EMAIL_NOTIFICATION_FRIEND.getValue(), 
							emailAddress, ImpressionTypes.SEND_MAIL.getValue(),loginUser, 
							Long.toString(themeDisplay.getCompanyId()),
							PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
							deviceName,deviceType,deviceWidth,browserName,storeId);

					sendMailDate = impressionsFriends.getCreateDate();
					if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressionsFriends != null){
						impressionsFriends.setStaffId(session.getAttribute("LOGINSTAFF").toString());
						ImpressionsLocalServiceUtil.updateImpressions(impressionsFriends);
					}

					HashMap<Long, Designers> sharedCart=(HashMap<Long, Designers>) session.getAttribute("LIFERAY_SHARED_CARTLIST");
					for(Map.Entry<Long, Designers> sharedProduct: sharedCart.entrySet()){
						System.out.println("This is cart list:  "+sharedProduct.getKey()+ " / " +sharedProduct.getValue().getDesignId());
						Impressions impressionShared =ImpressionsLocalServiceUtil.addToImpressions(ImpressionTypes.SHARED_PRODUCTS.getValue(), Long.toString(sharedProduct.getKey()), emailAddress, loginUser, Long.toString(themeDisplay.getCompanyId()), PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(), deviceName, deviceType, deviceWidth, browserName, storeId);
						if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressionShared != null){					
							impressionShared.setStaffId(session.getAttribute("LOGINSTAFF").toString());							
						}
						ImpressionsLocalServiceUtil.updateImpressions(impressionShared);
					}


					if(cartList != null && cartList.size()!=0){

						storeDevId = CommonUtil.getStoreIdForDevice(session);
						//multistore category "asi_storename_storedevId format
						StringBuilder multistoreCategory = new StringBuilder(PortletProps.get("sendgrid.multistore.category"));
						//multistoreCategory.append("_"+CommonUtil.getStoreName(storeDevId)+"_"+storeDevId);
						multistoreCategory.append("_"+CommonUtil.getStoreName(storeDevId));
						_log.info("multistoreCategory : "+multistoreCategory.toString());
						//MailUtil.sendEmail(emailAddress, emailTemplate, storeDevId, sendMailDate);
						//MailUtil.sendEmail(emailAddress, emailTemplate, multistoreCategory.toString(), sendMailDate);
						String timeStamp =  CommonUtil.getSubjectTimeStamp(sendMailDate, emailAddress, session);
						System.out.println("Time Stamp : "+timeStamp);
						//MailUtil.sendEmail(emailAddress, emailTemplate, timeStamp, multistoreCategory.toString(), salesAssociateTags);

						MailUtil.sendEmail(emailAddress, emailTemplate, timeStamp, multistoreCategory.toString(),
								cartIdentifier, userId, staffList);
						
					}

					/*Also send to first email*/

					Impressions impressions = ImpressionsLocalServiceUtil.addToImpressions(ImpressionTypes.EMAIL_NOTIFICATION.getValue(), 
							firstEmail, ImpressionTypes.SEND_MAIL.getValue(),loginUser, 
							Long.toString(themeDisplay.getCompanyId()),
							PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
							deviceName,deviceType,deviceWidth,browserName,storeId);

					sendMailDate = impressions.getCreateDate();
					if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressions != null){
						impressions.setStaffId(session.getAttribute("LOGINSTAFF").toString());
						ImpressionsLocalServiceUtil.updateImpressions(impressions);
					}

					if(cartList != null && cartList.size()!=0){

						storeDevId = CommonUtil.getStoreIdForDevice(session);
						//multistore category "asi_storename_storedevId format
						StringBuilder multistoreCategory = new StringBuilder(PortletProps.get("sendgrid.multistore.category"));
						//multistoreCategory.append("_"+CommonUtil.getStoreName(storeDevId)+"_"+storeDevId);
						multistoreCategory.append("_"+CommonUtil.getStoreName(storeDevId));
						_log.info("multistoreCategory : "+multistoreCategory.toString());
						//MailUtil.sendEmail(emailAddress, emailTemplate, storeDevId, sendMailDate);
						//MailUtil.sendEmail(emailAddress, emailTemplate, multistoreCategory.toString(), sendMailDate);
						String timeStamp =  CommonUtil.getSubjectTimeStamp(sendMailDate, firstEmail, session);
						System.out.println("Time Stamp : "+timeStamp);
						//MailUtil.sendEmail(firstEmail, emailTemplate, timeStamp, multistoreCategory.toString(), salesAssociateTags);
						MailUtil.sendEmail(emailAddress, emailTemplate, timeStamp, multistoreCategory.toString(),
								cartIdentifier, userId, staffList);
					}
				}
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			//updateUser(emailAddress,session,themeDisplay.getCompanyId());
		} else if (cmd.equalsIgnoreCase("staffUsers")) {

			//long staffuser = ParamUtil.getLong(uploadPortletRequest,"staffusers");

			if (Validator.isNotNull(session.getAttribute(
					"LIFERAY_SHARED_CARTDESIGNERS"))) {
				HashMap<Long, CartsDesigners> cartDesignersList = (HashMap<Long, CartsDesigners>) session
						.getAttribute("LIFERAY_SHARED_CARTDESIGNERS"
								);
				Iterator it = cartDesignersList.entrySet().iterator();

				while (it.hasNext()) {

					Entry<Long, CartsDesigners> entry = (Entry<Long, CartsDesigners>) it
							.next();
					CartsDesigners cartsDesigners = entry.getValue();
					//cartsDesigners.setStaffUserId(staffuser);

					try {
						cartsDesigners = CartsDesignersLocalServiceUtil
								.updateCartsDesigners(cartsDesigners);
					} catch (SystemException e) {
						// TODO Auto-generated catch block
						_log.error(""+e.getMessage());
					}

				}
			}
		}else if(cmd.equalsIgnoreCase("staffEnd")){
			_log.info("Style Advisor cleared session  ");
			session.removeAttribute("LIFERAY_SHARED_CARTLIST");
			session.removeAttribute("LIFERAY_SHARED_CARTDESIGNERS");
			session.invalidate();
		}
		else if(cmd.equalsIgnoreCase("staffEndfromdocked")){

			_log.info("staffEndfromdocked cleared session  ");
			try {
				String deviceName = StringPool.BLANK;
				String deviceType = StringPool.BLANK;
				String browserName = StringPool.BLANK;
				String deviceWidth = StringPool.BLANK;

				String fromType = StringPool.BLANK;

				if(Validator.isNotNull(session.getAttribute("deviceName"))){
					deviceName = session.getAttribute("deviceName").toString();
				}
				if(Validator.isNotNull(session.getAttribute("deviceType"))){
					deviceType = session.getAttribute("deviceType").toString();
				}
				if(Validator.isNotNull(session.getAttribute("browserName"))){
					browserName = session.getAttribute("browserName").toString();
				}
				if(Validator.isNotNull(session.getAttribute("deviceWidth"))){
					deviceWidth = session.getAttribute("deviceWidth").toString();
				}

				fromType = uploadPortletRequest.getParameter("fromType");
				Impressions impressions = ImpressionsLocalServiceUtil.addToImpressions(fromType, loginUser, fromType,loginUser , 
						Long.toString(themeDisplay.getCompanyId()), 
						PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
						deviceName,deviceType,deviceWidth,browserName, storeId);

				if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressions != null){
					impressions.setStaffId(session.getAttribute("LOGINSTAFF").toString());
					ImpressionsLocalServiceUtil.updateImpressions(impressions);
				}
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.removeAttribute("LIFERAY_SHARED_CARTLIST");
			session.removeAttribute("LIFERAY_SHARED_CARTDESIGNERS");
			session.invalidate();
		}
		else if (cmd.equalsIgnoreCase("devicesession")) {

			//long staffuser = ParamUtil.getLong(uploadPortletRequest,"staffusers");

			String deviceName = ParamUtil.getString(uploadPortletRequest, "deviceName");
			String deviceType = ParamUtil.getString(uploadPortletRequest, "deviceType");
			String browserName = ParamUtil.getString(uploadPortletRequest, "browserName");
			String deviceWidth = ParamUtil.getString(uploadPortletRequest, "screenWidth");

			_log.info("deviceName>>>>>>>>>>"+deviceName);
			_log.info("deviceType>>>>>>>>>>"+deviceType);
			_log.info("browserName>>>>>>>>>>"+browserName);
			_log.info("deviceWidth>>>>>>>>>>"+deviceWidth);
			session.setAttribute("deviceName", deviceName);
			session.setAttribute("deviceType", deviceType);
			session.setAttribute("browserName", browserName);
			session.setAttribute("deviceWidth", deviceWidth);
		}else if (cmd.equalsIgnoreCase("imageImpression")) {

			//long staffuser = ParamUtil.getLong(uploadPortletRequest,"staffusers");

			String imageId = ParamUtil.getString(uploadPortletRequest, "imageId");
			try {String deviceName = StringPool.BLANK;
			String deviceType = StringPool.BLANK;
			String browserName = StringPool.BLANK;
			String deviceWidth = StringPool.BLANK;

			if(Validator.isNotNull(session.getAttribute("deviceName"))){
				deviceName = session.getAttribute("deviceName").toString();
			}
			if(Validator.isNotNull(session.getAttribute("deviceType"))){
				deviceType = session.getAttribute("deviceType").toString();
			}
			if(Validator.isNotNull(session.getAttribute("browserName"))){
				browserName = session.getAttribute("browserName").toString();
			}
			if(Validator.isNotNull(session.getAttribute("deviceWidth"))){
				deviceWidth = session.getAttribute("deviceWidth").toString();
			}
			Impressions impressions = ImpressionsLocalServiceUtil.addToImpressions(ImpressionTypes.CAROUSEL.getValue(), imageId, ImpressionTypes.IMAGE.getValue(),loginUser , 
					Long.toString(themeDisplay.getCompanyId()),
					PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
					deviceName,deviceType,deviceWidth,browserName, storeId);

			if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressions != null){
				impressions.setStaffId(session.getAttribute("LOGINSTAFF").toString());
				ImpressionsLocalServiceUtil.updateImpressions(impressions);
			}
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}else if (cmd.equalsIgnoreCase("generalImpress")) {

			//long staffuser = ParamUtil.getLong(uploadPortletRequest,"staffusers");
			String impType = ParamUtil.getString(uploadPortletRequest, "impType");
			String impId = ParamUtil.getString(uploadPortletRequest, "impId");
			String impAction = ParamUtil.getString(uploadPortletRequest, "impAction");
			try {String deviceName = StringPool.BLANK;
			String deviceType = StringPool.BLANK;
			String browserName = StringPool.BLANK;
			String deviceWidth = StringPool.BLANK;

			if(Validator.isNotNull(session.getAttribute("deviceName"))){
				deviceName = session.getAttribute("deviceName").toString();
			}
			if(Validator.isNotNull(session.getAttribute("deviceType"))){
				deviceType = session.getAttribute("deviceType").toString();
			}
			if(Validator.isNotNull(session.getAttribute("browserName"))){
				browserName = session.getAttribute("browserName").toString();
			}
			if(Validator.isNotNull(session.getAttribute("deviceWidth"))){
				deviceWidth = session.getAttribute("deviceWidth").toString();
			}
			if(Validator.isNotNull(impType) && Validator.isNotNull(impAction)){
				Impressions impressions = ImpressionsLocalServiceUtil.addToImpressions(impType, impId, impAction,loginUser , 
						Long.toString(themeDisplay.getCompanyId()),
						PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
						deviceName,deviceType,deviceWidth,browserName, storeId);

				if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressions != null){
					impressions.setStaffId(session.getAttribute("LOGINSTAFF").toString());
					ImpressionsLocalServiceUtil.updateImpressions(impressions);
				}
			}
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
		else if(cmd.equalsIgnoreCase("undocked")){
			_log.info("undocked   ");
			if(Validator.isNotNull(session.getAttribute("CLEARSESSION-LAST"))){
				session.removeAttribute("LIFERAY_SHARED_CARTLIST");
				session.removeAttribute("LIFERAY_SHARED_CARTDESIGNERS");
				session.removeAttribute("LOGINSTAFF");
				session.removeAttribute("CARTID");
				session.removeAttribute("LOGIN-USER");			
				session.removeAttribute("FIRST-EMAIL");
				session.removeAttribute("CLEARSESSION-LAST");

			}
			if(Validator.isNull(session.getAttribute("LOGIN-USER"))){
				UUID idOne = UUID.randomUUID();
				session.setAttribute("LOGIN-USER", idOne.toString());
				/*try {String deviceName = StringPool.BLANK;
					String deviceType = StringPool.BLANK;
					String browserName = StringPool.BLANK;
					String deviceWidth = StringPool.BLANK;

					if(Validator.isNotNull(session.getAttribute("deviceName"))){
						deviceName = session.getAttribute("deviceName").toString();
					}
					if(Validator.isNotNull(session.getAttribute("deviceType"))){
						deviceType = session.getAttribute("deviceType").toString();
					}
					if(Validator.isNotNull(session.getAttribute("browserName"))){
						browserName = session.getAttribute("browserName").toString();
					}
					if(Validator.isNotNull(session.getAttribute("deviceWidth"))){
						deviceWidth = session.getAttribute("deviceWidth").toString();
					}
					Impressions impressions = ImpressionsLocalServiceUtil.addToImpressions("USER", Long.toString(themeDisplay.getUserId()),
							"LOGIN",idOne.toString() , Long.toString(themeDisplay.getCompanyId()),
							PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
							deviceName,deviceType,deviceWidth,browserName, storeId);

					if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressions != null){
						impressions.setStaffId(session.getAttribute("LOGINSTAFF").toString());
						ImpressionsLocalServiceUtil.updateImpressions(impressions);
					}
					} catch (SystemException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
			}
			/*loginUser = session.getAttribute("LOGIN-USER").toString();
				try {
					String deviceName = StringPool.BLANK;
					String deviceType = StringPool.BLANK;
					String browserName = StringPool.BLANK;
					String deviceWidth = StringPool.BLANK;

					if(Validator.isNotNull(session.getAttribute("deviceName"))){
						deviceName = session.getAttribute("deviceName").toString();
					}
					if(Validator.isNotNull(session.getAttribute("deviceType"))){
						deviceType = session.getAttribute("deviceType").toString();
					}
					if(Validator.isNotNull(session.getAttribute("browserName"))){
						browserName = session.getAttribute("browserName").toString();
					}
					if(Validator.isNotNull(session.getAttribute("deviceWidth"))){
						deviceWidth = session.getAttribute("deviceWidth").toString();
					}

					Impressions impressions = ImpressionsLocalServiceUtil.addToImpressions("UNDOCKED", loginUser, "UNDOCKED",
							loginUser , Long.toString(themeDisplay.getCompanyId()), 
							PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
							deviceName,deviceType,deviceWidth,browserName, storeId);

					if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressions != null){
						impressions.setStaffId(session.getAttribute("LOGINSTAFF").toString());
						ImpressionsLocalServiceUtil.updateImpressions(impressions);
					}
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/


		}else if (cmd.equals("remove")) {

			_log.info("Products was removed");

			long designId = ParamUtil.getLong(uploadPortletRequest, "designId");

			HashMap<Long, Designers> cartList = null;
			HashMap<Long, CartsDesigners> cartDesigners;

			if (Validator.isNotNull(session
					.getAttribute("LIFERAY_SHARED_CARTLIST"))) {

				cartList = (HashMap<Long, Designers>) session
						.getAttribute("LIFERAY_SHARED_CARTLIST");
				if (cartList.containsKey(designId))
					cartList.remove(designId);
				cartDesigners = (HashMap<Long, CartsDesigners>) session
						.getAttribute("LIFERAY_SHARED_CARTDESIGNERS");

				if(Validator.isNotNull(session.getAttribute("LOGIN-USER"))){
					System.out.println("LOGIN-USER inside recommendations if");
					loginUser = session.getAttribute("LOGIN-USER").toString();										
				}
				if (cartDesigners.containsKey(designId)) {

					CartsDesigners designers = cartDesigners.get(designId);
					designers.setKept(false);
					try {
						CartsDesignersLocalServiceUtil
						.updateCartsDesigners(designers);
						String deviceName = StringPool.BLANK;
						String deviceType = StringPool.BLANK;
						String browserName = StringPool.BLANK;
						String deviceWidth = StringPool.BLANK;

						if(Validator.isNotNull(session.getAttribute("deviceName"))){
							deviceName = session.getAttribute("deviceName").toString();
						}
						if(Validator.isNotNull(session.getAttribute("deviceType"))){
							deviceType = session.getAttribute("deviceType").toString();
						}
						if(Validator.isNotNull(session.getAttribute("browserName"))){
							browserName = session.getAttribute("browserName").toString();
						}
						if(Validator.isNotNull(session.getAttribute("deviceWidth"))){
							deviceWidth = session.getAttribute("deviceWidth").toString();
						}
						Impressions impressions = 	ImpressionsLocalServiceUtil.addToImpressions(ImpressionTypes.CART_PRODUCT.getValue(), 
								Long.toString(designers.getCartDesignerId()), ImpressionTypes.REMOVED.getValue(), loginUser , 
								Long.toString(themeDisplay.getCompanyId()), 
								PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
								deviceName,deviceType,deviceWidth,browserName, storeId);

						if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressions != null){
							impressions.setStaffId(session.getAttribute("LOGINSTAFF").toString());
							ImpressionsLocalServiceUtil.updateImpressions(impressions);
						}
					} catch (SystemException e) {
						e.printStackTrace();
					}

					cartDesigners.remove(designId);

					session.setAttribute("LIFERAY_SHARED_CARTDESIGNERS",
							cartDesigners);

				}

				session.setAttribute("LIFERAY_SHARED_CARTLIST", cartList);
				@SuppressWarnings("unchecked")
				HashMap<Long, Designers> list = (HashMap<Long, Designers>) session
				.getAttribute("LIFERAY_SHARED_CARTLIST");
				System.out.println("listlistlistlistlist>>>>"+list.size());

			}
		}else if(cmd.equals("getproduct")){
			long designId = ParamUtil.getLong(uploadPortletRequest, "designId");
			String viewedFrom = ParamUtil.getString(uploadPortletRequest, "viewFrom");
			if(Validator.isNotNull(viewedFrom)){
				viewedFrom = "_"+viewedFrom;
			}

			String prodDetailsPopup = getProductDetailsPopup(designId, resourceRequest,viewedFrom);

			/*Designers designers = null;
			DesignersImages designersImage = null;
			try {
				designers  = DesignersLocalServiceUtil.getDesigners(designId);
				designersImage = DesignersImagesLocalServiceUtil.getByDesignId(designId);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			StringBuffer buffer = new StringBuffer();
			buffer.append("<div class=\"product_slider_main\">");
			buffer.append("<div class=\"product_slider_heading_main\">");
			buffer.append(" <div class=\"product_slider_heading_left\">FONTEYN</div>");
			buffer.append("<div class=\"product_slider_heading_left_content\">Media Unit, Walnut and Red</div>");
			buffer.append("<div class=\"product_slider_heading_right\">£549</div>");
			buffer.append(" </div>");
			buffer.append(" <!--product_slider_heading_main-->");
			buffer.append("  <div class=\"product_slider\">");
			buffer.append("   <div class=\"connected-carousels\">");
			buffer.append("    <div class=\"stage\">");
			buffer.append("       <div data-jcarousel=\"true\" class=\"carousel carousel-stage\">");
			buffer.append("<ul style=\"left: -40px; top: 0px;\">");
			if(Validator.isNotNull(designersImage.getEntity_image1())) { 

				buffer.append("<li><div class=\"product-slider-image\" style=\"background:url("+designersImage.getEntity_image1()+") no-repeat; background-size:cover;\"></div></li>");  

			}if(Validator.isNotNull(designersImage.getEntity_image2())) { 
				buffer.append("<li><div class=\"product-slider-image\" style=\"background:url("+designersImage.getEntity_image2()+") no-repeat; background-size:cover;\"></div></li>");  
			}if(Validator.isNotNull(designersImage.getEntity_image3())) { 
				buffer.append("<li><div class=\"product-slider-image\" style=\"background:url("+designersImage.getEntity_image3()+") no-repeat; background-size:cover;\"></div></li>");  
			}if(Validator.isNotNull(designersImage.getEntity_image4())) { 
				buffer.append(" <li><div class=\"product-slider-image\" style=\"background:url("+designersImage.getEntity_image4()+") no-repeat; background-size:cover;\"></div></li>");  
			}if(Validator.isNotNull(designersImage.getEntity_image5())) { 
				buffer.append(" <li><div class=\"product-slider-image\" style=\"background:url("+designersImage.getEntity_image5()+") no-repeat; background-size:cover;\"></div></li>");  
			}if(Validator.isNotNull(designersImage.getEntity_image6())) { 
				buffer.append("<li><div class=\"product-slider-image\" style=\"background:url("+designersImage.getEntity_image6()+") no-repeat; background-size:cover;\"></div></li>");  
			}if(Validator.isNotNull(designersImage.getEntity_image7())) { 
				buffer.append(" <li><div class=\"product-slider-image\" style=\"background:url("+designersImage.getEntity_image7()+") no-repeat; background-size:cover;\"></div></li>");  
			}if(Validator.isNotNull(designersImage.getEntity_image8())) { 
				buffer.append(" <li><div class=\"product-slider-image\" style=\"background:url("+designersImage.getEntity_image8()+") no-repeat; background-size:cover;\"></div></li>");  
			}if(Validator.isNotNull(designersImage.getEntity_image9())) { 
				buffer.append(" <li><div class=\"product-slider-image\" style=\"background:url("+designersImage.getEntity_image9()+") no-repeat; background-size:cover;\"></div></li>");  
			}if(Validator.isNotNull(designersImage.getEntity_image10())) { 
				buffer.append("<li><div class=\"product-slider-image\" style=\"background:url("+designersImage.getEntity_image10()+") no-repeat; background-size:cover;\"></div></li>");  
			}
			buffer.append("</ul>");  
			buffer.append(" </div>");  

			buffer.append(" </div>");  

			buffer.append(" <div class=\"navigation\">");  

			buffer.append("<div data-jcarousel=\"true\" class=\"carousel carousel-navigation\">");  
			buffer.append("<ul style=\"left: -40px; top: 0px;\">");

			if(Validator.isNotNull(designersImage.getEntity_image1())) { 
				buffer.append(" <li class=\"active\" data-jcarouselcontrol=\"true\"><div id=\"im1\" class=\"slider-square\" style=\"background:url("+designersImage.getEntity_image1()+") no-repeat; background-size:cover;\"></div></li>");  
			}if(Validator.isNotNull(designersImage.getEntity_image2())) { 
				buffer.append(" <li data-jcarouselcontrol=\"true\"><div id=\"im2\" class=\"slider-square\" style=\"background:url("+designersImage.getEntity_image2()+") no-repeat; background-size:cover;\"></div></li>");  
			}if(Validator.isNotNull(designersImage.getEntity_image3())) { 
				buffer.append(" <li data-jcarouselcontrol=\"true\"><div id=\"im3\" class=\"slider-square\" style=\"background:url("+designersImage.getEntity_image3()+") no-repeat; background-size:cover;\"></div></li>");  
			}if(Validator.isNotNull(designersImage.getEntity_image4())) { 
				buffer.append(" <li data-jcarouselcontrol=\"true\"><div id=\"im4\" class=\"slider-square\" style=\"background:url("+designersImage.getEntity_image4()+") no-repeat; background-size:cover;\"></div></li>");  
			}if(Validator.isNotNull(designersImage.getEntity_image5())) { 
				buffer.append("  <li data-jcarouselcontrol=\"true\"><div id=\"im5\" class=\"slider-square\" style=\"background:url("+designersImage.getEntity_image5()+") no-repeat; background-size:cover;\"></div></li>");  
			}if(Validator.isNotNull(designersImage.getEntity_image6())) { 
				buffer.append(" <li data-jcarouselcontrol=\"true\"><div id=\"im6\" class=\"slider-square\" style=\"background:url("+designersImage.getEntity_image6()+") no-repeat; background-size:cover;\"></div></li>");  
			}if(Validator.isNotNull(designersImage.getEntity_image7())) { 
				buffer.append(" <li data-jcarouselcontrol=\"true\"><div id=\"im7\" class=\"slider-square\" style=\"background:url("+designersImage.getEntity_image7()+") no-repeat; background-size:cover;\"></div></li>");  
			}if(Validator.isNotNull(designersImage.getEntity_image8())) { 
				buffer.append(" <li data-jcarouselcontrol=\"true\"><div id=\"im8\" class=\"slider-square\" style=\"background:url("+designersImage.getEntity_image8()+") no-repeat; background-size:cover;\"></div></li>");  
			}if(Validator.isNotNull(designersImage.getEntity_image9())) { 
				buffer.append(" <li data-jcarouselcontrol=\"true\"><div id=\"im9\" class=\"slider-square\" style=\"background:url("+designersImage.getEntity_image9()+") no-repeat; background-size:cover;\"></div></li>");  
			}if(Validator.isNotNull(designersImage.getEntity_image10())) { 
				buffer.append(" <li data-jcarouselcontrol=\"true\"><div id=\"im10\" class=\"slider-square\" style=\"background:url("+designersImage.getEntity_image10()+") no-repeat; background-size:cover;\"></div></li>");  
			}
			buffer.append("</ul>"); 
			buffer.append("</div>"); 
			buffer.append("</div>"); 
			buffer.append("</div>"); 


			buffer.append("<div  data-jcarouselcontrol=\"true\" id=\"left\" class=\"prev-stage inactive\"> "); 
			buffer.append("<img src=\""+resourceRequest.getContextPath() +"/images/arrow-left.png\" height=\"40\" width=\"40\">");  
			buffer.append(" </div> "); 

			buffer.append("  <div data-jcarouselcontrol=\"true\" id=\"right\" class=\"next-stage\"> "); 
			buffer.append(" <img src=\""+resourceRequest.getContextPath() +"/images/arrow-right.png\" height=\"40\" width=\"40\"> "); 
			buffer.append("</div>"); 



			buffer.append("</div><!--product_slider-->"); 



			buffer.append(" </div><!--product_slider_main-->"); 


			buffer.append("<div class=\"product_description_block\">"); 

			buffer.append("<div id=\"TabbedPanels1\" class=\"TabbedPanels\">"); 
			buffer.append("<ul class=\"TabbedPanelsTabGroup\">"); 
			buffer.append(" <li class=\"TabbedPanelsTab TabbedPanelsTabSelected\" tabindex=\"0\" >Details</li>"); 
			buffer.append("  <li class=\"TabbedPanelsTab\" tabindex=\"0\">Collection</li>"); 
			buffer.append("  <li class=\"TabbedPanelsTab\" tabindex=\"0\">Color</li>"); 
			buffer.append("</ul>"); 
			buffer.append(" <div class=\"TabbedPanelsContentGroup\">"); 

			buffer.append("<div class=\"TabbedPanelsContent TabbedPanelsContentVisible\">"); 

			buffer.append("<div class=\"details_content_block\" style=\"text-align:left; padding-left:0;\">"); 

			buffer.append(" <div class=\"details_content_heading\">Delivery and returns</div>"); 
			buffer.append(" <div class=\"details_content\">"); 
			buffer.append(designers.getLeft_description());
			buffer.append("</div>"); 

			buffer.append("<div class=\"details_content\">"); 
			buffer.append("<div id=\"countdown1\">2 days,</div> - <div id=\"countdown2\">12:01</div>"); 
			buffer.append(" </div>"); 

			buffer.append("</div><!--details_content1-->"); 


			buffer.append("<div class=\"details_content_block\" style=\"text-align:right; padding-right:0;\">"); 

			buffer.append("<div class=\"details_content_heading\">Dimensions</div>"); 
			buffer.append(" <div class=\"details_content\">"); 
			buffer.append(designers.getRight_description()); 

			buffer.append(" </div>"); 

			buffer.append("</div><!--details_content2-->"); 

			buffer.append(" </div><!--Details_block-->"); 



			buffer.append("<div align=\"center\" class=\"TabbedPanelsContent\" style=\"padding:10% 0% 5% 0%;display:none;\">"); 

			try{
				List<Recommendations> listRecomm = RecommendationsLocalServiceUtil.getByDesigner1(3, designers.getBarcode(), designers.getCompanyId());
				//List<Designers> itemsByColor = DesignersLocalServiceUtil.getByCompanyId(themeDisplay.getCompanyId())
				int count =0;
				for(Recommendations recommendations : listRecomm) {
					Designers designers2 = DesignersLocalServiceUtil.getByCompanyId(recommendations.getCompanyId(), recommendations.getDesigner2());
					if(designers2.getDesignId() == designId ) continue;
					//if(object.getColors().equalsIgnoreCase(designers.getColors())){
					count ++;
					if(count>6) break;

					DesignersImages designersImages = DesignersImagesLocalServiceUtil.getByDesignId(designers2.getDesignId());
					String URL = "/designers?designId=";

					URL = URL + designers2.getDesignId();

					buffer.append("<div id=\"collection1\" onclick='clicked(\""+URL.toString()+" \")' align=\"center\" class=\"collection_image\" style=\"background:url("+designersImages.getEntity_image1()+") no-repeat; background-size:contain; background-position:50% 0;\"></div>"); 

					//}
				} 

			} catch(Exception e){}


			buffer.append(" </div><!--Collection_block-->"); 


			buffer.append("<div align=\"center\" class=\"TabbedPanelsContent\" style=\"padding:10% 0% 5% 0%;display:none;\">"); 

			try{
				List<Recommendations> listRecomm = RecommendationsLocalServiceUtil.getByDesigner1(4, designers.getBarcode(), designers.getCompanyId());
				//List<Designers> itemsByColor = DesignersLocalServiceUtil.getByCompanyId(themeDisplay.getCompanyId())
				int count =0;
				for(Recommendations recommendations : listRecomm) {
					Designers designers3 = DesignersLocalServiceUtil.getByCompanyId(recommendations.getCompanyId(), recommendations.getDesigner2());
					if(designers3.getDesignId() == designId ) continue;
					//if(object.getColors().equalsIgnoreCase(designers.getColors())){
					count ++;
					if(count>6) break;

					DesignersImages designersImages = DesignersImagesLocalServiceUtil.getByDesignId(designers3.getDesignId());
					String URL = "/designers?designId=";

					URL = URL + designers3.getDesignId();

					buffer.append("<div class=\"color_image\" onclick='clicked(\""+URL.toString() +"\")' style=\"background:url("+recommendations.getColor_image()+" ) no-repeat; background-size:cover;border:2px solid #ccc;\"></div>"); 

					//}
				} 

			} catch(Exception e){}


			buffer.append("</div><!--Color_Block-->"); 

			buffer.append(" </div>"); 
			buffer.append(" </div>"); 

			buffer.append("</div><!--product_description_block-->"); 


			StringBuilder sht = new StringBuilder();

			// sht.append("<div class=\"product_slider_main\"> <div class=\"product_slider_heading_main\"> <div class=\"product_slider_heading_left\">FONTEYN</div><div class=\"product_slider_heading_left_content\">Media Unit, Walnut and Red</div><div class=\"product_slider_heading_right\">£549</div></div><div class=\"product_slider\"> <div class=\"connected-carousels\"> <div class=\"stage\"> <div data-jcarousel=\"true\" class=\"carousel carousel-stage\"> <ul style=\"left: -40px; top: 0px;\"> <li> <div class=\"product-slider-image\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/3/600x400/fonteyn_red_walnut_media_unit_lb1.jpg) no-repeat; background-size:cover;\"></div></li><li> <div class=\"product-slider-image\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/3/600x400/fonteyn_red_walnut_media_unit_lb2_1.jpg) no-repeat; background-size:cover;\"></div></li><li> <div class=\"product-slider-image\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/3/600x400/fonteyn_red_walnut_media_unit_lb3.jpg) no-repeat; background-size:cover;\"></div></li><li> <div class=\"product-slider-image\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/3/600x400/fonteyn_red_walnut_media_unit_lb4.jpg) no-repeat; background-size:cover;\"></div></li><li> <div class=\"product-slider-image\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/3/600x400/fonteyn_red_walnut_media_unit_lb5.jpg) no-repeat; background-size:cover;\"></div></li><li> <div class=\"product-slider-image\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/3/600x400/fonteyn_red_walnut_media_unit_lb6.jpg) no-repeat; background-size:cover;\"></div></li><li> <div class=\"product-slider-image\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/3/600x400/fonteyn_red_walnut_media_unit_lb7.jpg) no-repeat; background-size:cover;\"></div></li><li> <div class=\"product-slider-image\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/3/600x400/fonteyn_red_walnut_media_unit_lb8.jpg) no-repeat; background-size:cover;\"></div></li><li> <div class=\"product-slider-image\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/3/600x400/fonteyn_red_walnut_media_unit_lb9.jpg) no-repeat; background-size:cover;\"></div></li></ul> </div></div><div class=\"navigation\"> <div data-jcarousel=\"true\" class=\"carousel carousel-navigation\"> <ul style=\"left: -40px; top: 0px;\"> <li class=\"active\" data-jcarouselcontrol=\"true\"> <div id=\"im1\" class=\"slider-square\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/3/600x400/fonteyn_red_walnut_media_unit_lb1.jpg) no-repeat; background-size:cover;\"></div></li><li data-jcarouselcontrol=\"true\"> <div id=\"im2\" class=\"slider-square\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/3/600x400/fonteyn_red_walnut_media_unit_lb2_1.jpg) no-repeat; background-size:cover;\"></div></li><li data-jcarouselcontrol=\"true\"> <div id=\"im3\" class=\"slider-square\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/3/600x400/fonteyn_red_walnut_media_unit_lb3.jpg) no-repeat; background-size:cover;\"></div></li><li data-jcarouselcontrol=\"true\"> <div id=\"im4\" class=\"slider-square\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/3/600x400/fonteyn_red_walnut_media_unit_lb4.jpg) no-repeat; background-size:cover;\"></div></li><li data-jcarouselcontrol=\"true\"> <div id=\"im5\" class=\"slider-square\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/3/600x400/fonteyn_red_walnut_media_unit_lb5.jpg) no-repeat; background-size:cover;\"></div></li><li data-jcarouselcontrol=\"true\"> <div id=\"im6\" class=\"slider-square\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/3/600x400/fonteyn_red_walnut_media_unit_lb6.jpg) no-repeat; background-size:cover;\"></div></li><li data-jcarouselcontrol=\"true\"> <div id=\"im7\" class=\"slider-square\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/3/600x400/fonteyn_red_walnut_media_unit_lb7.jpg) no-repeat; background-size:cover;\"></div></li><li data-jcarouselcontrol=\"true\"> <div id=\"im8\" class=\"slider-square\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/3/600x400/fonteyn_red_walnut_media_unit_lb8.jpg) no-repeat; background-size:cover;\"></div></li><li data-jcarouselcontrol=\"true\"> <div id=\"im9\" class=\"slider-square\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/3/600x400/fonteyn_red_walnut_media_unit_lb9.jpg) no-repeat; background-size:cover;\"></div></li></ul> </div></div></div><div data-jcarouselcontrol=\"true\" id=\"left\" class=\"prev-stage inactive\"> <img src=\"/Cloud-tags-portlet/images/arrow-left.png\" height=\"40\" width=\"40\"> </div><div data-jcarouselcontrol=\"true\" id=\"right\" class=\"next-stage\"> <img src=\"/Cloud-tags-portlet/images/arrow-right.png\" height=\"40\" width=\"40\"> </div></div></div><div class=\"product_description_block\"> <div id=\"TabbedPanels1\" class=\"TabbedPanels\"> <ul class=\"TabbedPanelsTabGroup\"> <li class=\"TabbedPanelsTab TabbedPanelsTabSelected\" tabindex=\"0\">Details</li><li class=\"TabbedPanelsTab\" tabindex=\"0\">Collection</li><li class=\"TabbedPanelsTab\" tabindex=\"0\">Color</li></ul> <div class=\"TabbedPanelsContentGroup\"> <div style=\"display: block;\" class=\"TabbedPanelsContent TabbedPanelsContentVisible\"> <div class=\"details_content_block\" style=\"text-align:left; padding-left:0;\"> <div class=\"details_content_heading\">Delivery and returns</div><div class=\"details_content\">Fonteyn Media Unit in walnut and red is a stylish piece for any design-led living room. With sliding doors and plenty of storage space. By Steuart Padwick</div><div class=\"details_content\"> <div id=\"countdown1\">6 days,</div>- <div id=\"countdown2\">04:34:02</div></div></div><div class=\"details_content_block\" style=\"text-align:right; padding-right:0;\"> <div class=\"details_content_heading\">Dimensions</div><div class=\"details_content\">General Dimensions: W150 x D45 x H50cm <br>Storage Dimensions: Shelves - W46 x D41 x H15 Side compartments - W51 x D41 x H15 <br>Packaging Dimensions: 160 x 55 x 46cm</div></div></div><div class=\"TabbedPanelsContent\" style=\"padding: 10% 0% 5%; display: none;\" align=\"center\"> <div id=\"collection1\" onclick=\"clicked(&quot;/designers?designId=1806&quot;)\" class=\"collection_image\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/1806/600x400/fonteyn_dressing_table_coral_designguildlogo_lb1.jpg) no-repeat; background-size:contain; background-position:50% 0;\" align=\"center\"></div><div id=\"collection1\" onclick=\"clicked(&quot;/designers?designId=1997&quot;)\" class=\"collection_image\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/1997/600x400/fonteyn_chest_of_drawers_oak_1.jpg) no-repeat; background-size:contain; background-position:50% 0;\" align=\"center\"></div><div id=\"collection1\" onclick=\"clicked(&quot;/designers?designId=1804&quot;)\" class=\"collection_image\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/1804/600x400/fonteyn_oak_walnut_console_table_lb1_2.jpg) no-repeat; background-size:contain; background-position:50% 0;\" align=\"center\"></div><div id=\"collection1\" onclick=\"clicked(&quot;/designers?designId=1801&quot;)\" class=\"collection_image\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/1801/600x400/fonteyn_desk_oak_walnut_dressing_table_designguildlogo_lb1.jpg) no-repeat; background-size:contain; background-position:50% 0;\" align=\"center\"></div><div id=\"collection1\" onclick=\"clicked(&quot;/designers?designId=2058&quot;)\" class=\"collection_image\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/2058/600x400/fonteyn_oak_dressing_table_lb1.jpg) no-repeat; background-size:contain; background-position:50% 0;\" align=\"center\"></div><div id=\"collection1\" onclick=\"clicked(&quot;/designers?designId=2047&quot;)\" class=\"collection_image\" style=\"background:url(https://s3.amazonaws.com/ct-made-liferay-qa/uploads/designers/images/2047/600x400/fonteyn_oak_bedside_table_lb1_1.jpg) no-repeat; background-size:contain; background-position:50% 0;\" align=\"center\"></div></div><div class=\"TabbedPanelsContent\" style=\"padding: 10% 0% 5%; display: none;\" align=\"center\"> <div class=\"color_image\" onclick=\"clicked(&quot;/designers?designId=2&quot;)\" style=\"background:url(http://www.madestatic.com/media/catalog/product/cache/1/small_image/45x45/9df78eab33525d08d6e5fb8d27136e95/f/o/fonteyn_walnut_swatch_6.jpg) no-repeat; background-size:cover;border:2px solid #ccc;\"></div></div></div></div></div>");
			resourceResponse.getWriter().write(buffer.toString());*/

			resourceResponse.getWriter().write(prodDetailsPopup);

		}else if(cmd.equalsIgnoreCase("productDetails")){
			_log.info("in productDetails");
			long designId = ParamUtil.getLong(uploadPortletRequest, "designId");
			_log.info("in productDetails : "+designId);

			String prodDetails = getProductDetailsPopup(designId, resourceRequest,"");

			resourceResponse.getWriter().write(prodDetails);
		}else if(cmd.equalsIgnoreCase("relatedItems")){
			_log.info("in relatedItems");
			long designId = ParamUtil.getLong(uploadPortletRequest, "designId");
			_log.info("in relatedItems : "+designId);

			session.setAttribute(Constants.PREV_SEL_PROD, designId);

			System.out.println("After set : "+session.getAttribute(Constants.PREV_SEL_PROD));

			Designers designers = null;
			try {

				designers = DesignersLocalServiceUtil.getDesigners(designId);
			}catch(Exception e){

			}
			PrintWriter writer = resourceResponse.getWriter();
			JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();

			HashMap<Long, Designers> cartList = null;

			if (Validator.isNotNull(session.getAttribute("LIFERAY_SHARED_CARTLIST"))) {

				cartList = (HashMap<Long, Designers>) session
						.getAttribute("LIFERAY_SHARED_CARTLIST");

			} else {

				cartList = new HashMap<Long, Designers>();
			}

			JSONArray relatedItems = getRelItems(designers, designId, cartList);
			JSONArray ourEdit = getOurEdit(designers, designId, cartList);
			System.out.println("relatedItems : "+relatedItems);
			jsonObject.put("relatedItems", relatedItems);

			//System.out.println("Our Edit : "+ourEdit);
			jsonObject.put("ourEdit", ourEdit);

			writer.print(jsonObject.toString());
			writer.flush();
			writer.close();
		}


	}

	private JSONArray getRelItems(Designers designers, long productId, HashMap<Long, Designers> cartList){

		JSONArray relatedItems = JSONFactoryUtil.createJSONArray();

		try{
			List<Recommendations> listRecomm = RecommendationsLocalServiceUtil.getByDesigner1(1, designers.getBarcode(), designers.getCompanyId());
			//List<Designers> itemsByColor = DesignersLocalServiceUtil.getByCompanyId(themeDisplay.getCompanyId())
			System.out.println(designers.getBarcode()+">>>>>>>>>>>>>>>>>>>>>>>>"+listRecomm.size());
			int count =0;

			for(Recommendations recommendations : listRecomm) {
				Designers designer = DesignersLocalServiceUtil.getByCompanyId(recommendations.getCompanyId(), recommendations.getDesigner2());
				if((designer != null && designer.getDesignId() == productId) 
						|| (cartList != null && cartList.containsKey(designer.getDesignId())) ) continue;
				//if(object.getColors().equalsIgnoreCase(designer.getColors())){
				//count ++;
				//if(count>6) break;

				if(count>=3) break;

				if(designer != null && designer.isIsactive()){
					try{
						DesignersImages designerImages = 
								DesignersImagesLocalServiceUtil.getByDesignId(designer.getDesignId());
						String URL = "/designers?designId=";

						URL = URL + designer.getDesignId();

						JSONObject obj = JSONFactoryUtil.createJSONObject();

						obj.put("designId", (designer != null) ? Long.toString(designer.getDesignId()) : "");
						obj.put("image1", (designerImages != null ? designerImages.getEntity_image1().replace(PortletProps.get("main.image.dimension"),PortletProps.get("list.page.dimension")) : ""));
						obj.put("url", URL);

						relatedItems.put(obj);
						count ++;
					}catch(Exception e){

					}
				}
			}
		}catch(Exception e){
			_log.error(e.getMessage());
		}
		return relatedItems;
	}

	private JSONArray getOurEdit(Designers designers, long productId, HashMap<Long, Designers> cartList){

		JSONArray ourEdit = JSONFactoryUtil.createJSONArray();

		try{
			List<Recommendations> 
			listRecomm = RecommendationsLocalServiceUtil.getByDesigner1(2, designers.getBarcode(), designers.getCompanyId());
			//List<Designers> itemsByColor = DesignersLocalServiceUtil.getByCompanyId(themeDisplay.getCompanyId())
			System.out.println(designers.getBarcode()+">>>>>>>>>>>>>>>>>>>>>>>>"+listRecomm.size());
			int count =0;
			for(Recommendations recommendations : listRecomm) {
				Designers designer = DesignersLocalServiceUtil.getByCompanyId(recommendations.getCompanyId(), recommendations.getDesigner2());
				if((designer != null && designer.getDesignId() == productId ) 
						|| (cartList != null && cartList.containsKey(designer.getDesignId()))) continue;
				//if(object.getColors().equalsIgnoreCase(designer.getColors())){
				//count ++;
				//if(count>6) break;

				if(count>=3) break;

				if(designer != null && designer.isIsactive()){
					try{
						DesignersImages designerImages = 
								DesignersImagesLocalServiceUtil.getByDesignId(designer.getDesignId());
						String URL = "/designers?designId=";

						URL = URL + designer.getDesignId();

						JSONObject obj = JSONFactoryUtil.createJSONObject();

						obj.put("designId", (designer != null) ? Long.toString(designer.getDesignId()) : "");
						obj.put("image1", (designerImages != null ? designerImages.getEntity_image1().replace(PortletProps.get("main.image.dimension"),PortletProps.get("list.page.dimension")) : ""));
						obj.put("url", URL);

						ourEdit.put(obj);
						count ++;
					}catch(Exception e){

					}
				}
			}
			System.out.println("Our Edit : "+ourEdit);

		}catch(Exception e){
			_log.error(e.getMessage());
		}

		return ourEdit;

	}

	private String getProductDetailsPopup(long designId, ResourceRequest resourceRequest,String viewFrom){

		boolean tabs1 = false;
		boolean tabs2 = false;

		Designers designers = null;
		DesignersImages designersImage = null;
		try {
			designers  = DesignersLocalServiceUtil.getDesigners(designId);
			designersImage = DesignersImagesLocalServiceUtil.getByDesignId(designId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpSession session = PortalUtil.getHttpServletRequest(resourceRequest)
				.getSession();

		HashMap<Long, Designers> cartList = null;
		try{
			if (Validator.isNotNull(session.getAttribute("LIFERAY_SHARED_CARTLIST"))) {

				cartList = (HashMap<Long, Designers>) session
						.getAttribute("LIFERAY_SHARED_CARTLIST");

			} else {

				cartList = new HashMap<Long, Designers>();
			}
		}catch(Exception e){

		}
		String deviceName = StringPool.BLANK;
		String deviceType = StringPool.BLANK;
		String browserName = StringPool.BLANK;
		String deviceWidth = StringPool.BLANK;
		String loginUserId = StringPool.BLANK;
		String ipAddress = StringPool.BLANK;
		if(Validator.isNotNull(session.getAttribute(ImpressionTypes.IPADDRESS.toString()))){
			ipAddress = session.getAttribute(ImpressionTypes.IPADDRESS.toString()).toString();							
		}
		if(Validator.isNotNull(session.getAttribute("LOGIN-USER"))){
			System.out.println("LOGIN-USER inside recommendations if");
			loginUserId = session.getAttribute("LOGIN-USER").toString();							
		}
		if(Validator.isNotNull(session.getAttribute("deviceName"))){
			deviceName = session.getAttribute("deviceName").toString();
		}
		if(Validator.isNotNull(session.getAttribute("deviceType"))){
			deviceType = session.getAttribute("deviceType").toString();
		}
		if(Validator.isNotNull(session.getAttribute("browserName"))){
			browserName = session.getAttribute("browserName").toString();
		}
		long storeDevId = CommonUtil.getStoreIdForDevice(session);
		if(Validator.isNotNull(session.getAttribute("deviceWidth"))){
			deviceWidth = session.getAttribute("deviceWidth").toString();
		}
		try {
			Impressions impressions = ImpressionsLocalServiceUtil.addToImpressions("PRODUCT",Long.toString(designId), 
					ImpressionTypes.TAPPED+viewFrom.toString(),loginUserId , Long.toString(designers.getCompanyId()),
					ipAddress,deviceName,deviceType,deviceWidth,browserName,storeDevId);

			if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressions != null){					
				impressions.setStaffId(session.getAttribute("LOGINSTAFF").toString());
				ImpressionsLocalServiceUtil.updateImpressions(impressions);
			}

		} catch (SystemException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		StringBuffer buffer = new StringBuffer();
		buffer.append("<div class=\"product_slider_main\">");
		buffer.append("<div class=\"product_slider_heading_main\">");
		buffer.append(" <div class=\"product_slider_heading_left\">");
		buffer.append(designers.getProductTitle()+"</div>");
		buffer.append("<div class=\"product_slider_heading_left_content\">");
		buffer.append(designers.getShortDescription().replaceAll("</br>", "")+"</div>");
		buffer.append("<div class=\"product_slider_heading_right\">");
		buffer.append("&pound;"+designers.getPrice()+"</div>");
		//£549);
		buffer.append(" </div>");
		buffer.append(" <!--product_slider_heading_main-->");
		buffer.append("  <div class=\"product_slider\">");
		buffer.append("   <div class=\"connected-carousels\">");
		buffer.append("    <div class=\"stage\">");
		buffer.append("       <div class=\"carousel carousel-stage\">");
		buffer.append("<ul>");
		if(Validator.isNotNull(designersImage.getEntity_image1())) { 

			buffer.append("<li><div class=\"product-slider-image\" style=\"background:url("+designersImage.getEntity_image1()+") no-repeat; background-size:contain; background-position:0% 40%;\"></div></li>");  

		}if(Validator.isNotNull(designersImage.getEntity_image2())) { 
			buffer.append("<li><div class=\"product-slider-image\" style=\"background:url("+designersImage.getEntity_image2()+") no-repeat; background-size:contain; background-position:0% 40%;\"></div></li>");  
		}if(Validator.isNotNull(designersImage.getEntity_image3())) { 
			buffer.append("<li><div class=\"product-slider-image\" style=\"background:url("+designersImage.getEntity_image3()+") no-repeat; background-size:contain; background-position:0% 40%;\"></div></li>");  
		}if(Validator.isNotNull(designersImage.getEntity_image4())) { 
			buffer.append(" <li><div class=\"product-slider-image\" style=\"background:url("+designersImage.getEntity_image4()+") no-repeat; background-size:contain; background-position:0% 40%;\"></div></li>");  
		}if(Validator.isNotNull(designersImage.getEntity_image5())) { 
			buffer.append(" <li><div class=\"product-slider-image\" style=\"background:url("+designersImage.getEntity_image5()+") no-repeat; background-size:contain; background-position:0% 40%;\"></div></li>");  
		}if(Validator.isNotNull(designersImage.getEntity_image6())) { 
			buffer.append("<li><div class=\"product-slider-image\" style=\"background:url("+designersImage.getEntity_image6()+") no-repeat; background-size:contain; background-position:0% 40%;\"></div></li>");  
		}if(Validator.isNotNull(designersImage.getEntity_image7())) { 
			buffer.append(" <li><div class=\"product-slider-image\" style=\"background:url("+designersImage.getEntity_image7()+") no-repeat; background-size:contain; background-position:0% 40%;\"></div></li>");  
		}if(Validator.isNotNull(designersImage.getEntity_image8())) { 
			buffer.append(" <li><div class=\"product-slider-image\" style=\"background:url("+designersImage.getEntity_image8()+") no-repeat; background-size:contain; background-position:0% 40%;\"></div></li>");  
		}if(Validator.isNotNull(designersImage.getEntity_image9())) { 
			buffer.append(" <li><div class=\"product-slider-image\" style=\"background:url("+designersImage.getEntity_image9()+") no-repeat; background-size:contain; background-position:0% 40%;\"></div></li>");  
		}if(Validator.isNotNull(designersImage.getEntity_image10())) { 
			buffer.append("<li><div class=\"product-slider-image\" style=\"background:url("+designersImage.getEntity_image10()+") no-repeat; background-size:contain; background-position:0% 40%;\"></div></li>");  
		}
		buffer.append("</ul>");  
		buffer.append(" </div>");  

		buffer.append(" </div>");  

		buffer.append(" <div class=\"navigation\">");  

		buffer.append("<div class=\"carousel carousel-navigation\">");  
		buffer.append("<ul>");

		if(Validator.isNotNull(designersImage.getEntity_image1())) { 
			buffer.append(" <li><div id=\"im1\" class=\"slider-square\" style=\"background:url("+designersImage.getEntity_image1().replace(PortletProps.get("main.image.dimension"),PortletProps.get("small.image.dimension"))+") no-repeat; background-size:contain; background-position:0%;\"></div></li>");  
		}if(Validator.isNotNull(designersImage.getEntity_image2())) { 
			buffer.append(" <li><div id=\"im2\" class=\"slider-square\" style=\"background:url("+designersImage.getEntity_image2().replace(PortletProps.get("main.image.dimension"),PortletProps.get("small.image.dimension"))+") no-repeat; background-size:contain; background-position:0%;\"></div></li>");  
		}if(Validator.isNotNull(designersImage.getEntity_image3())) { 
			buffer.append(" <li><div id=\"im3\" class=\"slider-square\" style=\"background:url("+designersImage.getEntity_image3().replace(PortletProps.get("main.image.dimension"),PortletProps.get("small.image.dimension"))+") no-repeat; background-size:contain; background-position:0%;\"></div></li>");  
		}if(Validator.isNotNull(designersImage.getEntity_image4())) { 
			buffer.append(" <li><div id=\"im4\" class=\"slider-square\" style=\"background:url("+designersImage.getEntity_image4().replace(PortletProps.get("main.image.dimension"),PortletProps.get("small.image.dimension"))+") no-repeat; background-size:contain; background-position:0%;\"></div></li>");  
		}if(Validator.isNotNull(designersImage.getEntity_image5())) { 
			buffer.append("  <li><div id=\"im5\" class=\"slider-square\" style=\"background:url("+designersImage.getEntity_image5().replace(PortletProps.get("main.image.dimension"),PortletProps.get("small.image.dimension"))+") no-repeat; background-size:contain; background-position:0%;\"></div></li>");  
		}if(Validator.isNotNull(designersImage.getEntity_image6())) { 
			buffer.append(" <li><div id=\"im6\" class=\"slider-square\" style=\"background:url("+designersImage.getEntity_image6().replace(PortletProps.get("main.image.dimension"),PortletProps.get("small.image.dimension"))+") no-repeat; background-size:contain; background-position:0%;\"></div></li>");  
		}if(Validator.isNotNull(designersImage.getEntity_image7())) { 
			buffer.append(" <li><div id=\"im7\" class=\"slider-square\" style=\"background:url("+designersImage.getEntity_image7().replace(PortletProps.get("main.image.dimension"),PortletProps.get("small.image.dimension"))+") no-repeat; background-size:contain; background-position:0%;\"></div></li>");  
		}if(Validator.isNotNull(designersImage.getEntity_image8())) { 
			buffer.append(" <li><div id=\"im8\" class=\"slider-square\" style=\"background:url("+designersImage.getEntity_image8().replace(PortletProps.get("main.image.dimension"),PortletProps.get("small.image.dimension"))+") no-repeat; background-size:contain; background-position:0%;\"></div></li>");  
		}if(Validator.isNotNull(designersImage.getEntity_image9())) { 
			buffer.append(" <li><div id=\"im9\" class=\"slider-square\" style=\"background:url("+designersImage.getEntity_image9().replace(PortletProps.get("main.image.dimension"),PortletProps.get("small.image.dimension"))+") no-repeat; background-size:contain; background-position:0%;\"></div></li>");  
		}if(Validator.isNotNull(designersImage.getEntity_image10())) { 
			buffer.append(" <li><div id=\"im10\" class=\"slider-square\" style=\"background:url("+designersImage.getEntity_image10().replace(PortletProps.get("main.image.dimension"),PortletProps.get("small.image.dimension"))+") no-repeat; background-size:contain; background-position:0%;\"></div></li>");  
		}
		buffer.append("</ul>"); 
		buffer.append("</div>"); 
		buffer.append("</div>"); 
		buffer.append("</div>"); 


		buffer.append("<div  id=\"left\" class=\"prev-stage inactive\"> "); 
		buffer.append("<img src=\""+resourceRequest.getContextPath() +"/images/arrow-left.png\" height=\"40\" width=\"40\">");  
		buffer.append(" </div> "); 

		buffer.append("  <div id=\"right\" class=\"next-stage\"> "); 
		buffer.append(" <img src=\""+resourceRequest.getContextPath() +"/images/arrow-right.png\" height=\"40\" width=\"40\"> "); 
		buffer.append("</div>"); 



		buffer.append("</div><!--product_slider-->"); 



		buffer.append(" </div><!--product_slider_main-->"); 


		buffer.append("<div class=\"product_description_block\">"); 

		buffer.append("<div id=\"TabbedPanels1\" class=\"TabbedPanels\">"); 
		buffer.append("<ul class=\"TabbedPanelsTabGroup\">"); 
		buffer.append("<li class=\"TabbedPanelsTab TabbedPanelsTabSelected\" tabindex=\"0\" >Details</li>"); 
		buffer.append("<li class=\"TabbedPanelsTab\" tabindex=\"0\">Collection</li>"); 
		buffer.append("<li class=\"TabbedPanelsTab\" tabindex=\"0\">Colour</li>"); 
		buffer.append("</ul>"); 
		buffer.append(" <div class=\"TabbedPanelsContentGroup\">"); 
		String padding1 = "padding:8% 0% 42% 0%;";

		if(Validator.isNotNull(designers.getLeft_description()) && Validator.isNotNull(designers.getRight_description())){
			System.out.println("inside ");
			padding1 = "padding:8% 0% 25% 0%;";
		}
		buffer.append("<div class=\"TabbedPanelsContent TabbedPanelsContentVisible\" id=\"DetailsTabbedPanel\" style=\""+padding1+"\">"); 

		buffer.append("<div class=\"details_content_block\" style=\"text-align:left; padding-left:0;\">"); 

		buffer.append(" <div class=\"details_content_heading\">Description</div>"); 
		buffer.append(" <div class=\"details_content\">"); 
		buffer.append(designers.getLeft_description());
		buffer.append("</div>"); 

		buffer.append("<div class=\"details_content_heading\">Next batch order</div>");

		buffer.append("<div class=\"details_content\">"); 
		//buffer.append("<div id=\"countdown1\">2 days,</div> - <div id=\"countdown2\">12:01</div>"); 
		buffer.append("<div class=\"details_content\" style=\"width: 100%; display: inline-block;\"><span id=\"countdown1\">2 days</span> - <span id=\"countdown2\">12:01</span> </div>");
		buffer.append("</div>"); 

		buffer.append("</div><!--details_content1-->"); 


		buffer.append("<div class=\"details_content_block\" style=\"text-align:right; padding-right:0;\">"); 

		buffer.append("<div class=\"details_content_heading\">Dimensions</div>"); 
		buffer.append(" <div class=\"details_content\">"); 
		buffer.append(designers.getRight_description()); 

		buffer.append(" </div>"); 

		buffer.append("</div><!--details_content2-->"); 

		buffer.append(" </div><!--Details_block-->"); 

		String padding = "padding:8% 0% 42% 0%;";

		List<Recommendations> listRecomm = null;

		try {
			listRecomm = RecommendationsLocalServiceUtil.getByDesigner1(3, designers.getBarcode(), designers.getCompanyId());
		} catch (SystemException e2) {
			_log.error(e2.getMessage());
		}
		System.out.println("Size coll : "+listRecomm.size());
		if(listRecomm != null && listRecomm.size() > 3 ){
			System.out.println("Size coll : "+listRecomm.size());
			padding = "padding:8% 0% 25% 0%;";
		}
		System.out.println("padding coll : "+padding);
		//buffer.append("<div align=\"center\" class=\"TabbedPanelsContent\" style=\"padding:8% 0% 25% 0%;display:none;\">"); 
		if(listRecomm.size() != 0){
		buffer.append("<div align=\"center\" class=\"TabbedPanelsContent\" id=\"CollectionTabbedPanel\" style=\"");
		buffer.append(padding+"display:none;\">");
		//try{
		//List<Recommendations> listRecomm = RecommendationsLocalServiceUtil.getByDesigner1(3, designers.getBarcode(), designers.getCompanyId());
		//List<Designers> itemsByColor = DesignersLocalServiceUtil.getByCompanyId(themeDisplay.getCompanyId())
		int count =0;
		for(Recommendations recommendations : listRecomm) {
			Designers designers2 = null;
			try{
				designers2 = DesignersLocalServiceUtil.getByCompanyId(recommendations.getCompanyId(), recommendations.getDesigner2());

				if((designers2 !=  null && designers2.getDesignId() == designId) || 
						(cartList != null && cartList.containsKey(designers2.getDesignId()))) continue;
				//if(object.getColors().equalsIgnoreCase(designers.getColors())){

				if(count>5) break;
				//if(count>3) break;
				if(designers2 != null&& designers2.isIsactive()){
					tabs1 = true;
					DesignersImages designersImages = null;
					try{
						designersImages = DesignersImagesLocalServiceUtil.getByDesignId(designers2.getDesignId());
					}catch(Exception e){}
					String URL = "/designers?designId=";

					URL = URL + designers2.getDesignId();

					//buffer.append("<div id=\"collection1\" onclick='clicked(\""+URL.toString()+" \")' align=\"center\" class=\"collection_image\" style=\"background:url("+designersImages.getEntity_image1()+") no-repeat; background-size:contain; background-position:50% 0;\"></div>"); 
					if(designersImages != null){
						buffer.append("<div id=\"collection"+designers2.getDesignId()+ "\" onclick=getProductDetails(");
						buffer.append(designers2.getDesignId());
						buffer.append(",true,'"+ImpressionTypes.COLLECTIONS+"') align=\"center\" class=\"collection_image\" style=\"background:url("+designersImages.getEntity_image1().replace(PortletProps.get("main.image.dimension"),PortletProps.get("list.page.dimension"))+") no-repeat; background-size:contain; background-position:50% 0;\"></div>");
						//}
						count ++;
					}
				}
			}catch(Exception e){

			}
		} 

		//} catch(Exception e){}


		buffer.append("</div><!--Collection_block-->"); 
		}
		padding = "padding:8% 0% 42% 0%;";

		listRecomm = null;
		try {
			listRecomm = RecommendationsLocalServiceUtil.getByDesigner1(4, designers.getBarcode(), designers.getCompanyId());
		} catch (SystemException e1) {
			_log.error(e1.getMessage());

		}
		System.out.println("Size color : "+listRecomm.size());
		if(listRecomm != null && listRecomm.size() > 3 ){
			//System.out.println("Size color : "+listRecomm.size());
			padding = "padding:8% 0% 25% 0%;";
		}

		System.out.println("padding color : "+padding);
		//buffer.append("<div align=\"center\" class=\"TabbedPanelsContent\" style=\"");
		if(listRecomm.size()!=0){
		buffer.append("<div align=\"center\" class=\"TabbedPanelsContent\" id=\"ColourTabbedPanel\" style=\"");
		buffer.append(padding+"display:none;\">"); 

		try{
			//List<Recommendations> listRecomm = RecommendationsLocalServiceUtil.getByDesigner1(4, designers.getBarcode(), designers.getCompanyId());
			//List<Designers> itemsByColor = DesignersLocalServiceUtil.getByCompanyId(themeDisplay.getCompanyId())
			int count =0;
			for(Recommendations recommendations : listRecomm) {
				Designers designers3 = null;
				try{
					designers3 = DesignersLocalServiceUtil.getByCompanyId(recommendations.getCompanyId(), recommendations.getDesigner2());

					if(designers3 != null && designers3.getDesignId() == designId || 
							(cartList != null && cartList.containsKey(designers3.getDesignId()))) continue;
					//if(object.getColors().equalsIgnoreCase(designers.getColors())){
					//count ++;
					if(count>5) break;

					//if(count>3) break;
					if(designers3 != null && designers3.isIsactive()){
						tabs2 = true;
						DesignersImages designersImages = null;
						try{
							designersImages = DesignersImagesLocalServiceUtil.getByDesignId(designers3.getDesignId());
						}catch(Exception e){}
						String URL = "/designers?designId=";

						URL = URL + designers3.getDesignId();

						if(designersImages != null){
							//buffer.append("<div class=\"color_image\" onclick='clicked(\""+URL.toString() +"\")' style=\"background:url("+recommendations.getColor_image()+" ) no-repeat; background-size:cover;border:2px solid #ccc;\"></div>"); 
							buffer.append("<div id=\"color"+designers3.getDesignId()+"\" class=\"color_image\" onclick=getProductDetails(");
							buffer.append(designers3.getDesignId());
							buffer.append(",true,'"+ImpressionTypes.COLOURS+"'); style=\"background:url("+recommendations.getColor_image()+" ) no-repeat; background-size:cover;border:2px solid #ccc;\"></div>");
							//}
							count ++;
						}
					}
				}catch(Exception e){}
			} 


		} catch(Exception e){}


		buffer.append("</div><!--Color_Block-->"); 
		}
		buffer.append(" </div>"); 
		buffer.append(" </div>"); 

		buffer.append("</div><!--product_description_block-->");

		String finalBufferString = buffer.toString();
		if(!tabs1){
			finalBufferString = finalBufferString.replace("<li class=\"TabbedPanelsTab\" tabindex=\"0\">Collection</li>","");
			finalBufferString = finalBufferString.replace("<div align=\"center\" style=\"padding: 8% 0% 42%; display: block;\" id=\"CollectionTabbedPanel\" class=\"TabbedPanelsContent\"></div>","");
			
		}
		if(!tabs2){
			finalBufferString = finalBufferString.replace("<li class=\"TabbedPanelsTab\" tabindex=\"0\">Colour</li>","");
			finalBufferString = finalBufferString.replace("<div align=\"center\" style=\"padding: 8% 0% 42%; display: block;\" id=\"ColourTabbedPanel\" class=\"TabbedPanelsContent\"></div>","");

		}

		return finalBufferString;
	}

	/**
	 * This method sets the UserId associated to the CART List so that next time when he comes we can display the product added to CARTS.
	 * @param session
	 * @param userId
	 */
	private void updateUserIdOfCart(HttpSession session, long userId) {

		try{

			if (Validator.isNotNull(session.getAttribute(
					"LIFERAY_SHARED_CARTDESIGNERS"))) {
				@SuppressWarnings("unchecked")
				HashMap<Long, CartsDesigners> cartDesignersList = (HashMap<Long, CartsDesigners>) session
				.getAttribute("LIFERAY_SHARED_CARTDESIGNERS"
						);
				@SuppressWarnings("rawtypes")
				Iterator it = cartDesignersList.entrySet().iterator();

				while (it.hasNext()) {
					@SuppressWarnings("unchecked")
					Entry<Long, CartsDesigners> entry = (Entry<Long, CartsDesigners>) it
					.next();
					CartsDesigners cartsDesigners = entry.getValue();

					Carts carts = CartsLocalServiceUtil.getCarts(cartsDesigners.getCartId());
					if(carts.getUserId() != userId) {
						carts.setUserId(userId);
						CartsLocalServiceUtil.updateCarts(carts);
					}

				}
			}

		} catch(Exception e){
			e.printStackTrace();
		}

	}
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		HttpSession session = PortalUtil.getHttpServletRequest(renderRequest)
				.getSession();

		long loginUserRec = themeDisplay.getUserId();
		if(Validator.isNotNull(session.getAttribute("FIRST-LOGIN-USER"))){
			loginUserRec = Long.parseLong(session.getAttribute("FIRST-LOGIN-USER").toString());
		}

		if(Validator.isNull(session.getAttribute("LOGIN-USER"))){
			UUID idOne = UUID.randomUUID();
			session.setAttribute("LOGIN-USER", idOne.toString());
			try {
				String deviceName = StringPool.BLANK;
				String deviceType = StringPool.BLANK;
				String browserName = StringPool.BLANK;
				String deviceWidth = StringPool.BLANK;
				long storeId = CommonUtil.getStoreIdForDevice(session);
				if(Validator.isNotNull(session.getAttribute("deviceName"))){
					deviceName = session.getAttribute("deviceName").toString();
				}
				if(Validator.isNotNull(session.getAttribute("deviceType"))){
					deviceType = session.getAttribute("deviceType").toString();
				}
				if(Validator.isNotNull(session.getAttribute("browserName"))){
					browserName = session.getAttribute("browserName").toString();
				}
				if(Validator.isNotNull(session.getAttribute("deviceWidth"))){
					deviceWidth = session.getAttribute("deviceWidth").toString();
				}
				Impressions impressions = 	ImpressionsLocalServiceUtil.addToImpressions(ImpressionTypes.USER.getValue(), Long.toString(loginUserRec),
						ImpressionTypes.LOGIN.getValue(),idOne.toString() , Long.toString(themeDisplay.getCompanyId()),
						PortalUtil.getHttpServletRequest(renderRequest).getRemoteAddr(),
						deviceName,deviceType,deviceWidth,browserName,storeId);
				if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressions != null){
					impressions.setStaffId(session.getAttribute("LOGINSTAFF").toString());
					ImpressionsLocalServiceUtil.updateImpressions(impressions);
				}
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		super.doView(renderRequest, renderResponse);
	}



	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
}
