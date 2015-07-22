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

import com.cloud.tags.model.DesignersBarcode;
import com.cloud.tags.model.DesignersBarcodeModel;
import com.cloud.tags.model.DesignersBarcodeSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the DesignersBarcode service. Represents a row in the &quot;designer_barcodes&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.cloud.tags.model.DesignersBarcodeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DesignersBarcodeImpl}.
 * </p>
 *
 * @author Mohammed Zaheer
 * @see DesignersBarcodeImpl
 * @see com.cloud.tags.model.DesignersBarcode
 * @see com.cloud.tags.model.DesignersBarcodeModel
 * @generated
 */
@JSON(strict = true)
public class DesignersBarcodeModelImpl extends BaseModelImpl<DesignersBarcode>
	implements DesignersBarcodeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a designers barcode model instance should use the {@link com.cloud.tags.model.DesignersBarcode} interface instead.
	 */
	public static final String TABLE_NAME = "designer_barcodes";
	public static final Object[][] TABLE_COLUMNS = {
			{ "designerBarcodeId", Types.BIGINT },
			{ "barcodeId", Types.BIGINT },
			{ "designId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table designer_barcodes (designerBarcodeId LONG not null primary key,barcodeId LONG,designId LONG,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table designer_barcodes";
	public static final String ORDER_BY_JPQL = " ORDER BY designersBarcode.designerBarcodeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY designer_barcodes.designerBarcodeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.cloud.tags.model.DesignersBarcode"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.cloud.tags.model.DesignersBarcode"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.cloud.tags.model.DesignersBarcode"),
			true);
	public static long BARCODEID_COLUMN_BITMASK = 1L;
	public static long DESIGNERBARCODEID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static DesignersBarcode toModel(DesignersBarcodeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		DesignersBarcode model = new DesignersBarcodeImpl();

		model.setDesignerBarcodeId(soapModel.getDesignerBarcodeId());
		model.setBarcodeId(soapModel.getBarcodeId());
		model.setDesignId(soapModel.getDesignId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<DesignersBarcode> toModels(
		DesignersBarcodeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<DesignersBarcode> models = new ArrayList<DesignersBarcode>(soapModels.length);

		for (DesignersBarcodeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.cloud.tags.model.DesignersBarcode"));

	public DesignersBarcodeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _designerBarcodeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDesignerBarcodeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _designerBarcodeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DesignersBarcode.class;
	}

	@Override
	public String getModelClassName() {
		return DesignersBarcode.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("designerBarcodeId", getDesignerBarcodeId());
		attributes.put("barcodeId", getBarcodeId());
		attributes.put("designId", getDesignId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long designerBarcodeId = (Long)attributes.get("designerBarcodeId");

		if (designerBarcodeId != null) {
			setDesignerBarcodeId(designerBarcodeId);
		}

		Long barcodeId = (Long)attributes.get("barcodeId");

		if (barcodeId != null) {
			setBarcodeId(barcodeId);
		}

		Long designId = (Long)attributes.get("designId");

		if (designId != null) {
			setDesignId(designId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@JSON
	@Override
	public long getDesignerBarcodeId() {
		return _designerBarcodeId;
	}

	@Override
	public void setDesignerBarcodeId(long designerBarcodeId) {
		_designerBarcodeId = designerBarcodeId;
	}

	@JSON
	@Override
	public long getBarcodeId() {
		return _barcodeId;
	}

	@Override
	public void setBarcodeId(long barcodeId) {
		_columnBitmask |= BARCODEID_COLUMN_BITMASK;

		if (!_setOriginalBarcodeId) {
			_setOriginalBarcodeId = true;

			_originalBarcodeId = _barcodeId;
		}

		_barcodeId = barcodeId;
	}

	public long getOriginalBarcodeId() {
		return _originalBarcodeId;
	}

	@JSON
	@Override
	public long getDesignId() {
		return _designId;
	}

	@Override
	public void setDesignId(long designId) {
		_designId = designId;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			DesignersBarcode.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DesignersBarcode toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DesignersBarcode)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DesignersBarcodeImpl designersBarcodeImpl = new DesignersBarcodeImpl();

		designersBarcodeImpl.setDesignerBarcodeId(getDesignerBarcodeId());
		designersBarcodeImpl.setBarcodeId(getBarcodeId());
		designersBarcodeImpl.setDesignId(getDesignId());
		designersBarcodeImpl.setCreateDate(getCreateDate());
		designersBarcodeImpl.setModifiedDate(getModifiedDate());

		designersBarcodeImpl.resetOriginalValues();

		return designersBarcodeImpl;
	}

	@Override
	public int compareTo(DesignersBarcode designersBarcode) {
		long primaryKey = designersBarcode.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DesignersBarcode)) {
			return false;
		}

		DesignersBarcode designersBarcode = (DesignersBarcode)obj;

		long primaryKey = designersBarcode.getPrimaryKey();

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
	public void resetOriginalValues() {
		DesignersBarcodeModelImpl designersBarcodeModelImpl = this;

		designersBarcodeModelImpl._originalBarcodeId = designersBarcodeModelImpl._barcodeId;

		designersBarcodeModelImpl._setOriginalBarcodeId = false;

		designersBarcodeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DesignersBarcode> toCacheModel() {
		DesignersBarcodeCacheModel designersBarcodeCacheModel = new DesignersBarcodeCacheModel();

		designersBarcodeCacheModel.designerBarcodeId = getDesignerBarcodeId();

		designersBarcodeCacheModel.barcodeId = getBarcodeId();

		designersBarcodeCacheModel.designId = getDesignId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			designersBarcodeCacheModel.createDate = createDate.getTime();
		}
		else {
			designersBarcodeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			designersBarcodeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			designersBarcodeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return designersBarcodeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{designerBarcodeId=");
		sb.append(getDesignerBarcodeId());
		sb.append(", barcodeId=");
		sb.append(getBarcodeId());
		sb.append(", designId=");
		sb.append(getDesignId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.cloud.tags.model.DesignersBarcode");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>designerBarcodeId</column-name><column-value><![CDATA[");
		sb.append(getDesignerBarcodeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>barcodeId</column-name><column-value><![CDATA[");
		sb.append(getBarcodeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>designId</column-name><column-value><![CDATA[");
		sb.append(getDesignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = DesignersBarcode.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			DesignersBarcode.class
		};
	private long _designerBarcodeId;
	private long _barcodeId;
	private long _originalBarcodeId;
	private boolean _setOriginalBarcodeId;
	private long _designId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _columnBitmask;
	private DesignersBarcode _escapedModel;
}