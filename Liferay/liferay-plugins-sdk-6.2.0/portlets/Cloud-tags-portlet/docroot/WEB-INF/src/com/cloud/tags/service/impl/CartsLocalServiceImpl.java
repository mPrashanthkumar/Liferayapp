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
import java.util.UUID;

import com.cloud.tags.model.Carts;
import com.cloud.tags.model.impl.CartsImpl;
import com.cloud.tags.service.base.CartsLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the carts local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.cloud.tags.service.CartsLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Azam
 * @see com.cloud.tags.service.base.CartsLocalServiceBaseImpl
 * @see com.cloud.tags.service.CartsLocalServiceUtil
 */
public class CartsLocalServiceImpl extends CartsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.cloud.tags.service.CartsLocalServiceUtil} to access the carts local
	 * service.
	 */

	public Carts getInstance() {
		return new CartsImpl();
	}

	public Carts addToCarts(long userId) throws SystemException {

		Carts carts = getInstance();
		carts.setCreateDate(new Date());
		carts.setUserId(userId);
		carts.setModifiedDate(new Date());
		//UUID idOne = UUID.randomUUID();		
		//carts.setSession_id(idOne.toString());
		carts = cartsLocalService.addCarts(carts);
		return carts;
	}

	public  List<Carts> findByuserId(
			long userId) throws SystemException {
			return cartsPersistence.findByuserId(userId);
		}
	
	public List<Carts> findBySessionId(String session_id) throws SystemException{
		return cartsPersistence.findBysession_id(session_id);
	}
	/*public List<Carts> findByuserId(long userId) {
			return cartsPersistence.findByuserId(userId);

	}*/

	
	
	/*public List<CartsDesigners> getCartsDesigners(long cartId){ 
		return	cartsPersistence.getCartsDesigners(cartId); 
	}*/
	 

}