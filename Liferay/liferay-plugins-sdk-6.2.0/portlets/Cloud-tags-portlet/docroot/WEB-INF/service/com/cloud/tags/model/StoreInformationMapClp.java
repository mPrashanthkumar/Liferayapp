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
import com.cloud.tags.service.StoreInformationMapLocalServiceUtil;

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
public class StoreInformationMapClp extends BaseModelImpl<StoreInformationMap>
	implements StoreInformationMap {
	public StoreInformationMapClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StoreInformationMap.class;
	}

	@Override
	public String getModelClassName() {
		return StoreInformationMap.class.getName();
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
		attributes.put("Name", getName());
		attributes.put("Address", getAddress());
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

		String Name = (String)attributes.get("Name");

		if (Name != null) {
			setName(Name);
		}

		String Address = (String)attributes.get("Address");

		if (Address != null) {
			setAddress(Address);
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

		if (_storeInformationMapRemoteModel != null) {
			try {
				Class<?> clazz = _storeInformationMapRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", long.class);

				method.invoke(_storeInformationMapRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _Name;
	}

	@Override
	public void setName(String Name) {
		_Name = Name;

		if (_storeInformationMapRemoteModel != null) {
			try {
				Class<?> clazz = _storeInformationMapRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_storeInformationMapRemoteModel, Name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddress() {
		return _Address;
	}

	@Override
	public void setAddress(String Address) {
		_Address = Address;

		if (_storeInformationMapRemoteModel != null) {
			try {
				Class<?> clazz = _storeInformationMapRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress", String.class);

				method.invoke(_storeInformationMapRemoteModel, Address);
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

		if (_storeInformationMapRemoteModel != null) {
			try {
				Class<?> clazz = _storeInformationMapRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_storeInformationMapRemoteModel, companyId);
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

		if (_storeInformationMapRemoteModel != null) {
			try {
				Class<?> clazz = _storeInformationMapRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_storeInformationMapRemoteModel, groupId);
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

		if (_storeInformationMapRemoteModel != null) {
			try {
				Class<?> clazz = _storeInformationMapRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_storeInformationMapRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStoreInformationMapRemoteModel() {
		return _storeInformationMapRemoteModel;
	}

	public void setStoreInformationMapRemoteModel(
		BaseModel<?> storeInformationMapRemoteModel) {
		_storeInformationMapRemoteModel = storeInformationMapRemoteModel;
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

		Class<?> remoteModelClass = _storeInformationMapRemoteModel.getClass();

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

		Object returnValue = method.invoke(_storeInformationMapRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StoreInformationMapLocalServiceUtil.addStoreInformationMap(this);
		}
		else {
			StoreInformationMapLocalServiceUtil.updateStoreInformationMap(this);
		}
	}

	@Override
	public StoreInformationMap toEscapedModel() {
		return (StoreInformationMap)ProxyUtil.newProxyInstance(StoreInformationMap.class.getClassLoader(),
			new Class[] { StoreInformationMap.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StoreInformationMapClp clone = new StoreInformationMapClp();

		clone.setUuid(getUuid());
		clone.setName(getName());
		clone.setAddress(getAddress());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(StoreInformationMap storeInformationMap) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				storeInformationMap.getCreateDate());

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

		if (!(obj instanceof StoreInformationMapClp)) {
			return false;
		}

		StoreInformationMapClp storeInformationMap = (StoreInformationMapClp)obj;

		long primaryKey = storeInformationMap.getPrimaryKey();

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

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", Name=");
		sb.append(getName());
		sb.append(", Address=");
		sb.append(getAddress());
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
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.cloud.tags.model.StoreInformationMap");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
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
	private String _Name;
	private String _Address;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private BaseModel<?> _storeInformationMapRemoteModel;
}