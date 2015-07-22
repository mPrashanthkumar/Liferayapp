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

import com.cloud.tags.model.Impressions;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Impressions in entity cache.
 *
 * @author Mohammed Zaheer
 * @see Impressions
 * @generated
 */
public class ImpressionsCacheModel implements CacheModel<Impressions>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{recId=");
		sb.append(recId);
		sb.append(", impressionType=");
		sb.append(impressionType);
		sb.append(", impressionId=");
		sb.append(impressionId);
		sb.append(", impressionAction=");
		sb.append(impressionAction);
		sb.append(", ipAddress=");
		sb.append(ipAddress);
		sb.append(", deviceType=");
		sb.append(deviceType);
		sb.append(", deviceName=");
		sb.append(deviceName);
		sb.append(", deviceWidth=");
		sb.append(deviceWidth);
		sb.append(", ideviceBrowser=");
		sb.append(ideviceBrowser);
		sb.append(", session_Id=");
		sb.append(session_Id);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", storeDeviceId=");
		sb.append(storeDeviceId);
		sb.append(", staffId=");
		sb.append(staffId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Impressions toEntityModel() {
		ImpressionsImpl impressionsImpl = new ImpressionsImpl();

		impressionsImpl.setRecId(recId);

		if (impressionType == null) {
			impressionsImpl.setImpressionType(StringPool.BLANK);
		}
		else {
			impressionsImpl.setImpressionType(impressionType);
		}

		if (impressionId == null) {
			impressionsImpl.setImpressionId(StringPool.BLANK);
		}
		else {
			impressionsImpl.setImpressionId(impressionId);
		}

		if (impressionAction == null) {
			impressionsImpl.setImpressionAction(StringPool.BLANK);
		}
		else {
			impressionsImpl.setImpressionAction(impressionAction);
		}

		if (ipAddress == null) {
			impressionsImpl.setIpAddress(StringPool.BLANK);
		}
		else {
			impressionsImpl.setIpAddress(ipAddress);
		}

		if (deviceType == null) {
			impressionsImpl.setDeviceType(StringPool.BLANK);
		}
		else {
			impressionsImpl.setDeviceType(deviceType);
		}

		if (deviceName == null) {
			impressionsImpl.setDeviceName(StringPool.BLANK);
		}
		else {
			impressionsImpl.setDeviceName(deviceName);
		}

		if (deviceWidth == null) {
			impressionsImpl.setDeviceWidth(StringPool.BLANK);
		}
		else {
			impressionsImpl.setDeviceWidth(deviceWidth);
		}

		if (ideviceBrowser == null) {
			impressionsImpl.setIdeviceBrowser(StringPool.BLANK);
		}
		else {
			impressionsImpl.setIdeviceBrowser(ideviceBrowser);
		}

		if (session_Id == null) {
			impressionsImpl.setSession_Id(StringPool.BLANK);
		}
		else {
			impressionsImpl.setSession_Id(session_Id);
		}

		if (companyId == null) {
			impressionsImpl.setCompanyId(StringPool.BLANK);
		}
		else {
			impressionsImpl.setCompanyId(companyId);
		}

		if (createDate == Long.MIN_VALUE) {
			impressionsImpl.setCreateDate(null);
		}
		else {
			impressionsImpl.setCreateDate(new Date(createDate));
		}

		impressionsImpl.setStoreDeviceId(storeDeviceId);

		if (staffId == null) {
			impressionsImpl.setStaffId(StringPool.BLANK);
		}
		else {
			impressionsImpl.setStaffId(staffId);
		}

		impressionsImpl.resetOriginalValues();

		return impressionsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		recId = objectInput.readLong();
		impressionType = objectInput.readUTF();
		impressionId = objectInput.readUTF();
		impressionAction = objectInput.readUTF();
		ipAddress = objectInput.readUTF();
		deviceType = objectInput.readUTF();
		deviceName = objectInput.readUTF();
		deviceWidth = objectInput.readUTF();
		ideviceBrowser = objectInput.readUTF();
		session_Id = objectInput.readUTF();
		companyId = objectInput.readUTF();
		createDate = objectInput.readLong();
		storeDeviceId = objectInput.readLong();
		staffId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(recId);

		if (impressionType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(impressionType);
		}

		if (impressionId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(impressionId);
		}

		if (impressionAction == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(impressionAction);
		}

		if (ipAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ipAddress);
		}

		if (deviceType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(deviceType);
		}

		if (deviceName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(deviceName);
		}

		if (deviceWidth == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(deviceWidth);
		}

		if (ideviceBrowser == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ideviceBrowser);
		}

		if (session_Id == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(session_Id);
		}

		if (companyId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companyId);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(storeDeviceId);

		if (staffId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(staffId);
		}
	}

	public long recId;
	public String impressionType;
	public String impressionId;
	public String impressionAction;
	public String ipAddress;
	public String deviceType;
	public String deviceName;
	public String deviceWidth;
	public String ideviceBrowser;
	public String session_Id;
	public String companyId;
	public long createDate;
	public long storeDeviceId;
	public String staffId;
}