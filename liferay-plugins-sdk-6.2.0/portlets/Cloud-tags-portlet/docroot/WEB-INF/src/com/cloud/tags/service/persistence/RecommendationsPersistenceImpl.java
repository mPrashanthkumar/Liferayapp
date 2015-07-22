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

import com.cloud.tags.NoSuchRecommendationsException;
import com.cloud.tags.model.Recommendations;
import com.cloud.tags.model.impl.RecommendationsImpl;
import com.cloud.tags.model.impl.RecommendationsModelImpl;

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
 * The persistence implementation for the recommendations service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see RecommendationsPersistence
 * @see RecommendationsUtil
 * @generated
 */
public class RecommendationsPersistenceImpl extends BasePersistenceImpl<Recommendations>
	implements RecommendationsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RecommendationsUtil} to access the recommendations persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RecommendationsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RecommendationsModelImpl.ENTITY_CACHE_ENABLED,
			RecommendationsModelImpl.FINDER_CACHE_ENABLED,
			RecommendationsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RecommendationsModelImpl.ENTITY_CACHE_ENABLED,
			RecommendationsModelImpl.FINDER_CACHE_ENABLED,
			RecommendationsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RecommendationsModelImpl.ENTITY_CACHE_ENABLED,
			RecommendationsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYDESIGNER1TYPE =
		new FinderPath(RecommendationsModelImpl.ENTITY_CACHE_ENABLED,
			RecommendationsModelImpl.FINDER_CACHE_ENABLED,
			RecommendationsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByByDesigner1Type",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYDESIGNER1TYPE =
		new FinderPath(RecommendationsModelImpl.ENTITY_CACHE_ENABLED,
			RecommendationsModelImpl.FINDER_CACHE_ENABLED,
			RecommendationsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByDesigner1Type",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			RecommendationsModelImpl.DESIGNER1_COLUMN_BITMASK |
			RecommendationsModelImpl._TYPE_COLUMN_BITMASK |
			RecommendationsModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYDESIGNER1TYPE = new FinderPath(RecommendationsModelImpl.ENTITY_CACHE_ENABLED,
			RecommendationsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByByDesigner1Type",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the recommendationses where designer1 = &#63; and _type = &#63; and companyId = &#63;.
	 *
	 * @param designer1 the designer1
	 * @param _type the _type
	 * @param companyId the company ID
	 * @return the matching recommendationses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Recommendations> findByByDesigner1Type(String designer1,
		long _type, long companyId) throws SystemException {
		return findByByDesigner1Type(designer1, _type, companyId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Recommendations> findByByDesigner1Type(String designer1,
		long _type, long companyId, int start, int end)
		throws SystemException {
		return findByByDesigner1Type(designer1, _type, companyId, start, end,
			null);
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
	@Override
	public List<Recommendations> findByByDesigner1Type(String designer1,
		long _type, long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYDESIGNER1TYPE;
			finderArgs = new Object[] { designer1, _type, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYDESIGNER1TYPE;
			finderArgs = new Object[] {
					designer1, _type, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Recommendations> list = (List<Recommendations>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Recommendations recommendations : list) {
				if (!Validator.equals(designer1, recommendations.getDesigner1()) ||
						(_type != recommendations.get_type()) ||
						(companyId != recommendations.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_RECOMMENDATIONS_WHERE);

			boolean bindDesigner1 = false;

			if (designer1 == null) {
				query.append(_FINDER_COLUMN_BYDESIGNER1TYPE_DESIGNER1_1);
			}
			else if (designer1.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYDESIGNER1TYPE_DESIGNER1_3);
			}
			else {
				bindDesigner1 = true;

				query.append(_FINDER_COLUMN_BYDESIGNER1TYPE_DESIGNER1_2);
			}

			query.append(_FINDER_COLUMN_BYDESIGNER1TYPE__TYPE_2);

			query.append(_FINDER_COLUMN_BYDESIGNER1TYPE_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RecommendationsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDesigner1) {
					qPos.add(designer1);
				}

				qPos.add(_type);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Recommendations>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Recommendations>(list);
				}
				else {
					list = (List<Recommendations>)QueryUtil.list(q,
							getDialect(), start, end);
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
	@Override
	public Recommendations findByByDesigner1Type_First(String designer1,
		long _type, long companyId, OrderByComparator orderByComparator)
		throws NoSuchRecommendationsException, SystemException {
		Recommendations recommendations = fetchByByDesigner1Type_First(designer1,
				_type, companyId, orderByComparator);

		if (recommendations != null) {
			return recommendations;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("designer1=");
		msg.append(designer1);

		msg.append(", _type=");
		msg.append(_type);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRecommendationsException(msg.toString());
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
	@Override
	public Recommendations fetchByByDesigner1Type_First(String designer1,
		long _type, long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Recommendations> list = findByByDesigner1Type(designer1, _type,
				companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Recommendations findByByDesigner1Type_Last(String designer1,
		long _type, long companyId, OrderByComparator orderByComparator)
		throws NoSuchRecommendationsException, SystemException {
		Recommendations recommendations = fetchByByDesigner1Type_Last(designer1,
				_type, companyId, orderByComparator);

		if (recommendations != null) {
			return recommendations;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("designer1=");
		msg.append(designer1);

		msg.append(", _type=");
		msg.append(_type);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRecommendationsException(msg.toString());
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
	@Override
	public Recommendations fetchByByDesigner1Type_Last(String designer1,
		long _type, long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByByDesigner1Type(designer1, _type, companyId);

		if (count == 0) {
			return null;
		}

		List<Recommendations> list = findByByDesigner1Type(designer1, _type,
				companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Recommendations[] findByByDesigner1Type_PrevAndNext(long recId,
		String designer1, long _type, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRecommendationsException, SystemException {
		Recommendations recommendations = findByPrimaryKey(recId);

		Session session = null;

		try {
			session = openSession();

			Recommendations[] array = new RecommendationsImpl[3];

			array[0] = getByByDesigner1Type_PrevAndNext(session,
					recommendations, designer1, _type, companyId,
					orderByComparator, true);

			array[1] = recommendations;

			array[2] = getByByDesigner1Type_PrevAndNext(session,
					recommendations, designer1, _type, companyId,
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

	protected Recommendations getByByDesigner1Type_PrevAndNext(
		Session session, Recommendations recommendations, String designer1,
		long _type, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RECOMMENDATIONS_WHERE);

		boolean bindDesigner1 = false;

		if (designer1 == null) {
			query.append(_FINDER_COLUMN_BYDESIGNER1TYPE_DESIGNER1_1);
		}
		else if (designer1.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BYDESIGNER1TYPE_DESIGNER1_3);
		}
		else {
			bindDesigner1 = true;

			query.append(_FINDER_COLUMN_BYDESIGNER1TYPE_DESIGNER1_2);
		}

		query.append(_FINDER_COLUMN_BYDESIGNER1TYPE__TYPE_2);

		query.append(_FINDER_COLUMN_BYDESIGNER1TYPE_COMPANYID_2);

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
			query.append(RecommendationsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDesigner1) {
			qPos.add(designer1);
		}

		qPos.add(_type);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(recommendations);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Recommendations> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the recommendationses where designer1 = &#63; and _type = &#63; and companyId = &#63; from the database.
	 *
	 * @param designer1 the designer1
	 * @param _type the _type
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByByDesigner1Type(String designer1, long _type,
		long companyId) throws SystemException {
		for (Recommendations recommendations : findByByDesigner1Type(
				designer1, _type, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(recommendations);
		}
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
	@Override
	public int countByByDesigner1Type(String designer1, long _type,
		long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYDESIGNER1TYPE;

		Object[] finderArgs = new Object[] { designer1, _type, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_RECOMMENDATIONS_WHERE);

			boolean bindDesigner1 = false;

			if (designer1 == null) {
				query.append(_FINDER_COLUMN_BYDESIGNER1TYPE_DESIGNER1_1);
			}
			else if (designer1.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYDESIGNER1TYPE_DESIGNER1_3);
			}
			else {
				bindDesigner1 = true;

				query.append(_FINDER_COLUMN_BYDESIGNER1TYPE_DESIGNER1_2);
			}

			query.append(_FINDER_COLUMN_BYDESIGNER1TYPE__TYPE_2);

			query.append(_FINDER_COLUMN_BYDESIGNER1TYPE_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDesigner1) {
					qPos.add(designer1);
				}

				qPos.add(_type);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_BYDESIGNER1TYPE_DESIGNER1_1 = "recommendations.designer1 IS NULL AND ";
	private static final String _FINDER_COLUMN_BYDESIGNER1TYPE_DESIGNER1_2 = "recommendations.designer1 = ? AND ";
	private static final String _FINDER_COLUMN_BYDESIGNER1TYPE_DESIGNER1_3 = "(recommendations.designer1 IS NULL OR recommendations.designer1 = '') AND ";
	private static final String _FINDER_COLUMN_BYDESIGNER1TYPE__TYPE_2 = "recommendations._type = ? AND ";
	private static final String _FINDER_COLUMN_BYDESIGNER1TYPE_COMPANYID_2 = "recommendations.companyId = ?";

	public RecommendationsPersistenceImpl() {
		setModelClass(Recommendations.class);
	}

	/**
	 * Caches the recommendations in the entity cache if it is enabled.
	 *
	 * @param recommendations the recommendations
	 */
	@Override
	public void cacheResult(Recommendations recommendations) {
		EntityCacheUtil.putResult(RecommendationsModelImpl.ENTITY_CACHE_ENABLED,
			RecommendationsImpl.class, recommendations.getPrimaryKey(),
			recommendations);

		recommendations.resetOriginalValues();
	}

	/**
	 * Caches the recommendationses in the entity cache if it is enabled.
	 *
	 * @param recommendationses the recommendationses
	 */
	@Override
	public void cacheResult(List<Recommendations> recommendationses) {
		for (Recommendations recommendations : recommendationses) {
			if (EntityCacheUtil.getResult(
						RecommendationsModelImpl.ENTITY_CACHE_ENABLED,
						RecommendationsImpl.class,
						recommendations.getPrimaryKey()) == null) {
				cacheResult(recommendations);
			}
			else {
				recommendations.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all recommendationses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RecommendationsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RecommendationsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the recommendations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Recommendations recommendations) {
		EntityCacheUtil.removeResult(RecommendationsModelImpl.ENTITY_CACHE_ENABLED,
			RecommendationsImpl.class, recommendations.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Recommendations> recommendationses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Recommendations recommendations : recommendationses) {
			EntityCacheUtil.removeResult(RecommendationsModelImpl.ENTITY_CACHE_ENABLED,
				RecommendationsImpl.class, recommendations.getPrimaryKey());
		}
	}

	/**
	 * Creates a new recommendations with the primary key. Does not add the recommendations to the database.
	 *
	 * @param recId the primary key for the new recommendations
	 * @return the new recommendations
	 */
	@Override
	public Recommendations create(long recId) {
		Recommendations recommendations = new RecommendationsImpl();

		recommendations.setNew(true);
		recommendations.setPrimaryKey(recId);

		return recommendations;
	}

	/**
	 * Removes the recommendations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recId the primary key of the recommendations
	 * @return the recommendations that was removed
	 * @throws com.cloud.tags.NoSuchRecommendationsException if a recommendations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Recommendations remove(long recId)
		throws NoSuchRecommendationsException, SystemException {
		return remove((Serializable)recId);
	}

	/**
	 * Removes the recommendations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the recommendations
	 * @return the recommendations that was removed
	 * @throws com.cloud.tags.NoSuchRecommendationsException if a recommendations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Recommendations remove(Serializable primaryKey)
		throws NoSuchRecommendationsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Recommendations recommendations = (Recommendations)session.get(RecommendationsImpl.class,
					primaryKey);

			if (recommendations == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRecommendationsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(recommendations);
		}
		catch (NoSuchRecommendationsException nsee) {
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
	protected Recommendations removeImpl(Recommendations recommendations)
		throws SystemException {
		recommendations = toUnwrappedModel(recommendations);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(recommendations)) {
				recommendations = (Recommendations)session.get(RecommendationsImpl.class,
						recommendations.getPrimaryKeyObj());
			}

			if (recommendations != null) {
				session.delete(recommendations);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (recommendations != null) {
			clearCache(recommendations);
		}

		return recommendations;
	}

	@Override
	public Recommendations updateImpl(
		com.cloud.tags.model.Recommendations recommendations)
		throws SystemException {
		recommendations = toUnwrappedModel(recommendations);

		boolean isNew = recommendations.isNew();

		RecommendationsModelImpl recommendationsModelImpl = (RecommendationsModelImpl)recommendations;

		Session session = null;

		try {
			session = openSession();

			if (recommendations.isNew()) {
				session.save(recommendations);

				recommendations.setNew(false);
			}
			else {
				session.merge(recommendations);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RecommendationsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((recommendationsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYDESIGNER1TYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						recommendationsModelImpl.getOriginalDesigner1(),
						recommendationsModelImpl.getOriginal_type(),
						recommendationsModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYDESIGNER1TYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYDESIGNER1TYPE,
					args);

				args = new Object[] {
						recommendationsModelImpl.getDesigner1(),
						recommendationsModelImpl.get_type(),
						recommendationsModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYDESIGNER1TYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYDESIGNER1TYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(RecommendationsModelImpl.ENTITY_CACHE_ENABLED,
			RecommendationsImpl.class, recommendations.getPrimaryKey(),
			recommendations);

		return recommendations;
	}

	protected Recommendations toUnwrappedModel(Recommendations recommendations) {
		if (recommendations instanceof RecommendationsImpl) {
			return recommendations;
		}

		RecommendationsImpl recommendationsImpl = new RecommendationsImpl();

		recommendationsImpl.setNew(recommendations.isNew());
		recommendationsImpl.setPrimaryKey(recommendations.getPrimaryKey());

		recommendationsImpl.setRecId(recommendations.getRecId());
		recommendationsImpl.setDesigner1(recommendations.getDesigner1());
		recommendationsImpl.setDesigner2(recommendations.getDesigner2());
		recommendationsImpl.set_type(recommendations.get_type());
		recommendationsImpl.setPercentage(recommendations.getPercentage());
		recommendationsImpl.setCompanyId(recommendations.getCompanyId());
		recommendationsImpl.setColor_name(recommendations.getColor_name());
		recommendationsImpl.setColor_image(recommendations.getColor_image());

		return recommendationsImpl;
	}

	/**
	 * Returns the recommendations with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the recommendations
	 * @return the recommendations
	 * @throws com.cloud.tags.NoSuchRecommendationsException if a recommendations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Recommendations findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRecommendationsException, SystemException {
		Recommendations recommendations = fetchByPrimaryKey(primaryKey);

		if (recommendations == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRecommendationsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return recommendations;
	}

	/**
	 * Returns the recommendations with the primary key or throws a {@link com.cloud.tags.NoSuchRecommendationsException} if it could not be found.
	 *
	 * @param recId the primary key of the recommendations
	 * @return the recommendations
	 * @throws com.cloud.tags.NoSuchRecommendationsException if a recommendations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Recommendations findByPrimaryKey(long recId)
		throws NoSuchRecommendationsException, SystemException {
		return findByPrimaryKey((Serializable)recId);
	}

	/**
	 * Returns the recommendations with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the recommendations
	 * @return the recommendations, or <code>null</code> if a recommendations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Recommendations fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Recommendations recommendations = (Recommendations)EntityCacheUtil.getResult(RecommendationsModelImpl.ENTITY_CACHE_ENABLED,
				RecommendationsImpl.class, primaryKey);

		if (recommendations == _nullRecommendations) {
			return null;
		}

		if (recommendations == null) {
			Session session = null;

			try {
				session = openSession();

				recommendations = (Recommendations)session.get(RecommendationsImpl.class,
						primaryKey);

				if (recommendations != null) {
					cacheResult(recommendations);
				}
				else {
					EntityCacheUtil.putResult(RecommendationsModelImpl.ENTITY_CACHE_ENABLED,
						RecommendationsImpl.class, primaryKey,
						_nullRecommendations);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RecommendationsModelImpl.ENTITY_CACHE_ENABLED,
					RecommendationsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return recommendations;
	}

	/**
	 * Returns the recommendations with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recId the primary key of the recommendations
	 * @return the recommendations, or <code>null</code> if a recommendations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Recommendations fetchByPrimaryKey(long recId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)recId);
	}

	/**
	 * Returns all the recommendationses.
	 *
	 * @return the recommendationses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Recommendations> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Recommendations> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Recommendations> findAll(int start, int end,
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

		List<Recommendations> list = (List<Recommendations>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RECOMMENDATIONS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RECOMMENDATIONS;

				if (pagination) {
					sql = sql.concat(RecommendationsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Recommendations>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Recommendations>(list);
				}
				else {
					list = (List<Recommendations>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the recommendationses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Recommendations recommendations : findAll()) {
			remove(recommendations);
		}
	}

	/**
	 * Returns the number of recommendationses.
	 *
	 * @return the number of recommendationses
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

				Query q = session.createQuery(_SQL_COUNT_RECOMMENDATIONS);

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
	 * Initializes the recommendations persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cloud.tags.model.Recommendations")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Recommendations>> listenersList = new ArrayList<ModelListener<Recommendations>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Recommendations>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RecommendationsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RECOMMENDATIONS = "SELECT recommendations FROM Recommendations recommendations";
	private static final String _SQL_SELECT_RECOMMENDATIONS_WHERE = "SELECT recommendations FROM Recommendations recommendations WHERE ";
	private static final String _SQL_COUNT_RECOMMENDATIONS = "SELECT COUNT(recommendations) FROM Recommendations recommendations";
	private static final String _SQL_COUNT_RECOMMENDATIONS_WHERE = "SELECT COUNT(recommendations) FROM Recommendations recommendations WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "recommendations.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Recommendations exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Recommendations exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RecommendationsPersistenceImpl.class);
	private static Recommendations _nullRecommendations = new RecommendationsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Recommendations> toCacheModel() {
				return _nullRecommendationsCacheModel;
			}
		};

	private static CacheModel<Recommendations> _nullRecommendationsCacheModel = new CacheModel<Recommendations>() {
			@Override
			public Recommendations toEntityModel() {
				return _nullRecommendations;
			}
		};
}