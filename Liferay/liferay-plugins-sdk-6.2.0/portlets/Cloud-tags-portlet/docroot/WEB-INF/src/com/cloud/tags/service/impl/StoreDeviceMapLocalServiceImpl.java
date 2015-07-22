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

import java.util.List;

import com.cloud.tags.model.StoreDeviceMap;
import com.cloud.tags.service.base.StoreDeviceMapLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the store device map local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.cloud.tags.service.StoreDeviceMapLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mohammed Zaheer
 * @see com.cloud.tags.service.base.StoreDeviceMapLocalServiceBaseImpl
 * @see com.cloud.tags.service.StoreDeviceMapLocalServiceUtil
 */
public class StoreDeviceMapLocalServiceImpl
	extends StoreDeviceMapLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.cloud.tags.service.StoreDeviceMapLocalServiceUtil} to access the store device map local service.
	 */
	public  List<StoreDeviceMap> findByDevice(
			java.lang.String deviceMacAddress) throws SystemException{
		return storeDeviceMapPersistence.findByDevice(deviceMacAddress);
	}
	
	public List<StoreDeviceMap> findByStoreName(String storeName)throws SystemException{
		return storeDeviceMapPersistence.findByStoreName(storeName);
	}
}