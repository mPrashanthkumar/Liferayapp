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

import com.cloud.tags.model.StoreInformationMap;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the store information map service. This utility wraps {@link StoreInformationMapPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see StoreInformationMapPersistence
 * @see StoreInformationMapPersistenceImpl
 * @generated
 */
public class StoreInformationMapUtil {
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
	public static void clearCache(StoreInformationMap storeInformationMap) {
		getPersistence().clearCache(storeInformationMap);
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
	public static List<StoreInformationMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StoreInformationMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StoreInformationMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static StoreInformationMap update(
		StoreInformationMap storeInformationMap) throws SystemException {
		return getPersistence().update(storeInformationMap);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static StoreInformationMap update(
		StoreInformationMap storeInformationMap, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(storeInformationMap, serviceContext);
	}

	/**
	* Caches the store information map in the entity cache if it is enabled.
	*
	* @param storeInformationMap the store information map
	*/
	public static void cacheResult(
		com.cloud.tags.model.StoreInformationMap storeInformationMap) {
		getPersistence().cacheResult(storeInformationMap);
	}

	/**
	* Caches the store information maps in the entity cache if it is enabled.
	*
	* @param storeInformationMaps the store information maps
	*/
	public static void cacheResult(
		java.util.List<com.cloud.tags.model.StoreInformationMap> storeInformationMaps) {
		getPersistence().cacheResult(storeInformationMaps);
	}

	/**
	* Creates a new store information map with the primary key. Does not add the store information map to the database.
	*
	* @param uuid the primary key for the new store information map
	* @return the new store information map
	*/
	public static com.cloud.tags.model.StoreInformationMap create(long uuid) {
		return getPersistence().create(uuid);
	}

	/**
	* Removes the store information map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param uuid the primary key of the store information map
	* @return the store information map that was removed
	* @throws com.cloud.tags.NoSuchStoreInformationMapException if a store information map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.StoreInformationMap remove(long uuid)
		throws com.cloud.tags.NoSuchStoreInformationMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(uuid);
	}

	public static com.cloud.tags.model.StoreInformationMap updateImpl(
		com.cloud.tags.model.StoreInformationMap storeInformationMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(storeInformationMap);
	}

	/**
	* Returns the store information map with the primary key or throws a {@link com.cloud.tags.NoSuchStoreInformationMapException} if it could not be found.
	*
	* @param uuid the primary key of the store information map
	* @return the store information map
	* @throws com.cloud.tags.NoSuchStoreInformationMapException if a store information map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.StoreInformationMap findByPrimaryKey(
		long uuid)
		throws com.cloud.tags.NoSuchStoreInformationMapException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(uuid);
	}

	/**
	* Returns the store information map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param uuid the primary key of the store information map
	* @return the store information map, or <code>null</code> if a store information map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.StoreInformationMap fetchByPrimaryKey(
		long uuid) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(uuid);
	}

	/**
	* Returns all the store information maps.
	*
	* @return the store information maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.StoreInformationMap> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.cloud.tags.model.StoreInformationMap> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the store information maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.StoreInformationMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of store information maps
	* @param end the upper bound of the range of store information maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of store information maps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.StoreInformationMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the store information maps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of store information maps.
	*
	* @return the number of store information maps
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StoreInformationMapPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StoreInformationMapPersistence)PortletBeanLocatorUtil.locate(com.cloud.tags.service.ClpSerializer.getServletContextName(),
					StoreInformationMapPersistence.class.getName());

			ReferenceRegistry.registerReference(StoreInformationMapUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StoreInformationMapPersistence persistence) {
	}

	private static StoreInformationMapPersistence _persistence;
}