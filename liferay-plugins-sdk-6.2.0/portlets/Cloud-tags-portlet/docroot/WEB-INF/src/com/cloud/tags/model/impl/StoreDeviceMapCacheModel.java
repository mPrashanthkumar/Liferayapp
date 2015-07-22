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

package com.cloud.tags.model.impl;

import com.cloud.tags.model.StoreDeviceMap;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StoreDeviceMap in entity cache.
 *
 * @author Mohammed Zaheer
 * @see StoreDeviceMap
 * @generated
 */
public class StoreDeviceMapCacheModel implements CacheModel<StoreDeviceMap>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", storeName=");
		sb.append(storeName);
		sb.append(", deviceMacAddress=");
		sb.append(deviceMacAddress);
		sb.append(", storeId=");
		sb.append(storeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StoreDeviceMap toEntityModel() {
		StoreDeviceMapImpl storeDeviceMapImpl = new StoreDeviceMapImpl();

		storeDeviceMapImpl.setUuid(uuid);

		if (storeName == null) {
			storeDeviceMapImpl.setStoreName(StringPool.BLANK);
		}
		else {
			storeDeviceMapImpl.setStoreName(storeName);
		}

		if (deviceMacAddress == null) {
			storeDeviceMapImpl.setDeviceMacAddress(StringPool.BLANK);
		}
		else {
			storeDeviceMapImpl.setDeviceMacAddress(deviceMacAddress);
		}

		storeDeviceMapImpl.setStoreId(storeId);
		storeDeviceMapImpl.setCompanyId(companyId);
		storeDeviceMapImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			storeDeviceMapImpl.setCreateDate(null);
		}
		else {
			storeDeviceMapImpl.setCreateDate(new Date(createDate));
		}

		storeDeviceMapImpl.resetOriginalValues();

		return storeDeviceMapImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readLong();
		storeName = objectInput.readUTF();
		deviceMacAddress = objectInput.readUTF();
		storeId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(uuid);

		if (storeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(storeName);
		}

		if (deviceMacAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(deviceMacAddress);
		}

		objectOutput.writeLong(storeId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
	}

	public long uuid;
	public String storeName;
	public String deviceMacAddress;
	public long storeId;
	public long companyId;
	public long groupId;
	public long createDate;
}