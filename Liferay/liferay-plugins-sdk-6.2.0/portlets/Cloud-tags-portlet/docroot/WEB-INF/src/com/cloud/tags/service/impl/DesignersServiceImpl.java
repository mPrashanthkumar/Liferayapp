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

import java.io.File;
import java.sql.SQLException;

import com.cloud.tags.common.ReadCSV;
import com.cloud.tags.model.Designers;
import com.cloud.tags.service.DesignersLocalServiceUtil;
import com.cloud.tags.service.base.DesignersServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the designers remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.cloud.tags.service.DesignersService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Azam
 * @see com.cloud.tags.service.base.DesignersServiceBaseImpl
 * @see com.cloud.tags.service.DesignersServiceUtil
 */
public class DesignersServiceImpl extends DesignersServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.cloud.tags.service.DesignersServiceUtil} to access the designers remote service.
	 */
	public String  runFeed() {
		String msg = "success";
		Designers lDesigner = null;
		try {
			lDesigner = DesignersLocalServiceUtil.getDesigners(1);
			ReadCSV.parseTempTable(lDesigner.getCompanyId(), lDesigner.getUserId(), lDesigner.getGroupId());
		} catch (PortalException | SystemException | SQLException e) {
			msg = "failed";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return msg;
		
	}
}