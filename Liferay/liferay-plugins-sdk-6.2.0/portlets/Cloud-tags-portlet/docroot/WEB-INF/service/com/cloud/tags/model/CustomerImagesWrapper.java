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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CustomerImages}.
 * </p>
 *
 * @author Mohammed Zaheer
 * @see CustomerImages
 * @generated
 */
public class CustomerImagesWrapper implements CustomerImages,
	ModelWrapper<CustomerImages> {
	public CustomerImagesWrapper(CustomerImages customerImages) {
		_customerImages = customerImages;
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

	/**
	* Returns the primary key of this customer images.
	*
	* @return the primary key of this customer images
	*/
	@Override
	public long getPrimaryKey() {
		return _customerImages.getPrimaryKey();
	}

	/**
	* Sets the primary key of this customer images.
	*
	* @param primaryKey the primary key of this customer images
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_customerImages.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the customer image ID of this customer images.
	*
	* @return the customer image ID of this customer images
	*/
	@Override
	public long getCustomerImageId() {
		return _customerImages.getCustomerImageId();
	}

	/**
	* Sets the customer image ID of this customer images.
	*
	* @param customerImageId the customer image ID of this customer images
	*/
	@Override
	public void setCustomerImageId(long customerImageId) {
		_customerImages.setCustomerImageId(customerImageId);
	}

	/**
	* Returns the designer s k u of this customer images.
	*
	* @return the designer s k u of this customer images
	*/
	@Override
	public java.lang.String getDesignerSKU() {
		return _customerImages.getDesignerSKU();
	}

	/**
	* Sets the designer s k u of this customer images.
	*
	* @param designerSKU the designer s k u of this customer images
	*/
	@Override
	public void setDesignerSKU(java.lang.String designerSKU) {
		_customerImages.setDesignerSKU(designerSKU);
	}

	/**
	* Returns the designer cus image of this customer images.
	*
	* @return the designer cus image of this customer images
	*/
	@Override
	public java.lang.String getDesignerCusImage() {
		return _customerImages.getDesignerCusImage();
	}

	/**
	* Sets the designer cus image of this customer images.
	*
	* @param designerCusImage the designer cus image of this customer images
	*/
	@Override
	public void setDesignerCusImage(java.lang.String designerCusImage) {
		_customerImages.setDesignerCusImage(designerCusImage);
	}

	/**
	* Returns the customer image of this customer images.
	*
	* @return the customer image of this customer images
	*/
	@Override
	public java.lang.String getCustomerImage() {
		return _customerImages.getCustomerImage();
	}

	/**
	* Sets the customer image of this customer images.
	*
	* @param customerImage the customer image of this customer images
	*/
	@Override
	public void setCustomerImage(java.lang.String customerImage) {
		_customerImages.setCustomerImage(customerImage);
	}

	/**
	* Returns the customer name of this customer images.
	*
	* @return the customer name of this customer images
	*/
	@Override
	public java.lang.String getCustomerName() {
		return _customerImages.getCustomerName();
	}

	/**
	* Sets the customer name of this customer images.
	*
	* @param customerName the customer name of this customer images
	*/
	@Override
	public void setCustomerName(java.lang.String customerName) {
		_customerImages.setCustomerName(customerName);
	}

	/**
	* Returns the customer address of this customer images.
	*
	* @return the customer address of this customer images
	*/
	@Override
	public java.lang.String getCustomerAddress() {
		return _customerImages.getCustomerAddress();
	}

	/**
	* Sets the customer address of this customer images.
	*
	* @param customerAddress the customer address of this customer images
	*/
	@Override
	public void setCustomerAddress(java.lang.String customerAddress) {
		_customerImages.setCustomerAddress(customerAddress);
	}

	@Override
	public boolean isNew() {
		return _customerImages.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_customerImages.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _customerImages.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_customerImages.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _customerImages.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _customerImages.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_customerImages.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _customerImages.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_customerImages.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_customerImages.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_customerImages.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CustomerImagesWrapper((CustomerImages)_customerImages.clone());
	}

	@Override
	public int compareTo(com.cloud.tags.model.CustomerImages customerImages) {
		return _customerImages.compareTo(customerImages);
	}

	@Override
	public int hashCode() {
		return _customerImages.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.cloud.tags.model.CustomerImages> toCacheModel() {
		return _customerImages.toCacheModel();
	}

	@Override
	public com.cloud.tags.model.CustomerImages toEscapedModel() {
		return new CustomerImagesWrapper(_customerImages.toEscapedModel());
	}

	@Override
	public com.cloud.tags.model.CustomerImages toUnescapedModel() {
		return new CustomerImagesWrapper(_customerImages.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _customerImages.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _customerImages.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_customerImages.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CustomerImagesWrapper)) {
			return false;
		}

		CustomerImagesWrapper customerImagesWrapper = (CustomerImagesWrapper)obj;

		if (Validator.equals(_customerImages,
					customerImagesWrapper._customerImages)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CustomerImages getWrappedCustomerImages() {
		return _customerImages;
	}

	@Override
	public CustomerImages getWrappedModel() {
		return _customerImages;
	}

	@Override
	public void resetOriginalValues() {
		_customerImages.resetOriginalValues();
	}

	private CustomerImages _customerImages;
}