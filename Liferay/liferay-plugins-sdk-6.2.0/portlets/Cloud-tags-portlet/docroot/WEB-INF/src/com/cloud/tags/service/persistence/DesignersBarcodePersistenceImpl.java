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

import com.cloud.tags.NoSuchDesignersBarcodeException;
import com.cloud.tags.model.DesignersBarcode;
import com.cloud.tags.model.impl.DesignersBarcodeImpl;
import com.cloud.tags.model.impl.DesignersBarcodeModelImpl;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the designers barcode service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see DesignersBarcodePersistence
 * @see DesignersBarcodeUtil
 * @generated
 */
public class DesignersBarcodePersistenceImpl extends BasePersistenceImpl<DesignersBarcode>
	implements DesignersBarcodePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DesignersBarcodeUtil} to access the designers barcode persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DesignersBarcodeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DesignersBarcodeModelImpl.ENTITY_CACHE_ENABLED,
			DesignersBarcodeModelImpl.FINDER_CACHE_ENABLED,
			DesignersBarcodeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DesignersBarcodeModelImpl.ENTITY_CACHE_ENABLED,
			DesignersBarcodeModelImpl.FINDER_CACHE_ENABLED,
			DesignersBarcodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DesignersBarcodeModelImpl.ENTITY_CACHE_ENABLED,
			DesignersBarcodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_BARCODEID = new FinderPath(DesignersBarcodeModelImpl.ENTITY_CACHE_ENABLED,
			DesignersBarcodeModelImpl.FINDER_CACHE_ENABLED,
			DesignersBarcodeImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByBarcodeId", new String[] { Long.class.getName() },
			DesignersBarcodeModelImpl.BARCODEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BARCODEID = new FinderPath(DesignersBarcodeModelImpl.ENTITY_CACHE_ENABLED,
			DesignersBarcodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBarcodeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the designers barcode where barcodeId = &#63; or throws a {@link com.cloud.tags.NoSuchDesignersBarcodeException} if it could not be found.
	 *
	 * @param barcodeId the barcode ID
	 * @return the matching designers barcode
	 * @throws com.cloud.tags.NoSuchDesignersBarcodeException if a matching designers barcode could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DesignersBarcode findByBarcodeId(long barcodeId)
		throws NoSuchDesignersBarcodeException, SystemException {
		DesignersBarcode designersBarcode = fetchByBarcodeId(barcodeId);

		if (designersBarcode == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("barcodeId=");
			msg.append(barcodeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDesignersBarcodeException(msg.toString());
		}

		return designersBarcode;
	}

	/**
	 * Returns the designers barcode where barcodeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param barcodeId the barcode ID
	 * @return the matching designers barcode, or <code>null</code> if a matching designers barcode could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DesignersBarcode fetchByBarcodeId(long barcodeId)
		throws SystemException {
		return fetchByBarcodeId(barcodeId, true);
	}

	/**
	 * Returns the designers barcode where barcodeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param barcodeId the barcode ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching designers barcode, or <code>null</code> if a matching designers barcode could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DesignersBarcode fetchByBarcodeId(long barcodeId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { barcodeId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BARCODEID,
					finderArgs, this);
		}

		if (result instanceof DesignersBarcode) {
			DesignersBarcode designersBarcode = (DesignersBarcode)result;

			if ((barcodeId != designersBarcode.getBarcodeId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DESIGNERSBARCODE_WHERE);

			query.append(_FINDER_COLUMN_BARCODEID_BARCODEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(barcodeId);

				List<DesignersBarcode> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BARCODEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DesignersBarcodePersistenceImpl.fetchByBarcodeId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					DesignersBarcode designersBarcode = list.get(0);

					result = designersBarcode;

					cacheResult(designersBarcode);

					if ((designersBarcode.getBarcodeId() != barcodeId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BARCODEID,
							finderArgs, designersBarcode);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BARCODEID,
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
			return (DesignersBarcode)result;
		}
	}

	/**
	 * Removes the designers barcode where barcodeId = &#63; from the database.
	 *
	 * @param barcodeId the barcode ID
	 * @return the designers barcode that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DesignersBarcode removeByBarcodeId(long barcodeId)
		throws NoSuchDesignersBarcodeException, SystemException {
		DesignersBarcode designersBarcode = findByBarcodeId(barcodeId);

		return remove(designersBarcode);
	}

	/**
	 * Returns the number of designers barcodes where barcodeId = &#63;.
	 *
	 * @param barcodeId the barcode ID
	 * @return the number of matching designers barcodes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBarcodeId(long barcodeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BARCODEID;

		Object[] finderArgs = new Object[] { barcodeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DESIGNERSBARCODE_WHERE);

			query.append(_FINDER_COLUMN_BARCODEID_BARCODEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(barcodeId);

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

	private static final String _FINDER_COLUMN_BARCODEID_BARCODEID_2 = "designersBarcode.barcodeId = ?";

	public DesignersBarcodePersistenceImpl() {
		setModelClass(DesignersBarcode.class);
	}

	/**
	 * Caches the designers barcode in the entity cache if it is enabled.
	 *
	 * @param designersBarcode the designers barcode
	 */
	@Override
	public void cacheResult(DesignersBarcode designersBarcode) {
		EntityCacheUtil.putResult(DesignersBarcodeModelImpl.ENTITY_CACHE_ENABLED,
			DesignersBarcodeImpl.class, designersBarcode.getPrimaryKey(),
			designersBarcode);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BARCODEID,
			new Object[] { designersBarcode.getBarcodeId() }, designersBarcode);

		designersBarcode.resetOriginalValues();
	}

	/**
	 * Caches the designers barcodes in the entity cache if it is enabled.
	 *
	 * @param designersBarcodes the designers barcodes
	 */
	@Override
	public void cacheResult(List<DesignersBarcode> designersBarcodes) {
		for (DesignersBarcode designersBarcode : designersBarcodes) {
			if (EntityCacheUtil.getResult(
						DesignersBarcodeModelImpl.ENTITY_CACHE_ENABLED,
						DesignersBarcodeImpl.class,
						designersBarcode.getPrimaryKey()) == null) {
				cacheResult(designersBarcode);
			}
			else {
				designersBarcode.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all designers barcodes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DesignersBarcodeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DesignersBarcodeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the designers barcode.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DesignersBarcode designersBarcode) {
		EntityCacheUtil.removeResult(DesignersBarcodeModelImpl.ENTITY_CACHE_ENABLED,
			DesignersBarcodeImpl.class, designersBarcode.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(designersBarcode);
	}

	@Override
	public void clearCache(List<DesignersBarcode> designersBarcodes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DesignersBarcode designersBarcode : designersBarcodes) {
			EntityCacheUtil.removeResult(DesignersBarcodeModelImpl.ENTITY_CACHE_ENABLED,
				DesignersBarcodeImpl.class, designersBarcode.getPrimaryKey());

			clearUniqueFindersCache(designersBarcode);
		}
	}

	protected void cacheUniqueFindersCache(DesignersBarcode designersBarcode) {
		if (designersBarcode.isNew()) {
			Object[] args = new Object[] { designersBarcode.getBarcodeId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BARCODEID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BARCODEID, args,
				designersBarcode);
		}
		else {
			DesignersBarcodeModelImpl designersBarcodeModelImpl = (DesignersBarcodeModelImpl)designersBarcode;

			if ((designersBarcodeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BARCODEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { designersBarcode.getBarcodeId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BARCODEID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BARCODEID, args,
					designersBarcode);
			}
		}
	}

	protected void clearUniqueFindersCache(DesignersBarcode designersBarcode) {
		DesignersBarcodeModelImpl designersBarcodeModelImpl = (DesignersBarcodeModelImpl)designersBarcode;

		Object[] args = new Object[] { designersBarcode.getBarcodeId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BARCODEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BARCODEID, args);

		if ((designersBarcodeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BARCODEID.getColumnBitmask()) != 0) {
			args = new Object[] { designersBarcodeModelImpl.getOriginalBarcodeId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BARCODEID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BARCODEID, args);
		}
	}

	/**
	 * Creates a new designers barcode with the primary key. Does not add the designers barcode to the database.
	 *
	 * @param designerBarcodeId the primary key for the new designers barcode
	 * @return the new designers barcode
	 */
	@Override
	public DesignersBarcode create(long designerBarcodeId) {
		DesignersBarcode designersBarcode = new DesignersBarcodeImpl();

		designersBarcode.setNew(true);
		designersBarcode.setPrimaryKey(designerBarcodeId);

		return designersBarcode;
	}

	/**
	 * Removes the designers barcode with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designerBarcodeId the primary key of the designers barcode
	 * @return the designers barcode that was removed
	 * @throws com.cloud.tags.NoSuchDesignersBarcodeException if a designers barcode with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DesignersBarcode remove(long designerBarcodeId)
		throws NoSuchDesignersBarcodeException, SystemException {
		return remove((Serializable)designerBarcodeId);
	}

	/**
	 * Removes the designers barcode with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the designers barcode
	 * @return the designers barcode that was removed
	 * @throws com.cloud.tags.NoSuchDesignersBarcodeException if a designers barcode with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DesignersBarcode remove(Serializable primaryKey)
		throws NoSuchDesignersBarcodeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DesignersBarcode designersBarcode = (DesignersBarcode)session.get(DesignersBarcodeImpl.class,
					primaryKey);

			if (designersBarcode == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDesignersBarcodeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(designersBarcode);
		}
		catch (NoSuchDesignersBarcodeException nsee) {
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
	protected DesignersBarcode removeImpl(DesignersBarcode designersBarcode)
		throws SystemException {
		designersBarcode = toUnwrappedModel(designersBarcode);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(designersBarcode)) {
				designersBarcode = (DesignersBarcode)session.get(DesignersBarcodeImpl.class,
						designersBarcode.getPrimaryKeyObj());
			}

			if (designersBarcode != null) {
				session.delete(designersBarcode);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (designersBarcode != null) {
			clearCache(designersBarcode);
		}

		return designersBarcode;
	}

	@Override
	public DesignersBarcode updateImpl(
		com.cloud.tags.model.DesignersBarcode designersBarcode)
		throws SystemException {
		designersBarcode = toUnwrappedModel(designersBarcode);

		boolean isNew = designersBarcode.isNew();

		Session session = null;

		try {
			session = openSession();

			if (designersBarcode.isNew()) {
				session.save(designersBarcode);

				designersBarcode.setNew(false);
			}
			else {
				session.merge(designersBarcode);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DesignersBarcodeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(DesignersBarcodeModelImpl.ENTITY_CACHE_ENABLED,
			DesignersBarcodeImpl.class, designersBarcode.getPrimaryKey(),
			designersBarcode);

		clearUniqueFindersCache(designersBarcode);
		cacheUniqueFindersCache(designersBarcode);

		return designersBarcode;
	}

	protected DesignersBarcode toUnwrappedModel(
		DesignersBarcode designersBarcode) {
		if (designersBarcode instanceof DesignersBarcodeImpl) {
			return designersBarcode;
		}

		DesignersBarcodeImpl designersBarcodeImpl = new DesignersBarcodeImpl();

		designersBarcodeImpl.setNew(designersBarcode.isNew());
		designersBarcodeImpl.setPrimaryKey(designersBarcode.getPrimaryKey());

		designersBarcodeImpl.setDesignerBarcodeId(designersBarcode.getDesignerBarcodeId());
		designersBarcodeImpl.setBarcodeId(designersBarcode.getBarcodeId());
		designersBarcodeImpl.setDesignId(designersBarcode.getDesignId());
		designersBarcodeImpl.setCreateDate(designersBarcode.getCreateDate());
		designersBarcodeImpl.setModifiedDate(designersBarcode.getModifiedDate());

		return designersBarcodeImpl;
	}

	/**
	 * Returns the designers barcode with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the designers barcode
	 * @return the designers barcode
	 * @throws com.cloud.tags.NoSuchDesignersBarcodeException if a designers barcode with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DesignersBarcode findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDesignersBarcodeException, SystemException {
		DesignersBarcode designersBarcode = fetchByPrimaryKey(primaryKey);

		if (designersBarcode == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDesignersBarcodeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return designersBarcode;
	}

	/**
	 * Returns the designers barcode with the primary key or throws a {@link com.cloud.tags.NoSuchDesignersBarcodeException} if it could not be found.
	 *
	 * @param designerBarcodeId the primary key of the designers barcode
	 * @return the designers barcode
	 * @throws com.cloud.tags.NoSuchDesignersBarcodeException if a designers barcode with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DesignersBarcode findByPrimaryKey(long designerBarcodeId)
		throws NoSuchDesignersBarcodeException, SystemException {
		return findByPrimaryKey((Serializable)designerBarcodeId);
	}

	/**
	 * Returns the designers barcode with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the designers barcode
	 * @return the designers barcode, or <code>null</code> if a designers barcode with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DesignersBarcode fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DesignersBarcode designersBarcode = (DesignersBarcode)EntityCacheUtil.getResult(DesignersBarcodeModelImpl.ENTITY_CACHE_ENABLED,
				DesignersBarcodeImpl.class, primaryKey);

		if (designersBarcode == _nullDesignersBarcode) {
			return null;
		}

		if (designersBarcode == null) {
			Session session = null;

			try {
				session = openSession();

				designersBarcode = (DesignersBarcode)session.get(DesignersBarcodeImpl.class,
						primaryKey);

				if (designersBarcode != null) {
					cacheResult(designersBarcode);
				}
				else {
					EntityCacheUtil.putResult(DesignersBarcodeModelImpl.ENTITY_CACHE_ENABLED,
						DesignersBarcodeImpl.class, primaryKey,
						_nullDesignersBarcode);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DesignersBarcodeModelImpl.ENTITY_CACHE_ENABLED,
					DesignersBarcodeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return designersBarcode;
	}

	/**
	 * Returns the designers barcode with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designerBarcodeId the primary key of the designers barcode
	 * @return the designers barcode, or <code>null</code> if a designers barcode with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DesignersBarcode fetchByPrimaryKey(long designerBarcodeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)designerBarcodeId);
	}

	/**
	 * Returns all the designers barcodes.
	 *
	 * @return the designers barcodes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DesignersBarcode> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designers barcodes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersBarcodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of designers barcodes
	 * @param end the upper bound of the range of designers barcodes (not inclusive)
	 * @return the range of designers barcodes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DesignersBarcode> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the designers barcodes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersBarcodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of designers barcodes
	 * @param end the upper bound of the range of designers barcodes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designers barcodes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DesignersBarcode> findAll(int start, int end,
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

		List<DesignersBarcode> list = (List<DesignersBarcode>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DESIGNERSBARCODE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DESIGNERSBARCODE;

				if (pagination) {
					sql = sql.concat(DesignersBarcodeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DesignersBarcode>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DesignersBarcode>(list);
				}
				else {
					list = (List<DesignersBarcode>)QueryUtil.list(q,
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
	 * Removes all the designers barcodes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DesignersBarcode designersBarcode : findAll()) {
			remove(designersBarcode);
		}
	}

	/**
	 * Returns the number of designers barcodes.
	 *
	 * @return the number of designers barcodes
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

				Query q = session.createQuery(_SQL_COUNT_DESIGNERSBARCODE);

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
	 * Initializes the designers barcode persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cloud.tags.model.DesignersBarcode")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DesignersBarcode>> listenersList = new ArrayList<ModelListener<DesignersBarcode>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DesignersBarcode>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DesignersBarcodeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DESIGNERSBARCODE = "SELECT designersBarcode FROM DesignersBarcode designersBarcode";
	private static final String _SQL_SELECT_DESIGNERSBARCODE_WHERE = "SELECT designersBarcode FROM DesignersBarcode designersBarcode WHERE ";
	private static final String _SQL_COUNT_DESIGNERSBARCODE = "SELECT COUNT(designersBarcode) FROM DesignersBarcode designersBarcode";
	private static final String _SQL_COUNT_DESIGNERSBARCODE_WHERE = "SELECT COUNT(designersBarcode) FROM DesignersBarcode designersBarcode WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "designersBarcode.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DesignersBarcode exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DesignersBarcode exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DesignersBarcodePersistenceImpl.class);
	private static DesignersBarcode _nullDesignersBarcode = new DesignersBarcodeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DesignersBarcode> toCacheModel() {
				return _nullDesignersBarcodeCacheModel;
			}
		};

	private static CacheModel<DesignersBarcode> _nullDesignersBarcodeCacheModel = new CacheModel<DesignersBarcode>() {
			@Override
			public DesignersBarcode toEntityModel() {
				return _nullDesignersBarcode;
			}
		};
}