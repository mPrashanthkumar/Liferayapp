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
 * This class is a wrapper for {@link CartsDesigners}.
 * </p>
 *
 * @author Mohammed Zaheer
 * @see CartsDesigners
 * @generated
 */
public class CartsDesignersWrapper implements CartsDesigners,
	ModelWrapper<CartsDesigners> {
	public CartsDesignersWrapper(CartsDesigners cartsDesigners) {
		_cartsDesigners = cartsDesigners;
	}

	@Override
	public Class<?> getModelClass() {
		return CartsDesigners.class;
	}

	@Override
	public String getModelClassName() {
		return CartsDesigners.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cartDesignerId", getCartDesignerId());
		attributes.put("cartId", getCartId());
		attributes.put("designId", getDesignId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("kept", getKept());
		attributes.put("favorite", getFavorite());
		attributes.put("staffId", getStaffId());
		attributes.put("userNote", getUserNote());
		attributes.put("XPComputed", getXPComputed());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cartDesignerId = (Long)attributes.get("cartDesignerId");

		if (cartDesignerId != null) {
			setCartDesignerId(cartDesignerId);
		}

		Long cartId = (Long)attributes.get("cartId");

		if (cartId != null) {
			setCartId(cartId);
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

		Boolean kept = (Boolean)attributes.get("kept");

		if (kept != null) {
			setKept(kept);
		}

		Boolean favorite = (Boolean)attributes.get("favorite");

		if (favorite != null) {
			setFavorite(favorite);
		}

		String staffId = (String)attributes.get("staffId");

		if (staffId != null) {
			setStaffId(staffId);
		}

		String userNote = (String)attributes.get("userNote");

		if (userNote != null) {
			setUserNote(userNote);
		}

		Boolean XPComputed = (Boolean)attributes.get("XPComputed");

		if (XPComputed != null) {
			setXPComputed(XPComputed);
		}
	}

	/**
	* Returns the primary key of this carts designers.
	*
	* @return the primary key of this carts designers
	*/
	@Override
	public long getPrimaryKey() {
		return _cartsDesigners.getPrimaryKey();
	}

	/**
	* Sets the primary key of this carts designers.
	*
	* @param primaryKey the primary key of this carts designers
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_cartsDesigners.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the cart designer ID of this carts designers.
	*
	* @return the cart designer ID of this carts designers
	*/
	@Override
	public long getCartDesignerId() {
		return _cartsDesigners.getCartDesignerId();
	}

	/**
	* Sets the cart designer ID of this carts designers.
	*
	* @param cartDesignerId the cart designer ID of this carts designers
	*/
	@Override
	public void setCartDesignerId(long cartDesignerId) {
		_cartsDesigners.setCartDesignerId(cartDesignerId);
	}

	/**
	* Returns the cart ID of this carts designers.
	*
	* @return the cart ID of this carts designers
	*/
	@Override
	public long getCartId() {
		return _cartsDesigners.getCartId();
	}

	/**
	* Sets the cart ID of this carts designers.
	*
	* @param cartId the cart ID of this carts designers
	*/
	@Override
	public void setCartId(long cartId) {
		_cartsDesigners.setCartId(cartId);
	}

	/**
	* Returns the design ID of this carts designers.
	*
	* @return the design ID of this carts designers
	*/
	@Override
	public long getDesignId() {
		return _cartsDesigners.getDesignId();
	}

	/**
	* Sets the design ID of this carts designers.
	*
	* @param designId the design ID of this carts designers
	*/
	@Override
	public void setDesignId(long designId) {
		_cartsDesigners.setDesignId(designId);
	}

	/**
	* Returns the create date of this carts designers.
	*
	* @return the create date of this carts designers
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _cartsDesigners.getCreateDate();
	}

	/**
	* Sets the create date of this carts designers.
	*
	* @param createDate the create date of this carts designers
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_cartsDesigners.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this carts designers.
	*
	* @return the modified date of this carts designers
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _cartsDesigners.getModifiedDate();
	}

	/**
	* Sets the modified date of this carts designers.
	*
	* @param modifiedDate the modified date of this carts designers
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_cartsDesigners.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the kept of this carts designers.
	*
	* @return the kept of this carts designers
	*/
	@Override
	public boolean getKept() {
		return _cartsDesigners.getKept();
	}

	/**
	* Returns <code>true</code> if this carts designers is kept.
	*
	* @return <code>true</code> if this carts designers is kept; <code>false</code> otherwise
	*/
	@Override
	public boolean isKept() {
		return _cartsDesigners.isKept();
	}

	/**
	* Sets whether this carts designers is kept.
	*
	* @param kept the kept of this carts designers
	*/
	@Override
	public void setKept(boolean kept) {
		_cartsDesigners.setKept(kept);
	}

	/**
	* Returns the favorite of this carts designers.
	*
	* @return the favorite of this carts designers
	*/
	@Override
	public boolean getFavorite() {
		return _cartsDesigners.getFavorite();
	}

	/**
	* Returns <code>true</code> if this carts designers is favorite.
	*
	* @return <code>true</code> if this carts designers is favorite; <code>false</code> otherwise
	*/
	@Override
	public boolean isFavorite() {
		return _cartsDesigners.isFavorite();
	}

	/**
	* Sets whether this carts designers is favorite.
	*
	* @param favorite the favorite of this carts designers
	*/
	@Override
	public void setFavorite(boolean favorite) {
		_cartsDesigners.setFavorite(favorite);
	}

	/**
	* Returns the staff ID of this carts designers.
	*
	* @return the staff ID of this carts designers
	*/
	@Override
	public java.lang.String getStaffId() {
		return _cartsDesigners.getStaffId();
	}

	/**
	* Sets the staff ID of this carts designers.
	*
	* @param staffId the staff ID of this carts designers
	*/
	@Override
	public void setStaffId(java.lang.String staffId) {
		_cartsDesigners.setStaffId(staffId);
	}

	/**
	* Returns the user note of this carts designers.
	*
	* @return the user note of this carts designers
	*/
	@Override
	public java.lang.String getUserNote() {
		return _cartsDesigners.getUserNote();
	}

	/**
	* Sets the user note of this carts designers.
	*
	* @param userNote the user note of this carts designers
	*/
	@Override
	public void setUserNote(java.lang.String userNote) {
		_cartsDesigners.setUserNote(userNote);
	}

	/**
	* Returns the x p computed of this carts designers.
	*
	* @return the x p computed of this carts designers
	*/
	@Override
	public boolean getXPComputed() {
		return _cartsDesigners.getXPComputed();
	}

	/**
	* Returns <code>true</code> if this carts designers is x p computed.
	*
	* @return <code>true</code> if this carts designers is x p computed; <code>false</code> otherwise
	*/
	@Override
	public boolean isXPComputed() {
		return _cartsDesigners.isXPComputed();
	}

	/**
	* Sets whether this carts designers is x p computed.
	*
	* @param XPComputed the x p computed of this carts designers
	*/
	@Override
	public void setXPComputed(boolean XPComputed) {
		_cartsDesigners.setXPComputed(XPComputed);
	}

	@Override
	public boolean isNew() {
		return _cartsDesigners.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_cartsDesigners.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _cartsDesigners.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cartsDesigners.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _cartsDesigners.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _cartsDesigners.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cartsDesigners.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cartsDesigners.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_cartsDesigners.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_cartsDesigners.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cartsDesigners.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CartsDesignersWrapper((CartsDesigners)_cartsDesigners.clone());
	}

	@Override
	public int compareTo(com.cloud.tags.model.CartsDesigners cartsDesigners) {
		return _cartsDesigners.compareTo(cartsDesigners);
	}

	@Override
	public int hashCode() {
		return _cartsDesigners.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.cloud.tags.model.CartsDesigners> toCacheModel() {
		return _cartsDesigners.toCacheModel();
	}

	@Override
	public com.cloud.tags.model.CartsDesigners toEscapedModel() {
		return new CartsDesignersWrapper(_cartsDesigners.toEscapedModel());
	}

	@Override
	public com.cloud.tags.model.CartsDesigners toUnescapedModel() {
		return new CartsDesignersWrapper(_cartsDesigners.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cartsDesigners.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _cartsDesigners.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cartsDesigners.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CartsDesignersWrapper)) {
			return false;
		}

		CartsDesignersWrapper cartsDesignersWrapper = (CartsDesignersWrapper)obj;

		if (Validator.equals(_cartsDesigners,
					cartsDesignersWrapper._cartsDesigners)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CartsDesigners getWrappedCartsDesigners() {
		return _cartsDesigners;
	}

	@Override
	public CartsDesigners getWrappedModel() {
		return _cartsDesigners;
	}

	@Override
	public void resetOriginalValues() {
		_cartsDesigners.resetOriginalValues();
	}

	private CartsDesigners _cartsDesigners;
}