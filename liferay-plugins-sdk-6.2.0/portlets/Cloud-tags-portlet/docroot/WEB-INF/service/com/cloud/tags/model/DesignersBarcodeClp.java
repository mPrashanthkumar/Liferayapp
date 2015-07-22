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
import com.cloud.tags.service.DesignersBarcodeLocalServiceUtil;

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
public class DesignersBarcodeClp extends BaseModelImpl<DesignersBarcode>
	implements DesignersBarcode {
	public DesignersBarcodeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DesignersBarcode.class;
	}

	@Override
	public String getModelClassName() {
		return DesignersBarcode.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _designerBarcodeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDesignerBarcodeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _designerBarcodeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("designerBarcodeId", getDesignerBarcodeId());
		attributes.put("barcodeId", getBarcodeId());
		attributes.put("designId", getDesignId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long designerBarcodeId = (Long)attributes.get("designerBarcodeId");

		if (designerBarcodeId != null) {
			setDesignerBarcodeId(designerBarcodeId);
		}

		Long barcodeId = (Long)attributes.get("barcodeId");

		if (barcodeId != null) {
			setBarcodeId(barcodeId);
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
	}

	@Override
	public long getDesignerBarcodeId() {
		return _designerBarcodeId;
	}

	@Override
	public void setDesignerBarcodeId(long designerBarcodeId) {
		_designerBarcodeId = designerBarcodeId;

		if (_designersBarcodeRemoteModel != null) {
			try {
				Class<?> clazz = _designersBarcodeRemoteModel.getClass();

				Method method = clazz.getMethod("setDesignerBarcodeId",
						long.class);

				method.invoke(_designersBarcodeRemoteModel, designerBarcodeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBarcodeId() {
		return _barcodeId;
	}

	@Override
	public void setBarcodeId(long barcodeId) {
		_barcodeId = barcodeId;

		if (_designersBarcodeRemoteModel != null) {
			try {
				Class<?> clazz = _designersBarcodeRemoteModel.getClass();

				Method method = clazz.getMethod("setBarcodeId", long.class);

				method.invoke(_designersBarcodeRemoteModel, barcodeId);
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

		if (_designersBarcodeRemoteModel != null) {
			try {
				Class<?> clazz = _designersBarcodeRemoteModel.getClass();

				Method method = clazz.getMethod("setDesignId", long.class);

				method.invoke(_designersBarcodeRemoteModel, designId);
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

		if (_designersBarcodeRemoteModel != null) {
			try {
				Class<?> clazz = _designersBarcodeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_designersBarcodeRemoteModel, createDate);
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

		if (_designersBarcodeRemoteModel != null) {
			try {
				Class<?> clazz = _designersBarcodeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_designersBarcodeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDesignersBarcodeRemoteModel() {
		return _designersBarcodeRemoteModel;
	}

	public void setDesignersBarcodeRemoteModel(
		BaseModel<?> designersBarcodeRemoteModel) {
		_designersBarcodeRemoteModel = designersBarcodeRemoteModel;
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

		Class<?> remoteModelClass = _designersBarcodeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_designersBarcodeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DesignersBarcodeLocalServiceUtil.addDesignersBarcode(this);
		}
		else {
			DesignersBarcodeLocalServiceUtil.updateDesignersBarcode(this);
		}
	}

	@Override
	public DesignersBarcode toEscapedModel() {
		return (DesignersBarcode)ProxyUtil.newProxyInstance(DesignersBarcode.class.getClassLoader(),
			new Class[] { DesignersBarcode.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DesignersBarcodeClp clone = new DesignersBarcodeClp();

		clone.setDesignerBarcodeId(getDesignerBarcodeId());
		clone.setBarcodeId(getBarcodeId());
		clone.setDesignId(getDesignId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(DesignersBarcode designersBarcode) {
		long primaryKey = designersBarcode.getPrimaryKey();

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

		if (!(obj instanceof DesignersBarcodeClp)) {
			return false;
		}

		DesignersBarcodeClp designersBarcode = (DesignersBarcodeClp)obj;

		long primaryKey = designersBarcode.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{designerBarcodeId=");
		sb.append(getDesignerBarcodeId());
		sb.append(", barcodeId=");
		sb.append(getBarcodeId());
		sb.append(", designId=");
		sb.append(getDesignId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.cloud.tags.model.DesignersBarcode");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>designerBarcodeId</column-name><column-value><![CDATA[");
		sb.append(getDesignerBarcodeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>barcodeId</column-name><column-value><![CDATA[");
		sb.append(getBarcodeId());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _designerBarcodeId;
	private long _barcodeId;
	private long _designId;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _designersBarcodeRemoteModel;
}