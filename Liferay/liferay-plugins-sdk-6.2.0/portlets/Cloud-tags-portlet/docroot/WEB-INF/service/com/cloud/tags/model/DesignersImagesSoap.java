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

package com.cloud.tags.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.cloud.tags.service.http.DesignersImagesServiceSoap}.
 *
 * @author Mohammed Zaheer
 * @see com.cloud.tags.service.http.DesignersImagesServiceSoap
 * @generated
 */
public class DesignersImagesSoap implements Serializable {
	public static DesignersImagesSoap toSoapModel(DesignersImages model) {
		DesignersImagesSoap soapModel = new DesignersImagesSoap();

		soapModel.setDesignImageId(model.getDesignImageId());
		soapModel.setDesignId(model.getDesignId());
		soapModel.setEntity_image1(model.getEntity_image1());
		soapModel.setEntity_image2(model.getEntity_image2());
		soapModel.setEntity_image3(model.getEntity_image3());
		soapModel.setEntity_image4(model.getEntity_image4());
		soapModel.setEntity_image5(model.getEntity_image5());
		soapModel.setEntity_image6(model.getEntity_image6());
		soapModel.setEntity_image7(model.getEntity_image7());
		soapModel.setEntity_image8(model.getEntity_image8());
		soapModel.setEntity_image9(model.getEntity_image9());
		soapModel.setEntity_image10(model.getEntity_image10());
		soapModel.setLarge_image_url(model.getLarge_image_url());
		soapModel.setSmall_image_url(model.getSmall_image_url());
		soapModel.setProfile_image_url(model.getProfile_image_url());

		return soapModel;
	}

	public static DesignersImagesSoap[] toSoapModels(DesignersImages[] models) {
		DesignersImagesSoap[] soapModels = new DesignersImagesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DesignersImagesSoap[][] toSoapModels(
		DesignersImages[][] models) {
		DesignersImagesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DesignersImagesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DesignersImagesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DesignersImagesSoap[] toSoapModels(
		List<DesignersImages> models) {
		List<DesignersImagesSoap> soapModels = new ArrayList<DesignersImagesSoap>(models.size());

		for (DesignersImages model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DesignersImagesSoap[soapModels.size()]);
	}

	public DesignersImagesSoap() {
	}

	public long getPrimaryKey() {
		return _designImageId;
	}

	public void setPrimaryKey(long pk) {
		setDesignImageId(pk);
	}

	public long getDesignImageId() {
		return _designImageId;
	}

	public void setDesignImageId(long designImageId) {
		_designImageId = designImageId;
	}

	public long getDesignId() {
		return _designId;
	}

	public void setDesignId(long designId) {
		_designId = designId;
	}

	public String getEntity_image1() {
		return _entity_image1;
	}

	public void setEntity_image1(String entity_image1) {
		_entity_image1 = entity_image1;
	}

	public String getEntity_image2() {
		return _entity_image2;
	}

	public void setEntity_image2(String entity_image2) {
		_entity_image2 = entity_image2;
	}

	public String getEntity_image3() {
		return _entity_image3;
	}

	public void setEntity_image3(String entity_image3) {
		_entity_image3 = entity_image3;
	}

	public String getEntity_image4() {
		return _entity_image4;
	}

	public void setEntity_image4(String entity_image4) {
		_entity_image4 = entity_image4;
	}

	public String getEntity_image5() {
		return _entity_image5;
	}

	public void setEntity_image5(String entity_image5) {
		_entity_image5 = entity_image5;
	}

	public String getEntity_image6() {
		return _entity_image6;
	}

	public void setEntity_image6(String entity_image6) {
		_entity_image6 = entity_image6;
	}

	public String getEntity_image7() {
		return _entity_image7;
	}

	public void setEntity_image7(String entity_image7) {
		_entity_image7 = entity_image7;
	}

	public String getEntity_image8() {
		return _entity_image8;
	}

	public void setEntity_image8(String entity_image8) {
		_entity_image8 = entity_image8;
	}

	public String getEntity_image9() {
		return _entity_image9;
	}

	public void setEntity_image9(String entity_image9) {
		_entity_image9 = entity_image9;
	}

	public String getEntity_image10() {
		return _entity_image10;
	}

	public void setEntity_image10(String entity_image10) {
		_entity_image10 = entity_image10;
	}

	public String getLarge_image_url() {
		return _large_image_url;
	}

	public void setLarge_image_url(String large_image_url) {
		_large_image_url = large_image_url;
	}

	public String getSmall_image_url() {
		return _small_image_url;
	}

	public void setSmall_image_url(String small_image_url) {
		_small_image_url = small_image_url;
	}

	public String getProfile_image_url() {
		return _profile_image_url;
	}

	public void setProfile_image_url(String profile_image_url) {
		_profile_image_url = profile_image_url;
	}

	private long _designImageId;
	private long _designId;
	private String _entity_image1;
	private String _entity_image2;
	private String _entity_image3;
	private String _entity_image4;
	private String _entity_image5;
	private String _entity_image6;
	private String _entity_image7;
	private String _entity_image8;
	private String _entity_image9;
	private String _entity_image10;
	private String _large_image_url;
	private String _small_image_url;
	private String _profile_image_url;
}