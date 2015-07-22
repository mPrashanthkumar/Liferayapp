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

import com.cloud.tags.service.ClpSerializer;
import com.cloud.tags.service.DesignersLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mohammed Zaheer
 */
public class DesignersClp extends BaseModelImpl<Designers> implements Designers {
	public DesignersClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Designers.class;
	}

	@Override
	public String getModelClassName() {
		return Designers.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _designId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDesignId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _designId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("designId", getDesignId());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("productTitle", getProductTitle());
		attributes.put("description", getDescription());
		attributes.put("shortDescription", getShortDescription());
		attributes.put("price", getPrice());
		attributes.put("public_url", getPublic_url());
		attributes.put("short_url", getShort_url());
		attributes.put("slug", getSlug());
		attributes.put("sizes", getSizes());
		attributes.put("colors", getColors());
		attributes.put("brand", getBrand());
		attributes.put("saleprice", getSaleprice());
		attributes.put("retailprice", getRetailprice());
		attributes.put("instock", getInstock());
		attributes.put("parentid", getParentid());
		attributes.put("category", getCategory());
		attributes.put("productcode", getProductcode());
		attributes.put("barcode", getBarcode());
		attributes.put("matchWith", getMatchWith());
		attributes.put("timerDate", getTimerDate());
		attributes.put("tabcurrent", getTabcurrent());
		attributes.put("liked", getLiked());
		attributes.put("ctapp_shorturl", getCtapp_shorturl());
		attributes.put("ctapp_shorturl_success", getCtapp_shorturl_success());
		attributes.put("sayduck", getSayduck());
		attributes.put("left_description", getLeft_description());
		attributes.put("right_description", getRight_description());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long designId = (Long)attributes.get("designId");

		if (designId != null) {
			setDesignId(designId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String productTitle = (String)attributes.get("productTitle");

		if (productTitle != null) {
			setProductTitle(productTitle);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String shortDescription = (String)attributes.get("shortDescription");

		if (shortDescription != null) {
			setShortDescription(shortDescription);
		}

		String price = (String)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		String public_url = (String)attributes.get("public_url");

		if (public_url != null) {
			setPublic_url(public_url);
		}

		String short_url = (String)attributes.get("short_url");

		if (short_url != null) {
			setShort_url(short_url);
		}

		String slug = (String)attributes.get("slug");

		if (slug != null) {
			setSlug(slug);
		}

		String sizes = (String)attributes.get("sizes");

		if (sizes != null) {
			setSizes(sizes);
		}

		String colors = (String)attributes.get("colors");

		if (colors != null) {
			setColors(colors);
		}

		String brand = (String)attributes.get("brand");

		if (brand != null) {
			setBrand(brand);
		}

		String saleprice = (String)attributes.get("saleprice");

		if (saleprice != null) {
			setSaleprice(saleprice);
		}

		String retailprice = (String)attributes.get("retailprice");

		if (retailprice != null) {
			setRetailprice(retailprice);
		}

		String instock = (String)attributes.get("instock");

		if (instock != null) {
			setInstock(instock);
		}

		String parentid = (String)attributes.get("parentid");

		if (parentid != null) {
			setParentid(parentid);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String productcode = (String)attributes.get("productcode");

		if (productcode != null) {
			setProductcode(productcode);
		}

		String barcode = (String)attributes.get("barcode");

		if (barcode != null) {
			setBarcode(barcode);
		}

		String matchWith = (String)attributes.get("matchWith");

		if (matchWith != null) {
			setMatchWith(matchWith);
		}

		String timerDate = (String)attributes.get("timerDate");

		if (timerDate != null) {
			setTimerDate(timerDate);
		}

		Boolean tabcurrent = (Boolean)attributes.get("tabcurrent");

		if (tabcurrent != null) {
			setTabcurrent(tabcurrent);
		}

		Long liked = (Long)attributes.get("liked");

		if (liked != null) {
			setLiked(liked);
		}

		Boolean ctapp_shorturl = (Boolean)attributes.get("ctapp_shorturl");

		if (ctapp_shorturl != null) {
			setCtapp_shorturl(ctapp_shorturl);
		}

		Boolean ctapp_shorturl_success = (Boolean)attributes.get(
				"ctapp_shorturl_success");

		if (ctapp_shorturl_success != null) {
			setCtapp_shorturl_success(ctapp_shorturl_success);
		}

		Boolean sayduck = (Boolean)attributes.get("sayduck");

		if (sayduck != null) {
			setSayduck(sayduck);
		}

		String left_description = (String)attributes.get("left_description");

		if (left_description != null) {
			setLeft_description(left_description);
		}

		String right_description = (String)attributes.get("right_description");

		if (right_description != null) {
			setRight_description(right_description);
		}
	}

	@Override
	public long getDesignId() {
		return _designId;
	}

	@Override
	public void setDesignId(long designId) {
		_designId = designId;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setDesignId", long.class);

				method.invoke(_designersRemoteModel, designId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_designersRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_designersRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_designersRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_designersRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_designersRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_designersRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProductTitle() {
		return _productTitle;
	}

	@Override
	public void setProductTitle(String productTitle) {
		_productTitle = productTitle;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setProductTitle", String.class);

				method.invoke(_designersRemoteModel, productTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_designersRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShortDescription() {
		return _shortDescription;
	}

	@Override
	public void setShortDescription(String shortDescription) {
		_shortDescription = shortDescription;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setShortDescription",
						String.class);

				method.invoke(_designersRemoteModel, shortDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrice() {
		return _price;
	}

	@Override
	public void setPrice(String price) {
		_price = price;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setPrice", String.class);

				method.invoke(_designersRemoteModel, price);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPublic_url() {
		return _public_url;
	}

	@Override
	public void setPublic_url(String public_url) {
		_public_url = public_url;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setPublic_url", String.class);

				method.invoke(_designersRemoteModel, public_url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShort_url() {
		return _short_url;
	}

	@Override
	public void setShort_url(String short_url) {
		_short_url = short_url;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setShort_url", String.class);

				method.invoke(_designersRemoteModel, short_url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSlug() {
		return _slug;
	}

	@Override
	public void setSlug(String slug) {
		_slug = slug;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setSlug", String.class);

				method.invoke(_designersRemoteModel, slug);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSizes() {
		return _sizes;
	}

	@Override
	public void setSizes(String sizes) {
		_sizes = sizes;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setSizes", String.class);

				method.invoke(_designersRemoteModel, sizes);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColors() {
		return _colors;
	}

	@Override
	public void setColors(String colors) {
		_colors = colors;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setColors", String.class);

				method.invoke(_designersRemoteModel, colors);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBrand() {
		return _brand;
	}

	@Override
	public void setBrand(String brand) {
		_brand = brand;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setBrand", String.class);

				method.invoke(_designersRemoteModel, brand);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSaleprice() {
		return _saleprice;
	}

	@Override
	public void setSaleprice(String saleprice) {
		_saleprice = saleprice;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setSaleprice", String.class);

				method.invoke(_designersRemoteModel, saleprice);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRetailprice() {
		return _retailprice;
	}

	@Override
	public void setRetailprice(String retailprice) {
		_retailprice = retailprice;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setRetailprice", String.class);

				method.invoke(_designersRemoteModel, retailprice);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInstock() {
		return _instock;
	}

	@Override
	public void setInstock(String instock) {
		_instock = instock;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setInstock", String.class);

				method.invoke(_designersRemoteModel, instock);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getParentid() {
		return _parentid;
	}

	@Override
	public void setParentid(String parentid) {
		_parentid = parentid;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setParentid", String.class);

				method.invoke(_designersRemoteModel, parentid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCategory() {
		return _category;
	}

	@Override
	public void setCategory(String category) {
		_category = category;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory", String.class);

				method.invoke(_designersRemoteModel, category);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProductcode() {
		return _productcode;
	}

	@Override
	public void setProductcode(String productcode) {
		_productcode = productcode;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setProductcode", String.class);

				method.invoke(_designersRemoteModel, productcode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBarcode() {
		return _barcode;
	}

	@Override
	public void setBarcode(String barcode) {
		_barcode = barcode;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setBarcode", String.class);

				method.invoke(_designersRemoteModel, barcode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMatchWith() {
		return _matchWith;
	}

	@Override
	public void setMatchWith(String matchWith) {
		_matchWith = matchWith;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setMatchWith", String.class);

				method.invoke(_designersRemoteModel, matchWith);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTimerDate() {
		return _timerDate;
	}

	@Override
	public void setTimerDate(String timerDate) {
		_timerDate = timerDate;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setTimerDate", String.class);

				method.invoke(_designersRemoteModel, timerDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getTabcurrent() {
		return _tabcurrent;
	}

	@Override
	public boolean isTabcurrent() {
		return _tabcurrent;
	}

	@Override
	public void setTabcurrent(boolean tabcurrent) {
		_tabcurrent = tabcurrent;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setTabcurrent", boolean.class);

				method.invoke(_designersRemoteModel, tabcurrent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLiked() {
		return _liked;
	}

	@Override
	public void setLiked(long liked) {
		_liked = liked;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setLiked", long.class);

				method.invoke(_designersRemoteModel, liked);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCtapp_shorturl() {
		return _ctapp_shorturl;
	}

	@Override
	public boolean isCtapp_shorturl() {
		return _ctapp_shorturl;
	}

	@Override
	public void setCtapp_shorturl(boolean ctapp_shorturl) {
		_ctapp_shorturl = ctapp_shorturl;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setCtapp_shorturl",
						boolean.class);

				method.invoke(_designersRemoteModel, ctapp_shorturl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCtapp_shorturl_success() {
		return _ctapp_shorturl_success;
	}

	@Override
	public boolean isCtapp_shorturl_success() {
		return _ctapp_shorturl_success;
	}

	@Override
	public void setCtapp_shorturl_success(boolean ctapp_shorturl_success) {
		_ctapp_shorturl_success = ctapp_shorturl_success;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setCtapp_shorturl_success",
						boolean.class);

				method.invoke(_designersRemoteModel, ctapp_shorturl_success);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getSayduck() {
		return _sayduck;
	}

	@Override
	public boolean isSayduck() {
		return _sayduck;
	}

	@Override
	public void setSayduck(boolean sayduck) {
		_sayduck = sayduck;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setSayduck", boolean.class);

				method.invoke(_designersRemoteModel, sayduck);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLeft_description() {
		return _left_description;
	}

	@Override
	public void setLeft_description(String left_description) {
		_left_description = left_description;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setLeft_description",
						String.class);

				method.invoke(_designersRemoteModel, left_description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRight_description() {
		return _right_description;
	}

	@Override
	public void setRight_description(String right_description) {
		_right_description = right_description;

		if (_designersRemoteModel != null) {
			try {
				Class<?> clazz = _designersRemoteModel.getClass();

				Method method = clazz.getMethod("setRight_description",
						String.class);

				method.invoke(_designersRemoteModel, right_description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDesignersRemoteModel() {
		return _designersRemoteModel;
	}

	public void setDesignersRemoteModel(BaseModel<?> designersRemoteModel) {
		_designersRemoteModel = designersRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _designersRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_designersRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DesignersLocalServiceUtil.addDesigners(this);
		}
		else {
			DesignersLocalServiceUtil.updateDesigners(this);
		}
	}

	@Override
	public Designers toEscapedModel() {
		return (Designers)ProxyUtil.newProxyInstance(Designers.class.getClassLoader(),
			new Class[] { Designers.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DesignersClp clone = new DesignersClp();

		clone.setDesignId(getDesignId());
		clone.setUserId(getUserId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setProductTitle(getProductTitle());
		clone.setDescription(getDescription());
		clone.setShortDescription(getShortDescription());
		clone.setPrice(getPrice());
		clone.setPublic_url(getPublic_url());
		clone.setShort_url(getShort_url());
		clone.setSlug(getSlug());
		clone.setSizes(getSizes());
		clone.setColors(getColors());
		clone.setBrand(getBrand());
		clone.setSaleprice(getSaleprice());
		clone.setRetailprice(getRetailprice());
		clone.setInstock(getInstock());
		clone.setParentid(getParentid());
		clone.setCategory(getCategory());
		clone.setProductcode(getProductcode());
		clone.setBarcode(getBarcode());
		clone.setMatchWith(getMatchWith());
		clone.setTimerDate(getTimerDate());
		clone.setTabcurrent(getTabcurrent());
		clone.setLiked(getLiked());
		clone.setCtapp_shorturl(getCtapp_shorturl());
		clone.setCtapp_shorturl_success(getCtapp_shorturl_success());
		clone.setSayduck(getSayduck());
		clone.setLeft_description(getLeft_description());
		clone.setRight_description(getRight_description());

		return clone;
	}

	@Override
	public int compareTo(Designers designers) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), designers.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DesignersClp)) {
			return false;
		}

		DesignersClp designers = (DesignersClp)obj;

		long primaryKey = designers.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(67);

		sb.append("{designId=");
		sb.append(getDesignId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", productTitle=");
		sb.append(getProductTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", shortDescription=");
		sb.append(getShortDescription());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", public_url=");
		sb.append(getPublic_url());
		sb.append(", short_url=");
		sb.append(getShort_url());
		sb.append(", slug=");
		sb.append(getSlug());
		sb.append(", sizes=");
		sb.append(getSizes());
		sb.append(", colors=");
		sb.append(getColors());
		sb.append(", brand=");
		sb.append(getBrand());
		sb.append(", saleprice=");
		sb.append(getSaleprice());
		sb.append(", retailprice=");
		sb.append(getRetailprice());
		sb.append(", instock=");
		sb.append(getInstock());
		sb.append(", parentid=");
		sb.append(getParentid());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", productcode=");
		sb.append(getProductcode());
		sb.append(", barcode=");
		sb.append(getBarcode());
		sb.append(", matchWith=");
		sb.append(getMatchWith());
		sb.append(", timerDate=");
		sb.append(getTimerDate());
		sb.append(", tabcurrent=");
		sb.append(getTabcurrent());
		sb.append(", liked=");
		sb.append(getLiked());
		sb.append(", ctapp_shorturl=");
		sb.append(getCtapp_shorturl());
		sb.append(", ctapp_shorturl_success=");
		sb.append(getCtapp_shorturl_success());
		sb.append(", sayduck=");
		sb.append(getSayduck());
		sb.append(", left_description=");
		sb.append(getLeft_description());
		sb.append(", right_description=");
		sb.append(getRight_description());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(103);

		sb.append("<model><model-name>");
		sb.append("com.cloud.tags.model.Designers");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>designId</column-name><column-value><![CDATA[");
		sb.append(getDesignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productTitle</column-name><column-value><![CDATA[");
		sb.append(getProductTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shortDescription</column-name><column-value><![CDATA[");
		sb.append(getShortDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>public_url</column-name><column-value><![CDATA[");
		sb.append(getPublic_url());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>short_url</column-name><column-value><![CDATA[");
		sb.append(getShort_url());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>slug</column-name><column-value><![CDATA[");
		sb.append(getSlug());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sizes</column-name><column-value><![CDATA[");
		sb.append(getSizes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>colors</column-name><column-value><![CDATA[");
		sb.append(getColors());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>brand</column-name><column-value><![CDATA[");
		sb.append(getBrand());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>saleprice</column-name><column-value><![CDATA[");
		sb.append(getSaleprice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>retailprice</column-name><column-value><![CDATA[");
		sb.append(getRetailprice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>instock</column-name><column-value><![CDATA[");
		sb.append(getInstock());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentid</column-name><column-value><![CDATA[");
		sb.append(getParentid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productcode</column-name><column-value><![CDATA[");
		sb.append(getProductcode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>barcode</column-name><column-value><![CDATA[");
		sb.append(getBarcode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>matchWith</column-name><column-value><![CDATA[");
		sb.append(getMatchWith());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timerDate</column-name><column-value><![CDATA[");
		sb.append(getTimerDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tabcurrent</column-name><column-value><![CDATA[");
		sb.append(getTabcurrent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>liked</column-name><column-value><![CDATA[");
		sb.append(getLiked());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ctapp_shorturl</column-name><column-value><![CDATA[");
		sb.append(getCtapp_shorturl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ctapp_shorturl_success</column-name><column-value><![CDATA[");
		sb.append(getCtapp_shorturl_success());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sayduck</column-name><column-value><![CDATA[");
		sb.append(getSayduck());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>left_description</column-name><column-value><![CDATA[");
		sb.append(getLeft_description());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>right_description</column-name><column-value><![CDATA[");
		sb.append(getRight_description());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _designId;
	private long _userId;
	private String _userUuid;
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
	private BaseModel<?> _designersRemoteModel;
}