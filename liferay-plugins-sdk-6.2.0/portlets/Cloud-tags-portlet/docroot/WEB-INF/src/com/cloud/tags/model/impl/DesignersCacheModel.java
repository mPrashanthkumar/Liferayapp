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

import com.cloud.tags.model.Designers;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Designers in entity cache.
 *
 * @author Mohammed Zaheer
 * @see Designers
 * @generated
 */
public class DesignersCacheModel implements CacheModel<Designers>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(67);

		sb.append("{designId=");
		sb.append(designId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", productTitle=");
		sb.append(productTitle);
		sb.append(", description=");
		sb.append(description);
		sb.append(", shortDescription=");
		sb.append(shortDescription);
		sb.append(", price=");
		sb.append(price);
		sb.append(", public_url=");
		sb.append(public_url);
		sb.append(", short_url=");
		sb.append(short_url);
		sb.append(", slug=");
		sb.append(slug);
		sb.append(", sizes=");
		sb.append(sizes);
		sb.append(", colors=");
		sb.append(colors);
		sb.append(", brand=");
		sb.append(brand);
		sb.append(", saleprice=");
		sb.append(saleprice);
		sb.append(", retailprice=");
		sb.append(retailprice);
		sb.append(", instock=");
		sb.append(instock);
		sb.append(", parentid=");
		sb.append(parentid);
		sb.append(", category=");
		sb.append(category);
		sb.append(", productcode=");
		sb.append(productcode);
		sb.append(", barcode=");
		sb.append(barcode);
		sb.append(", matchWith=");
		sb.append(matchWith);
		sb.append(", timerDate=");
		sb.append(timerDate);
		sb.append(", tabcurrent=");
		sb.append(tabcurrent);
		sb.append(", liked=");
		sb.append(liked);
		sb.append(", ctapp_shorturl=");
		sb.append(ctapp_shorturl);
		sb.append(", ctapp_shorturl_success=");
		sb.append(ctapp_shorturl_success);
		sb.append(", sayduck=");
		sb.append(sayduck);
		sb.append(", left_description=");
		sb.append(left_description);
		sb.append(", right_description=");
		sb.append(right_description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Designers toEntityModel() {
		DesignersImpl designersImpl = new DesignersImpl();

		designersImpl.setDesignId(designId);
		designersImpl.setUserId(userId);
		designersImpl.setCompanyId(companyId);
		designersImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			designersImpl.setCreateDate(null);
		}
		else {
			designersImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			designersImpl.setModifiedDate(null);
		}
		else {
			designersImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			designersImpl.setName(StringPool.BLANK);
		}
		else {
			designersImpl.setName(name);
		}

		if (productTitle == null) {
			designersImpl.setProductTitle(StringPool.BLANK);
		}
		else {
			designersImpl.setProductTitle(productTitle);
		}

		if (description == null) {
			designersImpl.setDescription(StringPool.BLANK);
		}
		else {
			designersImpl.setDescription(description);
		}

		if (shortDescription == null) {
			designersImpl.setShortDescription(StringPool.BLANK);
		}
		else {
			designersImpl.setShortDescription(shortDescription);
		}

		if (price == null) {
			designersImpl.setPrice(StringPool.BLANK);
		}
		else {
			designersImpl.setPrice(price);
		}

		if (public_url == null) {
			designersImpl.setPublic_url(StringPool.BLANK);
		}
		else {
			designersImpl.setPublic_url(public_url);
		}

		if (short_url == null) {
			designersImpl.setShort_url(StringPool.BLANK);
		}
		else {
			designersImpl.setShort_url(short_url);
		}

		if (slug == null) {
			designersImpl.setSlug(StringPool.BLANK);
		}
		else {
			designersImpl.setSlug(slug);
		}

		if (sizes == null) {
			designersImpl.setSizes(StringPool.BLANK);
		}
		else {
			designersImpl.setSizes(sizes);
		}

		if (colors == null) {
			designersImpl.setColors(StringPool.BLANK);
		}
		else {
			designersImpl.setColors(colors);
		}

		if (brand == null) {
			designersImpl.setBrand(StringPool.BLANK);
		}
		else {
			designersImpl.setBrand(brand);
		}

		if (saleprice == null) {
			designersImpl.setSaleprice(StringPool.BLANK);
		}
		else {
			designersImpl.setSaleprice(saleprice);
		}

		if (retailprice == null) {
			designersImpl.setRetailprice(StringPool.BLANK);
		}
		else {
			designersImpl.setRetailprice(retailprice);
		}

		if (instock == null) {
			designersImpl.setInstock(StringPool.BLANK);
		}
		else {
			designersImpl.setInstock(instock);
		}

		if (parentid == null) {
			designersImpl.setParentid(StringPool.BLANK);
		}
		else {
			designersImpl.setParentid(parentid);
		}

		if (category == null) {
			designersImpl.setCategory(StringPool.BLANK);
		}
		else {
			designersImpl.setCategory(category);
		}

		if (productcode == null) {
			designersImpl.setProductcode(StringPool.BLANK);
		}
		else {
			designersImpl.setProductcode(productcode);
		}

		if (barcode == null) {
			designersImpl.setBarcode(StringPool.BLANK);
		}
		else {
			designersImpl.setBarcode(barcode);
		}

		if (matchWith == null) {
			designersImpl.setMatchWith(StringPool.BLANK);
		}
		else {
			designersImpl.setMatchWith(matchWith);
		}

		if (timerDate == null) {
			designersImpl.setTimerDate(StringPool.BLANK);
		}
		else {
			designersImpl.setTimerDate(timerDate);
		}

		designersImpl.setTabcurrent(tabcurrent);
		designersImpl.setLiked(liked);
		designersImpl.setCtapp_shorturl(ctapp_shorturl);
		designersImpl.setCtapp_shorturl_success(ctapp_shorturl_success);
		designersImpl.setSayduck(sayduck);

		if (left_description == null) {
			designersImpl.setLeft_description(StringPool.BLANK);
		}
		else {
			designersImpl.setLeft_description(left_description);
		}

		if (right_description == null) {
			designersImpl.setRight_description(StringPool.BLANK);
		}
		else {
			designersImpl.setRight_description(right_description);
		}

		designersImpl.resetOriginalValues();

		return designersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		designId = objectInput.readLong();
		userId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		productTitle = objectInput.readUTF();
		description = objectInput.readUTF();
		shortDescription = objectInput.readUTF();
		price = objectInput.readUTF();
		public_url = objectInput.readUTF();
		short_url = objectInput.readUTF();
		slug = objectInput.readUTF();
		sizes = objectInput.readUTF();
		colors = objectInput.readUTF();
		brand = objectInput.readUTF();
		saleprice = objectInput.readUTF();
		retailprice = objectInput.readUTF();
		instock = objectInput.readUTF();
		parentid = objectInput.readUTF();
		category = objectInput.readUTF();
		productcode = objectInput.readUTF();
		barcode = objectInput.readUTF();
		matchWith = objectInput.readUTF();
		timerDate = objectInput.readUTF();
		tabcurrent = objectInput.readBoolean();
		liked = objectInput.readLong();
		ctapp_shorturl = objectInput.readBoolean();
		ctapp_shorturl_success = objectInput.readBoolean();
		sayduck = objectInput.readBoolean();
		left_description = objectInput.readUTF();
		right_description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(designId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (productTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productTitle);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (shortDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shortDescription);
		}

		if (price == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(price);
		}

		if (public_url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(public_url);
		}

		if (short_url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(short_url);
		}

		if (slug == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(slug);
		}

		if (sizes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sizes);
		}

		if (colors == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(colors);
		}

		if (brand == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(brand);
		}

		if (saleprice == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(saleprice);
		}

		if (retailprice == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(retailprice);
		}

		if (instock == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(instock);
		}

		if (parentid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(parentid);
		}

		if (category == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(category);
		}

		if (productcode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productcode);
		}

		if (barcode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(barcode);
		}

		if (matchWith == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(matchWith);
		}

		if (timerDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(timerDate);
		}

		objectOutput.writeBoolean(tabcurrent);
		objectOutput.writeLong(liked);
		objectOutput.writeBoolean(ctapp_shorturl);
		objectOutput.writeBoolean(ctapp_shorturl_success);
		objectOutput.writeBoolean(sayduck);

		if (left_description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(left_description);
		}

		if (right_description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(right_description);
		}
	}

	public long designId;
	public long userId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String productTitle;
	public String description;
	public String shortDescription;
	public String price;
	public String public_url;
	public String short_url;
	public String slug;
	public String sizes;
	public String colors;
	public String brand;
	public String saleprice;
	public String retailprice;
	public String instock;
	public String parentid;
	public String category;
	public String productcode;
	public String barcode;
	public String matchWith;
	public String timerDate;
	public boolean tabcurrent;
	public long liked;
	public boolean ctapp_shorturl;
	public boolean ctapp_shorturl_success;
	public boolean sayduck;
	public String left_description;
	public String right_description;
}