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

package com.cloud.tags.service;

import com.cloud.tags.model.CartsClp;
import com.cloud.tags.model.CartsDesignersClp;
import com.cloud.tags.model.CustomerImagesClp;
import com.cloud.tags.model.DesignersBarcodeClp;
import com.cloud.tags.model.DesignersClp;
import com.cloud.tags.model.DesignersImagesClp;
import com.cloud.tags.model.ImpressionsClp;
import com.cloud.tags.model.RecommendationsClp;
import com.cloud.tags.model.StoreDeviceMapClp;
import com.cloud.tags.model.StoreInformationMapClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mohammed Zaheer
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"Cloud-tags-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"Cloud-tags-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "Cloud-tags-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CartsClp.class.getName())) {
			return translateInputCarts(oldModel);
		}

		if (oldModelClassName.equals(CartsDesignersClp.class.getName())) {
			return translateInputCartsDesigners(oldModel);
		}

		if (oldModelClassName.equals(CustomerImagesClp.class.getName())) {
			return translateInputCustomerImages(oldModel);
		}

		if (oldModelClassName.equals(DesignersClp.class.getName())) {
			return translateInputDesigners(oldModel);
		}

		if (oldModelClassName.equals(DesignersBarcodeClp.class.getName())) {
			return translateInputDesignersBarcode(oldModel);
		}

		if (oldModelClassName.equals(DesignersImagesClp.class.getName())) {
			return translateInputDesignersImages(oldModel);
		}

		if (oldModelClassName.equals(ImpressionsClp.class.getName())) {
			return translateInputImpressions(oldModel);
		}

		if (oldModelClassName.equals(RecommendationsClp.class.getName())) {
			return translateInputRecommendations(oldModel);
		}

		if (oldModelClassName.equals(StoreDeviceMapClp.class.getName())) {
			return translateInputStoreDeviceMap(oldModel);
		}

		if (oldModelClassName.equals(StoreInformationMapClp.class.getName())) {
			return translateInputStoreInformationMap(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputCarts(BaseModel<?> oldModel) {
		CartsClp oldClpModel = (CartsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCartsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCartsDesigners(BaseModel<?> oldModel) {
		CartsDesignersClp oldClpModel = (CartsDesignersClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCartsDesignersRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCustomerImages(BaseModel<?> oldModel) {
		CustomerImagesClp oldClpModel = (CustomerImagesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCustomerImagesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDesigners(BaseModel<?> oldModel) {
		DesignersClp oldClpModel = (DesignersClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDesignersRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDesignersBarcode(BaseModel<?> oldModel) {
		DesignersBarcodeClp oldClpModel = (DesignersBarcodeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDesignersBarcodeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDesignersImages(BaseModel<?> oldModel) {
		DesignersImagesClp oldClpModel = (DesignersImagesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDesignersImagesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputImpressions(BaseModel<?> oldModel) {
		ImpressionsClp oldClpModel = (ImpressionsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getImpressionsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRecommendations(BaseModel<?> oldModel) {
		RecommendationsClp oldClpModel = (RecommendationsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRecommendationsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStoreDeviceMap(BaseModel<?> oldModel) {
		StoreDeviceMapClp oldClpModel = (StoreDeviceMapClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStoreDeviceMapRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStoreInformationMap(
		BaseModel<?> oldModel) {
		StoreInformationMapClp oldClpModel = (StoreInformationMapClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStoreInformationMapRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("com.cloud.tags.model.impl.CartsImpl")) {
			return translateOutputCarts(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cloud.tags.model.impl.CartsDesignersImpl")) {
			return translateOutputCartsDesigners(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cloud.tags.model.impl.CustomerImagesImpl")) {
			return translateOutputCustomerImages(oldModel);
		}

		if (oldModelClassName.equals("com.cloud.tags.model.impl.DesignersImpl")) {
			return translateOutputDesigners(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cloud.tags.model.impl.DesignersBarcodeImpl")) {
			return translateOutputDesignersBarcode(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cloud.tags.model.impl.DesignersImagesImpl")) {
			return translateOutputDesignersImages(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cloud.tags.model.impl.ImpressionsImpl")) {
			return translateOutputImpressions(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cloud.tags.model.impl.RecommendationsImpl")) {
			return translateOutputRecommendations(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cloud.tags.model.impl.StoreDeviceMapImpl")) {
			return translateOutputStoreDeviceMap(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cloud.tags.model.impl.StoreInformationMapImpl")) {
			return translateOutputStoreInformationMap(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.cloud.tags.NoSuchCartsException")) {
			return new com.cloud.tags.NoSuchCartsException();
		}

		if (className.equals("com.cloud.tags.NoSuchCartsDesignersException")) {
			return new com.cloud.tags.NoSuchCartsDesignersException();
		}

		if (className.equals("com.cloud.tags.NoSuchCustomerImagesException")) {
			return new com.cloud.tags.NoSuchCustomerImagesException();
		}

		if (className.equals("com.cloud.tags.NoSuchDesignersException")) {
			return new com.cloud.tags.NoSuchDesignersException();
		}

		if (className.equals("com.cloud.tags.NoSuchDesignersBarcodeException")) {
			return new com.cloud.tags.NoSuchDesignersBarcodeException();
		}

		if (className.equals("com.cloud.tags.NoSuchDesignersImagesException")) {
			return new com.cloud.tags.NoSuchDesignersImagesException();
		}

		if (className.equals("com.cloud.tags.NoSuchImpressionsException")) {
			return new com.cloud.tags.NoSuchImpressionsException();
		}

		if (className.equals("com.cloud.tags.NoSuchRecommendationsException")) {
			return new com.cloud.tags.NoSuchRecommendationsException();
		}

		if (className.equals("com.cloud.tags.NoSuchStoreDeviceMapException")) {
			return new com.cloud.tags.NoSuchStoreDeviceMapException();
		}

		if (className.equals(
					"com.cloud.tags.NoSuchStoreInformationMapException")) {
			return new com.cloud.tags.NoSuchStoreInformationMapException();
		}

		return throwable;
	}

	public static Object translateOutputCarts(BaseModel<?> oldModel) {
		CartsClp newModel = new CartsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCartsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCartsDesigners(BaseModel<?> oldModel) {
		CartsDesignersClp newModel = new CartsDesignersClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCartsDesignersRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCustomerImages(BaseModel<?> oldModel) {
		CustomerImagesClp newModel = new CustomerImagesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCustomerImagesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDesigners(BaseModel<?> oldModel) {
		DesignersClp newModel = new DesignersClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDesignersRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDesignersBarcode(BaseModel<?> oldModel) {
		DesignersBarcodeClp newModel = new DesignersBarcodeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDesignersBarcodeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDesignersImages(BaseModel<?> oldModel) {
		DesignersImagesClp newModel = new DesignersImagesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDesignersImagesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputImpressions(BaseModel<?> oldModel) {
		ImpressionsClp newModel = new ImpressionsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setImpressionsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRecommendations(BaseModel<?> oldModel) {
		RecommendationsClp newModel = new RecommendationsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRecommendationsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStoreDeviceMap(BaseModel<?> oldModel) {
		StoreDeviceMapClp newModel = new StoreDeviceMapClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStoreDeviceMapRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStoreInformationMap(
		BaseModel<?> oldModel) {
		StoreInformationMapClp newModel = new StoreInformationMapClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStoreInformationMapRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}