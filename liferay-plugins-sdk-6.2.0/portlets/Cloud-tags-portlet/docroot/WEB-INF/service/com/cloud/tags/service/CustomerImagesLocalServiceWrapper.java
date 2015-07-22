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
 * Provides a wrapper for {@link CustomerImagesLocalService}.
 *
 * @author Mohammed Zaheer
 * @see CustomerImagesLocalService
 * @generated
 */
public class CustomerImagesLocalServiceWrapper
	implements CustomerImagesLocalService,
		ServiceWrapper<CustomerImagesLocalService> {
	public CustomerImagesLocalServiceWrapper(
		CustomerImagesLocalService customerImagesLocalService) {
		_customerImagesLocalService = customerImagesLocalService;
	}

	/**
	* Adds the customer images to the database. Also notifies the appropriate model listeners.
	*
	* @param customerImages the customer images
	* @return the customer images that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.CustomerImages addCustomerImages(
		com.cloud.tags.model.CustomerImages customerImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerImagesLocalService.addCustomerImages(customerImages);
	}

	/**
	* Creates a new customer images with the primary key. Does not add the customer images to the database.
	*
	* @param customerImageId the primary key for the new customer images
	* @return the new customer images
	*/
	@Override
	public com.cloud.tags.model.CustomerImages createCustomerImages(
		long customerImageId) {
		return _customerImagesLocalService.createCustomerImages(customerImageId);
	}

	/**
	* Deletes the customer images with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param customerImageId the primary key of the customer images
	* @return the customer images that was removed
	* @throws PortalException if a customer images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.CustomerImages deleteCustomerImages(
		long customerImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _customerImagesLocalService.deleteCustomerImages(customerImageId);
	}

	/**
	* Deletes the customer images from the database. Also notifies the appropriate model listeners.
	*
	* @param customerImages the customer images
	* @return the customer images that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.CustomerImages deleteCustomerImages(
		com.cloud.tags.model.CustomerImages customerImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerImagesLocalService.deleteCustomerImages(customerImages);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _customerImagesLocalService.dynamicQuery();
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
		return _customerImagesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CustomerImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _customerImagesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CustomerImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _customerImagesLocalService.dynamicQuery(dynamicQuery, start,
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
		return _customerImagesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _customerImagesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.cloud.tags.model.CustomerImages fetchCustomerImages(
		long customerImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerImagesLocalService.fetchCustomerImages(customerImageId);
	}

	/**
	* Returns the customer images with the primary key.
	*
	* @param customerImageId the primary key of the customer images
	* @return the customer images
	* @throws PortalException if a customer images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.CustomerImages getCustomerImages(
		long customerImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _customerImagesLocalService.getCustomerImages(customerImageId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _customerImagesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the customer imageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CustomerImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of customer imageses
	* @param end the upper bound of the range of customer imageses (not inclusive)
	* @return the range of customer imageses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.cloud.tags.model.CustomerImages> getCustomerImageses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerImagesLocalService.getCustomerImageses(start, end);
	}

	/**
	* Returns the number of customer imageses.
	*
	* @return the number of customer imageses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCustomerImagesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerImagesLocalService.getCustomerImagesesCount();
	}

	/**
	* Updates the customer images in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param customerImages the customer images
	* @return the customer images that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.CustomerImages updateCustomerImages(
		com.cloud.tags.model.CustomerImages customerImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerImagesLocalService.updateCustomerImages(customerImages);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _customerImagesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_customerImagesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _customerImagesLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.cloud.tags.model.CustomerImages> getByproductSKU(
		java.lang.String productcode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerImagesLocalService.getByproductSKU(productcode);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CustomerImagesLocalService getWrappedCustomerImagesLocalService() {
		return _customerImagesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCustomerImagesLocalService(
		CustomerImagesLocalService customerImagesLocalService) {
		_customerImagesLocalService = customerImagesLocalService;
	}

	@Override
	public CustomerImagesLocalService getWrappedService() {
		return _customerImagesLocalService;
	}

	@Override
	public void setWrappedService(
		CustomerImagesLocalService customerImagesLocalService) {
		_customerImagesLocalService = customerImagesLocalService;
	}

	private CustomerImagesLocalService _customerImagesLocalService;
}