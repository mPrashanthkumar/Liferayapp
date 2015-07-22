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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the store information map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see StoreInformationMapPersistenceImpl
 * @see StoreInformationMapUtil
 * @generated
 */
public interface StoreInformationMapPersistence extends BasePersistence<StoreInformationMap> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StoreInformationMapUtil} to access the store information map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the store information map in the entity cache if it is enabled.
	*
	* @param storeInformationMap the store information map
	*/
	public void cacheResult(
		com.cloud.tags.model.StoreInformationMap storeInformationMap);

	/**
	* Caches the store information maps in the entity cache if it is enabled.
	*
	* @param storeInformationMaps the store information maps
	*/
	public void cacheResult(
		java.util.List<com.cloud.tags.model.StoreInformationMap> storeInformationMaps);

	/**
	* Creates a new store information map with the primary key. Does not add the store information map to the database.
	*
	* @param uuid the primary key for the new store information map
	* @return the new store information map
	*/
	public com.cloud.tags.model.StoreInformationMap create(long uuid);

	/**
	* Removes the store information map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param uuid the primary key of the store information map
	* @return the store information map that was removed
	* @throws com.cloud.tags.NoSuchStoreInformationMapException if a store information map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.StoreInformationMap remove(long uuid)
		throws com.cloud.tags.NoSuchStoreInformationMapException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cloud.tags.model.StoreInformationMap updateImpl(
		com.cloud.tags.model.StoreInformationMap storeInformationMap)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the store information map with the primary key or throws a {@link com.cloud.tags.NoSuchStoreInformationMapException} if it could not be found.
	*
	* @param uuid the primary key of the store information map
	* @return the store information map
	* @throws com.cloud.tags.NoSuchStoreInformationMapException if a store information map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.StoreInformationMap findByPrimaryKey(long uuid)
		throws com.cloud.tags.NoSuchStoreInformationMapException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the store information map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param uuid the primary key of the store information map
	* @return the store information map, or <code>null</code> if a store information map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.StoreInformationMap fetchByPrimaryKey(long uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the store information maps.
	*
	* @return the store information maps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.StoreInformationMap> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cloud.tags.model.StoreInformationMap> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cloud.tags.model.StoreInformationMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the store information maps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of store information maps.
	*
	* @return the number of store information maps
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}