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
public class ImpressionsSoap implements Serializable {
	public static ImpressionsSoap toSoapModel(Impressions model) {
		ImpressionsSoap soapModel = new ImpressionsSoap();

		soapModel.setRecId(model.getRecId());
		soapModel.setImpressionType(model.getImpressionType());
		soapModel.setImpressionId(model.getImpressionId());
		soapModel.setImpressionAction(model.getImpressionAction());
		soapModel.setIpAddress(model.getIpAddress());
		soapModel.setDeviceType(model.getDeviceType());
		soapModel.setDeviceName(model.getDeviceName());
		soapModel.setDeviceWidth(model.getDeviceWidth());
		soapModel.setIdeviceBrowser(model.getIdeviceBrowser());
		soapModel.setSession_Id(model.getSession_Id());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setStoreDeviceId(model.getStoreDeviceId());
		soapModel.setStaffId(model.getStaffId());

		return soapModel;
	}

	public static ImpressionsSoap[] toSoapModels(Impressions[] models) {
		ImpressionsSoap[] soapModels = new ImpressionsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ImpressionsSoap[][] toSoapModels(Impressions[][] models) {
		ImpressionsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ImpressionsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ImpressionsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ImpressionsSoap[] toSoapModels(List<Impressions> models) {
		List<ImpressionsSoap> soapModels = new ArrayList<ImpressionsSoap>(models.size());

		for (Impressions model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ImpressionsSoap[soapModels.size()]);
	}

	public ImpressionsSoap() {
	}

	public long getPrimaryKey() {
		return _recId;
	}

	public void setPrimaryKey(long pk) {
		setRecId(pk);
	}

	public long getRecId() {
		return _recId;
	}

	public void setRecId(long recId) {
		_recId = recId;
	}

	public String getImpressionType() {
		return _impressionType;
	}

	public void setImpressionType(String impressionType) {
		_impressionType = impressionType;
	}

	public String getImpressionId() {
		return _impressionId;
	}

	public void setImpressionId(String impressionId) {
		_impressionId = impressionId;
	}

	public String getImpressionAction() {
		return _impressionAction;
	}

	public void setImpressionAction(String impressionAction) {
		_impressionAction = impressionAction;
	}

	public String getIpAddress() {
		return _ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		_ipAddress = ipAddress;
	}

	public String getDeviceType() {
		return _deviceType;
	}

	public void setDeviceType(String deviceType) {
		_deviceType = deviceType;
	}

	public String getDeviceName() {
		return _deviceName;
	}

	public void setDeviceName(String deviceName) {
		_deviceName = deviceName;
	}

	public String getDeviceWidth() {
		return _deviceWidth;
	}

	public void setDeviceWidth(String deviceWidth) {
		_deviceWidth = deviceWidth;
	}

	public String getIdeviceBrowser() {
		return _ideviceBrowser;
	}

	public void setIdeviceBrowser(String ideviceBrowser) {
		_ideviceBrowser = ideviceBrowser;
	}

	public String getSession_Id() {
		return _session_Id;
	}

	public void setSession_Id(String session_Id) {
		_session_Id = session_Id;
	}

	public String getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(String companyId) {
		_companyId = companyId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getStoreDeviceId() {
		return _storeDeviceId;
	}

	public void setStoreDeviceId(long storeDeviceId) {
		_storeDeviceId = storeDeviceId;
	}

	public String getStaffId() {
		return _staffId;
	}

	public void setStaffId(String staffId) {
		_staffId = staffId;
	}

	private long _recId;
	private String _impressionType;
	private String _impressionId;
	private String _impressionAction;
	private String _ipAddress;
	private String _deviceType;
	private String _deviceName;
	private String _deviceWidth;
	private String _ideviceBrowser;
	private String _session_Id;
	private String _companyId;
	private Date _createDate;
	private long _storeDeviceId;
	private String _staffId;
}