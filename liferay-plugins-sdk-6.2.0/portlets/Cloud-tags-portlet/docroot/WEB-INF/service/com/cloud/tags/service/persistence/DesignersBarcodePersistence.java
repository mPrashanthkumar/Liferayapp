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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the designers barcode service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see DesignersBarcodePersistenceImpl
 * @see DesignersBarcodeUtil
 * @generated
 */
public interface DesignersBarcodePersistence extends BasePersistence<DesignersBarcode> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DesignersBarcodeUtil} to access the designers barcode persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the designers barcode where barcodeId = &#63; or throws a {@link com.cloud.tags.NoSuchDesignersBarcodeException} if it could not be found.
	*
	* @param barcodeId the barcode ID
	* @return the matching designers barcode
	* @throws com.cloud.tags.NoSuchDesignersBarcodeException if a matching designers barcode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.DesignersBarcode findByBarcodeId(long barcodeId)
		throws com.cloud.tags.NoSuchDesignersBarcodeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the designers barcode where barcodeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param barcodeId the barcode ID
	* @return the matching designers barcode, or <code>null</code> if a matching designers barcode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.DesignersBarcode fetchByBarcodeId(
		long barcodeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the designers barcode where barcodeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param barcodeId the barcode ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching designers barcode, or <code>null</code> if a matching designers barcode could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.DesignersBarcode fetchByBarcodeId(
		long barcodeId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the designers barcode where barcodeId = &#63; from the database.
	*
	* @param barcodeId the barcode ID
	* @return the designers barcode that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.DesignersBarcode removeByBarcodeId(
		long barcodeId)
		throws com.cloud.tags.NoSuchDesignersBarcodeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of designers barcodes where barcodeId = &#63;.
	*
	* @param barcodeId the barcode ID
	* @return the number of matching designers barcodes
	* @throws SystemException if a system exception occurred
	*/
	public int countByBarcodeId(long barcodeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the designers barcode in the entity cache if it is enabled.
	*
	* @param designersBarcode the designers barcode
	*/
	public void cacheResult(
		com.cloud.tags.model.DesignersBarcode designersBarcode);

	/**
	* Caches the designers barcodes in the entity cache if it is enabled.
	*
	* @param designersBarcodes the designers barcodes
	*/
	public void cacheResult(
		java.util.List<com.cloud.tags.model.DesignersBarcode> designersBarcodes);

	/**
	* Creates a new designers barcode with the primary key. Does not add the designers barcode to the database.
	*
	* @param designerBarcodeId the primary key for the new designers barcode
	* @return the new designers barcode
	*/
	public com.cloud.tags.model.DesignersBarcode create(long designerBarcodeId);

	/**
	* Removes the designers barcode with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param designerBarcodeId the primary key of the designers barcode
	* @return the designers barcode that was removed
	* @throws com.cloud.tags.NoSuchDesignersBarcodeException if a designers barcode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.DesignersBarcode remove(long designerBarcodeId)
		throws com.cloud.tags.NoSuchDesignersBarcodeException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cloud.tags.model.DesignersBarcode updateImpl(
		com.cloud.tags.model.DesignersBarcode designersBarcode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the designers barcode with the primary key or throws a {@link com.cloud.tags.NoSuchDesignersBarcodeException} if it could not be found.
	*
	* @param designerBarcodeId the primary key of the designers barcode
	* @return the designers barcode
	* @throws com.cloud.tags.NoSuchDesignersBarcodeException if a designers barcode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.DesignersBarcode findByPrimaryKey(
		long designerBarcodeId)
		throws com.cloud.tags.NoSuchDesignersBarcodeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the designers barcode with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param designerBarcodeId the primary key of the designers barcode
	* @return the designers barcode, or <code>null</code> if a designers barcode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.DesignersBarcode fetchByPrimaryKey(
		long designerBarcodeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the designers barcodes.
	*
	* @return the designers barcodes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.DesignersBarcode> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cloud.tags.model.DesignersBarcode> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cloud.tags.model.DesignersBarcode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the designers barcodes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of designers barcodes.
	*
	* @return the number of designers barcodes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}