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
 * Provides a wrapper for {@link StoreInformationMapService}.
 *
 * @author Mohammed Zaheer
 * @see StoreInformationMapService
 * @generated
 */
public class StoreInformationMapServiceWrapper
	implements StoreInformationMapService,
		ServiceWrapper<StoreInformationMapService> {
	public StoreInformationMapServiceWrapper(
		StoreInformationMapService storeInformationMapService) {
		_storeInformationMapService = storeInformationMapService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _storeInformationMapService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_storeInformationMapService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _storeInformationMapService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StoreInformationMapService getWrappedStoreInformationMapService() {
		return _storeInformationMapService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStoreInformationMapService(
		StoreInformationMapService storeInformationMapService) {
		_storeInformationMapService = storeInformationMapService;
	}

	@Override
	public StoreInformationMapService getWrappedService() {
		return _storeInformationMapService;
	}

	@Override
	public void setWrappedService(
		StoreInformationMapService storeInformationMapService) {
		_storeInformationMapService = storeInformationMapService;
	}

	private StoreInformationMapService _storeInformationMapService;
}