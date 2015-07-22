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

import com.cloud.tags.model.CartsDesigners;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the carts designers service. This utility wraps {@link CartsDesignersPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see CartsDesignersPersistence
 * @see CartsDesignersPersistenceImpl
 * @generated
 */
public class CartsDesignersUtil {
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
	public static void clearCache(CartsDesigners cartsDesigners) {
		getPersistence().clearCache(cartsDesigners);
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
	public static List<CartsDesigners> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CartsDesigners> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CartsDesigners> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CartsDesigners update(CartsDesigners cartsDesigners)
		throws SystemException {
		return getPersistence().update(cartsDesigners);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CartsDesigners update(CartsDesigners cartsDesigners,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(cartsDesigners, serviceContext);
	}

	/**
	* Returns all the carts designerses where cartId = &#63;.
	*
	* @param cartId the cart ID
	* @return the matching carts designerses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.CartsDesigners> findByCartId(
		long cartId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCartId(cartId);
	}

	/**
	* Returns a range of all the carts designerses where cartId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsDesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cartId the cart ID
	* @param start the lower bound of the range of carts designerses
	* @param end the upper bound of the range of carts designerses (not inclusive)
	* @return the range of matching carts designerses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.CartsDesigners> findByCartId(
		long cartId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCartId(cartId, start, end);
	}

	/**
	* Returns an ordered range of all the carts designerses where cartId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsDesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cartId the cart ID
	* @param start the lower bound of the range of carts designerses
	* @param end the upper bound of the range of carts designerses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching carts designerses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.CartsDesigners> findByCartId(
		long cartId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCartId(cartId, start, end, orderByComparator);
	}

	/**
	* Returns the first carts designers in the ordered set where cartId = &#63;.
	*
	* @param cartId the cart ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching carts designers
	* @throws com.cloud.tags.NoSuchCartsDesignersException if a matching carts designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.CartsDesigners findByCartId_First(
		long cartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCartsDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCartId_First(cartId, orderByComparator);
	}

	/**
	* Returns the first carts designers in the ordered set where cartId = &#63;.
	*
	* @param cartId the cart ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching carts designers, or <code>null</code> if a matching carts designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.CartsDesigners fetchByCartId_First(
		long cartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCartId_First(cartId, orderByComparator);
	}

	/**
	* Returns the last carts designers in the ordered set where cartId = &#63;.
	*
	* @param cartId the cart ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching carts designers
	* @throws com.cloud.tags.NoSuchCartsDesignersException if a matching carts designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.CartsDesigners findByCartId_Last(
		long cartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCartsDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCartId_Last(cartId, orderByComparator);
	}

	/**
	* Returns the last carts designers in the ordered set where cartId = &#63;.
	*
	* @param cartId the cart ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching carts designers, or <code>null</code> if a matching carts designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.CartsDesigners fetchByCartId_Last(
		long cartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCartId_Last(cartId, orderByComparator);
	}

	/**
	* Returns the carts designerses before and after the current carts designers in the ordered set where cartId = &#63;.
	*
	* @param cartDesignerId the primary key of the current carts designers
	* @param cartId the cart ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next carts designers
	* @throws com.cloud.tags.NoSuchCartsDesignersException if a carts designers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.CartsDesigners[] findByCartId_PrevAndNext(
		long cartDesignerId, long cartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCartsDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCartId_PrevAndNext(cartDesignerId, cartId,
			orderByComparator);
	}

	/**
	* Removes all the carts designerses where cartId = &#63; from the database.
	*
	* @param cartId the cart ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCartId(long cartId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCartId(cartId);
	}

	/**
	* Returns the number of carts designerses where cartId = &#63;.
	*
	* @param cartId the cart ID
	* @return the number of matching carts designerses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCartId(long cartId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCartId(cartId);
	}

	/**
	* Returns all the carts designerses where cartId = &#63;.
	*
	* @param cartId the cart ID
	* @return the matching carts designerses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.CartsDesigners> findByCartIdIsXPComputed(
		long cartId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCartIdIsXPComputed(cartId);
	}

	/**
	* Returns a range of all the carts designerses where cartId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsDesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cartId the cart ID
	* @param start the lower bound of the range of carts designerses
	* @param end the upper bound of the range of carts designerses (not inclusive)
	* @return the range of matching carts designerses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.CartsDesigners> findByCartIdIsXPComputed(
		long cartId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCartIdIsXPComputed(cartId, start, end);
	}

	/**
	* Returns an ordered range of all the carts designerses where cartId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsDesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cartId the cart ID
	* @param start the lower bound of the range of carts designerses
	* @param end the upper bound of the range of carts designerses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching carts designerses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.CartsDesigners> findByCartIdIsXPComputed(
		long cartId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCartIdIsXPComputed(cartId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first carts designers in the ordered set where cartId = &#63;.
	*
	* @param cartId the cart ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching carts designers
	* @throws com.cloud.tags.NoSuchCartsDesignersException if a matching carts designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.CartsDesigners findByCartIdIsXPComputed_First(
		long cartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCartsDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCartIdIsXPComputed_First(cartId, orderByComparator);
	}

	/**
	* Returns the first carts designers in the ordered set where cartId = &#63;.
	*
	* @param cartId the cart ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching carts designers, or <code>null</code> if a matching carts designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.CartsDesigners fetchByCartIdIsXPComputed_First(
		long cartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCartIdIsXPComputed_First(cartId, orderByComparator);
	}

	/**
	* Returns the last carts designers in the ordered set where cartId = &#63;.
	*
	* @param cartId the cart ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching carts designers
	* @throws com.cloud.tags.NoSuchCartsDesignersException if a matching carts designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.CartsDesigners findByCartIdIsXPComputed_Last(
		long cartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCartsDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCartIdIsXPComputed_Last(cartId, orderByComparator);
	}

	/**
	* Returns the last carts designers in the ordered set where cartId = &#63;.
	*
	* @param cartId the cart ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching carts designers, or <code>null</code> if a matching carts designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.CartsDesigners fetchByCartIdIsXPComputed_Last(
		long cartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCartIdIsXPComputed_Last(cartId, orderByComparator);
	}

	/**
	* Returns the carts designerses before and after the current carts designers in the ordered set where cartId = &#63;.
	*
	* @param cartDesignerId the primary key of the current carts designers
	* @param cartId the cart ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next carts designers
	* @throws com.cloud.tags.NoSuchCartsDesignersException if a carts designers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.CartsDesigners[] findByCartIdIsXPComputed_PrevAndNext(
		long cartDesignerId, long cartId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCartsDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCartIdIsXPComputed_PrevAndNext(cartDesignerId,
			cartId, orderByComparator);
	}

	/**
	* Removes all the carts designerses where cartId = &#63; from the database.
	*
	* @param cartId the cart ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCartIdIsXPComputed(long cartId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCartIdIsXPComputed(cartId);
	}

	/**
	* Returns the number of carts designerses where cartId = &#63;.
	*
	* @param cartId the cart ID
	* @return the number of matching carts designerses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCartIdIsXPComputed(long cartId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCartIdIsXPComputed(cartId);
	}

	/**
	* Returns the carts designers where cartId = &#63; and designId = &#63; or throws a {@link com.cloud.tags.NoSuchCartsDesignersException} if it could not be found.
	*
	* @param cartId the cart ID
	* @param designId the design ID
	* @return the matching carts designers
	* @throws com.cloud.tags.NoSuchCartsDesignersException if a matching carts designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.CartsDesigners findByCartIdDesignerId(
		long cartId, long designId)
		throws com.cloud.tags.NoSuchCartsDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCartIdDesignerId(cartId, designId);
	}

	/**
	* Returns the carts designers where cartId = &#63; and designId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cartId the cart ID
	* @param designId the design ID
	* @return the matching carts designers, or <code>null</code> if a matching carts designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.CartsDesigners fetchByCartIdDesignerId(
		long cartId, long designId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCartIdDesignerId(cartId, designId);
	}

	/**
	* Returns the carts designers where cartId = &#63; and designId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cartId the cart ID
	* @param designId the design ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching carts designers, or <code>null</code> if a matching carts designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.CartsDesigners fetchByCartIdDesignerId(
		long cartId, long designId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCartIdDesignerId(cartId, designId, retrieveFromCache);
	}

	/**
	* Removes the carts designers where cartId = &#63; and designId = &#63; from the database.
	*
	* @param cartId the cart ID
	* @param designId the design ID
	* @return the carts designers that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.CartsDesigners removeByCartIdDesignerId(
		long cartId, long designId)
		throws com.cloud.tags.NoSuchCartsDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByCartIdDesignerId(cartId, designId);
	}

	/**
	* Returns the number of carts designerses where cartId = &#63; and designId = &#63;.
	*
	* @param cartId the cart ID
	* @param designId the design ID
	* @return the number of matching carts designerses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCartIdDesignerId(long cartId, long designId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCartIdDesignerId(cartId, designId);
	}

	/**
	* Returns all the carts designerses where staffId = &#63;.
	*
	* @param staffId the staff ID
	* @return the matching carts designerses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.CartsDesigners> findByStaffId(
		java.lang.String staffId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStaffId(staffId);
	}

	/**
	* Returns a range of all the carts designerses where staffId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsDesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param staffId the staff ID
	* @param start the lower bound of the range of carts designerses
	* @param end the upper bound of the range of carts designerses (not inclusive)
	* @return the range of matching carts designerses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.CartsDesigners> findByStaffId(
		java.lang.String staffId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStaffId(staffId, start, end);
	}

	/**
	* Returns an ordered range of all the carts designerses where staffId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsDesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param staffId the staff ID
	* @param start the lower bound of the range of carts designerses
	* @param end the upper bound of the range of carts designerses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching carts designerses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.CartsDesigners> findByStaffId(
		java.lang.String staffId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStaffId(staffId, start, end, orderByComparator);
	}

	/**
	* Returns the first carts designers in the ordered set where staffId = &#63;.
	*
	* @param staffId the staff ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching carts designers
	* @throws com.cloud.tags.NoSuchCartsDesignersException if a matching carts designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.CartsDesigners findByStaffId_First(
		java.lang.String staffId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCartsDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStaffId_First(staffId, orderByComparator);
	}

	/**
	* Returns the first carts designers in the ordered set where staffId = &#63;.
	*
	* @param staffId the staff ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching carts designers, or <code>null</code> if a matching carts designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.CartsDesigners fetchByStaffId_First(
		java.lang.String staffId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStaffId_First(staffId, orderByComparator);
	}

	/**
	* Returns the last carts designers in the ordered set where staffId = &#63;.
	*
	* @param staffId the staff ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching carts designers
	* @throws com.cloud.tags.NoSuchCartsDesignersException if a matching carts designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.CartsDesigners findByStaffId_Last(
		java.lang.String staffId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCartsDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStaffId_Last(staffId, orderByComparator);
	}

	/**
	* Returns the last carts designers in the ordered set where staffId = &#63;.
	*
	* @param staffId the staff ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching carts designers, or <code>null</code> if a matching carts designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.CartsDesigners fetchByStaffId_Last(
		java.lang.String staffId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStaffId_Last(staffId, orderByComparator);
	}

	/**
	* Returns the carts designerses before and after the current carts designers in the ordered set where staffId = &#63;.
	*
	* @param cartDesignerId the primary key of the current carts designers
	* @param staffId the staff ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next carts designers
	* @throws com.cloud.tags.NoSuchCartsDesignersException if a carts designers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.CartsDesigners[] findByStaffId_PrevAndNext(
		long cartDesignerId, java.lang.String staffId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCartsDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStaffId_PrevAndNext(cartDesignerId, staffId,
			orderByComparator);
	}

	/**
	* Removes all the carts designerses where staffId = &#63; from the database.
	*
	* @param staffId the staff ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStaffId(java.lang.String staffId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStaffId(staffId);
	}

	/**
	* Returns the number of carts designerses where staffId = &#63;.
	*
	* @param staffId the staff ID
	* @return the number of matching carts designerses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStaffId(java.lang.String staffId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStaffId(staffId);
	}

	/**
	* Caches the carts designers in the entity cache if it is enabled.
	*
	* @param cartsDesigners the carts designers
	*/
	public static void cacheResult(
		com.cloud.tags.model.CartsDesigners cartsDesigners) {
		getPersistence().cacheResult(cartsDesigners);
	}

	/**
	* Caches the carts designerses in the entity cache if it is enabled.
	*
	* @param cartsDesignerses the carts designerses
	*/
	public static void cacheResult(
		java.util.List<com.cloud.tags.model.CartsDesigners> cartsDesignerses) {
		getPersistence().cacheResult(cartsDesignerses);
	}

	/**
	* Creates a new carts designers with the primary key. Does not add the carts designers to the database.
	*
	* @param cartDesignerId the primary key for the new carts designers
	* @return the new carts designers
	*/
	public static com.cloud.tags.model.CartsDesigners create(
		long cartDesignerId) {
		return getPersistence().create(cartDesignerId);
	}

	/**
	* Removes the carts designers with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cartDesignerId the primary key of the carts designers
	* @return the carts designers that was removed
	* @throws com.cloud.tags.NoSuchCartsDesignersException if a carts designers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.CartsDesigners remove(
		long cartDesignerId)
		throws com.cloud.tags.NoSuchCartsDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(cartDesignerId);
	}

	public static com.cloud.tags.model.CartsDesigners updateImpl(
		com.cloud.tags.model.CartsDesigners cartsDesigners)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(cartsDesigners);
	}

	/**
	* Returns the carts designers with the primary key or throws a {@link com.cloud.tags.NoSuchCartsDesignersException} if it could not be found.
	*
	* @param cartDesignerId the primary key of the carts designers
	* @return the carts designers
	* @throws com.cloud.tags.NoSuchCartsDesignersException if a carts designers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.CartsDesigners findByPrimaryKey(
		long cartDesignerId)
		throws com.cloud.tags.NoSuchCartsDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(cartDesignerId);
	}

	/**
	* Returns the carts designers with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cartDesignerId the primary key of the carts designers
	* @return the carts designers, or <code>null</code> if a carts designers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.CartsDesigners fetchByPrimaryKey(
		long cartDesignerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(cartDesignerId);
	}

	/**
	* Returns all the carts designerses.
	*
	* @return the carts designerses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.CartsDesigners> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the carts designerses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsDesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of carts designerses
	* @param end the upper bound of the range of carts designerses (not inclusive)
	* @return the range of carts designerses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.CartsDesigners> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the carts designerses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsDesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of carts designerses
	* @param end the upper bound of the range of carts designerses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of carts designerses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.CartsDesigners> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the carts designerses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of carts designerses.
	*
	* @return the number of carts designerses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CartsDesignersPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CartsDesignersPersistence)PortletBeanLocatorUtil.locate(com.cloud.tags.service.ClpSerializer.getServletContextName(),
					CartsDesignersPersistence.class.getName());

			ReferenceRegistry.registerReference(CartsDesignersUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CartsDesignersPersistence persistence) {
	}

	private static CartsDesignersPersistence _persistence;
}