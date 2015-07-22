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

import com.cloud.tags.model.DesignersBarcode;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DesignersBarcode in entity cache.
 *
 * @author Mohammed Zaheer
 * @see DesignersBarcode
 * @generated
 */
public class DesignersBarcodeCacheModel implements CacheModel<DesignersBarcode>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{designerBarcodeId=");
		sb.append(designerBarcodeId);
		sb.append(", barcodeId=");
		sb.append(barcodeId);
		sb.append(", designId=");
		sb.append(designId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DesignersBarcode toEntityModel() {
		DesignersBarcodeImpl designersBarcodeImpl = new DesignersBarcodeImpl();

		designersBarcodeImpl.setDesignerBarcodeId(designerBarcodeId);
		designersBarcodeImpl.setBarcodeId(barcodeId);
		designersBarcodeImpl.setDesignId(designId);

		if (createDate == Long.MIN_VALUE) {
			designersBarcodeImpl.setCreateDate(null);
		}
		else {
			designersBarcodeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			designersBarcodeImpl.setModifiedDate(null);
		}
		else {
			designersBarcodeImpl.setModifiedDate(new Date(modifiedDate));
		}

		designersBarcodeImpl.resetOriginalValues();

		return designersBarcodeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		designerBarcodeId = objectInput.readLong();
		barcodeId = objectInput.readLong();
		designId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(designerBarcodeId);
		objectOutput.writeLong(barcodeId);
		objectOutput.writeLong(designId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long designerBarcodeId;
	public long barcodeId;
	public long designId;
	public long createDate;
	public long modifiedDate;
}