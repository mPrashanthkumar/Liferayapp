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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for DesignersBarcode. This utility wraps
 * {@link com.cloud.tags.service.impl.DesignersBarcodeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mohammed Zaheer
 * @see DesignersBarcodeLocalService
 * @see com.cloud.tags.service.base.DesignersBarcodeLocalServiceBaseImpl
 * @see com.cloud.tags.service.impl.DesignersBarcodeLocalServiceImpl
 * @generated
 */
public class DesignersBarcodeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.cloud.tags.service.impl.DesignersBarcodeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the designers barcode to the database. Also notifies the appropriate model listeners.
	*
	* @param designersBarcode the designers barcode
	* @return the designers barcode that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.DesignersBarcode addDesignersBarcode(
		com.cloud.tags.model.DesignersBarcode designersBarcode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDesignersBarcode(designersBarcode);
	}

	/**
	* Creates a new designers barcode with the primary key. Does not add the designers barcode to the database.
	*
	* @param designerBarcodeId the primary key for the new designers barcode
	* @return the new designers barcode
	*/
	public static com.cloud.tags.model.DesignersBarcode createDesignersBarcode(
		long designerBarcodeId) {
		return getService().createDesignersBarcode(designerBarcodeId);
	}

	/**
	* Deletes the designers barcode with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param designerBarcodeId the primary key of the designers barcode
	* @return the designers barcode that was removed
	* @throws PortalException if a designers barcode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.DesignersBarcode deleteDesignersBarcode(
		long designerBarcodeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDesignersBarcode(designerBarcodeId);
	}

	/**
	* Deletes the designers barcode from the database. Also notifies the appropriate model listeners.
	*
	* @param designersBarcode the designers barcode
	* @return the designers barcode that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.DesignersBarcode deleteDesignersBarcode(
		com.cloud.tags.model.DesignersBarcode designersBarcode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDesignersBarcode(designersBarcode);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.cloud.tags.model.DesignersBarcode fetchDesignersBarcode(
		long designerBarcodeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDesignersBarcode(designerBarcodeId);
	}

	/**
	* Returns the designers barcode with the primary key.
	*
	* @param designerBarcodeId the primary key of the designers barcode
	* @return the designers barcode
	* @throws PortalException if a designers barcode with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.DesignersBarcode getDesignersBarcode(
		long designerBarcodeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDesignersBarcode(designerBarcodeId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.cloud.tags.model.DesignersBarcode> getDesignersBarcodes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDesignersBarcodes(start, end);
	}

	/**
	* Returns the number of designers barcodes.
	*
	* @return the number of designers barcodes
	* @throws SystemException if a system exception occurred
	*/
	public static int getDesignersBarcodesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDesignersBarcodesCount();
	}

	/**
	* Updates the designers barcode in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param designersBarcode the designers barcode
	* @return the designers barcode that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.DesignersBarcode updateDesignersBarcode(
		com.cloud.tags.model.DesignersBarcode designersBarcode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDesignersBarcode(designersBarcode);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.cloud.tags.model.DesignersBarcode findByBarcodeId(
		long barcodeId)
		throws com.cloud.tags.NoSuchDesignersBarcodeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByBarcodeId(barcodeId);
	}

	public static void clearService() {
		_service = null;
	}

	public static DesignersBarcodeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DesignersBarcodeLocalService.class.getName());

			if (invokableLocalService instanceof DesignersBarcodeLocalService) {
				_service = (DesignersBarcodeLocalService)invokableLocalService;
			}
			else {
				_service = new DesignersBarcodeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(DesignersBarcodeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(DesignersBarcodeLocalService service) {
	}

	private static DesignersBarcodeLocalService _service;
}