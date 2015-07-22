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
 * This class is a wrapper for {@link Carts}.
 * </p>
 *
 * @author Mohammed Zaheer
 * @see Carts
 * @generated
 */
public class CartsWrapper implements Carts, ModelWrapper<Carts> {
	public CartsWrapper(Carts carts) {
		_carts = carts;
	}

	@Override
	public Class<?> getModelClass() {
		return Carts.class;
	}

	@Override
	public String getModelClassName() {
		return Carts.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cartId", getCartId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("session_id", getSession_id());
		attributes.put("staffId", getStaffId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cartId = (Long)attributes.get("cartId");

		if (cartId != null) {
			setCartId(cartId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String session_id = (String)attributes.get("session_id");

		if (session_id != null) {
			setSession_id(session_id);
		}

		String staffId = (String)attributes.get("staffId");

		if (staffId != null) {
			setStaffId(staffId);
		}
	}

	/**
	* Returns the primary key of this carts.
	*
	* @return the primary key of this carts
	*/
	@Override
	public long getPrimaryKey() {
		return _carts.getPrimaryKey();
	}

	/**
	* Sets the primary key of this carts.
	*
	* @param primaryKey the primary key of this carts
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_carts.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the cart ID of this carts.
	*
	* @return the cart ID of this carts
	*/
	@Override
	public long getCartId() {
		return _carts.getCartId();
	}

	/**
	* Sets the cart ID of this carts.
	*
	* @param cartId the cart ID of this carts
	*/
	@Override
	public void setCartId(long cartId) {
		_carts.setCartId(cartId);
	}

	/**
	* Returns the user ID of this carts.
	*
	* @return the user ID of this carts
	*/
	@Override
	public long getUserId() {
		return _carts.getUserId();
	}

	/**
	* Sets the user ID of this carts.
	*
	* @param userId the user ID of this carts
	*/
	@Override
	public void setUserId(long userId) {
		_carts.setUserId(userId);
	}

	/**
	* Returns the user uuid of this carts.
	*
	* @return the user uuid of this carts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _carts.getUserUuid();
	}

	/**
	* Sets the user uuid of this carts.
	*
	* @param userUuid the user uuid of this carts
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_carts.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this carts.
	*
	* @return the create date of this carts
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _carts.getCreateDate();
	}

	/**
	* Sets the create date of this carts.
	*
	* @param createDate the create date of this carts
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_carts.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this carts.
	*
	* @return the modified date of this carts
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _carts.getModifiedDate();
	}

	/**
	* Sets the modified date of this carts.
	*
	* @param modifiedDate the modified date of this carts
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_carts.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the session_id of this carts.
	*
	* @return the session_id of this carts
	*/
	@Override
	public java.lang.String getSession_id() {
		return _carts.getSession_id();
	}

	/**
	* Sets the session_id of this carts.
	*
	* @param session_id the session_id of this carts
	*/
	@Override
	public void setSession_id(java.lang.String session_id) {
		_carts.setSession_id(session_id);
	}

	/**
	* Returns the staff ID of this carts.
	*
	* @return the staff ID of this carts
	*/
	@Override
	public java.lang.String getStaffId() {
		return _carts.getStaffId();
	}

	/**
	* Sets the staff ID of this carts.
	*
	* @param staffId the staff ID of this carts
	*/
	@Override
	public void setStaffId(java.lang.String staffId) {
		_carts.setStaffId(staffId);
	}

	@Override
	public boolean isNew() {
		return _carts.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_carts.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _carts.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_carts.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _carts.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _carts.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_carts.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _carts.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_carts.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_carts.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_carts.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CartsWrapper((Carts)_carts.clone());
	}

	@Override
	public int compareTo(com.cloud.tags.model.Carts carts) {
		return _carts.compareTo(carts);
	}

	@Override
	public int hashCode() {
		return _carts.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.cloud.tags.model.Carts> toCacheModel() {
		return _carts.toCacheModel();
	}

	@Override
	public com.cloud.tags.model.Carts toEscapedModel() {
		return new CartsWrapper(_carts.toEscapedModel());
	}

	@Override
	public com.cloud.tags.model.Carts toUnescapedModel() {
		return new CartsWrapper(_carts.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _carts.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _carts.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_carts.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CartsWrapper)) {
			return false;
		}

		CartsWrapper cartsWrapper = (CartsWrapper)obj;

		if (Validator.equals(_carts, cartsWrapper._carts)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Carts getWrappedCarts() {
		return _carts;
	}

	@Override
	public Carts getWrappedModel() {
		return _carts;
	}

	@Override
	public void resetOriginalValues() {
		_carts.resetOriginalValues();
	}

	private Carts _carts;
}