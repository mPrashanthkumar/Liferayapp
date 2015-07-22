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

import com.cloud.tags.model.Impressions;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the impressions service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see ImpressionsPersistenceImpl
 * @see ImpressionsUtil
 * @generated
 */
public interface ImpressionsPersistence extends BasePersistence<Impressions> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ImpressionsUtil} to access the impressions persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the impressionses where impressionType = &#63; and impressionAction = &#63; and session_Id = &#63; and companyId = &#63;.
	*
	* @param impressionType the impression type
	* @param impressionAction the impression action
	* @param session_Id the session_ ID
	* @param companyId the company ID
	* @return the matching impressionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Impressions> findByByImpressionTypeAction(
		java.lang.String impressionType, java.lang.String impressionAction,
		java.lang.String session_Id, java.lang.String companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the impressionses where impressionType = &#63; and impressionAction = &#63; and session_Id = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.ImpressionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param impressionType the impression type
	* @param impressionAction the impression action
	* @param session_Id the session_ ID
	* @param companyId the company ID
	* @param start the lower bound of the range of impressionses
	* @param end the upper bound of the range of impressionses (not inclusive)
	* @return the range of matching impressionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Impressions> findByByImpressionTypeAction(
		java.lang.String impressionType, java.lang.String impressionAction,
		java.lang.String session_Id, java.lang.String companyId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the impressionses where impressionType = &#63; and impressionAction = &#63; and session_Id = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.ImpressionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param impressionType the impression type
	* @param impressionAction the impression action
	* @param session_Id the session_ ID
	* @param companyId the company ID
	* @param start the lower bound of the range of impressionses
	* @param end the upper bound of the range of impressionses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching impressionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Impressions> findByByImpressionTypeAction(
		java.lang.String impressionType, java.lang.String impressionAction,
		java.lang.String session_Id, java.lang.String companyId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first impressions in the ordered set where impressionType = &#63; and impressionAction = &#63; and session_Id = &#63; and companyId = &#63;.
	*
	* @param impressionType the impression type
	* @param impressionAction the impression action
	* @param session_Id the session_ ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching impressions
	* @throws com.cloud.tags.NoSuchImpressionsException if a matching impressions could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Impressions findByByImpressionTypeAction_First(
		java.lang.String impressionType, java.lang.String impressionAction,
		java.lang.String session_Id, java.lang.String companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchImpressionsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first impressions in the ordered set where impressionType = &#63; and impressionAction = &#63; and session_Id = &#63; and companyId = &#63;.
	*
	* @param impressionType the impression type
	* @param impressionAction the impression action
	* @param session_Id the session_ ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching impressions, or <code>null</code> if a matching impressions could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Impressions fetchByByImpressionTypeAction_First(
		java.lang.String impressionType, java.lang.String impressionAction,
		java.lang.String session_Id, java.lang.String companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last impressions in the ordered set where impressionType = &#63; and impressionAction = &#63; and session_Id = &#63; and companyId = &#63;.
	*
	* @param impressionType the impression type
	* @param impressionAction the impression action
	* @param session_Id the session_ ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching impressions
	* @throws com.cloud.tags.NoSuchImpressionsException if a matching impressions could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Impressions findByByImpressionTypeAction_Last(
		java.lang.String impressionType, java.lang.String impressionAction,
		java.lang.String session_Id, java.lang.String companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchImpressionsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last impressions in the ordered set where impressionType = &#63; and impressionAction = &#63; and session_Id = &#63; and companyId = &#63;.
	*
	* @param impressionType the impression type
	* @param impressionAction the impression action
	* @param session_Id the session_ ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching impressions, or <code>null</code> if a matching impressions could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Impressions fetchByByImpressionTypeAction_Last(
		java.lang.String impressionType, java.lang.String impressionAction,
		java.lang.String session_Id, java.lang.String companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the impressionses before and after the current impressions in the ordered set where impressionType = &#63; and impressionAction = &#63; and session_Id = &#63; and companyId = &#63;.
	*
	* @param recId the primary key of the current impressions
	* @param impressionType the impression type
	* @param impressionAction the impression action
	* @param session_Id the session_ ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next impressions
	* @throws com.cloud.tags.NoSuchImpressionsException if a impressions with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Impressions[] findByByImpressionTypeAction_PrevAndNext(
		long recId, java.lang.String impressionType,
		java.lang.String impressionAction, java.lang.String session_Id,
		java.lang.String companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchImpressionsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the impressionses where impressionType = &#63; and impressionAction = &#63; and session_Id = &#63; and companyId = &#63; from the database.
	*
	* @param impressionType the impression type
	* @param impressionAction the impression action
	* @param session_Id the session_ ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByByImpressionTypeAction(
		java.lang.String impressionType, java.lang.String impressionAction,
		java.lang.String session_Id, java.lang.String companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of impressionses where impressionType = &#63; and impressionAction = &#63; and session_Id = &#63; and companyId = &#63;.
	*
	* @param impressionType the impression type
	* @param impressionAction the impression action
	* @param session_Id the session_ ID
	* @param companyId the company ID
	* @return the number of matching impressionses
	* @throws SystemException if a system exception occurred
	*/
	public int countByByImpressionTypeAction(java.lang.String impressionType,
		java.lang.String impressionAction, java.lang.String session_Id,
		java.lang.String companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the impressionses where storeDeviceId = &#63;.
	*
	* @param storeDeviceId the store device ID
	* @return the matching impressionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Impressions> findByStoreDevice(
		long storeDeviceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the impressionses where storeDeviceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.ImpressionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param storeDeviceId the store device ID
	* @param start the lower bound of the range of impressionses
	* @param end the upper bound of the range of impressionses (not inclusive)
	* @return the range of matching impressionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Impressions> findByStoreDevice(
		long storeDeviceId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the impressionses where storeDeviceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.ImpressionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param storeDeviceId the store device ID
	* @param start the lower bound of the range of impressionses
	* @param end the upper bound of the range of impressionses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching impressionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Impressions> findByStoreDevice(
		long storeDeviceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first impressions in the ordered set where storeDeviceId = &#63;.
	*
	* @param storeDeviceId the store device ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching impressions
	* @throws com.cloud.tags.NoSuchImpressionsException if a matching impressions could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Impressions findByStoreDevice_First(
		long storeDeviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchImpressionsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first impressions in the ordered set where storeDeviceId = &#63;.
	*
	* @param storeDeviceId the store device ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching impressions, or <code>null</code> if a matching impressions could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Impressions fetchByStoreDevice_First(
		long storeDeviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last impressions in the ordered set where storeDeviceId = &#63;.
	*
	* @param storeDeviceId the store device ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching impressions
	* @throws com.cloud.tags.NoSuchImpressionsException if a matching impressions could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Impressions findByStoreDevice_Last(
		long storeDeviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchImpressionsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last impressions in the ordered set where storeDeviceId = &#63;.
	*
	* @param storeDeviceId the store device ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching impressions, or <code>null</code> if a matching impressions could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Impressions fetchByStoreDevice_Last(
		long storeDeviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the impressionses before and after the current impressions in the ordered set where storeDeviceId = &#63;.
	*
	* @param recId the primary key of the current impressions
	* @param storeDeviceId the store device ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next impressions
	* @throws com.cloud.tags.NoSuchImpressionsException if a impressions with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Impressions[] findByStoreDevice_PrevAndNext(
		long recId, long storeDeviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchImpressionsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the impressionses where storeDeviceId = &#63; from the database.
	*
	* @param storeDeviceId the store device ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStoreDevice(long storeDeviceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of impressionses where storeDeviceId = &#63;.
	*
	* @param storeDeviceId the store device ID
	* @return the number of matching impressionses
	* @throws SystemException if a system exception occurred
	*/
	public int countByStoreDevice(long storeDeviceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the impressionses where staffId = &#63;.
	*
	* @param staffId the staff ID
	* @return the matching impressionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Impressions> findByStaffId(
		java.lang.String staffId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the impressionses where staffId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.ImpressionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param staffId the staff ID
	* @param start the lower bound of the range of impressionses
	* @param end the upper bound of the range of impressionses (not inclusive)
	* @return the range of matching impressionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Impressions> findByStaffId(
		java.lang.String staffId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the impressionses where staffId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.ImpressionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param staffId the staff ID
	* @param start the lower bound of the range of impressionses
	* @param end the upper bound of the range of impressionses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching impressionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Impressions> findByStaffId(
		java.lang.String staffId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first impressions in the ordered set where staffId = &#63;.
	*
	* @param staffId the staff ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching impressions
	* @throws com.cloud.tags.NoSuchImpressionsException if a matching impressions could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Impressions findByStaffId_First(
		java.lang.String staffId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchImpressionsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first impressions in the ordered set where staffId = &#63;.
	*
	* @param staffId the staff ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching impressions, or <code>null</code> if a matching impressions could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Impressions fetchByStaffId_First(
		java.lang.String staffId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last impressions in the ordered set where staffId = &#63;.
	*
	* @param staffId the staff ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching impressions
	* @throws com.cloud.tags.NoSuchImpressionsException if a matching impressions could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Impressions findByStaffId_Last(
		java.lang.String staffId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchImpressionsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last impressions in the ordered set where staffId = &#63;.
	*
	* @param staffId the staff ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching impressions, or <code>null</code> if a matching impressions could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Impressions fetchByStaffId_Last(
		java.lang.String staffId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the impressionses before and after the current impressions in the ordered set where staffId = &#63;.
	*
	* @param recId the primary key of the current impressions
	* @param staffId the staff ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next impressions
	* @throws com.cloud.tags.NoSuchImpressionsException if a impressions with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Impressions[] findByStaffId_PrevAndNext(
		long recId, java.lang.String staffId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchImpressionsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the impressionses where staffId = &#63; from the database.
	*
	* @param staffId the staff ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStaffId(java.lang.String staffId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of impressionses where staffId = &#63;.
	*
	* @param staffId the staff ID
	* @return the number of matching impressionses
	* @throws SystemException if a system exception occurred
	*/
	public int countByStaffId(java.lang.String staffId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the impressions in the entity cache if it is enabled.
	*
	* @param impressions the impressions
	*/
	public void cacheResult(com.cloud.tags.model.Impressions impressions);

	/**
	* Caches the impressionses in the entity cache if it is enabled.
	*
	* @param impressionses the impressionses
	*/
	public void cacheResult(
		java.util.List<com.cloud.tags.model.Impressions> impressionses);

	/**
	* Creates a new impressions with the primary key. Does not add the impressions to the database.
	*
	* @param recId the primary key for the new impressions
	* @return the new impressions
	*/
	public com.cloud.tags.model.Impressions create(long recId);

	/**
	* Removes the impressions with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recId the primary key of the impressions
	* @return the impressions that was removed
	* @throws com.cloud.tags.NoSuchImpressionsException if a impressions with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Impressions remove(long recId)
		throws com.cloud.tags.NoSuchImpressionsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.cloud.tags.model.Impressions updateImpl(
		com.cloud.tags.model.Impressions impressions)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the impressions with the primary key or throws a {@link com.cloud.tags.NoSuchImpressionsException} if it could not be found.
	*
	* @param recId the primary key of the impressions
	* @return the impressions
	* @throws com.cloud.tags.NoSuchImpressionsException if a impressions with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Impressions findByPrimaryKey(long recId)
		throws com.cloud.tags.NoSuchImpressionsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the impressions with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recId the primary key of the impressions
	* @return the impressions, or <code>null</code> if a impressions with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.cloud.tags.model.Impressions fetchByPrimaryKey(long recId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the impressionses.
	*
	* @return the impressionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Impressions> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the impressionses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.ImpressionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of impressionses
	* @param end the upper bound of the range of impressionses (not inclusive)
	* @return the range of impressionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Impressions> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the impressionses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.ImpressionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of impressionses
	* @param end the upper bound of the range of impressionses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of impressionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.cloud.tags.model.Impressions> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the impressionses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of impressionses.
	*
	* @return the number of impressionses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}