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

package com.cloud.tags.service.persistence;

import com.cloud.tags.model.StoreDeviceMap;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the store device map service. This utility wraps {@link StoreDeviceMapPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see StoreDeviceMapPersistence
 * @see StoreDeviceMapPersistenceImpl
 * @generated
 */
public class StoreDeviceMapUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(StoreDeviceMap storeDeviceMap) {
		getPersistence().clearCache(storeDeviceMap);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StoreDeviceMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StoreDeviceMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StoreDeviceMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static StoreDeviceMap update(StoreDeviceMap storeDeviceMap)
		throws SystemException {
		return getPersistence().update(storeDeviceMap);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static StoreDeviceMap update(StoreDeviceMap storeDeviceMap,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(storeDeviceMap, serviceContext);
	}

	/**
	* Returns all the store device maps where deviceMacAddress = &#63;.
	*
	* @param deviceMacAddress the device mac address
	* @return the matching store device maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.StoreDeviceMap> findByDevice(
		java.lang.String deviceMacAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDevice(deviceMacAddress);
	}

	/**
	* Returns a range of all the store device maps where deviceMacAddress = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.StoreDeviceMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param deviceMacAddress the device mac address
	* @param start the lower bound of the range of store device maps
	* @param end the upper bound of the range of store device maps (not inclusive)
	* @return the range of matching store device maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.StoreDeviceMap> findByDevice(
		java.lang.String deviceMacAddress, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDevice(deviceMacAddress, start, end);
	}

	/**
	* Returns an ordered range of all the store device maps where deviceMacAddress = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.StoreDeviceMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param deviceMacAddress the device mac address
	* @param start the lower bound of the range of store device maps
	* @param end the upper bound of the range of store device maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching store device maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.StoreDeviceMap> findByDevice(
		java.lang.String deviceMacAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDevice(deviceMacAddress, start, end, orderByComparator);
	}

	/**
	* Returns the first store device map in the ordered set where deviceMacAddress = &#63;.
	*
	* @param deviceMacAddress the device mac address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching store device map
	* @throws com.cloud.tags.NoSuchStoreDeviceMapException if a matching store device map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.StoreDeviceMap findByDevice_First(
		java.lang.String deviceMacAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchStoreDeviceMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDevice_First(deviceMacAddress, orderByComparator);
	}

	/**
	* Returns the first store device map in the ordered set where deviceMacAddress = &#63;.
	*
	* @param deviceMacAddress the device mac address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching store device map, or <code>null</code> if a matching store device map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.StoreDeviceMap fetchByDevice_First(
		java.lang.String deviceMacAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDevice_First(deviceMacAddress, orderByComparator);
	}

	/**
	* Returns the last store device map in the ordered set where deviceMacAddress = &#63;.
	*
	* @param deviceMacAddress the device mac address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching store device map
	* @throws com.cloud.tags.NoSuchStoreDeviceMapException if a matching store device map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.StoreDeviceMap findByDevice_Last(
		java.lang.String deviceMacAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchStoreDeviceMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDevice_Last(deviceMacAddress, orderByComparator);
	}

	/**
	* Returns the last store device map in the ordered set where deviceMacAddress = &#63;.
	*
	* @param deviceMacAddress the device mac address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching store device map, or <code>null</code> if a matching store device map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.StoreDeviceMap fetchByDevice_Last(
		java.lang.String deviceMacAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDevice_Last(deviceMacAddress, orderByComparator);
	}

	/**
	* Returns the store device maps before and after the current store device map in the ordered set where deviceMacAddress = &#63;.
	*
	* @param uuid the primary key of the current store device map
	* @param deviceMacAddress the device mac address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next store device map
	* @throws com.cloud.tags.NoSuchStoreDeviceMapException if a store device map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.StoreDeviceMap[] findByDevice_PrevAndNext(
		long uuid, java.lang.String deviceMacAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchStoreDeviceMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDevice_PrevAndNext(uuid, deviceMacAddress,
			orderByComparator);
	}

	/**
	* Removes all the store device maps where deviceMacAddress = &#63; from the database.
	*
	* @param deviceMacAddress the device mac address
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDevice(java.lang.String deviceMacAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDevice(deviceMacAddress);
	}

	/**
	* Returns the number of store device maps where deviceMacAddress = &#63;.
	*
	* @param deviceMacAddress the device mac address
	* @return the number of matching store device maps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDevice(java.lang.String deviceMacAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDevice(deviceMacAddress);
	}

	/**
	* Returns all the store device maps where storeName = &#63;.
	*
	* @param storeName the store name
	* @return the matching store device maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.StoreDeviceMap> findByStoreName(
		java.lang.String storeName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStoreName(storeName);
	}

	/**
	* Returns a range of all the store device maps where storeName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.StoreDeviceMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param storeName the store name
	* @param start the lower bound of the range of store device maps
	* @param end the upper bound of the range of store device maps (not inclusive)
	* @return the range of matching store device maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.StoreDeviceMap> findByStoreName(
		java.lang.String storeName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStoreName(storeName, start, end);
	}

	/**
	* Returns an ordered range of all the store device maps where storeName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.StoreDeviceMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param storeName the store name
	* @param start the lower bound of the range of store device maps
	* @param end the upper bound of the range of store device maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching store device maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.StoreDeviceMap> findByStoreName(
		java.lang.String storeName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStoreName(storeName, start, end, orderByComparator);
	}

	/**
	* Returns the first store device map in the ordered set where storeName = &#63;.
	*
	* @param storeName the store name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching store device map
	* @throws com.cloud.tags.NoSuchStoreDeviceMapException if a matching store device map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.StoreDeviceMap findByStoreName_First(
		java.lang.String storeName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchStoreDeviceMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStoreName_First(storeName, orderByComparator);
	}

	/**
	* Returns the first store device map in the ordered set where storeName = &#63;.
	*
	* @param storeName the store name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching store device map, or <code>null</code> if a matching store device map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.StoreDeviceMap fetchByStoreName_First(
		java.lang.String storeName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStoreName_First(storeName, orderByComparator);
	}

	/**
	* Returns the last store device map in the ordered set where storeName = &#63;.
	*
	* @param storeName the store name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching store device map
	* @throws com.cloud.tags.NoSuchStoreDeviceMapException if a matching store device map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.StoreDeviceMap findByStoreName_Last(
		java.lang.String storeName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchStoreDeviceMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStoreName_Last(storeName, orderByComparator);
	}

	/**
	* Returns the last store device map in the ordered set where storeName = &#63;.
	*
	* @param storeName the store name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching store device map, or <code>null</code> if a matching store device map could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.StoreDeviceMap fetchByStoreName_Last(
		java.lang.String storeName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStoreName_Last(storeName, orderByComparator);
	}

	/**
	* Returns the store device maps before and after the current store device map in the ordered set where storeName = &#63;.
	*
	* @param uuid the primary key of the current store device map
	* @param storeName the store name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next store device map
	* @throws com.cloud.tags.NoSuchStoreDeviceMapException if a store device map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.StoreDeviceMap[] findByStoreName_PrevAndNext(
		long uuid, java.lang.String storeName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchStoreDeviceMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStoreName_PrevAndNext(uuid, storeName,
			orderByComparator);
	}

	/**
	* Removes all the store device maps where storeName = &#63; from the database.
	*
	* @param storeName the store name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStoreName(java.lang.String storeName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStoreName(storeName);
	}

	/**
	* Returns the number of store device maps where storeName = &#63;.
	*
	* @param storeName the store name
	* @return the number of matching store device maps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStoreName(java.lang.String storeName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStoreName(storeName);
	}

	/**
	* Caches the store device map in the entity cache if it is enabled.
	*
	* @param storeDeviceMap the store device map
	*/
	public static void cacheResult(
		com.cloud.tags.model.StoreDeviceMap storeDeviceMap) {
		getPersistence().cacheResult(storeDeviceMap);
	}

	/**
	* Caches the store device maps in the entity cache if it is enabled.
	*
	* @param storeDeviceMaps the store device maps
	*/
	public static void cacheResult(
		java.util.List<com.cloud.tags.model.StoreDeviceMap> storeDeviceMaps) {
		getPersistence().cacheResult(storeDeviceMaps);
	}

	/**
	* Creates a new store device map with the primary key. Does not add the store device map to the database.
	*
	* @param uuid the primary key for the new store device map
	* @return the new store device map
	*/
	public static com.cloud.tags.model.StoreDeviceMap create(long uuid) {
		return getPersistence().create(uuid);
	}

	/**
	* Removes the store device map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param uuid the primary key of the store device map
	* @return the store device map that was removed
	* @throws com.cloud.tags.NoSuchStoreDeviceMapException if a store device map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.StoreDeviceMap remove(long uuid)
		throws com.cloud.tags.NoSuchStoreDeviceMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(uuid);
	}

	public static com.cloud.tags.model.StoreDeviceMap updateImpl(
		com.cloud.tags.model.StoreDeviceMap storeDeviceMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(storeDeviceMap);
	}

	/**
	* Returns the store device map with the primary key or throws a {@link com.cloud.tags.NoSuchStoreDeviceMapException} if it could not be found.
	*
	* @param uuid the primary key of the store device map
	* @return the store device map
	* @throws com.cloud.tags.NoSuchStoreDeviceMapException if a store device map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.StoreDeviceMap findByPrimaryKey(
		long uuid)
		throws com.cloud.tags.NoSuchStoreDeviceMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(uuid);
	}

	/**
	* Returns the store device map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param uuid the primary key of the store device map
	* @return the store device map, or <code>null</code> if a store device map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.StoreDeviceMap fetchByPrimaryKey(
		long uuid) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(uuid);
	}

	/**
	* Returns all the store device maps.
	*
	* @return the store device maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.StoreDeviceMap> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.cloud.tags.model.StoreDeviceMap> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the store device maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.StoreDeviceMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of store device maps
	* @param end the upper bound of the range of store device maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of store device maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.StoreDeviceMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the store device maps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of store device maps.
	*
	* @return the number of store device maps
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StoreDeviceMapPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StoreDeviceMapPersistence)PortletBeanLocatorUtil.locate(com.cloud.tags.service.ClpSerializer.getServletContextName(),
					StoreDeviceMapPersistence.class.getName());

			ReferenceRegistry.registerReference(StoreDeviceMapUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StoreDeviceMapPersistence persistence) {
	}

	private static StoreDeviceMapPersistence _persistence;
}