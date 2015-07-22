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

import com.cloud.tags.model.StoreInformationMap;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StoreInformationMap in entity cache.
 *
 * @author Mohammed Zaheer
 * @see StoreInformationMap
 * @generated
 */
public class StoreInformationMapCacheModel implements CacheModel<StoreInformationMap>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", Name=");
		sb.append(Name);
		sb.append(", Address=");
		sb.append(Address);
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
	public StoreInformationMap toEntityModel() {
		StoreInformationMapImpl storeInformationMapImpl = new StoreInformationMapImpl();

		storeInformationMapImpl.setUuid(uuid);

		if (Name == null) {
			storeInformationMapImpl.setName(StringPool.BLANK);
		}
		else {
			storeInformationMapImpl.setName(Name);
		}

		if (Address == null) {
			storeInformationMapImpl.setAddress(StringPool.BLANK);
		}
		else {
			storeInformationMapImpl.setAddress(Address);
		}

		storeInformationMapImpl.setCompanyId(companyId);
		storeInformationMapImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			storeInformationMapImpl.setCreateDate(null);
		}
		else {
			storeInformationMapImpl.setCreateDate(new Date(createDate));
		}

		storeInformationMapImpl.resetOriginalValues();

		return storeInformationMapImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readLong();
		Name = objectInput.readUTF();
		Address = objectInput.readUTF();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(uuid);

		if (Name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Name);
		}

		if (Address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Address);
		}

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
	}

	public long uuid;
	public String Name;
	public String Address;
	public long companyId;
	public long groupId;
	public long createDate;
}