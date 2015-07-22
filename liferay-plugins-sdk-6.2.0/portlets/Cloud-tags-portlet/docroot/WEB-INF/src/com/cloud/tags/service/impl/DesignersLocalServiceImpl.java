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

import com.cloud.tags.NoSuchDesignersException;
import com.cloud.tags.common.ElasticIndexUtil;
import com.cloud.tags.model.Designers;
import com.cloud.tags.model.impl.DesignersImpl;
import com.cloud.tags.service.base.DesignersLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the designers local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.cloud.tags.service.DesignersLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Azam
 * @see com.cloud.tags.service.base.DesignersLocalServiceBaseImpl
 * @see com.cloud.tags.service.DesignersLocalServiceUtil
 */
public class DesignersLocalServiceImpl extends DesignersLocalServiceBaseImpl {
	
	public Designers getInstance(){
		return new DesignersImpl();
	}
	
	public Designers addDesigners(String name,String description,String price,String show_url,long userId,long companyId,long groupId) throws SystemException{
		
		Designers designers = getInstance();
		
		designers.setName(name);
		designers.setDescription(description);
		designers.setPrice(price);
		designers.setSaleprice(price);
		designers.setCreateDate(new Date());
		designers.setModifiedDate(new Date());
		designers.setUserId(userId);
		designers.setCompanyId(companyId);
		designers.setGroupId(groupId);
		designers.setPublic_url(show_url);
	//	ElasticIndexUtil.indextDataToElasticSearch(designers, "products", "designers");

		designers = designersLocalService.addDesigners(designers);
		
		return designers;
		
	}
	
	/*public Designers addDesigners(Designers designers ) throws SystemException{
		
		designers.setCreateDate(new Date());
		designers.setModifiedDate(new Date());
		
		designers = designersLocalService.addDesigners(designers);
		return designers;
		
	}*/
	
	public List<Designers> getByproductCode(
			String productcode)
			throws SystemException {
			return designersPersistence.findByproductCode(productcode);
		}
	
	public List<Designers> getByCompanyId(long companyId)
			throws SystemException {
			return designersPersistence.findBybyCompanyId(companyId);
		}
	public Designers getByCompanyId(long companyId,String barcode)
			throws SystemException {			
				return designersPersistence.fetchBybyCompanyIdBarcode(companyId, barcode);
	}
}