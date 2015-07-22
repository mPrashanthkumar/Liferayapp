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
 * This class is a wrapper for {@link StoreInformationMap}.
 * </p>
 *
 * @author Mohammed Zaheer
 * @see StoreInformationMap
 * @generated
 */
public class StoreInformationMapWrapper implements StoreInformationMap,
	ModelWrapper<StoreInformationMap> {
	public StoreInformationMapWrapper(StoreInformationMap storeInformationMap) {
		_storeInformationMap = storeInformationMap;
	}

	@Override
	public Class<?> getModelClass() {
		return StoreInformationMap.class;
	}

	@Override
	public String getModelClassName() {
		return StoreInformationMap.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("Name", getName());
		attributes.put("Address", getAddress());
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

		String Name = (String)attributes.get("Name");

		if (Name != null) {
			setName(Name);
		}

		String Address = (String)attributes.get("Address");

		if (Address != null) {
			setAddress(Address);
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
	* Returns the primary key of this store information map.
	*
	* @return the primary key of this store information map
	*/
	@Override
	public long getPrimaryKey() {
		return _storeInformationMap.getPrimaryKey();
	}

	/**
	* Sets the primary key of this store information map.
	*
	* @param primaryKey the primary key of this store information map
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_storeInformationMap.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this store information map.
	*
	* @return the uuid of this store information map
	*/
	@Override
	public long getUuid() {
		return _storeInformationMap.getUuid();
	}

	/**
	* Sets the uuid of this store information map.
	*
	* @param uuid the uuid of this store information map
	*/
	@Override
	public void setUuid(long uuid) {
		_storeInformationMap.setUuid(uuid);
	}

	/**
	* Returns the name of this store information map.
	*
	* @return the name of this store information map
	*/
	@Override
	public java.lang.String getName() {
		return _storeInformationMap.getName();
	}

	/**
	* Sets the name of this store information map.
	*
	* @param Name the name of this store information map
	*/
	@Override
	public void setName(java.lang.String Name) {
		_storeInformationMap.setName(Name);
	}

	/**
	* Returns the address of this store information map.
	*
	* @return the address of this store information map
	*/
	@Override
	public java.lang.String getAddress() {
		return _storeInformationMap.getAddress();
	}

	/**
	* Sets the address of this store information map.
	*
	* @param Address the address of this store information map
	*/
	@Override
	public void setAddress(java.lang.String Address) {
		_storeInformationMap.setAddress(Address);
	}

	/**
	* Returns the company ID of this store information map.
	*
	* @return the company ID of this store information map
	*/
	@Override
	public long getCompanyId() {
		return _storeInformationMap.getCompanyId();
	}

	/**
	* Sets the company ID of this store information map.
	*
	* @param companyId the company ID of this store information map
	*/
	@Override
	public void setCompanyId(long companyId) {
		_storeInformationMap.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this store information map.
	*
	* @return the group ID of this store information map
	*/
	@Override
	public long getGroupId() {
		return _storeInformationMap.getGroupId();
	}

	/**
	* Sets the group ID of this store information map.
	*
	* @param groupId the group ID of this store information map
	*/
	@Override
	public void setGroupId(long groupId) {
		_storeInformationMap.setGroupId(groupId);
	}

	/**
	* Returns the create date of this store information map.
	*
	* @return the create date of this store information map
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _storeInformationMap.getCreateDate();
	}

	/**
	* Sets the create date of this store information map.
	*
	* @param createDate the create date of this store information map
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_storeInformationMap.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _storeInformationMap.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_storeInformationMap.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _storeInformationMap.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_storeInformationMap.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _storeInformationMap.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _storeInformationMap.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_storeInformationMap.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _storeInformationMap.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_storeInformationMap.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_storeInformationMap.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_storeInformationMap.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StoreInformationMapWrapper((StoreInformationMap)_storeInformationMap.clone());
	}

	@Override
	public int compareTo(
		com.cloud.tags.model.StoreInformationMap storeInformationMap) {
		return _storeInformationMap.compareTo(storeInformationMap);
	}

	@Override
	public int hashCode() {
		return _storeInformationMap.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.cloud.tags.model.StoreInformationMap> toCacheModel() {
		return _storeInformationMap.toCacheModel();
	}

	@Override
	public com.cloud.tags.model.StoreInformationMap toEscapedModel() {
		return new StoreInformationMapWrapper(_storeInformationMap.toEscapedModel());
	}

	@Override
	public com.cloud.tags.model.StoreInformationMap toUnescapedModel() {
		return new StoreInformationMapWrapper(_storeInformationMap.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _storeInformationMap.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _storeInformationMap.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_storeInformationMap.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StoreInformationMapWrapper)) {
			return false;
		}

		StoreInformationMapWrapper storeInformationMapWrapper = (StoreInformationMapWrapper)obj;

		if (Validator.equals(_storeInformationMap,
					storeInformationMapWrapper._storeInformationMap)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StoreInformationMap getWrappedStoreInformationMap() {
		return _storeInformationMap;
	}

	@Override
	public StoreInformationMap getWrappedModel() {
		return _storeInformationMap;
	}

	@Override
	public void resetOriginalValues() {
		_storeInformationMap.resetOriginalValues();
	}

	private StoreInformationMap _storeInformationMap;
}