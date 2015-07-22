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
 * This class is used by SOAP remote services, specifically {@link com.cloud.tags.service.http.CustomerImagesServiceSoap}.
 *
 * @author Mohammed Zaheer
 * @see com.cloud.tags.service.http.CustomerImagesServiceSoap
 * @generated
 */
public class CustomerImagesSoap implements Serializable {
	public static CustomerImagesSoap toSoapModel(CustomerImages model) {
		CustomerImagesSoap soapModel = new CustomerImagesSoap();

		soapModel.setCustomerImageId(model.getCustomerImageId());
		soapModel.setDesignerSKU(model.getDesignerSKU());
		soapModel.setDesignerCusImage(model.getDesignerCusImage());
		soapModel.setCustomerImage(model.getCustomerImage());
		soapModel.setCustomerName(model.getCustomerName());
		soapModel.setCustomerAddress(model.getCustomerAddress());

		return soapModel;
	}

	public static CustomerImagesSoap[] toSoapModels(CustomerImages[] models) {
		CustomerImagesSoap[] soapModels = new CustomerImagesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CustomerImagesSoap[][] toSoapModels(CustomerImages[][] models) {
		CustomerImagesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CustomerImagesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CustomerImagesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CustomerImagesSoap[] toSoapModels(List<CustomerImages> models) {
		List<CustomerImagesSoap> soapModels = new ArrayList<CustomerImagesSoap>(models.size());

		for (CustomerImages model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CustomerImagesSoap[soapModels.size()]);
	}

	public CustomerImagesSoap() {
	}

	public long getPrimaryKey() {
		return _customerImageId;
	}

	public void setPrimaryKey(long pk) {
		setCustomerImageId(pk);
	}

	public long getCustomerImageId() {
		return _customerImageId;
	}

	public void setCustomerImageId(long customerImageId) {
		_customerImageId = customerImageId;
	}

	public String getDesignerSKU() {
		return _designerSKU;
	}

	public void setDesignerSKU(String designerSKU) {
		_designerSKU = designerSKU;
	}

	public String getDesignerCusImage() {
		return _designerCusImage;
	}

	public void setDesignerCusImage(String designerCusImage) {
		_designerCusImage = designerCusImage;
	}

	public String getCustomerImage() {
		return _customerImage;
	}

	public void setCustomerImage(String customerImage) {
		_customerImage = customerImage;
	}

	public String getCustomerName() {
		return _customerName;
	}

	public void setCustomerName(String customerName) {
		_customerName = customerName;
	}

	public String getCustomerAddress() {
		return _customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		_customerAddress = customerAddress;
	}

	private long _customerImageId;
	private String _designerSKU;
	private String _designerCusImage;
	private String _customerImage;
	private String _customerName;
	private String _customerAddress;
}