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

import com.cloud.tags.service.ClpSerializer;
import com.cloud.tags.service.StoreDeviceMapLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
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
public class StoreDeviceMapClp extends BaseModelImpl<StoreDeviceMap>
	implements StoreDeviceMap {
	public StoreDeviceMapClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StoreDeviceMap.class;
	}

	@Override
	public String getModelClassName() {
		return StoreDeviceMap.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _uuid;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUuid(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _uuid;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("storeName", getStoreName());
		attributes.put("deviceMacAddress", getDeviceMacAddress());
		attributes.put("storeId", getStoreId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long uuid = (Long)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String storeName = (String)attributes.get("storeName");

		if (storeName != null) {
			setStoreName(storeName);
		}

		String deviceMacAddress = (String)attributes.get("deviceMacAddress");

		if (deviceMacAddress != null) {
			setDeviceMacAddress(deviceMacAddress);
		}

		Long storeId = (Long)attributes.get("storeId");

		if (storeId != null) {
			setStoreId(storeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public long getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(long uuid) {
		_uuid = uuid;

		if (_storeDeviceMapRemoteModel != null) {
			try {
				Class<?> clazz = _storeDeviceMapRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", long.class);

				method.invoke(_storeDeviceMapRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStoreName() {
		return _storeName;
	}

	@Override
	public void setStoreName(String storeName) {
		_storeName = storeName;

		if (_storeDeviceMapRemoteModel != null) {
			try {
				Class<?> clazz = _storeDeviceMapRemoteModel.getClass();

				Method method = clazz.getMethod("setStoreName", String.class);

				method.invoke(_storeDeviceMapRemoteModel, storeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDeviceMacAddress() {
		return _deviceMacAddress;
	}

	@Override
	public void setDeviceMacAddress(String deviceMacAddress) {
		_deviceMacAddress = deviceMacAddress;

		if (_storeDeviceMapRemoteModel != null) {
			try {
				Class<?> clazz = _storeDeviceMapRemoteModel.getClass();

				Method method = clazz.getMethod("setDeviceMacAddress",
						String.class);

				method.invoke(_storeDeviceMapRemoteModel, deviceMacAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStoreId() {
		return _storeId;
	}

	@Override
	public void setStoreId(long storeId) {
		_storeId = storeId;

		if (_storeDeviceMapRemoteModel != null) {
			try {
				Class<?> clazz = _storeDeviceMapRemoteModel.getClass();

				Method method = clazz.getMethod("setStoreId", long.class);

				method.invoke(_storeDeviceMapRemoteModel, storeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_storeDeviceMapRemoteModel != null) {
			try {
				Class<?> clazz = _storeDeviceMapRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_storeDeviceMapRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_storeDeviceMapRemoteModel != null) {
			try {
				Class<?> clazz = _storeDeviceMapRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_storeDeviceMapRemoteModel, groupId);
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

		if (_storeDeviceMapRemoteModel != null) {
			try {
				Class<?> clazz = _storeDeviceMapRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_storeDeviceMapRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStoreDeviceMapRemoteModel() {
		return _storeDeviceMapRemoteModel;
	}

	public void setStoreDeviceMapRemoteModel(
		BaseModel<?> storeDeviceMapRemoteModel) {
		_storeDeviceMapRemoteModel = storeDeviceMapRemoteModel;
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

		Class<?> remoteModelClass = _storeDeviceMapRemoteModel.getClass();

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

		Object returnValue = method.invoke(_storeDeviceMapRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StoreDeviceMapLocalServiceUtil.addStoreDeviceMap(this);
		}
		else {
			StoreDeviceMapLocalServiceUtil.updateStoreDeviceMap(this);
		}
	}

	@Override
	public StoreDeviceMap toEscapedModel() {
		return (StoreDeviceMap)ProxyUtil.newProxyInstance(StoreDeviceMap.class.getClassLoader(),
			new Class[] { StoreDeviceMap.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StoreDeviceMapClp clone = new StoreDeviceMapClp();

		clone.setUuid(getUuid());
		clone.setStoreName(getStoreName());
		clone.setDeviceMacAddress(getDeviceMacAddress());
		clone.setStoreId(getStoreId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(StoreDeviceMap storeDeviceMap) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				storeDeviceMap.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StoreDeviceMapClp)) {
			return false;
		}

		StoreDeviceMapClp storeDeviceMap = (StoreDeviceMapClp)obj;

		long primaryKey = storeDeviceMap.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", storeName=");
		sb.append(getStoreName());
		sb.append(", deviceMacAddress=");
		sb.append(getDeviceMacAddress());
		sb.append(", storeId=");
		sb.append(getStoreId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.cloud.tags.model.StoreDeviceMap");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>storeName</column-name><column-value><![CDATA[");
		sb.append(getStoreName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deviceMacAddress</column-name><column-value><![CDATA[");
		sb.append(getDeviceMacAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>storeId</column-name><column-value><![CDATA[");
		sb.append(getStoreId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _uuid;
	private String _storeName;
	private String _deviceMacAddress;
	private long _storeId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private BaseModel<?> _storeDeviceMapRemoteModel;
}