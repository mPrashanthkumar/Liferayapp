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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DesignersBarcode}.
 * </p>
 *
 * @author Mohammed Zaheer
 * @see DesignersBarcode
 * @generated
 */
public class DesignersBarcodeWrapper implements DesignersBarcode,
	ModelWrapper<DesignersBarcode> {
	public DesignersBarcodeWrapper(DesignersBarcode designersBarcode) {
		_designersBarcode = designersBarcode;
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

	/**
	* Returns the primary key of this designers barcode.
	*
	* @return the primary key of this designers barcode
	*/
	@Override
	public long getPrimaryKey() {
		return _designersBarcode.getPrimaryKey();
	}

	/**
	* Sets the primary key of this designers barcode.
	*
	* @param primaryKey the primary key of this designers barcode
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_designersBarcode.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the designer barcode ID of this designers barcode.
	*
	* @return the designer barcode ID of this designers barcode
	*/
	@Override
	public long getDesignerBarcodeId() {
		return _designersBarcode.getDesignerBarcodeId();
	}

	/**
	* Sets the designer barcode ID of this designers barcode.
	*
	* @param designerBarcodeId the designer barcode ID of this designers barcode
	*/
	@Override
	public void setDesignerBarcodeId(long designerBarcodeId) {
		_designersBarcode.setDesignerBarcodeId(designerBarcodeId);
	}

	/**
	* Returns the barcode ID of this designers barcode.
	*
	* @return the barcode ID of this designers barcode
	*/
	@Override
	public long getBarcodeId() {
		return _designersBarcode.getBarcodeId();
	}

	/**
	* Sets the barcode ID of this designers barcode.
	*
	* @param barcodeId the barcode ID of this designers barcode
	*/
	@Override
	public void setBarcodeId(long barcodeId) {
		_designersBarcode.setBarcodeId(barcodeId);
	}

	/**
	* Returns the design ID of this designers barcode.
	*
	* @return the design ID of this designers barcode
	*/
	@Override
	public long getDesignId() {
		return _designersBarcode.getDesignId();
	}

	/**
	* Sets the design ID of this designers barcode.
	*
	* @param designId the design ID of this designers barcode
	*/
	@Override
	public void setDesignId(long designId) {
		_designersBarcode.setDesignId(designId);
	}

	/**
	* Returns the create date of this designers barcode.
	*
	* @return the create date of this designers barcode
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _designersBarcode.getCreateDate();
	}

	/**
	* Sets the create date of this designers barcode.
	*
	* @param createDate the create date of this designers barcode
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_designersBarcode.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this designers barcode.
	*
	* @return the modified date of this designers barcode
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _designersBarcode.getModifiedDate();
	}

	/**
	* Sets the modified date of this designers barcode.
	*
	* @param modifiedDate the modified date of this designers barcode
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_designersBarcode.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _designersBarcode.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_designersBarcode.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _designersBarcode.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_designersBarcode.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _designersBarcode.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _designersBarcode.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_designersBarcode.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _designersBarcode.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_designersBarcode.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_designersBarcode.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_designersBarcode.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DesignersBarcodeWrapper((DesignersBarcode)_designersBarcode.clone());
	}

	@Override
	public int compareTo(com.cloud.tags.model.DesignersBarcode designersBarcode) {
		return _designersBarcode.compareTo(designersBarcode);
	}

	@Override
	public int hashCode() {
		return _designersBarcode.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.cloud.tags.model.DesignersBarcode> toCacheModel() {
		return _designersBarcode.toCacheModel();
	}

	@Override
	public com.cloud.tags.model.DesignersBarcode toEscapedModel() {
		return new DesignersBarcodeWrapper(_designersBarcode.toEscapedModel());
	}

	@Override
	public com.cloud.tags.model.DesignersBarcode toUnescapedModel() {
		return new DesignersBarcodeWrapper(_designersBarcode.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _designersBarcode.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _designersBarcode.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_designersBarcode.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DesignersBarcodeWrapper)) {
			return false;
		}

		DesignersBarcodeWrapper designersBarcodeWrapper = (DesignersBarcodeWrapper)obj;

		if (Validator.equals(_designersBarcode,
					designersBarcodeWrapper._designersBarcode)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DesignersBarcode getWrappedDesignersBarcode() {
		return _designersBarcode;
	}

	@Override
	public DesignersBarcode getWrappedModel() {
		return _designersBarcode;
	}

	@Override
	public void resetOriginalValues() {
		_designersBarcode.resetOriginalValues();
	}

	private DesignersBarcode _designersBarcode;
}