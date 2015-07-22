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

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.cloud.tags.common.util.Constants;
import com.cloud.tags.model.Designers;
import com.cloud.tags.service.DesignersLocalServiceUtil;
import com.cloud.tags.service.base.RecommendationsServiceBaseImpl;
import com.ct.nimbus.NimbusR;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.portlet.PortletProps;

/**
 * The implementation of the recommendations remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.cloud.tags.service.RecommendationsService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Azam
 * @see com.cloud.tags.service.base.RecommendationsServiceBaseImpl
 * @see com.cloud.tags.service.RecommendationsServiceUtil
 */
public class RecommendationsServiceImpl extends RecommendationsServiceBaseImpl {
	
	private final static Logger _log = Logger
			.getLogger(RecommendationsServiceImpl.class.getName());
	
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.cloud.tags.service.RecommendationsServiceUtil} to access the recommendations remote service.
	 */
	
	public List<Designers> getNimbusRecommendations(String sessionId, String email, 
			long productId, long companyId, String category){
		int R = 0;
		int numOfRecommends = 0;
		List<Designers> recommendations =  new ArrayList<Designers>();
		try{
			R = Integer.parseInt(PortletProps.get("R"));
			numOfRecommends = Integer.parseInt(
					PortletProps.get("no.of.nimbus.recommendations"));
		}catch(Exception e){
			_log.error(e.getMessage());
		}
		
		if(R == 0)
			R = Constants.R;
		
		if(numOfRecommends == 0)
			numOfRecommends = Constants.NUM_OF_RECOMMENDATIONS;
		NimbusR nimbusR = new NimbusR();
		try {
			List<String> recommendProductCodes = nimbusR.getNimbusResultSession(
					sessionId, email, productId, companyId, numOfRecommends, R, category);
			if(recommendProductCodes != null){
				for(String productCode : recommendProductCodes){
					try {
						List<Designers> designers = DesignersLocalServiceUtil.
								getByproductCode(productCode);
						if(designers != null)
							recommendations.addAll(designers);
					} catch (SystemException e) {
						_log.error(e.getMessage());
					}
				}
			}
			
		} catch (IOException | SQLException | NamingException e) {
			_log.error(e.getMessage());
		}		
		return recommendations;
	}
}