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

import com.cloud.tags.NoSuchStoreDeviceMapException;
import com.cloud.tags.model.StoreDeviceMap;
import com.cloud.tags.model.impl.StoreDeviceMapImpl;
import com.cloud.tags.model.impl.StoreDeviceMapModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the store device map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see StoreDeviceMapPersistence
 * @see StoreDeviceMapUtil
 * @generated
 */
public class StoreDeviceMapPersistenceImpl extends BasePersistenceImpl<StoreDeviceMap>
	implements StoreDeviceMapPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StoreDeviceMapUtil} to access the store device map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StoreDeviceMapImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StoreDeviceMapModelImpl.ENTITY_CACHE_ENABLED,
			StoreDeviceMapModelImpl.FINDER_CACHE_ENABLED,
			StoreDeviceMapImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StoreDeviceMapModelImpl.ENTITY_CACHE_ENABLED,
			StoreDeviceMapModelImpl.FINDER_CACHE_ENABLED,
			StoreDeviceMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StoreDeviceMapModelImpl.ENTITY_CACHE_ENABLED,
			StoreDeviceMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEVICE = new FinderPath(StoreDeviceMapModelImpl.ENTITY_CACHE_ENABLED,
			StoreDeviceMapModelImpl.FINDER_CACHE_ENABLED,
			StoreDeviceMapImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDevice",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICE =
		new FinderPath(StoreDeviceMapModelImpl.ENTITY_CACHE_ENABLED,
			StoreDeviceMapModelImpl.FINDER_CACHE_ENABLED,
			StoreDeviceMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDevice",
			new String[] { String.class.getName() },
			StoreDeviceMapModelImpl.DEVICEMACADDRESS_COLUMN_BITMASK |
			StoreDeviceMapModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEVICE = new FinderPath(StoreDeviceMapModelImpl.ENTITY_CACHE_ENABLED,
			StoreDeviceMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDevice",
			new String[] { String.class.getName() });

	/**
	 * Returns all the store device maps where deviceMacAddress = &#63;.
	 *
	 * @param deviceMacAddress the device mac address
	 * @return the matching store device maps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StoreDeviceMap> findByDevice(String deviceMacAddress)
		throws SystemException {
		return findByDevice(deviceMacAddress, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the store device maps where deviceMacAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.StoreDeviceMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param deviceMacAddress the device mac address
	 * @param start the lower bound of the range of store device maps
	 * @param end the upper bound of the range of store device maps (not inclusive)
	 * @return the range of matching store device maps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StoreDeviceMap> findByDevice(String deviceMacAddress,
		int start, int end) throws SystemException {
		return findByDevice(deviceMacAddress, start, end, null);
	}

	/**
	 * Returns an ordered range of all the store device maps where deviceMacAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.StoreDeviceMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param deviceMacAddress the device mac address
	 * @param start the lower bound of the range of store device maps
	 * @param end the upper bound of the range of store device maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching store device maps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StoreDeviceMap> findByDevice(String deviceMacAddress,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICE;
			finderArgs = new Object[] { deviceMacAddress };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEVICE;
			finderArgs = new Object[] {
					deviceMacAddress,
					
					start, end, orderByComparator
				};
		}

		List<StoreDeviceMap> list = (List<StoreDeviceMap>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StoreDeviceMap storeDeviceMap : list) {
				if (!Validator.equals(deviceMacAddress,
							storeDeviceMap.getDeviceMacAddress())) {
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

			query.append(_SQL_SELECT_STOREDEVICEMAP_WHERE);

			boolean bindDeviceMacAddress = false;

			if (deviceMacAddress == null) {
				query.append(_FINDER_COLUMN_DEVICE_DEVICEMACADDRESS_1);
			}
			else if (deviceMacAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DEVICE_DEVICEMACADDRESS_3);
			}
			else {
				bindDeviceMacAddress = true;

				query.append(_FINDER_COLUMN_DEVICE_DEVICEMACADDRESS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StoreDeviceMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDeviceMacAddress) {
					qPos.add(deviceMacAddress);
				}

				if (!pagination) {
					list = (List<StoreDeviceMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StoreDeviceMap>(list);
				}
				else {
					list = (List<StoreDeviceMap>)QueryUtil.list(q,
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
	 * Returns the first store device map in the ordered set where deviceMacAddress = &#63;.
	 *
	 * @param deviceMacAddress the device mac address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching store device map
	 * @throws com.cloud.tags.NoSuchStoreDeviceMapException if a matching store device map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StoreDeviceMap findByDevice_First(String deviceMacAddress,
		OrderByComparator orderByComparator)
		throws NoSuchStoreDeviceMapException, SystemException {
		StoreDeviceMap storeDeviceMap = fetchByDevice_First(deviceMacAddress,
				orderByComparator);

		if (storeDeviceMap != null) {
			return storeDeviceMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("deviceMacAddress=");
		msg.append(deviceMacAddress);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStoreDeviceMapException(msg.toString());
	}

	/**
	 * Returns the first store device map in the ordered set where deviceMacAddress = &#63;.
	 *
	 * @param deviceMacAddress the device mac address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching store device map, or <code>null</code> if a matching store device map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StoreDeviceMap fetchByDevice_First(String deviceMacAddress,
		OrderByComparator orderByComparator) throws SystemException {
		List<StoreDeviceMap> list = findByDevice(deviceMacAddress, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last store device map in the ordered set where deviceMacAddress = &#63;.
	 *
	 * @param deviceMacAddress the device mac address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching store device map
	 * @throws com.cloud.tags.NoSuchStoreDeviceMapException if a matching store device map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StoreDeviceMap findByDevice_Last(String deviceMacAddress,
		OrderByComparator orderByComparator)
		throws NoSuchStoreDeviceMapException, SystemException {
		StoreDeviceMap storeDeviceMap = fetchByDevice_Last(deviceMacAddress,
				orderByComparator);

		if (storeDeviceMap != null) {
			return storeDeviceMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("deviceMacAddress=");
		msg.append(deviceMacAddress);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStoreDeviceMapException(msg.toString());
	}

	/**
	 * Returns the last store device map in the ordered set where deviceMacAddress = &#63;.
	 *
	 * @param deviceMacAddress the device mac address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching store device map, or <code>null</code> if a matching store device map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StoreDeviceMap fetchByDevice_Last(String deviceMacAddress,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDevice(deviceMacAddress);

		if (count == 0) {
			return null;
		}

		List<StoreDeviceMap> list = findByDevice(deviceMacAddress, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the store device maps before and after the current store device map in the ordered set where deviceMacAddress = &#63;.
	 *
	 * @param uuid the primary key of the current store device map
	 * @param deviceMacAddress the device mac address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next store device map
	 * @throws com.cloud.tags.NoSuchStoreDeviceMapException if a store device map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StoreDeviceMap[] findByDevice_PrevAndNext(long uuid,
		String deviceMacAddress, OrderByComparator orderByComparator)
		throws NoSuchStoreDeviceMapException, SystemException {
		StoreDeviceMap storeDeviceMap = findByPrimaryKey(uuid);

		Session session = null;

		try {
			session = openSession();

			StoreDeviceMap[] array = new StoreDeviceMapImpl[3];

			array[0] = getByDevice_PrevAndNext(session, storeDeviceMap,
					deviceMacAddress, orderByComparator, true);

			array[1] = storeDeviceMap;

			array[2] = getByDevice_PrevAndNext(session, storeDeviceMap,
					deviceMacAddress, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StoreDeviceMap getByDevice_PrevAndNext(Session session,
		StoreDeviceMap storeDeviceMap, String deviceMacAddress,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STOREDEVICEMAP_WHERE);

		boolean bindDeviceMacAddress = false;

		if (deviceMacAddress == null) {
			query.append(_FINDER_COLUMN_DEVICE_DEVICEMACADDRESS_1);
		}
		else if (deviceMacAddress.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DEVICE_DEVICEMACADDRESS_3);
		}
		else {
			bindDeviceMacAddress = true;

			query.append(_FINDER_COLUMN_DEVICE_DEVICEMACADDRESS_2);
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
			query.append(StoreDeviceMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDeviceMacAddress) {
			qPos.add(deviceMacAddress);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(storeDeviceMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StoreDeviceMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the store device maps where deviceMacAddress = &#63; from the database.
	 *
	 * @param deviceMacAddress the device mac address
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDevice(String deviceMacAddress)
		throws SystemException {
		for (StoreDeviceMap storeDeviceMap : findByDevice(deviceMacAddress,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(storeDeviceMap);
		}
	}

	/**
	 * Returns the number of store device maps where deviceMacAddress = &#63;.
	 *
	 * @param deviceMacAddress the device mac address
	 * @return the number of matching store device maps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDevice(String deviceMacAddress) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DEVICE;

		Object[] finderArgs = new Object[] { deviceMacAddress };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STOREDEVICEMAP_WHERE);

			boolean bindDeviceMacAddress = false;

			if (deviceMacAddress == null) {
				query.append(_FINDER_COLUMN_DEVICE_DEVICEMACADDRESS_1);
			}
			else if (deviceMacAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DEVICE_DEVICEMACADDRESS_3);
			}
			else {
				bindDeviceMacAddress = true;

				query.append(_FINDER_COLUMN_DEVICE_DEVICEMACADDRESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDeviceMacAddress) {
					qPos.add(deviceMacAddress);
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

	private static final String _FINDER_COLUMN_DEVICE_DEVICEMACADDRESS_1 = "storeDeviceMap.deviceMacAddress IS NULL";
	private static final String _FINDER_COLUMN_DEVICE_DEVICEMACADDRESS_2 = "storeDeviceMap.deviceMacAddress = ?";
	private static final String _FINDER_COLUMN_DEVICE_DEVICEMACADDRESS_3 = "(storeDeviceMap.deviceMacAddress IS NULL OR storeDeviceMap.deviceMacAddress = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STORENAME =
		new FinderPath(StoreDeviceMapModelImpl.ENTITY_CACHE_ENABLED,
			StoreDeviceMapModelImpl.FINDER_CACHE_ENABLED,
			StoreDeviceMapImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStoreName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STORENAME =
		new FinderPath(StoreDeviceMapModelImpl.ENTITY_CACHE_ENABLED,
			StoreDeviceMapModelImpl.FINDER_CACHE_ENABLED,
			StoreDeviceMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStoreName",
			new String[] { String.class.getName() },
			StoreDeviceMapModelImpl.STORENAME_COLUMN_BITMASK |
			StoreDeviceMapModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STORENAME = new FinderPath(StoreDeviceMapModelImpl.ENTITY_CACHE_ENABLED,
			StoreDeviceMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStoreName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the store device maps where storeName = &#63;.
	 *
	 * @param storeName the store name
	 * @return the matching store device maps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StoreDeviceMap> findByStoreName(String storeName)
		throws SystemException {
		return findByStoreName(storeName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the store device maps where storeName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.StoreDeviceMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param storeName the store name
	 * @param start the lower bound of the range of store device maps
	 * @param end the upper bound of the range of store device maps (not inclusive)
	 * @return the range of matching store device maps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StoreDeviceMap> findByStoreName(String storeName, int start,
		int end) throws SystemException {
		return findByStoreName(storeName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the store device maps where storeName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.StoreDeviceMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param storeName the store name
	 * @param start the lower bound of the range of store device maps
	 * @param end the upper bound of the range of store device maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching store device maps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StoreDeviceMap> findByStoreName(String storeName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STORENAME;
			finderArgs = new Object[] { storeName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STORENAME;
			finderArgs = new Object[] { storeName, start, end, orderByComparator };
		}

		List<StoreDeviceMap> list = (List<StoreDeviceMap>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StoreDeviceMap storeDeviceMap : list) {
				if (!Validator.equals(storeName, storeDeviceMap.getStoreName())) {
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

			query.append(_SQL_SELECT_STOREDEVICEMAP_WHERE);

			boolean bindStoreName = false;

			if (storeName == null) {
				query.append(_FINDER_COLUMN_STORENAME_STORENAME_1);
			}
			else if (storeName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STORENAME_STORENAME_3);
			}
			else {
				bindStoreName = true;

				query.append(_FINDER_COLUMN_STORENAME_STORENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StoreDeviceMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStoreName) {
					qPos.add(storeName);
				}

				if (!pagination) {
					list = (List<StoreDeviceMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StoreDeviceMap>(list);
				}
				else {
					list = (List<StoreDeviceMap>)QueryUtil.list(q,
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
	 * Returns the first store device map in the ordered set where storeName = &#63;.
	 *
	 * @param storeName the store name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching store device map
	 * @throws com.cloud.tags.NoSuchStoreDeviceMapException if a matching store device map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StoreDeviceMap findByStoreName_First(String storeName,
		OrderByComparator orderByComparator)
		throws NoSuchStoreDeviceMapException, SystemException {
		StoreDeviceMap storeDeviceMap = fetchByStoreName_First(storeName,
				orderByComparator);

		if (storeDeviceMap != null) {
			return storeDeviceMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("storeName=");
		msg.append(storeName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStoreDeviceMapException(msg.toString());
	}

	/**
	 * Returns the first store device map in the ordered set where storeName = &#63;.
	 *
	 * @param storeName the store name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching store device map, or <code>null</code> if a matching store device map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StoreDeviceMap fetchByStoreName_First(String storeName,
		OrderByComparator orderByComparator) throws SystemException {
		List<StoreDeviceMap> list = findByStoreName(storeName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last store device map in the ordered set where storeName = &#63;.
	 *
	 * @param storeName the store name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching store device map
	 * @throws com.cloud.tags.NoSuchStoreDeviceMapException if a matching store device map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StoreDeviceMap findByStoreName_Last(String storeName,
		OrderByComparator orderByComparator)
		throws NoSuchStoreDeviceMapException, SystemException {
		StoreDeviceMap storeDeviceMap = fetchByStoreName_Last(storeName,
				orderByComparator);

		if (storeDeviceMap != null) {
			return storeDeviceMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("storeName=");
		msg.append(storeName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStoreDeviceMapException(msg.toString());
	}

	/**
	 * Returns the last store device map in the ordered set where storeName = &#63;.
	 *
	 * @param storeName the store name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching store device map, or <code>null</code> if a matching store device map could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StoreDeviceMap fetchByStoreName_Last(String storeName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStoreName(storeName);

		if (count == 0) {
			return null;
		}

		List<StoreDeviceMap> list = findByStoreName(storeName, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the store device maps before and after the current store device map in the ordered set where storeName = &#63;.
	 *
	 * @param uuid the primary key of the current store device map
	 * @param storeName the store name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next store device map
	 * @throws com.cloud.tags.NoSuchStoreDeviceMapException if a store device map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StoreDeviceMap[] findByStoreName_PrevAndNext(long uuid,
		String storeName, OrderByComparator orderByComparator)
		throws NoSuchStoreDeviceMapException, SystemException {
		StoreDeviceMap storeDeviceMap = findByPrimaryKey(uuid);

		Session session = null;

		try {
			session = openSession();

			StoreDeviceMap[] array = new StoreDeviceMapImpl[3];

			array[0] = getByStoreName_PrevAndNext(session, storeDeviceMap,
					storeName, orderByComparator, true);

			array[1] = storeDeviceMap;

			array[2] = getByStoreName_PrevAndNext(session, storeDeviceMap,
					storeName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StoreDeviceMap getByStoreName_PrevAndNext(Session session,
		StoreDeviceMap storeDeviceMap, String storeName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STOREDEVICEMAP_WHERE);

		boolean bindStoreName = false;

		if (storeName == null) {
			query.append(_FINDER_COLUMN_STORENAME_STORENAME_1);
		}
		else if (storeName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STORENAME_STORENAME_3);
		}
		else {
			bindStoreName = true;

			query.append(_FINDER_COLUMN_STORENAME_STORENAME_2);
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
			query.append(StoreDeviceMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStoreName) {
			qPos.add(storeName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(storeDeviceMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StoreDeviceMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the store device maps where storeName = &#63; from the database.
	 *
	 * @param storeName the store name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStoreName(String storeName) throws SystemException {
		for (StoreDeviceMap storeDeviceMap : findByStoreName(storeName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(storeDeviceMap);
		}
	}

	/**
	 * Returns the number of store device maps where storeName = &#63;.
	 *
	 * @param storeName the store name
	 * @return the number of matching store device maps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStoreName(String storeName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STORENAME;

		Object[] finderArgs = new Object[] { storeName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STOREDEVICEMAP_WHERE);

			boolean bindStoreName = false;

			if (storeName == null) {
				query.append(_FINDER_COLUMN_STORENAME_STORENAME_1);
			}
			else if (storeName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STORENAME_STORENAME_3);
			}
			else {
				bindStoreName = true;

				query.append(_FINDER_COLUMN_STORENAME_STORENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStoreName) {
					qPos.add(storeName);
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

	private static final String _FINDER_COLUMN_STORENAME_STORENAME_1 = "storeDeviceMap.storeName IS NULL";
	private static final String _FINDER_COLUMN_STORENAME_STORENAME_2 = "storeDeviceMap.storeName = ?";
	private static final String _FINDER_COLUMN_STORENAME_STORENAME_3 = "(storeDeviceMap.storeName IS NULL OR storeDeviceMap.storeName = '')";

	public StoreDeviceMapPersistenceImpl() {
		setModelClass(StoreDeviceMap.class);
	}

	/**
	 * Caches the store device map in the entity cache if it is enabled.
	 *
	 * @param storeDeviceMap the store device map
	 */
	@Override
	public void cacheResult(StoreDeviceMap storeDeviceMap) {
		EntityCacheUtil.putResult(StoreDeviceMapModelImpl.ENTITY_CACHE_ENABLED,
			StoreDeviceMapImpl.class, storeDeviceMap.getPrimaryKey(),
			storeDeviceMap);

		storeDeviceMap.resetOriginalValues();
	}

	/**
	 * Caches the store device maps in the entity cache if it is enabled.
	 *
	 * @param storeDeviceMaps the store device maps
	 */
	@Override
	public void cacheResult(List<StoreDeviceMap> storeDeviceMaps) {
		for (StoreDeviceMap storeDeviceMap : storeDeviceMaps) {
			if (EntityCacheUtil.getResult(
						StoreDeviceMapModelImpl.ENTITY_CACHE_ENABLED,
						StoreDeviceMapImpl.class, storeDeviceMap.getPrimaryKey()) == null) {
				cacheResult(storeDeviceMap);
			}
			else {
				storeDeviceMap.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all store device maps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StoreDeviceMapImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StoreDeviceMapImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the store device map.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StoreDeviceMap storeDeviceMap) {
		EntityCacheUtil.removeResult(StoreDeviceMapModelImpl.ENTITY_CACHE_ENABLED,
			StoreDeviceMapImpl.class, storeDeviceMap.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StoreDeviceMap> storeDeviceMaps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StoreDeviceMap storeDeviceMap : storeDeviceMaps) {
			EntityCacheUtil.removeResult(StoreDeviceMapModelImpl.ENTITY_CACHE_ENABLED,
				StoreDeviceMapImpl.class, storeDeviceMap.getPrimaryKey());
		}
	}

	/**
	 * Creates a new store device map with the primary key. Does not add the store device map to the database.
	 *
	 * @param uuid the primary key for the new store device map
	 * @return the new store device map
	 */
	@Override
	public StoreDeviceMap create(long uuid) {
		StoreDeviceMap storeDeviceMap = new StoreDeviceMapImpl();

		storeDeviceMap.setNew(true);
		storeDeviceMap.setPrimaryKey(uuid);

		return storeDeviceMap;
	}

	/**
	 * Removes the store device map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param uuid the primary key of the store device map
	 * @return the store device map that was removed
	 * @throws com.cloud.tags.NoSuchStoreDeviceMapException if a store device map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StoreDeviceMap remove(long uuid)
		throws NoSuchStoreDeviceMapException, SystemException {
		return remove((Serializable)uuid);
	}

	/**
	 * Removes the store device map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the store device map
	 * @return the store device map that was removed
	 * @throws com.cloud.tags.NoSuchStoreDeviceMapException if a store device map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StoreDeviceMap remove(Serializable primaryKey)
		throws NoSuchStoreDeviceMapException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StoreDeviceMap storeDeviceMap = (StoreDeviceMap)session.get(StoreDeviceMapImpl.class,
					primaryKey);

			if (storeDeviceMap == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStoreDeviceMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(storeDeviceMap);
		}
		catch (NoSuchStoreDeviceMapException nsee) {
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
	protected StoreDeviceMap removeImpl(StoreDeviceMap storeDeviceMap)
		throws SystemException {
		storeDeviceMap = toUnwrappedModel(storeDeviceMap);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(storeDeviceMap)) {
				storeDeviceMap = (StoreDeviceMap)session.get(StoreDeviceMapImpl.class,
						storeDeviceMap.getPrimaryKeyObj());
			}

			if (storeDeviceMap != null) {
				session.delete(storeDeviceMap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (storeDeviceMap != null) {
			clearCache(storeDeviceMap);
		}

		return storeDeviceMap;
	}

	@Override
	public StoreDeviceMap updateImpl(
		com.cloud.tags.model.StoreDeviceMap storeDeviceMap)
		throws SystemException {
		storeDeviceMap = toUnwrappedModel(storeDeviceMap);

		boolean isNew = storeDeviceMap.isNew();

		StoreDeviceMapModelImpl storeDeviceMapModelImpl = (StoreDeviceMapModelImpl)storeDeviceMap;

		Session session = null;

		try {
			session = openSession();

			if (storeDeviceMap.isNew()) {
				session.save(storeDeviceMap);

				storeDeviceMap.setNew(false);
			}
			else {
				session.merge(storeDeviceMap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StoreDeviceMapModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((storeDeviceMapModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						storeDeviceMapModelImpl.getOriginalDeviceMacAddress()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEVICE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICE,
					args);

				args = new Object[] {
						storeDeviceMapModelImpl.getDeviceMacAddress()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEVICE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICE,
					args);
			}

			if ((storeDeviceMapModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STORENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						storeDeviceMapModelImpl.getOriginalStoreName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STORENAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STORENAME,
					args);

				args = new Object[] { storeDeviceMapModelImpl.getStoreName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STORENAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STORENAME,
					args);
			}
		}

		EntityCacheUtil.putResult(StoreDeviceMapModelImpl.ENTITY_CACHE_ENABLED,
			StoreDeviceMapImpl.class, storeDeviceMap.getPrimaryKey(),
			storeDeviceMap);

		return storeDeviceMap;
	}

	protected StoreDeviceMap toUnwrappedModel(StoreDeviceMap storeDeviceMap) {
		if (storeDeviceMap instanceof StoreDeviceMapImpl) {
			return storeDeviceMap;
		}

		StoreDeviceMapImpl storeDeviceMapImpl = new StoreDeviceMapImpl();

		storeDeviceMapImpl.setNew(storeDeviceMap.isNew());
		storeDeviceMapImpl.setPrimaryKey(storeDeviceMap.getPrimaryKey());

		storeDeviceMapImpl.setUuid(storeDeviceMap.getUuid());
		storeDeviceMapImpl.setStoreName(storeDeviceMap.getStoreName());
		storeDeviceMapImpl.setDeviceMacAddress(storeDeviceMap.getDeviceMacAddress());
		storeDeviceMapImpl.setStoreId(storeDeviceMap.getStoreId());
		storeDeviceMapImpl.setCompanyId(storeDeviceMap.getCompanyId());
		storeDeviceMapImpl.setGroupId(storeDeviceMap.getGroupId());
		storeDeviceMapImpl.setCreateDate(storeDeviceMap.getCreateDate());

		return storeDeviceMapImpl;
	}

	/**
	 * Returns the store device map with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the store device map
	 * @return the store device map
	 * @throws com.cloud.tags.NoSuchStoreDeviceMapException if a store device map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StoreDeviceMap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStoreDeviceMapException, SystemException {
		StoreDeviceMap storeDeviceMap = fetchByPrimaryKey(primaryKey);

		if (storeDeviceMap == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStoreDeviceMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return storeDeviceMap;
	}

	/**
	 * Returns the store device map with the primary key or throws a {@link com.cloud.tags.NoSuchStoreDeviceMapException} if it could not be found.
	 *
	 * @param uuid the primary key of the store device map
	 * @return the store device map
	 * @throws com.cloud.tags.NoSuchStoreDeviceMapException if a store device map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StoreDeviceMap findByPrimaryKey(long uuid)
		throws NoSuchStoreDeviceMapException, SystemException {
		return findByPrimaryKey((Serializable)uuid);
	}

	/**
	 * Returns the store device map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the store device map
	 * @return the store device map, or <code>null</code> if a store device map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StoreDeviceMap fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StoreDeviceMap storeDeviceMap = (StoreDeviceMap)EntityCacheUtil.getResult(StoreDeviceMapModelImpl.ENTITY_CACHE_ENABLED,
				StoreDeviceMapImpl.class, primaryKey);

		if (storeDeviceMap == _nullStoreDeviceMap) {
			return null;
		}

		if (storeDeviceMap == null) {
			Session session = null;

			try {
				session = openSession();

				storeDeviceMap = (StoreDeviceMap)session.get(StoreDeviceMapImpl.class,
						primaryKey);

				if (storeDeviceMap != null) {
					cacheResult(storeDeviceMap);
				}
				else {
					EntityCacheUtil.putResult(StoreDeviceMapModelImpl.ENTITY_CACHE_ENABLED,
						StoreDeviceMapImpl.class, primaryKey,
						_nullStoreDeviceMap);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StoreDeviceMapModelImpl.ENTITY_CACHE_ENABLED,
					StoreDeviceMapImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return storeDeviceMap;
	}

	/**
	 * Returns the store device map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param uuid the primary key of the store device map
	 * @return the store device map, or <code>null</code> if a store device map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StoreDeviceMap fetchByPrimaryKey(long uuid)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)uuid);
	}

	/**
	 * Returns all the store device maps.
	 *
	 * @return the store device maps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StoreDeviceMap> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the store device maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.StoreDeviceMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of store device maps
	 * @param end the upper bound of the range of store device maps (not inclusive)
	 * @return the range of store device maps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StoreDeviceMap> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the store device maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.StoreDeviceMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of store device maps
	 * @param end the upper bound of the range of store device maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of store device maps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StoreDeviceMap> findAll(int start, int end,
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

		List<StoreDeviceMap> list = (List<StoreDeviceMap>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STOREDEVICEMAP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STOREDEVICEMAP;

				if (pagination) {
					sql = sql.concat(StoreDeviceMapModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StoreDeviceMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StoreDeviceMap>(list);
				}
				else {
					list = (List<StoreDeviceMap>)QueryUtil.list(q,
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
	 * Removes all the store device maps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StoreDeviceMap storeDeviceMap : findAll()) {
			remove(storeDeviceMap);
		}
	}

	/**
	 * Returns the number of store device maps.
	 *
	 * @return the number of store device maps
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

				Query q = session.createQuery(_SQL_COUNT_STOREDEVICEMAP);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the store device map persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cloud.tags.model.StoreDeviceMap")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StoreDeviceMap>> listenersList = new ArrayList<ModelListener<StoreDeviceMap>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StoreDeviceMap>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StoreDeviceMapImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STOREDEVICEMAP = "SELECT storeDeviceMap FROM StoreDeviceMap storeDeviceMap";
	private static final String _SQL_SELECT_STOREDEVICEMAP_WHERE = "SELECT storeDeviceMap FROM StoreDeviceMap storeDeviceMap WHERE ";
	private static final String _SQL_COUNT_STOREDEVICEMAP = "SELECT COUNT(storeDeviceMap) FROM StoreDeviceMap storeDeviceMap";
	private static final String _SQL_COUNT_STOREDEVICEMAP_WHERE = "SELECT COUNT(storeDeviceMap) FROM StoreDeviceMap storeDeviceMap WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "storeDeviceMap.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StoreDeviceMap exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StoreDeviceMap exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StoreDeviceMapPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static StoreDeviceMap _nullStoreDeviceMap = new StoreDeviceMapImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StoreDeviceMap> toCacheModel() {
				return _nullStoreDeviceMapCacheModel;
			}
		};

	private static CacheModel<StoreDeviceMap> _nullStoreDeviceMapCacheModel = new CacheModel<StoreDeviceMap>() {
			@Override
			public StoreDeviceMap toEntityModel() {
				return _nullStoreDeviceMap;
			}
		};
}