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
 * This class is used by SOAP remote services, specifically {@link com.cloud.tags.service.http.StoreInformationMapServiceSoap}.
 *
 * @author Mohammed Zaheer
 * @see com.cloud.tags.service.http.StoreInformationMapServiceSoap
 * @generated
 */
public class StoreInformationMapSoap implements Serializable {
	public static StoreInformationMapSoap toSoapModel(StoreInformationMap model) {
		StoreInformationMapSoap soapModel = new StoreInformationMapSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setName(model.getName());
		soapModel.setAddress(model.getAddress());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static StoreInformationMapSoap[] toSoapModels(
		StoreInformationMap[] models) {
		StoreInformationMapSoap[] soapModels = new StoreInformationMapSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StoreInformationMapSoap[][] toSoapModels(
		StoreInformationMap[][] models) {
		StoreInformationMapSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StoreInformationMapSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StoreInformationMapSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StoreInformationMapSoap[] toSoapModels(
		List<StoreInformationMap> models) {
		List<StoreInformationMapSoap> soapModels = new ArrayList<StoreInformationMapSoap>(models.size());

		for (StoreInformationMap model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StoreInformationMapSoap[soapModels.size()]);
	}

	public StoreInformationMapSoap() {
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

	public String getName() {
		return _Name;
	}

	public void setName(String Name) {
		_Name = Name;
	}

	public String getAddress() {
		return _Address;
	}

	public void setAddress(String Address) {
		_Address = Address;
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
	private String _Name;
	private String _Address;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
}