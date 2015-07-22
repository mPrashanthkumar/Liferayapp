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
 * Provides a wrapper for {@link CartsDesignersLocalService}.
 *
 * @author Mohammed Zaheer
 * @see CartsDesignersLocalService
 * @generated
 */
public class CartsDesignersLocalServiceWrapper
	implements CartsDesignersLocalService,
		ServiceWrapper<CartsDesignersLocalService> {
	public CartsDesignersLocalServiceWrapper(
		CartsDesignersLocalService cartsDesignersLocalService) {
		_cartsDesignersLocalService = cartsDesignersLocalService;
	}

	/**
	* Adds the carts designers to the database. Also notifies the appropriate model listeners.
	*
	* @param cartsDesigners the carts designers
	* @return the carts designers that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.CartsDesigners addCartsDesigners(
		com.cloud.tags.model.CartsDesigners cartsDesigners)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cartsDesignersLocalService.addCartsDesigners(cartsDesigners);
	}

	/**
	* Creates a new carts designers with the primary key. Does not add the carts designers to the database.
	*
	* @param cartDesignerId the primary key for the new carts designers
	* @return the new carts designers
	*/
	@Override
	public com.cloud.tags.model.CartsDesigners createCartsDesigners(
		long cartDesignerId) {
		return _cartsDesignersLocalService.createCartsDesigners(cartDesignerId);
	}

	/**
	* Deletes the carts designers with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cartDesignerId the primary key of the carts designers
	* @return the carts designers that was removed
	* @throws PortalException if a carts designers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.CartsDesigners deleteCartsDesigners(
		long cartDesignerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cartsDesignersLocalService.deleteCartsDesigners(cartDesignerId);
	}

	/**
	* Deletes the carts designers from the database. Also notifies the appropriate model listeners.
	*
	* @param cartsDesigners the carts designers
	* @return the carts designers that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.CartsDesigners deleteCartsDesigners(
		com.cloud.tags.model.CartsDesigners cartsDesigners)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cartsDesignersLocalService.deleteCartsDesigners(cartsDesigners);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cartsDesignersLocalService.dynamicQuery();
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
		return _cartsDesignersLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsDesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _cartsDesignersLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsDesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _cartsDesignersLocalService.dynamicQuery(dynamicQuery, start,
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
		return _cartsDesignersLocalService.dynamicQueryCount(dynamicQuery);
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
		return _cartsDesignersLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.cloud.tags.model.CartsDesigners fetchCartsDesigners(
		long cartDesignerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cartsDesignersLocalService.fetchCartsDesigners(cartDesignerId);
	}

	/**
	* Returns the carts designers with the primary key.
	*
	* @param cartDesignerId the primary key of the carts designers
	* @return the carts designers
	* @throws PortalException if a carts designers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.CartsDesigners getCartsDesigners(
		long cartDesignerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cartsDesignersLocalService.getCartsDesigners(cartDesignerId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cartsDesignersLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.cloud.tags.model.CartsDesigners> getCartsDesignerses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cartsDesignersLocalService.getCartsDesignerses(start, end);
	}

	/**
	* Returns the number of carts designerses.
	*
	* @return the number of carts designerses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCartsDesignersesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cartsDesignersLocalService.getCartsDesignersesCount();
	}

	/**
	* Updates the carts designers in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cartsDesigners the carts designers
	* @return the carts designers that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.CartsDesigners updateCartsDesigners(
		com.cloud.tags.model.CartsDesigners cartsDesigners)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cartsDesignersLocalService.updateCartsDesigners(cartsDesigners);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _cartsDesignersLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cartsDesignersLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cartsDesignersLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.cloud.tags.model.CartsDesigners getInstance() {
		return _cartsDesignersLocalService.getInstance();
	}

	@Override
	public com.cloud.tags.model.CartsDesigners addDesignerToCarts(long cartId,
		long designId, boolean kept)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cartsDesignersLocalService.addDesignerToCarts(cartId, designId,
			kept);
	}

	@Override
	public java.util.List<com.cloud.tags.model.CartsDesigners> findByCartId(
		long cartId) throws com.liferay.portal.kernel.exception.SystemException {
		return _cartsDesignersLocalService.findByCartId(cartId);
	}

	@Override
	public com.cloud.tags.model.CartsDesigners findBycartIdDesignId(
		long cartId, long productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cartsDesignersLocalService.findBycartIdDesignId(cartId,
			productId);
	}

	@Override
	public java.util.List<com.cloud.tags.model.CartsDesigners> findByStaffId(
		java.lang.String staffId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cartsDesignersLocalService.findByStaffId(staffId);
	}

	@Override
	public java.util.List<com.cloud.tags.model.CartsDesigners> findByCartIdIsXPComputed(
		long cartId) throws com.liferay.portal.kernel.exception.SystemException {
		return _cartsDesignersLocalService.findByCartIdIsXPComputed(cartId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CartsDesignersLocalService getWrappedCartsDesignersLocalService() {
		return _cartsDesignersLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCartsDesignersLocalService(
		CartsDesignersLocalService cartsDesignersLocalService) {
		_cartsDesignersLocalService = cartsDesignersLocalService;
	}

	@Override
	public CartsDesignersLocalService getWrappedService() {
		return _cartsDesignersLocalService;
	}

	@Override
	public void setWrappedService(
		CartsDesignersLocalService cartsDesignersLocalService) {
		_cartsDesignersLocalService = cartsDesignersLocalService;
	}

	private CartsDesignersLocalService _cartsDesignersLocalService;
}