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

import com.cloud.tags.model.CartsDesigners;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CartsDesigners in entity cache.
 *
 * @author Mohammed Zaheer
 * @see CartsDesigners
 * @generated
 */
public class CartsDesignersCacheModel implements CacheModel<CartsDesigners>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{cartDesignerId=");
		sb.append(cartDesignerId);
		sb.append(", cartId=");
		sb.append(cartId);
		sb.append(", designId=");
		sb.append(designId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", kept=");
		sb.append(kept);
		sb.append(", favorite=");
		sb.append(favorite);
		sb.append(", staffId=");
		sb.append(staffId);
		sb.append(", userNote=");
		sb.append(userNote);
		sb.append(", XPComputed=");
		sb.append(XPComputed);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CartsDesigners toEntityModel() {
		CartsDesignersImpl cartsDesignersImpl = new CartsDesignersImpl();

		cartsDesignersImpl.setCartDesignerId(cartDesignerId);
		cartsDesignersImpl.setCartId(cartId);
		cartsDesignersImpl.setDesignId(designId);

		if (createDate == Long.MIN_VALUE) {
			cartsDesignersImpl.setCreateDate(null);
		}
		else {
			cartsDesignersImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cartsDesignersImpl.setModifiedDate(null);
		}
		else {
			cartsDesignersImpl.setModifiedDate(new Date(modifiedDate));
		}

		cartsDesignersImpl.setKept(kept);
		cartsDesignersImpl.setFavorite(favorite);

		if (staffId == null) {
			cartsDesignersImpl.setStaffId(StringPool.BLANK);
		}
		else {
			cartsDesignersImpl.setStaffId(staffId);
		}

		if (userNote == null) {
			cartsDesignersImpl.setUserNote(StringPool.BLANK);
		}
		else {
			cartsDesignersImpl.setUserNote(userNote);
		}

		cartsDesignersImpl.setXPComputed(XPComputed);

		cartsDesignersImpl.resetOriginalValues();

		return cartsDesignersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cartDesignerId = objectInput.readLong();
		cartId = objectInput.readLong();
		designId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		kept = objectInput.readBoolean();
		favorite = objectInput.readBoolean();
		staffId = objectInput.readUTF();
		userNote = objectInput.readUTF();
		XPComputed = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(cartDesignerId);
		objectOutput.writeLong(cartId);
		objectOutput.writeLong(designId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeBoolean(kept);
		objectOutput.writeBoolean(favorite);

		if (staffId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(staffId);
		}

		if (userNote == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userNote);
		}

		objectOutput.writeBoolean(XPComputed);
	}

	public long cartDesignerId;
	public long cartId;
	public long designId;
	public long createDate;
	public long modifiedDate;
	public boolean kept;
	public boolean favorite;
	public String staffId;
	public String userNote;
	public boolean XPComputed;
}