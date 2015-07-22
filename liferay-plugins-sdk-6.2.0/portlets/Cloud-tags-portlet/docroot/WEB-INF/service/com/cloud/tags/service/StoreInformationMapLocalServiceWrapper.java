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
 * Provides a wrapper for {@link StoreInformationMapLocalService}.
 *
 * @author Mohammed Zaheer
 * @see StoreInformationMapLocalService
 * @generated
 */
public class StoreInformationMapLocalServiceWrapper
	implements StoreInformationMapLocalService,
		ServiceWrapper<StoreInformationMapLocalService> {
	public StoreInformationMapLocalServiceWrapper(
		StoreInformationMapLocalService storeInformationMapLocalService) {
		_storeInformationMapLocalService = storeInformationMapLocalService;
	}

	/**
	* Adds the store information map to the database. Also notifies the appropriate model listeners.
	*
	* @param storeInformationMap the store information map
	* @return the store information map that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.StoreInformationMap addStoreInformationMap(
		com.cloud.tags.model.StoreInformationMap storeInformationMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _storeInformationMapLocalService.addStoreInformationMap(storeInformationMap);
	}

	/**
	* Creates a new store information map with the primary key. Does not add the store information map to the database.
	*
	* @param uuid the primary key for the new store information map
	* @return the new store information map
	*/
	@Override
	public com.cloud.tags.model.StoreInformationMap createStoreInformationMap(
		long uuid) {
		return _storeInformationMapLocalService.createStoreInformationMap(uuid);
	}

	/**
	* Deletes the store information map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param uuid the primary key of the store information map
	* @return the store information map that was removed
	* @throws PortalException if a store information map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.StoreInformationMap deleteStoreInformationMap(
		long uuid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _storeInformationMapLocalService.deleteStoreInformationMap(uuid);
	}

	/**
	* Deletes the store information map from the database. Also notifies the appropriate model listeners.
	*
	* @param storeInformationMap the store information map
	* @return the store information map that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.StoreInformationMap deleteStoreInformationMap(
		com.cloud.tags.model.StoreInformationMap storeInformationMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _storeInformationMapLocalService.deleteStoreInformationMap(storeInformationMap);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _storeInformationMapLocalService.dynamicQuery();
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
		return _storeInformationMapLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.StoreInformationMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _storeInformationMapLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.StoreInformationMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _storeInformationMapLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _storeInformationMapLocalService.dynamicQueryCount(dynamicQuery);
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
		return _storeInformationMapLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.cloud.tags.model.StoreInformationMap fetchStoreInformationMap(
		long uuid) throws com.liferay.portal.kernel.exception.SystemException {
		return _storeInformationMapLocalService.fetchStoreInformationMap(uuid);
	}

	/**
	* Returns the store information map with the primary key.
	*
	* @param uuid the primary key of the store information map
	* @return the store information map
	* @throws PortalException if a store information map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.StoreInformationMap getStoreInformationMap(
		long uuid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _storeInformationMapLocalService.getStoreInformationMap(uuid);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _storeInformationMapLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the store information maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.StoreInformationMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of store information maps
	* @param end the upper bound of the range of store information maps (not inclusive)
	* @return the range of store information maps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.cloud.tags.model.StoreInformationMap> getStoreInformationMaps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _storeInformationMapLocalService.getStoreInformationMaps(start,
			end);
	}

	/**
	* Returns the number of store information maps.
	*
	* @return the number of store information maps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStoreInformationMapsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _storeInformationMapLocalService.getStoreInformationMapsCount();
	}

	/**
	* Updates the store information map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param storeInformationMap the store information map
	* @return the store information map that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.StoreInformationMap updateStoreInformationMap(
		com.cloud.tags.model.StoreInformationMap storeInformationMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _storeInformationMapLocalService.updateStoreInformationMap(storeInformationMap);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _storeInformationMapLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_storeInformationMapLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _storeInformationMapLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StoreInformationMapLocalService getWrappedStoreInformationMapLocalService() {
		return _storeInformationMapLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStoreInformationMapLocalService(
		StoreInformationMapLocalService storeInformationMapLocalService) {
		_storeInformationMapLocalService = storeInformationMapLocalService;
	}

	@Override
	public StoreInformationMapLocalService getWrappedService() {
		return _storeInformationMapLocalService;
	}

	@Override
	public void setWrappedService(
		StoreInformationMapLocalService storeInformationMapLocalService) {
		_storeInformationMapLocalService = storeInformationMapLocalService;
	}

	private StoreInformationMapLocalService _storeInformationMapLocalService;
}