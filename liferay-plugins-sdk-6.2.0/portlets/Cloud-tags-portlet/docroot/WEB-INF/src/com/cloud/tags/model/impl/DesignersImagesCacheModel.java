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

import com.cloud.tags.model.DesignersImages;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DesignersImages in entity cache.
 *
 * @author Mohammed Zaheer
 * @see DesignersImages
 * @generated
 */
public class DesignersImagesCacheModel implements CacheModel<DesignersImages>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{designImageId=");
		sb.append(designImageId);
		sb.append(", designId=");
		sb.append(designId);
		sb.append(", entity_image1=");
		sb.append(entity_image1);
		sb.append(", entity_image2=");
		sb.append(entity_image2);
		sb.append(", entity_image3=");
		sb.append(entity_image3);
		sb.append(", entity_image4=");
		sb.append(entity_image4);
		sb.append(", entity_image5=");
		sb.append(entity_image5);
		sb.append(", entity_image6=");
		sb.append(entity_image6);
		sb.append(", entity_image7=");
		sb.append(entity_image7);
		sb.append(", entity_image8=");
		sb.append(entity_image8);
		sb.append(", entity_image9=");
		sb.append(entity_image9);
		sb.append(", entity_image10=");
		sb.append(entity_image10);
		sb.append(", large_image_url=");
		sb.append(large_image_url);
		sb.append(", small_image_url=");
		sb.append(small_image_url);
		sb.append(", profile_image_url=");
		sb.append(profile_image_url);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DesignersImages toEntityModel() {
		DesignersImagesImpl designersImagesImpl = new DesignersImagesImpl();

		designersImagesImpl.setDesignImageId(designImageId);
		designersImagesImpl.setDesignId(designId);

		if (entity_image1 == null) {
			designersImagesImpl.setEntity_image1(StringPool.BLANK);
		}
		else {
			designersImagesImpl.setEntity_image1(entity_image1);
		}

		if (entity_image2 == null) {
			designersImagesImpl.setEntity_image2(StringPool.BLANK);
		}
		else {
			designersImagesImpl.setEntity_image2(entity_image2);
		}

		if (entity_image3 == null) {
			designersImagesImpl.setEntity_image3(StringPool.BLANK);
		}
		else {
			designersImagesImpl.setEntity_image3(entity_image3);
		}

		if (entity_image4 == null) {
			designersImagesImpl.setEntity_image4(StringPool.BLANK);
		}
		else {
			designersImagesImpl.setEntity_image4(entity_image4);
		}

		if (entity_image5 == null) {
			designersImagesImpl.setEntity_image5(StringPool.BLANK);
		}
		else {
			designersImagesImpl.setEntity_image5(entity_image5);
		}

		if (entity_image6 == null) {
			designersImagesImpl.setEntity_image6(StringPool.BLANK);
		}
		else {
			designersImagesImpl.setEntity_image6(entity_image6);
		}

		if (entity_image7 == null) {
			designersImagesImpl.setEntity_image7(StringPool.BLANK);
		}
		else {
			designersImagesImpl.setEntity_image7(entity_image7);
		}

		if (entity_image8 == null) {
			designersImagesImpl.setEntity_image8(StringPool.BLANK);
		}
		else {
			designersImagesImpl.setEntity_image8(entity_image8);
		}

		if (entity_image9 == null) {
			designersImagesImpl.setEntity_image9(StringPool.BLANK);
		}
		else {
			designersImagesImpl.setEntity_image9(entity_image9);
		}

		if (entity_image10 == null) {
			designersImagesImpl.setEntity_image10(StringPool.BLANK);
		}
		else {
			designersImagesImpl.setEntity_image10(entity_image10);
		}

		if (large_image_url == null) {
			designersImagesImpl.setLarge_image_url(StringPool.BLANK);
		}
		else {
			designersImagesImpl.setLarge_image_url(large_image_url);
		}

		if (small_image_url == null) {
			designersImagesImpl.setSmall_image_url(StringPool.BLANK);
		}
		else {
			designersImagesImpl.setSmall_image_url(small_image_url);
		}

		if (profile_image_url == null) {
			designersImagesImpl.setProfile_image_url(StringPool.BLANK);
		}
		else {
			designersImagesImpl.setProfile_image_url(profile_image_url);
		}

		designersImagesImpl.resetOriginalValues();

		return designersImagesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		designImageId = objectInput.readLong();
		designId = objectInput.readLong();
		entity_image1 = objectInput.readUTF();
		entity_image2 = objectInput.readUTF();
		entity_image3 = objectInput.readUTF();
		entity_image4 = objectInput.readUTF();
		entity_image5 = objectInput.readUTF();
		entity_image6 = objectInput.readUTF();
		entity_image7 = objectInput.readUTF();
		entity_image8 = objectInput.readUTF();
		entity_image9 = objectInput.readUTF();
		entity_image10 = objectInput.readUTF();
		large_image_url = objectInput.readUTF();
		small_image_url = objectInput.readUTF();
		profile_image_url = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(designImageId);
		objectOutput.writeLong(designId);

		if (entity_image1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(entity_image1);
		}

		if (entity_image2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(entity_image2);
		}

		if (entity_image3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(entity_image3);
		}

		if (entity_image4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(entity_image4);
		}

		if (entity_image5 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(entity_image5);
		}

		if (entity_image6 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(entity_image6);
		}

		if (entity_image7 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(entity_image7);
		}

		if (entity_image8 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(entity_image8);
		}

		if (entity_image9 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(entity_image9);
		}

		if (entity_image10 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(entity_image10);
		}

		if (large_image_url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(large_image_url);
		}

		if (small_image_url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(small_image_url);
		}

		if (profile_image_url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(profile_image_url);
		}
	}

	public long designImageId;
	public long designId;
	public String entity_image1;
	public String entity_image2;
	public String entity_image3;
	public String entity_image4;
	public String entity_image5;
	public String entity_image6;
	public String entity_image7;
	public String entity_image8;
	public String entity_image9;
	public String entity_image10;
	public String large_image_url;
	public String small_image_url;
	public String profile_image_url;
}