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
 * This class is a wrapper for {@link Impressions}.
 * </p>
 *
 * @author Mohammed Zaheer
 * @see Impressions
 * @generated
 */
public class ImpressionsWrapper implements Impressions,
	ModelWrapper<Impressions> {
	public ImpressionsWrapper(Impressions impressions) {
		_impressions = impressions;
	}

	@Override
	public Class<?> getModelClass() {
		return Impressions.class;
	}

	@Override
	public String getModelClassName() {
		return Impressions.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("recId", getRecId());
		attributes.put("impressionType", getImpressionType());
		attributes.put("impressionId", getImpressionId());
		attributes.put("impressionAction", getImpressionAction());
		attributes.put("ipAddress", getIpAddress());
		attributes.put("deviceType", getDeviceType());
		attributes.put("deviceName", getDeviceName());
		attributes.put("deviceWidth", getDeviceWidth());
		attributes.put("ideviceBrowser", getIdeviceBrowser());
		attributes.put("session_Id", getSession_Id());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("storeDeviceId", getStoreDeviceId());
		attributes.put("staffId", getStaffId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long recId = (Long)attributes.get("recId");

		if (recId != null) {
			setRecId(recId);
		}

		String impressionType = (String)attributes.get("impressionType");

		if (impressionType != null) {
			setImpressionType(impressionType);
		}

		String impressionId = (String)attributes.get("impressionId");

		if (impressionId != null) {
			setImpressionId(impressionId);
		}

		String impressionAction = (String)attributes.get("impressionAction");

		if (impressionAction != null) {
			setImpressionAction(impressionAction);
		}

		String ipAddress = (String)attributes.get("ipAddress");

		if (ipAddress != null) {
			setIpAddress(ipAddress);
		}

		String deviceType = (String)attributes.get("deviceType");

		if (deviceType != null) {
			setDeviceType(deviceType);
		}

		String deviceName = (String)attributes.get("deviceName");

		if (deviceName != null) {
			setDeviceName(deviceName);
		}

		String deviceWidth = (String)attributes.get("deviceWidth");

		if (deviceWidth != null) {
			setDeviceWidth(deviceWidth);
		}

		String ideviceBrowser = (String)attributes.get("ideviceBrowser");

		if (ideviceBrowser != null) {
			setIdeviceBrowser(ideviceBrowser);
		}

		String session_Id = (String)attributes.get("session_Id");

		if (session_Id != null) {
			setSession_Id(session_Id);
		}

		String companyId = (String)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long storeDeviceId = (Long)attributes.get("storeDeviceId");

		if (storeDeviceId != null) {
			setStoreDeviceId(storeDeviceId);
		}

		String staffId = (String)attributes.get("staffId");

		if (staffId != null) {
			setStaffId(staffId);
		}
	}

	/**
	* Returns the primary key of this impressions.
	*
	* @return the primary key of this impressions
	*/
	@Override
	public long getPrimaryKey() {
		return _impressions.getPrimaryKey();
	}

	/**
	* Sets the primary key of this impressions.
	*
	* @param primaryKey the primary key of this impressions
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_impressions.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the rec ID of this impressions.
	*
	* @return the rec ID of this impressions
	*/
	@Override
	public long getRecId() {
		return _impressions.getRecId();
	}

	/**
	* Sets the rec ID of this impressions.
	*
	* @param recId the rec ID of this impressions
	*/
	@Override
	public void setRecId(long recId) {
		_impressions.setRecId(recId);
	}

	/**
	* Returns the impression type of this impressions.
	*
	* @return the impression type of this impressions
	*/
	@Override
	public java.lang.String getImpressionType() {
		return _impressions.getImpressionType();
	}

	/**
	* Sets the impression type of this impressions.
	*
	* @param impressionType the impression type of this impressions
	*/
	@Override
	public void setImpressionType(java.lang.String impressionType) {
		_impressions.setImpressionType(impressionType);
	}

	/**
	* Returns the impression ID of this impressions.
	*
	* @return the impression ID of this impressions
	*/
	@Override
	public java.lang.String getImpressionId() {
		return _impressions.getImpressionId();
	}

	/**
	* Sets the impression ID of this impressions.
	*
	* @param impressionId the impression ID of this impressions
	*/
	@Override
	public void setImpressionId(java.lang.String impressionId) {
		_impressions.setImpressionId(impressionId);
	}

	/**
	* Returns the impression action of this impressions.
	*
	* @return the impression action of this impressions
	*/
	@Override
	public java.lang.String getImpressionAction() {
		return _impressions.getImpressionAction();
	}

	/**
	* Sets the impression action of this impressions.
	*
	* @param impressionAction the impression action of this impressions
	*/
	@Override
	public void setImpressionAction(java.lang.String impressionAction) {
		_impressions.setImpressionAction(impressionAction);
	}

	/**
	* Returns the ip address of this impressions.
	*
	* @return the ip address of this impressions
	*/
	@Override
	public java.lang.String getIpAddress() {
		return _impressions.getIpAddress();
	}

	/**
	* Sets the ip address of this impressions.
	*
	* @param ipAddress the ip address of this impressions
	*/
	@Override
	public void setIpAddress(java.lang.String ipAddress) {
		_impressions.setIpAddress(ipAddress);
	}

	/**
	* Returns the device type of this impressions.
	*
	* @return the device type of this impressions
	*/
	@Override
	public java.lang.String getDeviceType() {
		return _impressions.getDeviceType();
	}

	/**
	* Sets the device type of this impressions.
	*
	* @param deviceType the device type of this impressions
	*/
	@Override
	public void setDeviceType(java.lang.String deviceType) {
		_impressions.setDeviceType(deviceType);
	}

	/**
	* Returns the device name of this impressions.
	*
	* @return the device name of this impressions
	*/
	@Override
	public java.lang.String getDeviceName() {
		return _impressions.getDeviceName();
	}

	/**
	* Sets the device name of this impressions.
	*
	* @param deviceName the device name of this impressions
	*/
	@Override
	public void setDeviceName(java.lang.String deviceName) {
		_impressions.setDeviceName(deviceName);
	}

	/**
	* Returns the device width of this impressions.
	*
	* @return the device width of this impressions
	*/
	@Override
	public java.lang.String getDeviceWidth() {
		return _impressions.getDeviceWidth();
	}

	/**
	* Sets the device width of this impressions.
	*
	* @param deviceWidth the device width of this impressions
	*/
	@Override
	public void setDeviceWidth(java.lang.String deviceWidth) {
		_impressions.setDeviceWidth(deviceWidth);
	}

	/**
	* Returns the idevice browser of this impressions.
	*
	* @return the idevice browser of this impressions
	*/
	@Override
	public java.lang.String getIdeviceBrowser() {
		return _impressions.getIdeviceBrowser();
	}

	/**
	* Sets the idevice browser of this impressions.
	*
	* @param ideviceBrowser the idevice browser of this impressions
	*/
	@Override
	public void setIdeviceBrowser(java.lang.String ideviceBrowser) {
		_impressions.setIdeviceBrowser(ideviceBrowser);
	}

	/**
	* Returns the session_ ID of this impressions.
	*
	* @return the session_ ID of this impressions
	*/
	@Override
	public java.lang.String getSession_Id() {
		return _impressions.getSession_Id();
	}

	/**
	* Sets the session_ ID of this impressions.
	*
	* @param session_Id the session_ ID of this impressions
	*/
	@Override
	public void setSession_Id(java.lang.String session_Id) {
		_impressions.setSession_Id(session_Id);
	}

	/**
	* Returns the company ID of this impressions.
	*
	* @return the company ID of this impressions
	*/
	@Override
	public java.lang.String getCompanyId() {
		return _impressions.getCompanyId();
	}

	/**
	* Sets the company ID of this impressions.
	*
	* @param companyId the company ID of this impressions
	*/
	@Override
	public void setCompanyId(java.lang.String companyId) {
		_impressions.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this impressions.
	*
	* @return the create date of this impressions
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _impressions.getCreateDate();
	}

	/**
	* Sets the create date of this impressions.
	*
	* @param createDate the create date of this impressions
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_impressions.setCreateDate(createDate);
	}

	/**
	* Returns the store device ID of this impressions.
	*
	* @return the store device ID of this impressions
	*/
	@Override
	public long getStoreDeviceId() {
		return _impressions.getStoreDeviceId();
	}

	/**
	* Sets the store device ID of this impressions.
	*
	* @param storeDeviceId the store device ID of this impressions
	*/
	@Override
	public void setStoreDeviceId(long storeDeviceId) {
		_impressions.setStoreDeviceId(storeDeviceId);
	}

	/**
	* Returns the staff ID of this impressions.
	*
	* @return the staff ID of this impressions
	*/
	@Override
	public java.lang.String getStaffId() {
		return _impressions.getStaffId();
	}

	/**
	* Sets the staff ID of this impressions.
	*
	* @param staffId the staff ID of this impressions
	*/
	@Override
	public void setStaffId(java.lang.String staffId) {
		_impressions.setStaffId(staffId);
	}

	@Override
	public boolean isNew() {
		return _impressions.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_impressions.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _impressions.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_impressions.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _impressions.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _impressions.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_impressions.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _impressions.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_impressions.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_impressions.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_impressions.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ImpressionsWrapper((Impressions)_impressions.clone());
	}

	@Override
	public int compareTo(com.cloud.tags.model.Impressions impressions) {
		return _impressions.compareTo(impressions);
	}

	@Override
	public int hashCode() {
		return _impressions.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.cloud.tags.model.Impressions> toCacheModel() {
		return _impressions.toCacheModel();
	}

	@Override
	public com.cloud.tags.model.Impressions toEscapedModel() {
		return new ImpressionsWrapper(_impressions.toEscapedModel());
	}

	@Override
	public com.cloud.tags.model.Impressions toUnescapedModel() {
		return new ImpressionsWrapper(_impressions.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _impressions.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _impressions.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_impressions.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ImpressionsWrapper)) {
			return false;
		}

		ImpressionsWrapper impressionsWrapper = (ImpressionsWrapper)obj;

		if (Validator.equals(_impressions, impressionsWrapper._impressions)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Impressions getWrappedImpressions() {
		return _impressions;
	}

	@Override
	public Impressions getWrappedModel() {
		return _impressions;
	}

	@Override
	public void resetOriginalValues() {
		_impressions.resetOriginalValues();
	}

	private Impressions _impressions;
}