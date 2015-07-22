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
import com.cloud.tags.service.DesignersImagesLocalServiceUtil;

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
public class DesignersImagesClp extends BaseModelImpl<DesignersImages>
	implements DesignersImages {
	public DesignersImagesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DesignersImages.class;
	}

	@Override
	public String getModelClassName() {
		return DesignersImages.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _designImageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDesignImageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _designImageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("designImageId", getDesignImageId());
		attributes.put("designId", getDesignId());
		attributes.put("entity_image1", getEntity_image1());
		attributes.put("entity_image2", getEntity_image2());
		attributes.put("entity_image3", getEntity_image3());
		attributes.put("entity_image4", getEntity_image4());
		attributes.put("entity_image5", getEntity_image5());
		attributes.put("entity_image6", getEntity_image6());
		attributes.put("entity_image7", getEntity_image7());
		attributes.put("entity_image8", getEntity_image8());
		attributes.put("entity_image9", getEntity_image9());
		attributes.put("entity_image10", getEntity_image10());
		attributes.put("large_image_url", getLarge_image_url());
		attributes.put("small_image_url", getSmall_image_url());
		attributes.put("profile_image_url", getProfile_image_url());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long designImageId = (Long)attributes.get("designImageId");

		if (designImageId != null) {
			setDesignImageId(designImageId);
		}

		Long designId = (Long)attributes.get("designId");

		if (designId != null) {
			setDesignId(designId);
		}

		String entity_image1 = (String)attributes.get("entity_image1");

		if (entity_image1 != null) {
			setEntity_image1(entity_image1);
		}

		String entity_image2 = (String)attributes.get("entity_image2");

		if (entity_image2 != null) {
			setEntity_image2(entity_image2);
		}

		String entity_image3 = (String)attributes.get("entity_image3");

		if (entity_image3 != null) {
			setEntity_image3(entity_image3);
		}

		String entity_image4 = (String)attributes.get("entity_image4");

		if (entity_image4 != null) {
			setEntity_image4(entity_image4);
		}

		String entity_image5 = (String)attributes.get("entity_image5");

		if (entity_image5 != null) {
			setEntity_image5(entity_image5);
		}

		String entity_image6 = (String)attributes.get("entity_image6");

		if (entity_image6 != null) {
			setEntity_image6(entity_image6);
		}

		String entity_image7 = (String)attributes.get("entity_image7");

		if (entity_image7 != null) {
			setEntity_image7(entity_image7);
		}

		String entity_image8 = (String)attributes.get("entity_image8");

		if (entity_image8 != null) {
			setEntity_image8(entity_image8);
		}

		String entity_image9 = (String)attributes.get("entity_image9");

		if (entity_image9 != null) {
			setEntity_image9(entity_image9);
		}

		String entity_image10 = (String)attributes.get("entity_image10");

		if (entity_image10 != null) {
			setEntity_image10(entity_image10);
		}

		String large_image_url = (String)attributes.get("large_image_url");

		if (large_image_url != null) {
			setLarge_image_url(large_image_url);
		}

		String small_image_url = (String)attributes.get("small_image_url");

		if (small_image_url != null) {
			setSmall_image_url(small_image_url);
		}

		String profile_image_url = (String)attributes.get("profile_image_url");

		if (profile_image_url != null) {
			setProfile_image_url(profile_image_url);
		}
	}

	@Override
	public long getDesignImageId() {
		return _designImageId;
	}

	@Override
	public void setDesignImageId(long designImageId) {
		_designImageId = designImageId;

		if (_designersImagesRemoteModel != null) {
			try {
				Class<?> clazz = _designersImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setDesignImageId", long.class);

				method.invoke(_designersImagesRemoteModel, designImageId);
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

		if (_designersImagesRemoteModel != null) {
			try {
				Class<?> clazz = _designersImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setDesignId", long.class);

				method.invoke(_designersImagesRemoteModel, designId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEntity_image1() {
		return _entity_image1;
	}

	@Override
	public void setEntity_image1(String entity_image1) {
		_entity_image1 = entity_image1;

		if (_designersImagesRemoteModel != null) {
			try {
				Class<?> clazz = _designersImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setEntity_image1", String.class);

				method.invoke(_designersImagesRemoteModel, entity_image1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEntity_image2() {
		return _entity_image2;
	}

	@Override
	public void setEntity_image2(String entity_image2) {
		_entity_image2 = entity_image2;

		if (_designersImagesRemoteModel != null) {
			try {
				Class<?> clazz = _designersImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setEntity_image2", String.class);

				method.invoke(_designersImagesRemoteModel, entity_image2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEntity_image3() {
		return _entity_image3;
	}

	@Override
	public void setEntity_image3(String entity_image3) {
		_entity_image3 = entity_image3;

		if (_designersImagesRemoteModel != null) {
			try {
				Class<?> clazz = _designersImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setEntity_image3", String.class);

				method.invoke(_designersImagesRemoteModel, entity_image3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEntity_image4() {
		return _entity_image4;
	}

	@Override
	public void setEntity_image4(String entity_image4) {
		_entity_image4 = entity_image4;

		if (_designersImagesRemoteModel != null) {
			try {
				Class<?> clazz = _designersImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setEntity_image4", String.class);

				method.invoke(_designersImagesRemoteModel, entity_image4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEntity_image5() {
		return _entity_image5;
	}

	@Override
	public void setEntity_image5(String entity_image5) {
		_entity_image5 = entity_image5;

		if (_designersImagesRemoteModel != null) {
			try {
				Class<?> clazz = _designersImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setEntity_image5", String.class);

				method.invoke(_designersImagesRemoteModel, entity_image5);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEntity_image6() {
		return _entity_image6;
	}

	@Override
	public void setEntity_image6(String entity_image6) {
		_entity_image6 = entity_image6;

		if (_designersImagesRemoteModel != null) {
			try {
				Class<?> clazz = _designersImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setEntity_image6", String.class);

				method.invoke(_designersImagesRemoteModel, entity_image6);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEntity_image7() {
		return _entity_image7;
	}

	@Override
	public void setEntity_image7(String entity_image7) {
		_entity_image7 = entity_image7;

		if (_designersImagesRemoteModel != null) {
			try {
				Class<?> clazz = _designersImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setEntity_image7", String.class);

				method.invoke(_designersImagesRemoteModel, entity_image7);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEntity_image8() {
		return _entity_image8;
	}

	@Override
	public void setEntity_image8(String entity_image8) {
		_entity_image8 = entity_image8;

		if (_designersImagesRemoteModel != null) {
			try {
				Class<?> clazz = _designersImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setEntity_image8", String.class);

				method.invoke(_designersImagesRemoteModel, entity_image8);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEntity_image9() {
		return _entity_image9;
	}

	@Override
	public void setEntity_image9(String entity_image9) {
		_entity_image9 = entity_image9;

		if (_designersImagesRemoteModel != null) {
			try {
				Class<?> clazz = _designersImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setEntity_image9", String.class);

				method.invoke(_designersImagesRemoteModel, entity_image9);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEntity_image10() {
		return _entity_image10;
	}

	@Override
	public void setEntity_image10(String entity_image10) {
		_entity_image10 = entity_image10;

		if (_designersImagesRemoteModel != null) {
			try {
				Class<?> clazz = _designersImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setEntity_image10",
						String.class);

				method.invoke(_designersImagesRemoteModel, entity_image10);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLarge_image_url() {
		return _large_image_url;
	}

	@Override
	public void setLarge_image_url(String large_image_url) {
		_large_image_url = large_image_url;

		if (_designersImagesRemoteModel != null) {
			try {
				Class<?> clazz = _designersImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setLarge_image_url",
						String.class);

				method.invoke(_designersImagesRemoteModel, large_image_url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSmall_image_url() {
		return _small_image_url;
	}

	@Override
	public void setSmall_image_url(String small_image_url) {
		_small_image_url = small_image_url;

		if (_designersImagesRemoteModel != null) {
			try {
				Class<?> clazz = _designersImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setSmall_image_url",
						String.class);

				method.invoke(_designersImagesRemoteModel, small_image_url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProfile_image_url() {
		return _profile_image_url;
	}

	@Override
	public void setProfile_image_url(String profile_image_url) {
		_profile_image_url = profile_image_url;

		if (_designersImagesRemoteModel != null) {
			try {
				Class<?> clazz = _designersImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setProfile_image_url",
						String.class);

				method.invoke(_designersImagesRemoteModel, profile_image_url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDesignersImagesRemoteModel() {
		return _designersImagesRemoteModel;
	}

	public void setDesignersImagesRemoteModel(
		BaseModel<?> designersImagesRemoteModel) {
		_designersImagesRemoteModel = designersImagesRemoteModel;
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

		Class<?> remoteModelClass = _designersImagesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_designersImagesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DesignersImagesLocalServiceUtil.addDesignersImages(this);
		}
		else {
			DesignersImagesLocalServiceUtil.updateDesignersImages(this);
		}
	}

	@Override
	public DesignersImages toEscapedModel() {
		return (DesignersImages)ProxyUtil.newProxyInstance(DesignersImages.class.getClassLoader(),
			new Class[] { DesignersImages.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DesignersImagesClp clone = new DesignersImagesClp();

		clone.setDesignImageId(getDesignImageId());
		clone.setDesignId(getDesignId());
		clone.setEntity_image1(getEntity_image1());
		clone.setEntity_image2(getEntity_image2());
		clone.setEntity_image3(getEntity_image3());
		clone.setEntity_image4(getEntity_image4());
		clone.setEntity_image5(getEntity_image5());
		clone.setEntity_image6(getEntity_image6());
		clone.setEntity_image7(getEntity_image7());
		clone.setEntity_image8(getEntity_image8());
		clone.setEntity_image9(getEntity_image9());
		clone.setEntity_image10(getEntity_image10());
		clone.setLarge_image_url(getLarge_image_url());
		clone.setSmall_image_url(getSmall_image_url());
		clone.setProfile_image_url(getProfile_image_url());

		return clone;
	}

	@Override
	public int compareTo(DesignersImages designersImages) {
		long primaryKey = designersImages.getPrimaryKey();

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

		if (!(obj instanceof DesignersImagesClp)) {
			return false;
		}

		DesignersImagesClp designersImages = (DesignersImagesClp)obj;

		long primaryKey = designersImages.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{designImageId=");
		sb.append(getDesignImageId());
		sb.append(", designId=");
		sb.append(getDesignId());
		sb.append(", entity_image1=");
		sb.append(getEntity_image1());
		sb.append(", entity_image2=");
		sb.append(getEntity_image2());
		sb.append(", entity_image3=");
		sb.append(getEntity_image3());
		sb.append(", entity_image4=");
		sb.append(getEntity_image4());
		sb.append(", entity_image5=");
		sb.append(getEntity_image5());
		sb.append(", entity_image6=");
		sb.append(getEntity_image6());
		sb.append(", entity_image7=");
		sb.append(getEntity_image7());
		sb.append(", entity_image8=");
		sb.append(getEntity_image8());
		sb.append(", entity_image9=");
		sb.append(getEntity_image9());
		sb.append(", entity_image10=");
		sb.append(getEntity_image10());
		sb.append(", large_image_url=");
		sb.append(getLarge_image_url());
		sb.append(", small_image_url=");
		sb.append(getSmall_image_url());
		sb.append(", profile_image_url=");
		sb.append(getProfile_image_url());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.cloud.tags.model.DesignersImages");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>designImageId</column-name><column-value><![CDATA[");
		sb.append(getDesignImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>designId</column-name><column-value><![CDATA[");
		sb.append(getDesignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entity_image1</column-name><column-value><![CDATA[");
		sb.append(getEntity_image1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entity_image2</column-name><column-value><![CDATA[");
		sb.append(getEntity_image2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entity_image3</column-name><column-value><![CDATA[");
		sb.append(getEntity_image3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entity_image4</column-name><column-value><![CDATA[");
		sb.append(getEntity_image4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entity_image5</column-name><column-value><![CDATA[");
		sb.append(getEntity_image5());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entity_image6</column-name><column-value><![CDATA[");
		sb.append(getEntity_image6());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entity_image7</column-name><column-value><![CDATA[");
		sb.append(getEntity_image7());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entity_image8</column-name><column-value><![CDATA[");
		sb.append(getEntity_image8());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entity_image9</column-name><column-value><![CDATA[");
		sb.append(getEntity_image9());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entity_image10</column-name><column-value><![CDATA[");
		sb.append(getEntity_image10());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>large_image_url</column-name><column-value><![CDATA[");
		sb.append(getLarge_image_url());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>small_image_url</column-name><column-value><![CDATA[");
		sb.append(getSmall_image_url());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>profile_image_url</column-name><column-value><![CDATA[");
		sb.append(getProfile_image_url());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _designImageId;
	private long _designId;
	private String _entity_image1;
	private String _entity_image2;
	private String _entity_image3;
	private String _entity_image4;
	private String _entity_image5;
	private String _entity_image6;
	private String _entity_image7;
	private String _entity_image8;
	private String _entity_image9;
	private String _entity_image10;
	private String _large_image_url;
	private String _small_image_url;
	private String _profile_image_url;
	private BaseModel<?> _designersImagesRemoteModel;
}