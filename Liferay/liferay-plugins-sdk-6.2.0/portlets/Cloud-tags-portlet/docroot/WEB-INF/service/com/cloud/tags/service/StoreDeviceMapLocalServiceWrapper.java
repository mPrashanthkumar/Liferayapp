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
 * Provides a wrapper for {@link StoreDeviceMapLocalService}.
 *
 * @author Mohammed Zaheer
 * @see StoreDeviceMapLocalService
 * @generated
 */
public class StoreDeviceMapLocalServiceWrapper
	implements StoreDeviceMapLocalService,
		ServiceWrapper<StoreDeviceMapLocalService> {
	public StoreDeviceMapLocalServiceWrapper(
		StoreDeviceMapLocalService storeDeviceMapLocalService) {
		_storeDeviceMapLocalService = storeDeviceMapLocalService;
	}

	/**
	* Adds the store device map to the database. Also notifies the appropriate model listeners.
	*
	* @param storeDeviceMap the store device map
	* @return the store device map that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.StoreDeviceMap addStoreDeviceMap(
		com.cloud.tags.model.StoreDeviceMap storeDeviceMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _storeDeviceMapLocalService.addStoreDeviceMap(storeDeviceMap);
	}

	/**
	* Creates a new store device map with the primary key. Does not add the store device map to the database.
	*
	* @param uuid the primary key for the new store device map
	* @return the new store device map
	*/
	@Override
	public com.cloud.tags.model.StoreDeviceMap createStoreDeviceMap(long uuid) {
		return _storeDeviceMapLocalService.createStoreDeviceMap(uuid);
	}

	/**
	* Deletes the store device map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param uuid the primary key of the store device map
	* @return the store device map that was removed
	* @throws PortalException if a store device map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.StoreDeviceMap deleteStoreDeviceMap(long uuid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _storeDeviceMapLocalService.deleteStoreDeviceMap(uuid);
	}

	/**
	* Deletes the store device map from the database. Also notifies the appropriate model listeners.
	*
	* @param storeDeviceMap the store device map
	* @return the store device map that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.StoreDeviceMap deleteStoreDeviceMap(
		com.cloud.tags.model.StoreDeviceMap storeDeviceMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _storeDeviceMapLocalService.deleteStoreDeviceMap(storeDeviceMap);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _storeDeviceMapLocalService.dynamicQuery();
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
		return _storeDeviceMapLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.StoreDeviceMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _storeDeviceMapLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.StoreDeviceMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _storeDeviceMapLocalService.dynamicQuery(dynamicQuery, start,
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
		return _storeDeviceMapLocalService.dynamicQueryCount(dynamicQuery);
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
		return _storeDeviceMapLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.cloud.tags.model.StoreDeviceMap fetchStoreDeviceMap(long uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _storeDeviceMapLocalService.fetchStoreDeviceMap(uuid);
	}

	/**
	* Returns the store device map with the primary key.
	*
	* @param uuid the primary key of the store device map
	* @return the store device map
	* @throws PortalException if a store device map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.StoreDeviceMap getStoreDeviceMap(long uuid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _storeDeviceMapLocalService.getStoreDeviceMap(uuid);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _storeDeviceMapLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the store device maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.StoreDeviceMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of store device maps
	* @param end the upper bound of the range of store device maps (not inclusive)
	* @return the range of store device maps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.cloud.tags.model.StoreDeviceMap> getStoreDeviceMaps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _storeDeviceMapLocalService.getStoreDeviceMaps(start, end);
	}

	/**
	* Returns the number of store device maps.
	*
	* @return the number of store device maps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStoreDeviceMapsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _storeDeviceMapLocalService.getStoreDeviceMapsCount();
	}

	/**
	* Updates the store device map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param storeDeviceMap the store device map
	* @return the store device map that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.StoreDeviceMap updateStoreDeviceMap(
		com.cloud.tags.model.StoreDeviceMap storeDeviceMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _storeDeviceMapLocalService.updateStoreDeviceMap(storeDeviceMap);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _storeDeviceMapLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_storeDeviceMapLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _storeDeviceMapLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.cloud.tags.model.StoreDeviceMap> findByDevice(
		java.lang.String deviceMacAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _storeDeviceMapLocalService.findByDevice(deviceMacAddress);
	}

	@Override
	public java.util.List<com.cloud.tags.model.StoreDeviceMap> findByStoreName(
		java.lang.String storeName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _storeDeviceMapLocalService.findByStoreName(storeName);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StoreDeviceMapLocalService getWrappedStoreDeviceMapLocalService() {
		return _storeDeviceMapLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStoreDeviceMapLocalService(
		StoreDeviceMapLocalService storeDeviceMapLocalService) {
		_storeDeviceMapLocalService = storeDeviceMapLocalService;
	}

	@Override
	public StoreDeviceMapLocalService getWrappedService() {
		return _storeDeviceMapLocalService;
	}

	@Override
	public void setWrappedService(
		StoreDeviceMapLocalService storeDeviceMapLocalService) {
		_storeDeviceMapLocalService = storeDeviceMapLocalService;
	}

	private StoreDeviceMapLocalService _storeDeviceMapLocalService;
}