package com.cloud.tags.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cloud.tags.common.util.Constants;
import com.cloud.tags.model.Carts;
import com.cloud.tags.model.CartsDesigners;
import com.cloud.tags.model.Designers;
import com.cloud.tags.portlet.recommendation.Recommendationcontroller;
import com.cloud.tags.service.CartsDesignersLocalServiceUtil;
import com.cloud.tags.service.CartsLocalServiceUtil;
import com.cloud.tags.service.DesignersLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SalesAssociatePortlet
 */
public class SalesAssociatePortlet extends MVCPortlet {
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


	}

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		HttpSession session = PortalUtil.getHttpServletRequest(renderRequest)
				.getSession();
		HttpServletRequest httpServletRequest =  PortalUtil.getHttpServletRequest(renderRequest);

		//HttpSession httpsession = PortalUtil.getHttpServletRequest(renderRequest).getSession();
		String staffName = "Invalid User";
		String currentCompleteUrl = PortalUtil.getCurrentCompleteURL(httpServletRequest);
		if(currentCompleteUrl.contains("/associate")){
			currentCompleteUrl = currentCompleteUrl.replace('?', '#');
			String staffuser[] = currentCompleteUrl.split("#");
			System.out.println("$$$$$$$$$$$$$$$$>>>"+staffuser.length);


			if(staffuser.length == 2){
				staffName = staffuser[1];
				session.setAttribute("LOGINSTAFF", staffName);
			}else{
				session.setAttribute("LOGINSTAFF", staffName);
			}

			/*Map<String, String> salesAssociates = null;

			String staffTag = Constants.SALES_ASS_TAG_PREFIX+staffName;

			if(Validator.isNotNull(session.getAttribute(Constants.SALES_ASSOCIATE_LIST))){
				salesAssociates = (HashMap<String, String>) session.getAttribute(Constants.SALES_ASSOCIATE_LIST);				
				
			}else{
				salesAssociates = new HashMap<String, String>();				
			}
			salesAssociates.put(staffTag, staffTag);
			session.setAttribute(Constants.SALES_ASSOCIATE_LIST, salesAssociates);*/
			
			List<String> salesAssociates = null;		

			if(Validator.isNotNull(session.getAttribute(Constants.SALES_ASSOCIATES_LIST))){
				salesAssociates = (List<String>) session.getAttribute(Constants.SALES_ASSOCIATES_LIST);				
				
			}else{
				salesAssociates = new ArrayList<String>();				
			}
			salesAssociates.add(staffName);
			session.setAttribute(Constants.SALES_ASSOCIATES_LIST, salesAssociates);
			
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}


}
