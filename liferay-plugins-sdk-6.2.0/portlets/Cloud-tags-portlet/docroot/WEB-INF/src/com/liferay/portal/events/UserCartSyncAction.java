package com.liferay.portal.events;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cloud.tags.model.Carts;
import com.cloud.tags.model.CartsDesigners;
import com.cloud.tags.model.Designers;
import com.cloud.tags.service.CartsDesignersLocalServiceUtil;
import com.cloud.tags.service.CartsLocalServiceUtil;
import com.cloud.tags.service.DesignersLocalServiceUtil;
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.util.PortalUtil;

public class UserCartSyncAction extends Action {

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response)
			throws ActionException {

		HttpSession session = request.getSession();

		session.removeAttribute("LIFERAY_SHARED_CARTLIST");
		session.removeAttribute("LIFERAY_SHARED_CARTDESIGNERS");
		
		try {
			List<Carts> carts = CartsLocalServiceUtil.findByuserId(PortalUtil
					.getUserId(request));

			HashMap<Long, Designers> cartList = new HashMap<Long, Designers>();
			HashMap<Long, CartsDesigners> cartDesigners = new HashMap<Long, CartsDesigners>();
			for (Carts cart : carts) {


				List<CartsDesigners> cartsDesigners = CartsDesignersLocalServiceUtil
						.findByCartId(cart.getCartId());

				for (CartsDesigners designers : cartsDesigners) {


					if (designers.isKept()) {

						try {
							Designers designers2 = DesignersLocalServiceUtil
									.getDesigners(designers.getDesignId());
							
							cartList.put(designers.getDesignId(), designers2);
							cartDesigners.put(designers.getDesignId(),
									designers);
						} catch (PortalException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}

			}

			session.setAttribute("LIFERAY_SHARED_CARTLIST", cartList);
			session.setAttribute("LIFERAY_SHARED_CARTDESIGNERS", cartDesigners);

		} catch (SystemException e) {
			
			e.printStackTrace();
		}

	}

}
