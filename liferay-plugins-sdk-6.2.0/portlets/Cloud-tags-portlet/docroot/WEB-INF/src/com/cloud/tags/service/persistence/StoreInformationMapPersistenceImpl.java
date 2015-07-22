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

import com.cloud.tags.NoSuchStoreInformationMapException;
import com.cloud.tags.model.StoreInformationMap;
import com.cloud.tags.model.impl.StoreInformationMapImpl;
import com.cloud.tags.model.impl.StoreInformationMapModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the store information map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see StoreInformationMapPersistence
 * @see StoreInformationMapUtil
 * @generated
 */
public class StoreInformationMapPersistenceImpl extends BasePersistenceImpl<StoreInformationMap>
	implements StoreInformationMapPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StoreInformationMapUtil} to access the store information map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StoreInformationMapImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StoreInformationMapModelImpl.ENTITY_CACHE_ENABLED,
			StoreInformationMapModelImpl.FINDER_CACHE_ENABLED,
			StoreInformationMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StoreInformationMapModelImpl.ENTITY_CACHE_ENABLED,
			StoreInformationMapModelImpl.FINDER_CACHE_ENABLED,
			StoreInformationMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StoreInformationMapModelImpl.ENTITY_CACHE_ENABLED,
			StoreInformationMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public StoreInformationMapPersistenceImpl() {
		setModelClass(StoreInformationMap.class);
	}

	/**
	 * Caches the store information map in the entity cache if it is enabled.
	 *
	 * @param storeInformationMap the store information map
	 */
	@Override
	public void cacheResult(StoreInformationMap storeInformationMap) {
		EntityCacheUtil.putResult(StoreInformationMapModelImpl.ENTITY_CACHE_ENABLED,
			StoreInformationMapImpl.class, storeInformationMap.getPrimaryKey(),
			storeInformationMap);

		storeInformationMap.resetOriginalValues();
	}

	/**
	 * Caches the store information maps in the entity cache if it is enabled.
	 *
	 * @param storeInformationMaps the store information maps
	 */
	@Override
	public void cacheResult(List<StoreInformationMap> storeInformationMaps) {
		for (StoreInformationMap storeInformationMap : storeInformationMaps) {
			if (EntityCacheUtil.getResult(
						StoreInformationMapModelImpl.ENTITY_CACHE_ENABLED,
						StoreInformationMapImpl.class,
						storeInformationMap.getPrimaryKey()) == null) {
				cacheResult(storeInformationMap);
			}
			else {
				storeInformationMap.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all store information maps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StoreInformationMapImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StoreInformationMapImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the store information map.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StoreInformationMap storeInformationMap) {
		EntityCacheUtil.removeResult(StoreInformationMapModelImpl.ENTITY_CACHE_ENABLED,
			StoreInformationMapImpl.class, storeInformationMap.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StoreInformationMap> storeInformationMaps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StoreInformationMap storeInformationMap : storeInformationMaps) {
			EntityCacheUtil.removeResult(StoreInformationMapModelImpl.ENTITY_CACHE_ENABLED,
				StoreInformationMapImpl.class,
				storeInformationMap.getPrimaryKey());
		}
	}

	/**
	 * Creates a new store information map with the primary key. Does not add the store information map to the database.
	 *
	 * @param uuid the primary key for the new store information map
	 * @return the new store information map
	 */
	@Override
	public StoreInformationMap create(long uuid) {
		StoreInformationMap storeInformationMap = new StoreInformationMapImpl();

		storeInformationMap.setNew(true);
		storeInformationMap.setPrimaryKey(uuid);

		return storeInformationMap;
	}

	/**
	 * Removes the store information map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param uuid the primary key of the store information map
	 * @return the store information map that was removed
	 * @throws com.cloud.tags.NoSuchStoreInformationMapException if a store information map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StoreInformationMap remove(long uuid)
		throws NoSuchStoreInformationMapException, SystemException {
		return remove((Serializable)uuid);
	}

	/**
	 * Removes the store information map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the store information map
	 * @return the store information map that was removed
	 * @throws com.cloud.tags.NoSuchStoreInformationMapException if a store information map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StoreInformationMap remove(Serializable primaryKey)
		throws NoSuchStoreInformationMapException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StoreInformationMap storeInformationMap = (StoreInformationMap)session.get(StoreInformationMapImpl.class,
					primaryKey);

			if (storeInformationMap == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStoreInformationMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(storeInformationMap);
		}
		catch (NoSuchStoreInformationMapException nsee) {
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
	protected StoreInformationMap removeImpl(
		StoreInformationMap storeInformationMap) throws SystemException {
		storeInformationMap = toUnwrappedModel(storeInformationMap);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(storeInformationMap)) {
				storeInformationMap = (StoreInformationMap)session.get(StoreInformationMapImpl.class,
						storeInformationMap.getPrimaryKeyObj());
			}

			if (storeInformationMap != null) {
				session.delete(storeInformationMap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (storeInformationMap != null) {
			clearCache(storeInformationMap);
		}

		return storeInformationMap;
	}

	@Override
	public StoreInformationMap updateImpl(
		com.cloud.tags.model.StoreInformationMap storeInformationMap)
		throws SystemException {
		storeInformationMap = toUnwrappedModel(storeInformationMap);

		boolean isNew = storeInformationMap.isNew();

		Session session = null;

		try {
			session = openSession();

			if (storeInformationMap.isNew()) {
				session.save(storeInformationMap);

				storeInformationMap.setNew(false);
			}
			else {
				session.merge(storeInformationMap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(StoreInformationMapModelImpl.ENTITY_CACHE_ENABLED,
			StoreInformationMapImpl.class, storeInformationMap.getPrimaryKey(),
			storeInformationMap);

		return storeInformationMap;
	}

	protected StoreInformationMap toUnwrappedModel(
		StoreInformationMap storeInformationMap) {
		if (storeInformationMap instanceof StoreInformationMapImpl) {
			return storeInformationMap;
		}

		StoreInformationMapImpl storeInformationMapImpl = new StoreInformationMapImpl();

		storeInformationMapImpl.setNew(storeInformationMap.isNew());
		storeInformationMapImpl.setPrimaryKey(storeInformationMap.getPrimaryKey());

		storeInformationMapImpl.setUuid(storeInformationMap.getUuid());
		storeInformationMapImpl.setName(storeInformationMap.getName());
		storeInformationMapImpl.setAddress(storeInformationMap.getAddress());
		storeInformationMapImpl.setCompanyId(storeInformationMap.getCompanyId());
		storeInformationMapImpl.setGroupId(storeInformationMap.getGroupId());
		storeInformationMapImpl.setCreateDate(storeInformationMap.getCreateDate());

		return storeInformationMapImpl;
	}

	/**
	 * Returns the store information map with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the store information map
	 * @return the store information map
	 * @throws com.cloud.tags.NoSuchStoreInformationMapException if a store information map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StoreInformationMap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStoreInformationMapException, SystemException {
		StoreInformationMap storeInformationMap = fetchByPrimaryKey(primaryKey);

		if (storeInformationMap == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStoreInformationMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return storeInformationMap;
	}

	/**
	 * Returns the store information map with the primary key or throws a {@link com.cloud.tags.NoSuchStoreInformationMapException} if it could not be found.
	 *
	 * @param uuid the primary key of the store information map
	 * @return the store information map
	 * @throws com.cloud.tags.NoSuchStoreInformationMapException if a store information map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StoreInformationMap findByPrimaryKey(long uuid)
		throws NoSuchStoreInformationMapException, SystemException {
		return findByPrimaryKey((Serializable)uuid);
	}

	/**
	 * Returns the store information map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the store information map
	 * @return the store information map, or <code>null</code> if a store information map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StoreInformationMap fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StoreInformationMap storeInformationMap = (StoreInformationMap)EntityCacheUtil.getResult(StoreInformationMapModelImpl.ENTITY_CACHE_ENABLED,
				StoreInformationMapImpl.class, primaryKey);

		if (storeInformationMap == _nullStoreInformationMap) {
			return null;
		}

		if (storeInformationMap == null) {
			Session session = null;

			try {
				session = openSession();

				storeInformationMap = (StoreInformationMap)session.get(StoreInformationMapImpl.class,
						primaryKey);

				if (storeInformationMap != null) {
					cacheResult(storeInformationMap);
				}
				else {
					EntityCacheUtil.putResult(StoreInformationMapModelImpl.ENTITY_CACHE_ENABLED,
						StoreInformationMapImpl.class, primaryKey,
						_nullStoreInformationMap);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StoreInformationMapModelImpl.ENTITY_CACHE_ENABLED,
					StoreInformationMapImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return storeInformationMap;
	}

	/**
	 * Returns the store information map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param uuid the primary key of the store information map
	 * @return the store information map, or <code>null</code> if a store information map with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StoreInformationMap fetchByPrimaryKey(long uuid)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)uuid);
	}

	/**
	 * Returns all the store information maps.
	 *
	 * @return the store information maps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StoreInformationMap> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the store information maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.StoreInformationMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of store information maps
	 * @param end the upper bound of the range of store information maps (not inclusive)
	 * @return the range of store information maps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StoreInformationMap> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the store information maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.StoreInformationMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of store information maps
	 * @param end the upper bound of the range of store information maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of store information maps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StoreInformationMap> findAll(int start, int end,
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

		List<StoreInformationMap> list = (List<StoreInformationMap>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STOREINFORMATIONMAP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STOREINFORMATIONMAP;

				if (pagination) {
					sql = sql.concat(StoreInformationMapModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StoreInformationMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StoreInformationMap>(list);
				}
				else {
					list = (List<StoreInformationMap>)QueryUtil.list(q,
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
	 * Removes all the store information maps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StoreInformationMap storeInformationMap : findAll()) {
			remove(storeInformationMap);
		}
	}

	/**
	 * Returns the number of store information maps.
	 *
	 * @return the number of store information maps
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

				Query q = session.createQuery(_SQL_COUNT_STOREINFORMATIONMAP);

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
	 * Initializes the store information map persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cloud.tags.model.StoreInformationMap")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StoreInformationMap>> listenersList = new ArrayList<ModelListener<StoreInformationMap>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StoreInformationMap>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StoreInformationMapImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STOREINFORMATIONMAP = "SELECT storeInformationMap FROM StoreInformationMap storeInformationMap";
	private static final String _SQL_COUNT_STOREINFORMATIONMAP = "SELECT COUNT(storeInformationMap) FROM StoreInformationMap storeInformationMap";
	private static final String _ORDER_BY_ENTITY_ALIAS = "storeInformationMap.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StoreInformationMap exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StoreInformationMapPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static StoreInformationMap _nullStoreInformationMap = new StoreInformationMapImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StoreInformationMap> toCacheModel() {
				return _nullStoreInformationMapCacheModel;
			}
		};

	private static CacheModel<StoreInformationMap> _nullStoreInformationMapCacheModel =
		new CacheModel<StoreInformationMap>() {
			@Override
			public StoreInformationMap toEntityModel() {
				return _nullStoreInformationMap;
			}
		};
}