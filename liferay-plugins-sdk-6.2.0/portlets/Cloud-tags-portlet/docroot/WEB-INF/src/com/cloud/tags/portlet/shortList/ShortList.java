package com.cloud.tags.portlet.shortList;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cloud.tags.common.CommonUtil;
import com.cloud.tags.common.ImpressionTypes;
import com.cloud.tags.common.RestClientUtil;
import com.cloud.tags.model.CartsDesigners;
import com.cloud.tags.model.Designers;
import com.cloud.tags.model.Impressions;
import com.cloud.tags.service.CartsDesignersLocalServiceUtil;
import com.cloud.tags.service.DesignersLocalServiceUtil;
import com.cloud.tags.service.ImpressionsLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * @author Azam
 * Portlet implementation class ShortList
 * this class is used for the Shorlist portlet to manage all the products added to Cart
 */
public class ShortList extends MVCPortlet {

	private final static Logger _log = Logger
			.getLogger(ShortList.class.getName());
	
	@Override
	public void init() throws PortletException {
		// TODO Auto-generated method stub
		super.init();
	}

	/**
	 * This method manages the products Removal after adding to cart as well as Staff Users who would like to clear the products 
	 */
	@SuppressWarnings("unchecked")
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		UploadPortletRequest uploadPortletRequest = PortalUtil
				.getUploadPortletRequest(resourceRequest);

		long designId = ParamUtil.getLong(uploadPortletRequest, "designId");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String cmd = ParamUtil.getString(uploadPortletRequest, "CMD");
		
		HttpSession session = PortalUtil.getHttpServletRequest(resourceRequest)
				.getSession();
		long storeId = CommonUtil.getStoreIdForDevice(session);
		HashMap<Long, Designers> cartList = null;
		HashMap<Long, CartsDesigners> cartDesigners;

		if (cmd.equals("remove")) {
			
			_log.info("Products was removed");

			if (Validator.isNotNull(session
					.getAttribute("LIFERAY_SHARED_CARTLIST"))) {

				cartList = (HashMap<Long, Designers>) session
						.getAttribute("LIFERAY_SHARED_CARTLIST");
				if (cartList.containsKey(designId))
					cartList.remove(designId);
				cartDesigners = (HashMap<Long, CartsDesigners>) session
						.getAttribute("LIFERAY_SHARED_CARTDESIGNERS");
				String loginUser = StringPool.BLANK;
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
		} else if (cmd.equals("staffEnd")) {
			
			_log.info("Style Advisor cleared session  ");
			session.removeAttribute("LIFERAY_SHARED_CARTLIST");
			session.removeAttribute("LIFERAY_SHARED_CARTDESIGNERS");
		}
	}
	
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		
		_log.fatal("Heloo i ma here ");
		super.doView(renderRequest, renderResponse);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}
