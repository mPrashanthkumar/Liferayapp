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

import com.cloud.tags.NoSuchImpressionsException;
import com.cloud.tags.model.Impressions;
import com.cloud.tags.model.impl.ImpressionsImpl;
import com.cloud.tags.model.impl.ImpressionsModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the impressions service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see ImpressionsPersistence
 * @see ImpressionsUtil
 * @generated
 */
public class ImpressionsPersistenceImpl extends BasePersistenceImpl<Impressions>
	implements ImpressionsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ImpressionsUtil} to access the impressions persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ImpressionsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ImpressionsModelImpl.ENTITY_CACHE_ENABLED,
			ImpressionsModelImpl.FINDER_CACHE_ENABLED, ImpressionsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ImpressionsModelImpl.ENTITY_CACHE_ENABLED,
			ImpressionsModelImpl.FINDER_CACHE_ENABLED, ImpressionsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ImpressionsModelImpl.ENTITY_CACHE_ENABLED,
			ImpressionsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYIMPRESSIONTYPEACTION =
		new FinderPath(ImpressionsModelImpl.ENTITY_CACHE_ENABLED,
			ImpressionsModelImpl.FINDER_CACHE_ENABLED, ImpressionsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByByImpressionTypeAction",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYIMPRESSIONTYPEACTION =
		new FinderPath(ImpressionsModelImpl.ENTITY_CACHE_ENABLED,
			ImpressionsModelImpl.FINDER_CACHE_ENABLED, ImpressionsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByByImpressionTypeAction",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			ImpressionsModelImpl.IMPRESSIONTYPE_COLUMN_BITMASK |
			ImpressionsModelImpl.IMPRESSIONACTION_COLUMN_BITMASK |
			ImpressionsModelImpl.SESSION_ID_COLUMN_BITMASK |
			ImpressionsModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYIMPRESSIONTYPEACTION = new FinderPath(ImpressionsModelImpl.ENTITY_CACHE_ENABLED,
			ImpressionsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByByImpressionTypeAction",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			});

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
	@Override
	public List<Impressions> findByByImpressionTypeAction(
		String impressionType, String impressionAction, String session_Id,
		String companyId) throws SystemException {
		return findByByImpressionTypeAction(impressionType, impressionAction,
			session_Id, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Impressions> findByByImpressionTypeAction(
		String impressionType, String impressionAction, String session_Id,
		String companyId, int start, int end) throws SystemException {
		return findByByImpressionTypeAction(impressionType, impressionAction,
			session_Id, companyId, start, end, null);
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
	@Override
	public List<Impressions> findByByImpressionTypeAction(
		String impressionType, String impressionAction, String session_Id,
		String companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYIMPRESSIONTYPEACTION;
			finderArgs = new Object[] {
					impressionType, impressionAction, session_Id, companyId
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYIMPRESSIONTYPEACTION;
			finderArgs = new Object[] {
					impressionType, impressionAction, session_Id, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Impressions> list = (List<Impressions>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Impressions impressions : list) {
				if (!Validator.equals(impressionType,
							impressions.getImpressionType()) ||
						!Validator.equals(impressionAction,
							impressions.getImpressionAction()) ||
						!Validator.equals(session_Id,
							impressions.getSession_Id()) ||
						!Validator.equals(companyId, impressions.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_IMPRESSIONS_WHERE);

			boolean bindImpressionType = false;

			if (impressionType == null) {
				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONTYPE_1);
			}
			else if (impressionType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONTYPE_3);
			}
			else {
				bindImpressionType = true;

				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONTYPE_2);
			}

			boolean bindImpressionAction = false;

			if (impressionAction == null) {
				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONACTION_1);
			}
			else if (impressionAction.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONACTION_3);
			}
			else {
				bindImpressionAction = true;

				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONACTION_2);
			}

			boolean bindSession_Id = false;

			if (session_Id == null) {
				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_SESSION_ID_1);
			}
			else if (session_Id.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_SESSION_ID_3);
			}
			else {
				bindSession_Id = true;

				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_SESSION_ID_2);
			}

			boolean bindCompanyId = false;

			if (companyId == null) {
				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_COMPANYID_1);
			}
			else if (companyId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_COMPANYID_3);
			}
			else {
				bindCompanyId = true;

				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_COMPANYID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ImpressionsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindImpressionType) {
					qPos.add(impressionType);
				}

				if (bindImpressionAction) {
					qPos.add(impressionAction);
				}

				if (bindSession_Id) {
					qPos.add(session_Id);
				}

				if (bindCompanyId) {
					qPos.add(companyId);
				}

				if (!pagination) {
					list = (List<Impressions>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Impressions>(list);
				}
				else {
					list = (List<Impressions>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Impressions findByByImpressionTypeAction_First(
		String impressionType, String impressionAction, String session_Id,
		String companyId, OrderByComparator orderByComparator)
		throws NoSuchImpressionsException, SystemException {
		Impressions impressions = fetchByByImpressionTypeAction_First(impressionType,
				impressionAction, session_Id, companyId, orderByComparator);

		if (impressions != null) {
			return impressions;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("impressionType=");
		msg.append(impressionType);

		msg.append(", impressionAction=");
		msg.append(impressionAction);

		msg.append(", session_Id=");
		msg.append(session_Id);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImpressionsException(msg.toString());
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
	@Override
	public Impressions fetchByByImpressionTypeAction_First(
		String impressionType, String impressionAction, String session_Id,
		String companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Impressions> list = findByByImpressionTypeAction(impressionType,
				impressionAction, session_Id, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Impressions findByByImpressionTypeAction_Last(
		String impressionType, String impressionAction, String session_Id,
		String companyId, OrderByComparator orderByComparator)
		throws NoSuchImpressionsException, SystemException {
		Impressions impressions = fetchByByImpressionTypeAction_Last(impressionType,
				impressionAction, session_Id, companyId, orderByComparator);

		if (impressions != null) {
			return impressions;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("impressionType=");
		msg.append(impressionType);

		msg.append(", impressionAction=");
		msg.append(impressionAction);

		msg.append(", session_Id=");
		msg.append(session_Id);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImpressionsException(msg.toString());
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
	@Override
	public Impressions fetchByByImpressionTypeAction_Last(
		String impressionType, String impressionAction, String session_Id,
		String companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByByImpressionTypeAction(impressionType,
				impressionAction, session_Id, companyId);

		if (count == 0) {
			return null;
		}

		List<Impressions> list = findByByImpressionTypeAction(impressionType,
				impressionAction, session_Id, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Impressions[] findByByImpressionTypeAction_PrevAndNext(long recId,
		String impressionType, String impressionAction, String session_Id,
		String companyId, OrderByComparator orderByComparator)
		throws NoSuchImpressionsException, SystemException {
		Impressions impressions = findByPrimaryKey(recId);

		Session session = null;

		try {
			session = openSession();

			Impressions[] array = new ImpressionsImpl[3];

			array[0] = getByByImpressionTypeAction_PrevAndNext(session,
					impressions, impressionType, impressionAction, session_Id,
					companyId, orderByComparator, true);

			array[1] = impressions;

			array[2] = getByByImpressionTypeAction_PrevAndNext(session,
					impressions, impressionType, impressionAction, session_Id,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Impressions getByByImpressionTypeAction_PrevAndNext(
		Session session, Impressions impressions, String impressionType,
		String impressionAction, String session_Id, String companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IMPRESSIONS_WHERE);

		boolean bindImpressionType = false;

		if (impressionType == null) {
			query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONTYPE_1);
		}
		else if (impressionType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONTYPE_3);
		}
		else {
			bindImpressionType = true;

			query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONTYPE_2);
		}

		boolean bindImpressionAction = false;

		if (impressionAction == null) {
			query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONACTION_1);
		}
		else if (impressionAction.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONACTION_3);
		}
		else {
			bindImpressionAction = true;

			query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONACTION_2);
		}

		boolean bindSession_Id = false;

		if (session_Id == null) {
			query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_SESSION_ID_1);
		}
		else if (session_Id.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_SESSION_ID_3);
		}
		else {
			bindSession_Id = true;

			query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_SESSION_ID_2);
		}

		boolean bindCompanyId = false;

		if (companyId == null) {
			query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_COMPANYID_1);
		}
		else if (companyId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_COMPANYID_3);
		}
		else {
			bindCompanyId = true;

			query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_COMPANYID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ImpressionsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindImpressionType) {
			qPos.add(impressionType);
		}

		if (bindImpressionAction) {
			qPos.add(impressionAction);
		}

		if (bindSession_Id) {
			qPos.add(session_Id);
		}

		if (bindCompanyId) {
			qPos.add(companyId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(impressions);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Impressions> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public void removeByByImpressionTypeAction(String impressionType,
		String impressionAction, String session_Id, String companyId)
		throws SystemException {
		for (Impressions impressions : findByByImpressionTypeAction(
				impressionType, impressionAction, session_Id, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(impressions);
		}
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
	@Override
	public int countByByImpressionTypeAction(String impressionType,
		String impressionAction, String session_Id, String companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYIMPRESSIONTYPEACTION;

		Object[] finderArgs = new Object[] {
				impressionType, impressionAction, session_Id, companyId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_IMPRESSIONS_WHERE);

			boolean bindImpressionType = false;

			if (impressionType == null) {
				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONTYPE_1);
			}
			else if (impressionType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONTYPE_3);
			}
			else {
				bindImpressionType = true;

				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONTYPE_2);
			}

			boolean bindImpressionAction = false;

			if (impressionAction == null) {
				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONACTION_1);
			}
			else if (impressionAction.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONACTION_3);
			}
			else {
				bindImpressionAction = true;

				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONACTION_2);
			}

			boolean bindSession_Id = false;

			if (session_Id == null) {
				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_SESSION_ID_1);
			}
			else if (session_Id.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_SESSION_ID_3);
			}
			else {
				bindSession_Id = true;

				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_SESSION_ID_2);
			}

			boolean bindCompanyId = false;

			if (companyId == null) {
				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_COMPANYID_1);
			}
			else if (companyId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_COMPANYID_3);
			}
			else {
				bindCompanyId = true;

				query.append(_FINDER_COLUMN_BYIMPRESSIONTYPEACTION_COMPANYID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindImpressionType) {
					qPos.add(impressionType);
				}

				if (bindImpressionAction) {
					qPos.add(impressionAction);
				}

				if (bindSession_Id) {
					qPos.add(session_Id);
				}

				if (bindCompanyId) {
					qPos.add(companyId);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONTYPE_1 =
		"impressions.impressionType IS NULL AND ";
	private static final String _FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONTYPE_2 =
		"impressions.impressionType = ? AND ";
	private static final String _FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONTYPE_3 =
		"(impressions.impressionType IS NULL OR impressions.impressionType = '') AND ";
	private static final String _FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONACTION_1 =
		"impressions.impressionAction IS NULL AND ";
	private static final String _FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONACTION_2 =
		"impressions.impressionAction = ? AND ";
	private static final String _FINDER_COLUMN_BYIMPRESSIONTYPEACTION_IMPRESSIONACTION_3 =
		"(impressions.impressionAction IS NULL OR impressions.impressionAction = '') AND ";
	private static final String _FINDER_COLUMN_BYIMPRESSIONTYPEACTION_SESSION_ID_1 =
		"impressions.session_Id IS NULL AND ";
	private static final String _FINDER_COLUMN_BYIMPRESSIONTYPEACTION_SESSION_ID_2 =
		"impressions.session_Id = ? AND ";
	private static final String _FINDER_COLUMN_BYIMPRESSIONTYPEACTION_SESSION_ID_3 =
		"(impressions.session_Id IS NULL OR impressions.session_Id = '') AND ";
	private static final String _FINDER_COLUMN_BYIMPRESSIONTYPEACTION_COMPANYID_1 =
		"impressions.companyId IS NULL";
	private static final String _FINDER_COLUMN_BYIMPRESSIONTYPEACTION_COMPANYID_2 =
		"impressions.companyId = ?";
	private static final String _FINDER_COLUMN_BYIMPRESSIONTYPEACTION_COMPANYID_3 =
		"(impressions.companyId IS NULL OR impressions.companyId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STOREDEVICE =
		new FinderPath(ImpressionsModelImpl.ENTITY_CACHE_ENABLED,
			ImpressionsModelImpl.FINDER_CACHE_ENABLED, ImpressionsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStoreDevice",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STOREDEVICE =
		new FinderPath(ImpressionsModelImpl.ENTITY_CACHE_ENABLED,
			ImpressionsModelImpl.FINDER_CACHE_ENABLED, ImpressionsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStoreDevice",
			new String[] { Long.class.getName() },
			ImpressionsModelImpl.STOREDEVICEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STOREDEVICE = new FinderPath(ImpressionsModelImpl.ENTITY_CACHE_ENABLED,
			ImpressionsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStoreDevice",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the impressionses where storeDeviceId = &#63;.
	 *
	 * @param storeDeviceId the store device ID
	 * @return the matching impressionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Impressions> findByStoreDevice(long storeDeviceId)
		throws SystemException {
		return findByStoreDevice(storeDeviceId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Impressions> findByStoreDevice(long storeDeviceId, int start,
		int end) throws SystemException {
		return findByStoreDevice(storeDeviceId, start, end, null);
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
	@Override
	public List<Impressions> findByStoreDevice(long storeDeviceId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STOREDEVICE;
			finderArgs = new Object[] { storeDeviceId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STOREDEVICE;
			finderArgs = new Object[] {
					storeDeviceId,
					
					start, end, orderByComparator
				};
		}

		List<Impressions> list = (List<Impressions>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Impressions impressions : list) {
				if ((storeDeviceId != impressions.getStoreDeviceId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_IMPRESSIONS_WHERE);

			query.append(_FINDER_COLUMN_STOREDEVICE_STOREDEVICEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ImpressionsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(storeDeviceId);

				if (!pagination) {
					list = (List<Impressions>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Impressions>(list);
				}
				else {
					list = (List<Impressions>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Impressions findByStoreDevice_First(long storeDeviceId,
		OrderByComparator orderByComparator)
		throws NoSuchImpressionsException, SystemException {
		Impressions impressions = fetchByStoreDevice_First(storeDeviceId,
				orderByComparator);

		if (impressions != null) {
			return impressions;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("storeDeviceId=");
		msg.append(storeDeviceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImpressionsException(msg.toString());
	}

	/**
	 * Returns the first impressions in the ordered set where storeDeviceId = &#63;.
	 *
	 * @param storeDeviceId the store device ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching impressions, or <code>null</code> if a matching impressions could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Impressions fetchByStoreDevice_First(long storeDeviceId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Impressions> list = findByStoreDevice(storeDeviceId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Impressions findByStoreDevice_Last(long storeDeviceId,
		OrderByComparator orderByComparator)
		throws NoSuchImpressionsException, SystemException {
		Impressions impressions = fetchByStoreDevice_Last(storeDeviceId,
				orderByComparator);

		if (impressions != null) {
			return impressions;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("storeDeviceId=");
		msg.append(storeDeviceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImpressionsException(msg.toString());
	}

	/**
	 * Returns the last impressions in the ordered set where storeDeviceId = &#63;.
	 *
	 * @param storeDeviceId the store device ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching impressions, or <code>null</code> if a matching impressions could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Impressions fetchByStoreDevice_Last(long storeDeviceId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStoreDevice(storeDeviceId);

		if (count == 0) {
			return null;
		}

		List<Impressions> list = findByStoreDevice(storeDeviceId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Impressions[] findByStoreDevice_PrevAndNext(long recId,
		long storeDeviceId, OrderByComparator orderByComparator)
		throws NoSuchImpressionsException, SystemException {
		Impressions impressions = findByPrimaryKey(recId);

		Session session = null;

		try {
			session = openSession();

			Impressions[] array = new ImpressionsImpl[3];

			array[0] = getByStoreDevice_PrevAndNext(session, impressions,
					storeDeviceId, orderByComparator, true);

			array[1] = impressions;

			array[2] = getByStoreDevice_PrevAndNext(session, impressions,
					storeDeviceId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Impressions getByStoreDevice_PrevAndNext(Session session,
		Impressions impressions, long storeDeviceId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IMPRESSIONS_WHERE);

		query.append(_FINDER_COLUMN_STOREDEVICE_STOREDEVICEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ImpressionsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(storeDeviceId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(impressions);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Impressions> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the impressionses where storeDeviceId = &#63; from the database.
	 *
	 * @param storeDeviceId the store device ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStoreDevice(long storeDeviceId)
		throws SystemException {
		for (Impressions impressions : findByStoreDevice(storeDeviceId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(impressions);
		}
	}

	/**
	 * Returns the number of impressionses where storeDeviceId = &#63;.
	 *
	 * @param storeDeviceId the store device ID
	 * @return the number of matching impressionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStoreDevice(long storeDeviceId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STOREDEVICE;

		Object[] finderArgs = new Object[] { storeDeviceId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_IMPRESSIONS_WHERE);

			query.append(_FINDER_COLUMN_STOREDEVICE_STOREDEVICEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(storeDeviceId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STOREDEVICE_STOREDEVICEID_2 = "impressions.storeDeviceId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STAFFID = new FinderPath(ImpressionsModelImpl.ENTITY_CACHE_ENABLED,
			ImpressionsModelImpl.FINDER_CACHE_ENABLED, ImpressionsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStaffId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STAFFID =
		new FinderPath(ImpressionsModelImpl.ENTITY_CACHE_ENABLED,
			ImpressionsModelImpl.FINDER_CACHE_ENABLED, ImpressionsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStaffId",
			new String[] { String.class.getName() },
			ImpressionsModelImpl.STAFFID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STAFFID = new FinderPath(ImpressionsModelImpl.ENTITY_CACHE_ENABLED,
			ImpressionsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStaffId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the impressionses where staffId = &#63;.
	 *
	 * @param staffId the staff ID
	 * @return the matching impressionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Impressions> findByStaffId(String staffId)
		throws SystemException {
		return findByStaffId(staffId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Impressions> findByStaffId(String staffId, int start, int end)
		throws SystemException {
		return findByStaffId(staffId, start, end, null);
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
	@Override
	public List<Impressions> findByStaffId(String staffId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STAFFID;
			finderArgs = new Object[] { staffId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STAFFID;
			finderArgs = new Object[] { staffId, start, end, orderByComparator };
		}

		List<Impressions> list = (List<Impressions>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Impressions impressions : list) {
				if (!Validator.equals(staffId, impressions.getStaffId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_IMPRESSIONS_WHERE);

			boolean bindStaffId = false;

			if (staffId == null) {
				query.append(_FINDER_COLUMN_STAFFID_STAFFID_1);
			}
			else if (staffId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STAFFID_STAFFID_3);
			}
			else {
				bindStaffId = true;

				query.append(_FINDER_COLUMN_STAFFID_STAFFID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ImpressionsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStaffId) {
					qPos.add(staffId);
				}

				if (!pagination) {
					list = (List<Impressions>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Impressions>(list);
				}
				else {
					list = (List<Impressions>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Impressions findByStaffId_First(String staffId,
		OrderByComparator orderByComparator)
		throws NoSuchImpressionsException, SystemException {
		Impressions impressions = fetchByStaffId_First(staffId,
				orderByComparator);

		if (impressions != null) {
			return impressions;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("staffId=");
		msg.append(staffId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImpressionsException(msg.toString());
	}

	/**
	 * Returns the first impressions in the ordered set where staffId = &#63;.
	 *
	 * @param staffId the staff ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching impressions, or <code>null</code> if a matching impressions could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Impressions fetchByStaffId_First(String staffId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Impressions> list = findByStaffId(staffId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Impressions findByStaffId_Last(String staffId,
		OrderByComparator orderByComparator)
		throws NoSuchImpressionsException, SystemException {
		Impressions impressions = fetchByStaffId_Last(staffId, orderByComparator);

		if (impressions != null) {
			return impressions;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("staffId=");
		msg.append(staffId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImpressionsException(msg.toString());
	}

	/**
	 * Returns the last impressions in the ordered set where staffId = &#63;.
	 *
	 * @param staffId the staff ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching impressions, or <code>null</code> if a matching impressions could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Impressions fetchByStaffId_Last(String staffId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStaffId(staffId);

		if (count == 0) {
			return null;
		}

		List<Impressions> list = findByStaffId(staffId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Impressions[] findByStaffId_PrevAndNext(long recId, String staffId,
		OrderByComparator orderByComparator)
		throws NoSuchImpressionsException, SystemException {
		Impressions impressions = findByPrimaryKey(recId);

		Session session = null;

		try {
			session = openSession();

			Impressions[] array = new ImpressionsImpl[3];

			array[0] = getByStaffId_PrevAndNext(session, impressions, staffId,
					orderByComparator, true);

			array[1] = impressions;

			array[2] = getByStaffId_PrevAndNext(session, impressions, staffId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Impressions getByStaffId_PrevAndNext(Session session,
		Impressions impressions, String staffId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IMPRESSIONS_WHERE);

		boolean bindStaffId = false;

		if (staffId == null) {
			query.append(_FINDER_COLUMN_STAFFID_STAFFID_1);
		}
		else if (staffId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STAFFID_STAFFID_3);
		}
		else {
			bindStaffId = true;

			query.append(_FINDER_COLUMN_STAFFID_STAFFID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ImpressionsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStaffId) {
			qPos.add(staffId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(impressions);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Impressions> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the impressionses where staffId = &#63; from the database.
	 *
	 * @param staffId the staff ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStaffId(String staffId) throws SystemException {
		for (Impressions impressions : findByStaffId(staffId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(impressions);
		}
	}

	/**
	 * Returns the number of impressionses where staffId = &#63;.
	 *
	 * @param staffId the staff ID
	 * @return the number of matching impressionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStaffId(String staffId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STAFFID;

		Object[] finderArgs = new Object[] { staffId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_IMPRESSIONS_WHERE);

			boolean bindStaffId = false;

			if (staffId == null) {
				query.append(_FINDER_COLUMN_STAFFID_STAFFID_1);
			}
			else if (staffId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STAFFID_STAFFID_3);
			}
			else {
				bindStaffId = true;

				query.append(_FINDER_COLUMN_STAFFID_STAFFID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStaffId) {
					qPos.add(staffId);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STAFFID_STAFFID_1 = "impressions.staffId IS NULL";
	private static final String _FINDER_COLUMN_STAFFID_STAFFID_2 = "impressions.staffId = ?";
	private static final String _FINDER_COLUMN_STAFFID_STAFFID_3 = "(impressions.staffId IS NULL OR impressions.staffId = '')";

	public ImpressionsPersistenceImpl() {
		setModelClass(Impressions.class);
	}

	/**
	 * Caches the impressions in the entity cache if it is enabled.
	 *
	 * @param impressions the impressions
	 */
	@Override
	public void cacheResult(Impressions impressions) {
		EntityCacheUtil.putResult(ImpressionsModelImpl.ENTITY_CACHE_ENABLED,
			ImpressionsImpl.class, impressions.getPrimaryKey(), impressions);

		impressions.resetOriginalValues();
	}

	/**
	 * Caches the impressionses in the entity cache if it is enabled.
	 *
	 * @param impressionses the impressionses
	 */
	@Override
	public void cacheResult(List<Impressions> impressionses) {
		for (Impressions impressions : impressionses) {
			if (EntityCacheUtil.getResult(
						ImpressionsModelImpl.ENTITY_CACHE_ENABLED,
						ImpressionsImpl.class, impressions.getPrimaryKey()) == null) {
				cacheResult(impressions);
			}
			else {
				impressions.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all impressionses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ImpressionsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ImpressionsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the impressions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Impressions impressions) {
		EntityCacheUtil.removeResult(ImpressionsModelImpl.ENTITY_CACHE_ENABLED,
			ImpressionsImpl.class, impressions.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Impressions> impressionses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Impressions impressions : impressionses) {
			EntityCacheUtil.removeResult(ImpressionsModelImpl.ENTITY_CACHE_ENABLED,
				ImpressionsImpl.class, impressions.getPrimaryKey());
		}
	}

	/**
	 * Creates a new impressions with the primary key. Does not add the impressions to the database.
	 *
	 * @param recId the primary key for the new impressions
	 * @return the new impressions
	 */
	@Override
	public Impressions create(long recId) {
		Impressions impressions = new ImpressionsImpl();

		impressions.setNew(true);
		impressions.setPrimaryKey(recId);

		return impressions;
	}

	/**
	 * Removes the impressions with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recId the primary key of the impressions
	 * @return the impressions that was removed
	 * @throws com.cloud.tags.NoSuchImpressionsException if a impressions with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Impressions remove(long recId)
		throws NoSuchImpressionsException, SystemException {
		return remove((Serializable)recId);
	}

	/**
	 * Removes the impressions with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the impressions
	 * @return the impressions that was removed
	 * @throws com.cloud.tags.NoSuchImpressionsException if a impressions with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Impressions remove(Serializable primaryKey)
		throws NoSuchImpressionsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Impressions impressions = (Impressions)session.get(ImpressionsImpl.class,
					primaryKey);

			if (impressions == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchImpressionsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(impressions);
		}
		catch (NoSuchImpressionsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Impressions removeImpl(Impressions impressions)
		throws SystemException {
		impressions = toUnwrappedModel(impressions);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(impressions)) {
				impressions = (Impressions)session.get(ImpressionsImpl.class,
						impressions.getPrimaryKeyObj());
			}

			if (impressions != null) {
				session.delete(impressions);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (impressions != null) {
			clearCache(impressions);
		}

		return impressions;
	}

	@Override
	public Impressions updateImpl(com.cloud.tags.model.Impressions impressions)
		throws SystemException {
		impressions = toUnwrappedModel(impressions);

		boolean isNew = impressions.isNew();

		ImpressionsModelImpl impressionsModelImpl = (ImpressionsModelImpl)impressions;

		Session session = null;

		try {
			session = openSession();

			if (impressions.isNew()) {
				session.save(impressions);

				impressions.setNew(false);
			}
			else {
				session.merge(impressions);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ImpressionsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((impressionsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYIMPRESSIONTYPEACTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						impressionsModelImpl.getOriginalImpressionType(),
						impressionsModelImpl.getOriginalImpressionAction(),
						impressionsModelImpl.getOriginalSession_Id(),
						impressionsModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYIMPRESSIONTYPEACTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYIMPRESSIONTYPEACTION,
					args);

				args = new Object[] {
						impressionsModelImpl.getImpressionType(),
						impressionsModelImpl.getImpressionAction(),
						impressionsModelImpl.getSession_Id(),
						impressionsModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYIMPRESSIONTYPEACTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYIMPRESSIONTYPEACTION,
					args);
			}

			if ((impressionsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STOREDEVICE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						impressionsModelImpl.getOriginalStoreDeviceId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STOREDEVICE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STOREDEVICE,
					args);

				args = new Object[] { impressionsModelImpl.getStoreDeviceId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STOREDEVICE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STOREDEVICE,
					args);
			}

			if ((impressionsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STAFFID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						impressionsModelImpl.getOriginalStaffId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STAFFID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STAFFID,
					args);

				args = new Object[] { impressionsModelImpl.getStaffId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STAFFID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STAFFID,
					args);
			}
		}

		EntityCacheUtil.putResult(ImpressionsModelImpl.ENTITY_CACHE_ENABLED,
			ImpressionsImpl.class, impressions.getPrimaryKey(), impressions);

		return impressions;
	}

	protected Impressions toUnwrappedModel(Impressions impressions) {
		if (impressions instanceof ImpressionsImpl) {
			return impressions;
		}

		ImpressionsImpl impressionsImpl = new ImpressionsImpl();

		impressionsImpl.setNew(impressions.isNew());
		impressionsImpl.setPrimaryKey(impressions.getPrimaryKey());

		impressionsImpl.setRecId(impressions.getRecId());
		impressionsImpl.setImpressionType(impressions.getImpressionType());
		impressionsImpl.setImpressionId(impressions.getImpressionId());
		impressionsImpl.setImpressionAction(impressions.getImpressionAction());
		impressionsImpl.setIpAddress(impressions.getIpAddress());
		impressionsImpl.setDeviceType(impressions.getDeviceType());
		impressionsImpl.setDeviceName(impressions.getDeviceName());
		impressionsImpl.setDeviceWidth(impressions.getDeviceWidth());
		impressionsImpl.setIdeviceBrowser(impressions.getIdeviceBrowser());
		impressionsImpl.setSession_Id(impressions.getSession_Id());
		impressionsImpl.setCompanyId(impressions.getCompanyId());
		impressionsImpl.setCreateDate(impressions.getCreateDate());
		impressionsImpl.setStoreDeviceId(impressions.getStoreDeviceId());
		impressionsImpl.setStaffId(impressions.getStaffId());

		return impressionsImpl;
	}

	/**
	 * Returns the impressions with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the impressions
	 * @return the impressions
	 * @throws com.cloud.tags.NoSuchImpressionsException if a impressions with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Impressions findByPrimaryKey(Serializable primaryKey)
		throws NoSuchImpressionsException, SystemException {
		Impressions impressions = fetchByPrimaryKey(primaryKey);

		if (impressions == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchImpressionsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return impressions;
	}

	/**
	 * Returns the impressions with the primary key or throws a {@link com.cloud.tags.NoSuchImpressionsException} if it could not be found.
	 *
	 * @param recId the primary key of the impressions
	 * @return the impressions
	 * @throws com.cloud.tags.NoSuchImpressionsException if a impressions with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Impressions findByPrimaryKey(long recId)
		throws NoSuchImpressionsException, SystemException {
		return findByPrimaryKey((Serializable)recId);
	}

	/**
	 * Returns the impressions with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the impressions
	 * @return the impressions, or <code>null</code> if a impressions with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Impressions fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Impressions impressions = (Impressions)EntityCacheUtil.getResult(ImpressionsModelImpl.ENTITY_CACHE_ENABLED,
				ImpressionsImpl.class, primaryKey);

		if (impressions == _nullImpressions) {
			return null;
		}

		if (impressions == null) {
			Session session = null;

			try {
				session = openSession();

				impressions = (Impressions)session.get(ImpressionsImpl.class,
						primaryKey);

				if (impressions != null) {
					cacheResult(impressions);
				}
				else {
					EntityCacheUtil.putResult(ImpressionsModelImpl.ENTITY_CACHE_ENABLED,
						ImpressionsImpl.class, primaryKey, _nullImpressions);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ImpressionsModelImpl.ENTITY_CACHE_ENABLED,
					ImpressionsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return impressions;
	}

	/**
	 * Returns the impressions with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recId the primary key of the impressions
	 * @return the impressions, or <code>null</code> if a impressions with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Impressions fetchByPrimaryKey(long recId) throws SystemException {
		return fetchByPrimaryKey((Serializable)recId);
	}

	/**
	 * Returns all the impressionses.
	 *
	 * @return the impressionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Impressions> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Impressions> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Impressions> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Impressions> list = (List<Impressions>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_IMPRESSIONS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_IMPRESSIONS;

				if (pagination) {
					sql = sql.concat(ImpressionsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Impressions>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Impressions>(list);
				}
				else {
					list = (List<Impressions>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the impressionses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Impressions impressions : findAll()) {
			remove(impressions);
		}
	}

	/**
	 * Returns the number of impressionses.
	 *
	 * @return the number of impressionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_IMPRESSIONS);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the impressions persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cloud.tags.model.Impressions")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Impressions>> listenersList = new ArrayList<ModelListener<Impressions>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Impressions>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ImpressionsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_IMPRESSIONS = "SELECT impressions FROM Impressions impressions";
	private static final String _SQL_SELECT_IMPRESSIONS_WHERE = "SELECT impressions FROM Impressions impressions WHERE ";
	private static final String _SQL_COUNT_IMPRESSIONS = "SELECT COUNT(impressions) FROM Impressions impressions";
	private static final String _SQL_COUNT_IMPRESSIONS_WHERE = "SELECT COUNT(impressions) FROM Impressions impressions WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "impressions.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Impressions exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Impressions exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ImpressionsPersistenceImpl.class);
	private static Impressions _nullImpressions = new ImpressionsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Impressions> toCacheModel() {
				return _nullImpressionsCacheModel;
			}
		};

	private static CacheModel<Impressions> _nullImpressionsCacheModel = new CacheModel<Impressions>() {
			@Override
			public Impressions toEntityModel() {
				return _nullImpressions;
			}
		};
}