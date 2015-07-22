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

package com.cloud.tags.model.impl;

import com.cloud.tags.model.CartsDesigners;
import com.cloud.tags.model.CartsDesignersModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the CartsDesigners service. Represents a row in the &quot;cart_designers&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.cloud.tags.model.CartsDesignersModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CartsDesignersImpl}.
 * </p>
 *
 * @author Mohammed Zaheer
 * @see CartsDesignersImpl
 * @see com.cloud.tags.model.CartsDesigners
 * @see com.cloud.tags.model.CartsDesignersModel
 * @generated
 */
public class CartsDesignersModelImpl extends BaseModelImpl<CartsDesigners>
	implements CartsDesignersModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a carts designers model instance should use the {@link com.cloud.tags.model.CartsDesigners} interface instead.
	 */
	public static final String TABLE_NAME = "cart_designers";
	public static final Object[][] TABLE_COLUMNS = {
			{ "cartDesignerId", Types.BIGINT },
			{ "cartId", Types.BIGINT },
			{ "designId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "kept", Types.BOOLEAN },
			{ "favorite", Types.BOOLEAN },
			{ "staffId", Types.VARCHAR },
			{ "userNote", Types.VARCHAR },
			{ "XPComputed", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table cart_designers (cartDesignerId LONG not null primary key,cartId LONG,designId LONG,createDate DATE null,modifiedDate DATE null,kept BOOLEAN,favorite BOOLEAN,staffId VARCHAR(75) null,userNote TEXT null,XPComputed BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table cart_designers";
	public static final String ORDER_BY_JPQL = " ORDER BY cartsDesigners.cartDesignerId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY cart_designers.cartDesignerId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.cloud.tags.model.CartsDesigners"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.cloud.tags.model.CartsDesigners"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.cloud.tags.model.CartsDesigners"),
			true);
	public static long CARTID_COLUMN_BITMASK = 1L;
	public static long DESIGNID_COLUMN_BITMASK = 2L;
	public static long STAFFID_COLUMN_BITMASK = 4L;
	public static long CARTDESIGNERID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.cloud.tags.model.CartsDesigners"));

	public CartsDesignersModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _cartDesignerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCartDesignerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cartDesignerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CartsDesigners.class;
	}

	@Override
	public String getModelClassName() {
		return CartsDesigners.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cartDesignerId", getCartDesignerId());
		attributes.put("cartId", getCartId());
		attributes.put("designId", getDesignId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("kept", getKept());
		attributes.put("favorite", getFavorite());
		attributes.put("staffId", getStaffId());
		attributes.put("userNote", getUserNote());
		attributes.put("XPComputed", getXPComputed());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cartDesignerId = (Long)attributes.get("cartDesignerId");

		if (cartDesignerId != null) {
			setCartDesignerId(cartDesignerId);
		}

		Long cartId = (Long)attributes.get("cartId");

		if (cartId != null) {
			setCartId(cartId);
		}

		Long designId = (Long)attributes.get("designId");

		if (designId != null) {
			setDesignId(designId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean kept = (Boolean)attributes.get("kept");

		if (kept != null) {
			setKept(kept);
		}

		Boolean favorite = (Boolean)attributes.get("favorite");

		if (favorite != null) {
			setFavorite(favorite);
		}

		String staffId = (String)attributes.get("staffId");

		if (staffId != null) {
			setStaffId(staffId);
		}

		String userNote = (String)attributes.get("userNote");

		if (userNote != null) {
			setUserNote(userNote);
		}

		Boolean XPComputed = (Boolean)attributes.get("XPComputed");

		if (XPComputed != null) {
			setXPComputed(XPComputed);
		}
	}

	@Override
	public long getCartDesignerId() {
		return _cartDesignerId;
	}

	@Override
	public void setCartDesignerId(long cartDesignerId) {
		_cartDesignerId = cartDesignerId;
	}

	@Override
	public long getCartId() {
		return _cartId;
	}

	@Override
	public void setCartId(long cartId) {
		_columnBitmask |= CARTID_COLUMN_BITMASK;

		if (!_setOriginalCartId) {
			_setOriginalCartId = true;

			_originalCartId = _cartId;
		}

		_cartId = cartId;
	}

	public long getOriginalCartId() {
		return _originalCartId;
	}

	@Override
	public long getDesignId() {
		return _designId;
	}

	@Override
	public void setDesignId(long designId) {
		_columnBitmask |= DESIGNID_COLUMN_BITMASK;

		if (!_setOriginalDesignId) {
			_setOriginalDesignId = true;

			_originalDesignId = _designId;
		}

		_designId = designId;
	}

	public long getOriginalDesignId() {
		return _originalDesignId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public boolean getKept() {
		return _kept;
	}

	@Override
	public boolean isKept() {
		return _kept;
	}

	@Override
	public void setKept(boolean kept) {
		_kept = kept;
	}

	@Override
	public boolean getFavorite() {
		return _favorite;
	}

	@Override
	public boolean isFavorite() {
		return _favorite;
	}

	@Override
	public void setFavorite(boolean favorite) {
		_favorite = favorite;
	}

	@Override
	public String getStaffId() {
		if (_staffId == null) {
			return StringPool.BLANK;
		}
		else {
			return _staffId;
		}
	}

	@Override
	public void setStaffId(String staffId) {
		_columnBitmask |= STAFFID_COLUMN_BITMASK;

		if (_originalStaffId == null) {
			_originalStaffId = _staffId;
		}

		_staffId = staffId;
	}

	public String getOriginalStaffId() {
		return GetterUtil.getString(_originalStaffId);
	}

	@Override
	public String getUserNote() {
		if (_userNote == null) {
			return StringPool.BLANK;
		}
		else {
			return _userNote;
		}
	}

	@Override
	public void setUserNote(String userNote) {
		_userNote = userNote;
	}

	@Override
	public boolean getXPComputed() {
		return _XPComputed;
	}

	@Override
	public boolean isXPComputed() {
		return _XPComputed;
	}

	@Override
	public void setXPComputed(boolean XPComputed) {
		_XPComputed = XPComputed;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			CartsDesigners.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CartsDesigners toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CartsDesigners)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CartsDesignersImpl cartsDesignersImpl = new CartsDesignersImpl();

		cartsDesignersImpl.setCartDesignerId(getCartDesignerId());
		cartsDesignersImpl.setCartId(getCartId());
		cartsDesignersImpl.setDesignId(getDesignId());
		cartsDesignersImpl.setCreateDate(getCreateDate());
		cartsDesignersImpl.setModifiedDate(getModifiedDate());
		cartsDesignersImpl.setKept(getKept());
		cartsDesignersImpl.setFavorite(getFavorite());
		cartsDesignersImpl.setStaffId(getStaffId());
		cartsDesignersImpl.setUserNote(getUserNote());
		cartsDesignersImpl.setXPComputed(getXPComputed());

		cartsDesignersImpl.resetOriginalValues();

		return cartsDesignersImpl;
	}

	@Override
	public int compareTo(CartsDesigners cartsDesigners) {
		long primaryKey = cartsDesigners.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CartsDesigners)) {
			return false;
		}

		CartsDesigners cartsDesigners = (CartsDesigners)obj;

		long primaryKey = cartsDesigners.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		CartsDesignersModelImpl cartsDesignersModelImpl = this;

		cartsDesignersModelImpl._originalCartId = cartsDesignersModelImpl._cartId;

		cartsDesignersModelImpl._setOriginalCartId = false;

		cartsDesignersModelImpl._originalDesignId = cartsDesignersModelImpl._designId;

		cartsDesignersModelImpl._setOriginalDesignId = false;

		cartsDesignersModelImpl._originalStaffId = cartsDesignersModelImpl._staffId;

		cartsDesignersModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CartsDesigners> toCacheModel() {
		CartsDesignersCacheModel cartsDesignersCacheModel = new CartsDesignersCacheModel();

		cartsDesignersCacheModel.cartDesignerId = getCartDesignerId();

		cartsDesignersCacheModel.cartId = getCartId();

		cartsDesignersCacheModel.designId = getDesignId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			cartsDesignersCacheModel.createDate = createDate.getTime();
		}
		else {
			cartsDesignersCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			cartsDesignersCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			cartsDesignersCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		cartsDesignersCacheModel.kept = getKept();

		cartsDesignersCacheModel.favorite = getFavorite();

		cartsDesignersCacheModel.staffId = getStaffId();

		String staffId = cartsDesignersCacheModel.staffId;

		if ((staffId != null) && (staffId.length() == 0)) {
			cartsDesignersCacheModel.staffId = null;
		}

		cartsDesignersCacheModel.userNote = getUserNote();

		String userNote = cartsDesignersCacheModel.userNote;

		if ((userNote != null) && (userNote.length() == 0)) {
			cartsDesignersCacheModel.userNote = null;
		}

		cartsDesignersCacheModel.XPComputed = getXPComputed();

		return cartsDesignersCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{cartDesignerId=");
		sb.append(getCartDesignerId());
		sb.append(", cartId=");
		sb.append(getCartId());
		sb.append(", designId=");
		sb.append(getDesignId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", kept=");
		sb.append(getKept());
		sb.append(", favorite=");
		sb.append(getFavorite());
		sb.append(", staffId=");
		sb.append(getStaffId());
		sb.append(", userNote=");
		sb.append(getUserNote());
		sb.append(", XPComputed=");
		sb.append(getXPComputed());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.cloud.tags.model.CartsDesigners");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>cartDesignerId</column-name><column-value><![CDATA[");
		sb.append(getCartDesignerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cartId</column-name><column-value><![CDATA[");
		sb.append(getCartId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>designId</column-name><column-value><![CDATA[");
		sb.append(getDesignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kept</column-name><column-value><![CDATA[");
		sb.append(getKept());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>favorite</column-name><column-value><![CDATA[");
		sb.append(getFavorite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staffId</column-name><column-value><![CDATA[");
		sb.append(getStaffId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userNote</column-name><column-value><![CDATA[");
		sb.append(getUserNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>XPComputed</column-name><column-value><![CDATA[");
		sb.append(getXPComputed());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CartsDesigners.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			CartsDesigners.class
		};
	private long _cartDesignerId;
	private long _cartId;
	private long _originalCartId;
	private boolean _setOriginalCartId;
	private long _designId;
	private long _originalDesignId;
	private boolean _setOriginalDesignId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _kept;
	private boolean _favorite;
	private String _staffId;
	private String _originalStaffId;
	private String _userNote;
	private boolean _XPComputed;
	private long _columnBitmask;
	private CartsDesigners _escapedModel;
}