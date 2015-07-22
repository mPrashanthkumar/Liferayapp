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
 * Provides a wrapper for {@link RecommendationsService}.
 *
 * @author Mohammed Zaheer
 * @see RecommendationsService
 * @generated
 */
public class RecommendationsServiceWrapper implements RecommendationsService,
	ServiceWrapper<RecommendationsService> {
	public RecommendationsServiceWrapper(
		RecommendationsService recommendationsService) {
		_recommendationsService = recommendationsService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _recommendationsService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_recommendationsService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _recommendationsService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.cloud.tags.model.Designers> getNimbusRecommendations(
		java.lang.String sessionId, java.lang.String email, long productId,
		long companyId, java.lang.String category) {
		return _recommendationsService.getNimbusRecommendations(sessionId,
			email, productId, companyId, category);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RecommendationsService getWrappedRecommendationsService() {
		return _recommendationsService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRecommendationsService(
		RecommendationsService recommendationsService) {
		_recommendationsService = recommendationsService;
	}

	@Override
	public RecommendationsService getWrappedService() {
		return _recommendationsService;
	}

	@Override
	public void setWrappedService(RecommendationsService recommendationsService) {
		_recommendationsService = recommendationsService;
	}

	private RecommendationsService _recommendationsService;
}