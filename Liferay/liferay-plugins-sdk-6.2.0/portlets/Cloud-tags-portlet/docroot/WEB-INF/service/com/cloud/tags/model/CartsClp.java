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

import com.cloud.tags.service.CartsLocalServiceUtil;
import com.cloud.tags.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mohammed Zaheer
 */
public class CartsClp extends BaseModelImpl<Carts> implements Carts {
	public CartsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Carts.class;
	}

	@Override
	public String getModelClassName() {
		return Carts.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _cartId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCartId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cartId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cartId", getCartId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("session_id", getSession_id());
		attributes.put("staffId", getStaffId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cartId = (Long)attributes.get("cartId");

		if (cartId != null) {
			setCartId(cartId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String session_id = (String)attributes.get("session_id");

		if (session_id != null) {
			setSession_id(session_id);
		}

		String staffId = (String)attributes.get("staffId");

		if (staffId != null) {
			setStaffId(staffId);
		}
	}

	@Override
	public long getCartId() {
		return _cartId;
	}

	@Override
	public void setCartId(long cartId) {
		_cartId = cartId;

		if (_cartsRemoteModel != null) {
			try {
				Class<?> clazz = _cartsRemoteModel.getClass();

				Method method = clazz.getMethod("setCartId", long.class);

				method.invoke(_cartsRemoteModel, cartId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_cartsRemoteModel != null) {
			try {
				Class<?> clazz = _cartsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_cartsRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_cartsRemoteModel != null) {
			try {
				Class<?> clazz = _cartsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_cartsRemoteModel, createDate);
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

		if (_cartsRemoteModel != null) {
			try {
				Class<?> clazz = _cartsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_cartsRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSession_id() {
		return _session_id;
	}

	@Override
	public void setSession_id(String session_id) {
		_session_id = session_id;

		if (_cartsRemoteModel != null) {
			try {
				Class<?> clazz = _cartsRemoteModel.getClass();

				Method method = clazz.getMethod("setSession_id", String.class);

				method.invoke(_cartsRemoteModel, session_id);
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

		if (_cartsRemoteModel != null) {
			try {
				Class<?> clazz = _cartsRemoteModel.getClass();

				Method method = clazz.getMethod("setStaffId", String.class);

				method.invoke(_cartsRemoteModel, staffId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCartsRemoteModel() {
		return _cartsRemoteModel;
	}

	public void setCartsRemoteModel(BaseModel<?> cartsRemoteModel) {
		_cartsRemoteModel = cartsRemoteModel;
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

		Class<?> remoteModelClass = _cartsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_cartsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CartsLocalServiceUtil.addCarts(this);
		}
		else {
			CartsLocalServiceUtil.updateCarts(this);
		}
	}

	@Override
	public Carts toEscapedModel() {
		return (Carts)ProxyUtil.newProxyInstance(Carts.class.getClassLoader(),
			new Class[] { Carts.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CartsClp clone = new CartsClp();

		clone.setCartId(getCartId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSession_id(getSession_id());
		clone.setStaffId(getStaffId());

		return clone;
	}

	@Override
	public int compareTo(Carts carts) {
		long primaryKey = carts.getPrimaryKey();

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

		if (!(obj instanceof CartsClp)) {
			return false;
		}

		CartsClp carts = (CartsClp)obj;

		long primaryKey = carts.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{cartId=");
		sb.append(getCartId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", session_id=");
		sb.append(getSession_id());
		sb.append(", staffId=");
		sb.append(getStaffId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.cloud.tags.model.Carts");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>cartId</column-name><column-value><![CDATA[");
		sb.append(getCartId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
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
			"<column><column-name>session_id</column-name><column-value><![CDATA[");
		sb.append(getSession_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staffId</column-name><column-value><![CDATA[");
		sb.append(getStaffId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _cartId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _session_id;
	private String _staffId;
	private BaseModel<?> _cartsRemoteModel;
}