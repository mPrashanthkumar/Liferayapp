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
import com.cloud.tags.service.CustomerImagesLocalServiceUtil;

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
public class CustomerImagesClp extends BaseModelImpl<CustomerImages>
	implements CustomerImages {
	public CustomerImagesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CustomerImages.class;
	}

	@Override
	public String getModelClassName() {
		return CustomerImages.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _customerImageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCustomerImageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _customerImageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("customerImageId", getCustomerImageId());
		attributes.put("designerSKU", getDesignerSKU());
		attributes.put("designerCusImage", getDesignerCusImage());
		attributes.put("customerImage", getCustomerImage());
		attributes.put("customerName", getCustomerName());
		attributes.put("customerAddress", getCustomerAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long customerImageId = (Long)attributes.get("customerImageId");

		if (customerImageId != null) {
			setCustomerImageId(customerImageId);
		}

		String designerSKU = (String)attributes.get("designerSKU");

		if (designerSKU != null) {
			setDesignerSKU(designerSKU);
		}

		String designerCusImage = (String)attributes.get("designerCusImage");

		if (designerCusImage != null) {
			setDesignerCusImage(designerCusImage);
		}

		String customerImage = (String)attributes.get("customerImage");

		if (customerImage != null) {
			setCustomerImage(customerImage);
		}

		String customerName = (String)attributes.get("customerName");

		if (customerName != null) {
			setCustomerName(customerName);
		}

		String customerAddress = (String)attributes.get("customerAddress");

		if (customerAddress != null) {
			setCustomerAddress(customerAddress);
		}
	}

	@Override
	public long getCustomerImageId() {
		return _customerImageId;
	}

	@Override
	public void setCustomerImageId(long customerImageId) {
		_customerImageId = customerImageId;

		if (_customerImagesRemoteModel != null) {
			try {
				Class<?> clazz = _customerImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerImageId", long.class);

				method.invoke(_customerImagesRemoteModel, customerImageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDesignerSKU() {
		return _designerSKU;
	}

	@Override
	public void setDesignerSKU(String designerSKU) {
		_designerSKU = designerSKU;

		if (_customerImagesRemoteModel != null) {
			try {
				Class<?> clazz = _customerImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setDesignerSKU", String.class);

				method.invoke(_customerImagesRemoteModel, designerSKU);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDesignerCusImage() {
		return _designerCusImage;
	}

	@Override
	public void setDesignerCusImage(String designerCusImage) {
		_designerCusImage = designerCusImage;

		if (_customerImagesRemoteModel != null) {
			try {
				Class<?> clazz = _customerImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setDesignerCusImage",
						String.class);

				method.invoke(_customerImagesRemoteModel, designerCusImage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomerImage() {
		return _customerImage;
	}

	@Override
	public void setCustomerImage(String customerImage) {
		_customerImage = customerImage;

		if (_customerImagesRemoteModel != null) {
			try {
				Class<?> clazz = _customerImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerImage", String.class);

				method.invoke(_customerImagesRemoteModel, customerImage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomerName() {
		return _customerName;
	}

	@Override
	public void setCustomerName(String customerName) {
		_customerName = customerName;

		if (_customerImagesRemoteModel != null) {
			try {
				Class<?> clazz = _customerImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerName", String.class);

				method.invoke(_customerImagesRemoteModel, customerName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomerAddress() {
		return _customerAddress;
	}

	@Override
	public void setCustomerAddress(String customerAddress) {
		_customerAddress = customerAddress;

		if (_customerImagesRemoteModel != null) {
			try {
				Class<?> clazz = _customerImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerAddress",
						String.class);

				method.invoke(_customerImagesRemoteModel, customerAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCustomerImagesRemoteModel() {
		return _customerImagesRemoteModel;
	}

	public void setCustomerImagesRemoteModel(
		BaseModel<?> customerImagesRemoteModel) {
		_customerImagesRemoteModel = customerImagesRemoteModel;
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

		Class<?> remoteModelClass = _customerImagesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_customerImagesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CustomerImagesLocalServiceUtil.addCustomerImages(this);
		}
		else {
			CustomerImagesLocalServiceUtil.updateCustomerImages(this);
		}
	}

	@Override
	public CustomerImages toEscapedModel() {
		return (CustomerImages)ProxyUtil.newProxyInstance(CustomerImages.class.getClassLoader(),
			new Class[] { CustomerImages.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CustomerImagesClp clone = new CustomerImagesClp();

		clone.setCustomerImageId(getCustomerImageId());
		clone.setDesignerSKU(getDesignerSKU());
		clone.setDesignerCusImage(getDesignerCusImage());
		clone.setCustomerImage(getCustomerImage());
		clone.setCustomerName(getCustomerName());
		clone.setCustomerAddress(getCustomerAddress());

		return clone;
	}

	@Override
	public int compareTo(CustomerImages customerImages) {
		long primaryKey = customerImages.getPrimaryKey();

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

		if (!(obj instanceof CustomerImagesClp)) {
			return false;
		}

		CustomerImagesClp customerImages = (CustomerImagesClp)obj;

		long primaryKey = customerImages.getPrimaryKey();

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

		sb.append("{customerImageId=");
		sb.append(getCustomerImageId());
		sb.append(", designerSKU=");
		sb.append(getDesignerSKU());
		sb.append(", designerCusImage=");
		sb.append(getDesignerCusImage());
		sb.append(", customerImage=");
		sb.append(getCustomerImage());
		sb.append(", customerName=");
		sb.append(getCustomerName());
		sb.append(", customerAddress=");
		sb.append(getCustomerAddress());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.cloud.tags.model.CustomerImages");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>customerImageId</column-name><column-value><![CDATA[");
		sb.append(getCustomerImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>designerSKU</column-name><column-value><![CDATA[");
		sb.append(getDesignerSKU());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>designerCusImage</column-name><column-value><![CDATA[");
		sb.append(getDesignerCusImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customerImage</column-name><column-value><![CDATA[");
		sb.append(getCustomerImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customerName</column-name><column-value><![CDATA[");
		sb.append(getCustomerName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customerAddress</column-name><column-value><![CDATA[");
		sb.append(getCustomerAddress());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _customerImageId;
	private String _designerSKU;
	private String _designerCusImage;
	private String _customerImage;
	private String _customerName;
	private String _customerAddress;
	private BaseModel<?> _customerImagesRemoteModel;
}