package com.cloud.tags.common;

import static com.rosaloves.bitlyj.Bitly.as;
import static com.rosaloves.bitlyj.Bitly.shorten;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.imgscalr.Scalr;

import com.cloud.tags.common.util.Constants;
import com.cloud.tags.model.Carts;
import com.cloud.tags.model.CartsDesigners;
import com.cloud.tags.model.Designers;
import com.cloud.tags.model.Impressions;
import com.cloud.tags.model.StoreDeviceMap;
import com.cloud.tags.service.CartsDesignersLocalServiceUtil;
import com.cloud.tags.service.CartsLocalServiceUtil;
import com.cloud.tags.service.DesignersLocalServiceUtil;
import com.cloud.tags.service.ImpressionsLocalServiceUtil;
import com.cloud.tags.service.StoreDeviceMapLocalServiceUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;
import com.rosaloves.bitlyj.Url;
/**
 * 
 * @author Mohammed Zaheer
 *
 */
public class CommonUtil {
	private static Log _log = LogFactoryUtil.getLog(CommonUtil.class);

	public static File getThumbnail(File file, String contentType) {
		byte[] bytes = null;
		ImageBag imageBag = null;

		if (Validator.isNull(file))
			return null;

		try {
			imageBag = ImageToolUtil.read(file);
		} catch (IOException e) {
			_log.debug("Error while reading file");
		}
		if (Validator.isNull(imageBag))
			return null;

		RenderedImage renderedImage = imageBag.getRenderedImage();

		long height = 250; // Math.round(image.getHeight() * reduceBy);
		long width = 250;// Math.round(image.getWidth() * reduceBy);
		renderedImage = ImageToolUtil.scale(renderedImage, (int) height,
				(int) width);
		try {
			bytes = ImageToolUtil.getBytes(renderedImage, contentType);
		} catch (IOException e) {
			_log.debug("Error while converting to bytes");
		}
		File thumbnailfile = null;
		try {
			thumbnailfile = FileUtil.createTempFile(bytes);
		} catch (IOException e) {
			_log.debug("Unable to create file");
		}

		return thumbnailfile;
	}

	public static String getThumnail(String path, long designId, long groupId) {

		String smallImageURL = StringPool.BLANK;

		try {
			URL url = new URL(path);
			URLConnection conn = url.openConnection();
			InputStream in =  conn.getInputStream();			
			File file = FileUtil.createTempFile(in);

			String thumnailPath = "uploads1" + StringPool.SLASH + "designers"
					+ StringPool.SLASH + groupId + StringPool.SLASH
					+ "entity_image1" + StringPool.SLASH + designId
					+ StringPool.SLASH + "thumb" + StringPool.SLASH
					+ getFileName(path);

			String contentType = URLConnection.guessContentTypeFromStream(in);
			file = getThumbnail(file, contentType);
			S3Util.uploadToS3(file, contentType, thumnailPath);

			smallImageURL = PortletProps.get("s3.image.url")
					+ PortletProps.get("aws.bucket") + StringPool.SLASH
					+ thumnailPath;

		} catch (MalformedURLException e) {
			_log.debug("Error while reading image from URL ");

		} catch (IOException e) {
			_log.debug("Error while reading image from URL ");

		}

		System.out.println("smallImageURL"+smallImageURL);
		return smallImageURL;
	}

	public static String getFileName(String url) {
		String fileName;
		int slashIndex = url.lastIndexOf("/");
		int qIndex = url.lastIndexOf("?");
		if (qIndex > slashIndex) {// if has parameters
			fileName = url.substring(slashIndex + 1, qIndex);
		} else {
			fileName = url.substring(slashIndex + 1);
		}
		if (fileName.contains(".")) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}

		return fileName;
	}


	public static String getTiyURL(String longURL,String loginId, String apiKey){

		String tinyURL = "";
		try{
			Url url = as(loginId, apiKey).call(shorten(longURL));
			tinyURL = url.getShortUrl();
		}catch(Exception e){
			_log.error("could not get the short URL"+e.getMessage());
		}
		return tinyURL;

	}

	public static long getUserByEmail(String emailAddress,long companyId){

		long userId = 0l;

		try{

			userId = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress).getUserId();

		}catch(NoSuchUserException nse){
			_log.warn("No user exits create new"+nse.getMessage());
			try {

				User user =  UserLocalServiceUtil.addUser(
						0l, 				// creatorUserId
						companyId,		 	// companyId
						true,			 	// autoPassword
						"", 				// password1,
						"", 				// password2,
						true, 				// autoScreenName,
						"", 			// screnName,
						emailAddress, 				// need to check how to update thisemailAddress,
						0l, 				// facebookId,
						"", 				// openId,
						Locale.getDefault(),//locale
						emailAddress, 			// firstName,
						"", 		// middleName,
						"", 			// lastName,
						0, 					// prefixId,
						0, 					// suffixId,
						true,				// male,
						1, 					// birthdayMonth,
						1, 					// birthdayDay,
						1970, 				// birthdayYear,
						"",  				// jobTitle,
						null,				// groupIds,
						null,				// organizationIds,
						null,				// roleIds,
						null,				// userGroupIds,
						true, 				// sendEmail,
						new ServiceContext());
				//ElasticIndexUtil.indextDataToElasticSearch(user, "user", "userdetails");

				userId = user.getUserId();
			} catch (PortalException e) {
				e.printStackTrace();
				_log.warn("No user exits create new"+e.getMessage());
			} catch (SystemException e) {
				e.printStackTrace();
				_log.warn("No user exits create new"+e.getMessage());
			}

		} catch (PortalException e) {
			_log.warn("No user exits create new"+e.getMessage());
		} catch (SystemException e) {
			_log.warn("No user exits create new"+e.getMessage());
		}

		_log.info("User object"+userId);

		return userId;

	}

	public static long getUserByEmail(String emailAddress,long companyId,HttpSession session){

		long userId = 0l;

		try{

			userId = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress).getUserId();

		}catch(NoSuchUserException nse){
			_log.warn("No user exits create new"+nse.getMessage());
			try {

				User user =  UserLocalServiceUtil.addUser(
						0l, 				// creatorUserId
						companyId,		 	// companyId
						true,			 	// autoPassword
						"", 				// password1,
						"", 				// password2,
						true, 				// autoScreenName,
						"", 			// screnName,
						emailAddress, 				// need to check how to update thisemailAddress,
						0l, 				// facebookId,
						"", 				// openId,
						Locale.getDefault(),//locale
						emailAddress, 			// firstName,
						"", 		// middleName,
						"", 			// lastName,
						0, 					// prefixId,
						0, 					// suffixId,
						true,				// male,
						1, 					// birthdayMonth,
						1, 					// birthdayDay,
						1970, 				// birthdayYear,
						"",  				// jobTitle,
						null,				// groupIds,
						null,				// organizationIds,
						null,				// roleIds,
						null,				// userGroupIds,
						true, 				// sendEmail,
						new ServiceContext());
				//ElasticIndexUtil.indextDataToElasticSearch(user, "user", "userdetails");

				userId = user.getUserId();
				session.setAttribute("NEWUSER", "yes");
			} catch (PortalException e) {
				e.printStackTrace();
				_log.warn("No user exits create new"+e.getMessage());
			} catch (SystemException e) {
				e.printStackTrace();
				_log.warn("No user exits create new"+e.getMessage());
			}

		} catch (PortalException e) {
			_log.warn("No user exits create new"+e.getMessage());
		} catch (SystemException e) {
			_log.warn("No user exits create new"+e.getMessage());
		}

		_log.info("User object"+userId);

		return userId;

	}

	/**
	 * 
	 * @param originalImage
	 * @param type
	 * @param IMG_WIDTH
	 * @param IMG_HEIGHT
	 * @return
	 */
	@SuppressWarnings("unused")
	public static String multiDimensions(String path, long designerId, long companyId, boolean isFirstImage){


		String productImageURL = StringPool.BLANK;

		try {
			if(!path.trim().equalsIgnoreCase("")){
				URL url = new URL(path);
				URLConnection conn = url.openConnection();

				InputStream in =  conn.getInputStream();

				File file = FileUtil.createTempFile(in);

				String thumnailPath = "uploads1" + StringPool.SLASH + "designers"
						+ StringPool.SLASH +"images"+ StringPool.SLASH+ designerId
						+ StringPool.SLASH 
						+"600x400"+StringPool.SLASH+ getFileName(path)+".jpg";

				String contentType = "image/jpeg";
				System.out.println("************************************"+contentType);
				File fileMain = getImageWithDimensions(file, contentType, 600, 400,thumnailPath );			
				S3Util.uploadToS3(fileMain, contentType, thumnailPath);
				
				String smallPathCar = "uploads1" + StringPool.SLASH + "designers"
						+ StringPool.SLASH +"images"+ StringPool.SLASH+ designerId
						+ StringPool.SLASH
						+"100x70"+StringPool.SLASH+getFileName(path)+".jpg";

				File fileSma = getImageWithDimensions(file, contentType, 100, 70,smallPathCar);
				S3Util.uploadToS3(fileSma, contentType, smallPathCar);
				
				fileSma.delete();
				fileMain.delete();
				productImageURL = PortletProps.get("s3.image.url")
						+ PortletProps.get("aws.bucket") + StringPool.SLASH
						+ thumnailPath;
			
				if(isFirstImage){
					String smallPath = "uploads1" + StringPool.SLASH + "designers"
							+ StringPool.SLASH +"images"+ StringPool.SLASH+ designerId
							+ StringPool.SLASH
							+"500x500"+StringPool.SLASH+getFileName(path)+".jpg";

					File fileReco = getImageWithDimensions(file, contentType, 500, 500,getFileName(path)+".jpg");					
					S3Util.uploadToS3(fileReco, contentType, smallPath);
					
					String emailPath = "uploads1" + StringPool.SLASH + "designers"
							+ StringPool.SLASH +"images"+ StringPool.SLASH+ designerId
							+ StringPool.SLASH
							+"200x200"+StringPool.SLASH+getFileName(path)+".jpg";

					File fileEmail = getImageWithDimensions(file, contentType, 200, 200,getFileName(path)+".jpg");					
					S3Util.uploadToS3(fileEmail, contentType, emailPath);
					
					fileEmail.delete();
					fileReco.delete();
				}
				
				file.delete();				
				in.close();
			}


		} catch (MalformedURLException e) {
			_log.debug("Error while reading image from URL ");

		} catch (IOException e) {
			_log.debug("Error while reading image from URL ");

		}

		System.out.println("productImageURL"+productImageURL);
		return productImageURL;


	}
	/**
	 * 
	 * @param file
	 * @param contentType
	 * @param height
	 * @param width
	 * @return
	 */
	public static File getImageWithDimensions(File file, String contentType,int height,int width, String name) {


		BufferedImage originalImage = null;
		try {
			originalImage = ImageIO.read(file);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		BufferedImage resizeImageJpg =Scalr.resize(
				originalImage, 
				Scalr.Method.QUALITY, 
				Scalr.Mode.AUTOMATIC,
				height, 
				width, 
				Scalr.OP_ANTIALIAS);
		//File thumbnailfile = new File("C:\\Zaheer\\Cloudtags\\Imagetesting\\images\\"+file.getName()+".jpg");
		//File thumbnailfile = new File("/home/zaheer_july_14/madePlatform/liferay-portal-6.2.0-ce-ga1/AWS-Images/"+file.getName()+".jpg");
		File thumbnailfile = new File("/opt/apps/liferayapp/images/"+file.getName()+".jpg");

		try {
			ImageIO.write(resizeImageJpg, "jpg",thumbnailfile );

			//thumbnailfile = new File("C:\\Zaheer\\Cloudtags\\Imagetesting\\images\\"+file.getName());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 



		return thumbnailfile;
	}
	public static String getTabCurrent(String path,  boolean isTabcurrent){
		String imageUrl = path;
		String awsURI = PortletProps.get("s3.image.url")
				+ PortletProps.get("aws.bucket");
		String tabCurrentURL = PortletProps.get("tablet.current.url");
		if(isTabcurrent){
			imageUrl = imageUrl.replace(awsURI, tabCurrentURL);
		}else{
			return imageUrl;
		}
		return imageUrl;

	}
	public static Map<Long, CartsDesigners> mergelikedAdded(Map<Long, CartsDesigners> liked, Map<Long, CartsDesigners> added) {
		Map<Long, CartsDesigners> marsterMap = new HashMap<Long, CartsDesigners>();
		long i=1;
		for(CartsDesigners cartDesigner : liked.values()){
			marsterMap.put(i, cartDesigner);
			i++;
		}
		for (CartsDesigners cartDesigner : added.values()) {
			if (!liked.containsValue(cartDesigner)) {	           
				marsterMap.put(i,cartDesigner);
				i++;
			} 
		}
		return marsterMap;
	}
	public static String getCartId(long designerId, Map<Long, CartsDesigners> marsterMap,HttpSession session) {		
		String catId=StringPool.BLANK;
		for(CartsDesigners cartDesigner : marsterMap.values()){
			if(cartDesigner.getDesignId() == designerId){
				catId = session.getAttribute("CARTID").toString();
				System.out.println("<><><>>>>>>>>>>>>>>>>>>>>>>>"+cartDesigner.getCartDesignerId());
				break;				
			}

		}

		return catId;
	}
	/***
	 * Gets store device map id for the mac address of the device.
	 * Returns zero if there is no mapping info for store and device
	 * @param session
	 * @return store device map id
	 */
	public static long getStoreIdForDevice(HttpSession session){
		//_log.info("getStoreIdForDevice(HttpSession session) Start");
		long storeDevMapId = 0;
		String deviceMacAddress = "";
		if(Validator.isNotNull(session.getAttribute("deviceMacAddress"))){
			deviceMacAddress = (String) session.getAttribute("deviceMacAddress");
			System.out.println("Device Mac Address in getStoreIdForDevice : "+deviceMacAddress);
		}
		storeDevMapId = getStoreIdForDevice(deviceMacAddress);

		//_log.info("getStoreIdForDevice(HttpSession session) End");
		return storeDevMapId;

	}

	/***
	 * 
	 * Gets store device map id for given mac address 
	 * @param deviceMacAddress
	 * @return store device map id
	 */
	public static long getStoreIdForDevice(String deviceMacAddress){
		//_log.info("getStoreIdForDevice(String deviceMacAddress) Start");
		long storeId = 0;
		if(deviceMacAddress != null && !deviceMacAddress.isEmpty()){
			List<StoreDeviceMap> storeDevicesForMac = null;
			try {
				storeDevicesForMac = StoreDeviceMapLocalServiceUtil.findByDevice(deviceMacAddress);
			} catch (SystemException e) {
				_log.error(e.getMessage());
			}
			if(storeDevicesForMac != null && storeDevicesForMac.size() > 0)
				storeId = storeDevicesForMac.get(0).getUuid();
		}
		//_log.info("getStoreIdForDevice(String deviceMacAddress) End");
		return storeId;
	}

	/***
	 * Returns storeName for given store device map id.
	 * In case of exception or no info returns empty string
	 * @param storeDevMapId
	 * @return store name as string
	 */
	public static String getStoreName(long storeDevMapId) {
		String storeName = "";

		try {
			StoreDeviceMap storeDevMap = StoreDeviceMapLocalServiceUtil.getStoreDeviceMap(storeDevMapId);
			if(Validator.isNotNull(storeDevMap))
				storeName = storeDevMap.getStoreName();
		} catch (PortalException | SystemException e) {
			_log.error(e.getMessage());
		}

		return storeName;
	}

	public static String getSubjectTimeStamp(Date date, String emailAddress, HttpSession session){
		System.out.println("Date : "+date);
		SimpleDateFormat dateFormatter = new SimpleDateFormat(" MMMM d, yyyy hh:mm a");
		//String timeZone = PortletProps.get("timezone");

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Impressions.class);
		Criterion criteria = RestrictionsFactoryUtil.eq("impressionId",emailAddress);
		criteria = RestrictionsFactoryUtil.and(criteria, RestrictionsFactoryUtil.eq("impressionAction", "SENDMAIL"));

		dynamicQuery.add(criteria)
		.addOrder(OrderFactoryUtil.desc("createDate"));

		boolean flag = false;

		String timeStamp = "";

		try {
			List<Impressions> impressions = ImpressionsLocalServiceUtil.dynamicQuery(dynamicQuery);
			Date emailDate;
			//ignoring the recent impression which will at position 1
			if(impressions != null &&  impressions.size() > 1){
				//System.out.println("impressions : "+impressions );

				emailDate = impressions.get(1).getCreateDate();
				_log.info("Date : "+emailDate);

				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				String s1 = sdf.format(date);
				String s2 = sdf.format(emailDate);
				_log.info("s1 : "+s1 +" "+s2);
				if(sdf.format(date).equals(sdf.format(emailDate)))
					flag = true;
			}			

		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		if(flag){
			//TimeZone zone = TimeZone.getTimeZone(timeZone); 
			//dateFormatter.setTimeZone(zone);
			timeStamp = dateFormatter.format(date);
		}
		return timeStamp;
	}

	/***
	 * Checks the email address is entered by the user first time
	 * - sets email as owner email if first_email is not set
	 * - else sets the email as friend email
	 * 
	 * @param session
	 * @param emailAddress
	 * @param companyId
	 * @return owner userId
	 */
	public static long getOwnerUserId(HttpSession session,
			String emailAddress, long companyId){

		if(Validator.isNull(session.getAttribute(Constants.FIRST_EMAIL)) || 
				session.getAttribute(Constants.FIRST_EMAIL).toString().isEmpty()){

			session.setAttribute(Constants.FIRST_EMAIL, emailAddress);					
		}else{
			session.setAttribute(Constants.FRIEND_EMAIL, emailAddress);
		}

		long userId = CommonUtil.getUserByEmail(
				session.getAttribute(Constants.FIRST_EMAIL).toString(), companyId);

		return userId;

	}

	public static HashMap<Long, CartsDesigners> addToCart(long productId, HttpSession session, ThemeDisplay themeDisplay,HttpServletRequest originalRequest){

		_log.info("Insided added cart");

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

		//long productId = ParamUtil.getLong(uploadPortletRequest, "productId");

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
			cartList.put(productId, designers);
			session.setAttribute("LIFERAY_SHARED_CARTLIST", cartList);

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
							originalRequest.getRemoteAddr(),
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
						System.out.println("In commonutil add cart designers : " +cartsDesigners.getCartDesignerId() +" "+staffId);
						//add / update sales associate tag
						Map<String, String> salesAssociates = null;

						/*String staffTag = Constants.SALES_ASS_TAG_PREFIX + staffId;
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
							originalRequest.getRemoteAddr(),
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


		return (HashMap<Long, CartsDesigners>) session
				.getAttribute("LIFERAY_SHARED_CARTDESIGNERS");
	}


	public static String sendMandrillMail(Date date, String emailAddress, HttpSession session){

		return "";
	}

	public static String getCartProducts(HashMap<Long, Designers> cartList){
		String productIds = StringPool.BLANK;
		if(cartList != null){
			for(Long productId : cartList.keySet()){
				productIds += productId.toString() + ",";
			}
		}

		return productIds;
	}

	public static boolean showWOW(HttpSession session){
		boolean showWow = false;
		int cnt = 4;
		if (Validator.isNotNull(session.getAttribute("LIFERAY_SHARED_CARTLIST"))) {
			HashMap<Long, Designers> cartList = (HashMap<Long, Designers>) session
					.getAttribute("LIFERAY_SHARED_CARTLIST");
			if(cartList != null && cartList.size() > 1){
				if((cartList.size() % 3) == 1 )
					showWow = true;
			}
		}
		return showWow;
	}
	
	public static String getStaffList(HttpSession session){
		String staffList = StringPool.BLANK;
		if(Validator.isNotNull(session.getAttribute(Constants.SALES_ASSOCIATES_LIST))){
			List<String> salesAssociates = (List<String>) session.getAttribute(Constants.SALES_ASSOCIATES_LIST);		
			if(salesAssociates != null){
				for(String salesAssociate : salesAssociates){
					staffList += salesAssociate + ",";
				}
				if(staffList.length() > 0)
					staffList = staffList.substring(0, staffList.length()-1);
			}

		}
		return staffList; 
	}
}
