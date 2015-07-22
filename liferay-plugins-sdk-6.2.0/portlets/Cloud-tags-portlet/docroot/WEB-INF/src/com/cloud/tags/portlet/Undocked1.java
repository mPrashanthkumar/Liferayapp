package com.cloud.tags.portlet;

import java.io.IOException;
import java.util.UUID;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cloud.tags.common.CommonUtil;
import com.cloud.tags.common.ImpressionTypes;
import com.cloud.tags.model.Impressions;
import com.cloud.tags.service.ImpressionsLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * @author Mohammed Zaheer
 * Portlet implementation class Undocked1
 * 
 */
public class Undocked1 extends MVCPortlet {

	private final static Logger _log = Logger
			.getLogger(Undocked.class.getName());

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

		HttpServletRequest httpServletRequest =  PortalUtil.getHttpServletRequest(resourceRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String cmd = ParamUtil.getString(uploadPortletRequest, "CMD");

		String actualSessionUserId =  Long.toString(themeDisplay.getUserId());
		if(Validator.isNotNull(session.getAttribute("USERLOGIN-ID"))){
			_log.info("USERLOGIN-ID");
			actualSessionUserId = httpServletRequest.getSession().getAttribute("USERLOGIN-ID").toString();
		}

		String loginUser = StringPool.BLANK;
		if(Validator.isNotNull(session.getAttribute("LOGIN-USER"))){
			loginUser = session.getAttribute("LOGIN-USER").toString();										
		}

		/*if(cmd.equals("USELOGIN")){
			String emailAddress = uploadPortletRequest.getParameter("email");
			_log.info("Welcome to User Login >>>>>>>>>"+emailAddress);	
			long userId = CommonUtil.getUserByEmail(emailAddress, themeDisplay.getCompanyId(),session);
			session.setAttribute("USERLOGIN-ID", emailAddress);

		}else */
		if(cmd.equals("MACADDRESS")){
			//Added by viji  - start
			String deviceMacAddress = ParamUtil.getString(uploadPortletRequest, "macAddress");			
			
			session.setAttribute("deviceMacAddress", deviceMacAddress);
			
			_log.info("deviceMacAddress>>>>>>>>>>"+deviceMacAddress);
			long storeId = CommonUtil.getStoreIdForDevice(deviceMacAddress);
			if(Validator.isNotNull(session.getAttribute("UNDOCKIMPRESS-ID")) && Validator.isNotNull(session.getAttribute("USERIMPRESS-ID"))){
				
				try {
					Impressions imp = ImpressionsLocalServiceUtil.getImpressions(Long.parseLong(session.getAttribute("UNDOCKIMPRESS-ID").toString()));
					imp.setStoreDeviceId(storeId);
					ImpressionsLocalServiceUtil.updateImpressions(imp);
					
					imp = ImpressionsLocalServiceUtil.getImpressions(Long.parseLong(session.getAttribute("USERIMPRESS-ID").toString()));
					imp.setStoreDeviceId(storeId);
					ImpressionsLocalServiceUtil.updateImpressions(imp);
					session.removeAttribute("UNDOCKIMPRESS-ID");
					session.removeAttribute("USERIMPRESS-ID");
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			//end
		}else if(cmd.equals("UNDOCKED")){
			_log.info("FROM  UNDOCKED");
			String deviceName = ParamUtil.getString(uploadPortletRequest, "deviceName");
			String deviceType = ParamUtil.getString(uploadPortletRequest, "deviceType");
			String browserName = ParamUtil.getString(uploadPortletRequest, "browserName");
			String deviceWidth = ParamUtil.getString(uploadPortletRequest, "screenWidth");
			//String deviceMacAddress = ParamUtil.getString(uploadPortletRequest, "macAddress");			
			
			//session.setAttribute("deviceMacAddress", deviceMacAddress);
			
			//_log.info("deviceMacAddress>>>>>>>>>>"+deviceMacAddress);

			_log.info("deviceName>>>>>>>>>>1"+deviceName);
			_log.info("deviceType>>>>>>>>>>1"+deviceType);
			_log.info("browserName>>>>>>>>>>1"+browserName);
			_log.info("deviceWidth>>>>>>>>>>1"+deviceWidth);	
			
			if(Validator.isNull(session.getAttribute("DONTCLEARSESSION"))){						
				session.removeAttribute("LIFERAY_SHARED_CARTLIST");
				session.removeAttribute("LIFERAY_SHARED_CARTDESIGNERS");				
				session.removeAttribute("LOGINSTAFF");
				session.removeAttribute("CARTID");
				session.removeAttribute("FIRST-EMAIL");
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				UUID idOne = UUID.randomUUID();
				session.setAttribute("LOGIN-USER", idOne.toString());
			}
			
			String userId = StringPool.BLANK;
			if(Validator.isNotNull(session.getAttribute("LOGIN-USER")))
					userId = (String) session.getAttribute("LOGIN-USER");
			long storeId = CommonUtil.getStoreIdForDevice(session);
			try {

				Impressions impressions = ImpressionsLocalServiceUtil.addToImpressions(ImpressionTypes.USER.getValue(),actualSessionUserId,
						ImpressionTypes.LOGIN.getValue(),userId , Long.toString(themeDisplay.getCompanyId()),
						PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
						deviceName,deviceType,deviceWidth,browserName,storeId);
				session.setAttribute("USERIMPRESS-ID", impressions.getRecId());
				//loginUser = session.getAttribute("LOGIN-USER").toString();

				if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressions != null){
					impressions.setStaffId(session.getAttribute("LOGINSTAFF").toString());
					ImpressionsLocalServiceUtil.updateImpressions(impressions);
				}

				impressions = ImpressionsLocalServiceUtil.addToImpressions(ImpressionTypes.UNDOCKED.getValue(), actualSessionUserId, 
						ImpressionTypes.UNDOCKED.getValue(),userId , Long.toString(themeDisplay.getCompanyId()),
						PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
						deviceName,deviceType,deviceWidth,browserName,storeId);
				
				session.setAttribute("UNDOCKIMPRESS-ID", impressions.getRecId());
				
				if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressions != null){
					impressions.setStaffId(session.getAttribute("LOGINSTAFF").toString());
					ImpressionsLocalServiceUtil.updateImpressions(impressions);
				}

			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(cmd.equals("VALIDATEEMAIL")){
			System.out.println("Welcome to VALIDATEEMAIL");
			String emailAddress = uploadPortletRequest.getParameter("email");// ParamUtil.getString(resourceRequest,"email");
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
			
			_log.info("deviceName>>>>>>>>>>1"+deviceName);
			_log.info("deviceType>>>>>>>>>>1"+deviceType);
			_log.info("browserName>>>>>>>>>>1"+browserName);
			_log.info("deviceWidth>>>>>>>>>>1"+deviceWidth);	

			System.out.println("I am here with email address" + emailAddress);
			session.setAttribute("FIRST-EMAIL", emailAddress);

			long emailUserId = CommonUtil.getUserByEmail(emailAddress, themeDisplay.getCompanyId());
			
			session.setAttribute("FIRST-LOGIN-USER", emailUserId);
			String userId = StringPool.BLANK;
			if(Validator.isNotNull(session.getAttribute("LOGIN-USER")))
					userId = (String) session.getAttribute("LOGIN-USER");
			long storeId = CommonUtil.getStoreIdForDevice(session);
			try {
				ImpressionsLocalServiceUtil.addToImpressions(ImpressionTypes.USER.getValue(),Long.toString(emailUserId),
						ImpressionTypes.LOGIN.getValue(),userId , Long.toString(themeDisplay.getCompanyId()),
						PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
						deviceName,deviceType,deviceWidth,browserName,storeId);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}
}
