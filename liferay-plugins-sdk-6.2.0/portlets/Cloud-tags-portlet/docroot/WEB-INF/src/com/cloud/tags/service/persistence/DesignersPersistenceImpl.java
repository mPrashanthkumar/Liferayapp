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

import com.cloud.tags.NoSuchDesignersException;
import com.cloud.tags.model.Designers;
import com.cloud.tags.model.impl.DesignersImpl;
import com.cloud.tags.model.impl.DesignersModelImpl;

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
 * The persistence implementation for the designers service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see DesignersPersistence
 * @see DesignersUtil
 * @generated
 */
public class DesignersPersistenceImpl extends BasePersistenceImpl<Designers>
	implements DesignersPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DesignersUtil} to access the designers persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DesignersImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DesignersModelImpl.ENTITY_CACHE_ENABLED,
			DesignersModelImpl.FINDER_CACHE_ENABLED, DesignersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DesignersModelImpl.ENTITY_CACHE_ENABLED,
			DesignersModelImpl.FINDER_CACHE_ENABLED, DesignersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DesignersModelImpl.ENTITY_CACHE_ENABLED,
			DesignersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCTCODE =
		new FinderPath(DesignersModelImpl.ENTITY_CACHE_ENABLED,
			DesignersModelImpl.FINDER_CACHE_ENABLED, DesignersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByproductCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTCODE =
		new FinderPath(DesignersModelImpl.ENTITY_CACHE_ENABLED,
			DesignersModelImpl.FINDER_CACHE_ENABLED, DesignersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByproductCode",
			new String[] { String.class.getName() },
			DesignersModelImpl.PRODUCTCODE_COLUMN_BITMASK |
			DesignersModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCTCODE = new FinderPath(DesignersModelImpl.ENTITY_CACHE_ENABLED,
			DesignersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByproductCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the designerses where productcode = &#63;.
	 *
	 * @param productcode the productcode
	 * @return the matching designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Designers> findByproductCode(String productcode)
		throws SystemException {
		return findByproductCode(productcode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designerses where productcode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param productcode the productcode
	 * @param start the lower bound of the range of designerses
	 * @param end the upper bound of the range of designerses (not inclusive)
	 * @return the range of matching designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Designers> findByproductCode(String productcode, int start,
		int end) throws SystemException {
		return findByproductCode(productcode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the designerses where productcode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param productcode the productcode
	 * @param start the lower bound of the range of designerses
	 * @param end the upper bound of the range of designerses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Designers> findByproductCode(String productcode, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTCODE;
			finderArgs = new Object[] { productcode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCTCODE;
			finderArgs = new Object[] { productcode, start, end, orderByComparator };
		}

		List<Designers> list = (List<Designers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Designers designers : list) {
				if (!Validator.equals(productcode, designers.getProductcode())) {
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

			query.append(_SQL_SELECT_DESIGNERS_WHERE);

			boolean bindProductcode = false;

			if (productcode == null) {
				query.append(_FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_1);
			}
			else if (productcode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_3);
			}
			else {
				bindProductcode = true;

				query.append(_FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DesignersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindProductcode) {
					qPos.add(productcode);
				}

				if (!pagination) {
					list = (List<Designers>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Designers>(list);
				}
				else {
					list = (List<Designers>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first designers in the ordered set where productcode = &#63;.
	 *
	 * @param productcode the productcode
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designers
	 * @throws com.cloud.tags.NoSuchDesignersException if a matching designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Designers findByproductCode_First(String productcode,
		OrderByComparator orderByComparator)
		throws NoSuchDesignersException, SystemException {
		Designers designers = fetchByproductCode_First(productcode,
				orderByComparator);

		if (designers != null) {
			return designers;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("productcode=");
		msg.append(productcode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDesignersException(msg.toString());
	}

	/**
	 * Returns the first designers in the ordered set where productcode = &#63;.
	 *
	 * @param productcode the productcode
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designers, or <code>null</code> if a matching designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Designers fetchByproductCode_First(String productcode,
		OrderByComparator orderByComparator) throws SystemException {
		List<Designers> list = findByproductCode(productcode, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last designers in the ordered set where productcode = &#63;.
	 *
	 * @param productcode the productcode
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designers
	 * @throws com.cloud.tags.NoSuchDesignersException if a matching designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Designers findByproductCode_Last(String productcode,
		OrderByComparator orderByComparator)
		throws NoSuchDesignersException, SystemException {
		Designers designers = fetchByproductCode_Last(productcode,
				orderByComparator);

		if (designers != null) {
			return designers;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("productcode=");
		msg.append(productcode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDesignersException(msg.toString());
	}

	/**
	 * Returns the last designers in the ordered set where productcode = &#63;.
	 *
	 * @param productcode the productcode
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designers, or <code>null</code> if a matching designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Designers fetchByproductCode_Last(String productcode,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByproductCode(productcode);

		if (count == 0) {
			return null;
		}

		List<Designers> list = findByproductCode(productcode, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the designerses before and after the current designers in the ordered set where productcode = &#63;.
	 *
	 * @param designId the primary key of the current designers
	 * @param productcode the productcode
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designers
	 * @throws com.cloud.tags.NoSuchDesignersException if a designers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Designers[] findByproductCode_PrevAndNext(long designId,
		String productcode, OrderByComparator orderByComparator)
		throws NoSuchDesignersException, SystemException {
		Designers designers = findByPrimaryKey(designId);

		Session session = null;

		try {
			session = openSession();

			Designers[] array = new DesignersImpl[3];

			array[0] = getByproductCode_PrevAndNext(session, designers,
					productcode, orderByComparator, true);

			array[1] = designers;

			array[2] = getByproductCode_PrevAndNext(session, designers,
					productcode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Designers getByproductCode_PrevAndNext(Session session,
		Designers designers, String productcode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DESIGNERS_WHERE);

		boolean bindProductcode = false;

		if (productcode == null) {
			query.append(_FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_1);
		}
		else if (productcode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_3);
		}
		else {
			bindProductcode = true;

			query.append(_FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_2);
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
			query.append(DesignersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindProductcode) {
			qPos.add(productcode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(designers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Designers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the designerses where productcode = &#63; from the database.
	 *
	 * @param productcode the productcode
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByproductCode(String productcode)
		throws SystemException {
		for (Designers designers : findByproductCode(productcode,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(designers);
		}
	}

	/**
	 * Returns the number of designerses where productcode = &#63;.
	 *
	 * @param productcode the productcode
	 * @return the number of matching designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByproductCode(String productcode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRODUCTCODE;

		Object[] finderArgs = new Object[] { productcode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DESIGNERS_WHERE);

			boolean bindProductcode = false;

			if (productcode == null) {
				query.append(_FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_1);
			}
			else if (productcode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_3);
			}
			else {
				bindProductcode = true;

				query.append(_FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindProductcode) {
					qPos.add(productcode);
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

	private static final String _FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_1 = "designers.productcode IS NULL";
	private static final String _FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_2 = "designers.productcode = ?";
	private static final String _FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_3 = "(designers.productcode IS NULL OR designers.productcode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYCOMPANYID =
		new FinderPath(DesignersModelImpl.ENTITY_CACHE_ENABLED,
			DesignersModelImpl.FINDER_CACHE_ENABLED, DesignersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybyCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCOMPANYID =
		new FinderPath(DesignersModelImpl.ENTITY_CACHE_ENABLED,
			DesignersModelImpl.FINDER_CACHE_ENABLED, DesignersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybyCompanyId",
			new String[] { Long.class.getName() },
			DesignersModelImpl.COMPANYID_COLUMN_BITMASK |
			DesignersModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYCOMPANYID = new FinderPath(DesignersModelImpl.ENTITY_CACHE_ENABLED,
			DesignersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the designerses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Designers> findBybyCompanyId(long companyId)
		throws SystemException {
		return findBybyCompanyId(companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designerses where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of designerses
	 * @param end the upper bound of the range of designerses (not inclusive)
	 * @return the range of matching designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Designers> findBybyCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findBybyCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the designerses where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of designerses
	 * @param end the upper bound of the range of designerses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Designers> findBybyCompanyId(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCOMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYCOMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<Designers> list = (List<Designers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Designers designers : list) {
				if ((companyId != designers.getCompanyId())) {
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

			query.append(_SQL_SELECT_DESIGNERS_WHERE);

			query.append(_FINDER_COLUMN_BYCOMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DesignersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Designers>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Designers>(list);
				}
				else {
					list = (List<Designers>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first designers in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designers
	 * @throws com.cloud.tags.NoSuchDesignersException if a matching designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Designers findBybyCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchDesignersException, SystemException {
		Designers designers = fetchBybyCompanyId_First(companyId,
				orderByComparator);

		if (designers != null) {
			return designers;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDesignersException(msg.toString());
	}

	/**
	 * Returns the first designers in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designers, or <code>null</code> if a matching designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Designers fetchBybyCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Designers> list = findBybyCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last designers in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designers
	 * @throws com.cloud.tags.NoSuchDesignersException if a matching designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Designers findBybyCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchDesignersException, SystemException {
		Designers designers = fetchBybyCompanyId_Last(companyId,
				orderByComparator);

		if (designers != null) {
			return designers;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDesignersException(msg.toString());
	}

	/**
	 * Returns the last designers in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designers, or <code>null</code> if a matching designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Designers fetchBybyCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybyCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<Designers> list = findBybyCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the designerses before and after the current designers in the ordered set where companyId = &#63;.
	 *
	 * @param designId the primary key of the current designers
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designers
	 * @throws com.cloud.tags.NoSuchDesignersException if a designers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Designers[] findBybyCompanyId_PrevAndNext(long designId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchDesignersException, SystemException {
		Designers designers = findByPrimaryKey(designId);

		Session session = null;

		try {
			session = openSession();

			Designers[] array = new DesignersImpl[3];

			array[0] = getBybyCompanyId_PrevAndNext(session, designers,
					companyId, orderByComparator, true);

			array[1] = designers;

			array[2] = getBybyCompanyId_PrevAndNext(session, designers,
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

	protected Designers getBybyCompanyId_PrevAndNext(Session session,
		Designers designers, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DESIGNERS_WHERE);

		query.append(_FINDER_COLUMN_BYCOMPANYID_COMPANYID_2);

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
			query.append(DesignersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(designers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Designers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the designerses where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybyCompanyId(long companyId) throws SystemException {
		for (Designers designers : findBybyCompanyId(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(designers);
		}
	}

	/**
	 * Returns the number of designerses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyCompanyId(long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYCOMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DESIGNERS_WHERE);

			query.append(_FINDER_COLUMN_BYCOMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_BYCOMPANYID_COMPANYID_2 = "designers.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_BYCOMPANYIDBARCODE = new FinderPath(DesignersModelImpl.ENTITY_CACHE_ENABLED,
			DesignersModelImpl.FINDER_CACHE_ENABLED, DesignersImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBybyCompanyIdBarcode",
			new String[] { Long.class.getName(), String.class.getName() },
			DesignersModelImpl.COMPANYID_COLUMN_BITMASK |
			DesignersModelImpl.BARCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYCOMPANYIDBARCODE = new FinderPath(DesignersModelImpl.ENTITY_CACHE_ENABLED,
			DesignersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBybyCompanyIdBarcode",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the designers where companyId = &#63; and barcode = &#63; or throws a {@link com.cloud.tags.NoSuchDesignersException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param barcode the barcode
	 * @return the matching designers
	 * @throws com.cloud.tags.NoSuchDesignersException if a matching designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Designers findBybyCompanyIdBarcode(long companyId, String barcode)
		throws NoSuchDesignersException, SystemException {
		Designers designers = fetchBybyCompanyIdBarcode(companyId, barcode);

		if (designers == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", barcode=");
			msg.append(barcode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDesignersException(msg.toString());
		}

		return designers;
	}

	/**
	 * Returns the designers where companyId = &#63; and barcode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param barcode the barcode
	 * @return the matching designers, or <code>null</code> if a matching designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Designers fetchBybyCompanyIdBarcode(long companyId, String barcode)
		throws SystemException {
		return fetchBybyCompanyIdBarcode(companyId, barcode, true);
	}

	/**
	 * Returns the designers where companyId = &#63; and barcode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param barcode the barcode
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching designers, or <code>null</code> if a matching designers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Designers fetchBybyCompanyIdBarcode(long companyId, String barcode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, barcode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BYCOMPANYIDBARCODE,
					finderArgs, this);
		}

		if (result instanceof Designers) {
			Designers designers = (Designers)result;

			if ((companyId != designers.getCompanyId()) ||
					!Validator.equals(barcode, designers.getBarcode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DESIGNERS_WHERE);

			query.append(_FINDER_COLUMN_BYCOMPANYIDBARCODE_COMPANYID_2);

			boolean bindBarcode = false;

			if (barcode == null) {
				query.append(_FINDER_COLUMN_BYCOMPANYIDBARCODE_BARCODE_1);
			}
			else if (barcode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYCOMPANYIDBARCODE_BARCODE_3);
			}
			else {
				bindBarcode = true;

				query.append(_FINDER_COLUMN_BYCOMPANYIDBARCODE_BARCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindBarcode) {
					qPos.add(barcode);
				}

				List<Designers> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYCOMPANYIDBARCODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DesignersPersistenceImpl.fetchBybyCompanyIdBarcode(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Designers designers = list.get(0);

					result = designers;

					cacheResult(designers);

					if ((designers.getCompanyId() != companyId) ||
							(designers.getBarcode() == null) ||
							!designers.getBarcode().equals(barcode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYCOMPANYIDBARCODE,
							finderArgs, designers);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BYCOMPANYIDBARCODE,
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
			return (Designers)result;
		}
	}

	/**
	 * Removes the designers where companyId = &#63; and barcode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param barcode the barcode
	 * @return the designers that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Designers removeBybyCompanyIdBarcode(long companyId, String barcode)
		throws NoSuchDesignersException, SystemException {
		Designers designers = findBybyCompanyIdBarcode(companyId, barcode);

		return remove(designers);
	}

	/**
	 * Returns the number of designerses where companyId = &#63; and barcode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param barcode the barcode
	 * @return the number of matching designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyCompanyIdBarcode(long companyId, String barcode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYCOMPANYIDBARCODE;

		Object[] finderArgs = new Object[] { companyId, barcode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DESIGNERS_WHERE);

			query.append(_FINDER_COLUMN_BYCOMPANYIDBARCODE_COMPANYID_2);

			boolean bindBarcode = false;

			if (barcode == null) {
				query.append(_FINDER_COLUMN_BYCOMPANYIDBARCODE_BARCODE_1);
			}
			else if (barcode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYCOMPANYIDBARCODE_BARCODE_3);
			}
			else {
				bindBarcode = true;

				query.append(_FINDER_COLUMN_BYCOMPANYIDBARCODE_BARCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindBarcode) {
					qPos.add(barcode);
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

	private static final String _FINDER_COLUMN_BYCOMPANYIDBARCODE_COMPANYID_2 = "designers.companyId = ? AND ";
	private static final String _FINDER_COLUMN_BYCOMPANYIDBARCODE_BARCODE_1 = "designers.barcode IS NULL";
	private static final String _FINDER_COLUMN_BYCOMPANYIDBARCODE_BARCODE_2 = "designers.barcode = ?";
	private static final String _FINDER_COLUMN_BYCOMPANYIDBARCODE_BARCODE_3 = "(designers.barcode IS NULL OR designers.barcode = '')";

	public DesignersPersistenceImpl() {
		setModelClass(Designers.class);
	}

	/**
	 * Caches the designers in the entity cache if it is enabled.
	 *
	 * @param designers the designers
	 */
	@Override
	public void cacheResult(Designers designers) {
		EntityCacheUtil.putResult(DesignersModelImpl.ENTITY_CACHE_ENABLED,
			DesignersImpl.class, designers.getPrimaryKey(), designers);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYCOMPANYIDBARCODE,
			new Object[] { designers.getCompanyId(), designers.getBarcode() },
			designers);

		designers.resetOriginalValues();
	}

	/**
	 * Caches the designerses in the entity cache if it is enabled.
	 *
	 * @param designerses the designerses
	 */
	@Override
	public void cacheResult(List<Designers> designerses) {
		for (Designers designers : designerses) {
			if (EntityCacheUtil.getResult(
						DesignersModelImpl.ENTITY_CACHE_ENABLED,
						DesignersImpl.class, designers.getPrimaryKey()) == null) {
				cacheResult(designers);
			}
			else {
				designers.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all designerses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DesignersImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DesignersImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the designers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Designers designers) {
		EntityCacheUtil.removeResult(DesignersModelImpl.ENTITY_CACHE_ENABLED,
			DesignersImpl.class, designers.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(designers);
	}

	@Override
	public void clearCache(List<Designers> designerses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Designers designers : designerses) {
			EntityCacheUtil.removeResult(DesignersModelImpl.ENTITY_CACHE_ENABLED,
				DesignersImpl.class, designers.getPrimaryKey());

			clearUniqueFindersCache(designers);
		}
	}

	protected void cacheUniqueFindersCache(Designers designers) {
		if (designers.isNew()) {
			Object[] args = new Object[] {
					designers.getCompanyId(), designers.getBarcode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYCOMPANYIDBARCODE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYCOMPANYIDBARCODE,
				args, designers);
		}
		else {
			DesignersModelImpl designersModelImpl = (DesignersModelImpl)designers;

			if ((designersModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BYCOMPANYIDBARCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						designers.getCompanyId(), designers.getBarcode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYCOMPANYIDBARCODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYCOMPANYIDBARCODE,
					args, designers);
			}
		}
	}

	protected void clearUniqueFindersCache(Designers designers) {
		DesignersModelImpl designersModelImpl = (DesignersModelImpl)designers;

		Object[] args = new Object[] {
				designers.getCompanyId(), designers.getBarcode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYCOMPANYIDBARCODE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BYCOMPANYIDBARCODE,
			args);

		if ((designersModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BYCOMPANYIDBARCODE.getColumnBitmask()) != 0) {
			args = new Object[] {
					designersModelImpl.getOriginalCompanyId(),
					designersModelImpl.getOriginalBarcode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYCOMPANYIDBARCODE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BYCOMPANYIDBARCODE,
				args);
		}
	}

	/**
	 * Creates a new designers with the primary key. Does not add the designers to the database.
	 *
	 * @param designId the primary key for the new designers
	 * @return the new designers
	 */
	@Override
	public Designers create(long designId) {
		Designers designers = new DesignersImpl();

		designers.setNew(true);
		designers.setPrimaryKey(designId);

		return designers;
	}

	/**
	 * Removes the designers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designId the primary key of the designers
	 * @return the designers that was removed
	 * @throws com.cloud.tags.NoSuchDesignersException if a designers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Designers remove(long designId)
		throws NoSuchDesignersException, SystemException {
		return remove((Serializable)designId);
	}

	/**
	 * Removes the designers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the designers
	 * @return the designers that was removed
	 * @throws com.cloud.tags.NoSuchDesignersException if a designers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Designers remove(Serializable primaryKey)
		throws NoSuchDesignersException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Designers designers = (Designers)session.get(DesignersImpl.class,
					primaryKey);

			if (designers == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDesignersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(designers);
		}
		catch (NoSuchDesignersException nsee) {
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
	protected Designers removeImpl(Designers designers)
		throws SystemException {
		designers = toUnwrappedModel(designers);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(designers)) {
				designers = (Designers)session.get(DesignersImpl.class,
						designers.getPrimaryKeyObj());
			}

			if (designers != null) {
				session.delete(designers);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (designers != null) {
			clearCache(designers);
		}

		return designers;
	}

	@Override
	public Designers updateImpl(com.cloud.tags.model.Designers designers)
		throws SystemException {
		designers = toUnwrappedModel(designers);

		boolean isNew = designers.isNew();

		DesignersModelImpl designersModelImpl = (DesignersModelImpl)designers;

		Session session = null;

		try {
			session = openSession();

			if (designers.isNew()) {
				session.save(designers);

				designers.setNew(false);
			}
			else {
				session.merge(designers);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DesignersModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((designersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						designersModelImpl.getOriginalProductcode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCTCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTCODE,
					args);

				args = new Object[] { designersModelImpl.getProductcode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCTCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTCODE,
					args);
			}

			if ((designersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCOMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						designersModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYCOMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCOMPANYID,
					args);

				args = new Object[] { designersModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYCOMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYCOMPANYID,
					args);
			}
		}

		EntityCacheUtil.putResult(DesignersModelImpl.ENTITY_CACHE_ENABLED,
			DesignersImpl.class, designers.getPrimaryKey(), designers);

		clearUniqueFindersCache(designers);
		cacheUniqueFindersCache(designers);

		return designers;
	}

	protected Designers toUnwrappedModel(Designers designers) {
		if (designers instanceof DesignersImpl) {
			return designers;
		}

		DesignersImpl designersImpl = new DesignersImpl();

		designersImpl.setNew(designers.isNew());
		designersImpl.setPrimaryKey(designers.getPrimaryKey());

		designersImpl.setDesignId(designers.getDesignId());
		designersImpl.setUserId(designers.getUserId());
		designersImpl.setCompanyId(designers.getCompanyId());
		designersImpl.setGroupId(designers.getGroupId());
		designersImpl.setCreateDate(designers.getCreateDate());
		designersImpl.setModifiedDate(designers.getModifiedDate());
		designersImpl.setName(designers.getName());
		designersImpl.setProductTitle(designers.getProductTitle());
		designersImpl.setDescription(designers.getDescription());
		designersImpl.setShortDescription(designers.getShortDescription());
		designersImpl.setPrice(designers.getPrice());
		designersImpl.setPublic_url(designers.getPublic_url());
		designersImpl.setShort_url(designers.getShort_url());
		designersImpl.setSlug(designers.getSlug());
		designersImpl.setSizes(designers.getSizes());
		designersImpl.setColors(designers.getColors());
		designersImpl.setBrand(designers.getBrand());
		designersImpl.setSaleprice(designers.getSaleprice());
		designersImpl.setRetailprice(designers.getRetailprice());
		designersImpl.setInstock(designers.getInstock());
		designersImpl.setParentid(designers.getParentid());
		designersImpl.setCategory(designers.getCategory());
		designersImpl.setProductcode(designers.getProductcode());
		designersImpl.setBarcode(designers.getBarcode());
		designersImpl.setMatchWith(designers.getMatchWith());
		designersImpl.setTimerDate(designers.getTimerDate());
		designersImpl.setTabcurrent(designers.isTabcurrent());
		designersImpl.setLiked(designers.getLiked());
		designersImpl.setCtapp_shorturl(designers.isCtapp_shorturl());
		designersImpl.setCtapp_shorturl_success(designers.isCtapp_shorturl_success());
		designersImpl.setSayduck(designers.isSayduck());
		designersImpl.setLeft_description(designers.getLeft_description());
		designersImpl.setRight_description(designers.getRight_description());

		return designersImpl;
	}

	/**
	 * Returns the designers with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the designers
	 * @return the designers
	 * @throws com.cloud.tags.NoSuchDesignersException if a designers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Designers findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDesignersException, SystemException {
		Designers designers = fetchByPrimaryKey(primaryKey);

		if (designers == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDesignersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return designers;
	}

	/**
	 * Returns the designers with the primary key or throws a {@link com.cloud.tags.NoSuchDesignersException} if it could not be found.
	 *
	 * @param designId the primary key of the designers
	 * @return the designers
	 * @throws com.cloud.tags.NoSuchDesignersException if a designers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Designers findByPrimaryKey(long designId)
		throws NoSuchDesignersException, SystemException {
		return findByPrimaryKey((Serializable)designId);
	}

	/**
	 * Returns the designers with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the designers
	 * @return the designers, or <code>null</code> if a designers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Designers fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Designers designers = (Designers)EntityCacheUtil.getResult(DesignersModelImpl.ENTITY_CACHE_ENABLED,
				DesignersImpl.class, primaryKey);

		if (designers == _nullDesigners) {
			return null;
		}

		if (designers == null) {
			Session session = null;

			try {
				session = openSession();

				designers = (Designers)session.get(DesignersImpl.class,
						primaryKey);

				if (designers != null) {
					cacheResult(designers);
				}
				else {
					EntityCacheUtil.putResult(DesignersModelImpl.ENTITY_CACHE_ENABLED,
						DesignersImpl.class, primaryKey, _nullDesigners);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DesignersModelImpl.ENTITY_CACHE_ENABLED,
					DesignersImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return designers;
	}

	/**
	 * Returns the designers with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designId the primary key of the designers
	 * @return the designers, or <code>null</code> if a designers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Designers fetchByPrimaryKey(long designId) throws SystemException {
		return fetchByPrimaryKey((Serializable)designId);
	}

	/**
	 * Returns all the designerses.
	 *
	 * @return the designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Designers> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designerses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of designerses
	 * @param end the upper bound of the range of designerses (not inclusive)
	 * @return the range of designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Designers> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the designerses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of designerses
	 * @param end the upper bound of the range of designerses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designerses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Designers> findAll(int start, int end,
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

		List<Designers> list = (List<Designers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DESIGNERS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DESIGNERS;

				if (pagination) {
					sql = sql.concat(DesignersModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Designers>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Designers>(list);
				}
				else {
					list = (List<Designers>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the designerses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Designers designers : findAll()) {
			remove(designers);
		}
	}

	/**
	 * Returns the number of designerses.
	 *
	 * @return the number of designerses
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

				Query q = session.createQuery(_SQL_COUNT_DESIGNERS);

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
	 * Initializes the designers persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cloud.tags.model.Designers")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Designers>> listenersList = new ArrayList<ModelListener<Designers>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Designers>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DesignersImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DESIGNERS = "SELECT designers FROM Designers designers";
	private static final String _SQL_SELECT_DESIGNERS_WHERE = "SELECT designers FROM Designers designers WHERE ";
	private static final String _SQL_COUNT_DESIGNERS = "SELECT COUNT(designers) FROM Designers designers";
	private static final String _SQL_COUNT_DESIGNERS_WHERE = "SELECT COUNT(designers) FROM Designers designers WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "designers.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Designers exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Designers exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DesignersPersistenceImpl.class);
	private static Designers _nullDesigners = new DesignersImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Designers> toCacheModel() {
				return _nullDesignersCacheModel;
			}
		};

	private static CacheModel<Designers> _nullDesignersCacheModel = new CacheModel<Designers>() {
			@Override
			public Designers toEntityModel() {
				return _nullDesigners;
			}
		};
}