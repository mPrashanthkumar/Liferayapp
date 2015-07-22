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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the recommendations service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see RecommendationsPersistenceImpl
 * @see RecommendationsUtil
 * @generated
 */
public interface RecommendationsPersistence extends BasePersistence<Recommendations> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RecommendationsUtil} to access the recommendations persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the recommendationses where designer1 = &#63; and _type = &#63; and companyId = &#63;.
	*
	* @param designer1 the designer1
	* @param _type the _type
	* @param companyId the company ID
	* @return the matching recommendationses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Recommendations> findByByDesigner1Type(
		java.lang.String designer1, long _type, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cloud.tags.model.Recommendations> findByByDesigner1Type(
		java.lang.String designer1, long _type, long companyId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cloud.tags.model.Recommendations> findByByDesigner1Type(
		java.lang.String designer1, long _type, long companyId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.cloud.tags.model.Recommendations findByByDesigner1Type_First(
		java.lang.String designer1, long _type, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchRecommendationsException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.cloud.tags.model.Recommendations fetchByByDesigner1Type_First(
		java.lang.String designer1, long _type, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.cloud.tags.model.Recommendations findByByDesigner1Type_Last(
		java.lang.String designer1, long _type, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchRecommendationsException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.cloud.tags.model.Recommendations fetchByByDesigner1Type_Last(
		java.lang.String designer1, long _type, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.cloud.tags.model.Recommendations[] findByByDesigner1Type_PrevAndNext(
		long recId, java.lang.String designer1, long _type, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchRecommendationsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the recommendationses where designer1 = &#63; and _type = &#63; and companyId = &#63; from the database.
	*
	* @param designer1 the designer1
	* @param _type the _type
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByByDesigner1Type(java.lang.String designer1, long _type,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of recommendationses where designer1 = &#63; and _type = &#63; and companyId = &#63;.
	*
	* @param designer1 the designer1
	* @param _type the _type
	* @param companyId the company ID
	* @return the number of matching recommendationses
	* @throws SystemException if a system exception occurred
	*/
	public int countByByDesigner1Type(java.lang.String designer1, long _type,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the recommendations in the entity cache if it is enabled.
	*
	* @param recommendations the recommendations
	*/
	public void cacheResult(
		com.cloud.tags.model.Recommendations recommendations);

	/**
	* Caches the recommendationses in the entity cache if it is enabled.
	*
	* @param recommendationses the recommendationses
	*/
	public void cacheResult(
		java.util.List<com.cloud.tags.model.Recommendations> recommendationses);

	/**
	* Creates a new recommendations with the primary key. Does not add the recommendations to the database.
	*
	* @param recId the primary key for the new recommendations
	* @return the new recommendations
	*/
	public com.cloud.tags.model.Recommendations create(long recId);

	/**
	* Removes the recommendations with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recId the primary key of the recommendations
	* @return the recommendations that was removed
	* @throws com.cloud.tags.NoSuchRecommendationsException if a recommendations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Recommendations remove(long recId)
		throws com.cloud.tags.NoSuchRecommendationsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cloud.tags.model.Recommendations updateImpl(
		com.cloud.tags.model.Recommendations recommendations)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the recommendations with the primary key or throws a {@link com.cloud.tags.NoSuchRecommendationsException} if it could not be found.
	*
	* @param recId the primary key of the recommendations
	* @return the recommendations
	* @throws com.cloud.tags.NoSuchRecommendationsException if a recommendations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Recommendations findByPrimaryKey(long recId)
		throws com.cloud.tags.NoSuchRecommendationsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the recommendations with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recId the primary key of the recommendations
	* @return the recommendations, or <code>null</code> if a recommendations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Recommendations fetchByPrimaryKey(long recId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the recommendationses.
	*
	* @return the recommendationses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Recommendations> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cloud.tags.model.Recommendations> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.cloud.tags.model.Recommendations> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the recommendationses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of recommendationses.
	*
	* @return the number of recommendationses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}