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

import com.cloud.tags.NoSuchDesignersImagesException;
import com.cloud.tags.model.DesignersImages;
import com.cloud.tags.model.impl.DesignersImagesImpl;
import com.cloud.tags.model.impl.DesignersImagesModelImpl;

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
 * The persistence implementation for the designers images service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mohammed Zaheer
 * @see DesignersImagesPersistence
 * @see DesignersImagesUtil
 * @generated
 */
public class DesignersImagesPersistenceImpl extends BasePersistenceImpl<DesignersImages>
	implements DesignersImagesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DesignersImagesUtil} to access the designers images persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DesignersImagesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DesignersImagesModelImpl.ENTITY_CACHE_ENABLED,
			DesignersImagesModelImpl.FINDER_CACHE_ENABLED,
			DesignersImagesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DesignersImagesModelImpl.ENTITY_CACHE_ENABLED,
			DesignersImagesModelImpl.FINDER_CACHE_ENABLED,
			DesignersImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DesignersImagesModelImpl.ENTITY_CACHE_ENABLED,
			DesignersImagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_DESIGNID = new FinderPath(DesignersImagesModelImpl.ENTITY_CACHE_ENABLED,
			DesignersImagesModelImpl.FINDER_CACHE_ENABLED,
			DesignersImagesImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBydesignId", new String[] { Long.class.getName() },
			DesignersImagesModelImpl.DESIGNID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DESIGNID = new FinderPath(DesignersImagesModelImpl.ENTITY_CACHE_ENABLED,
			DesignersImagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydesignId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the designers images where designId = &#63; or throws a {@link com.cloud.tags.NoSuchDesignersImagesException} if it could not be found.
	 *
	 * @param designId the design ID
	 * @return the matching designers images
	 * @throws com.cloud.tags.NoSuchDesignersImagesException if a matching designers images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DesignersImages findBydesignId(long designId)
		throws NoSuchDesignersImagesException, SystemException {
		DesignersImages designersImages = fetchBydesignId(designId);

		if (designersImages == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("designId=");
			msg.append(designId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDesignersImagesException(msg.toString());
		}

		return designersImages;
	}

	/**
	 * Returns the designers images where designId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param designId the design ID
	 * @return the matching designers images, or <code>null</code> if a matching designers images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DesignersImages fetchBydesignId(long designId)
		throws SystemException {
		return fetchBydesignId(designId, true);
	}

	/**
	 * Returns the designers images where designId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param designId the design ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching designers images, or <code>null</code> if a matching designers images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DesignersImages fetchBydesignId(long designId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { designId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_DESIGNID,
					finderArgs, this);
		}

		if (result instanceof DesignersImages) {
			DesignersImages designersImages = (DesignersImages)result;

			if ((designId != designersImages.getDesignId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DESIGNERSIMAGES_WHERE);

			query.append(_FINDER_COLUMN_DESIGNID_DESIGNID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(designId);

				List<DesignersImages> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DESIGNID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DesignersImagesPersistenceImpl.fetchBydesignId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					DesignersImages designersImages = list.get(0);

					result = designersImages;

					cacheResult(designersImages);

					if ((designersImages.getDesignId() != designId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DESIGNID,
							finderArgs, designersImages);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DESIGNID,
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
			return (DesignersImages)result;
		}
	}

	/**
	 * Removes the designers images where designId = &#63; from the database.
	 *
	 * @param designId the design ID
	 * @return the designers images that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DesignersImages removeBydesignId(long designId)
		throws NoSuchDesignersImagesException, SystemException {
		DesignersImages designersImages = findBydesignId(designId);

		return remove(designersImages);
	}

	/**
	 * Returns the number of designers imageses where designId = &#63;.
	 *
	 * @param designId the design ID
	 * @return the number of matching designers imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBydesignId(long designId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DESIGNID;

		Object[] finderArgs = new Object[] { designId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DESIGNERSIMAGES_WHERE);

			query.append(_FINDER_COLUMN_DESIGNID_DESIGNID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_DESIGNID_DESIGNID_2 = "designersImages.designId = ?";

	public DesignersImagesPersistenceImpl() {
		setModelClass(DesignersImages.class);
	}

	/**
	 * Caches the designers images in the entity cache if it is enabled.
	 *
	 * @param designersImages the designers images
	 */
	@Override
	public void cacheResult(DesignersImages designersImages) {
		EntityCacheUtil.putResult(DesignersImagesModelImpl.ENTITY_CACHE_ENABLED,
			DesignersImagesImpl.class, designersImages.getPrimaryKey(),
			designersImages);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DESIGNID,
			new Object[] { designersImages.getDesignId() }, designersImages);

		designersImages.resetOriginalValues();
	}

	/**
	 * Caches the designers imageses in the entity cache if it is enabled.
	 *
	 * @param designersImageses the designers imageses
	 */
	@Override
	public void cacheResult(List<DesignersImages> designersImageses) {
		for (DesignersImages designersImages : designersImageses) {
			if (EntityCacheUtil.getResult(
						DesignersImagesModelImpl.ENTITY_CACHE_ENABLED,
						DesignersImagesImpl.class,
						designersImages.getPrimaryKey()) == null) {
				cacheResult(designersImages);
			}
			else {
				designersImages.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all designers imageses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DesignersImagesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DesignersImagesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the designers images.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DesignersImages designersImages) {
		EntityCacheUtil.removeResult(DesignersImagesModelImpl.ENTITY_CACHE_ENABLED,
			DesignersImagesImpl.class, designersImages.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(designersImages);
	}

	@Override
	public void clearCache(List<DesignersImages> designersImageses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DesignersImages designersImages : designersImageses) {
			EntityCacheUtil.removeResult(DesignersImagesModelImpl.ENTITY_CACHE_ENABLED,
				DesignersImagesImpl.class, designersImages.getPrimaryKey());

			clearUniqueFindersCache(designersImages);
		}
	}

	protected void cacheUniqueFindersCache(DesignersImages designersImages) {
		if (designersImages.isNew()) {
			Object[] args = new Object[] { designersImages.getDesignId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DESIGNID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DESIGNID, args,
				designersImages);
		}
		else {
			DesignersImagesModelImpl designersImagesModelImpl = (DesignersImagesModelImpl)designersImages;

			if ((designersImagesModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_DESIGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { designersImages.getDesignId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DESIGNID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DESIGNID, args,
					designersImages);
			}
		}
	}

	protected void clearUniqueFindersCache(DesignersImages designersImages) {
		DesignersImagesModelImpl designersImagesModelImpl = (DesignersImagesModelImpl)designersImages;

		Object[] args = new Object[] { designersImages.getDesignId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DESIGNID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DESIGNID, args);

		if ((designersImagesModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_DESIGNID.getColumnBitmask()) != 0) {
			args = new Object[] { designersImagesModelImpl.getOriginalDesignId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DESIGNID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DESIGNID, args);
		}
	}

	/**
	 * Creates a new designers images with the primary key. Does not add the designers images to the database.
	 *
	 * @param designImageId the primary key for the new designers images
	 * @return the new designers images
	 */
	@Override
	public DesignersImages create(long designImageId) {
		DesignersImages designersImages = new DesignersImagesImpl();

		designersImages.setNew(true);
		designersImages.setPrimaryKey(designImageId);

		return designersImages;
	}

	/**
	 * Removes the designers images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designImageId the primary key of the designers images
	 * @return the designers images that was removed
	 * @throws com.cloud.tags.NoSuchDesignersImagesException if a designers images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DesignersImages remove(long designImageId)
		throws NoSuchDesignersImagesException, SystemException {
		return remove((Serializable)designImageId);
	}

	/**
	 * Removes the designers images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the designers images
	 * @return the designers images that was removed
	 * @throws com.cloud.tags.NoSuchDesignersImagesException if a designers images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DesignersImages remove(Serializable primaryKey)
		throws NoSuchDesignersImagesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DesignersImages designersImages = (DesignersImages)session.get(DesignersImagesImpl.class,
					primaryKey);

			if (designersImages == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDesignersImagesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(designersImages);
		}
		catch (NoSuchDesignersImagesException nsee) {
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
	protected DesignersImages removeImpl(DesignersImages designersImages)
		throws SystemException {
		designersImages = toUnwrappedModel(designersImages);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(designersImages)) {
				designersImages = (DesignersImages)session.get(DesignersImagesImpl.class,
						designersImages.getPrimaryKeyObj());
			}

			if (designersImages != null) {
				session.delete(designersImages);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (designersImages != null) {
			clearCache(designersImages);
		}

		return designersImages;
	}

	@Override
	public DesignersImages updateImpl(
		com.cloud.tags.model.DesignersImages designersImages)
		throws SystemException {
		designersImages = toUnwrappedModel(designersImages);

		boolean isNew = designersImages.isNew();

		Session session = null;

		try {
			session = openSession();

			if (designersImages.isNew()) {
				session.save(designersImages);

				designersImages.setNew(false);
			}
			else {
				session.merge(designersImages);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DesignersImagesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(DesignersImagesModelImpl.ENTITY_CACHE_ENABLED,
			DesignersImagesImpl.class, designersImages.getPrimaryKey(),
			designersImages);

		clearUniqueFindersCache(designersImages);
		cacheUniqueFindersCache(designersImages);

		return designersImages;
	}

	protected DesignersImages toUnwrappedModel(DesignersImages designersImages) {
		if (designersImages instanceof DesignersImagesImpl) {
			return designersImages;
		}

		DesignersImagesImpl designersImagesImpl = new DesignersImagesImpl();

		designersImagesImpl.setNew(designersImages.isNew());
		designersImagesImpl.setPrimaryKey(designersImages.getPrimaryKey());

		designersImagesImpl.setDesignImageId(designersImages.getDesignImageId());
		designersImagesImpl.setDesignId(designersImages.getDesignId());
		designersImagesImpl.setEntity_image1(designersImages.getEntity_image1());
		designersImagesImpl.setEntity_image2(designersImages.getEntity_image2());
		designersImagesImpl.setEntity_image3(designersImages.getEntity_image3());
		designersImagesImpl.setEntity_image4(designersImages.getEntity_image4());
		designersImagesImpl.setEntity_image5(designersImages.getEntity_image5());
		designersImagesImpl.setEntity_image6(designersImages.getEntity_image6());
		designersImagesImpl.setEntity_image7(designersImages.getEntity_image7());
		designersImagesImpl.setEntity_image8(designersImages.getEntity_image8());
		designersImagesImpl.setEntity_image9(designersImages.getEntity_image9());
		designersImagesImpl.setEntity_image10(designersImages.getEntity_image10());
		designersImagesImpl.setLarge_image_url(designersImages.getLarge_image_url());
		designersImagesImpl.setSmall_image_url(designersImages.getSmall_image_url());
		designersImagesImpl.setProfile_image_url(designersImages.getProfile_image_url());

		return designersImagesImpl;
	}

	/**
	 * Returns the designers images with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the designers images
	 * @return the designers images
	 * @throws com.cloud.tags.NoSuchDesignersImagesException if a designers images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DesignersImages findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDesignersImagesException, SystemException {
		DesignersImages designersImages = fetchByPrimaryKey(primaryKey);

		if (designersImages == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDesignersImagesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return designersImages;
	}

	/**
	 * Returns the designers images with the primary key or throws a {@link com.cloud.tags.NoSuchDesignersImagesException} if it could not be found.
	 *
	 * @param designImageId the primary key of the designers images
	 * @return the designers images
	 * @throws com.cloud.tags.NoSuchDesignersImagesException if a designers images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DesignersImages findByPrimaryKey(long designImageId)
		throws NoSuchDesignersImagesException, SystemException {
		return findByPrimaryKey((Serializable)designImageId);
	}

	/**
	 * Returns the designers images with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the designers images
	 * @return the designers images, or <code>null</code> if a designers images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DesignersImages fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DesignersImages designersImages = (DesignersImages)EntityCacheUtil.getResult(DesignersImagesModelImpl.ENTITY_CACHE_ENABLED,
				DesignersImagesImpl.class, primaryKey);

		if (designersImages == _nullDesignersImages) {
			return null;
		}

		if (designersImages == null) {
			Session session = null;

			try {
				session = openSession();

				designersImages = (DesignersImages)session.get(DesignersImagesImpl.class,
						primaryKey);

				if (designersImages != null) {
					cacheResult(designersImages);
				}
				else {
					EntityCacheUtil.putResult(DesignersImagesModelImpl.ENTITY_CACHE_ENABLED,
						DesignersImagesImpl.class, primaryKey,
						_nullDesignersImages);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DesignersImagesModelImpl.ENTITY_CACHE_ENABLED,
					DesignersImagesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return designersImages;
	}

	/**
	 * Returns the designers images with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designImageId the primary key of the designers images
	 * @return the designers images, or <code>null</code> if a designers images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DesignersImages fetchByPrimaryKey(long designImageId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)designImageId);
	}

	/**
	 * Returns all the designers imageses.
	 *
	 * @return the designers imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DesignersImages> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designers imageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of designers imageses
	 * @param end the upper bound of the range of designers imageses (not inclusive)
	 * @return the range of designers imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DesignersImages> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the designers imageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.cloud.tags.model.impl.DesignersImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of designers imageses
	 * @param end the upper bound of the range of designers imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designers imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DesignersImages> findAll(int start, int end,
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

		List<DesignersImages> list = (List<DesignersImages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DESIGNERSIMAGES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DESIGNERSIMAGES;

				if (pagination) {
					sql = sql.concat(DesignersImagesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DesignersImages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DesignersImages>(list);
				}
				else {
					list = (List<DesignersImages>)QueryUtil.list(q,
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
	 * Removes all the designers imageses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DesignersImages designersImages : findAll()) {
			remove(designersImages);
		}
	}

	/**
	 * Returns the number of designers imageses.
	 *
	 * @return the number of designers imageses
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

				Query q = session.createQuery(_SQL_COUNT_DESIGNERSIMAGES);

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
	 * Initializes the designers images persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.cloud.tags.model.DesignersImages")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DesignersImages>> listenersList = new ArrayList<ModelListener<DesignersImages>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DesignersImages>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DesignersImagesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DESIGNERSIMAGES = "SELECT designersImages FROM DesignersImages designersImages";
	private static final String _SQL_SELECT_DESIGNERSIMAGES_WHERE = "SELECT designersImages FROM DesignersImages designersImages WHERE ";
	private static final String _SQL_COUNT_DESIGNERSIMAGES = "SELECT COUNT(designersImages) FROM DesignersImages designersImages";
	private static final String _SQL_COUNT_DESIGNERSIMAGES_WHERE = "SELECT COUNT(designersImages) FROM DesignersImages designersImages WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "designersImages.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DesignersImages exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DesignersImages exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DesignersImagesPersistenceImpl.class);
	private static DesignersImages _nullDesignersImages = new DesignersImagesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DesignersImages> toCacheModel() {
				return _nullDesignersImagesCacheModel;
			}
		};

	private static CacheModel<DesignersImages> _nullDesignersImagesCacheModel = new CacheModel<DesignersImages>() {
			@Override
			public DesignersImages toEntityModel() {
				return _nullDesignersImages;
			}
		};
}