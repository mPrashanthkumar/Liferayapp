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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ImpressionsService}.
 *
 * @author Mohammed Zaheer
 * @see ImpressionsService
 * @generated
 */
public class ImpressionsServiceWrapper implements ImpressionsService,
	ServiceWrapper<ImpressionsService> {
	public ImpressionsServiceWrapper(ImpressionsService impressionsService) {
		_impressionsService = impressionsService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _impressionsService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_impressionsService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _impressionsService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.cloud.tags.model.Impressions addTheImpressions(
		java.lang.String impType, java.lang.String impId,
		java.lang.String impAction, java.lang.String userId,
		java.lang.String companyId, java.lang.String ipAddress,
		java.lang.String deviceName, java.lang.String deviceType,
		java.lang.String deviceWidth, java.lang.String browser, long storeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _impressionsService.addTheImpressions(impType, impId, impAction,
			userId, companyId, ipAddress, deviceName, deviceType, deviceWidth,
			browser, storeId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ImpressionsService getWrappedImpressionsService() {
		return _impressionsService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedImpressionsService(
		ImpressionsService impressionsService) {
		_impressionsService = impressionsService;
	}

	@Override
	public ImpressionsService getWrappedService() {
		return _impressionsService;
	}

	@Override
	public void setWrappedService(ImpressionsService impressionsService) {
		_impressionsService = impressionsService;
	}

	private ImpressionsService _impressionsService;
}