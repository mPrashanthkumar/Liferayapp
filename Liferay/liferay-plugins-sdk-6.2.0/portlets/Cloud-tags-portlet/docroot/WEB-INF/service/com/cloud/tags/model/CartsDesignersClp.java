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

package com.cloud.tags.model;

import com.cloud.tags.service.CartsDesignersLocalServiceUtil;
import com.cloud.tags.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mohammed Zaheer
 */
public class CartsDesignersClp extends BaseModelImpl<CartsDesigners>
	implements CartsDesigners {
	public CartsDesignersClp() {
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

		if (_cartsDesignersRemoteModel != null) {
			try {
				Class<?> clazz = _cartsDesignersRemoteModel.getClass();

				Method method = clazz.getMethod("setCartDesignerId", long.class);

				method.invoke(_cartsDesignersRemoteModel, cartDesignerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCartId() {
		return _cartId;
	}

	@Override
	public void setCartId(long cartId) {
		_cartId = cartId;

		if (_cartsDesignersRemoteModel != null) {
			try {
				Class<?> clazz = _cartsDesignersRemoteModel.getClass();

				Method method = clazz.getMethod("setCartId", long.class);

				method.invoke(_cartsDesignersRemoteModel, cartId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDesignId() {
		return _designId;
	}

	@Override
	public void setDesignId(long designId) {
		_designId = designId;

		if (_cartsDesignersRemoteModel != null) {
			try {
				Class<?> clazz = _cartsDesignersRemoteModel.getClass();

				Method method = clazz.getMethod("setDesignId", long.class);

				method.invoke(_cartsDesignersRemoteModel, designId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_cartsDesignersRemoteModel != null) {
			try {
				Class<?> clazz = _cartsDesignersRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_cartsDesignersRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_cartsDesignersRemoteModel != null) {
			try {
				Class<?> clazz = _cartsDesignersRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_cartsDesignersRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
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

		if (_cartsDesignersRemoteModel != null) {
			try {
				Class<?> clazz = _cartsDesignersRemoteModel.getClass();

				Method method = clazz.getMethod("setKept", boolean.class);

				method.invoke(_cartsDesignersRemoteModel, kept);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
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

		if (_cartsDesignersRemoteModel != null) {
			try {
				Class<?> clazz = _cartsDesignersRemoteModel.getClass();

				Method method = clazz.getMethod("setFavorite", boolean.class);

				method.invoke(_cartsDesignersRemoteModel, favorite);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStaffId() {
		return _staffId;
	}

	@Override
	public void setStaffId(String staffId) {
		_staffId = staffId;

		if (_cartsDesignersRemoteModel != null) {
			try {
				Class<?> clazz = _cartsDesignersRemoteModel.getClass();

				Method method = clazz.getMethod("setStaffId", String.class);

				method.invoke(_cartsDesignersRemoteModel, staffId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserNote() {
		return _userNote;
	}

	@Override
	public void setUserNote(String userNote) {
		_userNote = userNote;

		if (_cartsDesignersRemoteModel != null) {
			try {
				Class<?> clazz = _cartsDesignersRemoteModel.getClass();

				Method method = clazz.getMethod("setUserNote", String.class);

				method.invoke(_cartsDesignersRemoteModel, userNote);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
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

		if (_cartsDesignersRemoteModel != null) {
			try {
				Class<?> clazz = _cartsDesignersRemoteModel.getClass();

				Method method = clazz.getMethod("setXPComputed", boolean.class);

				method.invoke(_cartsDesignersRemoteModel, XPComputed);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCartsDesignersRemoteModel() {
		return _cartsDesignersRemoteModel;
	}

	public void setCartsDesignersRemoteModel(
		BaseModel<?> cartsDesignersRemoteModel) {
		_cartsDesignersRemoteModel = cartsDesignersRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _cartsDesignersRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_cartsDesignersRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CartsDesignersLocalServiceUtil.addCartsDesigners(this);
		}
		else {
			CartsDesignersLocalServiceUtil.updateCartsDesigners(this);
		}
	}

	@Override
	public CartsDesigners toEscapedModel() {
		return (CartsDesigners)ProxyUtil.newProxyInstance(CartsDesigners.class.getClassLoader(),
			new Class[] { CartsDesigners.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CartsDesignersClp clone = new CartsDesignersClp();

		clone.setCartDesignerId(getCartDesignerId());
		clone.setCartId(getCartId());
		clone.setDesignId(getDesignId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setKept(getKept());
		clone.setFavorite(getFavorite());
		clone.setStaffId(getStaffId());
		clone.setUserNote(getUserNote());
		clone.setXPComputed(getXPComputed());

		return clone;
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

		if (!(obj instanceof CartsDesignersClp)) {
			return false;
		}

		CartsDesignersClp cartsDesigners = (CartsDesignersClp)obj;

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

	private long _cartDesignerId;
	private long _cartId;
	private long _designId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _kept;
	private boolean _favorite;
	private String _staffId;
	private String _userNote;
	private boolean _XPComputed;
	private BaseModel<?> _cartsDesignersRemoteModel;
}