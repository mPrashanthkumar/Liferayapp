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

import com.cloud.tags.model.Recommendations;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Recommendations in entity cache.
 *
 * @author Mohammed Zaheer
 * @see Recommendations
 * @generated
 */
public class RecommendationsCacheModel implements CacheModel<Recommendations>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{recId=");
		sb.append(recId);
		sb.append(", designer1=");
		sb.append(designer1);
		sb.append(", designer2=");
		sb.append(designer2);
		sb.append(", _type=");
		sb.append(_type);
		sb.append(", percentage=");
		sb.append(percentage);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", color_name=");
		sb.append(color_name);
		sb.append(", color_image=");
		sb.append(color_image);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Recommendations toEntityModel() {
		RecommendationsImpl recommendationsImpl = new RecommendationsImpl();

		recommendationsImpl.setRecId(recId);

		if (designer1 == null) {
			recommendationsImpl.setDesigner1(StringPool.BLANK);
		}
		else {
			recommendationsImpl.setDesigner1(designer1);
		}

		if (designer2 == null) {
			recommendationsImpl.setDesigner2(StringPool.BLANK);
		}
		else {
			recommendationsImpl.setDesigner2(designer2);
		}

		recommendationsImpl.set_type(_type);
		recommendationsImpl.setPercentage(percentage);
		recommendationsImpl.setCompanyId(companyId);

		if (color_name == null) {
			recommendationsImpl.setColor_name(StringPool.BLANK);
		}
		else {
			recommendationsImpl.setColor_name(color_name);
		}

		if (color_image == null) {
			recommendationsImpl.setColor_image(StringPool.BLANK);
		}
		else {
			recommendationsImpl.setColor_image(color_image);
		}

		recommendationsImpl.resetOriginalValues();

		return recommendationsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		recId = objectInput.readLong();
		designer1 = objectInput.readUTF();
		designer2 = objectInput.readUTF();
		_type = objectInput.readLong();
		percentage = objectInput.readDouble();
		companyId = objectInput.readLong();
		color_name = objectInput.readUTF();
		color_image = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(recId);

		if (designer1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(designer1);
		}

		if (designer2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(designer2);
		}

		objectOutput.writeLong(_type);
		objectOutput.writeDouble(percentage);
		objectOutput.writeLong(companyId);

		if (color_name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(color_name);
		}

		if (color_image == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(color_image);
		}
	}

	public long recId;
	public String designer1;
	public String designer2;
	public long _type;
	public double percentage;
	public long companyId;
	public String color_name;
	public String color_image;
}