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

package com.cloud.tags.service.messaging;

import com.cloud.tags.service.CartsDesignersLocalServiceUtil;
import com.cloud.tags.service.CartsLocalServiceUtil;
import com.cloud.tags.service.ClpSerializer;
import com.cloud.tags.service.CustomerImagesLocalServiceUtil;
import com.cloud.tags.service.CustomerImagesServiceUtil;
import com.cloud.tags.service.DesignersBarcodeLocalServiceUtil;
import com.cloud.tags.service.DesignersBarcodeServiceUtil;
import com.cloud.tags.service.DesignersImagesLocalServiceUtil;
import com.cloud.tags.service.DesignersImagesServiceUtil;
import com.cloud.tags.service.DesignersLocalServiceUtil;
import com.cloud.tags.service.DesignersServiceUtil;
import com.cloud.tags.service.ImpressionsLocalServiceUtil;
import com.cloud.tags.service.RecommendationsLocalServiceUtil;
import com.cloud.tags.service.RecommendationsServiceUtil;
import com.cloud.tags.service.StoreDeviceMapLocalServiceUtil;
import com.cloud.tags.service.StoreDeviceMapServiceUtil;
import com.cloud.tags.service.StoreInformationMapLocalServiceUtil;
import com.cloud.tags.service.StoreInformationMapServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Mohammed Zaheer
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			CartsLocalServiceUtil.clearService();

			CartsDesignersLocalServiceUtil.clearService();

			CustomerImagesLocalServiceUtil.clearService();

			CustomerImagesServiceUtil.clearService();
			DesignersLocalServiceUtil.clearService();

			DesignersServiceUtil.clearService();
			DesignersBarcodeLocalServiceUtil.clearService();

			DesignersBarcodeServiceUtil.clearService();
			DesignersImagesLocalServiceUtil.clearService();

			DesignersImagesServiceUtil.clearService();
			ImpressionsLocalServiceUtil.clearService();

			RecommendationsLocalServiceUtil.clearService();

			RecommendationsServiceUtil.clearService();
			StoreDeviceMapLocalServiceUtil.clearService();

			StoreDeviceMapServiceUtil.clearService();
			StoreInformationMapLocalServiceUtil.clearService();

			StoreInformationMapServiceUtil.clearService();
		}
	}
}