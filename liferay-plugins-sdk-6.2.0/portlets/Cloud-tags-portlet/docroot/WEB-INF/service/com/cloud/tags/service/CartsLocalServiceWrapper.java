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
 * Provides a wrapper for {@link CartsLocalService}.
 *
 * @author Mohammed Zaheer
 * @see CartsLocalService
 * @generated
 */
public class CartsLocalServiceWrapper implements CartsLocalService,
	ServiceWrapper<CartsLocalService> {
	public CartsLocalServiceWrapper(CartsLocalService cartsLocalService) {
		_cartsLocalService = cartsLocalService;
	}

	/**
	* Adds the carts to the database. Also notifies the appropriate model listeners.
	*
	* @param carts the carts
	* @return the carts that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.Carts addCarts(com.cloud.tags.model.Carts carts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cartsLocalService.addCarts(carts);
	}

	/**
	* Creates a new carts with the primary key. Does not add the carts to the database.
	*
	* @param cartId the primary key for the new carts
	* @return the new carts
	*/
	@Override
	public com.cloud.tags.model.Carts createCarts(long cartId) {
		return _cartsLocalService.createCarts(cartId);
	}

	/**
	* Deletes the carts with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cartId the primary key of the carts
	* @return the carts that was removed
	* @throws PortalException if a carts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.Carts deleteCarts(long cartId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cartsLocalService.deleteCarts(cartId);
	}

	/**
	* Deletes the carts from the database. Also notifies the appropriate model listeners.
	*
	* @param carts the carts
	* @return the carts that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.Carts deleteCarts(
		com.cloud.tags.model.Carts carts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cartsLocalService.deleteCarts(carts);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cartsLocalService.dynamicQuery();
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
		return _cartsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _cartsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _cartsLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _cartsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _cartsLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.cloud.tags.model.Carts fetchCarts(long cartId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cartsLocalService.fetchCarts(cartId);
	}

	/**
	* Returns the carts with the primary key.
	*
	* @param cartId the primary key of the carts
	* @return the carts
	* @throws PortalException if a carts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.Carts getCarts(long cartId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cartsLocalService.getCarts(cartId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cartsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the cartses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cartses
	* @param end the upper bound of the range of cartses (not inclusive)
	* @return the range of cartses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.cloud.tags.model.Carts> getCartses(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _cartsLocalService.getCartses(start, end);
	}

	/**
	* Returns the number of cartses.
	*
	* @return the number of cartses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCartsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cartsLocalService.getCartsesCount();
	}

	/**
	* Updates the carts in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param carts the carts
	* @return the carts that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.cloud.tags.model.Carts updateCarts(
		com.cloud.tags.model.Carts carts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cartsLocalService.updateCarts(carts);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _cartsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cartsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cartsLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.cloud.tags.model.Carts getInstance() {
		return _cartsLocalService.getInstance();
	}

	@Override
	public com.cloud.tags.model.Carts addToCarts(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cartsLocalService.addToCarts(userId);
	}

	@Override
	public java.util.List<com.cloud.tags.model.Carts> findByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cartsLocalService.findByuserId(userId);
	}

	@Override
	public java.util.List<com.cloud.tags.model.Carts> findBySessionId(
		java.lang.String session_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cartsLocalService.findBySessionId(session_id);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CartsLocalService getWrappedCartsLocalService() {
		return _cartsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCartsLocalService(CartsLocalService cartsLocalService) {
		_cartsLocalService = cartsLocalService;
	}

	@Override
	public CartsLocalService getWrappedService() {
		return _cartsLocalService;
	}

	@Override
	public void setWrappedService(CartsLocalService cartsLocalService) {
		_cartsLocalService = cartsLocalService;
	}

	private CartsLocalService _cartsLocalService;
}