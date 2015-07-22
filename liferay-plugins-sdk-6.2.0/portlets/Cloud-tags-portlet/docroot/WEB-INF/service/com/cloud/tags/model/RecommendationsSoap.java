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
 * This class is used by SOAP remote services, specifically {@link com.cloud.tags.service.http.RecommendationsServiceSoap}.
 *
 * @author Mohammed Zaheer
 * @see com.cloud.tags.service.http.RecommendationsServiceSoap
 * @generated
 */
public class RecommendationsSoap implements Serializable {
	public static RecommendationsSoap toSoapModel(Recommendations model) {
		RecommendationsSoap soapModel = new RecommendationsSoap();

		soapModel.setRecId(model.getRecId());
		soapModel.setDesigner1(model.getDesigner1());
		soapModel.setDesigner2(model.getDesigner2());
		soapModel.set_type(model.get_type());
		soapModel.setPercentage(model.getPercentage());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setColor_name(model.getColor_name());
		soapModel.setColor_image(model.getColor_image());

		return soapModel;
	}

	public static RecommendationsSoap[] toSoapModels(Recommendations[] models) {
		RecommendationsSoap[] soapModels = new RecommendationsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RecommendationsSoap[][] toSoapModels(
		Recommendations[][] models) {
		RecommendationsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RecommendationsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RecommendationsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RecommendationsSoap[] toSoapModels(
		List<Recommendations> models) {
		List<RecommendationsSoap> soapModels = new ArrayList<RecommendationsSoap>(models.size());

		for (Recommendations model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RecommendationsSoap[soapModels.size()]);
	}

	public RecommendationsSoap() {
	}

	public long getPrimaryKey() {
		return _recId;
	}

	public void setPrimaryKey(long pk) {
		setRecId(pk);
	}

	public long getRecId() {
		return _recId;
	}

	public void setRecId(long recId) {
		_recId = recId;
	}

	public String getDesigner1() {
		return _designer1;
	}

	public void setDesigner1(String designer1) {
		_designer1 = designer1;
	}

	public String getDesigner2() {
		return _designer2;
	}

	public void setDesigner2(String designer2) {
		_designer2 = designer2;
	}

	public long get_type() {
		return __type;
	}

	public void set_type(long _type) {
		__type = _type;
	}

	public double getPercentage() {
		return _percentage;
	}

	public void setPercentage(double percentage) {
		_percentage = percentage;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getColor_name() {
		return _color_name;
	}

	public void setColor_name(String color_name) {
		_color_name = color_name;
	}

	public String getColor_image() {
		return _color_image;
	}

	public void setColor_image(String color_image) {
		_color_image = color_image;
	}

	private long _recId;
	private String _designer1;
	private String _designer2;
	private long __type;
	private double _percentage;
	private long _companyId;
	private String _color_name;
	private String _color_image;
}