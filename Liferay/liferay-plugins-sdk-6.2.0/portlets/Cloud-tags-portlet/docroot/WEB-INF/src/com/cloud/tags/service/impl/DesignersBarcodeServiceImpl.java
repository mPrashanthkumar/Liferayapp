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
import com.cloud.tags.service.base.DesignersBarcodeServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * The implementation of the designers barcode remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.cloud.tags.service.DesignersBarcodeService} interface.
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author Azam
 * @see com.cloud.tags.service.base.DesignersBarcodeServiceBaseImpl
 * @see com.cloud.tags.service.DesignersBarcodeServiceUtil
 */
public class DesignersBarcodeServiceImpl extends
		DesignersBarcodeServiceBaseImpl {

	private final String ERROR_MSG = PortletProps.get("default.designer.url"); //"No Such Product Exits with barcode Id:";

	public String getSlugURLByBarcodeId(long barcodeId) {

		System.out.println("<<<<<<<<<<<<<<I am here to call the service>>>>>>>>>>>>>>");
		
		String slug = "";//"http://74.207.225.136:9090/designers?designId=22";

		try {
			DesignersBarcode designersBarcode = designersBarcodeLocalService
					.findByBarcodeId(barcodeId);

			slug = designersLocalService.getDesigners(
					designersBarcode.getDesignId()).getSlug();

		} catch (NoSuchDesignersBarcodeException e) {
			slug = ERROR_MSG  ;
		} catch (SystemException e) {
			slug = ERROR_MSG ;
		} catch (PortalException e) {
			slug = ERROR_MSG  ;
		}

		return slug;

	}
}