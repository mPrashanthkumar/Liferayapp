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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Designers}.
 * </p>
 *
 * @author Mohammed Zaheer
 * @see Designers
 * @generated
 */
public class DesignersWrapper implements Designers, ModelWrapper<Designers> {
	public DesignersWrapper(Designers designers) {
		_designers = designers;
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

	/**
	* Returns the primary key of this designers.
	*
	* @return the primary key of this designers
	*/
	@Override
	public long getPrimaryKey() {
		return _designers.getPrimaryKey();
	}

	/**
	* Sets the primary key of this designers.
	*
	* @param primaryKey the primary key of this designers
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_designers.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the design ID of this designers.
	*
	* @return the design ID of this designers
	*/
	@Override
	public long getDesignId() {
		return _designers.getDesignId();
	}

	/**
	* Sets the design ID of this designers.
	*
	* @param designId the design ID of this designers
	*/
	@Override
	public void setDesignId(long designId) {
		_designers.setDesignId(designId);
	}

	/**
	* Returns the user ID of this designers.
	*
	* @return the user ID of this designers
	*/
	@Override
	public long getUserId() {
		return _designers.getUserId();
	}

	/**
	* Sets the user ID of this designers.
	*
	* @param userId the user ID of this designers
	*/
	@Override
	public void setUserId(long userId) {
		_designers.setUserId(userId);
	}

	/**
	* Returns the user uuid of this designers.
	*
	* @return the user uuid of this designers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _designers.getUserUuid();
	}

	/**
	* Sets the user uuid of this designers.
	*
	* @param userUuid the user uuid of this designers
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_designers.setUserUuid(userUuid);
	}

	/**
	* Returns the company ID of this designers.
	*
	* @return the company ID of this designers
	*/
	@Override
	public long getCompanyId() {
		return _designers.getCompanyId();
	}

	/**
	* Sets the company ID of this designers.
	*
	* @param companyId the company ID of this designers
	*/
	@Override
	public void setCompanyId(long companyId) {
		_designers.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this designers.
	*
	* @return the group ID of this designers
	*/
	@Override
	public long getGroupId() {
		return _designers.getGroupId();
	}

	/**
	* Sets the group ID of this designers.
	*
	* @param groupId the group ID of this designers
	*/
	@Override
	public void setGroupId(long groupId) {
		_designers.setGroupId(groupId);
	}

	/**
	* Returns the create date of this designers.
	*
	* @return the create date of this designers
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _designers.getCreateDate();
	}

	/**
	* Sets the create date of this designers.
	*
	* @param createDate the create date of this designers
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_designers.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this designers.
	*
	* @return the modified date of this designers
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _designers.getModifiedDate();
	}

	/**
	* Sets the modified date of this designers.
	*
	* @param modifiedDate the modified date of this designers
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_designers.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this designers.
	*
	* @return the name of this designers
	*/
	@Override
	public java.lang.String getName() {
		return _designers.getName();
	}

	/**
	* Sets the name of this designers.
	*
	* @param name the name of this designers
	*/
	@Override
	public void setName(java.lang.String name) {
		_designers.setName(name);
	}

	/**
	* Returns the product title of this designers.
	*
	* @return the product title of this designers
	*/
	@Override
	public java.lang.String getProductTitle() {
		return _designers.getProductTitle();
	}

	/**
	* Sets the product title of this designers.
	*
	* @param productTitle the product title of this designers
	*/
	@Override
	public void setProductTitle(java.lang.String productTitle) {
		_designers.setProductTitle(productTitle);
	}

	/**
	* Returns the description of this designers.
	*
	* @return the description of this designers
	*/
	@Override
	public java.lang.String getDescription() {
		return _designers.getDescription();
	}

	/**
	* Sets the description of this designers.
	*
	* @param description the description of this designers
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_designers.setDescription(description);
	}

	/**
	* Returns the short description of this designers.
	*
	* @return the short description of this designers
	*/
	@Override
	public java.lang.String getShortDescription() {
		return _designers.getShortDescription();
	}

	/**
	* Sets the short description of this designers.
	*
	* @param shortDescription the short description of this designers
	*/
	@Override
	public void setShortDescription(java.lang.String shortDescription) {
		_designers.setShortDescription(shortDescription);
	}

	/**
	* Returns the price of this designers.
	*
	* @return the price of this designers
	*/
	@Override
	public java.lang.String getPrice() {
		return _designers.getPrice();
	}

	/**
	* Sets the price of this designers.
	*
	* @param price the price of this designers
	*/
	@Override
	public void setPrice(java.lang.String price) {
		_designers.setPrice(price);
	}

	/**
	* Returns the public_url of this designers.
	*
	* @return the public_url of this designers
	*/
	@Override
	public java.lang.String getPublic_url() {
		return _designers.getPublic_url();
	}

	/**
	* Sets the public_url of this designers.
	*
	* @param public_url the public_url of this designers
	*/
	@Override
	public void setPublic_url(java.lang.String public_url) {
		_designers.setPublic_url(public_url);
	}

	/**
	* Returns the short_url of this designers.
	*
	* @return the short_url of this designers
	*/
	@Override
	public java.lang.String getShort_url() {
		return _designers.getShort_url();
	}

	/**
	* Sets the short_url of this designers.
	*
	* @param short_url the short_url of this designers
	*/
	@Override
	public void setShort_url(java.lang.String short_url) {
		_designers.setShort_url(short_url);
	}

	/**
	* Returns the slug of this designers.
	*
	* @return the slug of this designers
	*/
	@Override
	public java.lang.String getSlug() {
		return _designers.getSlug();
	}

	/**
	* Sets the slug of this designers.
	*
	* @param slug the slug of this designers
	*/
	@Override
	public void setSlug(java.lang.String slug) {
		_designers.setSlug(slug);
	}

	/**
	* Returns the sizes of this designers.
	*
	* @return the sizes of this designers
	*/
	@Override
	public java.lang.String getSizes() {
		return _designers.getSizes();
	}

	/**
	* Sets the sizes of this designers.
	*
	* @param sizes the sizes of this designers
	*/
	@Override
	public void setSizes(java.lang.String sizes) {
		_designers.setSizes(sizes);
	}

	/**
	* Returns the colors of this designers.
	*
	* @return the colors of this designers
	*/
	@Override
	public java.lang.String getColors() {
		return _designers.getColors();
	}

	/**
	* Sets the colors of this designers.
	*
	* @param colors the colors of this designers
	*/
	@Override
	public void setColors(java.lang.String colors) {
		_designers.setColors(colors);
	}

	/**
	* Returns the brand of this designers.
	*
	* @return the brand of this designers
	*/
	@Override
	public java.lang.String getBrand() {
		return _designers.getBrand();
	}

	/**
	* Sets the brand of this designers.
	*
	* @param brand the brand of this designers
	*/
	@Override
	public void setBrand(java.lang.String brand) {
		_designers.setBrand(brand);
	}

	/**
	* Returns the saleprice of this designers.
	*
	* @return the saleprice of this designers
	*/
	@Override
	public java.lang.String getSaleprice() {
		return _designers.getSaleprice();
	}

	/**
	* Sets the saleprice of this designers.
	*
	* @param saleprice the saleprice of this designers
	*/
	@Override
	public void setSaleprice(java.lang.String saleprice) {
		_designers.setSaleprice(saleprice);
	}

	/**
	* Returns the retailprice of this designers.
	*
	* @return the retailprice of this designers
	*/
	@Override
	public java.lang.String getRetailprice() {
		return _designers.getRetailprice();
	}

	/**
	* Sets the retailprice of this designers.
	*
	* @param retailprice the retailprice of this designers
	*/
	@Override
	public void setRetailprice(java.lang.String retailprice) {
		_designers.setRetailprice(retailprice);
	}

	/**
	* Returns the instock of this designers.
	*
	* @return the instock of this designers
	*/
	@Override
	public java.lang.String getInstock() {
		return _designers.getInstock();
	}

	/**
	* Sets the instock of this designers.
	*
	* @param instock the instock of this designers
	*/
	@Override
	public void setInstock(java.lang.String instock) {
		_designers.setInstock(instock);
	}

	/**
	* Returns the parentid of this designers.
	*
	* @return the parentid of this designers
	*/
	@Override
	public java.lang.String getParentid() {
		return _designers.getParentid();
	}

	/**
	* Sets the parentid of this designers.
	*
	* @param parentid the parentid of this designers
	*/
	@Override
	public void setParentid(java.lang.String parentid) {
		_designers.setParentid(parentid);
	}

	/**
	* Returns the category of this designers.
	*
	* @return the category of this designers
	*/
	@Override
	public java.lang.String getCategory() {
		return _designers.getCategory();
	}

	/**
	* Sets the category of this designers.
	*
	* @param category the category of this designers
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_designers.setCategory(category);
	}

	/**
	* Returns the productcode of this designers.
	*
	* @return the productcode of this designers
	*/
	@Override
	public java.lang.String getProductcode() {
		return _designers.getProductcode();
	}

	/**
	* Sets the productcode of this designers.
	*
	* @param productcode the productcode of this designers
	*/
	@Override
	public void setProductcode(java.lang.String productcode) {
		_designers.setProductcode(productcode);
	}

	/**
	* Returns the barcode of this designers.
	*
	* @return the barcode of this designers
	*/
	@Override
	public java.lang.String getBarcode() {
		return _designers.getBarcode();
	}

	/**
	* Sets the barcode of this designers.
	*
	* @param barcode the barcode of this designers
	*/
	@Override
	public void setBarcode(java.lang.String barcode) {
		_designers.setBarcode(barcode);
	}

	/**
	* Returns the match with of this designers.
	*
	* @return the match with of this designers
	*/
	@Override
	public java.lang.String getMatchWith() {
		return _designers.getMatchWith();
	}

	/**
	* Sets the match with of this designers.
	*
	* @param matchWith the match with of this designers
	*/
	@Override
	public void setMatchWith(java.lang.String matchWith) {
		_designers.setMatchWith(matchWith);
	}

	/**
	* Returns the timer date of this designers.
	*
	* @return the timer date of this designers
	*/
	@Override
	public java.lang.String getTimerDate() {
		return _designers.getTimerDate();
	}

	/**
	* Sets the timer date of this designers.
	*
	* @param timerDate the timer date of this designers
	*/
	@Override
	public void setTimerDate(java.lang.String timerDate) {
		_designers.setTimerDate(timerDate);
	}

	/**
	* Returns the tabcurrent of this designers.
	*
	* @return the tabcurrent of this designers
	*/
	@Override
	public boolean getTabcurrent() {
		return _designers.getTabcurrent();
	}

	/**
	* Returns <code>true</code> if this designers is tabcurrent.
	*
	* @return <code>true</code> if this designers is tabcurrent; <code>false</code> otherwise
	*/
	@Override
	public boolean isTabcurrent() {
		return _designers.isTabcurrent();
	}

	/**
	* Sets whether this designers is tabcurrent.
	*
	* @param tabcurrent the tabcurrent of this designers
	*/
	@Override
	public void setTabcurrent(boolean tabcurrent) {
		_designers.setTabcurrent(tabcurrent);
	}

	/**
	* Returns the liked of this designers.
	*
	* @return the liked of this designers
	*/
	@Override
	public long getLiked() {
		return _designers.getLiked();
	}

	/**
	* Sets the liked of this designers.
	*
	* @param liked the liked of this designers
	*/
	@Override
	public void setLiked(long liked) {
		_designers.setLiked(liked);
	}

	/**
	* Returns the ctapp_shorturl of this designers.
	*
	* @return the ctapp_shorturl of this designers
	*/
	@Override
	public boolean getCtapp_shorturl() {
		return _designers.getCtapp_shorturl();
	}

	/**
	* Returns <code>true</code> if this designers is ctapp_shorturl.
	*
	* @return <code>true</code> if this designers is ctapp_shorturl; <code>false</code> otherwise
	*/
	@Override
	public boolean isCtapp_shorturl() {
		return _designers.isCtapp_shorturl();
	}

	/**
	* Sets whether this designers is ctapp_shorturl.
	*
	* @param ctapp_shorturl the ctapp_shorturl of this designers
	*/
	@Override
	public void setCtapp_shorturl(boolean ctapp_shorturl) {
		_designers.setCtapp_shorturl(ctapp_shorturl);
	}

	/**
	* Returns the ctapp_shorturl_success of this designers.
	*
	* @return the ctapp_shorturl_success of this designers
	*/
	@Override
	public boolean getCtapp_shorturl_success() {
		return _designers.getCtapp_shorturl_success();
	}

	/**
	* Returns <code>true</code> if this designers is ctapp_shorturl_success.
	*
	* @return <code>true</code> if this designers is ctapp_shorturl_success; <code>false</code> otherwise
	*/
	@Override
	public boolean isCtapp_shorturl_success() {
		return _designers.isCtapp_shorturl_success();
	}

	/**
	* Sets whether this designers is ctapp_shorturl_success.
	*
	* @param ctapp_shorturl_success the ctapp_shorturl_success of this designers
	*/
	@Override
	public void setCtapp_shorturl_success(boolean ctapp_shorturl_success) {
		_designers.setCtapp_shorturl_success(ctapp_shorturl_success);
	}

	/**
	* Returns the sayduck of this designers.
	*
	* @return the sayduck of this designers
	*/
	@Override
	public boolean getSayduck() {
		return _designers.getSayduck();
	}

	/**
	* Returns <code>true</code> if this designers is sayduck.
	*
	* @return <code>true</code> if this designers is sayduck; <code>false</code> otherwise
	*/
	@Override
	public boolean isSayduck() {
		return _designers.isSayduck();
	}

	/**
	* Sets whether this designers is sayduck.
	*
	* @param sayduck the sayduck of this designers
	*/
	@Override
	public void setSayduck(boolean sayduck) {
		_designers.setSayduck(sayduck);
	}

	/**
	* Returns the left_description of this designers.
	*
	* @return the left_description of this designers
	*/
	@Override
	public java.lang.String getLeft_description() {
		return _designers.getLeft_description();
	}

	/**
	* Sets the left_description of this designers.
	*
	* @param left_description the left_description of this designers
	*/
	@Override
	public void setLeft_description(java.lang.String left_description) {
		_designers.setLeft_description(left_description);
	}

	/**
	* Returns the right_description of this designers.
	*
	* @return the right_description of this designers
	*/
	@Override
	public java.lang.String getRight_description() {
		return _designers.getRight_description();
	}

	/**
	* Sets the right_description of this designers.
	*
	* @param right_description the right_description of this designers
	*/
	@Override
	public void setRight_description(java.lang.String right_description) {
		_designers.setRight_description(right_description);
	}

	@Override
	public boolean isNew() {
		return _designers.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_designers.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _designers.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_designers.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _designers.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _designers.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_designers.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _designers.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_designers.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_designers.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_designers.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DesignersWrapper((Designers)_designers.clone());
	}

	@Override
	public int compareTo(com.cloud.tags.model.Designers designers) {
		return _designers.compareTo(designers);
	}

	@Override
	public int hashCode() {
		return _designers.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.cloud.tags.model.Designers> toCacheModel() {
		return _designers.toCacheModel();
	}

	@Override
	public com.cloud.tags.model.Designers toEscapedModel() {
		return new DesignersWrapper(_designers.toEscapedModel());
	}

	@Override
	public com.cloud.tags.model.Designers toUnescapedModel() {
		return new DesignersWrapper(_designers.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _designers.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _designers.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_designers.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DesignersWrapper)) {
			return false;
		}

		DesignersWrapper designersWrapper = (DesignersWrapper)obj;

		if (Validator.equals(_designers, designersWrapper._designers)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Designers getWrappedDesigners() {
		return _designers;
	}

	@Override
	public Designers getWrappedModel() {
		return _designers;
	}

	@Override
	public void resetOriginalValues() {
		_designers.resetOriginalValues();
	}

	private Designers _designers;
}