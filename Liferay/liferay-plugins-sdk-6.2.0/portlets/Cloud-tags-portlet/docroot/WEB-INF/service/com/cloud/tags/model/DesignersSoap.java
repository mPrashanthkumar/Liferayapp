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
 * This class is used by SOAP remote services, specifically {@link com.cloud.tags.service.http.DesignersServiceSoap}.
 *
 * @author Mohammed Zaheer
 * @see com.cloud.tags.service.http.DesignersServiceSoap
 * @generated
 */
public class DesignersSoap implements Serializable {
	public static DesignersSoap toSoapModel(Designers model) {
		DesignersSoap soapModel = new DesignersSoap();

		soapModel.setDesignId(model.getDesignId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setProductTitle(model.getProductTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setShortDescription(model.getShortDescription());
		soapModel.setPrice(model.getPrice());
		soapModel.setPublic_url(model.getPublic_url());
		soapModel.setShort_url(model.getShort_url());
		soapModel.setSlug(model.getSlug());
		soapModel.setSizes(model.getSizes());
		soapModel.setColors(model.getColors());
		soapModel.setBrand(model.getBrand());
		soapModel.setSaleprice(model.getSaleprice());
		soapModel.setRetailprice(model.getRetailprice());
		soapModel.setInstock(model.getInstock());
		soapModel.setParentid(model.getParentid());
		soapModel.setCategory(model.getCategory());
		soapModel.setProductcode(model.getProductcode());
		soapModel.setBarcode(model.getBarcode());
		soapModel.setMatchWith(model.getMatchWith());
		soapModel.setTimerDate(model.getTimerDate());
		soapModel.setTabcurrent(model.getTabcurrent());
		soapModel.setLiked(model.getLiked());
		soapModel.setCtapp_shorturl(model.getCtapp_shorturl());
		soapModel.setCtapp_shorturl_success(model.getCtapp_shorturl_success());
		soapModel.setSayduck(model.getSayduck());
		soapModel.setLeft_description(model.getLeft_description());
		soapModel.setRight_description(model.getRight_description());

		return soapModel;
	}

	public static DesignersSoap[] toSoapModels(Designers[] models) {
		DesignersSoap[] soapModels = new DesignersSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DesignersSoap[][] toSoapModels(Designers[][] models) {
		DesignersSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DesignersSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DesignersSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DesignersSoap[] toSoapModels(List<Designers> models) {
		List<DesignersSoap> soapModels = new ArrayList<DesignersSoap>(models.size());

		for (Designers model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DesignersSoap[soapModels.size()]);
	}

	public DesignersSoap() {
	}

	public long getPrimaryKey() {
		return _designId;
	}

	public void setPrimaryKey(long pk) {
		setDesignId(pk);
	}

	public long getDesignId() {
		return _designId;
	}

	public void setDesignId(long designId) {
		_designId = designId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getProductTitle() {
		return _productTitle;
	}

	public void setProductTitle(String productTitle) {
		_productTitle = productTitle;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getShortDescription() {
		return _shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		_shortDescription = shortDescription;
	}

	public String getPrice() {
		return _price;
	}

	public void setPrice(String price) {
		_price = price;
	}

	public String getPublic_url() {
		return _public_url;
	}

	public void setPublic_url(String public_url) {
		_public_url = public_url;
	}

	public String getShort_url() {
		return _short_url;
	}

	public void setShort_url(String short_url) {
		_short_url = short_url;
	}

	public String getSlug() {
		return _slug;
	}

	public void setSlug(String slug) {
		_slug = slug;
	}

	public String getSizes() {
		return _sizes;
	}

	public void setSizes(String sizes) {
		_sizes = sizes;
	}

	public String getColors() {
		return _colors;
	}

	public void setColors(String colors) {
		_colors = colors;
	}

	public String getBrand() {
		return _brand;
	}

	public void setBrand(String brand) {
		_brand = brand;
	}

	public String getSaleprice() {
		return _saleprice;
	}

	public void setSaleprice(String saleprice) {
		_saleprice = saleprice;
	}

	public String getRetailprice() {
		return _retailprice;
	}

	public void setRetailprice(String retailprice) {
		_retailprice = retailprice;
	}

	public String getInstock() {
		return _instock;
	}

	public void setInstock(String instock) {
		_instock = instock;
	}

	public String getParentid() {
		return _parentid;
	}

	public void setParentid(String parentid) {
		_parentid = parentid;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public String getProductcode() {
		return _productcode;
	}

	public void setProductcode(String productcode) {
		_productcode = productcode;
	}

	public String getBarcode() {
		return _barcode;
	}

	public void setBarcode(String barcode) {
		_barcode = barcode;
	}

	public String getMatchWith() {
		return _matchWith;
	}

	public void setMatchWith(String matchWith) {
		_matchWith = matchWith;
	}

	public String getTimerDate() {
		return _timerDate;
	}

	public void setTimerDate(String timerDate) {
		_timerDate = timerDate;
	}

	public boolean getTabcurrent() {
		return _tabcurrent;
	}

	public boolean isTabcurrent() {
		return _tabcurrent;
	}

	public void setTabcurrent(boolean tabcurrent) {
		_tabcurrent = tabcurrent;
	}

	public long getLiked() {
		return _liked;
	}

	public void setLiked(long liked) {
		_liked = liked;
	}

	public boolean getCtapp_shorturl() {
		return _ctapp_shorturl;
	}

	public boolean isCtapp_shorturl() {
		return _ctapp_shorturl;
	}

	public void setCtapp_shorturl(boolean ctapp_shorturl) {
		_ctapp_shorturl = ctapp_shorturl;
	}

	public boolean getCtapp_shorturl_success() {
		return _ctapp_shorturl_success;
	}

	public boolean isCtapp_shorturl_success() {
		return _ctapp_shorturl_success;
	}

	public void setCtapp_shorturl_success(boolean ctapp_shorturl_success) {
		_ctapp_shorturl_success = ctapp_shorturl_success;
	}

	public boolean getSayduck() {
		return _sayduck;
	}

	public boolean isSayduck() {
		return _sayduck;
	}

	public void setSayduck(boolean sayduck) {
		_sayduck = sayduck;
	}

	public String getLeft_description() {
		return _left_description;
	}

	public void setLeft_description(String left_description) {
		_left_description = left_description;
	}

	public String getRight_description() {
		return _right_description;
	}

	public void setRight_description(String right_description) {
		_right_description = right_description;
	}

	private long _designId;
	private long _userId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _productTitle;
	private String _description;
	private String _shortDescription;
	private String _price;
	private String _public_url;
	private String _short_url;
	private String _slug;
	private String _sizes;
	private String _colors;
	private String _brand;
	private String _saleprice;
	private String _retailprice;
	private String _instock;
	private String _parentid;
	private String _category;
	private String _productcode;
	private String _barcode;
	private String _matchWith;
	private String _timerDate;
	private boolean _tabcurrent;
	private long _liked;
	private boolean _ctapp_shorturl;
	private boolean _ctapp_shorturl_success;
	private boolean _sayduck;
	private String _left_description;
	private String _right_description;
}