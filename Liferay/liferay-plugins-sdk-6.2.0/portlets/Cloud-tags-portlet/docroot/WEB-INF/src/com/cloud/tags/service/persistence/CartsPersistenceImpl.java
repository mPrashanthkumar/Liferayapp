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

import com.cloud.tags.NoSuchCartsException;
import com.cloud.tags.model.Carts;
import com.cloud.tags.model.impl.CartsImpl;
import com.cloud.tags.model.impl.CartsModelImpl;

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
 * The persistence implementation for the carts service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see CartsPersistence
 * @see CartsUtil
 * @generated
 */
public class CartsPersistenceImpl extends BasePersistenceImpl<Carts>
	implements CartsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CartsUtil} to access the carts persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CartsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CartsModelImpl.ENTITY_CACHE_ENABLED,
			CartsModelImpl.FINDER_CACHE_ENABLED, CartsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CartsModelImpl.ENTITY_CACHE_ENABLED,
			CartsModelImpl.FINDER_CACHE_ENABLED, CartsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CartsModelImpl.ENTITY_CACHE_ENABLED,
			CartsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(CartsModelImpl.ENTITY_CACHE_ENABLED,
			CartsModelImpl.FINDER_CACHE_ENABLED, CartsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(CartsModelImpl.ENTITY_CACHE_ENABLED,
			CartsModelImpl.FINDER_CACHE_ENABLED, CartsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] { Long.class.getName() },
			CartsModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(CartsModelImpl.ENTITY_CACHE_ENABLED,
			CartsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the cartses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching cartses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Carts> findByuserId(long userId) throws SystemException {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cartses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of cartses
	 * @param end the upper bound of the range of cartses (not inclusive)
	 * @return the range of matching cartses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Carts> findByuserId(long userId, int start, int end)
		throws SystemException {
		return findByuserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cartses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of cartses
	 * @param end the upper bound of the range of cartses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cartses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Carts> findByuserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<Carts> list = (List<Carts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Carts carts : list) {
				if ((userId != carts.getUserId())) {
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

			query.append(_SQL_SELECT_CARTS_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CartsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Carts>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Carts>(list);
				}
				else {
					list = (List<Carts>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first carts in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carts
	 * @throws com.cloud.tags.NoSuchCartsException if a matching carts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Carts findByuserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchCartsException, SystemException {
		Carts carts = fetchByuserId_First(userId, orderByComparator);

		if (carts != null) {
			return carts;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCartsException(msg.toString());
	}

	/**
	 * Returns the first carts in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carts, or <code>null</code> if a matching carts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Carts fetchByuserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Carts> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last carts in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carts
	 * @throws com.cloud.tags.NoSuchCartsException if a matching carts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Carts findByuserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchCartsException, SystemException {
		Carts carts = fetchByuserId_Last(userId, orderByComparator);

		if (carts != null) {
			return carts;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCartsException(msg.toString());
	}

	/**
	 * Returns the last carts in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carts, or <code>null</code> if a matching carts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Carts fetchByuserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<Carts> list = findByuserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cartses before and after the current carts in the ordered set where userId = &#63;.
	 *
	 * @param cartId the primary key of the current carts
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next carts
	 * @throws com.cloud.tags.NoSuchCartsException if a carts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Carts[] findByuserId_PrevAndNext(long cartId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchCartsException, SystemException {
		Carts carts = findByPrimaryKey(cartId);

		Session session = null;

		try {
			session = openSession();

			Carts[] array = new CartsImpl[3];

			array[0] = getByuserId_PrevAndNext(session, carts, userId,
					orderByComparator, true);

			array[1] = carts;

			array[2] = getByuserId_PrevAndNext(session, carts, userId,
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

	protected Carts getByuserId_PrevAndNext(Session session, Carts carts,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CARTS_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(CartsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(carts);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Carts> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cartses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByuserId(long userId) throws SystemException {
		for (Carts carts : findByuserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(carts);
		}
	}

	/**
	 * Returns the number of cartses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching cartses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByuserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CARTS_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "carts.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SESSION_ID =
		new FinderPath(CartsModelImpl.ENTITY_CACHE_ENABLED,
			CartsModelImpl.FINDER_CACHE_ENABLED, CartsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysession_id",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SESSION_ID =
		new FinderPath(CartsModelImpl.ENTITY_CACHE_ENABLED,
			CartsModelImpl.FINDER_CACHE_ENABLED, CartsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysession_id",
			new String[] { String.class.getName() },
			CartsModelImpl.SESSION_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SESSION_ID = new FinderPath(CartsModelImpl.ENTITY_CACHE_ENABLED,
			CartsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysession_id",
			new String[] { String.class.getName() });

	/**
	 * Returns all the cartses where session_id = &#63;.
	 *
	 * @param session_id the session_id
	 * @return the matching cartses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Carts> findBysession_id(String session_id)
		throws SystemException {
		return findBysession_id(session_id, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cartses where session_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param session_id the session_id
	 * @param start the lower bound of the range of cartses
	 * @param end the upper bound of the range of cartses (not inclusive)
	 * @return the range of matching cartses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Carts> findBysession_id(String session_id, int start, int end)
		throws SystemException {
		return findBysession_id(session_id, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cartses where session_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param session_id the session_id
	 * @param start the lower bound of the range of cartses
	 * @param end the upper bound of the range of cartses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cartses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Carts> findBysession_id(String session_id, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SESSION_ID;
			finderArgs = new Object[] { session_id };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SESSION_ID;
			finderArgs = new Object[] { session_id, start, end, orderByComparator };
		}

		List<Carts> list = (List<Carts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Carts carts : list) {
				if (!Validator.equals(session_id, carts.getSession_id())) {
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

			query.append(_SQL_SELECT_CARTS_WHERE);

			boolean bindSession_id = false;

			if (session_id == null) {
				query.append(_FINDER_COLUMN_SESSION_ID_SESSION_ID_1);
			}
			else if (session_id.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SESSION_ID_SESSION_ID_3);
			}
			else {
				bindSession_id = true;

				query.append(_FINDER_COLUMN_SESSION_ID_SESSION_ID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CartsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSession_id) {
					qPos.add(session_id);
				}

				if (!pagination) {
					list = (List<Carts>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Carts>(list);
				}
				else {
					list = (List<Carts>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first carts in the ordered set where session_id = &#63;.
	 *
	 * @param session_id the session_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carts
	 * @throws com.cloud.tags.NoSuchCartsException if a matching carts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Carts findBysession_id_First(String session_id,
		OrderByComparator orderByComparator)
		throws NoSuchCartsException, SystemException {
		Carts carts = fetchBysession_id_First(session_id, orderByComparator);

		if (carts != null) {
			return carts;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("session_id=");
		msg.append(session_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCartsException(msg.toString());
	}

	/**
	 * Returns the first carts in the ordered set where session_id = &#63;.
	 *
	 * @param session_id the session_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carts, or <code>null</code> if a matching carts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Carts fetchBysession_id_First(String session_id,
		OrderByComparator orderByComparator) throws SystemException {
		List<Carts> list = findBysession_id(session_id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last carts in the ordered set where session_id = &#63;.
	 *
	 * @param session_id the session_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carts
	 * @throws com.cloud.tags.NoSuchCartsException if a matching carts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Carts findBysession_id_Last(String session_id,
		OrderByComparator orderByComparator)
		throws NoSuchCartsException, SystemException {
		Carts carts = fetchBysession_id_Last(session_id, orderByComparator);

		if (carts != null) {
			return carts;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("session_id=");
		msg.append(session_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCartsException(msg.toString());
	}

	/**
	 * Returns the last carts in the ordered set where session_id = &#63;.
	 *
	 * @param session_id the session_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carts, or <code>null</code> if a matching carts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Carts fetchBysession_id_Last(String session_id,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBysession_id(session_id);

		if (count == 0) {
			return null;
		}

		List<Carts> list = findBysession_id(session_id, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cartses before and after the current carts in the ordered set where session_id = &#63;.
	 *
	 * @param cartId the primary key of the current carts
	 * @param session_id the session_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next carts
	 * @throws com.cloud.tags.NoSuchCartsException if a carts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Carts[] findBysession_id_PrevAndNext(long cartId, String session_id,
		OrderByComparator orderByComparator)
		throws NoSuchCartsException, SystemException {
		Carts carts = findByPrimaryKey(cartId);

		Session session = null;

		try {
			session = openSession();

			Carts[] array = new CartsImpl[3];

			array[0] = getBysession_id_PrevAndNext(session, carts, session_id,
					orderByComparator, true);

			array[1] = carts;

			array[2] = getBysession_id_PrevAndNext(session, carts, session_id,
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

	protected Carts getBysession_id_PrevAndNext(Session session, Carts carts,
		String session_id, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CARTS_WHERE);

		boolean bindSession_id = false;

		if (session_id == null) {
			query.append(_FINDER_COLUMN_SESSION_ID_SESSION_ID_1);
		}
		else if (session_id.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_SESSION_ID_SESSION_ID_3);
		}
		else {
			bindSession_id = true;

			query.append(_FINDER_COLUMN_SESSION_ID_SESSION_ID_2);
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
			query.append(CartsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindSession_id) {
			qPos.add(session_id);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(carts);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Carts> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cartses where session_id = &#63; from the database.
	 *
	 * @param session_id the session_id
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBysession_id(String session_id) throws SystemException {
		for (Carts carts : findBysession_id(session_id, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(carts);
		}
	}

	/**
	 * Returns the number of cartses where session_id = &#63;.
	 *
	 * @param session_id the session_id
	 * @return the number of matching cartses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBysession_id(String session_id) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SESSION_ID;

		Object[] finderArgs = new Object[] { session_id };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CARTS_WHERE);

			boolean bindSession_id = false;

			if (session_id == null) {
				query.append(_FINDER_COLUMN_SESSION_ID_SESSION_ID_1);
			}
			else if (session_id.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SESSION_ID_SESSION_ID_3);
			}
			else {
				bindSession_id = true;

				query.append(_FINDER_COLUMN_SESSION_ID_SESSION_ID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSession_id) {
					qPos.add(session_id);
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

	private static final String _FINDER_COLUMN_SESSION_ID_SESSION_ID_1 = "carts.session_id IS NULL";
	private static final String _FINDER_COLUMN_SESSION_ID_SESSION_ID_2 = "carts.session_id = ?";
	private static final String _FINDER_COLUMN_SESSION_ID_SESSION_ID_3 = "(carts.session_id IS NULL OR carts.session_id = '')";

	public CartsPersistenceImpl() {
		setModelClass(Carts.class);
	}

	/**
	 * Caches the carts in the entity cache if it is enabled.
	 *
	 * @param carts the carts
	 */
	@Override
	public void cacheResult(Carts carts) {
		EntityCacheUtil.putResult(CartsModelImpl.ENTITY_CACHE_ENABLED,
			CartsImpl.class, carts.getPrimaryKey(), carts);

		carts.resetOriginalValues();
	}

	/**
	 * Caches the cartses in the entity cache if it is enabled.
	 *
	 * @param cartses the cartses
	 */
	@Override
	public void cacheResult(List<Carts> cartses) {
		for (Carts carts : cartses) {
			if (EntityCacheUtil.getResult(CartsModelImpl.ENTITY_CACHE_ENABLED,
						CartsImpl.class, carts.getPrimaryKey()) == null) {
				cacheResult(carts);
			}
			else {
				carts.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cartses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CartsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CartsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the carts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Carts carts) {
		EntityCacheUtil.removeResult(CartsModelImpl.ENTITY_CACHE_ENABLED,
			CartsImpl.class, carts.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Carts> cartses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Carts carts : cartses) {
			EntityCacheUtil.removeResult(CartsModelImpl.ENTITY_CACHE_ENABLED,
				CartsImpl.class, carts.getPrimaryKey());
		}
	}

	/**
	 * Creates a new carts with the primary key. Does not add the carts to the database.
	 *
	 * @param cartId the primary key for the new carts
	 * @return the new carts
	 */
	@Override
	public Carts create(long cartId) {
		Carts carts = new CartsImpl();

		carts.setNew(true);
		carts.setPrimaryKey(cartId);

		return carts;
	}

	/**
	 * Removes the carts with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cartId the primary key of the carts
	 * @return the carts that was removed
	 * @throws com.cloud.tags.NoSuchCartsException if a carts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Carts remove(long cartId)
		throws NoSuchCartsException, SystemException {
		return remove((Serializable)cartId);
	}

	/**
	 * Removes the carts with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the carts
	 * @return the carts that was removed
	 * @throws com.cloud.tags.NoSuchCartsException if a carts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Carts remove(Serializable primaryKey)
		throws NoSuchCartsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Carts carts = (Carts)session.get(CartsImpl.class, primaryKey);

			if (carts == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCartsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(carts);
		}
		catch (NoSuchCartsException nsee) {
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
	protected Carts removeImpl(Carts carts) throws SystemException {
		carts = toUnwrappedModel(carts);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(carts)) {
				carts = (Carts)session.get(CartsImpl.class,
						carts.getPrimaryKeyObj());
			}

			if (carts != null) {
				session.delete(carts);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (carts != null) {
			clearCache(carts);
		}

		return carts;
	}

	@Override
	public Carts updateImpl(com.cloud.tags.model.Carts carts)
		throws SystemException {
		carts = toUnwrappedModel(carts);

		boolean isNew = carts.isNew();

		CartsModelImpl cartsModelImpl = (CartsModelImpl)carts;

		Session session = null;

		try {
			session = openSession();

			if (carts.isNew()) {
				session.save(carts);

				carts.setNew(false);
			}
			else {
				session.merge(carts);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CartsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((cartsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { cartsModelImpl.getOriginalUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { cartsModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((cartsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SESSION_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cartsModelImpl.getOriginalSession_id()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SESSION_ID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SESSION_ID,
					args);

				args = new Object[] { cartsModelImpl.getSession_id() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SESSION_ID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SESSION_ID,
					args);
			}
		}

		EntityCacheUtil.putResult(CartsModelImpl.ENTITY_CACHE_ENABLED,
			CartsImpl.class, carts.getPrimaryKey(), carts);

		return carts;
	}

	protected Carts toUnwrappedModel(Carts carts) {
		if (carts instanceof CartsImpl) {
			return carts;
		}

		CartsImpl cartsImpl = new CartsImpl();

		cartsImpl.setNew(carts.isNew());
		cartsImpl.setPrimaryKey(carts.getPrimaryKey());

		cartsImpl.setCartId(carts.getCartId());
		cartsImpl.setUserId(carts.getUserId());
		cartsImpl.setCreateDate(carts.getCreateDate());
		cartsImpl.setModifiedDate(carts.getModifiedDate());
		cartsImpl.setSession_id(carts.getSession_id());
		cartsImpl.setStaffId(carts.getStaffId());

		return cartsImpl;
	}

	/**
	 * Returns the carts with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the carts
	 * @return the carts
	 * @throws com.cloud.tags.NoSuchCartsException if a carts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Carts findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCartsException, SystemException {
		Carts carts = fetchByPrimaryKey(primaryKey);

		if (carts == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCartsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return carts;
	}

	/**
	 * Returns the carts with the primary key or throws a {@link com.cloud.tags.NoSuchCartsException} if it could not be found.
	 *
	 * @param cartId the primary key of the carts
	 * @return the carts
	 * @throws com.cloud.tags.NoSuchCartsException if a carts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Carts findByPrimaryKey(long cartId)
		throws NoSuchCartsException, SystemException {
		return findByPrimaryKey((Serializable)cartId);
	}

	/**
	 * Returns the carts with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the carts
	 * @return the carts, or <code>null</code> if a carts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Carts fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Carts carts = (Carts)EntityCacheUtil.getResult(CartsModelImpl.ENTITY_CACHE_ENABLED,
				CartsImpl.class, primaryKey);

		if (carts == _nullCarts) {
			return null;
		}

		if (carts == null) {
			Session session = null;

			try {
				session = openSession();

				carts = (Carts)session.get(CartsImpl.class, primaryKey);

				if (carts != null) {
					cacheResult(carts);
				}
				else {
					EntityCacheUtil.putResult(CartsModelImpl.ENTITY_CACHE_ENABLED,
						CartsImpl.class, primaryKey, _nullCarts);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CartsModelImpl.ENTITY_CACHE_ENABLED,
					CartsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return carts;
	}

	/**
	 * Returns the carts with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cartId the primary key of the carts
	 * @return the carts, or <code>null</code> if a carts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Carts fetchByPrimaryKey(long cartId) throws SystemException {
		return fetchByPrimaryKey((Serializable)cartId);
	}

	/**
	 * Returns all the cartses.
	 *
	 * @return the cartses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Carts> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Carts> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cartses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cartses
	 * @param end the upper bound of the range of cartses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cartses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Carts> findAll(int start, int end,
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

		List<Carts> list = (List<Carts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CARTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CARTS;

				if (pagination) {
					sql = sql.concat(CartsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Carts>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Carts>(list);
				}
				else {
					list = (List<Carts>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the cartses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Carts carts : findAll()) {
			remove(carts);
		}
	}

	/**
	 * Returns the number of cartses.
	 *
	 * @return the number of cartses
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

				Query q = session.createQuery(_SQL_COUNT_CARTS);

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
	 * Initializes the carts persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cloud.tags.model.Carts")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Carts>> listenersList = new ArrayList<ModelListener<Carts>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Carts>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CartsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CARTS = "SELECT carts FROM Carts carts";
	private static final String _SQL_SELECT_CARTS_WHERE = "SELECT carts FROM Carts carts WHERE ";
	private static final String _SQL_COUNT_CARTS = "SELECT COUNT(carts) FROM Carts carts";
	private static final String _SQL_COUNT_CARTS_WHERE = "SELECT COUNT(carts) FROM Carts carts WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "carts.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Carts exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Carts exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CartsPersistenceImpl.class);
	private static Carts _nullCarts = new CartsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Carts> toCacheModel() {
				return _nullCartsCacheModel;
			}
		};

	private static CacheModel<Carts> _nullCartsCacheModel = new CacheModel<Carts>() {
			@Override
			public Carts toEntityModel() {
				return _nullCarts;
			}
		};
}