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
 * Provides a wrapper for {@link RecommendationsLocalService}.
 *
 * @author Mohammed Zaheer
 * @see RecommendationsLocalService
 * @generated
 */
public class RecommendationsLocalServiceWrapper
	implements RecommendationsLocalService,
		ServiceWrapper<RecommendationsLocalService> {
	public RecommendationsLocalServiceWrapper(
		RecommendationsLocalService recommendationsLocalService) {
		_recommendationsLocalService = recommendationsLocalService;
	}

	/**
	* Adds the recommendations to the database. Also notifies the appropriate model listeners.
	*
	* @param recommendations the recommendations
	* @return the recommendations that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.Recommendations addRecommendations(
		com.cloud.tags.model.Recommendations recommendations)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recommendationsLocalService.addRecommendations(recommendations);
	}

	/**
	* Creates a new recommendations with the primary key. Does not add the recommendations to the database.
	*
	* @param recId the primary key for the new recommendations
	* @return the new recommendations
	*/
	@Override
	public com.cloud.tags.model.Recommendations createRecommendations(
		long recId) {
		return _recommendationsLocalService.createRecommendations(recId);
	}

	/**
	* Deletes the recommendations with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recId the primary key of the recommendations
	* @return the recommendations that was removed
	* @throws PortalException if a recommendations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.Recommendations deleteRecommendations(
		long recId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _recommendationsLocalService.deleteRecommendations(recId);
	}

	/**
	* Deletes the recommendations from the database. Also notifies the appropriate model listeners.
	*
	* @param recommendations the recommendations
	* @return the recommendations that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.Recommendations deleteRecommendations(
		com.cloud.tags.model.Recommendations recommendations)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recommendationsLocalService.deleteRecommendations(recommendations);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _recommendationsLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recommendationsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.RecommendationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _recommendationsLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.RecommendationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recommendationsLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recommendationsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recommendationsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.cloud.tags.model.Recommendations fetchRecommendations(long recId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recommendationsLocalService.fetchRecommendations(recId);
	}

	/**
	* Returns the recommendations with the primary key.
	*
	* @param recId the primary key of the recommendations
	* @return the recommendations
	* @throws PortalException if a recommendations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.Recommendations getRecommendations(long recId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _recommendationsLocalService.getRecommendations(recId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _recommendationsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the recommendationses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.RecommendationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of recommendationses
	* @param end the upper bound of the range of recommendationses (not inclusive)
	* @return the range of recommendationses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.cloud.tags.model.Recommendations> getRecommendationses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recommendationsLocalService.getRecommendationses(start, end);
	}

	/**
	* Returns the number of recommendationses.
	*
	* @return the number of recommendationses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getRecommendationsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recommendationsLocalService.getRecommendationsesCount();
	}

	/**
	* Updates the recommendations in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param recommendations the recommendations
	* @return the recommendations that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.Recommendations updateRecommendations(
		com.cloud.tags.model.Recommendations recommendations)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recommendationsLocalService.updateRecommendations(recommendations);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _recommendationsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_recommendationsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _recommendationsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.cloud.tags.model.Recommendations getInstance() {
		return _recommendationsLocalService.getInstance();
	}

	@Override
	public com.cloud.tags.model.Recommendations addRecommendations(long _type,
		java.lang.String designer1, java.lang.String designer2,
		double percentage, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recommendationsLocalService.addRecommendations(_type,
			designer1, designer2, percentage, companyId);
	}

	@Override
	public java.util.List<com.cloud.tags.model.Recommendations> getByDesigner1(
		long _type, java.lang.String designer1, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recommendationsLocalService.getByDesigner1(_type, designer1,
			companyId);
	}

	@Override
	public java.util.List<com.cloud.tags.model.Designers> getNimbusRecommendations(
		java.lang.String sessionId, java.lang.String email, long productId,
		long companyId, java.lang.String category) {
		return _recommendationsLocalService.getNimbusRecommendations(sessionId,
			email, productId, companyId, category);
	}

	@Override
	public java.util.List<com.cloud.tags.model.Designers> getNimbusRecommendations(
		java.lang.String sessionId, java.lang.String email,
		java.lang.String productIds, int numOfRecommend, long companyId,
		java.lang.String category) {
		return _recommendationsLocalService.getNimbusRecommendations(sessionId,
			email, productIds, numOfRecommend, companyId, category);
	}

	@Override
	public java.lang.Object getNimbusRRecommendations(
		java.lang.String sessionId, java.lang.String email, long productId,
		long companyId, java.lang.String category) {
		return _recommendationsLocalService.getNimbusRRecommendations(sessionId,
			email, productId, companyId, category);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RecommendationsLocalService getWrappedRecommendationsLocalService() {
		return _recommendationsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRecommendationsLocalService(
		RecommendationsLocalService recommendationsLocalService) {
		_recommendationsLocalService = recommendationsLocalService;
	}

	@Override
	public RecommendationsLocalService getWrappedService() {
		return _recommendationsLocalService;
	}

	@Override
	public void setWrappedService(
		RecommendationsLocalService recommendationsLocalService) {
		_recommendationsLocalService = recommendationsLocalService;
	}

	private RecommendationsLocalService _recommendationsLocalService;
}