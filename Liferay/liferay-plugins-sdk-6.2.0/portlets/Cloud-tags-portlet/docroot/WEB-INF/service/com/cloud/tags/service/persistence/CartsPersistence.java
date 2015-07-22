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

import com.cloud.tags.model.Carts;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the carts service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see CartsPersistenceImpl
 * @see CartsUtil
 * @generated
 */
public interface CartsPersistence extends BasePersistence<Carts> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CartsUtil} to access the carts persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the cartses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching cartses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Carts> findByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cartses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of cartses
	* @param end the upper bound of the range of cartses (not inclusive)
	* @return the range of matching cartses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Carts> findByuserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cartses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of cartses
	* @param end the upper bound of the range of cartses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cartses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Carts> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first carts in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching carts
	* @throws com.cloud.tags.NoSuchCartsException if a matching carts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Carts findByuserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCartsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first carts in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching carts, or <code>null</code> if a matching carts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Carts fetchByuserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last carts in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching carts
	* @throws com.cloud.tags.NoSuchCartsException if a matching carts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Carts findByuserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCartsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last carts in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching carts, or <code>null</code> if a matching carts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Carts fetchByuserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cartses before and after the current carts in the ordered set where userId = &#63;.
	*
	* @param cartId the primary key of the current carts
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next carts
	* @throws com.cloud.tags.NoSuchCartsException if a carts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Carts[] findByuserId_PrevAndNext(long cartId,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCartsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cartses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cartses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching cartses
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cartses where session_id = &#63;.
	*
	* @param session_id the session_id
	* @return the matching cartses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Carts> findBysession_id(
		java.lang.String session_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cartses where session_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param session_id the session_id
	* @param start the lower bound of the range of cartses
	* @param end the upper bound of the range of cartses (not inclusive)
	* @return the range of matching cartses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Carts> findBysession_id(
		java.lang.String session_id, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cartses where session_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param session_id the session_id
	* @param start the lower bound of the range of cartses
	* @param end the upper bound of the range of cartses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cartses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Carts> findBysession_id(
		java.lang.String session_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first carts in the ordered set where session_id = &#63;.
	*
	* @param session_id the session_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching carts
	* @throws com.cloud.tags.NoSuchCartsException if a matching carts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Carts findBysession_id_First(
		java.lang.String session_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCartsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first carts in the ordered set where session_id = &#63;.
	*
	* @param session_id the session_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching carts, or <code>null</code> if a matching carts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Carts fetchBysession_id_First(
		java.lang.String session_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last carts in the ordered set where session_id = &#63;.
	*
	* @param session_id the session_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching carts
	* @throws com.cloud.tags.NoSuchCartsException if a matching carts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Carts findBysession_id_Last(
		java.lang.String session_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCartsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last carts in the ordered set where session_id = &#63;.
	*
	* @param session_id the session_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching carts, or <code>null</code> if a matching carts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Carts fetchBysession_id_Last(
		java.lang.String session_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cartses before and after the current carts in the ordered set where session_id = &#63;.
	*
	* @param cartId the primary key of the current carts
	* @param session_id the session_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next carts
	* @throws com.cloud.tags.NoSuchCartsException if a carts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Carts[] findBysession_id_PrevAndNext(
		long cartId, java.lang.String session_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCartsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cartses where session_id = &#63; from the database.
	*
	* @param session_id the session_id
	* @throws SystemException if a system exception occurred
	*/
	public void removeBysession_id(java.lang.String session_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cartses where session_id = &#63;.
	*
	* @param session_id the session_id
	* @return the number of matching cartses
	* @throws SystemException if a system exception occurred
	*/
	public int countBysession_id(java.lang.String session_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the carts in the entity cache if it is enabled.
	*
	* @param carts the carts
	*/
	public void cacheResult(com.cloud.tags.model.Carts carts);

	/**
	* Caches the cartses in the entity cache if it is enabled.
	*
	* @param cartses the cartses
	*/
	public void cacheResult(java.util.List<com.cloud.tags.model.Carts> cartses);

	/**
	* Creates a new carts with the primary key. Does not add the carts to the database.
	*
	* @param cartId the primary key for the new carts
	* @return the new carts
	*/
	public com.cloud.tags.model.Carts create(long cartId);

	/**
	* Removes the carts with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cartId the primary key of the carts
	* @return the carts that was removed
	* @throws com.cloud.tags.NoSuchCartsException if a carts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Carts remove(long cartId)
		throws com.cloud.tags.NoSuchCartsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cloud.tags.model.Carts updateImpl(
		com.cloud.tags.model.Carts carts)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the carts with the primary key or throws a {@link com.cloud.tags.NoSuchCartsException} if it could not be found.
	*
	* @param cartId the primary key of the carts
	* @return the carts
	* @throws com.cloud.tags.NoSuchCartsException if a carts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Carts findByPrimaryKey(long cartId)
		throws com.cloud.tags.NoSuchCartsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the carts with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cartId the primary key of the carts
	* @return the carts, or <code>null</code> if a carts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Carts fetchByPrimaryKey(long cartId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cartses.
	*
	* @return the cartses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Carts> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cartses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cartses
	* @param end the upper bound of the range of cartses (not inclusive)
	* @return the range of cartses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Carts> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cartses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cartses
	* @param end the upper bound of the range of cartses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cartses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Carts> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cartses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cartses.
	*
	* @return the number of cartses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}