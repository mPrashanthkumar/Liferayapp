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

import com.cloud.tags.model.Recommendations;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the recommendations service. This utility wraps {@link RecommendationsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see RecommendationsPersistence
 * @see RecommendationsPersistenceImpl
 * @generated
 */
public class RecommendationsUtil {
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
	public static void clearCache(Recommendations recommendations) {
		getPersistence().clearCache(recommendations);
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
	public static List<Recommendations> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Recommendations> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Recommendations> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Recommendations update(Recommendations recommendations)
		throws SystemException {
		return getPersistence().update(recommendations);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Recommendations update(Recommendations recommendations,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(recommendations, serviceContext);
	}

	/**
	* Returns all the recommendationses where designer1 = &#63; and _type = &#63; and companyId = &#63;.
	*
	* @param designer1 the designer1
	* @param _type the _type
	* @param companyId the company ID
	* @return the matching recommendationses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.Recommendations> findByByDesigner1Type(
		java.lang.String designer1, long _type, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByDesigner1Type(designer1, _type, companyId);
	}

	/**
	* Returns a range of all the recommendationses where designer1 = &#63; and _type = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.RecommendationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param designer1 the designer1
	* @param _type the _type
	* @param companyId the company ID
	* @param start the lower bound of the range of recommendationses
	* @param end the upper bound of the range of recommendationses (not inclusive)
	* @return the range of matching recommendationses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.Recommendations> findByByDesigner1Type(
		java.lang.String designer1, long _type, long companyId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByDesigner1Type(designer1, _type, companyId, start,
			end);
	}

	/**
	* Returns an ordered range of all the recommendationses where designer1 = &#63; and _type = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.RecommendationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param designer1 the designer1
	* @param _type the _type
	* @param companyId the company ID
	* @param start the lower bound of the range of recommendationses
	* @param end the upper bound of the range of recommendationses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching recommendationses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.Recommendations> findByByDesigner1Type(
		java.lang.String designer1, long _type, long companyId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByDesigner1Type(designer1, _type, companyId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first recommendations in the ordered set where designer1 = &#63; and _type = &#63; and companyId = &#63;.
	*
	* @param designer1 the designer1
	* @param _type the _type
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching recommendations
	* @throws com.cloud.tags.NoSuchRecommendationsException if a matching recommendations could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Recommendations findByByDesigner1Type_First(
		java.lang.String designer1, long _type, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchRecommendationsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByDesigner1Type_First(designer1, _type, companyId,
			orderByComparator);
	}

	/**
	* Returns the first recommendations in the ordered set where designer1 = &#63; and _type = &#63; and companyId = &#63;.
	*
	* @param designer1 the designer1
	* @param _type the _type
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching recommendations, or <code>null</code> if a matching recommendations could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Recommendations fetchByByDesigner1Type_First(
		java.lang.String designer1, long _type, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByByDesigner1Type_First(designer1, _type, companyId,
			orderByComparator);
	}

	/**
	* Returns the last recommendations in the ordered set where designer1 = &#63; and _type = &#63; and companyId = &#63;.
	*
	* @param designer1 the designer1
	* @param _type the _type
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching recommendations
	* @throws com.cloud.tags.NoSuchRecommendationsException if a matching recommendations could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Recommendations findByByDesigner1Type_Last(
		java.lang.String designer1, long _type, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchRecommendationsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByDesigner1Type_Last(designer1, _type, companyId,
			orderByComparator);
	}

	/**
	* Returns the last recommendations in the ordered set where designer1 = &#63; and _type = &#63; and companyId = &#63;.
	*
	* @param designer1 the designer1
	* @param _type the _type
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching recommendations, or <code>null</code> if a matching recommendations could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Recommendations fetchByByDesigner1Type_Last(
		java.lang.String designer1, long _type, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByByDesigner1Type_Last(designer1, _type, companyId,
			orderByComparator);
	}

	/**
	* Returns the recommendationses before and after the current recommendations in the ordered set where designer1 = &#63; and _type = &#63; and companyId = &#63;.
	*
	* @param recId the primary key of the current recommendations
	* @param designer1 the designer1
	* @param _type the _type
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next recommendations
	* @throws com.cloud.tags.NoSuchRecommendationsException if a recommendations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Recommendations[] findByByDesigner1Type_PrevAndNext(
		long recId, java.lang.String designer1, long _type, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchRecommendationsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByDesigner1Type_PrevAndNext(recId, designer1, _type,
			companyId, orderByComparator);
	}

	/**
	* Removes all the recommendationses where designer1 = &#63; and _type = &#63; and companyId = &#63; from the database.
	*
	* @param designer1 the designer1
	* @param _type the _type
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByByDesigner1Type(java.lang.String designer1,
		long _type, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByByDesigner1Type(designer1, _type, companyId);
	}

	/**
	* Returns the number of recommendationses where designer1 = &#63; and _type = &#63; and companyId = &#63;.
	*
	* @param designer1 the designer1
	* @param _type the _type
	* @param companyId the company ID
	* @return the number of matching recommendationses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByByDesigner1Type(java.lang.String designer1,
		long _type, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByByDesigner1Type(designer1, _type, companyId);
	}

	/**
	* Caches the recommendations in the entity cache if it is enabled.
	*
	* @param recommendations the recommendations
	*/
	public static void cacheResult(
		com.cloud.tags.model.Recommendations recommendations) {
		getPersistence().cacheResult(recommendations);
	}

	/**
	* Caches the recommendationses in the entity cache if it is enabled.
	*
	* @param recommendationses the recommendationses
	*/
	public static void cacheResult(
		java.util.List<com.cloud.tags.model.Recommendations> recommendationses) {
		getPersistence().cacheResult(recommendationses);
	}

	/**
	* Creates a new recommendations with the primary key. Does not add the recommendations to the database.
	*
	* @param recId the primary key for the new recommendations
	* @return the new recommendations
	*/
	public static com.cloud.tags.model.Recommendations create(long recId) {
		return getPersistence().create(recId);
	}

	/**
	* Removes the recommendations with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recId the primary key of the recommendations
	* @return the recommendations that was removed
	* @throws com.cloud.tags.NoSuchRecommendationsException if a recommendations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Recommendations remove(long recId)
		throws com.cloud.tags.NoSuchRecommendationsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(recId);
	}

	public static com.cloud.tags.model.Recommendations updateImpl(
		com.cloud.tags.model.Recommendations recommendations)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(recommendations);
	}

	/**
	* Returns the recommendations with the primary key or throws a {@link com.cloud.tags.NoSuchRecommendationsException} if it could not be found.
	*
	* @param recId the primary key of the recommendations
	* @return the recommendations
	* @throws com.cloud.tags.NoSuchRecommendationsException if a recommendations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Recommendations findByPrimaryKey(
		long recId)
		throws com.cloud.tags.NoSuchRecommendationsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(recId);
	}

	/**
	* Returns the recommendations with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recId the primary key of the recommendations
	* @return the recommendations, or <code>null</code> if a recommendations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Recommendations fetchByPrimaryKey(
		long recId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(recId);
	}

	/**
	* Returns all the recommendationses.
	*
	* @return the recommendationses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.Recommendations> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the recommendationses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.RecommendationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of recommendationses
	* @param end the upper bound of the range of recommendationses (not inclusive)
	* @return the range of recommendationses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.Recommendations> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the recommendationses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.RecommendationsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of recommendationses
	* @param end the upper bound of the range of recommendationses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of recommendationses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.Recommendations> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the recommendationses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of recommendationses.
	*
	* @return the number of recommendationses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RecommendationsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RecommendationsPersistence)PortletBeanLocatorUtil.locate(com.cloud.tags.service.ClpSerializer.getServletContextName(),
					RecommendationsPersistence.class.getName());

			ReferenceRegistry.registerReference(RecommendationsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(RecommendationsPersistence persistence) {
	}

	private static RecommendationsPersistence _persistence;
}