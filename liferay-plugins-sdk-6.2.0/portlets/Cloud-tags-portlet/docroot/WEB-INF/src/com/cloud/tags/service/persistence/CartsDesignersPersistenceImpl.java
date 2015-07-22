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

import com.cloud.tags.NoSuchCartsDesignersException;
import com.cloud.tags.model.CartsDesigners;
import com.cloud.tags.model.impl.CartsDesignersImpl;
import com.cloud.tags.model.impl.CartsDesignersModelImpl;

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
 * The persistence implementation for the carts designers service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see CartsDesignersPersistence
 * @see CartsDesignersUtil
 * @generated
 */
public class CartsDesignersPersistenceImpl extends BasePersistenceImpl<CartsDesigners>
	implements CartsDesignersPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CartsDesignersUtil} to access the carts designers persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CartsDesignersImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CartsDesignersModelImpl.ENTITY_CACHE_ENABLED,
			CartsDesignersModelImpl.FINDER_CACHE_ENABLED,
			CartsDesignersImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CartsDesignersModelImpl.ENTITY_CACHE_ENABLED,
			CartsDesignersModelImpl.FINDER_CACHE_ENABLED,
			CartsDesignersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CartsDesignersModelImpl.ENTITY_CACHE_ENABLED,
			CartsDesignersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CARTID = new FinderPath(CartsDesignersModelImpl.ENTITY_CACHE_ENABLED,
			CartsDesignersModelImpl.FINDER_CACHE_ENABLED,
			CartsDesignersImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCartId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARTID =
		new FinderPath(CartsDesignersModelImpl.ENTITY_CACHE_ENABLED,
			CartsDesignersModelImpl.FINDER_CACHE_ENABLED,
			CartsDesignersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCartId",
			new String[] { Long.class.getName() },
			CartsDesignersModelImpl.CARTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CARTID = new FinderPath(CartsDesignersModelImpl.ENTITY_CACHE_ENABLED,
			CartsDesignersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCartId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the carts designerses where cartId = &#63;.
	 *
	 * @param cartId the cart ID
	 * @return the matching carts designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CartsDesigners> findByCartId(long cartId)
		throws SystemException {
		return findByCartId(cartId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the carts designerses where cartId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsDesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cartId the cart ID
	 * @param start the lower bound of the range of carts designerses
	 * @param end the upper bound of the range of carts designerses (not inclusive)
	 * @return the range of matching carts designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CartsDesigners> findByCartId(long cartId, int start, int end)
		throws SystemException {
		return findByCartId(cartId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the carts designerses where cartId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsDesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cartId the cart ID
	 * @param start the lower bound of the range of carts designerses
	 * @param end the upper bound of the range of carts designerses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching carts designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CartsDesigners> findByCartId(long cartId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARTID;
			finderArgs = new Object[] { cartId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CARTID;
			finderArgs = new Object[] { cartId, start, end, orderByComparator };
		}

		List<CartsDesigners> list = (List<CartsDesigners>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CartsDesigners cartsDesigners : list) {
				if ((cartId != cartsDesigners.getCartId())) {
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

			query.append(_SQL_SELECT_CARTSDESIGNERS_WHERE);

			query.append(_FINDER_COLUMN_CARTID_CARTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CartsDesignersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cartId);

				if (!pagination) {
					list = (List<CartsDesigners>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CartsDesigners>(list);
				}
				else {
					list = (List<CartsDesigners>)QueryUtil.list(q,
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
	 * Returns the first carts designers in the ordered set where cartId = &#63;.
	 *
	 * @param cartId the cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carts designers
	 * @throws com.cloud.tags.NoSuchCartsDesignersException if a matching carts designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners findByCartId_First(long cartId,
		OrderByComparator orderByComparator)
		throws NoSuchCartsDesignersException, SystemException {
		CartsDesigners cartsDesigners = fetchByCartId_First(cartId,
				orderByComparator);

		if (cartsDesigners != null) {
			return cartsDesigners;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cartId=");
		msg.append(cartId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCartsDesignersException(msg.toString());
	}

	/**
	 * Returns the first carts designers in the ordered set where cartId = &#63;.
	 *
	 * @param cartId the cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carts designers, or <code>null</code> if a matching carts designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners fetchByCartId_First(long cartId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CartsDesigners> list = findByCartId(cartId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last carts designers in the ordered set where cartId = &#63;.
	 *
	 * @param cartId the cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carts designers
	 * @throws com.cloud.tags.NoSuchCartsDesignersException if a matching carts designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners findByCartId_Last(long cartId,
		OrderByComparator orderByComparator)
		throws NoSuchCartsDesignersException, SystemException {
		CartsDesigners cartsDesigners = fetchByCartId_Last(cartId,
				orderByComparator);

		if (cartsDesigners != null) {
			return cartsDesigners;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cartId=");
		msg.append(cartId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCartsDesignersException(msg.toString());
	}

	/**
	 * Returns the last carts designers in the ordered set where cartId = &#63;.
	 *
	 * @param cartId the cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carts designers, or <code>null</code> if a matching carts designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners fetchByCartId_Last(long cartId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCartId(cartId);

		if (count == 0) {
			return null;
		}

		List<CartsDesigners> list = findByCartId(cartId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the carts designerses before and after the current carts designers in the ordered set where cartId = &#63;.
	 *
	 * @param cartDesignerId the primary key of the current carts designers
	 * @param cartId the cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next carts designers
	 * @throws com.cloud.tags.NoSuchCartsDesignersException if a carts designers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners[] findByCartId_PrevAndNext(long cartDesignerId,
		long cartId, OrderByComparator orderByComparator)
		throws NoSuchCartsDesignersException, SystemException {
		CartsDesigners cartsDesigners = findByPrimaryKey(cartDesignerId);

		Session session = null;

		try {
			session = openSession();

			CartsDesigners[] array = new CartsDesignersImpl[3];

			array[0] = getByCartId_PrevAndNext(session, cartsDesigners, cartId,
					orderByComparator, true);

			array[1] = cartsDesigners;

			array[2] = getByCartId_PrevAndNext(session, cartsDesigners, cartId,
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

	protected CartsDesigners getByCartId_PrevAndNext(Session session,
		CartsDesigners cartsDesigners, long cartId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CARTSDESIGNERS_WHERE);

		query.append(_FINDER_COLUMN_CARTID_CARTID_2);

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
			query.append(CartsDesignersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cartId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cartsDesigners);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CartsDesigners> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the carts designerses where cartId = &#63; from the database.
	 *
	 * @param cartId the cart ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCartId(long cartId) throws SystemException {
		for (CartsDesigners cartsDesigners : findByCartId(cartId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(cartsDesigners);
		}
	}

	/**
	 * Returns the number of carts designerses where cartId = &#63;.
	 *
	 * @param cartId the cart ID
	 * @return the number of matching carts designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCartId(long cartId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CARTID;

		Object[] finderArgs = new Object[] { cartId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CARTSDESIGNERS_WHERE);

			query.append(_FINDER_COLUMN_CARTID_CARTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cartId);

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

	private static final String _FINDER_COLUMN_CARTID_CARTID_2 = "cartsDesigners.cartId = ? AND cartsDesigners.kept = true";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CARTIDISXPCOMPUTED =
		new FinderPath(CartsDesignersModelImpl.ENTITY_CACHE_ENABLED,
			CartsDesignersModelImpl.FINDER_CACHE_ENABLED,
			CartsDesignersImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCartIdIsXPComputed",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARTIDISXPCOMPUTED =
		new FinderPath(CartsDesignersModelImpl.ENTITY_CACHE_ENABLED,
			CartsDesignersModelImpl.FINDER_CACHE_ENABLED,
			CartsDesignersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCartIdIsXPComputed", new String[] { Long.class.getName() },
			CartsDesignersModelImpl.CARTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CARTIDISXPCOMPUTED = new FinderPath(CartsDesignersModelImpl.ENTITY_CACHE_ENABLED,
			CartsDesignersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCartIdIsXPComputed", new String[] { Long.class.getName() });

	/**
	 * Returns all the carts designerses where cartId = &#63;.
	 *
	 * @param cartId the cart ID
	 * @return the matching carts designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CartsDesigners> findByCartIdIsXPComputed(long cartId)
		throws SystemException {
		return findByCartIdIsXPComputed(cartId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the carts designerses where cartId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsDesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cartId the cart ID
	 * @param start the lower bound of the range of carts designerses
	 * @param end the upper bound of the range of carts designerses (not inclusive)
	 * @return the range of matching carts designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CartsDesigners> findByCartIdIsXPComputed(long cartId,
		int start, int end) throws SystemException {
		return findByCartIdIsXPComputed(cartId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the carts designerses where cartId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsDesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cartId the cart ID
	 * @param start the lower bound of the range of carts designerses
	 * @param end the upper bound of the range of carts designerses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching carts designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CartsDesigners> findByCartIdIsXPComputed(long cartId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARTIDISXPCOMPUTED;
			finderArgs = new Object[] { cartId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CARTIDISXPCOMPUTED;
			finderArgs = new Object[] { cartId, start, end, orderByComparator };
		}

		List<CartsDesigners> list = (List<CartsDesigners>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CartsDesigners cartsDesigners : list) {
				if ((cartId != cartsDesigners.getCartId())) {
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

			query.append(_SQL_SELECT_CARTSDESIGNERS_WHERE);

			query.append(_FINDER_COLUMN_CARTIDISXPCOMPUTED_CARTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CartsDesignersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cartId);

				if (!pagination) {
					list = (List<CartsDesigners>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CartsDesigners>(list);
				}
				else {
					list = (List<CartsDesigners>)QueryUtil.list(q,
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
	 * Returns the first carts designers in the ordered set where cartId = &#63;.
	 *
	 * @param cartId the cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carts designers
	 * @throws com.cloud.tags.NoSuchCartsDesignersException if a matching carts designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners findByCartIdIsXPComputed_First(long cartId,
		OrderByComparator orderByComparator)
		throws NoSuchCartsDesignersException, SystemException {
		CartsDesigners cartsDesigners = fetchByCartIdIsXPComputed_First(cartId,
				orderByComparator);

		if (cartsDesigners != null) {
			return cartsDesigners;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cartId=");
		msg.append(cartId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCartsDesignersException(msg.toString());
	}

	/**
	 * Returns the first carts designers in the ordered set where cartId = &#63;.
	 *
	 * @param cartId the cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carts designers, or <code>null</code> if a matching carts designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners fetchByCartIdIsXPComputed_First(long cartId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CartsDesigners> list = findByCartIdIsXPComputed(cartId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last carts designers in the ordered set where cartId = &#63;.
	 *
	 * @param cartId the cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carts designers
	 * @throws com.cloud.tags.NoSuchCartsDesignersException if a matching carts designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners findByCartIdIsXPComputed_Last(long cartId,
		OrderByComparator orderByComparator)
		throws NoSuchCartsDesignersException, SystemException {
		CartsDesigners cartsDesigners = fetchByCartIdIsXPComputed_Last(cartId,
				orderByComparator);

		if (cartsDesigners != null) {
			return cartsDesigners;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cartId=");
		msg.append(cartId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCartsDesignersException(msg.toString());
	}

	/**
	 * Returns the last carts designers in the ordered set where cartId = &#63;.
	 *
	 * @param cartId the cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carts designers, or <code>null</code> if a matching carts designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners fetchByCartIdIsXPComputed_Last(long cartId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCartIdIsXPComputed(cartId);

		if (count == 0) {
			return null;
		}

		List<CartsDesigners> list = findByCartIdIsXPComputed(cartId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the carts designerses before and after the current carts designers in the ordered set where cartId = &#63;.
	 *
	 * @param cartDesignerId the primary key of the current carts designers
	 * @param cartId the cart ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next carts designers
	 * @throws com.cloud.tags.NoSuchCartsDesignersException if a carts designers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners[] findByCartIdIsXPComputed_PrevAndNext(
		long cartDesignerId, long cartId, OrderByComparator orderByComparator)
		throws NoSuchCartsDesignersException, SystemException {
		CartsDesigners cartsDesigners = findByPrimaryKey(cartDesignerId);

		Session session = null;

		try {
			session = openSession();

			CartsDesigners[] array = new CartsDesignersImpl[3];

			array[0] = getByCartIdIsXPComputed_PrevAndNext(session,
					cartsDesigners, cartId, orderByComparator, true);

			array[1] = cartsDesigners;

			array[2] = getByCartIdIsXPComputed_PrevAndNext(session,
					cartsDesigners, cartId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CartsDesigners getByCartIdIsXPComputed_PrevAndNext(
		Session session, CartsDesigners cartsDesigners, long cartId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CARTSDESIGNERS_WHERE);

		query.append(_FINDER_COLUMN_CARTIDISXPCOMPUTED_CARTID_2);

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
			query.append(CartsDesignersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cartId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cartsDesigners);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CartsDesigners> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the carts designerses where cartId = &#63; from the database.
	 *
	 * @param cartId the cart ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCartIdIsXPComputed(long cartId)
		throws SystemException {
		for (CartsDesigners cartsDesigners : findByCartIdIsXPComputed(cartId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(cartsDesigners);
		}
	}

	/**
	 * Returns the number of carts designerses where cartId = &#63;.
	 *
	 * @param cartId the cart ID
	 * @return the number of matching carts designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCartIdIsXPComputed(long cartId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CARTIDISXPCOMPUTED;

		Object[] finderArgs = new Object[] { cartId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CARTSDESIGNERS_WHERE);

			query.append(_FINDER_COLUMN_CARTIDISXPCOMPUTED_CARTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cartId);

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

	private static final String _FINDER_COLUMN_CARTIDISXPCOMPUTED_CARTID_2 = "cartsDesigners.cartId = ? AND cartsDesigners.XPComputed = false";
	public static final FinderPath FINDER_PATH_FETCH_BY_CARTIDDESIGNERID = new FinderPath(CartsDesignersModelImpl.ENTITY_CACHE_ENABLED,
			CartsDesignersModelImpl.FINDER_CACHE_ENABLED,
			CartsDesignersImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCartIdDesignerId",
			new String[] { Long.class.getName(), Long.class.getName() },
			CartsDesignersModelImpl.CARTID_COLUMN_BITMASK |
			CartsDesignersModelImpl.DESIGNID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CARTIDDESIGNERID = new FinderPath(CartsDesignersModelImpl.ENTITY_CACHE_ENABLED,
			CartsDesignersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCartIdDesignerId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the carts designers where cartId = &#63; and designId = &#63; or throws a {@link com.cloud.tags.NoSuchCartsDesignersException} if it could not be found.
	 *
	 * @param cartId the cart ID
	 * @param designId the design ID
	 * @return the matching carts designers
	 * @throws com.cloud.tags.NoSuchCartsDesignersException if a matching carts designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners findByCartIdDesignerId(long cartId, long designId)
		throws NoSuchCartsDesignersException, SystemException {
		CartsDesigners cartsDesigners = fetchByCartIdDesignerId(cartId, designId);

		if (cartsDesigners == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cartId=");
			msg.append(cartId);

			msg.append(", designId=");
			msg.append(designId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCartsDesignersException(msg.toString());
		}

		return cartsDesigners;
	}

	/**
	 * Returns the carts designers where cartId = &#63; and designId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cartId the cart ID
	 * @param designId the design ID
	 * @return the matching carts designers, or <code>null</code> if a matching carts designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners fetchByCartIdDesignerId(long cartId, long designId)
		throws SystemException {
		return fetchByCartIdDesignerId(cartId, designId, true);
	}

	/**
	 * Returns the carts designers where cartId = &#63; and designId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cartId the cart ID
	 * @param designId the design ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching carts designers, or <code>null</code> if a matching carts designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners fetchByCartIdDesignerId(long cartId, long designId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { cartId, designId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CARTIDDESIGNERID,
					finderArgs, this);
		}

		if (result instanceof CartsDesigners) {
			CartsDesigners cartsDesigners = (CartsDesigners)result;

			if ((cartId != cartsDesigners.getCartId()) ||
					(designId != cartsDesigners.getDesignId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CARTSDESIGNERS_WHERE);

			query.append(_FINDER_COLUMN_CARTIDDESIGNERID_CARTID_2);

			query.append(_FINDER_COLUMN_CARTIDDESIGNERID_DESIGNID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cartId);

				qPos.add(designId);

				List<CartsDesigners> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CARTIDDESIGNERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CartsDesignersPersistenceImpl.fetchByCartIdDesignerId(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CartsDesigners cartsDesigners = list.get(0);

					result = cartsDesigners;

					cacheResult(cartsDesigners);

					if ((cartsDesigners.getCartId() != cartId) ||
							(cartsDesigners.getDesignId() != designId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CARTIDDESIGNERID,
							finderArgs, cartsDesigners);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CARTIDDESIGNERID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CartsDesigners)result;
		}
	}

	/**
	 * Removes the carts designers where cartId = &#63; and designId = &#63; from the database.
	 *
	 * @param cartId the cart ID
	 * @param designId the design ID
	 * @return the carts designers that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners removeByCartIdDesignerId(long cartId, long designId)
		throws NoSuchCartsDesignersException, SystemException {
		CartsDesigners cartsDesigners = findByCartIdDesignerId(cartId, designId);

		return remove(cartsDesigners);
	}

	/**
	 * Returns the number of carts designerses where cartId = &#63; and designId = &#63;.
	 *
	 * @param cartId the cart ID
	 * @param designId the design ID
	 * @return the number of matching carts designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCartIdDesignerId(long cartId, long designId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CARTIDDESIGNERID;

		Object[] finderArgs = new Object[] { cartId, designId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CARTSDESIGNERS_WHERE);

			query.append(_FINDER_COLUMN_CARTIDDESIGNERID_CARTID_2);

			query.append(_FINDER_COLUMN_CARTIDDESIGNERID_DESIGNID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cartId);

				qPos.add(designId);

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

	private static final String _FINDER_COLUMN_CARTIDDESIGNERID_CARTID_2 = "cartsDesigners.cartId = ? AND ";
	private static final String _FINDER_COLUMN_CARTIDDESIGNERID_DESIGNID_2 = "cartsDesigners.designId = ? AND cartsDesigners.kept = true";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STAFFID = new FinderPath(CartsDesignersModelImpl.ENTITY_CACHE_ENABLED,
			CartsDesignersModelImpl.FINDER_CACHE_ENABLED,
			CartsDesignersImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStaffId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STAFFID =
		new FinderPath(CartsDesignersModelImpl.ENTITY_CACHE_ENABLED,
			CartsDesignersModelImpl.FINDER_CACHE_ENABLED,
			CartsDesignersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStaffId",
			new String[] { String.class.getName() },
			CartsDesignersModelImpl.STAFFID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STAFFID = new FinderPath(CartsDesignersModelImpl.ENTITY_CACHE_ENABLED,
			CartsDesignersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStaffId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the carts designerses where staffId = &#63;.
	 *
	 * @param staffId the staff ID
	 * @return the matching carts designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CartsDesigners> findByStaffId(String staffId)
		throws SystemException {
		return findByStaffId(staffId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the carts designerses where staffId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsDesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param staffId the staff ID
	 * @param start the lower bound of the range of carts designerses
	 * @param end the upper bound of the range of carts designerses (not inclusive)
	 * @return the range of matching carts designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CartsDesigners> findByStaffId(String staffId, int start, int end)
		throws SystemException {
		return findByStaffId(staffId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the carts designerses where staffId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsDesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param staffId the staff ID
	 * @param start the lower bound of the range of carts designerses
	 * @param end the upper bound of the range of carts designerses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching carts designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CartsDesigners> findByStaffId(String staffId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<CartsDesigners> list = (List<CartsDesigners>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CartsDesigners cartsDesigners : list) {
				if (!Validator.equals(staffId, cartsDesigners.getStaffId())) {
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

			query.append(_SQL_SELECT_CARTSDESIGNERS_WHERE);

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
				query.append(CartsDesignersModelImpl.ORDER_BY_JPQL);
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
					list = (List<CartsDesigners>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CartsDesigners>(list);
				}
				else {
					list = (List<CartsDesigners>)QueryUtil.list(q,
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
	 * Returns the first carts designers in the ordered set where staffId = &#63;.
	 *
	 * @param staffId the staff ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carts designers
	 * @throws com.cloud.tags.NoSuchCartsDesignersException if a matching carts designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners findByStaffId_First(String staffId,
		OrderByComparator orderByComparator)
		throws NoSuchCartsDesignersException, SystemException {
		CartsDesigners cartsDesigners = fetchByStaffId_First(staffId,
				orderByComparator);

		if (cartsDesigners != null) {
			return cartsDesigners;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("staffId=");
		msg.append(staffId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCartsDesignersException(msg.toString());
	}

	/**
	 * Returns the first carts designers in the ordered set where staffId = &#63;.
	 *
	 * @param staffId the staff ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching carts designers, or <code>null</code> if a matching carts designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners fetchByStaffId_First(String staffId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CartsDesigners> list = findByStaffId(staffId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last carts designers in the ordered set where staffId = &#63;.
	 *
	 * @param staffId the staff ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carts designers
	 * @throws com.cloud.tags.NoSuchCartsDesignersException if a matching carts designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners findByStaffId_Last(String staffId,
		OrderByComparator orderByComparator)
		throws NoSuchCartsDesignersException, SystemException {
		CartsDesigners cartsDesigners = fetchByStaffId_Last(staffId,
				orderByComparator);

		if (cartsDesigners != null) {
			return cartsDesigners;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("staffId=");
		msg.append(staffId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCartsDesignersException(msg.toString());
	}

	/**
	 * Returns the last carts designers in the ordered set where staffId = &#63;.
	 *
	 * @param staffId the staff ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching carts designers, or <code>null</code> if a matching carts designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners fetchByStaffId_Last(String staffId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStaffId(staffId);

		if (count == 0) {
			return null;
		}

		List<CartsDesigners> list = findByStaffId(staffId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the carts designerses before and after the current carts designers in the ordered set where staffId = &#63;.
	 *
	 * @param cartDesignerId the primary key of the current carts designers
	 * @param staffId the staff ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next carts designers
	 * @throws com.cloud.tags.NoSuchCartsDesignersException if a carts designers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners[] findByStaffId_PrevAndNext(long cartDesignerId,
		String staffId, OrderByComparator orderByComparator)
		throws NoSuchCartsDesignersException, SystemException {
		CartsDesigners cartsDesigners = findByPrimaryKey(cartDesignerId);

		Session session = null;

		try {
			session = openSession();

			CartsDesigners[] array = new CartsDesignersImpl[3];

			array[0] = getByStaffId_PrevAndNext(session, cartsDesigners,
					staffId, orderByComparator, true);

			array[1] = cartsDesigners;

			array[2] = getByStaffId_PrevAndNext(session, cartsDesigners,
					staffId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CartsDesigners getByStaffId_PrevAndNext(Session session,
		CartsDesigners cartsDesigners, String staffId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CARTSDESIGNERS_WHERE);

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
			query.append(CartsDesignersModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(cartsDesigners);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CartsDesigners> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the carts designerses where staffId = &#63; from the database.
	 *
	 * @param staffId the staff ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStaffId(String staffId) throws SystemException {
		for (CartsDesigners cartsDesigners : findByStaffId(staffId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(cartsDesigners);
		}
	}

	/**
	 * Returns the number of carts designerses where staffId = &#63;.
	 *
	 * @param staffId the staff ID
	 * @return the number of matching carts designerses
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

			query.append(_SQL_COUNT_CARTSDESIGNERS_WHERE);

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

	private static final String _FINDER_COLUMN_STAFFID_STAFFID_1 = "cartsDesigners.staffId IS NULL";
	private static final String _FINDER_COLUMN_STAFFID_STAFFID_2 = "cartsDesigners.staffId = ?";
	private static final String _FINDER_COLUMN_STAFFID_STAFFID_3 = "(cartsDesigners.staffId IS NULL OR cartsDesigners.staffId = '')";

	public CartsDesignersPersistenceImpl() {
		setModelClass(CartsDesigners.class);
	}

	/**
	 * Caches the carts designers in the entity cache if it is enabled.
	 *
	 * @param cartsDesigners the carts designers
	 */
	@Override
	public void cacheResult(CartsDesigners cartsDesigners) {
		EntityCacheUtil.putResult(CartsDesignersModelImpl.ENTITY_CACHE_ENABLED,
			CartsDesignersImpl.class, cartsDesigners.getPrimaryKey(),
			cartsDesigners);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CARTIDDESIGNERID,
			new Object[] {
				cartsDesigners.getCartId(), cartsDesigners.getDesignId()
			}, cartsDesigners);

		cartsDesigners.resetOriginalValues();
	}

	/**
	 * Caches the carts designerses in the entity cache if it is enabled.
	 *
	 * @param cartsDesignerses the carts designerses
	 */
	@Override
	public void cacheResult(List<CartsDesigners> cartsDesignerses) {
		for (CartsDesigners cartsDesigners : cartsDesignerses) {
			if (EntityCacheUtil.getResult(
						CartsDesignersModelImpl.ENTITY_CACHE_ENABLED,
						CartsDesignersImpl.class, cartsDesigners.getPrimaryKey()) == null) {
				cacheResult(cartsDesigners);
			}
			else {
				cartsDesigners.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all carts designerses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CartsDesignersImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CartsDesignersImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the carts designers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CartsDesigners cartsDesigners) {
		EntityCacheUtil.removeResult(CartsDesignersModelImpl.ENTITY_CACHE_ENABLED,
			CartsDesignersImpl.class, cartsDesigners.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(cartsDesigners);
	}

	@Override
	public void clearCache(List<CartsDesigners> cartsDesignerses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CartsDesigners cartsDesigners : cartsDesignerses) {
			EntityCacheUtil.removeResult(CartsDesignersModelImpl.ENTITY_CACHE_ENABLED,
				CartsDesignersImpl.class, cartsDesigners.getPrimaryKey());

			clearUniqueFindersCache(cartsDesigners);
		}
	}

	protected void cacheUniqueFindersCache(CartsDesigners cartsDesigners) {
		if (cartsDesigners.isNew()) {
			Object[] args = new Object[] {
					cartsDesigners.getCartId(), cartsDesigners.getDesignId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CARTIDDESIGNERID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CARTIDDESIGNERID,
				args, cartsDesigners);
		}
		else {
			CartsDesignersModelImpl cartsDesignersModelImpl = (CartsDesignersModelImpl)cartsDesigners;

			if ((cartsDesignersModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CARTIDDESIGNERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cartsDesigners.getCartId(), cartsDesigners.getDesignId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CARTIDDESIGNERID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CARTIDDESIGNERID,
					args, cartsDesigners);
			}
		}
	}

	protected void clearUniqueFindersCache(CartsDesigners cartsDesigners) {
		CartsDesignersModelImpl cartsDesignersModelImpl = (CartsDesignersModelImpl)cartsDesigners;

		Object[] args = new Object[] {
				cartsDesigners.getCartId(), cartsDesigners.getDesignId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CARTIDDESIGNERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CARTIDDESIGNERID, args);

		if ((cartsDesignersModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CARTIDDESIGNERID.getColumnBitmask()) != 0) {
			args = new Object[] {
					cartsDesignersModelImpl.getOriginalCartId(),
					cartsDesignersModelImpl.getOriginalDesignId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CARTIDDESIGNERID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CARTIDDESIGNERID,
				args);
		}
	}

	/**
	 * Creates a new carts designers with the primary key. Does not add the carts designers to the database.
	 *
	 * @param cartDesignerId the primary key for the new carts designers
	 * @return the new carts designers
	 */
	@Override
	public CartsDesigners create(long cartDesignerId) {
		CartsDesigners cartsDesigners = new CartsDesignersImpl();

		cartsDesigners.setNew(true);
		cartsDesigners.setPrimaryKey(cartDesignerId);

		return cartsDesigners;
	}

	/**
	 * Removes the carts designers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cartDesignerId the primary key of the carts designers
	 * @return the carts designers that was removed
	 * @throws com.cloud.tags.NoSuchCartsDesignersException if a carts designers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners remove(long cartDesignerId)
		throws NoSuchCartsDesignersException, SystemException {
		return remove((Serializable)cartDesignerId);
	}

	/**
	 * Removes the carts designers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the carts designers
	 * @return the carts designers that was removed
	 * @throws com.cloud.tags.NoSuchCartsDesignersException if a carts designers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners remove(Serializable primaryKey)
		throws NoSuchCartsDesignersException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CartsDesigners cartsDesigners = (CartsDesigners)session.get(CartsDesignersImpl.class,
					primaryKey);

			if (cartsDesigners == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCartsDesignersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cartsDesigners);
		}
		catch (NoSuchCartsDesignersException nsee) {
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
	protected CartsDesigners removeImpl(CartsDesigners cartsDesigners)
		throws SystemException {
		cartsDesigners = toUnwrappedModel(cartsDesigners);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cartsDesigners)) {
				cartsDesigners = (CartsDesigners)session.get(CartsDesignersImpl.class,
						cartsDesigners.getPrimaryKeyObj());
			}

			if (cartsDesigners != null) {
				session.delete(cartsDesigners);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cartsDesigners != null) {
			clearCache(cartsDesigners);
		}

		return cartsDesigners;
	}

	@Override
	public CartsDesigners updateImpl(
		com.cloud.tags.model.CartsDesigners cartsDesigners)
		throws SystemException {
		cartsDesigners = toUnwrappedModel(cartsDesigners);

		boolean isNew = cartsDesigners.isNew();

		CartsDesignersModelImpl cartsDesignersModelImpl = (CartsDesignersModelImpl)cartsDesigners;

		Session session = null;

		try {
			session = openSession();

			if (cartsDesigners.isNew()) {
				session.save(cartsDesigners);

				cartsDesigners.setNew(false);
			}
			else {
				session.merge(cartsDesigners);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CartsDesignersModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((cartsDesignersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cartsDesignersModelImpl.getOriginalCartId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CARTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARTID,
					args);

				args = new Object[] { cartsDesignersModelImpl.getCartId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CARTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARTID,
					args);
			}

			if ((cartsDesignersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARTIDISXPCOMPUTED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cartsDesignersModelImpl.getOriginalCartId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CARTIDISXPCOMPUTED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARTIDISXPCOMPUTED,
					args);

				args = new Object[] { cartsDesignersModelImpl.getCartId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CARTIDISXPCOMPUTED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARTIDISXPCOMPUTED,
					args);
			}

			if ((cartsDesignersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STAFFID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cartsDesignersModelImpl.getOriginalStaffId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STAFFID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STAFFID,
					args);

				args = new Object[] { cartsDesignersModelImpl.getStaffId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STAFFID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STAFFID,
					args);
			}
		}

		EntityCacheUtil.putResult(CartsDesignersModelImpl.ENTITY_CACHE_ENABLED,
			CartsDesignersImpl.class, cartsDesigners.getPrimaryKey(),
			cartsDesigners);

		clearUniqueFindersCache(cartsDesigners);
		cacheUniqueFindersCache(cartsDesigners);

		return cartsDesigners;
	}

	protected CartsDesigners toUnwrappedModel(CartsDesigners cartsDesigners) {
		if (cartsDesigners instanceof CartsDesignersImpl) {
			return cartsDesigners;
		}

		CartsDesignersImpl cartsDesignersImpl = new CartsDesignersImpl();

		cartsDesignersImpl.setNew(cartsDesigners.isNew());
		cartsDesignersImpl.setPrimaryKey(cartsDesigners.getPrimaryKey());

		cartsDesignersImpl.setCartDesignerId(cartsDesigners.getCartDesignerId());
		cartsDesignersImpl.setCartId(cartsDesigners.getCartId());
		cartsDesignersImpl.setDesignId(cartsDesigners.getDesignId());
		cartsDesignersImpl.setCreateDate(cartsDesigners.getCreateDate());
		cartsDesignersImpl.setModifiedDate(cartsDesigners.getModifiedDate());
		cartsDesignersImpl.setKept(cartsDesigners.isKept());
		cartsDesignersImpl.setFavorite(cartsDesigners.isFavorite());
		cartsDesignersImpl.setStaffId(cartsDesigners.getStaffId());
		cartsDesignersImpl.setUserNote(cartsDesigners.getUserNote());
		cartsDesignersImpl.setXPComputed(cartsDesigners.isXPComputed());

		return cartsDesignersImpl;
	}

	/**
	 * Returns the carts designers with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the carts designers
	 * @return the carts designers
	 * @throws com.cloud.tags.NoSuchCartsDesignersException if a carts designers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCartsDesignersException, SystemException {
		CartsDesigners cartsDesigners = fetchByPrimaryKey(primaryKey);

		if (cartsDesigners == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCartsDesignersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cartsDesigners;
	}

	/**
	 * Returns the carts designers with the primary key or throws a {@link com.cloud.tags.NoSuchCartsDesignersException} if it could not be found.
	 *
	 * @param cartDesignerId the primary key of the carts designers
	 * @return the carts designers
	 * @throws com.cloud.tags.NoSuchCartsDesignersException if a carts designers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners findByPrimaryKey(long cartDesignerId)
		throws NoSuchCartsDesignersException, SystemException {
		return findByPrimaryKey((Serializable)cartDesignerId);
	}

	/**
	 * Returns the carts designers with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the carts designers
	 * @return the carts designers, or <code>null</code> if a carts designers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CartsDesigners cartsDesigners = (CartsDesigners)EntityCacheUtil.getResult(CartsDesignersModelImpl.ENTITY_CACHE_ENABLED,
				CartsDesignersImpl.class, primaryKey);

		if (cartsDesigners == _nullCartsDesigners) {
			return null;
		}

		if (cartsDesigners == null) {
			Session session = null;

			try {
				session = openSession();

				cartsDesigners = (CartsDesigners)session.get(CartsDesignersImpl.class,
						primaryKey);

				if (cartsDesigners != null) {
					cacheResult(cartsDesigners);
				}
				else {
					EntityCacheUtil.putResult(CartsDesignersModelImpl.ENTITY_CACHE_ENABLED,
						CartsDesignersImpl.class, primaryKey,
						_nullCartsDesigners);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CartsDesignersModelImpl.ENTITY_CACHE_ENABLED,
					CartsDesignersImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cartsDesigners;
	}

	/**
	 * Returns the carts designers with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cartDesignerId the primary key of the carts designers
	 * @return the carts designers, or <code>null</code> if a carts designers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CartsDesigners fetchByPrimaryKey(long cartDesignerId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)cartDesignerId);
	}

	/**
	 * Returns all the carts designerses.
	 *
	 * @return the carts designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CartsDesigners> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the carts designerses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsDesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of carts designerses
	 * @param end the upper bound of the range of carts designerses (not inclusive)
	 * @return the range of carts designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CartsDesigners> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the carts designerses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CartsDesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of carts designerses
	 * @param end the upper bound of the range of carts designerses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of carts designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CartsDesigners> findAll(int start, int end,
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

		List<CartsDesigners> list = (List<CartsDesigners>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CARTSDESIGNERS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CARTSDESIGNERS;

				if (pagination) {
					sql = sql.concat(CartsDesignersModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CartsDesigners>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CartsDesigners>(list);
				}
				else {
					list = (List<CartsDesigners>)QueryUtil.list(q,
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
	 * Removes all the carts designerses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CartsDesigners cartsDesigners : findAll()) {
			remove(cartsDesigners);
		}
	}

	/**
	 * Returns the number of carts designerses.
	 *
	 * @return the number of carts designerses
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

				Query q = session.createQuery(_SQL_COUNT_CARTSDESIGNERS);

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
	 * Initializes the carts designers persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cloud.tags.model.CartsDesigners")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CartsDesigners>> listenersList = new ArrayList<ModelListener<CartsDesigners>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CartsDesigners>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CartsDesignersImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CARTSDESIGNERS = "SELECT cartsDesigners FROM CartsDesigners cartsDesigners";
	private static final String _SQL_SELECT_CARTSDESIGNERS_WHERE = "SELECT cartsDesigners FROM CartsDesigners cartsDesigners WHERE ";
	private static final String _SQL_COUNT_CARTSDESIGNERS = "SELECT COUNT(cartsDesigners) FROM CartsDesigners cartsDesigners";
	private static final String _SQL_COUNT_CARTSDESIGNERS_WHERE = "SELECT COUNT(cartsDesigners) FROM CartsDesigners cartsDesigners WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cartsDesigners.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CartsDesigners exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CartsDesigners exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CartsDesignersPersistenceImpl.class);
	private static CartsDesigners _nullCartsDesigners = new CartsDesignersImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CartsDesigners> toCacheModel() {
				return _nullCartsDesignersCacheModel;
			}
		};

	private static CacheModel<CartsDesigners> _nullCartsDesignersCacheModel = new CacheModel<CartsDesigners>() {
			@Override
			public CartsDesigners toEntityModel() {
				return _nullCartsDesigners;
			}
		};
}