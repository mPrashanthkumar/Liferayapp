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
 * This class is a wrapper for {@link StoreDeviceMap}.
 * </p>
 *
 * @author Mohammed Zaheer
 * @see StoreDeviceMap
 * @generated
 */
public class StoreDeviceMapWrapper implements StoreDeviceMap,
	ModelWrapper<StoreDeviceMap> {
	public StoreDeviceMapWrapper(StoreDeviceMap storeDeviceMap) {
		_storeDeviceMap = storeDeviceMap;
	}

	@Override
	public Class<?> getModelClass() {
		return StoreDeviceMap.class;
	}

	@Override
	public String getModelClassName() {
		return StoreDeviceMap.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("storeName", getStoreName());
		attributes.put("deviceMacAddress", getDeviceMacAddress());
		attributes.put("storeId", getStoreId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long uuid = (Long)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String storeName = (String)attributes.get("storeName");

		if (storeName != null) {
			setStoreName(storeName);
		}

		String deviceMacAddress = (String)attributes.get("deviceMacAddress");

		if (deviceMacAddress != null) {
			setDeviceMacAddress(deviceMacAddress);
		}

		Long storeId = (Long)attributes.get("storeId");

		if (storeId != null) {
			setStoreId(storeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	/**
	* Returns the primary key of this store device map.
	*
	* @return the primary key of this store device map
	*/
	@Override
	public long getPrimaryKey() {
		return _storeDeviceMap.getPrimaryKey();
	}

	/**
	* Sets the primary key of this store device map.
	*
	* @param primaryKey the primary key of this store device map
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_storeDeviceMap.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this store device map.
	*
	* @return the uuid of this store device map
	*/
	@Override
	public long getUuid() {
		return _storeDeviceMap.getUuid();
	}

	/**
	* Sets the uuid of this store device map.
	*
	* @param uuid the uuid of this store device map
	*/
	@Override
	public void setUuid(long uuid) {
		_storeDeviceMap.setUuid(uuid);
	}

	/**
	* Returns the store name of this store device map.
	*
	* @return the store name of this store device map
	*/
	@Override
	public java.lang.String getStoreName() {
		return _storeDeviceMap.getStoreName();
	}

	/**
	* Sets the store name of this store device map.
	*
	* @param storeName the store name of this store device map
	*/
	@Override
	public void setStoreName(java.lang.String storeName) {
		_storeDeviceMap.setStoreName(storeName);
	}

	/**
	* Returns the device mac address of this store device map.
	*
	* @return the device mac address of this store device map
	*/
	@Override
	public java.lang.String getDeviceMacAddress() {
		return _storeDeviceMap.getDeviceMacAddress();
	}

	/**
	* Sets the device mac address of this store device map.
	*
	* @param deviceMacAddress the device mac address of this store device map
	*/
	@Override
	public void setDeviceMacAddress(java.lang.String deviceMacAddress) {
		_storeDeviceMap.setDeviceMacAddress(deviceMacAddress);
	}

	/**
	* Returns the store ID of this store device map.
	*
	* @return the store ID of this store device map
	*/
	@Override
	public long getStoreId() {
		return _storeDeviceMap.getStoreId();
	}

	/**
	* Sets the store ID of this store device map.
	*
	* @param storeId the store ID of this store device map
	*/
	@Override
	public void setStoreId(long storeId) {
		_storeDeviceMap.setStoreId(storeId);
	}

	/**
	* Returns the company ID of this store device map.
	*
	* @return the company ID of this store device map
	*/
	@Override
	public long getCompanyId() {
		return _storeDeviceMap.getCompanyId();
	}

	/**
	* Sets the company ID of this store device map.
	*
	* @param companyId the company ID of this store device map
	*/
	@Override
	public void setCompanyId(long companyId) {
		_storeDeviceMap.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this store device map.
	*
	* @return the group ID of this store device map
	*/
	@Override
	public long getGroupId() {
		return _storeDeviceMap.getGroupId();
	}

	/**
	* Sets the group ID of this store device map.
	*
	* @param groupId the group ID of this store device map
	*/
	@Override
	public void setGroupId(long groupId) {
		_storeDeviceMap.setGroupId(groupId);
	}

	/**
	* Returns the create date of this store device map.
	*
	* @return the create date of this store device map
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _storeDeviceMap.getCreateDate();
	}

	/**
	* Sets the create date of this store device map.
	*
	* @param createDate the create date of this store device map
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_storeDeviceMap.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _storeDeviceMap.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_storeDeviceMap.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _storeDeviceMap.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_storeDeviceMap.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _storeDeviceMap.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _storeDeviceMap.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_storeDeviceMap.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _storeDeviceMap.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_storeDeviceMap.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_storeDeviceMap.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_storeDeviceMap.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StoreDeviceMapWrapper((StoreDeviceMap)_storeDeviceMap.clone());
	}

	@Override
	public int compareTo(com.cloud.tags.model.StoreDeviceMap storeDeviceMap) {
		return _storeDeviceMap.compareTo(storeDeviceMap);
	}

	@Override
	public int hashCode() {
		return _storeDeviceMap.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.cloud.tags.model.StoreDeviceMap> toCacheModel() {
		return _storeDeviceMap.toCacheModel();
	}

	@Override
	public com.cloud.tags.model.StoreDeviceMap toEscapedModel() {
		return new StoreDeviceMapWrapper(_storeDeviceMap.toEscapedModel());
	}

	@Override
	public com.cloud.tags.model.StoreDeviceMap toUnescapedModel() {
		return new StoreDeviceMapWrapper(_storeDeviceMap.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _storeDeviceMap.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _storeDeviceMap.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_storeDeviceMap.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StoreDeviceMapWrapper)) {
			return false;
		}

		StoreDeviceMapWrapper storeDeviceMapWrapper = (StoreDeviceMapWrapper)obj;

		if (Validator.equals(_storeDeviceMap,
					storeDeviceMapWrapper._storeDeviceMap)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StoreDeviceMap getWrappedStoreDeviceMap() {
		return _storeDeviceMap;
	}

	@Override
	public StoreDeviceMap getWrappedModel() {
		return _storeDeviceMap;
	}

	@Override
	public void resetOriginalValues() {
		_storeDeviceMap.resetOriginalValues();
	}

	private StoreDeviceMap _storeDeviceMap;
}