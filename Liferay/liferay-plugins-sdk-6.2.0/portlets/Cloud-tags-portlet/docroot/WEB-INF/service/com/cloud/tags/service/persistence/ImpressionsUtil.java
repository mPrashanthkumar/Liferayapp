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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the impressions service. This utility wraps {@link ImpressionsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see ImpressionsPersistence
 * @see ImpressionsPersistenceImpl
 * @generated
 */
public class ImpressionsUtil {
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
	public static void clearCache(Impressions impressions) {
		getPersistence().clearCache(impressions);
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
	public static List<Impressions> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Impressions> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Impressions> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Impressions update(Impressions impressions)
		throws SystemException {
		return getPersistence().update(impressions);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Impressions update(Impressions impressions,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(impressions, serviceContext);
	}

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
	public static java.util.List<com.cloud.tags.model.Impressions> findByByImpressionTypeAction(
		java.lang.String impressionType, java.lang.String impressionAction,
		java.lang.String session_Id, java.lang.String companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByImpressionTypeAction(impressionType,
			impressionAction, session_Id, companyId);
	}

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
	public static java.util.List<com.cloud.tags.model.Impressions> findByByImpressionTypeAction(
		java.lang.String impressionType, java.lang.String impressionAction,
		java.lang.String session_Id, java.lang.String companyId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByImpressionTypeAction(impressionType,
			impressionAction, session_Id, companyId, start, end);
	}

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
	public static java.util.List<com.cloud.tags.model.Impressions> findByByImpressionTypeAction(
		java.lang.String impressionType, java.lang.String impressionAction,
		java.lang.String session_Id, java.lang.String companyId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByImpressionTypeAction(impressionType,
			impressionAction, session_Id, companyId, start, end,
			orderByComparator);
	}

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
	public static com.cloud.tags.model.Impressions findByByImpressionTypeAction_First(
		java.lang.String impressionType, java.lang.String impressionAction,
		java.lang.String session_Id, java.lang.String companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchImpressionsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByImpressionTypeAction_First(impressionType,
			impressionAction, session_Id, companyId, orderByComparator);
	}

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
	public static com.cloud.tags.model.Impressions fetchByByImpressionTypeAction_First(
		java.lang.String impressionType, java.lang.String impressionAction,
		java.lang.String session_Id, java.lang.String companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByByImpressionTypeAction_First(impressionType,
			impressionAction, session_Id, companyId, orderByComparator);
	}

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
	public static com.cloud.tags.model.Impressions findByByImpressionTypeAction_Last(
		java.lang.String impressionType, java.lang.String impressionAction,
		java.lang.String session_Id, java.lang.String companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchImpressionsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByImpressionTypeAction_Last(impressionType,
			impressionAction, session_Id, companyId, orderByComparator);
	}

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
	public static com.cloud.tags.model.Impressions fetchByByImpressionTypeAction_Last(
		java.lang.String impressionType, java.lang.String impressionAction,
		java.lang.String session_Id, java.lang.String companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByByImpressionTypeAction_Last(impressionType,
			impressionAction, session_Id, companyId, orderByComparator);
	}

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
	public static com.cloud.tags.model.Impressions[] findByByImpressionTypeAction_PrevAndNext(
		long recId, java.lang.String impressionType,
		java.lang.String impressionAction, java.lang.String session_Id,
		java.lang.String companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchImpressionsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByImpressionTypeAction_PrevAndNext(recId,
			impressionType, impressionAction, session_Id, companyId,
			orderByComparator);
	}

	/**
	* Removes all the impressionses where impressionType = &#63; and impressionAction = &#63; and session_Id = &#63; and companyId = &#63; from the database.
	*
	* @param impressionType the impression type
	* @param impressionAction the impression action
	* @param session_Id the session_ ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByByImpressionTypeAction(
		java.lang.String impressionType, java.lang.String impressionAction,
		java.lang.String session_Id, java.lang.String companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByByImpressionTypeAction(impressionType, impressionAction,
			session_Id, companyId);
	}

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
	public static int countByByImpressionTypeAction(
		java.lang.String impressionType, java.lang.String impressionAction,
		java.lang.String session_Id, java.lang.String companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByByImpressionTypeAction(impressionType,
			impressionAction, session_Id, companyId);
	}

	/**
	* Returns all the impressionses where storeDeviceId = &#63;.
	*
	* @param storeDeviceId the store device ID
	* @return the matching impressionses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.Impressions> findByStoreDevice(
		long storeDeviceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStoreDevice(storeDeviceId);
	}

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
	public static java.util.List<com.cloud.tags.model.Impressions> findByStoreDevice(
		long storeDeviceId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStoreDevice(storeDeviceId, start, end);
	}

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
	public static java.util.List<com.cloud.tags.model.Impressions> findByStoreDevice(
		long storeDeviceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStoreDevice(storeDeviceId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first impressions in the ordered set where storeDeviceId = &#63;.
	*
	* @param storeDeviceId the store device ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching impressions
	* @throws com.cloud.tags.NoSuchImpressionsException if a matching impressions could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Impressions findByStoreDevice_First(
		long storeDeviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchImpressionsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStoreDevice_First(storeDeviceId, orderByComparator);
	}

	/**
	* Returns the first impressions in the ordered set where storeDeviceId = &#63;.
	*
	* @param storeDeviceId the store device ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching impressions, or <code>null</code> if a matching impressions could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Impressions fetchByStoreDevice_First(
		long storeDeviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStoreDevice_First(storeDeviceId, orderByComparator);
	}

	/**
	* Returns the last impressions in the ordered set where storeDeviceId = &#63;.
	*
	* @param storeDeviceId the store device ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching impressions
	* @throws com.cloud.tags.NoSuchImpressionsException if a matching impressions could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Impressions findByStoreDevice_Last(
		long storeDeviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchImpressionsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStoreDevice_Last(storeDeviceId, orderByComparator);
	}

	/**
	* Returns the last impressions in the ordered set where storeDeviceId = &#63;.
	*
	* @param storeDeviceId the store device ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching impressions, or <code>null</code> if a matching impressions could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Impressions fetchByStoreDevice_Last(
		long storeDeviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStoreDevice_Last(storeDeviceId, orderByComparator);
	}

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
	public static com.cloud.tags.model.Impressions[] findByStoreDevice_PrevAndNext(
		long recId, long storeDeviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchImpressionsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStoreDevice_PrevAndNext(recId, storeDeviceId,
			orderByComparator);
	}

	/**
	* Removes all the impressionses where storeDeviceId = &#63; from the database.
	*
	* @param storeDeviceId the store device ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStoreDevice(long storeDeviceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStoreDevice(storeDeviceId);
	}

	/**
	* Returns the number of impressionses where storeDeviceId = &#63;.
	*
	* @param storeDeviceId the store device ID
	* @return the number of matching impressionses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStoreDevice(long storeDeviceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStoreDevice(storeDeviceId);
	}

	/**
	* Returns all the impressionses where staffId = &#63;.
	*
	* @param staffId the staff ID
	* @return the matching impressionses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.Impressions> findByStaffId(
		java.lang.String staffId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStaffId(staffId);
	}

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
	public static java.util.List<com.cloud.tags.model.Impressions> findByStaffId(
		java.lang.String staffId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStaffId(staffId, start, end);
	}

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
	public static java.util.List<com.cloud.tags.model.Impressions> findByStaffId(
		java.lang.String staffId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStaffId(staffId, start, end, orderByComparator);
	}

	/**
	* Returns the first impressions in the ordered set where staffId = &#63;.
	*
	* @param staffId the staff ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching impressions
	* @throws com.cloud.tags.NoSuchImpressionsException if a matching impressions could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Impressions findByStaffId_First(
		java.lang.String staffId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchImpressionsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStaffId_First(staffId, orderByComparator);
	}

	/**
	* Returns the first impressions in the ordered set where staffId = &#63;.
	*
	* @param staffId the staff ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching impressions, or <code>null</code> if a matching impressions could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Impressions fetchByStaffId_First(
		java.lang.String staffId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStaffId_First(staffId, orderByComparator);
	}

	/**
	* Returns the last impressions in the ordered set where staffId = &#63;.
	*
	* @param staffId the staff ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching impressions
	* @throws com.cloud.tags.NoSuchImpressionsException if a matching impressions could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Impressions findByStaffId_Last(
		java.lang.String staffId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchImpressionsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStaffId_Last(staffId, orderByComparator);
	}

	/**
	* Returns the last impressions in the ordered set where staffId = &#63;.
	*
	* @param staffId the staff ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching impressions, or <code>null</code> if a matching impressions could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Impressions fetchByStaffId_Last(
		java.lang.String staffId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStaffId_Last(staffId, orderByComparator);
	}

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
	public static com.cloud.tags.model.Impressions[] findByStaffId_PrevAndNext(
		long recId, java.lang.String staffId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.cloud.tags.NoSuchImpressionsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStaffId_PrevAndNext(recId, staffId, orderByComparator);
	}

	/**
	* Removes all the impressionses where staffId = &#63; from the database.
	*
	* @param staffId the staff ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStaffId(java.lang.String staffId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStaffId(staffId);
	}

	/**
	* Returns the number of impressionses where staffId = &#63;.
	*
	* @param staffId the staff ID
	* @return the number of matching impressionses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStaffId(java.lang.String staffId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStaffId(staffId);
	}

	/**
	* Caches the impressions in the entity cache if it is enabled.
	*
	* @param impressions the impressions
	*/
	public static void cacheResult(com.cloud.tags.model.Impressions impressions) {
		getPersistence().cacheResult(impressions);
	}

	/**
	* Caches the impressionses in the entity cache if it is enabled.
	*
	* @param impressionses the impressionses
	*/
	public static void cacheResult(
		java.util.List<com.cloud.tags.model.Impressions> impressionses) {
		getPersistence().cacheResult(impressionses);
	}

	/**
	* Creates a new impressions with the primary key. Does not add the impressions to the database.
	*
	* @param recId the primary key for the new impressions
	* @return the new impressions
	*/
	public static com.cloud.tags.model.Impressions create(long recId) {
		return getPersistence().create(recId);
	}

	/**
	* Removes the impressions with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recId the primary key of the impressions
	* @return the impressions that was removed
	* @throws com.cloud.tags.NoSuchImpressionsException if a impressions with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Impressions remove(long recId)
		throws com.cloud.tags.NoSuchImpressionsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(recId);
	}

	public static com.cloud.tags.model.Impressions updateImpl(
		com.cloud.tags.model.Impressions impressions)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(impressions);
	}

	/**
	* Returns the impressions with the primary key or throws a {@link com.cloud.tags.NoSuchImpressionsException} if it could not be found.
	*
	* @param recId the primary key of the impressions
	* @return the impressions
	* @throws com.cloud.tags.NoSuchImpressionsException if a impressions with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Impressions findByPrimaryKey(long recId)
		throws com.cloud.tags.NoSuchImpressionsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(recId);
	}

	/**
	* Returns the impressions with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recId the primary key of the impressions
	* @return the impressions, or <code>null</code> if a impressions with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.cloud.tags.model.Impressions fetchByPrimaryKey(long recId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(recId);
	}

	/**
	* Returns all the impressionses.
	*
	* @return the impressionses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.cloud.tags.model.Impressions> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.cloud.tags.model.Impressions> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.cloud.tags.model.Impressions> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the impressionses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of impressionses.
	*
	* @return the number of impressionses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ImpressionsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ImpressionsPersistence)PortletBeanLocatorUtil.locate(com.cloud.tags.service.ClpSerializer.getServletContextName(),
					ImpressionsPersistence.class.getName());

			ReferenceRegistry.registerReference(ImpressionsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ImpressionsPersistence persistence) {
	}

	private static ImpressionsPersistence _persistence;
}