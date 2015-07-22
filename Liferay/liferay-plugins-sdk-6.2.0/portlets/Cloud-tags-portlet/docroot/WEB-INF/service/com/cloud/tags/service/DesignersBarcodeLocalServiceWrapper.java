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
 * Provides a wrapper for {@link DesignersBarcodeLocalService}.
 *
 * @author Mohammed Zaheer
 * @see DesignersBarcodeLocalService
 * @generated
 */
public class DesignersBarcodeLocalServiceWrapper
	implements DesignersBarcodeLocalService,
		ServiceWrapper<DesignersBarcodeLocalService> {
	public DesignersBarcodeLocalServiceWrapper(
		DesignersBarcodeLocalService designersBarcodeLocalService) {
		_designersBarcodeLocalService = designersBarcodeLocalService;
	}

	/**
	* Adds the designers barcode to the database. Also notifies the appropriate model listeners.
	*
	* @param designersBarcode the designers barcode
	* @return the designers barcode that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.DesignersBarcode addDesignersBarcode(
		com.cloud.tags.model.DesignersBarcode designersBarcode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersBarcodeLocalService.addDesignersBarcode(designersBarcode);
	}

	/**
	* Creates a new designers barcode with the primary key. Does not add the designers barcode to the database.
	*
	* @param designerBarcodeId the primary key for the new designers barcode
	* @return the new designers barcode
	*/
	@Override
	public com.cloud.tags.model.DesignersBarcode createDesignersBarcode(
		long designerBarcodeId) {
		return _designersBarcodeLocalService.createDesignersBarcode(designerBarcodeId);
	}

	/**
	* Deletes the designers barcode with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param designerBarcodeId the primary key of the designers barcode
	* @return the designers barcode that was removed
	* @throws PortalException if a designers barcode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.DesignersBarcode deleteDesignersBarcode(
		long designerBarcodeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _designersBarcodeLocalService.deleteDesignersBarcode(designerBarcodeId);
	}

	/**
	* Deletes the designers barcode from the database. Also notifies the appropriate model listeners.
	*
	* @param designersBarcode the designers barcode
	* @return the designers barcode that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.DesignersBarcode deleteDesignersBarcode(
		com.cloud.tags.model.DesignersBarcode designersBarcode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersBarcodeLocalService.deleteDesignersBarcode(designersBarcode);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _designersBarcodeLocalService.dynamicQuery();
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
		return _designersBarcodeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersBarcodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _designersBarcodeLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersBarcodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _designersBarcodeLocalService.dynamicQuery(dynamicQuery, start,
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
		return _designersBarcodeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _designersBarcodeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.cloud.tags.model.DesignersBarcode fetchDesignersBarcode(
		long designerBarcodeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersBarcodeLocalService.fetchDesignersBarcode(designerBarcodeId);
	}

	/**
	* Returns the designers barcode with the primary key.
	*
	* @param designerBarcodeId the primary key of the designers barcode
	* @return the designers barcode
	* @throws PortalException if a designers barcode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.DesignersBarcode getDesignersBarcode(
		long designerBarcodeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _designersBarcodeLocalService.getDesignersBarcode(designerBarcodeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _designersBarcodeLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.cloud.tags.model.DesignersBarcode> getDesignersBarcodes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersBarcodeLocalService.getDesignersBarcodes(start, end);
	}

	/**
	* Returns the number of designers barcodes.
	*
	* @return the number of designers barcodes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDesignersBarcodesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersBarcodeLocalService.getDesignersBarcodesCount();
	}

	/**
	* Updates the designers barcode in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param designersBarcode the designers barcode
	* @return the designers barcode that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.DesignersBarcode updateDesignersBarcode(
		com.cloud.tags.model.DesignersBarcode designersBarcode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersBarcodeLocalService.updateDesignersBarcode(designersBarcode);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _designersBarcodeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_designersBarcodeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _designersBarcodeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.cloud.tags.model.DesignersBarcode findByBarcodeId(long barcodeId)
		throws com.cloud.tags.NoSuchDesignersBarcodeException,
			com.liferay.portal.kernel.exception.SystemException {
		return _designersBarcodeLocalService.findByBarcodeId(barcodeId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DesignersBarcodeLocalService getWrappedDesignersBarcodeLocalService() {
		return _designersBarcodeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDesignersBarcodeLocalService(
		DesignersBarcodeLocalService designersBarcodeLocalService) {
		_designersBarcodeLocalService = designersBarcodeLocalService;
	}

	@Override
	public DesignersBarcodeLocalService getWrappedService() {
		return _designersBarcodeLocalService;
	}

	@Override
	public void setWrappedService(
		DesignersBarcodeLocalService designersBarcodeLocalService) {
		_designersBarcodeLocalService = designersBarcodeLocalService;
	}

	private DesignersBarcodeLocalService _designersBarcodeLocalService;
}