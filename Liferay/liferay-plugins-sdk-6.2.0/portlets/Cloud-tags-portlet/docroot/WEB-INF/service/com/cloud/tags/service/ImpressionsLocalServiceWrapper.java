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
 * Provides a wrapper for {@link ImpressionsLocalService}.
 *
 * @author Mohammed Zaheer
 * @see ImpressionsLocalService
 * @generated
 */
public class ImpressionsLocalServiceWrapper implements ImpressionsLocalService,
	ServiceWrapper<ImpressionsLocalService> {
	public ImpressionsLocalServiceWrapper(
		ImpressionsLocalService impressionsLocalService) {
		_impressionsLocalService = impressionsLocalService;
	}

	/**
	* Adds the impressions to the database. Also notifies the appropriate model listeners.
	*
	* @param impressions the impressions
	* @return the impressions that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.Impressions addImpressions(
		com.cloud.tags.model.Impressions impressions)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _impressionsLocalService.addImpressions(impressions);
	}

	/**
	* Creates a new impressions with the primary key. Does not add the impressions to the database.
	*
	* @param recId the primary key for the new impressions
	* @return the new impressions
	*/
	@Override
	public com.cloud.tags.model.Impressions createImpressions(long recId) {
		return _impressionsLocalService.createImpressions(recId);
	}

	/**
	* Deletes the impressions with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recId the primary key of the impressions
	* @return the impressions that was removed
	* @throws PortalException if a impressions with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.Impressions deleteImpressions(long recId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _impressionsLocalService.deleteImpressions(recId);
	}

	/**
	* Deletes the impressions from the database. Also notifies the appropriate model listeners.
	*
	* @param impressions the impressions
	* @return the impressions that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.Impressions deleteImpressions(
		com.cloud.tags.model.Impressions impressions)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _impressionsLocalService.deleteImpressions(impressions);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _impressionsLocalService.dynamicQuery();
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
		return _impressionsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.ImpressionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _impressionsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.ImpressionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _impressionsLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _impressionsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _impressionsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.cloud.tags.model.Impressions fetchImpressions(long recId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _impressionsLocalService.fetchImpressions(recId);
	}

	/**
	* Returns the impressions with the primary key.
	*
	* @param recId the primary key of the impressions
	* @return the impressions
	* @throws PortalException if a impressions with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.Impressions getImpressions(long recId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _impressionsLocalService.getImpressions(recId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _impressionsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the impressionses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.ImpressionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of impressionses
	* @param end the upper bound of the range of impressionses (not inclusive)
	* @return the range of impressionses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.cloud.tags.model.Impressions> getImpressionses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _impressionsLocalService.getImpressionses(start, end);
	}

	/**
	* Returns the number of impressionses.
	*
	* @return the number of impressionses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getImpressionsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _impressionsLocalService.getImpressionsesCount();
	}

	/**
	* Updates the impressions in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param impressions the impressions
	* @return the impressions that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.Impressions updateImpressions(
		com.cloud.tags.model.Impressions impressions)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _impressionsLocalService.updateImpressions(impressions);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _impressionsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_impressionsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _impressionsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.cloud.tags.model.Impressions getInstance() {
		return _impressionsLocalService.getInstance();
	}

	@Override
	public com.cloud.tags.model.Impressions addToImpressions(
		java.lang.String impType, java.lang.String impId,
		java.lang.String impAction, java.lang.String userId,
		java.lang.String companyId, java.lang.String ipAddress,
		java.lang.String deviceName, java.lang.String deviceType,
		java.lang.String deviceWidth, java.lang.String browser, long storeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _impressionsLocalService.addToImpressions(impType, impId,
			impAction, userId, companyId, ipAddress, deviceName, deviceType,
			deviceWidth, browser, storeId);
	}

	@Override
	public java.util.List<com.cloud.tags.model.Impressions> getByImpressionTypeAction(
		java.lang.String impType, java.lang.String impAction,
		java.lang.String sessionId, java.lang.String companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _impressionsLocalService.getByImpressionTypeAction(impType,
			impAction, sessionId, companyId);
	}

	@Override
	public java.util.List<com.cloud.tags.model.Impressions> getByImpressionByStoreId(
		long storeDeviceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _impressionsLocalService.getByImpressionByStoreId(storeDeviceId);
	}

	@Override
	public java.util.List<com.cloud.tags.model.Impressions> findByStaffId(
		java.lang.String staffId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _impressionsLocalService.findByStaffId(staffId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ImpressionsLocalService getWrappedImpressionsLocalService() {
		return _impressionsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedImpressionsLocalService(
		ImpressionsLocalService impressionsLocalService) {
		_impressionsLocalService = impressionsLocalService;
	}

	@Override
	public ImpressionsLocalService getWrappedService() {
		return _impressionsLocalService;
	}

	@Override
	public void setWrappedService(
		ImpressionsLocalService impressionsLocalService) {
		_impressionsLocalService = impressionsLocalService;
	}

	private ImpressionsLocalService _impressionsLocalService;
}