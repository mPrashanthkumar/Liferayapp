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

import com.cloud.tags.NoSuchDesignersImagesException;
import com.cloud.tags.common.ElasticIndexUtil;
import com.cloud.tags.model.DesignersImages;
import com.cloud.tags.model.impl.DesignersImagesImpl;
import com.cloud.tags.service.base.DesignersImagesLocalServiceBaseImpl;
import com.cloud.tags.service.persistence.DesignersImagesUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the designers images local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.cloud.tags.service.DesignersImagesLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Azam
 * @see com.cloud.tags.service.base.DesignersImagesLocalServiceBaseImpl
 * @see com.cloud.tags.service.DesignersImagesLocalServiceUtil
 */
public class DesignersImagesLocalServiceImpl extends
		DesignersImagesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.cloud.tags.service.DesignersImagesLocalServiceUtil} to access the
	 * designers images local service.
	 */

	public DesignersImages getInstance() {
		return new DesignersImagesImpl();
	}

	public DesignersImages createDesignersImages(long designId,
			String entity_image1, String entity_image2, String entity_image3,
			String entity_image4) throws SystemException {

		DesignersImages designersImages = getInstance();

		designersImages.setDesignId(designId);
		designersImages.setEntity_image1(entity_image1);
		designersImages.setEntity_image2(entity_image2);
		designersImages.setEntity_image3(entity_image3);
		designersImages.setEntity_image4(entity_image4);
		
	//	ElasticIndexUtil.indextDataToElasticSearch(designersImages, "products", "designers");

		designersImages = designersImagesLocalService
				.addDesignersImages(designersImages);

		return designersImages;
	}

	
	public DesignersImages getByDesignId(long designId) throws NoSuchDesignersImagesException, SystemException{
		
		return DesignersImagesUtil.findBydesignId(designId);
	}
}