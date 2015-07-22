package com.cloud.tags.portlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;
import org.imgscalr.Scalr;

import com.cloud.tags.NoSuchDesignersImagesException;
import com.cloud.tags.common.CommonUtil;
import com.cloud.tags.common.ReadCSV;
import com.cloud.tags.common.RestClientUtil;
import com.cloud.tags.common.S3Util;
import com.cloud.tags.model.Designers;
import com.cloud.tags.model.DesignersImages;
import com.cloud.tags.service.DesignersImagesLocalServiceUtil;
import com.cloud.tags.service.DesignersLocalServiceUtil;
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
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

/**
 * @author Azam
 * Portlet implementation class CloudTagsController
 * This controller class is used when the products feed is added to portal
 */
public class CloudTagsController extends MVCPortlet {

	
	private final static Logger _log = Logger
			.getLogger(CloudTagsController.class.getName());
	
	/**
	 * method for initializing any logic as per JSR 286 spec
	 */
	@Override
	public void init() throws PortletException {
		super.init();
	}
	
	/**
	 * This method is for reading the form data from the entities page and store the values into the database
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void addDesigner(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {


		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil
				.getUploadPortletRequest(actionRequest);
		String name = ParamUtil.getString(uploadPortletRequest, "name");
		String description = ParamUtil.getString(uploadPortletRequest,
				"description");
		String price = ParamUtil.getString(uploadPortletRequest, "price");
		String show_url = ParamUtil.getString(uploadPortletRequest, "show_url");
		Designers designers =null;
		try {
			 designers = DesignersLocalServiceUtil
					.addDesigners(name, description, price,show_url,
							themeDisplay.getUserId(),
							themeDisplay.getCompanyId(),
							themeDisplay.getScopeGroupId());
			 
			 designers.setSlug(themeDisplay.getPortalURL() + "/designers?designId=" + designers.getDesignId());
			 designers = DesignersLocalServiceUtil.updateDesigners(designers);
			 
			// DesignersImagesLocalServiceUtil.createDesignersImages(designers.getDesignId(),
			// entity_image1, entity_image2, entity_image3, entity_image4);

		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		String[] images = new String[4];
		 
		String smallImageURL ="";
		
		for (int i = 1; i <= 4; i++) {
			
			File entity_image = uploadPortletRequest
					.getFile("entity_image" + i);
			String contentType = uploadPortletRequest
					.getContentType("entity_image" + i);
			
			
			String image_name = uploadPortletRequest.getFileName("entity_image"
					+ i);
			
			String relativepath = "uploads"
					+ StringPool.SLASH + "designers"+ StringPool.SLASH + themeDisplay.getScopeGroupId()+ StringPool.SLASH + "entity_image"
					+ i + StringPool.SLASH + designers.getDesignId() + StringPool.SLASH
					+ image_name;
			if (entity_image.length() > 0) {
				
				
				S3Util.uploadToS3(entity_image, contentType, relativepath);
				
				images[i-1] = PortletProps.get("s3.image.url") + PortletProps.get("aws.bucket") +  StringPool.SLASH + relativepath;
				
				if(i==1) {
					/*File thumbnail =  CommonUtil.getThumbnail(entity_image, contentType);
					
					String thumnailPath = "uploads"
							+ StringPool.SLASH + "designers"+ StringPool.SLASH + themeDisplay.getScopeGroupId()+ StringPool.SLASH + "entity_image"
							+ i + StringPool.SLASH + designers.getDesignId() + StringPool.SLASH +"thumb"+StringPool.SLASH 
							+ image_name;
					S3Util.uploadToS3(thumbnail, contentType, thumnailPath );
					smallImageURL = PortletProps.get("s3.image.url") + PortletProps.get("aws.bucket") +  StringPool.SLASH + thumnailPath;*/
				}
				
			}

		}
		
		try {
			
			DesignersImages designersImages =  DesignersImagesLocalServiceUtil.createDesignersImages(designers.getDesignId(), images[0], images[1], images[2], images[3]);
			designersImages.setSmall_image_url(smallImageURL);
			
			System.out.println(designersImages);
			DesignersImagesLocalServiceUtil.updateDesignersImages(designersImages);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
		
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
						portletName, themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);
		
		redirectURL.setParameter("jspPage",viewTemplate);
		
		actionResponse.sendRedirect(redirectURL.toString());

	}
	
	
	
	/**
	 * This method is used to read the CSV file uploaded from the entities page
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void uploadCSV(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		System.out.println("I ma inside the upload CSV thinsg");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil
				.getUploadPortletRequest(actionRequest);
		File csvFile = uploadPortletRequest
				.getFile("csvfile");
		
		
		/*ReadCSV.parseCSV(csvFile,themeDisplay.getUserId(),
				themeDisplay.getCompanyId(),
				themeDisplay.getScopeGroupId(),themeDisplay.getPortalURL());*/
		
		try {
			ReadCSV.parseTempTable(themeDisplay.getCompanyId(),themeDisplay.getUserId(),themeDisplay.getScopeGroupId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ReadCSV.parseDumpDataCSV(csvFile, themeDisplay.getCompanyId());
		//ReadCSV.updateShortURLDumpDataCSV(csvFile, themeDisplay.getCompanyId());
		
		
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
						portletName, themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);
		
		redirectURL.setParameter("jspPage",viewTemplate);
		
		actionResponse.sendRedirect(redirectURL.toString());
	}
	
	public void generateProductionShortURL(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, NoSuchDesignersImagesException {

		System.out.println("I ma inside the upload CSV thinsg");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		
			try {
				List<Designers> designers = DesignersLocalServiceUtil.getDesignerses(0, DesignersLocalServiceUtil.getDesignersesCount());
				for(Designers desgn : designers){
					if(Validator.isNotNull(desgn)){
					String entityImage1 = StringPool.BLANK;
					DesignersImages designerImages = DesignersImagesLocalServiceUtil.getByDesignId(desgn.getDesignId());
						if(Validator.isNotNull(designerImages)){
							entityImage1= URLEncoder.encode(designerImages.getEntity_image1(),"UTF-8");
						}
					if(desgn.getCtapp_shorturl() && !desgn.getCtapp_shorturl_success()){
						//if(desgn.getDesignId() > 2341){

						/* Modified by viji to remove duplicate +"%26from=NFC" - 23-jan-2015 */
						//String urlStr = "http://ctapp.herokuapp.com/api/v1/short_urls_lr/md?token=mdLiferay&url=http://made.cloudtags.com:9090/designers?designId="+desgn.getDesignId()+"%26from=NFC"+"%26from=NFC&product_name="+URLEncoder.encode(desgn.getProductTitle(),"UTF-8")+"&product_image_1="+entityImage1+"&product_sku="+desgn.getBarcode();
						String urlStr = "http://ctapp.herokuapp.com/api/v1/short_urls_lr/md?token=mdLiferay&url=http://made.cloudtags.com:9090/designers?designId="+desgn.getDesignId()+"%26from=NFC&product_name="+URLEncoder.encode(desgn.getProductTitle(),"UTF-8")+"&product_image_1="+entityImage1+"&product_sku="+desgn.getBarcode();

						//String urlStr = "http://ctapp.herokuapp.com/api/v1/short_urls_lr/md?token=mdLiferay&url=http://cloudtags.com";
						String response = RestClientUtil.httpGet(urlStr);
						System.out.println(desgn.getDesignId()+"<<<<<"+urlStr+">>>>>>>"+response);
						if(Validator.isNotNull(response) && response.equalsIgnoreCase("true")){
							desgn.setCtapp_shorturl_success(true);
							DesignersLocalServiceUtil.updateDesigners(desgn);
						}
						//}
					}
					
				}
				}
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
						portletName, themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);
		
		redirectURL.setParameter("jspPage",viewTemplate);
		
		actionResponse.sendRedirect(redirectURL.toString());
	}
	
	/**
	 * During the edit of the product from entities page we need to update the information
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void editProduct(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		
		//Add the logic to update records
		
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil
				.getUploadPortletRequest(actionRequest);
		String name = ParamUtil.getString(uploadPortletRequest, "name");
		String description = ParamUtil.getString(uploadPortletRequest,
				"description");
		String price = ParamUtil.getString(uploadPortletRequest, "saleprice");
		String public_url = ParamUtil.getString(uploadPortletRequest, "public_url");
		Designers designers =null;
		DesignersImages designersImages = null;
		long designId = ParamUtil.getLong(uploadPortletRequest, "designId");
		System.out.println("I am in edit man>>>>>>>>>>>>>>"+designId);
		try {
			designers = DesignersLocalServiceUtil.getDesigners(designId);
			designers.setName(name);
			designers.setDescription(description);
			designers.setModifiedDate(new Date());
			designers.setSaleprice(price);
			designers.setPublic_url(public_url);
			
			designers = DesignersLocalServiceUtil.updateDesigners(designers);
			designersImages = DesignersImagesLocalServiceUtil.getByDesignId(designId);
			String[] images = new String[4];
			
			
			for (int i = 1; i <= 4; i++) {
				
				File entity_image = uploadPortletRequest
						.getFile("entity_image" + i);
				
				
				String contentType = uploadPortletRequest
						.getContentType("entity_image" + i);
				
				String image_name = uploadPortletRequest.getFileName("entity_image"
						+ i);
				System.out.println("entity_image>>"+entity_image.getPath());
				
				
				String relativepath = "uploads"
						+ StringPool.SLASH + "designers"+ StringPool.SLASH + themeDisplay.getScopeGroupId()+ StringPool.SLASH + "entity_image"
						+ i + StringPool.SLASH + designers.getDesignId() + StringPool.SLASH
						+ image_name;
				
				System.out.println("relativepath>>"+relativepath);

				if (entity_image.length() > 0) {
					BufferedImage originalImage = ImageIO.read(entity_image);
					int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
			 
					//BufferedImage resizeImageJpg = CommonUtil.resizeImage(originalImage, type,525,250);
					BufferedImage resizeImageJpg =Scalr.resize(
							originalImage, 
							Scalr.Method.QUALITY, 
							Scalr.Mode.FIT_EXACT,
							600, 
							300, 
							Scalr.OP_ANTIALIAS);
					
					
					URL url = new URL("http://localhost:9090/"+relativepath);
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					connection.setDoOutput(true);

					// Do necessary setup of connection, like:
					//  - setting the HTTP method (POST/PUT)
					//  - setting authentication parameters?
					// These depends on what kind of service you have running on localhost:8080

					OutputStream stream = connection.getOutputStream();
					try {
					    ImageIO.write(resizeImageJpg, "jpg", stream);
					}
					finally {
					    stream.close();
					}
					
					S3Util.uploadToS3(entity_image, contentType, relativepath);	
					
					images[i-1] = PortletProps.get("s3.image.url") + PortletProps.get("aws.bucket") +  StringPool.SLASH + relativepath;
					
					switch (i){
						case 1: designersImages.setEntity_image1(images[i-1]);
								break;
						case 2: designersImages.setEntity_image2(images[i-1]);
								break;
						case 3: designersImages.setEntity_image3(images[i-1]);
								break;
						case 4: designersImages.setEntity_image4(images[i-1]);
								break;
						default: break;
					}
					
					
				}
				

			}
			
			DesignersImagesLocalServiceUtil.updateDesignersImages(designersImages);
			
			
		} catch (PortalException e) {
			_log.error(e.getMessage());
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
		
	}
	
	/***
	 * Update Designers isactive field
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void updateDesignerActive(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		ReadCSV.updateActiveField(themeDisplay.getCompanyId(),themeDisplay.getUserId(),themeDisplay.getScopeGroupId());
	}
	
	/**
	 * method for rendering from one phase to another as per JSR 286 spec
	 */
	
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		super.render(request, response);
	}
	
	/**
	 * This method is to manage the RenderRequest and RenderResponse 
	 */
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		String cmd = ParamUtil.getString(renderRequest, "CMD");
		long designId = ParamUtil.getLong(renderRequest, "designId");
		if(cmd.equalsIgnoreCase("delete")){
			try{
				DesignersLocalServiceUtil.deleteDesigners(designId);
				DesignersImages designersImages = DesignersImagesLocalServiceUtil.getByDesignId(designId);
				DesignersImagesLocalServiceUtil.deleteDesignersImages(designersImages);
				
			}catch(Exception e){
				_log.error(e.getMessage());
			}
			
		} if(cmd.equalsIgnoreCase("generateTinyURL")) {
			try{
				
				Designers designers = DesignersLocalServiceUtil.getDesigners(designId);
				
				String tinyURL = CommonUtil.getTiyURL(designers.getPublic_url(), PortletProps.get("bitly.login.id"), PortletProps.get("bitly.login.key"));
				designers.setShort_url(tinyURL);
				designers =DesignersLocalServiceUtil.updateDesigners(designers);
			}catch(Exception e){
				_log.error(e.getMessage());
			}
			
		}
		super.doView(renderRequest, renderResponse);
		
	}
	/**
	 * destroy method for any cleanup as per JSR 286 spec
	 */
	@Override
	public void destroy() {
		super.destroy();
	}
	
	
}
