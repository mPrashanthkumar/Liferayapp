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
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.cloud.tags.NoSuchDesignersImagesException;
import com.cloud.tags.common.util.Constants;
import com.cloud.tags.common.util.ProductDetails;
import com.cloud.tags.model.Designers;
import com.cloud.tags.model.DesignersImages;
import com.cloud.tags.model.Recommendations;
import com.cloud.tags.model.impl.RecommendationsImpl;
import com.cloud.tags.service.DesignersImagesLocalServiceUtil;
import com.cloud.tags.service.DesignersLocalServiceUtil;
import com.cloud.tags.service.base.RecommendationsLocalServiceBaseImpl;
import com.ct.nimbus.NimbusR;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.portlet.PortletProps;

/**
 * The implementation of the recommendations local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.cloud.tags.service.RecommendationsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Azam
 * @see com.cloud.tags.service.base.RecommendationsLocalServiceBaseImpl
 * @see com.cloud.tags.service.RecommendationsLocalServiceUtil
 */
public class RecommendationsLocalServiceImpl
	extends RecommendationsLocalServiceBaseImpl {
	
	private final static Logger _log = Logger
			.getLogger(RecommendationsLocalServiceImpl.class.getName());
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.cloud.tags.service.RecommendationsLocalServiceUtil} to access the recommendations local service.
	 */
	public Recommendations getInstance(){
		return new RecommendationsImpl();
	}
	
	public Recommendations addRecommendations(long _type,String designer1,String designer2,double percentage, long companyId) throws SystemException{
		
		Recommendations recommendations = getInstance();
		
		recommendations.setDesigner1(designer1);
		recommendations.setDesigner2(designer2);		
		recommendations.set_type(_type);
		recommendations.setPercentage(percentage);
		recommendations.setCompanyId(companyId);
		
		
	//	ElasticIndexUtil.indextDataToElasticSearch(designers, "products", "designers");

		recommendations = recommendationsLocalService.addRecommendations(recommendations);
		
		return recommendations;
		
	}
	public List<Recommendations> getByDesigner1(
			long _type,String designer1, long companyId)
			throws SystemException {
			return recommendationsPersistence.findByByDesigner1Type(designer1, _type, companyId);
		}
	
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
	
	public List<Designers> getNimbusRecommendations(String sessionId, String email, 
			String productIds, int numOfRecommend, long companyId, String category){
		int R = 0;
		int numOfRecommends = 0;
		List<Designers> recommendations =  new ArrayList<Designers>();
		try{
			R = Integer.parseInt(PortletProps.get("R"));
			/*numOfRecommends = Integer.parseInt(
					PortletProps.get("no.of.nimbus.recommendations"));*/
		}catch(Exception e){
			_log.error(e.getMessage());
		}

		if(R == 0)
			R = Constants.R;

		if(numOfRecommends == 0)
			numOfRecommends = Constants.NUM_OF_RECOMMENDATIONS;
		NimbusR nimbusR = new NimbusR();
		try {
			List<String> recommendProductCodes = nimbusR.getNimbusResult(email, productIds,
					sessionId,  numOfRecommend, R, category);
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

	public Object getNimbusRRecommendations(String sessionId, String email, 
			long productId, long companyId, String category){
		int R = 0;
		int numOfRecommends = 0;
		List<ProductDetails> recommendations =  new ArrayList<ProductDetails>();
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
						ProductDetails productDetails = getProductDetails(productCode);
						if(productDetails != null)
							recommendations.add(productDetails);
					} catch (SystemException e) {
						_log.error(e.getMessage());
					} catch (NoSuchDesignersImagesException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		} catch (IOException | SQLException | NamingException e) {
			_log.error(e.getMessage());
		}		
		return recommendations;
	}

	ProductDetails getProductDetails(String productCode) throws NoSuchDesignersImagesException, SystemException{

		ProductDetails productDetails = null;

		List<Designers> designers = DesignersLocalServiceUtil.
				getByproductCode(productCode);

		if(designers != null && designers.size() > 0){
			Designers designer = designers.get(0);
			productDetails = new ProductDetails();
			productDetails.setDesignId(designer.getDesignId());
			productDetails.setPrice(designer.getPrice());
			productDetails.setProductCode(designer.getProductcode());
			productDetails.setName(designer.getName());
			productDetails.setProductTitle(designer.getProductTitle());
			productDetails.setCategory(designer.getCategory());
			DesignersImages designerImages = DesignersImagesLocalServiceUtil.getByDesignId(designer.getDesignId());
			productDetails.setEntity_image1(designerImages.getEntity_image1());
			productDetails.setEntity_image2(designerImages.getEntity_image2());
			productDetails.setEntity_image3(designerImages.getEntity_image3());
			productDetails.setEntity_image4(designerImages.getEntity_image4());
			productDetails.setEntity_image5(designerImages.getEntity_image5());
			productDetails.setEntity_image6(designerImages.getEntity_image6());
			productDetails.setEntity_image7(designerImages.getEntity_image7());
		}

		return productDetails;

	}
	
	
}