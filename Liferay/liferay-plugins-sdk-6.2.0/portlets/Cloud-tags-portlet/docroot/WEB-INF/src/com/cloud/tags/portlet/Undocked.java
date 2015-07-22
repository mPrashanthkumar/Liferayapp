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
 * Portlet implementation class Undocked
 * 
 */
public class Undocked extends MVCPortlet {

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
				
				try {
					if(Validator.isNotNull(session.getAttribute("UNDOCKIMPRESS-ID"))){
					Impressions imp = ImpressionsLocalServiceUtil.getImpressions(Long.parseLong(session.getAttribute("UNDOCKIMPRESS-ID").toString()));
					imp.setStoreDeviceId(storeId);
					ImpressionsLocalServiceUtil.updateImpressions(imp);
					session.removeAttribute("UNDOCKIMPRESS-ID");
					}
					
					if(Validator.isNotNull(session.getAttribute("USERIMPRESS-ID"))){
					Impressions imp = ImpressionsLocalServiceUtil.getImpressions(Long.parseLong(session.getAttribute("USERIMPRESS-ID").toString()));
					imp.setStoreDeviceId(storeId);
					ImpressionsLocalServiceUtil.updateImpressions(imp);
					session.removeAttribute("USERIMPRESS-ID");
					}
					
					if(Validator.isNotNull(session.getAttribute("USEREMAILIMPRESS-ID"))){
					Impressions imp = ImpressionsLocalServiceUtil.getImpressions(Long.parseLong(session.getAttribute("USEREMAILIMPRESS-ID").toString()));
					imp.setStoreDeviceId(storeId);
					ImpressionsLocalServiceUtil.updateImpressions(imp);
					session.removeAttribute("USEREMAILIMPRESS-ID");
					}
					if(Validator.isNotNull(session.getAttribute("INSTRUCTIONSIMPRESS-ID"))){
					Impressions imp = ImpressionsLocalServiceUtil.getImpressions(Long.parseLong(session.getAttribute("INSTRUCTIONSIMPRESS-ID").toString()));
					imp.setStoreDeviceId(storeId);
					ImpressionsLocalServiceUtil.updateImpressions(imp);
					session.removeAttribute("INSTRUCTIONSIMPRESS-ID");					
					}
					
					
					
					
					
					
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
				
		
			//end
		}else if(cmd.equals("UNDOCKED")){
			_log.info("FROM  UNDOCKED");
			String deviceName = ParamUtil.getString(uploadPortletRequest, "deviceName");
			String deviceType = ParamUtil.getString(uploadPortletRequest, "deviceType");
			String browserName = ParamUtil.getString(uploadPortletRequest, "browserName");
			String deviceWidth = ParamUtil.getString(uploadPortletRequest, "screenWidth");
			int instructions = ParamUtil.getInteger(uploadPortletRequest, "instructions");
			
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
			_log.info("instructions>>>>>>>>>>1"+instructions);
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
							
				

				/*impressions = ImpressionsLocalServiceUtil.addToImpressions(ImpressionTypes.UNDOCKED_NEW.getValue(), actualSessionUserId, 
						ImpressionTypes.UNDOCKED_NEW.getValue(),userId , Long.toString(themeDisplay.getCompanyId()),
						PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
						deviceName,deviceType,deviceWidth,browserName,storeId);*/
				if(instructions == 0){
					Impressions impressions = ImpressionsLocalServiceUtil.addToImpressions(ImpressionTypes.UNDOCKED.getValue(), actualSessionUserId, 
							ImpressionTypes.UNDOCKED.getValue(),userId , Long.toString(themeDisplay.getCompanyId()),
							PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
							deviceName,deviceType,deviceWidth,browserName,storeId);
					session.setAttribute("UNDOCKIMPRESS-ID", impressions.getRecId());
					
					if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressions != null){
						impressions.setStaffId(session.getAttribute("LOGINSTAFF").toString());
						ImpressionsLocalServiceUtil.updateImpressions(impressions);
					}
				}else if(instructions == 1){
				Impressions impressions1 = ImpressionsLocalServiceUtil.addToImpressions(ImpressionTypes.INSTRUCTIONPAGE.getValue(), actualSessionUserId, 
						ImpressionTypes.INSTRUCTIONS.getValue(),userId , Long.toString(themeDisplay.getCompanyId()),
						PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
						deviceName,deviceType,deviceWidth,browserName,storeId);
				session.setAttribute("INSTRUCTIONSIMPRESS-ID", impressions1.getRecId());
				
				if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressions1 != null){
					impressions1.setStaffId(session.getAttribute("LOGINSTAFF").toString());
					ImpressionsLocalServiceUtil.updateImpressions(impressions1);
				}
				}

			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(cmd.equals("VALIDATEEMAIL")){
			System.out.println("Welcome to VALIDATEEMAIL");
			session.setAttribute("HISTORY-PATH", "/undocked?page=notification");
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
				Impressions impreEmail = ImpressionsLocalServiceUtil.addToImpressions(ImpressionTypes.UNDOCKEDEMAIL.toString(),emailAddress,
						ImpressionTypes.EMAILADDRESS.getValue(),userId , Long.toString(themeDisplay.getCompanyId()),
						PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
						deviceName,deviceType,deviceWidth,browserName,storeId);
				
				Impressions impreUser = ImpressionsLocalServiceUtil.addToImpressions(ImpressionTypes.USER.getValue(),Long.toString(emailUserId),
						ImpressionTypes.LOGIN.getValue(),userId , Long.toString(themeDisplay.getCompanyId()),
						PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
						deviceName,deviceType,deviceWidth,browserName,storeId);
								
				
				session.setAttribute("USERIMPRESS-ID", impreUser.getRecId());
				//loginUser = session.getAttribute("LOGIN-USER").toString();

				if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impreUser != null){
					impreUser.setStaffId(session.getAttribute("LOGINSTAFF").toString());
					ImpressionsLocalServiceUtil.updateImpressions(impreUser);
				}
					session.setAttribute("USEREMAILIMPRESS-ID", impreEmail.getRecId());
					//loginUser = session.getAttribute("LOGIN-USER").toString();

					if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impreEmail != null){
						impreEmail.setStaffId(session.getAttribute("LOGINSTAFF").toString());
						ImpressionsLocalServiceUtil.updateImpressions(impreEmail);
				}
				
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("INSTRUCTION")){
			_log.info("FROM  INSTRUCTIONS");
			String deviceName = ParamUtil.getString(uploadPortletRequest, "deviceName");
			String deviceType = ParamUtil.getString(uploadPortletRequest, "deviceType");
			String browserName = ParamUtil.getString(uploadPortletRequest, "browserName");
			String deviceWidth = ParamUtil.getString(uploadPortletRequest, "screenWidth");
			
			
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
			
			
			
			String userId = StringPool.BLANK;
			if(Validator.isNotNull(session.getAttribute("LOGIN-USER")))
					userId = (String) session.getAttribute("LOGIN-USER");
			long storeId = CommonUtil.getStoreIdForDevice(session);
			try {
							
				if(Validator.isNotNull(session.getAttribute("FIRST-LOGIN-USER"))){
					actualSessionUserId = session.getAttribute("FIRST-LOGIN-USER").toString();
				}
				Impressions impressions = ImpressionsLocalServiceUtil.addToImpressions(ImpressionTypes.INSTRUCTIONPAGE.getValue(), actualSessionUserId, 
						ImpressionTypes.INSTRUCTIONS.getValue(),userId , Long.toString(themeDisplay.getCompanyId()),
						PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
						deviceName,deviceType,deviceWidth,browserName,storeId);
				session.setAttribute("INSTRUCTIONSIMPRESS-ID", impressions.getRecId());
				
				if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressions != null){
					impressions.setStaffId(session.getAttribute("LOGINSTAFF").toString());
					ImpressionsLocalServiceUtil.updateImpressions(impressions);
				}

			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}


	}
}
