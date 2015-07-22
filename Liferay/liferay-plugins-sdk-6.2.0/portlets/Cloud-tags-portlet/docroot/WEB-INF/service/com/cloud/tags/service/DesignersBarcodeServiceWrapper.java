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
 * Provides a wrapper for {@link DesignersBarcodeService}.
 *
 * @author Mohammed Zaheer
 * @see DesignersBarcodeService
 * @generated
 */
public class DesignersBarcodeServiceWrapper implements DesignersBarcodeService,
	ServiceWrapper<DesignersBarcodeService> {
	public DesignersBarcodeServiceWrapper(
		DesignersBarcodeService designersBarcodeService) {
		_designersBarcodeService = designersBarcodeService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _designersBarcodeService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_designersBarcodeService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _designersBarcodeService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.lang.String getSlugURLByBarcodeId(long barcodeId) {
		return _designersBarcodeService.getSlugURLByBarcodeId(barcodeId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DesignersBarcodeService getWrappedDesignersBarcodeService() {
		return _designersBarcodeService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDesignersBarcodeService(
		DesignersBarcodeService designersBarcodeService) {
		_designersBarcodeService = designersBarcodeService;
	}

	@Override
	public DesignersBarcodeService getWrappedService() {
		return _designersBarcodeService;
	}

	@Override
	public void setWrappedService(
		DesignersBarcodeService designersBarcodeService) {
		_designersBarcodeService = designersBarcodeService;
	}

	private DesignersBarcodeService _designersBarcodeService;
}