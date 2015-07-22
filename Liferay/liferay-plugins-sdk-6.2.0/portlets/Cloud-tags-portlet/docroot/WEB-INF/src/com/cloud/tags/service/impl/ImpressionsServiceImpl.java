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

import java.util.Date;

import com.cloud.tags.model.Impressions;
import com.cloud.tags.model.impl.ImpressionsImpl;
import com.cloud.tags.service.base.ImpressionsServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the impressions remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.cloud.tags.service.ImpressionsService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Mohammed Zaheer
 * @see com.cloud.tags.service.base.ImpressionsServiceBaseImpl
 * @see com.cloud.tags.service.ImpressionsServiceUtil
 */
public class ImpressionsServiceImpl extends ImpressionsServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.cloud.tags.service.ImpressionsServiceUtil} to access the impressions remote service.
	 */
	
	private Impressions getInstance() {
		return new ImpressionsImpl();
	}
	
	public Impressions addTheImpressions(String impType, String impId, String impAction,String userId, String companyId, String ipAddress,String deviceName, String deviceType,String deviceWidth, String browser,long storeId) throws SystemException{
		
		System.out.println(".......... Welcome to the Impressions Service ..........");
		
		Impressions impressions = getInstance();
		
		impressions.setCreateDate(new Date());
		impressions.setSession_Id(userId);
		impressions.setImpressionType(impType);
		impressions.setImpressionId(impId);
		impressions.setImpressionAction(impAction);
		impressions.setIpAddress(ipAddress);		
		impressions.setCompanyId(companyId);
		impressions.setDeviceName(deviceName);
		impressions.setDeviceType(deviceType);
		impressions.setDeviceWidth(deviceWidth);
		impressions.setIdeviceBrowser(browser);
		impressions.setStoreDeviceId(storeId);
		
		impressions = impressionsLocalService.addImpressions(impressions);
		return impressions;
	}
	
}