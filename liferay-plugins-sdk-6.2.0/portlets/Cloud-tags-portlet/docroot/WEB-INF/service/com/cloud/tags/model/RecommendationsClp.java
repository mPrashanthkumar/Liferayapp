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
import com.cloud.tags.service.RecommendationsLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mohammed Zaheer
 */
public class RecommendationsClp extends BaseModelImpl<Recommendations>
	implements Recommendations {
	public RecommendationsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Recommendations.class;
	}

	@Override
	public String getModelClassName() {
		return Recommendations.class.getName();
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
		attributes.put("designer1", getDesigner1());
		attributes.put("designer2", getDesigner2());
		attributes.put("_type", get_type());
		attributes.put("percentage", getPercentage());
		attributes.put("companyId", getCompanyId());
		attributes.put("color_name", getColor_name());
		attributes.put("color_image", getColor_image());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long recId = (Long)attributes.get("recId");

		if (recId != null) {
			setRecId(recId);
		}

		String designer1 = (String)attributes.get("designer1");

		if (designer1 != null) {
			setDesigner1(designer1);
		}

		String designer2 = (String)attributes.get("designer2");

		if (designer2 != null) {
			setDesigner2(designer2);
		}

		Long _type = (Long)attributes.get("_type");

		if (_type != null) {
			set_type(_type);
		}

		Double percentage = (Double)attributes.get("percentage");

		if (percentage != null) {
			setPercentage(percentage);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String color_name = (String)attributes.get("color_name");

		if (color_name != null) {
			setColor_name(color_name);
		}

		String color_image = (String)attributes.get("color_image");

		if (color_image != null) {
			setColor_image(color_image);
		}
	}

	@Override
	public long getRecId() {
		return _recId;
	}

	@Override
	public void setRecId(long recId) {
		_recId = recId;

		if (_recommendationsRemoteModel != null) {
			try {
				Class<?> clazz = _recommendationsRemoteModel.getClass();

				Method method = clazz.getMethod("setRecId", long.class);

				method.invoke(_recommendationsRemoteModel, recId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDesigner1() {
		return _designer1;
	}

	@Override
	public void setDesigner1(String designer1) {
		_designer1 = designer1;

		if (_recommendationsRemoteModel != null) {
			try {
				Class<?> clazz = _recommendationsRemoteModel.getClass();

				Method method = clazz.getMethod("setDesigner1", String.class);

				method.invoke(_recommendationsRemoteModel, designer1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDesigner2() {
		return _designer2;
	}

	@Override
	public void setDesigner2(String designer2) {
		_designer2 = designer2;

		if (_recommendationsRemoteModel != null) {
			try {
				Class<?> clazz = _recommendationsRemoteModel.getClass();

				Method method = clazz.getMethod("setDesigner2", String.class);

				method.invoke(_recommendationsRemoteModel, designer2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long get_type() {
		return __type;
	}

	@Override
	public void set_type(long _type) {
		__type = _type;

		if (_recommendationsRemoteModel != null) {
			try {
				Class<?> clazz = _recommendationsRemoteModel.getClass();

				Method method = clazz.getMethod("set_type", long.class);

				method.invoke(_recommendationsRemoteModel, _type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getPercentage() {
		return _percentage;
	}

	@Override
	public void setPercentage(double percentage) {
		_percentage = percentage;

		if (_recommendationsRemoteModel != null) {
			try {
				Class<?> clazz = _recommendationsRemoteModel.getClass();

				Method method = clazz.getMethod("setPercentage", double.class);

				method.invoke(_recommendationsRemoteModel, percentage);
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

		if (_recommendationsRemoteModel != null) {
			try {
				Class<?> clazz = _recommendationsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_recommendationsRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColor_name() {
		return _color_name;
	}

	@Override
	public void setColor_name(String color_name) {
		_color_name = color_name;

		if (_recommendationsRemoteModel != null) {
			try {
				Class<?> clazz = _recommendationsRemoteModel.getClass();

				Method method = clazz.getMethod("setColor_name", String.class);

				method.invoke(_recommendationsRemoteModel, color_name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColor_image() {
		return _color_image;
	}

	@Override
	public void setColor_image(String color_image) {
		_color_image = color_image;

		if (_recommendationsRemoteModel != null) {
			try {
				Class<?> clazz = _recommendationsRemoteModel.getClass();

				Method method = clazz.getMethod("setColor_image", String.class);

				method.invoke(_recommendationsRemoteModel, color_image);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getRecommendationsRemoteModel() {
		return _recommendationsRemoteModel;
	}

	public void setRecommendationsRemoteModel(
		BaseModel<?> recommendationsRemoteModel) {
		_recommendationsRemoteModel = recommendationsRemoteModel;
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

		Class<?> remoteModelClass = _recommendationsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_recommendationsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RecommendationsLocalServiceUtil.addRecommendations(this);
		}
		else {
			RecommendationsLocalServiceUtil.updateRecommendations(this);
		}
	}

	@Override
	public Recommendations toEscapedModel() {
		return (Recommendations)ProxyUtil.newProxyInstance(Recommendations.class.getClassLoader(),
			new Class[] { Recommendations.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RecommendationsClp clone = new RecommendationsClp();

		clone.setRecId(getRecId());
		clone.setDesigner1(getDesigner1());
		clone.setDesigner2(getDesigner2());
		clone.set_type(get_type());
		clone.setPercentage(getPercentage());
		clone.setCompanyId(getCompanyId());
		clone.setColor_name(getColor_name());
		clone.setColor_image(getColor_image());

		return clone;
	}

	@Override
	public int compareTo(Recommendations recommendations) {
		long primaryKey = recommendations.getPrimaryKey();

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

		if (!(obj instanceof RecommendationsClp)) {
			return false;
		}

		RecommendationsClp recommendations = (RecommendationsClp)obj;

		long primaryKey = recommendations.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{recId=");
		sb.append(getRecId());
		sb.append(", designer1=");
		sb.append(getDesigner1());
		sb.append(", designer2=");
		sb.append(getDesigner2());
		sb.append(", _type=");
		sb.append(get_type());
		sb.append(", percentage=");
		sb.append(getPercentage());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", color_name=");
		sb.append(getColor_name());
		sb.append(", color_image=");
		sb.append(getColor_image());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.cloud.tags.model.Recommendations");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>recId</column-name><column-value><![CDATA[");
		sb.append(getRecId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>designer1</column-name><column-value><![CDATA[");
		sb.append(getDesigner1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>designer2</column-name><column-value><![CDATA[");
		sb.append(getDesigner2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>_type</column-name><column-value><![CDATA[");
		sb.append(get_type());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>percentage</column-name><column-value><![CDATA[");
		sb.append(getPercentage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>color_name</column-name><column-value><![CDATA[");
		sb.append(getColor_name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>color_image</column-name><column-value><![CDATA[");
		sb.append(getColor_image());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _recId;
	private String _designer1;
	private String _designer2;
	private long __type;
	private double _percentage;
	private long _companyId;
	private String _color_name;
	private String _color_image;
	private BaseModel<?> _recommendationsRemoteModel;
}