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

import com.cloud.tags.model.DesignersBarcode;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the designers barcode service. This utility wraps {@link DesignersBarcodePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see DesignersBarcodePersistence
 * @see DesignersBarcodePersistenceImpl
 * @generated
 */
public class DesignersBarcodeUtil {
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
	public static void clearCache(DesignersBarcode designersBarcode) {
		getPersistence().clearCache(designersBarcode);
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
	public static List<DesignersBarcode> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DesignersBarcode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DesignersBarcode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static DesignersBarcode update(DesignersBarcode designersBarcode)
		throws SystemException {
		return getPersistence().update(designersBarcode);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static DesignersBarcode update(DesignersBarcode designersBarcode,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(designersBarcode, serviceContext);
	}

	/**
	* Returns the designers barcode where barcodeId = &#63; or throws a {@link com.cloud.tags.NoSuchDesignersBarcodeException} if it could not be found.
	*
	* @param barcodeId the barcode ID
	* @return the matching designers barcode
	* @throws com.cloud.tags.NoSuchDesignersBarcodeException if a matching designers barcode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.DesignersBarcode findByBarcodeId(
		long barcodeId)
		throws com.cloud.tags.NoSuchDesignersBarcodeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBarcodeId(barcodeId);
	}

	/**
	* Returns the designers barcode where barcodeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param barcodeId the barcode ID
	* @return the matching designers barcode, or <code>null</code> if a matching designers barcode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.DesignersBarcode fetchByBarcodeId(
		long barcodeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBarcodeId(barcodeId);
	}

	/**
	* Returns the designers barcode where barcodeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param barcodeId the barcode ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching designers barcode, or <code>null</code> if a matching designers barcode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.DesignersBarcode fetchByBarcodeId(
		long barcodeId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBarcodeId(barcodeId, retrieveFromCache);
	}

	/**
	* Removes the designers barcode where barcodeId = &#63; from the database.
	*
	* @param barcodeId the barcode ID
	* @return the designers barcode that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.DesignersBarcode removeByBarcodeId(
		long barcodeId)
		throws com.cloud.tags.NoSuchDesignersBarcodeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByBarcodeId(barcodeId);
	}

	/**
	* Returns the number of designers barcodes where barcodeId = &#63;.
	*
	* @param barcodeId the barcode ID
	* @return the number of matching designers barcodes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBarcodeId(long barcodeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBarcodeId(barcodeId);
	}

	/**
	* Caches the designers barcode in the entity cache if it is enabled.
	*
	* @param designersBarcode the designers barcode
	*/
	public static void cacheResult(
		com.cloud.tags.model.DesignersBarcode designersBarcode) {
		getPersistence().cacheResult(designersBarcode);
	}

	/**
	* Caches the designers barcodes in the entity cache if it is enabled.
	*
	* @param designersBarcodes the designers barcodes
	*/
	public static void cacheResult(
		java.util.List<com.cloud.tags.model.DesignersBarcode> designersBarcodes) {
		getPersistence().cacheResult(designersBarcodes);
	}

	/**
	* Creates a new designers barcode with the primary key. Does not add the designers barcode to the database.
	*
	* @param designerBarcodeId the primary key for the new designers barcode
	* @return the new designers barcode
	*/
	public static com.cloud.tags.model.DesignersBarcode create(
		long designerBarcodeId) {
		return getPersistence().create(designerBarcodeId);
	}

	/**
	* Removes the designers barcode with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param designerBarcodeId the primary key of the designers barcode
	* @return the designers barcode that was removed
	* @throws com.cloud.tags.NoSuchDesignersBarcodeException if a designers barcode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.DesignersBarcode remove(
		long designerBarcodeId)
		throws com.cloud.tags.NoSuchDesignersBarcodeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(designerBarcodeId);
	}

	public static com.cloud.tags.model.DesignersBarcode updateImpl(
		com.cloud.tags.model.DesignersBarcode designersBarcode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(designersBarcode);
	}

	/**
	* Returns the designers barcode with the primary key or throws a {@link com.cloud.tags.NoSuchDesignersBarcodeException} if it could not be found.
	*
	* @param designerBarcodeId the primary key of the designers barcode
	* @return the designers barcode
	* @throws com.cloud.tags.NoSuchDesignersBarcodeException if a designers barcode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.DesignersBarcode findByPrimaryKey(
		long designerBarcodeId)
		throws com.cloud.tags.NoSuchDesignersBarcodeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(designerBarcodeId);
	}

	/**
	* Returns the designers barcode with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param designerBarcodeId the primary key of the designers barcode
	* @return the designers barcode, or <code>null</code> if a designers barcode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.DesignersBarcode fetchByPrimaryKey(
		long designerBarcodeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(designerBarcodeId);
	}

	/**
	* Returns all the designers barcodes.
	*
	* @return the designers barcodes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.DesignersBarcode> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the designers barcodes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersBarcodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of designers barcodes
	* @param end the upper bound of the range of designers barcodes (not inclusive)
	* @return the range of designers barcodes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.DesignersBarcode> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the designers barcodes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersBarcodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of designers barcodes
	* @param end the upper bound of the range of designers barcodes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of designers barcodes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.DesignersBarcode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the designers barcodes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of designers barcodes.
	*
	* @return the number of designers barcodes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DesignersBarcodePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DesignersBarcodePersistence)PortletBeanLocatorUtil.locate(com.cloud.tags.service.ClpSerializer.getServletContextName(),
					DesignersBarcodePersistence.class.getName());

			ReferenceRegistry.registerReference(DesignersBarcodeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DesignersBarcodePersistence persistence) {
	}

	private static DesignersBarcodePersistence _persistence;
}