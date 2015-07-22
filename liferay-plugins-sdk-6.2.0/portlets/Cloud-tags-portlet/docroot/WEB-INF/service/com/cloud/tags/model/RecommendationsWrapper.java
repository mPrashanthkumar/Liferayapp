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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Recommendations}.
 * </p>
 *
 * @author Mohammed Zaheer
 * @see Recommendations
 * @generated
 */
public class RecommendationsWrapper implements Recommendations,
	ModelWrapper<Recommendations> {
	public RecommendationsWrapper(Recommendations recommendations) {
		_recommendations = recommendations;
	}

	@Override
	public Class<?> getModelClass() {
		return Recommendations.class;
	}

	@Override
	public String getModelClassName() {
		return Recommendations.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("recId", getRecId());
		attributes.put("designer1", getDesigner1());
		attributes.put("designer2", getDesigner2());
		attributes.put("_type", get_type());
		attributes.put("percentage", getPercentage());
		attributes.put("companyId", getCompanyId());
		attributes.put("color_name", getColor_name());
		attributes.put("color_image", getColor_image());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long recId = (Long)attributes.get("recId");

		if (recId != null) {
			setRecId(recId);
		}

		String designer1 = (String)attributes.get("designer1");

		if (designer1 != null) {
			setDesigner1(designer1);
		}

		String designer2 = (String)attributes.get("designer2");

		if (designer2 != null) {
			setDesigner2(designer2);
		}

		Long _type = (Long)attributes.get("_type");

		if (_type != null) {
			set_type(_type);
		}

		Double percentage = (Double)attributes.get("percentage");

		if (percentage != null) {
			setPercentage(percentage);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String color_name = (String)attributes.get("color_name");

		if (color_name != null) {
			setColor_name(color_name);
		}

		String color_image = (String)attributes.get("color_image");

		if (color_image != null) {
			setColor_image(color_image);
		}
	}

	/**
	* Returns the primary key of this recommendations.
	*
	* @return the primary key of this recommendations
	*/
	@Override
	public long getPrimaryKey() {
		return _recommendations.getPrimaryKey();
	}

	/**
	* Sets the primary key of this recommendations.
	*
	* @param primaryKey the primary key of this recommendations
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_recommendations.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the rec ID of this recommendations.
	*
	* @return the rec ID of this recommendations
	*/
	@Override
	public long getRecId() {
		return _recommendations.getRecId();
	}

	/**
	* Sets the rec ID of this recommendations.
	*
	* @param recId the rec ID of this recommendations
	*/
	@Override
	public void setRecId(long recId) {
		_recommendations.setRecId(recId);
	}

	/**
	* Returns the designer1 of this recommendations.
	*
	* @return the designer1 of this recommendations
	*/
	@Override
	public java.lang.String getDesigner1() {
		return _recommendations.getDesigner1();
	}

	/**
	* Sets the designer1 of this recommendations.
	*
	* @param designer1 the designer1 of this recommendations
	*/
	@Override
	public void setDesigner1(java.lang.String designer1) {
		_recommendations.setDesigner1(designer1);
	}

	/**
	* Returns the designer2 of this recommendations.
	*
	* @return the designer2 of this recommendations
	*/
	@Override
	public java.lang.String getDesigner2() {
		return _recommendations.getDesigner2();
	}

	/**
	* Sets the designer2 of this recommendations.
	*
	* @param designer2 the designer2 of this recommendations
	*/
	@Override
	public void setDesigner2(java.lang.String designer2) {
		_recommendations.setDesigner2(designer2);
	}

	/**
	* Returns the _type of this recommendations.
	*
	* @return the _type of this recommendations
	*/
	@Override
	public long get_type() {
		return _recommendations.get_type();
	}

	/**
	* Sets the _type of this recommendations.
	*
	* @param _type the _type of this recommendations
	*/
	@Override
	public void set_type(long _type) {
		_recommendations.set_type(_type);
	}

	/**
	* Returns the percentage of this recommendations.
	*
	* @return the percentage of this recommendations
	*/
	@Override
	public double getPercentage() {
		return _recommendations.getPercentage();
	}

	/**
	* Sets the percentage of this recommendations.
	*
	* @param percentage the percentage of this recommendations
	*/
	@Override
	public void setPercentage(double percentage) {
		_recommendations.setPercentage(percentage);
	}

	/**
	* Returns the company ID of this recommendations.
	*
	* @return the company ID of this recommendations
	*/
	@Override
	public long getCompanyId() {
		return _recommendations.getCompanyId();
	}

	/**
	* Sets the company ID of this recommendations.
	*
	* @param companyId the company ID of this recommendations
	*/
	@Override
	public void setCompanyId(long companyId) {
		_recommendations.setCompanyId(companyId);
	}

	/**
	* Returns the color_name of this recommendations.
	*
	* @return the color_name of this recommendations
	*/
	@Override
	public java.lang.String getColor_name() {
		return _recommendations.getColor_name();
	}

	/**
	* Sets the color_name of this recommendations.
	*
	* @param color_name the color_name of this recommendations
	*/
	@Override
	public void setColor_name(java.lang.String color_name) {
		_recommendations.setColor_name(color_name);
	}

	/**
	* Returns the color_image of this recommendations.
	*
	* @return the color_image of this recommendations
	*/
	@Override
	public java.lang.String getColor_image() {
		return _recommendations.getColor_image();
	}

	/**
	* Sets the color_image of this recommendations.
	*
	* @param color_image the color_image of this recommendations
	*/
	@Override
	public void setColor_image(java.lang.String color_image) {
		_recommendations.setColor_image(color_image);
	}

	@Override
	public boolean isNew() {
		return _recommendations.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_recommendations.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _recommendations.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_recommendations.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _recommendations.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _recommendations.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_recommendations.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _recommendations.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_recommendations.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_recommendations.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_recommendations.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RecommendationsWrapper((Recommendations)_recommendations.clone());
	}

	@Override
	public int compareTo(com.cloud.tags.model.Recommendations recommendations) {
		return _recommendations.compareTo(recommendations);
	}

	@Override
	public int hashCode() {
		return _recommendations.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.cloud.tags.model.Recommendations> toCacheModel() {
		return _recommendations.toCacheModel();
	}

	@Override
	public com.cloud.tags.model.Recommendations toEscapedModel() {
		return new RecommendationsWrapper(_recommendations.toEscapedModel());
	}

	@Override
	public com.cloud.tags.model.Recommendations toUnescapedModel() {
		return new RecommendationsWrapper(_recommendations.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _recommendations.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _recommendations.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_recommendations.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RecommendationsWrapper)) {
			return false;
		}

		RecommendationsWrapper recommendationsWrapper = (RecommendationsWrapper)obj;

		if (Validator.equals(_recommendations,
					recommendationsWrapper._recommendations)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Recommendations getWrappedRecommendations() {
		return _recommendations;
	}

	@Override
	public Recommendations getWrappedModel() {
		return _recommendations;
	}

	@Override
	public void resetOriginalValues() {
		_recommendations.resetOriginalValues();
	}

	private Recommendations _recommendations;
}