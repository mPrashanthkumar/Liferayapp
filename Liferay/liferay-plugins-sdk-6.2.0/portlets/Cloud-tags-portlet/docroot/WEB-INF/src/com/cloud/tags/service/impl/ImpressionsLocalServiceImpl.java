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
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.servlet.http.HttpSession;

import com.cloud.tags.model.Impressions;
import com.cloud.tags.model.impl.ImpressionsImpl;
import com.cloud.tags.service.base.ImpressionsLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.util.PortalUtil;

/**
 * The implementation of the impressions local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.cloud.tags.service.ImpressionsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mohammed Zaheer
 * @see com.cloud.tags.service.base.ImpressionsLocalServiceBaseImpl
 * @see com.cloud.tags.service.ImpressionsLocalServiceUtil
 */
public class ImpressionsLocalServiceImpl extends ImpressionsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.cloud.tags.service.ImpressionsLocalServiceUtil} to access the impressions local service.
	 */
	public Impressions getInstance() {
		return new ImpressionsImpl();
	}

	public Impressions addToImpressions(String impType, String impId, String impAction,String userId, String companyId, String ipAddress,String deviceName, String deviceType,String deviceWidth, String browser,long storeId) throws SystemException {

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
	public List<Impressions> getByImpressionTypeAction(String impType, String impAction,String sessionId, String companyId) throws SystemException{		
		
		return impressionsPersistence.findByByImpressionTypeAction(impType, impAction, sessionId, companyId);
	}
	
	public List<Impressions> getByImpressionByStoreId(long storeDeviceId) throws SystemException{		
		
		return impressionsPersistence.findByStoreDevice(storeDeviceId);
	}
	
	public List<Impressions> findByStaffId(String staffId) throws SystemException{
		return impressionsPersistence.findByStaffId(staffId);
	}
	
}