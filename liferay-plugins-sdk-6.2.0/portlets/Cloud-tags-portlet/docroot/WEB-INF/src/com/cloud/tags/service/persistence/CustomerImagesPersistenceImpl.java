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

import com.cloud.tags.NoSuchCustomerImagesException;
import com.cloud.tags.model.CustomerImages;
import com.cloud.tags.model.impl.CustomerImagesImpl;
import com.cloud.tags.model.impl.CustomerImagesModelImpl;

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
 * The persistence implementation for the customer images service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see CustomerImagesPersistence
 * @see CustomerImagesUtil
 * @generated
 */
public class CustomerImagesPersistenceImpl extends BasePersistenceImpl<CustomerImages>
	implements CustomerImagesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CustomerImagesUtil} to access the customer images persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CustomerImagesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CustomerImagesModelImpl.ENTITY_CACHE_ENABLED,
			CustomerImagesModelImpl.FINDER_CACHE_ENABLED,
			CustomerImagesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CustomerImagesModelImpl.ENTITY_CACHE_ENABLED,
			CustomerImagesModelImpl.FINDER_CACHE_ENABLED,
			CustomerImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CustomerImagesModelImpl.ENTITY_CACHE_ENABLED,
			CustomerImagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DESIGNERSKU =
		new FinderPath(CustomerImagesModelImpl.ENTITY_CACHE_ENABLED,
			CustomerImagesModelImpl.FINDER_CACHE_ENABLED,
			CustomerImagesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBydesignerSKU",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESIGNERSKU =
		new FinderPath(CustomerImagesModelImpl.ENTITY_CACHE_ENABLED,
			CustomerImagesModelImpl.FINDER_CACHE_ENABLED,
			CustomerImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydesignerSKU",
			new String[] { String.class.getName() },
			CustomerImagesModelImpl.DESIGNERSKU_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DESIGNERSKU = new FinderPath(CustomerImagesModelImpl.ENTITY_CACHE_ENABLED,
			CustomerImagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydesignerSKU",
			new String[] { String.class.getName() });

	/**
	 * Returns all the customer imageses where designerSKU = &#63;.
	 *
	 * @param designerSKU the designer s k u
	 * @return the matching customer imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CustomerImages> findBydesignerSKU(String designerSKU)
		throws SystemException {
		return findBydesignerSKU(designerSKU, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the customer imageses where designerSKU = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CustomerImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param designerSKU the designer s k u
	 * @param start the lower bound of the range of customer imageses
	 * @param end the upper bound of the range of customer imageses (not inclusive)
	 * @return the range of matching customer imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CustomerImages> findBydesignerSKU(String designerSKU,
		int start, int end) throws SystemException {
		return findBydesignerSKU(designerSKU, start, end, null);
	}

	/**
	 * Returns an ordered range of all the customer imageses where designerSKU = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CustomerImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param designerSKU the designer s k u
	 * @param start the lower bound of the range of customer imageses
	 * @param end the upper bound of the range of customer imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching customer imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CustomerImages> findBydesignerSKU(String designerSKU,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESIGNERSKU;
			finderArgs = new Object[] { designerSKU };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DESIGNERSKU;
			finderArgs = new Object[] { designerSKU, start, end, orderByComparator };
		}

		List<CustomerImages> list = (List<CustomerImages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CustomerImages customerImages : list) {
				if (!Validator.equals(designerSKU,
							customerImages.getDesignerSKU())) {
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

			query.append(_SQL_SELECT_CUSTOMERIMAGES_WHERE);

			boolean bindDesignerSKU = false;

			if (designerSKU == null) {
				query.append(_FINDER_COLUMN_DESIGNERSKU_DESIGNERSKU_1);
			}
			else if (designerSKU.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DESIGNERSKU_DESIGNERSKU_3);
			}
			else {
				bindDesignerSKU = true;

				query.append(_FINDER_COLUMN_DESIGNERSKU_DESIGNERSKU_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CustomerImagesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDesignerSKU) {
					qPos.add(designerSKU);
				}

				if (!pagination) {
					list = (List<CustomerImages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CustomerImages>(list);
				}
				else {
					list = (List<CustomerImages>)QueryUtil.list(q,
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
	 * Returns the first customer images in the ordered set where designerSKU = &#63;.
	 *
	 * @param designerSKU the designer s k u
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer images
	 * @throws com.cloud.tags.NoSuchCustomerImagesException if a matching customer images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerImages findBydesignerSKU_First(String designerSKU,
		OrderByComparator orderByComparator)
		throws NoSuchCustomerImagesException, SystemException {
		CustomerImages customerImages = fetchBydesignerSKU_First(designerSKU,
				orderByComparator);

		if (customerImages != null) {
			return customerImages;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("designerSKU=");
		msg.append(designerSKU);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCustomerImagesException(msg.toString());
	}

	/**
	 * Returns the first customer images in the ordered set where designerSKU = &#63;.
	 *
	 * @param designerSKU the designer s k u
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer images, or <code>null</code> if a matching customer images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerImages fetchBydesignerSKU_First(String designerSKU,
		OrderByComparator orderByComparator) throws SystemException {
		List<CustomerImages> list = findBydesignerSKU(designerSKU, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last customer images in the ordered set where designerSKU = &#63;.
	 *
	 * @param designerSKU the designer s k u
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer images
	 * @throws com.cloud.tags.NoSuchCustomerImagesException if a matching customer images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerImages findBydesignerSKU_Last(String designerSKU,
		OrderByComparator orderByComparator)
		throws NoSuchCustomerImagesException, SystemException {
		CustomerImages customerImages = fetchBydesignerSKU_Last(designerSKU,
				orderByComparator);

		if (customerImages != null) {
			return customerImages;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("designerSKU=");
		msg.append(designerSKU);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCustomerImagesException(msg.toString());
	}

	/**
	 * Returns the last customer images in the ordered set where designerSKU = &#63;.
	 *
	 * @param designerSKU the designer s k u
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer images, or <code>null</code> if a matching customer images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerImages fetchBydesignerSKU_Last(String designerSKU,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBydesignerSKU(designerSKU);

		if (count == 0) {
			return null;
		}

		List<CustomerImages> list = findBydesignerSKU(designerSKU, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the customer imageses before and after the current customer images in the ordered set where designerSKU = &#63;.
	 *
	 * @param customerImageId the primary key of the current customer images
	 * @param designerSKU the designer s k u
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next customer images
	 * @throws com.cloud.tags.NoSuchCustomerImagesException if a customer images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerImages[] findBydesignerSKU_PrevAndNext(
		long customerImageId, String designerSKU,
		OrderByComparator orderByComparator)
		throws NoSuchCustomerImagesException, SystemException {
		CustomerImages customerImages = findByPrimaryKey(customerImageId);

		Session session = null;

		try {
			session = openSession();

			CustomerImages[] array = new CustomerImagesImpl[3];

			array[0] = getBydesignerSKU_PrevAndNext(session, customerImages,
					designerSKU, orderByComparator, true);

			array[1] = customerImages;

			array[2] = getBydesignerSKU_PrevAndNext(session, customerImages,
					designerSKU, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CustomerImages getBydesignerSKU_PrevAndNext(Session session,
		CustomerImages customerImages, String designerSKU,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CUSTOMERIMAGES_WHERE);

		boolean bindDesignerSKU = false;

		if (designerSKU == null) {
			query.append(_FINDER_COLUMN_DESIGNERSKU_DESIGNERSKU_1);
		}
		else if (designerSKU.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DESIGNERSKU_DESIGNERSKU_3);
		}
		else {
			bindDesignerSKU = true;

			query.append(_FINDER_COLUMN_DESIGNERSKU_DESIGNERSKU_2);
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
			query.append(CustomerImagesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDesignerSKU) {
			qPos.add(designerSKU);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(customerImages);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CustomerImages> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the customer imageses where designerSKU = &#63; from the database.
	 *
	 * @param designerSKU the designer s k u
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBydesignerSKU(String designerSKU)
		throws SystemException {
		for (CustomerImages customerImages : findBydesignerSKU(designerSKU,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(customerImages);
		}
	}

	/**
	 * Returns the number of customer imageses where designerSKU = &#63;.
	 *
	 * @param designerSKU the designer s k u
	 * @return the number of matching customer imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBydesignerSKU(String designerSKU) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DESIGNERSKU;

		Object[] finderArgs = new Object[] { designerSKU };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CUSTOMERIMAGES_WHERE);

			boolean bindDesignerSKU = false;

			if (designerSKU == null) {
				query.append(_FINDER_COLUMN_DESIGNERSKU_DESIGNERSKU_1);
			}
			else if (designerSKU.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DESIGNERSKU_DESIGNERSKU_3);
			}
			else {
				bindDesignerSKU = true;

				query.append(_FINDER_COLUMN_DESIGNERSKU_DESIGNERSKU_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDesignerSKU) {
					qPos.add(designerSKU);
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

	private static final String _FINDER_COLUMN_DESIGNERSKU_DESIGNERSKU_1 = "customerImages.designerSKU IS NULL";
	private static final String _FINDER_COLUMN_DESIGNERSKU_DESIGNERSKU_2 = "customerImages.designerSKU = ?";
	private static final String _FINDER_COLUMN_DESIGNERSKU_DESIGNERSKU_3 = "(customerImages.designerSKU IS NULL OR customerImages.designerSKU = '')";

	public CustomerImagesPersistenceImpl() {
		setModelClass(CustomerImages.class);
	}

	/**
	 * Caches the customer images in the entity cache if it is enabled.
	 *
	 * @param customerImages the customer images
	 */
	@Override
	public void cacheResult(CustomerImages customerImages) {
		EntityCacheUtil.putResult(CustomerImagesModelImpl.ENTITY_CACHE_ENABLED,
			CustomerImagesImpl.class, customerImages.getPrimaryKey(),
			customerImages);

		customerImages.resetOriginalValues();
	}

	/**
	 * Caches the customer imageses in the entity cache if it is enabled.
	 *
	 * @param customerImageses the customer imageses
	 */
	@Override
	public void cacheResult(List<CustomerImages> customerImageses) {
		for (CustomerImages customerImages : customerImageses) {
			if (EntityCacheUtil.getResult(
						CustomerImagesModelImpl.ENTITY_CACHE_ENABLED,
						CustomerImagesImpl.class, customerImages.getPrimaryKey()) == null) {
				cacheResult(customerImages);
			}
			else {
				customerImages.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all customer imageses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CustomerImagesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CustomerImagesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the customer images.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CustomerImages customerImages) {
		EntityCacheUtil.removeResult(CustomerImagesModelImpl.ENTITY_CACHE_ENABLED,
			CustomerImagesImpl.class, customerImages.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CustomerImages> customerImageses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CustomerImages customerImages : customerImageses) {
			EntityCacheUtil.removeResult(CustomerImagesModelImpl.ENTITY_CACHE_ENABLED,
				CustomerImagesImpl.class, customerImages.getPrimaryKey());
		}
	}

	/**
	 * Creates a new customer images with the primary key. Does not add the customer images to the database.
	 *
	 * @param customerImageId the primary key for the new customer images
	 * @return the new customer images
	 */
	@Override
	public CustomerImages create(long customerImageId) {
		CustomerImages customerImages = new CustomerImagesImpl();

		customerImages.setNew(true);
		customerImages.setPrimaryKey(customerImageId);

		return customerImages;
	}

	/**
	 * Removes the customer images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customerImageId the primary key of the customer images
	 * @return the customer images that was removed
	 * @throws com.cloud.tags.NoSuchCustomerImagesException if a customer images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerImages remove(long customerImageId)
		throws NoSuchCustomerImagesException, SystemException {
		return remove((Serializable)customerImageId);
	}

	/**
	 * Removes the customer images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the customer images
	 * @return the customer images that was removed
	 * @throws com.cloud.tags.NoSuchCustomerImagesException if a customer images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerImages remove(Serializable primaryKey)
		throws NoSuchCustomerImagesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CustomerImages customerImages = (CustomerImages)session.get(CustomerImagesImpl.class,
					primaryKey);

			if (customerImages == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustomerImagesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(customerImages);
		}
		catch (NoSuchCustomerImagesException nsee) {
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
	protected CustomerImages removeImpl(CustomerImages customerImages)
		throws SystemException {
		customerImages = toUnwrappedModel(customerImages);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(customerImages)) {
				customerImages = (CustomerImages)session.get(CustomerImagesImpl.class,
						customerImages.getPrimaryKeyObj());
			}

			if (customerImages != null) {
				session.delete(customerImages);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (customerImages != null) {
			clearCache(customerImages);
		}

		return customerImages;
	}

	@Override
	public CustomerImages updateImpl(
		com.cloud.tags.model.CustomerImages customerImages)
		throws SystemException {
		customerImages = toUnwrappedModel(customerImages);

		boolean isNew = customerImages.isNew();

		CustomerImagesModelImpl customerImagesModelImpl = (CustomerImagesModelImpl)customerImages;

		Session session = null;

		try {
			session = openSession();

			if (customerImages.isNew()) {
				session.save(customerImages);

				customerImages.setNew(false);
			}
			else {
				session.merge(customerImages);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CustomerImagesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((customerImagesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESIGNERSKU.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						customerImagesModelImpl.getOriginalDesignerSKU()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DESIGNERSKU,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESIGNERSKU,
					args);

				args = new Object[] { customerImagesModelImpl.getDesignerSKU() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DESIGNERSKU,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESIGNERSKU,
					args);
			}
		}

		EntityCacheUtil.putResult(CustomerImagesModelImpl.ENTITY_CACHE_ENABLED,
			CustomerImagesImpl.class, customerImages.getPrimaryKey(),
			customerImages);

		return customerImages;
	}

	protected CustomerImages toUnwrappedModel(CustomerImages customerImages) {
		if (customerImages instanceof CustomerImagesImpl) {
			return customerImages;
		}

		CustomerImagesImpl customerImagesImpl = new CustomerImagesImpl();

		customerImagesImpl.setNew(customerImages.isNew());
		customerImagesImpl.setPrimaryKey(customerImages.getPrimaryKey());

		customerImagesImpl.setCustomerImageId(customerImages.getCustomerImageId());
		customerImagesImpl.setDesignerSKU(customerImages.getDesignerSKU());
		customerImagesImpl.setDesignerCusImage(customerImages.getDesignerCusImage());
		customerImagesImpl.setCustomerImage(customerImages.getCustomerImage());
		customerImagesImpl.setCustomerName(customerImages.getCustomerName());
		customerImagesImpl.setCustomerAddress(customerImages.getCustomerAddress());

		return customerImagesImpl;
	}

	/**
	 * Returns the customer images with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the customer images
	 * @return the customer images
	 * @throws com.cloud.tags.NoSuchCustomerImagesException if a customer images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerImages findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustomerImagesException, SystemException {
		CustomerImages customerImages = fetchByPrimaryKey(primaryKey);

		if (customerImages == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustomerImagesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return customerImages;
	}

	/**
	 * Returns the customer images with the primary key or throws a {@link com.cloud.tags.NoSuchCustomerImagesException} if it could not be found.
	 *
	 * @param customerImageId the primary key of the customer images
	 * @return the customer images
	 * @throws com.cloud.tags.NoSuchCustomerImagesException if a customer images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerImages findByPrimaryKey(long customerImageId)
		throws NoSuchCustomerImagesException, SystemException {
		return findByPrimaryKey((Serializable)customerImageId);
	}

	/**
	 * Returns the customer images with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the customer images
	 * @return the customer images, or <code>null</code> if a customer images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerImages fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CustomerImages customerImages = (CustomerImages)EntityCacheUtil.getResult(CustomerImagesModelImpl.ENTITY_CACHE_ENABLED,
				CustomerImagesImpl.class, primaryKey);

		if (customerImages == _nullCustomerImages) {
			return null;
		}

		if (customerImages == null) {
			Session session = null;

			try {
				session = openSession();

				customerImages = (CustomerImages)session.get(CustomerImagesImpl.class,
						primaryKey);

				if (customerImages != null) {
					cacheResult(customerImages);
				}
				else {
					EntityCacheUtil.putResult(CustomerImagesModelImpl.ENTITY_CACHE_ENABLED,
						CustomerImagesImpl.class, primaryKey,
						_nullCustomerImages);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CustomerImagesModelImpl.ENTITY_CACHE_ENABLED,
					CustomerImagesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return customerImages;
	}

	/**
	 * Returns the customer images with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param customerImageId the primary key of the customer images
	 * @return the customer images, or <code>null</code> if a customer images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CustomerImages fetchByPrimaryKey(long customerImageId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)customerImageId);
	}

	/**
	 * Returns all the customer imageses.
	 *
	 * @return the customer imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CustomerImages> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the customer imageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CustomerImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer imageses
	 * @param end the upper bound of the range of customer imageses (not inclusive)
	 * @return the range of customer imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CustomerImages> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the customer imageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.CustomerImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer imageses
	 * @param end the upper bound of the range of customer imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of customer imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CustomerImages> findAll(int start, int end,
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

		List<CustomerImages> list = (List<CustomerImages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CUSTOMERIMAGES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOMERIMAGES;

				if (pagination) {
					sql = sql.concat(CustomerImagesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CustomerImages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CustomerImages>(list);
				}
				else {
					list = (List<CustomerImages>)QueryUtil.list(q,
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
	 * Removes all the customer imageses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CustomerImages customerImages : findAll()) {
			remove(customerImages);
		}
	}

	/**
	 * Returns the number of customer imageses.
	 *
	 * @return the number of customer imageses
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

				Query q = session.createQuery(_SQL_COUNT_CUSTOMERIMAGES);

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
	 * Initializes the customer images persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cloud.tags.model.CustomerImages")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CustomerImages>> listenersList = new ArrayList<ModelListener<CustomerImages>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CustomerImages>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CustomerImagesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CUSTOMERIMAGES = "SELECT customerImages FROM CustomerImages customerImages";
	private static final String _SQL_SELECT_CUSTOMERIMAGES_WHERE = "SELECT customerImages FROM CustomerImages customerImages WHERE ";
	private static final String _SQL_COUNT_CUSTOMERIMAGES = "SELECT COUNT(customerImages) FROM CustomerImages customerImages";
	private static final String _SQL_COUNT_CUSTOMERIMAGES_WHERE = "SELECT COUNT(customerImages) FROM CustomerImages customerImages WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "customerImages.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CustomerImages exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CustomerImages exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CustomerImagesPersistenceImpl.class);
	private static CustomerImages _nullCustomerImages = new CustomerImagesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CustomerImages> toCacheModel() {
				return _nullCustomerImagesCacheModel;
			}
		};

	private static CacheModel<CustomerImages> _nullCustomerImagesCacheModel = new CacheModel<CustomerImages>() {
			@Override
			public CustomerImages toEntityModel() {
				return _nullCustomerImages;
			}
		};
}