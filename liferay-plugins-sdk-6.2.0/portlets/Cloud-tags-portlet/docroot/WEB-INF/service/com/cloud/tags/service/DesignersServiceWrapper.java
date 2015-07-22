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
 * Provides a wrapper for {@link DesignersService}.
 *
 * @author Mohammed Zaheer
 * @see DesignersService
 * @generated
 */
public class DesignersServiceWrapper implements DesignersService,
	ServiceWrapper<DesignersService> {
	public DesignersServiceWrapper(DesignersService designersService) {
		_designersService = designersService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _designersService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_designersService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _designersService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.lang.String runFeed() {
		return _designersService.runFeed();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DesignersService getWrappedDesignersService() {
		return _designersService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDesignersService(DesignersService designersService) {
		_designersService = designersService;
	}

	@Override
	public DesignersService getWrappedService() {
		return _designersService;
	}

	@Override
	public void setWrappedService(DesignersService designersService) {
		_designersService = designersService;
	}

	private DesignersService _designersService;
}