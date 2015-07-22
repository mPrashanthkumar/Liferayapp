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
 * Provides a wrapper for {@link DesignersLocalService}.
 *
 * @author Mohammed Zaheer
 * @see DesignersLocalService
 * @generated
 */
public class DesignersLocalServiceWrapper implements DesignersLocalService,
	ServiceWrapper<DesignersLocalService> {
	public DesignersLocalServiceWrapper(
		DesignersLocalService designersLocalService) {
		_designersLocalService = designersLocalService;
	}

	/**
	* Adds the designers to the database. Also notifies the appropriate model listeners.
	*
	* @param designers the designers
	* @return the designers that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.Designers addDesigners(
		com.cloud.tags.model.Designers designers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersLocalService.addDesigners(designers);
	}

	/**
	* Creates a new designers with the primary key. Does not add the designers to the database.
	*
	* @param designId the primary key for the new designers
	* @return the new designers
	*/
	@Override
	public com.cloud.tags.model.Designers createDesigners(long designId) {
		return _designersLocalService.createDesigners(designId);
	}

	/**
	* Deletes the designers with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param designId the primary key of the designers
	* @return the designers that was removed
	* @throws PortalException if a designers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.Designers deleteDesigners(long designId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _designersLocalService.deleteDesigners(designId);
	}

	/**
	* Deletes the designers from the database. Also notifies the appropriate model listeners.
	*
	* @param designers the designers
	* @return the designers that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.Designers deleteDesigners(
		com.cloud.tags.model.Designers designers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersLocalService.deleteDesigners(designers);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _designersLocalService.dynamicQuery();
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
		return _designersLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _designersLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _designersLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _designersLocalService.dynamicQueryCount(dynamicQuery);
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
		return _designersLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.cloud.tags.model.Designers fetchDesigners(long designId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersLocalService.fetchDesigners(designId);
	}

	/**
	* Returns the designers with the primary key.
	*
	* @param designId the primary key of the designers
	* @return the designers
	* @throws PortalException if a designers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.Designers getDesigners(long designId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _designersLocalService.getDesigners(designId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _designersLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.cloud.tags.model.Designers> getDesignerses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersLocalService.getDesignerses(start, end);
	}

	/**
	* Returns the number of designerses.
	*
	* @return the number of designerses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDesignersesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersLocalService.getDesignersesCount();
	}

	/**
	* Updates the designers in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param designers the designers
	* @return the designers that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.Designers updateDesigners(
		com.cloud.tags.model.Designers designers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersLocalService.updateDesigners(designers);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _designersLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_designersLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _designersLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.cloud.tags.model.Designers getInstance() {
		return _designersLocalService.getInstance();
	}

	@Override
	public com.cloud.tags.model.Designers addDesigners(java.lang.String name,
		java.lang.String description, java.lang.String price,
		java.lang.String show_url, long userId, long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersLocalService.addDesigners(name, description, price,
			show_url, userId, companyId, groupId);
	}

	@Override
	public java.util.List<com.cloud.tags.model.Designers> getByproductCode(
		java.lang.String productcode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersLocalService.getByproductCode(productcode);
	}

	@Override
	public java.util.List<com.cloud.tags.model.Designers> getByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersLocalService.getByCompanyId(companyId);
	}

	@Override
	public com.cloud.tags.model.Designers getByCompanyId(long companyId,
		java.lang.String barcode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designersLocalService.getByCompanyId(companyId, barcode);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DesignersLocalService getWrappedDesignersLocalService() {
		return _designersLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDesignersLocalService(
		DesignersLocalService designersLocalService) {
		_designersLocalService = designersLocalService;
	}

	@Override
	public DesignersLocalService getWrappedService() {
		return _designersLocalService;
	}

	@Override
	public void setWrappedService(DesignersLocalService designersLocalService) {
		_designersLocalService = designersLocalService;
	}

	private DesignersLocalService _designersLocalService;
}