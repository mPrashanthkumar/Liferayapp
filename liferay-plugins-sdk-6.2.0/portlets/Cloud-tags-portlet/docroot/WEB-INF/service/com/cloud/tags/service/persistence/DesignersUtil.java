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

import com.cloud.tags.model.Designers;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the designers service. This utility wraps {@link DesignersPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see DesignersPersistence
 * @see DesignersPersistenceImpl
 * @generated
 */
public class DesignersUtil {
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
	public static void clearCache(Designers designers) {
		getPersistence().clearCache(designers);
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
	public static List<Designers> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Designers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Designers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Designers update(Designers designers)
		throws SystemException {
		return getPersistence().update(designers);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Designers update(Designers designers,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(designers, serviceContext);
	}

	/**
	* Returns all the designerses where productcode = &#63;.
	*
	* @param productcode the productcode
	* @return the matching designerses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.Designers> findByproductCode(
		java.lang.String productcode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByproductCode(productcode);
	}

	/**
	* Returns a range of all the designerses where productcode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param productcode the productcode
	* @param start the lower bound of the range of designerses
	* @param end the upper bound of the range of designerses (not inclusive)
	* @return the range of matching designerses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.Designers> findByproductCode(
		java.lang.String productcode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByproductCode(productcode, start, end);
	}

	/**
	* Returns an ordered range of all the designerses where productcode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param productcode the productcode
	* @param start the lower bound of the range of designerses
	* @param end the upper bound of the range of designerses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching designerses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.Designers> findByproductCode(
		java.lang.String productcode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByproductCode(productcode, start, end, orderByComparator);
	}

	/**
	* Returns the first designers in the ordered set where productcode = &#63;.
	*
	* @param productcode the productcode
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching designers
	* @throws com.cloud.tags.NoSuchDesignersException if a matching designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Designers findByproductCode_First(
		java.lang.String productcode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByproductCode_First(productcode, orderByComparator);
	}

	/**
	* Returns the first designers in the ordered set where productcode = &#63;.
	*
	* @param productcode the productcode
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching designers, or <code>null</code> if a matching designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Designers fetchByproductCode_First(
		java.lang.String productcode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByproductCode_First(productcode, orderByComparator);
	}

	/**
	* Returns the last designers in the ordered set where productcode = &#63;.
	*
	* @param productcode the productcode
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching designers
	* @throws com.cloud.tags.NoSuchDesignersException if a matching designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Designers findByproductCode_Last(
		java.lang.String productcode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByproductCode_Last(productcode, orderByComparator);
	}

	/**
	* Returns the last designers in the ordered set where productcode = &#63;.
	*
	* @param productcode the productcode
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching designers, or <code>null</code> if a matching designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Designers fetchByproductCode_Last(
		java.lang.String productcode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByproductCode_Last(productcode, orderByComparator);
	}

	/**
	* Returns the designerses before and after the current designers in the ordered set where productcode = &#63;.
	*
	* @param designId the primary key of the current designers
	* @param productcode the productcode
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next designers
	* @throws com.cloud.tags.NoSuchDesignersException if a designers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Designers[] findByproductCode_PrevAndNext(
		long designId, java.lang.String productcode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByproductCode_PrevAndNext(designId, productcode,
			orderByComparator);
	}

	/**
	* Removes all the designerses where productcode = &#63; from the database.
	*
	* @param productcode the productcode
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByproductCode(java.lang.String productcode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByproductCode(productcode);
	}

	/**
	* Returns the number of designerses where productcode = &#63;.
	*
	* @param productcode the productcode
	* @return the number of matching designerses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByproductCode(java.lang.String productcode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByproductCode(productcode);
	}

	/**
	* Returns all the designerses where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching designerses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.Designers> findBybyCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyCompanyId(companyId);
	}

	/**
	* Returns a range of all the designerses where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of designerses
	* @param end the upper bound of the range of designerses (not inclusive)
	* @return the range of matching designerses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.Designers> findBybyCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the designerses where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of designerses
	* @param end the upper bound of the range of designerses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching designerses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.Designers> findBybyCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first designers in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching designers
	* @throws com.cloud.tags.NoSuchDesignersException if a matching designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Designers findBybyCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first designers in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching designers, or <code>null</code> if a matching designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Designers fetchBybyCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last designers in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching designers
	* @throws com.cloud.tags.NoSuchDesignersException if a matching designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Designers findBybyCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last designers in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching designers, or <code>null</code> if a matching designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Designers fetchBybyCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the designerses before and after the current designers in the ordered set where companyId = &#63;.
	*
	* @param designId the primary key of the current designers
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next designers
	* @throws com.cloud.tags.NoSuchDesignersException if a designers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Designers[] findBybyCompanyId_PrevAndNext(
		long designId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybyCompanyId_PrevAndNext(designId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the designerses where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybyCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybyCompanyId(companyId);
	}

	/**
	* Returns the number of designerses where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching designerses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyCompanyId(companyId);
	}

	/**
	* Returns the designers where companyId = &#63; and barcode = &#63; or throws a {@link com.cloud.tags.NoSuchDesignersException} if it could not be found.
	*
	* @param companyId the company ID
	* @param barcode the barcode
	* @return the matching designers
	* @throws com.cloud.tags.NoSuchDesignersException if a matching designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Designers findBybyCompanyIdBarcode(
		long companyId, java.lang.String barcode)
		throws com.cloud.tags.NoSuchDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybyCompanyIdBarcode(companyId, barcode);
	}

	/**
	* Returns the designers where companyId = &#63; and barcode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param barcode the barcode
	* @return the matching designers, or <code>null</code> if a matching designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Designers fetchBybyCompanyIdBarcode(
		long companyId, java.lang.String barcode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyCompanyIdBarcode(companyId, barcode);
	}

	/**
	* Returns the designers where companyId = &#63; and barcode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param barcode the barcode
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching designers, or <code>null</code> if a matching designers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Designers fetchBybyCompanyIdBarcode(
		long companyId, java.lang.String barcode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybyCompanyIdBarcode(companyId, barcode,
			retrieveFromCache);
	}

	/**
	* Removes the designers where companyId = &#63; and barcode = &#63; from the database.
	*
	* @param companyId the company ID
	* @param barcode the barcode
	* @return the designers that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Designers removeBybyCompanyIdBarcode(
		long companyId, java.lang.String barcode)
		throws com.cloud.tags.NoSuchDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeBybyCompanyIdBarcode(companyId, barcode);
	}

	/**
	* Returns the number of designerses where companyId = &#63; and barcode = &#63;.
	*
	* @param companyId the company ID
	* @param barcode the barcode
	* @return the number of matching designerses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyCompanyIdBarcode(long companyId,
		java.lang.String barcode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyCompanyIdBarcode(companyId, barcode);
	}

	/**
	* Caches the designers in the entity cache if it is enabled.
	*
	* @param designers the designers
	*/
	public static void cacheResult(com.cloud.tags.model.Designers designers) {
		getPersistence().cacheResult(designers);
	}

	/**
	* Caches the designerses in the entity cache if it is enabled.
	*
	* @param designerses the designerses
	*/
	public static void cacheResult(
		java.util.List<com.cloud.tags.model.Designers> designerses) {
		getPersistence().cacheResult(designerses);
	}

	/**
	* Creates a new designers with the primary key. Does not add the designers to the database.
	*
	* @param designId the primary key for the new designers
	* @return the new designers
	*/
	public static com.cloud.tags.model.Designers create(long designId) {
		return getPersistence().create(designId);
	}

	/**
	* Removes the designers with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param designId the primary key of the designers
	* @return the designers that was removed
	* @throws com.cloud.tags.NoSuchDesignersException if a designers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Designers remove(long designId)
		throws com.cloud.tags.NoSuchDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(designId);
	}

	public static com.cloud.tags.model.Designers updateImpl(
		com.cloud.tags.model.Designers designers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(designers);
	}

	/**
	* Returns the designers with the primary key or throws a {@link com.cloud.tags.NoSuchDesignersException} if it could not be found.
	*
	* @param designId the primary key of the designers
	* @return the designers
	* @throws com.cloud.tags.NoSuchDesignersException if a designers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Designers findByPrimaryKey(long designId)
		throws com.cloud.tags.NoSuchDesignersException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(designId);
	}

	/**
	* Returns the designers with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param designId the primary key of the designers
	* @return the designers, or <code>null</code> if a designers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Designers fetchByPrimaryKey(
		long designId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(designId);
	}

	/**
	* Returns all the designerses.
	*
	* @return the designerses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.Designers> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the designerses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of designerses
	* @param end the upper bound of the range of designerses (not inclusive)
	* @return the range of designerses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.Designers> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the designerses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of designerses
	* @param end the upper bound of the range of designerses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of designerses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.Designers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the designerses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of designerses.
	*
	* @return the number of designerses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DesignersPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DesignersPersistence)PortletBeanLocatorUtil.locate(com.cloud.tags.service.ClpSerializer.getServletContextName(),
					DesignersPersistence.class.getName());

			ReferenceRegistry.registerReference(DesignersUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DesignersPersistence persistence) {
	}

	private static DesignersPersistence _persistence;
}