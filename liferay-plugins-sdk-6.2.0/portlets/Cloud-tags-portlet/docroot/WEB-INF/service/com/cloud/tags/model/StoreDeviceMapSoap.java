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
 * This class is used by SOAP remote services, specifically {@link com.cloud.tags.service.http.StoreDeviceMapServiceSoap}.
 *
 * @author Mohammed Zaheer
 * @see com.cloud.tags.service.http.StoreDeviceMapServiceSoap
 * @generated
 */
public class StoreDeviceMapSoap implements Serializable {
	public static StoreDeviceMapSoap toSoapModel(StoreDeviceMap model) {
		StoreDeviceMapSoap soapModel = new StoreDeviceMapSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setStoreName(model.getStoreName());
		soapModel.setDeviceMacAddress(model.getDeviceMacAddress());
		soapModel.setStoreId(model.getStoreId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static StoreDeviceMapSoap[] toSoapModels(StoreDeviceMap[] models) {
		StoreDeviceMapSoap[] soapModels = new StoreDeviceMapSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StoreDeviceMapSoap[][] toSoapModels(StoreDeviceMap[][] models) {
		StoreDeviceMapSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StoreDeviceMapSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StoreDeviceMapSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StoreDeviceMapSoap[] toSoapModels(List<StoreDeviceMap> models) {
		List<StoreDeviceMapSoap> soapModels = new ArrayList<StoreDeviceMapSoap>(models.size());

		for (StoreDeviceMap model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StoreDeviceMapSoap[soapModels.size()]);
	}

	public StoreDeviceMapSoap() {
	}

	public long getPrimaryKey() {
		return _uuid;
	}

	public void setPrimaryKey(long pk) {
		setUuid(pk);
	}

	public long getUuid() {
		return _uuid;
	}

	public void setUuid(long uuid) {
		_uuid = uuid;
	}

	public String getStoreName() {
		return _storeName;
	}

	public void setStoreName(String storeName) {
		_storeName = storeName;
	}

	public String getDeviceMacAddress() {
		return _deviceMacAddress;
	}

	public void setDeviceMacAddress(String deviceMacAddress) {
		_deviceMacAddress = deviceMacAddress;
	}

	public long getStoreId() {
		return _storeId;
	}

	public void setStoreId(long storeId) {
		_storeId = storeId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	private long _uuid;
	private String _storeName;
	private String _deviceMacAddress;
	private long _storeId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
}