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

import com.cloud.tags.model.CustomerImages;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the customer images service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see CustomerImagesPersistenceImpl
 * @see CustomerImagesUtil
 * @generated
 */
public interface CustomerImagesPersistence extends BasePersistence<CustomerImages> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CustomerImagesUtil} to access the customer images persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the customer imageses where designerSKU = &#63;.
	*
	* @param designerSKU the designer s k u
	* @return the matching customer imageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.CustomerImages> findBydesignerSKU(
		java.lang.String designerSKU)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the customer imageses where designerSKU = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CustomerImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param designerSKU the designer s k u
	* @param start the lower bound of the range of customer imageses
	* @param end the upper bound of the range of customer imageses (not inclusive)
	* @return the range of matching customer imageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.CustomerImages> findBydesignerSKU(
		java.lang.String designerSKU, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the customer imageses where designerSKU = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CustomerImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param designerSKU the designer s k u
	* @param start the lower bound of the range of customer imageses
	* @param end the upper bound of the range of customer imageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching customer imageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.CustomerImages> findBydesignerSKU(
		java.lang.String designerSKU, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first customer images in the ordered set where designerSKU = &#63;.
	*
	* @param designerSKU the designer s k u
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching customer images
	* @throws com.cloud.tags.NoSuchCustomerImagesException if a matching customer images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.CustomerImages findBydesignerSKU_First(
		java.lang.String designerSKU,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCustomerImagesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first customer images in the ordered set where designerSKU = &#63;.
	*
	* @param designerSKU the designer s k u
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching customer images, or <code>null</code> if a matching customer images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.CustomerImages fetchBydesignerSKU_First(
		java.lang.String designerSKU,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last customer images in the ordered set where designerSKU = &#63;.
	*
	* @param designerSKU the designer s k u
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching customer images
	* @throws com.cloud.tags.NoSuchCustomerImagesException if a matching customer images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.CustomerImages findBydesignerSKU_Last(
		java.lang.String designerSKU,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCustomerImagesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last customer images in the ordered set where designerSKU = &#63;.
	*
	* @param designerSKU the designer s k u
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching customer images, or <code>null</code> if a matching customer images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.CustomerImages fetchBydesignerSKU_Last(
		java.lang.String designerSKU,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the customer imageses before and after the current customer images in the ordered set where designerSKU = &#63;.
	*
	* @param customerImageId the primary key of the current customer images
	* @param designerSKU the designer s k u
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next customer images
	* @throws com.cloud.tags.NoSuchCustomerImagesException if a customer images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.CustomerImages[] findBydesignerSKU_PrevAndNext(
		long customerImageId, java.lang.String designerSKU,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchCustomerImagesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the customer imageses where designerSKU = &#63; from the database.
	*
	* @param designerSKU the designer s k u
	* @throws SystemException if a system exception occurred
	*/
	public void removeBydesignerSKU(java.lang.String designerSKU)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of customer imageses where designerSKU = &#63;.
	*
	* @param designerSKU the designer s k u
	* @return the number of matching customer imageses
	* @throws SystemException if a system exception occurred
	*/
	public int countBydesignerSKU(java.lang.String designerSKU)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the customer images in the entity cache if it is enabled.
	*
	* @param customerImages the customer images
	*/
	public void cacheResult(com.cloud.tags.model.CustomerImages customerImages);

	/**
	* Caches the customer imageses in the entity cache if it is enabled.
	*
	* @param customerImageses the customer imageses
	*/
	public void cacheResult(
		java.util.List<com.cloud.tags.model.CustomerImages> customerImageses);

	/**
	* Creates a new customer images with the primary key. Does not add the customer images to the database.
	*
	* @param customerImageId the primary key for the new customer images
	* @return the new customer images
	*/
	public com.cloud.tags.model.CustomerImages create(long customerImageId);

	/**
	* Removes the customer images with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param customerImageId the primary key of the customer images
	* @return the customer images that was removed
	* @throws com.cloud.tags.NoSuchCustomerImagesException if a customer images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.CustomerImages remove(long customerImageId)
		throws com.cloud.tags.NoSuchCustomerImagesException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cloud.tags.model.CustomerImages updateImpl(
		com.cloud.tags.model.CustomerImages customerImages)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the customer images with the primary key or throws a {@link com.cloud.tags.NoSuchCustomerImagesException} if it could not be found.
	*
	* @param customerImageId the primary key of the customer images
	* @return the customer images
	* @throws com.cloud.tags.NoSuchCustomerImagesException if a customer images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.CustomerImages findByPrimaryKey(
		long customerImageId)
		throws com.cloud.tags.NoSuchCustomerImagesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the customer images with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param customerImageId the primary key of the customer images
	* @return the customer images, or <code>null</code> if a customer images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.CustomerImages fetchByPrimaryKey(
		long customerImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the customer imageses.
	*
	* @return the customer imageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.CustomerImages> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cloud.tags.model.CustomerImages> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the customer imageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CustomerImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of customer imageses
	* @param end the upper bound of the range of customer imageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of customer imageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.CustomerImages> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the customer imageses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of customer imageses.
	*
	* @return the number of customer imageses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}