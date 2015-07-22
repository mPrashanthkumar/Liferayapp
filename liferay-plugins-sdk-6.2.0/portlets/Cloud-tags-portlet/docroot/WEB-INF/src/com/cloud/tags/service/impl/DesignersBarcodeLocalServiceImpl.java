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

package com.cloud.tags.service.impl;

import com.cloud.tags.NoSuchDesignersBarcodeException;
import com.cloud.tags.model.DesignersBarcode;
import com.cloud.tags.service.base.DesignersBarcodeLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the designers barcode local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.cloud.tags.service.DesignersBarcodeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Azam
 * @see com.cloud.tags.service.base.DesignersBarcodeLocalServiceBaseImpl
 * @see com.cloud.tags.service.DesignersBarcodeLocalServiceUtil
 */
public class DesignersBarcodeLocalServiceImpl
	extends DesignersBarcodeLocalServiceBaseImpl {
	
	public DesignersBarcode findByBarcodeId(long barcodeId)throws NoSuchDesignersBarcodeException, SystemException {
			return designersBarcodePersistence.findByBarcodeId(barcodeId);
		}
	
}