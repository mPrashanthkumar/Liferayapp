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

import com.cloud.tags.model.Carts;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Carts in entity cache.
 *
 * @author Mohammed Zaheer
 * @see Carts
 * @generated
 */
public class CartsCacheModel implements CacheModel<Carts>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{cartId=");
		sb.append(cartId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", session_id=");
		sb.append(session_id);
		sb.append(", staffId=");
		sb.append(staffId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Carts toEntityModel() {
		CartsImpl cartsImpl = new CartsImpl();

		cartsImpl.setCartId(cartId);
		cartsImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			cartsImpl.setCreateDate(null);
		}
		else {
			cartsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cartsImpl.setModifiedDate(null);
		}
		else {
			cartsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (session_id == null) {
			cartsImpl.setSession_id(StringPool.BLANK);
		}
		else {
			cartsImpl.setSession_id(session_id);
		}

		if (staffId == null) {
			cartsImpl.setStaffId(StringPool.BLANK);
		}
		else {
			cartsImpl.setStaffId(staffId);
		}

		cartsImpl.resetOriginalValues();

		return cartsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cartId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		session_id = objectInput.readUTF();
		staffId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(cartId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (session_id == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(session_id);
		}

		if (staffId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(staffId);
		}
	}

	public long cartId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String session_id;
	public String staffId;
}