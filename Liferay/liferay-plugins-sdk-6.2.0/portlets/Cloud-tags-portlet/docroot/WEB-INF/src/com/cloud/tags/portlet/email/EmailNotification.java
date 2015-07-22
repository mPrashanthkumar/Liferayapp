package com.cloud.tags.portlet.email;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.portlet.PortletException;
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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

/**
 * @author Azam
 * Portlet implementation class EmailNotification
 * this Class is used to manage the Product List to be send Via email from I-M-Ready page
 */
public class EmailNotification extends MVCPortlet {

	private final static Logger _log = Logger.getLogger(EmailNotification.class
			.getName());

	@Override
	public void init() throws PortletException {
		// TODO Auto-generated method stub
		super.init();
	}

	/**
	 * this method reads the email template and the CART list and sends it as a email to the Users. Also manages the Style advisor users associated to the Cart products
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		UploadPortletRequest uploadPortletRequest = PortalUtil
				.getUploadPortletRequest(resourceRequest);

		String cmd = uploadPortletRequest.getParameter("CMD");

		_log.info("CMD" +cmd);

		HttpSession session =  PortalUtil.getHttpServletRequest(resourceRequest).getSession();

		long storeId = CommonUtil.getStoreIdForDevice(session);	



		String loginUser = StringPool.BLANK;
		if(Validator.isNotNull(session.getAttribute("LOGIN-USER"))){
			loginUser = session.getAttribute("LOGIN-USER").toString();										
		}
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		if (cmd.equalsIgnoreCase("sendEmail")) {
			boolean sayDuck = false;

			String emailAddress = uploadPortletRequest.getParameter("email");// ParamUtil.getString(resourceRequest,"email");

			session.setAttribute("FIRST-EMAIL", emailAddress);
			System.out.println(ParamUtil.getString(uploadPortletRequest,
					"email"));
			System.out.println(uploadPortletRequest.getAttribute("email"));
			System.out.println("I am here with email address" + emailAddress);


			long userId = CommonUtil.getUserByEmail(emailAddress, themeDisplay.getCompanyId());

			updateUserIdOfCart(session,userId);

			String emailTemplate = PortletProps.get("email.template.data");  // commented for time beaing MailUtil.getContent(PropsUtil.get("cartEmalTemplate"), themeDisplay);

			HashMap<Long, Designers> cartList = null;

			String data = PortletProps.get("email.template.variable");

			StringBuffer buffer = new StringBuffer();
			StringBuffer recoBuffer = new StringBuffer();

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

				boolean isDesignersRecomm = false;
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
				String cartId = StringPool.BLANK;

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
								buffer.append("<div align=\"center\" id=\"autogenratedIdMade"+Math.random()+"\"><table cellspacing=\"0\" cellpadding=\"0\" width=\"602\" border=\"0\" style=\"width:386.5pt; padding-top:0%;\"><tbody><tr>");

							}
							// start code for made google analytics by shiva 04-03-2015
							String generatedURL=""+designer.getPublic_url()+"?c=cloudtags&utm_source=cloudtags&utm_medium=cloudtags-"+cartId+"&utm_campaign=cloudtags&utm_content="+designer.getBarcode()+"";

							if((generatedURL.contains("rfihub.com"))){
								generatedURL=""+designer.getPublic_url()+"?c=cloudtags%26utm_source=cloudtags%26utm_medium=cloudtags-"+cartId+"%26utm_campaign=cloudtags%26utm_content="+designer.getBarcode()+"";													
							}
							// end code for made google analytics by shiva

							buffer.append("<td width=\"185\" valign=\"top\" style=\"width:138.75pt;padding:0cm;\" colspan=\"3\"> "
									+ "<p align=\"center\" style=\"text-align:center\" class=\"MsoNormal\"> "
									+ "<a style=\"text-decoration:none!important; -webkit-tap-highlight-color: rgba(0,0,0,0) !important;-webkit-tap-highlight-color: transparent !important; outline:none;\" href='"+generatedURL+"' target=\"_blank\">"
									+ "<img style=\"-webkit-tap-highlight-color: rgba(0,0,0,0) !important;-webkit-tap-highlight-color: transparent !important;\" width=\"190\" height=\"190\" border=\"0\" src='"+ designersImages.getEntity_image1()+ "' class=\"CToWUd\">");
							buffer.append("</a><u></u><u></u> </p></td> <td width=\"5\" valign=\"top\" style=\"width:3.75pt;padding:0cm\" rowspan=\"7\"></td>");

							getAddedCount++;

							if(((getAddedCount-1) == sublist.size())){
								if(sublist.size() < columns){
									for(int i = 0; i< (columns - sublist.size()); i++ ){								

										buffer.append("<td width=\"185\" valign=\"top\" style=\"width:138.75pt;padding:0cm;\" colspan=\"3\"></td>");
										buffer.append("<td width=\"5\" valign=\"top\" style=\"width:3.75pt;padding:0cm\" rowspan=\"7\"></td>");
									}
								}
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

						buffer.append("<td width=\"185\" valign=\"top\" style=\"width:110pt;padding:0pt 11.25pt 0pt 11.25pt;\" colspan=\"3\">");

						buffer.append("<p align=\"center\" style=\"text-align:center;\" class=\"MsoNormal\">"
								+ "<span style=\"font-size:15pt;font-family: 'Times New Roman', Times, serif;color:#000;\"><span><a style=\"text-decoration:none!important;-webkit-tap-highlight-color: rgba(0,0,0,0) !important;-webkit-tap-highlight-color: transparent !important; outline:none;font-family: 'Times New Roman', Times, serif;color:#000;\" href='"+generatedURL+"'"
								+ " target=\"_blank\">");

						if(designer.getName().length()>22){
							buffer.append(designer.getName().substring(0, 22)+"...<br>");
						}else{
							buffer.append(designer.getName()+"<br>");
						}
						buffer.append("</a></span><u></u><u></u></span><br/>");

						buffer.append("<span style=\"font-size:20pt;font-family: 'Times New Roman', Times, serif;color:#000;cursor:default;\">"
								+ "<span><strong>&pound;"+designer.getPrice()+"</strong></span></p></td>");

						getAddedCount++;


						if(((getAddedCount-1) == sublist.size())){
							if(sublist.size() < columns){
								for(int i = 0; i< (columns - sublist.size()); i++ ){																	
									buffer.append("<td width=\"185\" valign=\"top\" style=\"width:110pt;padding:0pt 11.25pt 0pt 11.25pt;\" colspan=\"3\"></td>");
								}
							}
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

						buffer.append("<td width=\"185\" valign=\"top\" style=\"width:138.75pt;padding:10pt 0 0 0;\" colspan=\"3\">");
						buffer.append("<p align=\"center\" style=\"text-align:center\" class=\"MsoNormal\">");
						buffer.append("<a style=\"text-decoration:none!important;-webkit-tap-highlight-color: rgba(0,0,0,0) !important;-webkit-tap-highlight-color: transparent !important; outline:none;\" href='"+generatedURL+"' target=\"_blank\">");
						buffer.append("<img width=\"130\" border=\"0\" src=\"https://ct-made-liferay-v2.s3.amazonaws.com/email_template_related/buy.jpg\" "
								+ " class=\"CToWUd\"> </a><u></u><u></u></p></td>");
						buffer.append("<td width=\"5\" valign=\"top\" style=\"width:3.75pt;padding:0cm\" rowspan=\"7\"></td>");

						getAddedCount++;


						if(((getAddedCount-1) == sublist.size())){
							if(sublist.size() < columns){
								for(int i = 0; i< (columns - sublist.size()); i++ ){																	
									buffer.append("<td width=\"185\" valign=\"top\" style=\"width:138.75pt;padding:10pt 0 0 0;\" colspan=\"3\"></td>");
									buffer.append("<td width=\"5\" valign=\"top\" style=\"width:3.75pt;padding:0cm\" rowspan=\"7\"></td>");
								}
							}
							buffer.append("</tr>");
						}

					}

					getAddedCount =1;
					for (Designers designer : sublist) {
						getAddedCount++;

						if(((getAddedCount-1) == sublist.size())){
							buffer.append("</tbody></table></div>");
						}
					}

				}

				/*for (Designers designer : masterMap.values()) {
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
						buffer.append("<tr>");
						if(designer.getSayduck() && map.containsValue(designer)){
							buffer.append("<td width=40 align=right><img src=\"http://ct-made-liferay-qa.s3.amazonaws.com/email-template/sayduck2.png\" width=29 height=55></td>");
						}else{
							buffer.append("<td width=40></td>");
						}

						// start code for made google analytics by shiva 04-03-2015
						String generatedURL=""+designer.getPublic_url()+"?c=cloudtags&utm_source=cloudtags&utm_medium=cloudtags-"+cartId+"&utm_campaign=cloudtags&utm_content="+designer.getBarcode()+"";

						if((generatedURL.contains("rfihub.com"))){
							generatedURL=""+designer.getPublic_url()+"?c=cloudtags%26utm_source=cloudtags%26utm_medium=cloudtags-"+cartId+"%26utm_campaign=cloudtags%26utm_content="+designer.getBarcode()+"";													
						}
						// end code for made google analytics by shiva

						buffer.append("<td width=230><a style=\"text-decoration:none\" href='"+generatedURL+"'>"
								+ "<img src='"+ designersImages.getEntity_image1()+ "'width=230 height=119>"
								+ "</a></td><td align=center valign=middle width=220>"
								+ "<a style=\"text-decoration:none\" href='"+generatedURL+"'>"
								+ "<font face=\"Kameron,Georgia,'Times New Roman',Times,serif\" size=\"3\" color=\"#000000\">");
						String desigName = designer.getName().replace("&#44;", ",");
						if(desigName.length() > 60){
							buffer.append(desigName.substring(0,60));
						}else{
							buffer.append(desigName);
						}
						buffer.append("</font></a></td>"
								+ "<td align=center valign=middle width=120><font face=\"Kameron,Georgia,'Times New Roman',Times,serif\" size=\"3\" color=\"#000000\">"
								+ "&pound;"+designer.getPrice()+"</font></td><td align=center valign=middle width=160>"
								+ "<a style=\"text-decoration:none\" href='"+generatedURL+"'>"
								+ "<img src=\"http://ct-made-liferay-qa.s3.amazonaws.com/email-template/buynow.png\" alt=\"BUY NOW\" width=140 height=37></a></td>"
								+ "<td width=30></td></tr><tr><td colspan=6 width=800 height=20> </td></tr>" );

						getAddedCount++;
						if(addedCount == getAddedCount && getAddedCount<10){
							_log.info("getAddedCount>"+getAddedCount);
							buffer.append("<tr><td width=\"800\" valign=\"middle\" height=\"20\" align=\"center\" colspan=\"6\"><font size=\"3\" face=\"Kameron,Georgia,'Times New Roman',Times,serif\" color=\"#000000\"><p><b><u>Recommended products:</u></b></p></font></td></tr>");		
						}

					} catch (NoSuchDesignersImagesException e) {
						_log.error(""+e.getMessage());
					} catch (SystemException e) {
						_log.error(""+e.getMessage());
					}


				}*/


				columns = 3; //3 col table
				if(recommendationMap != null && recommendationMap.size() > 0){
					int col = 1;
					recoBuffer.append("<div align=\"center\"> <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"602\" "
							+ "style=\"width:451.5pt\"> <tbody> <tr style=\"height:26pt\"> <td width=\"30%\" style="
							+ "\"width:301px;padding:0cm;height:18pt\"></td><td width=\"30%\" style=\"width:301px;padding:0cm;height:18pt\">"
							+ "</td></tr><tr style=\"height:26pt\"> <td style=\"padding:0cm;height:0.75pt;border-top:#999999 solid 1px;\">"
							+ "</td><td style=\"padding:0cm;height:0.75pt;border-top:#999999 solid 1px;\"></td></tr></tbody> </table> "
							+ "</div>");

					recoBuffer.append("<div align=\"center\"> <table cellspacing=\"0\" cellpadding=\"0\" width=\"602\" border=\"0\" style="
							+ "\"width:360.5pt\"> <tbody> <tr> <td align=\"left\" width=\"100%\" valign=\"top\" style=\"width:147.75pt;"
							+ "padding:0 0 10pt 0;\" colspan=\"3\"> <p style=\"text-align:left\" align=\"left\" class=\"MsoNormal\"> "
							+ "<span style=\"font-size:19px; text-align:left;font-family: 'Times New Roman', Times, serif;cursor:default;\">"
							+ "Our Edit:</span> </p></td></tr>");

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
									if(col == 1){
										recoBuffer.append("<tr>");										
									}else{
										recoBuffer.append("<div align=\"center\"><table cellspacing=\"0\" cellpadding=\"0\" width=\"602\" border=\"0\" style=\"width:360.5pt\"><tbody><tr>");
									}
								}

								// start code for made google analytics by shiva 04-03-2015
								String generatedURL=""+designer.getPublic_url()+"?c=cloudtags&utm_source=cloudtags&utm_medium=cloudtags-"+cartId+"&utm_campaign=cloudtags&utm_content="+designer.getBarcode()+"";

								if((generatedURL.contains("rfihub.com"))){
									generatedURL=""+designer.getPublic_url()+"?c=cloudtags%26utm_source=cloudtags%26utm_medium=cloudtags-"+cartId+"%26utm_campaign=cloudtags%26utm_content="+designer.getBarcode()+"";													
								}

								recoBuffer.append("<td width=\"185\" valign=\"top\" style=\"width:138.75pt;padding:0cm;\" colspan=\"3\">");
								recoBuffer.append("<p align=\"center\" style=\"text-align:center\" class=\"MsoNormal\">");
								recoBuffer.append("<a style=\"text-decoration:none!important;-webkit-tap-highlight-color: rgba(0,0,0,0) !important;-webkit-tap-highlight-color: transparent !important; outline:none;\" href='"+generatedURL+"' target=\"_blank\">");
								recoBuffer.append("<img width=\"130\" height=\"130\" border=\"0\" src='"+ designersImages.getEntity_image1()+ "' class=\"CToWUd\">");
								recoBuffer.append("</a><u></u><u></u></p>"
										+ "</td><td width=\"5\" valign=\"top\" style=\"width:8.75pt;padding:0cm\" rowspan=\"7\"></td>");

								getAddedCount++;


								if(((getAddedCount-1) == sublist.size())){
									if(sublist.size() < columns){
										for(int i = 0; i< (columns - sublist.size()); i++ ){
											recoBuffer.append("<td width=\"185\" valign=\"top\" style=\"width:138.75pt;padding:0cm;\" colspan=\"3\">");
											recoBuffer.append("</td><td width=\"5\" valign=\"top\" style=\"width:8.75pt;padding:0cm\" rowspan=\"7\"></td>");
										}
									}
									buffer.append("</tr>");
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
								recoBuffer.append("</tbody></table></div>");
							}
						}
					}
					/*for(Designers designer : recommendationMap.values()){

						DesignersImages designerImage = null;
						try {
							if(col % 3 == 0)
								buffer.append("<tr>");
							buffer.append("<td width=\"185\" valign=\"top\" style=\"width:138.75pt;padding:0cm;\" colspan=\"3\">"
									+ "<p align=\"center\" style=\"text-align:center\" class=\"MsoNormal\">"
									+"<a style=\"text-decoration:none!important;-webkit-tap-highlight-color: rgba(0,0,0,0) "
									+ "!important;-webkit-tap-highlight-color: transparent !important; "
									+ "outline:none;\" href=\"https://www.google.co.in/\" "
									+             "target=\"_blank\">");

							// start code for made google analytics by shiva 04-03-2015
							String generatedURL=""+designer.getPublic_url()+"?c=cloudtags&utm_source=cloudtags&utm_medium=cloudtags-"+cartId+"&utm_campaign=cloudtags&utm_content="+designer.getBarcode()+"";

							if((generatedURL.contains("rfihub.com"))){
								generatedURL=""+designer.getPublic_url()+"?c=cloudtags%26utm_source=cloudtags%26utm_medium=cloudtags-"+cartId+"%26utm_campaign=cloudtags%26utm_content="+designer.getBarcode()+"";													
							}
							// end code for made google analytics by shiva
							designerImage = DesignersImagesLocalServiceUtil
									.getByDesignId(designer.getDesignId());


							buffer.append("<img width=\"130\" height=\"130\" border=\"0\" "
									+ "src='"+ designerImage.getEntity_image1()+ "' class=\"CToWUd\">");
							buffer.append("</a><u></u><u></u></p></td><td width=\"5\" valign=\"top\" rowspan=\"7\" style=\"width:8.75pt;padding:0cm\"></td>");
							col++;
							if(col % 3 == 0)
								buffer.append("</tr>");

						} catch (NoSuchDesignersImagesException
								| SystemException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}*/
				}

				/*if(sayDuck){

					buffer.append("<tr><td colspan=6 width=800 align=center><img src=\"http://ct-made-liferay-qa.s3.amazonaws.com/email-template/sayduck3.png\" width=800 height=275><br/>"
							+ "<a href=\"https://itunes.apple.com/us/app/made.com/id675560451?mt=8\"><img src=\"http://ct-made-liferay-qa.s3.amazonaws.com/email-template/appstore.png\" width=119 height=40></a>"
							+ "</td></tr>");

				}*/

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
					e.printStackTrace();
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			String footerVar = PortletProps.get("email.template.footer.variable");
			String footerTemplate = PortletProps.get(footerStore);

			//emailTemplate = emailTemplate.replace(data, buffer.toString());
			String cartListPlaceHolder = PortletProps.get("email.template.cart");
			String recoPlaceHolder = PortletProps.get("email.template.reco");


			emailTemplate = emailTemplate.replace(cartListPlaceHolder, buffer.toString());
			emailTemplate = emailTemplate.replace(recoPlaceHolder, recoBuffer.toString());
			emailTemplate = emailTemplate.replace(footerVar, footerTemplate);

			/*if(cartList.size()!=0){
				//MailUtil.sendEmail(emailAddress, emailTemplate);
				long storeDevId = CommonUtil.getStoreIdForDevice(session);
				MailUtil.sendEmail(emailAddress, emailTemplate, Long.toString(storeDevId));
			}*/
			Date sendMailDate = null;
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
				Impressions impressions = ImpressionsLocalServiceUtil.addToImpressions(ImpressionTypes.EMAIL_NOTIFICATION.getValue(), emailAddress, ImpressionTypes.SEND_MAIL.getValue(),loginUser,
						Long.toString(themeDisplay.getCompanyId()),
						PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
						deviceName,deviceType,deviceWidth,browserName,storeId);

				if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressions != null){
					impressions.setStaffId(session.getAttribute("LOGINSTAFF").toString());
					ImpressionsLocalServiceUtil.updateImpressions(impressions);
				}
				sendMailDate =  impressions.getCreateDate();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
				
				Map<String, String> salesAssociateTags = new HashMap<String, String>() ;
				/*if(Validator.isNotNull(session.getAttribute(Constants.SALES_ASSOCIATE_LIST))){
					salesAssociateTags = (HashMap<String, String>) session.getAttribute(Constants.SALES_ASSOCIATE_LIST);				
					
				}*/
				
				MailUtil.sendEmail(emailAddress, emailTemplate, timeStamp, multistoreCategory.toString(), salesAssociateTags);
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
		}
		else if (cmd.equalsIgnoreCase("imageImpression")) {

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


		}
		return;
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
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}
