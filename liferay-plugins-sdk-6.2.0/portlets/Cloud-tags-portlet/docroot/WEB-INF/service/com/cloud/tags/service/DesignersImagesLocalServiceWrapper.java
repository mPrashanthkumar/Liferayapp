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
 * Provides a wrapper for {@link DesignersImagesLocalService}.
 *
 * @author Mohammed Zaheer
 * @see DesignersImagesLocalService
 * @generated
 */
public class DesignersImagesLocalServiceWrapper
	implements DesignersImagesLocalService,
		ServiceWrapper<DesignersImagesLocalService> {
	public DesignersImagesLocalServiceWrapper(
		DesignersImagesLocalService designersImagesLocalService) {
		_designersImagesLocalService = designersImagesLocalService;
	}

	/**
	* Adds the designers images to the database. Also notifies the appropriate model listeners.
	*
	* @param designersImages the designers images
	* @return the designers images that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.DesignersImages addDesignersImages(
		com.cloud.tags.model.DesignersImages designersImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersImagesLocalService.addDesignersImages(designersImages);
	}

	/**
	* Creates a new designers images with the primary key. Does not add the designers images to the database.
	*
	* @param designImageId the primary key for the new designers images
	* @return the new designers images
	*/
	@Override
	public com.cloud.tags.model.DesignersImages createDesignersImages(
		long designImageId) {
		return _designersImagesLocalService.createDesignersImages(designImageId);
	}

	/**
	* Deletes the designers images with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param designImageId the primary key of the designers images
	* @return the designers images that was removed
	* @throws PortalException if a designers images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.DesignersImages deleteDesignersImages(
		long designImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _designersImagesLocalService.deleteDesignersImages(designImageId);
	}

	/**
	* Deletes the designers images from the database. Also notifies the appropriate model listeners.
	*
	* @param designersImages the designers images
	* @return the designers images that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.DesignersImages deleteDesignersImages(
		com.cloud.tags.model.DesignersImages designersImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersImagesLocalService.deleteDesignersImages(designersImages);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _designersImagesLocalService.dynamicQuery();
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
		return _designersImagesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _designersImagesLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _designersImagesLocalService.dynamicQuery(dynamicQuery, start,
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
		return _designersImagesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _designersImagesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.cloud.tags.model.DesignersImages fetchDesignersImages(
		long designImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersImagesLocalService.fetchDesignersImages(designImageId);
	}

	/**
	* Returns the designers images with the primary key.
	*
	* @param designImageId the primary key of the designers images
	* @return the designers images
	* @throws PortalException if a designers images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.DesignersImages getDesignersImages(
		long designImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _designersImagesLocalService.getDesignersImages(designImageId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _designersImagesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the designers imageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of designers imageses
	* @param end the upper bound of the range of designers imageses (not inclusive)
	* @return the range of designers imageses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.cloud.tags.model.DesignersImages> getDesignersImageses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersImagesLocalService.getDesignersImageses(start, end);
	}

	/**
	* Returns the number of designers imageses.
	*
	* @return the number of designers imageses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDesignersImagesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersImagesLocalService.getDesignersImagesesCount();
	}

	/**
	* Updates the designers images in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param designersImages the designers images
	* @return the designers images that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.DesignersImages updateDesignersImages(
		com.cloud.tags.model.DesignersImages designersImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersImagesLocalService.updateDesignersImages(designersImages);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _designersImagesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_designersImagesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _designersImagesLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.cloud.tags.model.DesignersImages getInstance() {
		return _designersImagesLocalService.getInstance();
	}

	@Override
	public com.cloud.tags.model.DesignersImages createDesignersImages(
		long designId, java.lang.String entity_image1,
		java.lang.String entity_image2, java.lang.String entity_image3,
		java.lang.String entity_image4)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersImagesLocalService.createDesignersImages(designId,
			entity_image1, entity_image2, entity_image3, entity_image4);
	}

	@Override
	public com.cloud.tags.model.DesignersImages getByDesignId(long designId)
		throws com.cloud.tags.NoSuchDesignersImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return _designersImagesLocalService.getByDesignId(designId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DesignersImagesLocalService getWrappedDesignersImagesLocalService() {
		return _designersImagesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDesignersImagesLocalService(
		DesignersImagesLocalService designersImagesLocalService) {
		_designersImagesLocalService = designersImagesLocalService;
	}

	@Override
	public DesignersImagesLocalService getWrappedService() {
		return _designersImagesLocalService;
	}

	@Override
	public void setWrappedService(
		DesignersImagesLocalService designersImagesLocalService) {
		_designersImagesLocalService = designersImagesLocalService;
	}

	private DesignersImagesLocalService _designersImagesLocalService;
}