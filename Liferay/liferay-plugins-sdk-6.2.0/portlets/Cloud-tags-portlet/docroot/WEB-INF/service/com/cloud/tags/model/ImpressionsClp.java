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
import com.cloud.tags.service.ImpressionsLocalServiceUtil;

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
public class ImpressionsClp extends BaseModelImpl<Impressions>
	implements Impressions {
	public ImpressionsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Impressions.class;
	}

	@Override
	public String getModelClassName() {
		return Impressions.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _recId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRecId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _recId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("recId", getRecId());
		attributes.put("impressionType", getImpressionType());
		attributes.put("impressionId", getImpressionId());
		attributes.put("impressionAction", getImpressionAction());
		attributes.put("ipAddress", getIpAddress());
		attributes.put("deviceType", getDeviceType());
		attributes.put("deviceName", getDeviceName());
		attributes.put("deviceWidth", getDeviceWidth());
		attributes.put("ideviceBrowser", getIdeviceBrowser());
		attributes.put("session_Id", getSession_Id());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("storeDeviceId", getStoreDeviceId());
		attributes.put("staffId", getStaffId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long recId = (Long)attributes.get("recId");

		if (recId != null) {
			setRecId(recId);
		}

		String impressionType = (String)attributes.get("impressionType");

		if (impressionType != null) {
			setImpressionType(impressionType);
		}

		String impressionId = (String)attributes.get("impressionId");

		if (impressionId != null) {
			setImpressionId(impressionId);
		}

		String impressionAction = (String)attributes.get("impressionAction");

		if (impressionAction != null) {
			setImpressionAction(impressionAction);
		}

		String ipAddress = (String)attributes.get("ipAddress");

		if (ipAddress != null) {
			setIpAddress(ipAddress);
		}

		String deviceType = (String)attributes.get("deviceType");

		if (deviceType != null) {
			setDeviceType(deviceType);
		}

		String deviceName = (String)attributes.get("deviceName");

		if (deviceName != null) {
			setDeviceName(deviceName);
		}

		String deviceWidth = (String)attributes.get("deviceWidth");

		if (deviceWidth != null) {
			setDeviceWidth(deviceWidth);
		}

		String ideviceBrowser = (String)attributes.get("ideviceBrowser");

		if (ideviceBrowser != null) {
			setIdeviceBrowser(ideviceBrowser);
		}

		String session_Id = (String)attributes.get("session_Id");

		if (session_Id != null) {
			setSession_Id(session_Id);
		}

		String companyId = (String)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long storeDeviceId = (Long)attributes.get("storeDeviceId");

		if (storeDeviceId != null) {
			setStoreDeviceId(storeDeviceId);
		}

		String staffId = (String)attributes.get("staffId");

		if (staffId != null) {
			setStaffId(staffId);
		}
	}

	@Override
	public long getRecId() {
		return _recId;
	}

	@Override
	public void setRecId(long recId) {
		_recId = recId;

		if (_impressionsRemoteModel != null) {
			try {
				Class<?> clazz = _impressionsRemoteModel.getClass();

				Method method = clazz.getMethod("setRecId", long.class);

				method.invoke(_impressionsRemoteModel, recId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImpressionType() {
		return _impressionType;
	}

	@Override
	public void setImpressionType(String impressionType) {
		_impressionType = impressionType;

		if (_impressionsRemoteModel != null) {
			try {
				Class<?> clazz = _impressionsRemoteModel.getClass();

				Method method = clazz.getMethod("setImpressionType",
						String.class);

				method.invoke(_impressionsRemoteModel, impressionType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImpressionId() {
		return _impressionId;
	}

	@Override
	public void setImpressionId(String impressionId) {
		_impressionId = impressionId;

		if (_impressionsRemoteModel != null) {
			try {
				Class<?> clazz = _impressionsRemoteModel.getClass();

				Method method = clazz.getMethod("setImpressionId", String.class);

				method.invoke(_impressionsRemoteModel, impressionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImpressionAction() {
		return _impressionAction;
	}

	@Override
	public void setImpressionAction(String impressionAction) {
		_impressionAction = impressionAction;

		if (_impressionsRemoteModel != null) {
			try {
				Class<?> clazz = _impressionsRemoteModel.getClass();

				Method method = clazz.getMethod("setImpressionAction",
						String.class);

				method.invoke(_impressionsRemoteModel, impressionAction);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIpAddress() {
		return _ipAddress;
	}

	@Override
	public void setIpAddress(String ipAddress) {
		_ipAddress = ipAddress;

		if (_impressionsRemoteModel != null) {
			try {
				Class<?> clazz = _impressionsRemoteModel.getClass();

				Method method = clazz.getMethod("setIpAddress", String.class);

				method.invoke(_impressionsRemoteModel, ipAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDeviceType() {
		return _deviceType;
	}

	@Override
	public void setDeviceType(String deviceType) {
		_deviceType = deviceType;

		if (_impressionsRemoteModel != null) {
			try {
				Class<?> clazz = _impressionsRemoteModel.getClass();

				Method method = clazz.getMethod("setDeviceType", String.class);

				method.invoke(_impressionsRemoteModel, deviceType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDeviceName() {
		return _deviceName;
	}

	@Override
	public void setDeviceName(String deviceName) {
		_deviceName = deviceName;

		if (_impressionsRemoteModel != null) {
			try {
				Class<?> clazz = _impressionsRemoteModel.getClass();

				Method method = clazz.getMethod("setDeviceName", String.class);

				method.invoke(_impressionsRemoteModel, deviceName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDeviceWidth() {
		return _deviceWidth;
	}

	@Override
	public void setDeviceWidth(String deviceWidth) {
		_deviceWidth = deviceWidth;

		if (_impressionsRemoteModel != null) {
			try {
				Class<?> clazz = _impressionsRemoteModel.getClass();

				Method method = clazz.getMethod("setDeviceWidth", String.class);

				method.invoke(_impressionsRemoteModel, deviceWidth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIdeviceBrowser() {
		return _ideviceBrowser;
	}

	@Override
	public void setIdeviceBrowser(String ideviceBrowser) {
		_ideviceBrowser = ideviceBrowser;

		if (_impressionsRemoteModel != null) {
			try {
				Class<?> clazz = _impressionsRemoteModel.getClass();

				Method method = clazz.getMethod("setIdeviceBrowser",
						String.class);

				method.invoke(_impressionsRemoteModel, ideviceBrowser);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSession_Id() {
		return _session_Id;
	}

	@Override
	public void setSession_Id(String session_Id) {
		_session_Id = session_Id;

		if (_impressionsRemoteModel != null) {
			try {
				Class<?> clazz = _impressionsRemoteModel.getClass();

				Method method = clazz.getMethod("setSession_Id", String.class);

				method.invoke(_impressionsRemoteModel, session_Id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(String companyId) {
		_companyId = companyId;

		if (_impressionsRemoteModel != null) {
			try {
				Class<?> clazz = _impressionsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", String.class);

				method.invoke(_impressionsRemoteModel, companyId);
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

		if (_impressionsRemoteModel != null) {
			try {
				Class<?> clazz = _impressionsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_impressionsRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStoreDeviceId() {
		return _storeDeviceId;
	}

	@Override
	public void setStoreDeviceId(long storeDeviceId) {
		_storeDeviceId = storeDeviceId;

		if (_impressionsRemoteModel != null) {
			try {
				Class<?> clazz = _impressionsRemoteModel.getClass();

				Method method = clazz.getMethod("setStoreDeviceId", long.class);

				method.invoke(_impressionsRemoteModel, storeDeviceId);
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

		if (_impressionsRemoteModel != null) {
			try {
				Class<?> clazz = _impressionsRemoteModel.getClass();

				Method method = clazz.getMethod("setStaffId", String.class);

				method.invoke(_impressionsRemoteModel, staffId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getImpressionsRemoteModel() {
		return _impressionsRemoteModel;
	}

	public void setImpressionsRemoteModel(BaseModel<?> impressionsRemoteModel) {
		_impressionsRemoteModel = impressionsRemoteModel;
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

		Class<?> remoteModelClass = _impressionsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_impressionsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ImpressionsLocalServiceUtil.addImpressions(this);
		}
		else {
			ImpressionsLocalServiceUtil.updateImpressions(this);
		}
	}

	@Override
	public Impressions toEscapedModel() {
		return (Impressions)ProxyUtil.newProxyInstance(Impressions.class.getClassLoader(),
			new Class[] { Impressions.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ImpressionsClp clone = new ImpressionsClp();

		clone.setRecId(getRecId());
		clone.setImpressionType(getImpressionType());
		clone.setImpressionId(getImpressionId());
		clone.setImpressionAction(getImpressionAction());
		clone.setIpAddress(getIpAddress());
		clone.setDeviceType(getDeviceType());
		clone.setDeviceName(getDeviceName());
		clone.setDeviceWidth(getDeviceWidth());
		clone.setIdeviceBrowser(getIdeviceBrowser());
		clone.setSession_Id(getSession_Id());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setStoreDeviceId(getStoreDeviceId());
		clone.setStaffId(getStaffId());

		return clone;
	}

	@Override
	public int compareTo(Impressions impressions) {
		long primaryKey = impressions.getPrimaryKey();

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

		if (!(obj instanceof ImpressionsClp)) {
			return false;
		}

		ImpressionsClp impressions = (ImpressionsClp)obj;

		long primaryKey = impressions.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{recId=");
		sb.append(getRecId());
		sb.append(", impressionType=");
		sb.append(getImpressionType());
		sb.append(", impressionId=");
		sb.append(getImpressionId());
		sb.append(", impressionAction=");
		sb.append(getImpressionAction());
		sb.append(", ipAddress=");
		sb.append(getIpAddress());
		sb.append(", deviceType=");
		sb.append(getDeviceType());
		sb.append(", deviceName=");
		sb.append(getDeviceName());
		sb.append(", deviceWidth=");
		sb.append(getDeviceWidth());
		sb.append(", ideviceBrowser=");
		sb.append(getIdeviceBrowser());
		sb.append(", session_Id=");
		sb.append(getSession_Id());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", storeDeviceId=");
		sb.append(getStoreDeviceId());
		sb.append(", staffId=");
		sb.append(getStaffId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.cloud.tags.model.Impressions");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>recId</column-name><column-value><![CDATA[");
		sb.append(getRecId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>impressionType</column-name><column-value><![CDATA[");
		sb.append(getImpressionType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>impressionId</column-name><column-value><![CDATA[");
		sb.append(getImpressionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>impressionAction</column-name><column-value><![CDATA[");
		sb.append(getImpressionAction());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ipAddress</column-name><column-value><![CDATA[");
		sb.append(getIpAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deviceType</column-name><column-value><![CDATA[");
		sb.append(getDeviceType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deviceName</column-name><column-value><![CDATA[");
		sb.append(getDeviceName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deviceWidth</column-name><column-value><![CDATA[");
		sb.append(getDeviceWidth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ideviceBrowser</column-name><column-value><![CDATA[");
		sb.append(getIdeviceBrowser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>session_Id</column-name><column-value><![CDATA[");
		sb.append(getSession_Id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>storeDeviceId</column-name><column-value><![CDATA[");
		sb.append(getStoreDeviceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staffId</column-name><column-value><![CDATA[");
		sb.append(getStaffId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _recId;
	private String _impressionType;
	private String _impressionId;
	private String _impressionAction;
	private String _ipAddress;
	private String _deviceType;
	private String _deviceName;
	private String _deviceWidth;
	private String _ideviceBrowser;
	private String _session_Id;
	private String _companyId;
	private Date _createDate;
	private long _storeDeviceId;
	private String _staffId;
	private BaseModel<?> _impressionsRemoteModel;
}