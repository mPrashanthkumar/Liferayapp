package com.cloud.tags.common;

import java.io.File;

import org.apache.log4j.Logger;
import org.jets3t.service.S3Service;
import org.jets3t.service.S3ServiceException;
import org.jets3t.service.acl.AccessControlList;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;
import org.jets3t.service.model.S3Bucket;
import org.jets3t.service.model.S3Object;
import org.jets3t.service.security.AWSCredentials;

import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.util.portlet.PortletProps;

public class S3Util {

	private final static Logger _log = Logger.getLogger(S3Util.class
			.getName());

	private static final String AWS_KEY = PortletProps.get("aws.key");
	private static final String AWS_SECRET = PortletProps.get("aws.secret.key");
	private static final String BUCKET = PortletProps.get("aws.bucket");
	
	static S3Service client;
	
	public static void uploadToS3(File file, String contentType, String storagePath) {
				
		S3Bucket bucket = new S3Bucket(BUCKET);
		S3Object object = new S3Object();
		object.setBucketName(BUCKET);
		object.setDataInputFile(file);
		object.setKey(storagePath);
		object.setContentType(contentType);
		object.setAcl(AccessControlList.REST_CANNED_PUBLIC_READ);
		
		try {
			object = client.putObject(bucket, object);
		} catch (S3ServiceException e1) {
			_log.info(e1.getMessage());
		}

	}


	 static  {
		
		AWSCredentials awsCredentials = 
		        new AWSCredentials(AWS_KEY, AWS_SECRET);
		try {
			
			client = new RestS3Service(awsCredentials);
		} catch (S3ServiceException e) {
			_log.info(e.getMessage());

		}
		

	}

}
