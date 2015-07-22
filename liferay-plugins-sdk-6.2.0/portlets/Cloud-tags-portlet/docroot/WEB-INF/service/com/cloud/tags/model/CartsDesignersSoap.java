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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mohammed Zaheer
 * @generated
 */
public class CartsDesignersSoap implements Serializable {
	public static CartsDesignersSoap toSoapModel(CartsDesigners model) {
		CartsDesignersSoap soapModel = new CartsDesignersSoap();

		soapModel.setCartDesignerId(model.getCartDesignerId());
		soapModel.setCartId(model.getCartId());
		soapModel.setDesignId(model.getDesignId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setKept(model.getKept());
		soapModel.setFavorite(model.getFavorite());
		soapModel.setStaffId(model.getStaffId());
		soapModel.setUserNote(model.getUserNote());
		soapModel.setXPComputed(model.getXPComputed());

		return soapModel;
	}

	public static CartsDesignersSoap[] toSoapModels(CartsDesigners[] models) {
		CartsDesignersSoap[] soapModels = new CartsDesignersSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CartsDesignersSoap[][] toSoapModels(CartsDesigners[][] models) {
		CartsDesignersSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CartsDesignersSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CartsDesignersSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CartsDesignersSoap[] toSoapModels(List<CartsDesigners> models) {
		List<CartsDesignersSoap> soapModels = new ArrayList<CartsDesignersSoap>(models.size());

		for (CartsDesigners model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CartsDesignersSoap[soapModels.size()]);
	}

	public CartsDesignersSoap() {
	}

	public long getPrimaryKey() {
		return _cartDesignerId;
	}

	public void setPrimaryKey(long pk) {
		setCartDesignerId(pk);
	}

	public long getCartDesignerId() {
		return _cartDesignerId;
	}

	public void setCartDesignerId(long cartDesignerId) {
		_cartDesignerId = cartDesignerId;
	}

	public long getCartId() {
		return _cartId;
	}

	public void setCartId(long cartId) {
		_cartId = cartId;
	}

	public long getDesignId() {
		return _designId;
	}

	public void setDesignId(long designId) {
		_designId = designId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public boolean getKept() {
		return _kept;
	}

	public boolean isKept() {
		return _kept;
	}

	public void setKept(boolean kept) {
		_kept = kept;
	}

	public boolean getFavorite() {
		return _favorite;
	}

	public boolean isFavorite() {
		return _favorite;
	}

	public void setFavorite(boolean favorite) {
		_favorite = favorite;
	}

	public String getStaffId() {
		return _staffId;
	}

	public void setStaffId(String staffId) {
		_staffId = staffId;
	}

	public String getUserNote() {
		return _userNote;
	}

	public void setUserNote(String userNote) {
		_userNote = userNote;
	}

	public boolean getXPComputed() {
		return _XPComputed;
	}

	public boolean isXPComputed() {
		return _XPComputed;
	}

	public void setXPComputed(boolean XPComputed) {
		_XPComputed = XPComputed;
	}

	private long _cartDesignerId;
	private long _cartId;
	private long _designId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _kept;
	private boolean _favorite;
	private String _staffId;
	private String _userNote;
	private boolean _XPComputed;
}