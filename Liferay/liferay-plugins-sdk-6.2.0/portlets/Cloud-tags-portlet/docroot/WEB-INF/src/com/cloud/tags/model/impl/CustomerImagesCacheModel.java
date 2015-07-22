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

import com.cloud.tags.model.CustomerImages;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CustomerImages in entity cache.
 *
 * @author Mohammed Zaheer
 * @see CustomerImages
 * @generated
 */
public class CustomerImagesCacheModel implements CacheModel<CustomerImages>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{customerImageId=");
		sb.append(customerImageId);
		sb.append(", designerSKU=");
		sb.append(designerSKU);
		sb.append(", designerCusImage=");
		sb.append(designerCusImage);
		sb.append(", customerImage=");
		sb.append(customerImage);
		sb.append(", customerName=");
		sb.append(customerName);
		sb.append(", customerAddress=");
		sb.append(customerAddress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CustomerImages toEntityModel() {
		CustomerImagesImpl customerImagesImpl = new CustomerImagesImpl();

		customerImagesImpl.setCustomerImageId(customerImageId);

		if (designerSKU == null) {
			customerImagesImpl.setDesignerSKU(StringPool.BLANK);
		}
		else {
			customerImagesImpl.setDesignerSKU(designerSKU);
		}

		if (designerCusImage == null) {
			customerImagesImpl.setDesignerCusImage(StringPool.BLANK);
		}
		else {
			customerImagesImpl.setDesignerCusImage(designerCusImage);
		}

		if (customerImage == null) {
			customerImagesImpl.setCustomerImage(StringPool.BLANK);
		}
		else {
			customerImagesImpl.setCustomerImage(customerImage);
		}

		if (customerName == null) {
			customerImagesImpl.setCustomerName(StringPool.BLANK);
		}
		else {
			customerImagesImpl.setCustomerName(customerName);
		}

		if (customerAddress == null) {
			customerImagesImpl.setCustomerAddress(StringPool.BLANK);
		}
		else {
			customerImagesImpl.setCustomerAddress(customerAddress);
		}

		customerImagesImpl.resetOriginalValues();

		return customerImagesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		customerImageId = objectInput.readLong();
		designerSKU = objectInput.readUTF();
		designerCusImage = objectInput.readUTF();
		customerImage = objectInput.readUTF();
		customerName = objectInput.readUTF();
		customerAddress = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(customerImageId);

		if (designerSKU == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(designerSKU);
		}

		if (designerCusImage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(designerCusImage);
		}

		if (customerImage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(customerImage);
		}

		if (customerName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(customerName);
		}

		if (customerAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(customerAddress);
		}
	}

	public long customerImageId;
	public String designerSKU;
	public String designerCusImage;
	public String customerImage;
	public String customerName;
	public String customerAddress;
}