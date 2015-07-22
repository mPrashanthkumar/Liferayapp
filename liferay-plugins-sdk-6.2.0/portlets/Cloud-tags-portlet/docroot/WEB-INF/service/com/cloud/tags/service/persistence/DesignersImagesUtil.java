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

import com.cloud.tags.model.DesignersImages;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the designers images service. This utility wraps {@link DesignersImagesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see DesignersImagesPersistence
 * @see DesignersImagesPersistenceImpl
 * @generated
 */
public class DesignersImagesUtil {
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
	public static void clearCache(DesignersImages designersImages) {
		getPersistence().clearCache(designersImages);
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
	public static List<DesignersImages> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DesignersImages> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DesignersImages> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static DesignersImages update(DesignersImages designersImages)
		throws SystemException {
		return getPersistence().update(designersImages);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static DesignersImages update(DesignersImages designersImages,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(designersImages, serviceContext);
	}

	/**
	* Returns the designers images where designId = &#63; or throws a {@link com.cloud.tags.NoSuchDesignersImagesException} if it could not be found.
	*
	* @param designId the design ID
	* @return the matching designers images
	* @throws com.cloud.tags.NoSuchDesignersImagesException if a matching designers images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.DesignersImages findBydesignId(
		long designId)
		throws com.cloud.tags.NoSuchDesignersImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBydesignId(designId);
	}

	/**
	* Returns the designers images where designId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param designId the design ID
	* @return the matching designers images, or <code>null</code> if a matching designers images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.DesignersImages fetchBydesignId(
		long designId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBydesignId(designId);
	}

	/**
	* Returns the designers images where designId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param designId the design ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching designers images, or <code>null</code> if a matching designers images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.DesignersImages fetchBydesignId(
		long designId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBydesignId(designId, retrieveFromCache);
	}

	/**
	* Removes the designers images where designId = &#63; from the database.
	*
	* @param designId the design ID
	* @return the designers images that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.DesignersImages removeBydesignId(
		long designId)
		throws com.cloud.tags.NoSuchDesignersImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeBydesignId(designId);
	}

	/**
	* Returns the number of designers imageses where designId = &#63;.
	*
	* @param designId the design ID
	* @return the number of matching designers imageses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBydesignId(long designId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBydesignId(designId);
	}

	/**
	* Caches the designers images in the entity cache if it is enabled.
	*
	* @param designersImages the designers images
	*/
	public static void cacheResult(
		com.cloud.tags.model.DesignersImages designersImages) {
		getPersistence().cacheResult(designersImages);
	}

	/**
	* Caches the designers imageses in the entity cache if it is enabled.
	*
	* @param designersImageses the designers imageses
	*/
	public static void cacheResult(
		java.util.List<com.cloud.tags.model.DesignersImages> designersImageses) {
		getPersistence().cacheResult(designersImageses);
	}

	/**
	* Creates a new designers images with the primary key. Does not add the designers images to the database.
	*
	* @param designImageId the primary key for the new designers images
	* @return the new designers images
	*/
	public static com.cloud.tags.model.DesignersImages create(
		long designImageId) {
		return getPersistence().create(designImageId);
	}

	/**
	* Removes the designers images with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param designImageId the primary key of the designers images
	* @return the designers images that was removed
	* @throws com.cloud.tags.NoSuchDesignersImagesException if a designers images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.DesignersImages remove(
		long designImageId)
		throws com.cloud.tags.NoSuchDesignersImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(designImageId);
	}

	public static com.cloud.tags.model.DesignersImages updateImpl(
		com.cloud.tags.model.DesignersImages designersImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(designersImages);
	}

	/**
	* Returns the designers images with the primary key or throws a {@link com.cloud.tags.NoSuchDesignersImagesException} if it could not be found.
	*
	* @param designImageId the primary key of the designers images
	* @return the designers images
	* @throws com.cloud.tags.NoSuchDesignersImagesException if a designers images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.DesignersImages findByPrimaryKey(
		long designImageId)
		throws com.cloud.tags.NoSuchDesignersImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(designImageId);
	}

	/**
	* Returns the designers images with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param designImageId the primary key of the designers images
	* @return the designers images, or <code>null</code> if a designers images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.DesignersImages fetchByPrimaryKey(
		long designImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(designImageId);
	}

	/**
	* Returns all the designers imageses.
	*
	* @return the designers imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.DesignersImages> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.cloud.tags.model.DesignersImages> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the designers imageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of designers imageses
	* @param end the upper bound of the range of designers imageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of designers imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.DesignersImages> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the designers imageses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of designers imageses.
	*
	* @return the number of designers imageses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DesignersImagesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DesignersImagesPersistence)PortletBeanLocatorUtil.locate(com.cloud.tags.service.ClpSerializer.getServletContextName(),
					DesignersImagesPersistence.class.getName());

			ReferenceRegistry.registerReference(DesignersImagesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DesignersImagesPersistence persistence) {
	}

	private static DesignersImagesPersistence _persistence;
}