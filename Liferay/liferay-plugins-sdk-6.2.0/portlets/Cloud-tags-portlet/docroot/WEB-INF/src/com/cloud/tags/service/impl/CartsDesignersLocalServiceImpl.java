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

import com.cloud.tags.NoSuchCartsDesignersException;
import com.cloud.tags.model.CartsDesigners;
import com.cloud.tags.model.impl.CartsDesignersImpl;
import com.cloud.tags.service.CartsDesignersLocalService;
import com.cloud.tags.service.base.CartsDesignersLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the carts designers local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.cloud.tags.service.CartsDesignersLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Azam
 * @see com.cloud.tags.service.base.CartsDesignersLocalServiceBaseImpl
 * @see com.cloud.tags.service.CartsDesignersLocalServiceUtil
 */
public class CartsDesignersLocalServiceImpl extends
		CartsDesignersLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.cloud.tags.service.CartsDesignersLocalServiceUtil} to access the
	 * carts designers local service.
	 */

	public CartsDesigners getInstance() {
		return new CartsDesignersImpl();
	}

	public CartsDesigners addDesignerToCarts(long cartId, long designId,
			boolean kept) throws SystemException {

		CartsDesigners cartsDesigners = getInstance();
		cartsDesigners.setCartId(cartId);
		cartsDesigners.setDesignId(designId);
		cartsDesigners.setCreateDate(new Date());
		cartsDesigners.setModifiedDate(new Date());
		cartsDesigners.setKept(kept);
		return cartsDesignersLocalService.addCartsDesigners(cartsDesigners);

	}

	public List<CartsDesigners> findByCartId(long cartId)
			throws SystemException {
		return cartsDesignersPersistence.findByCartId(cartId);
	}
	
	public CartsDesigners findBycartIdDesignId(long cartId, long productId) throws SystemException {
		return cartsDesignersPersistence.fetchByCartIdDesignerId(cartId, productId);
	}
	
	public List<CartsDesigners> findByStaffId(String staffId)throws SystemException{
		return cartsDesignersPersistence.findByStaffId(staffId);
	}
	
	public List<CartsDesigners> findByCartIdIsXPComputed(long cartId) throws SystemException{
		return cartsDesignersPersistence.findByCartIdIsXPComputed(cartId);
	}
}