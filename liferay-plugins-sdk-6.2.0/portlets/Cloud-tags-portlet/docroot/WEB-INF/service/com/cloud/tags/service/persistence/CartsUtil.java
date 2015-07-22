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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the carts service. This utility wraps {@link CartsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see CartsPersistence
 * @see CartsPersistenceImpl
 * @generated
 */
public class CartsUtil {
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
	public static void clearCache(Carts carts) {
		getPersistence().clearCache(carts);
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
	public static List<Carts> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Carts> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Carts> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Carts update(Carts carts) throws SystemException {
		return getPersistence().update(carts);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Carts update(Carts carts, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(carts, serviceContext);
	}

	/**
	* Returns all the cartses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching cartses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.Carts> findByuserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuserId(userId);
	}

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
	public static java.util.List<com.cloud.tags.model.Carts> findByuserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuserId(userId, start, end);
	}

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
	public static java.util.List<com.cloud.tags.model.Carts> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first carts in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching carts
	* @throws com.cloud.tags.NoSuchCartsException if a matching carts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Carts findByuserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCartsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first carts in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching carts, or <code>null</code> if a matching carts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Carts fetchByuserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last carts in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching carts
	* @throws com.cloud.tags.NoSuchCartsException if a matching carts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Carts findByuserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCartsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last carts in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching carts, or <code>null</code> if a matching carts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Carts fetchByuserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

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
	public static com.cloud.tags.model.Carts[] findByuserId_PrevAndNext(
		long cartId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCartsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserId_PrevAndNext(cartId, userId, orderByComparator);
	}

	/**
	* Removes all the cartses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByuserId(userId);
	}

	/**
	* Returns the number of cartses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching cartses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByuserId(userId);
	}

	/**
	* Returns all the cartses where session_id = &#63;.
	*
	* @param session_id the session_id
	* @return the matching cartses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.Carts> findBysession_id(
		java.lang.String session_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBysession_id(session_id);
	}

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
	public static java.util.List<com.cloud.tags.model.Carts> findBysession_id(
		java.lang.String session_id, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBysession_id(session_id, start, end);
	}

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
	public static java.util.List<com.cloud.tags.model.Carts> findBysession_id(
		java.lang.String session_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysession_id(session_id, start, end, orderByComparator);
	}

	/**
	* Returns the first carts in the ordered set where session_id = &#63;.
	*
	* @param session_id the session_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching carts
	* @throws com.cloud.tags.NoSuchCartsException if a matching carts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Carts findBysession_id_First(
		java.lang.String session_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCartsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysession_id_First(session_id, orderByComparator);
	}

	/**
	* Returns the first carts in the ordered set where session_id = &#63;.
	*
	* @param session_id the session_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching carts, or <code>null</code> if a matching carts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Carts fetchBysession_id_First(
		java.lang.String session_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBysession_id_First(session_id, orderByComparator);
	}

	/**
	* Returns the last carts in the ordered set where session_id = &#63;.
	*
	* @param session_id the session_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching carts
	* @throws com.cloud.tags.NoSuchCartsException if a matching carts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Carts findBysession_id_Last(
		java.lang.String session_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCartsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysession_id_Last(session_id, orderByComparator);
	}

	/**
	* Returns the last carts in the ordered set where session_id = &#63;.
	*
	* @param session_id the session_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching carts, or <code>null</code> if a matching carts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Carts fetchBysession_id_Last(
		java.lang.String session_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBysession_id_Last(session_id, orderByComparator);
	}

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
	public static com.cloud.tags.model.Carts[] findBysession_id_PrevAndNext(
		long cartId, java.lang.String session_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCartsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysession_id_PrevAndNext(cartId, session_id,
			orderByComparator);
	}

	/**
	* Removes all the cartses where session_id = &#63; from the database.
	*
	* @param session_id the session_id
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBysession_id(java.lang.String session_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBysession_id(session_id);
	}

	/**
	* Returns the number of cartses where session_id = &#63;.
	*
	* @param session_id the session_id
	* @return the number of matching cartses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBysession_id(java.lang.String session_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBysession_id(session_id);
	}

	/**
	* Caches the carts in the entity cache if it is enabled.
	*
	* @param carts the carts
	*/
	public static void cacheResult(com.cloud.tags.model.Carts carts) {
		getPersistence().cacheResult(carts);
	}

	/**
	* Caches the cartses in the entity cache if it is enabled.
	*
	* @param cartses the cartses
	*/
	public static void cacheResult(
		java.util.List<com.cloud.tags.model.Carts> cartses) {
		getPersistence().cacheResult(cartses);
	}

	/**
	* Creates a new carts with the primary key. Does not add the carts to the database.
	*
	* @param cartId the primary key for the new carts
	* @return the new carts
	*/
	public static com.cloud.tags.model.Carts create(long cartId) {
		return getPersistence().create(cartId);
	}

	/**
	* Removes the carts with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cartId the primary key of the carts
	* @return the carts that was removed
	* @throws com.cloud.tags.NoSuchCartsException if a carts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Carts remove(long cartId)
		throws com.cloud.tags.NoSuchCartsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(cartId);
	}

	public static com.cloud.tags.model.Carts updateImpl(
		com.cloud.tags.model.Carts carts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(carts);
	}

	/**
	* Returns the carts with the primary key or throws a {@link com.cloud.tags.NoSuchCartsException} if it could not be found.
	*
	* @param cartId the primary key of the carts
	* @return the carts
	* @throws com.cloud.tags.NoSuchCartsException if a carts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Carts findByPrimaryKey(long cartId)
		throws com.cloud.tags.NoSuchCartsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(cartId);
	}

	/**
	* Returns the carts with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cartId the primary key of the carts
	* @return the carts, or <code>null</code> if a carts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Carts fetchByPrimaryKey(long cartId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(cartId);
	}

	/**
	* Returns all the cartses.
	*
	* @return the cartses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.Carts> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.cloud.tags.model.Carts> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.cloud.tags.model.Carts> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cartses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cartses.
	*
	* @return the number of cartses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CartsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CartsPersistence)PortletBeanLocatorUtil.locate(com.cloud.tags.service.ClpSerializer.getServletContextName(),
					CartsPersistence.class.getName());

			ReferenceRegistry.registerReference(CartsUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CartsPersistence persistence) {
	}

	private static CartsPersistence _persistence;
}