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
public class CartsSoap implements Serializable {
	public static CartsSoap toSoapModel(Carts model) {
		CartsSoap soapModel = new CartsSoap();

		soapModel.setCartId(model.getCartId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSession_id(model.getSession_id());
		soapModel.setStaffId(model.getStaffId());

		return soapModel;
	}

	public static CartsSoap[] toSoapModels(Carts[] models) {
		CartsSoap[] soapModels = new CartsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CartsSoap[][] toSoapModels(Carts[][] models) {
		CartsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CartsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CartsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CartsSoap[] toSoapModels(List<Carts> models) {
		List<CartsSoap> soapModels = new ArrayList<CartsSoap>(models.size());

		for (Carts model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CartsSoap[soapModels.size()]);
	}

	public CartsSoap() {
	}

	public long getPrimaryKey() {
		return _cartId;
	}

	public void setPrimaryKey(long pk) {
		setCartId(pk);
	}

	public long getCartId() {
		return _cartId;
	}

	public void setCartId(long cartId) {
		_cartId = cartId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
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

	public String getSession_id() {
		return _session_id;
	}

	public void setSession_id(String session_id) {
		_session_id = session_id;
	}

	public String getStaffId() {
		return _staffId;
	}

	public void setStaffId(String staffId) {
		_staffId = staffId;
	}

	private long _cartId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _session_id;
	private String _staffId;
}