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
 * This class is a wrapper for {@link DesignersImages}.
 * </p>
 *
 * @author Mohammed Zaheer
 * @see DesignersImages
 * @generated
 */
public class DesignersImagesWrapper implements DesignersImages,
	ModelWrapper<DesignersImages> {
	public DesignersImagesWrapper(DesignersImages designersImages) {
		_designersImages = designersImages;
	}

	@Override
	public Class<?> getModelClass() {
		return DesignersImages.class;
	}

	@Override
	public String getModelClassName() {
		return DesignersImages.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("designImageId", getDesignImageId());
		attributes.put("designId", getDesignId());
		attributes.put("entity_image1", getEntity_image1());
		attributes.put("entity_image2", getEntity_image2());
		attributes.put("entity_image3", getEntity_image3());
		attributes.put("entity_image4", getEntity_image4());
		attributes.put("entity_image5", getEntity_image5());
		attributes.put("entity_image6", getEntity_image6());
		attributes.put("entity_image7", getEntity_image7());
		attributes.put("entity_image8", getEntity_image8());
		attributes.put("entity_image9", getEntity_image9());
		attributes.put("entity_image10", getEntity_image10());
		attributes.put("large_image_url", getLarge_image_url());
		attributes.put("small_image_url", getSmall_image_url());
		attributes.put("profile_image_url", getProfile_image_url());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long designImageId = (Long)attributes.get("designImageId");

		if (designImageId != null) {
			setDesignImageId(designImageId);
		}

		Long designId = (Long)attributes.get("designId");

		if (designId != null) {
			setDesignId(designId);
		}

		String entity_image1 = (String)attributes.get("entity_image1");

		if (entity_image1 != null) {
			setEntity_image1(entity_image1);
		}

		String entity_image2 = (String)attributes.get("entity_image2");

		if (entity_image2 != null) {
			setEntity_image2(entity_image2);
		}

		String entity_image3 = (String)attributes.get("entity_image3");

		if (entity_image3 != null) {
			setEntity_image3(entity_image3);
		}

		String entity_image4 = (String)attributes.get("entity_image4");

		if (entity_image4 != null) {
			setEntity_image4(entity_image4);
		}

		String entity_image5 = (String)attributes.get("entity_image5");

		if (entity_image5 != null) {
			setEntity_image5(entity_image5);
		}

		String entity_image6 = (String)attributes.get("entity_image6");

		if (entity_image6 != null) {
			setEntity_image6(entity_image6);
		}

		String entity_image7 = (String)attributes.get("entity_image7");

		if (entity_image7 != null) {
			setEntity_image7(entity_image7);
		}

		String entity_image8 = (String)attributes.get("entity_image8");

		if (entity_image8 != null) {
			setEntity_image8(entity_image8);
		}

		String entity_image9 = (String)attributes.get("entity_image9");

		if (entity_image9 != null) {
			setEntity_image9(entity_image9);
		}

		String entity_image10 = (String)attributes.get("entity_image10");

		if (entity_image10 != null) {
			setEntity_image10(entity_image10);
		}

		String large_image_url = (String)attributes.get("large_image_url");

		if (large_image_url != null) {
			setLarge_image_url(large_image_url);
		}

		String small_image_url = (String)attributes.get("small_image_url");

		if (small_image_url != null) {
			setSmall_image_url(small_image_url);
		}

		String profile_image_url = (String)attributes.get("profile_image_url");

		if (profile_image_url != null) {
			setProfile_image_url(profile_image_url);
		}
	}

	/**
	* Returns the primary key of this designers images.
	*
	* @return the primary key of this designers images
	*/
	@Override
	public long getPrimaryKey() {
		return _designersImages.getPrimaryKey();
	}

	/**
	* Sets the primary key of this designers images.
	*
	* @param primaryKey the primary key of this designers images
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_designersImages.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the design image ID of this designers images.
	*
	* @return the design image ID of this designers images
	*/
	@Override
	public long getDesignImageId() {
		return _designersImages.getDesignImageId();
	}

	/**
	* Sets the design image ID of this designers images.
	*
	* @param designImageId the design image ID of this designers images
	*/
	@Override
	public void setDesignImageId(long designImageId) {
		_designersImages.setDesignImageId(designImageId);
	}

	/**
	* Returns the design ID of this designers images.
	*
	* @return the design ID of this designers images
	*/
	@Override
	public long getDesignId() {
		return _designersImages.getDesignId();
	}

	/**
	* Sets the design ID of this designers images.
	*
	* @param designId the design ID of this designers images
	*/
	@Override
	public void setDesignId(long designId) {
		_designersImages.setDesignId(designId);
	}

	/**
	* Returns the entity_image1 of this designers images.
	*
	* @return the entity_image1 of this designers images
	*/
	@Override
	public java.lang.String getEntity_image1() {
		return _designersImages.getEntity_image1();
	}

	/**
	* Sets the entity_image1 of this designers images.
	*
	* @param entity_image1 the entity_image1 of this designers images
	*/
	@Override
	public void setEntity_image1(java.lang.String entity_image1) {
		_designersImages.setEntity_image1(entity_image1);
	}

	/**
	* Returns the entity_image2 of this designers images.
	*
	* @return the entity_image2 of this designers images
	*/
	@Override
	public java.lang.String getEntity_image2() {
		return _designersImages.getEntity_image2();
	}

	/**
	* Sets the entity_image2 of this designers images.
	*
	* @param entity_image2 the entity_image2 of this designers images
	*/
	@Override
	public void setEntity_image2(java.lang.String entity_image2) {
		_designersImages.setEntity_image2(entity_image2);
	}

	/**
	* Returns the entity_image3 of this designers images.
	*
	* @return the entity_image3 of this designers images
	*/
	@Override
	public java.lang.String getEntity_image3() {
		return _designersImages.getEntity_image3();
	}

	/**
	* Sets the entity_image3 of this designers images.
	*
	* @param entity_image3 the entity_image3 of this designers images
	*/
	@Override
	public void setEntity_image3(java.lang.String entity_image3) {
		_designersImages.setEntity_image3(entity_image3);
	}

	/**
	* Returns the entity_image4 of this designers images.
	*
	* @return the entity_image4 of this designers images
	*/
	@Override
	public java.lang.String getEntity_image4() {
		return _designersImages.getEntity_image4();
	}

	/**
	* Sets the entity_image4 of this designers images.
	*
	* @param entity_image4 the entity_image4 of this designers images
	*/
	@Override
	public void setEntity_image4(java.lang.String entity_image4) {
		_designersImages.setEntity_image4(entity_image4);
	}

	/**
	* Returns the entity_image5 of this designers images.
	*
	* @return the entity_image5 of this designers images
	*/
	@Override
	public java.lang.String getEntity_image5() {
		return _designersImages.getEntity_image5();
	}

	/**
	* Sets the entity_image5 of this designers images.
	*
	* @param entity_image5 the entity_image5 of this designers images
	*/
	@Override
	public void setEntity_image5(java.lang.String entity_image5) {
		_designersImages.setEntity_image5(entity_image5);
	}

	/**
	* Returns the entity_image6 of this designers images.
	*
	* @return the entity_image6 of this designers images
	*/
	@Override
	public java.lang.String getEntity_image6() {
		return _designersImages.getEntity_image6();
	}

	/**
	* Sets the entity_image6 of this designers images.
	*
	* @param entity_image6 the entity_image6 of this designers images
	*/
	@Override
	public void setEntity_image6(java.lang.String entity_image6) {
		_designersImages.setEntity_image6(entity_image6);
	}

	/**
	* Returns the entity_image7 of this designers images.
	*
	* @return the entity_image7 of this designers images
	*/
	@Override
	public java.lang.String getEntity_image7() {
		return _designersImages.getEntity_image7();
	}

	/**
	* Sets the entity_image7 of this designers images.
	*
	* @param entity_image7 the entity_image7 of this designers images
	*/
	@Override
	public void setEntity_image7(java.lang.String entity_image7) {
		_designersImages.setEntity_image7(entity_image7);
	}

	/**
	* Returns the entity_image8 of this designers images.
	*
	* @return the entity_image8 of this designers images
	*/
	@Override
	public java.lang.String getEntity_image8() {
		return _designersImages.getEntity_image8();
	}

	/**
	* Sets the entity_image8 of this designers images.
	*
	* @param entity_image8 the entity_image8 of this designers images
	*/
	@Override
	public void setEntity_image8(java.lang.String entity_image8) {
		_designersImages.setEntity_image8(entity_image8);
	}

	/**
	* Returns the entity_image9 of this designers images.
	*
	* @return the entity_image9 of this designers images
	*/
	@Override
	public java.lang.String getEntity_image9() {
		return _designersImages.getEntity_image9();
	}

	/**
	* Sets the entity_image9 of this designers images.
	*
	* @param entity_image9 the entity_image9 of this designers images
	*/
	@Override
	public void setEntity_image9(java.lang.String entity_image9) {
		_designersImages.setEntity_image9(entity_image9);
	}

	/**
	* Returns the entity_image10 of this designers images.
	*
	* @return the entity_image10 of this designers images
	*/
	@Override
	public java.lang.String getEntity_image10() {
		return _designersImages.getEntity_image10();
	}

	/**
	* Sets the entity_image10 of this designers images.
	*
	* @param entity_image10 the entity_image10 of this designers images
	*/
	@Override
	public void setEntity_image10(java.lang.String entity_image10) {
		_designersImages.setEntity_image10(entity_image10);
	}

	/**
	* Returns the large_image_url of this designers images.
	*
	* @return the large_image_url of this designers images
	*/
	@Override
	public java.lang.String getLarge_image_url() {
		return _designersImages.getLarge_image_url();
	}

	/**
	* Sets the large_image_url of this designers images.
	*
	* @param large_image_url the large_image_url of this designers images
	*/
	@Override
	public void setLarge_image_url(java.lang.String large_image_url) {
		_designersImages.setLarge_image_url(large_image_url);
	}

	/**
	* Returns the small_image_url of this designers images.
	*
	* @return the small_image_url of this designers images
	*/
	@Override
	public java.lang.String getSmall_image_url() {
		return _designersImages.getSmall_image_url();
	}

	/**
	* Sets the small_image_url of this designers images.
	*
	* @param small_image_url the small_image_url of this designers images
	*/
	@Override
	public void setSmall_image_url(java.lang.String small_image_url) {
		_designersImages.setSmall_image_url(small_image_url);
	}

	/**
	* Returns the profile_image_url of this designers images.
	*
	* @return the profile_image_url of this designers images
	*/
	@Override
	public java.lang.String getProfile_image_url() {
		return _designersImages.getProfile_image_url();
	}

	/**
	* Sets the profile_image_url of this designers images.
	*
	* @param profile_image_url the profile_image_url of this designers images
	*/
	@Override
	public void setProfile_image_url(java.lang.String profile_image_url) {
		_designersImages.setProfile_image_url(profile_image_url);
	}

	@Override
	public boolean isNew() {
		return _designersImages.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_designersImages.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _designersImages.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_designersImages.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _designersImages.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _designersImages.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_designersImages.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _designersImages.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_designersImages.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_designersImages.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_designersImages.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DesignersImagesWrapper((DesignersImages)_designersImages.clone());
	}

	@Override
	public int compareTo(com.cloud.tags.model.DesignersImages designersImages) {
		return _designersImages.compareTo(designersImages);
	}

	@Override
	public int hashCode() {
		return _designersImages.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.cloud.tags.model.DesignersImages> toCacheModel() {
		return _designersImages.toCacheModel();
	}

	@Override
	public com.cloud.tags.model.DesignersImages toEscapedModel() {
		return new DesignersImagesWrapper(_designersImages.toEscapedModel());
	}

	@Override
	public com.cloud.tags.model.DesignersImages toUnescapedModel() {
		return new DesignersImagesWrapper(_designersImages.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _designersImages.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _designersImages.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_designersImages.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DesignersImagesWrapper)) {
			return false;
		}

		DesignersImagesWrapper designersImagesWrapper = (DesignersImagesWrapper)obj;

		if (Validator.equals(_designersImages,
					designersImagesWrapper._designersImages)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DesignersImages getWrappedDesignersImages() {
		return _designersImages;
	}

	@Override
	public DesignersImages getWrappedModel() {
		return _designersImages;
	}

	@Override
	public void resetOriginalValues() {
		_designersImages.resetOriginalValues();
	}

	private DesignersImages _designersImages;
}