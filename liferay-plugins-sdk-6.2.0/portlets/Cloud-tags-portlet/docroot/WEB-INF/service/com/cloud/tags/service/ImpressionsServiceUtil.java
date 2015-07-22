/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.cloud.tags.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Impressions. This utility wraps
 * {@link com.cloud.tags.service.impl.ImpressionsServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Mohammed Zaheer
 * @see ImpressionsService
 * @see com.cloud.tags.service.base.ImpressionsServiceBaseImpl
 * @see com.cloud.tags.service.impl.ImpressionsServiceImpl
 * @generated
 */
public class ImpressionsServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.cloud.tags.service.impl.ImpressionsServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.cloud.tags.model.Impressions addTheImpressions(
		java.lang.String impType, java.lang.String impId,
		java.lang.String impAction, java.lang.String userId,
		java.lang.String companyId, java.lang.String ipAddress,
		java.lang.String deviceName, java.lang.String deviceType,
		java.lang.String deviceWidth, java.lang.String browser, long storeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addTheImpressions(impType, impId, impAction, userId,
			companyId, ipAddress, deviceName, deviceType, deviceWidth, browser,
			storeId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ImpressionsService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ImpressionsService.class.getName());

			if (invokableService instanceof ImpressionsService) {
				_service = (ImpressionsService)invokableService;
			}
			else {
				_service = new ImpressionsServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(ImpressionsServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ImpressionsService service) {
	}

	private static ImpressionsService _service;
}