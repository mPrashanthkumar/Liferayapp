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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.cloud.tags.service.http.DesignersBarcodeServiceSoap}.
 *
 * @author Mohammed Zaheer
 * @see com.cloud.tags.service.http.DesignersBarcodeServiceSoap
 * @generated
 */
public class DesignersBarcodeSoap implements Serializable {
	public static DesignersBarcodeSoap toSoapModel(DesignersBarcode model) {
		DesignersBarcodeSoap soapModel = new DesignersBarcodeSoap();

		soapModel.setDesignerBarcodeId(model.getDesignerBarcodeId());
		soapModel.setBarcodeId(model.getBarcodeId());
		soapModel.setDesignId(model.getDesignId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static DesignersBarcodeSoap[] toSoapModels(DesignersBarcode[] models) {
		DesignersBarcodeSoap[] soapModels = new DesignersBarcodeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DesignersBarcodeSoap[][] toSoapModels(
		DesignersBarcode[][] models) {
		DesignersBarcodeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DesignersBarcodeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DesignersBarcodeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DesignersBarcodeSoap[] toSoapModels(
		List<DesignersBarcode> models) {
		List<DesignersBarcodeSoap> soapModels = new ArrayList<DesignersBarcodeSoap>(models.size());

		for (DesignersBarcode model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DesignersBarcodeSoap[soapModels.size()]);
	}

	public DesignersBarcodeSoap() {
	}

	public long getPrimaryKey() {
		return _designerBarcodeId;
	}

	public void setPrimaryKey(long pk) {
		setDesignerBarcodeId(pk);
	}

	public long getDesignerBarcodeId() {
		return _designerBarcodeId;
	}

	public void setDesignerBarcodeId(long designerBarcodeId) {
		_designerBarcodeId = designerBarcodeId;
	}

	public long getBarcodeId() {
		return _barcodeId;
	}

	public void setBarcodeId(long barcodeId) {
		_barcodeId = barcodeId;
	}

	public long getDesignId() {
		return _designId;
	}

	public void setDesignId(long designId) {
		_designId = designId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _designerBarcodeId;
	private long _barcodeId;
	private long _designId;
	private Date _createDate;
	private Date _modifiedDate;
}