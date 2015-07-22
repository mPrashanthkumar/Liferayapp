package com.cloud.tags.common;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.portlet.PortletProps;

public class ElasticIndexUtil {

	/**
	 * @author Mohammed Zaheer
	 * @param args
	 */
	
	private static final String ELASTIC_SEARCH_SERVER = PortletProps.get("elastic.search.key");

	
	public static String convertTojson(Object obj){
		
		Gson gson = new Gson();
		return gson.toJson(obj);
		
	}
	
	public static int indextDataToElasticSearch(Object objToIndex,String indexName,String indexType){
		
		DefaultHttpClient httpClient = new DefaultHttpClient();
		String jSON = convertTojson(objToIndex);
		
        HttpPost postRequest = new HttpPost(ELASTIC_SEARCH_SERVER + indexName + StringPool.SLASH + indexType);

        try {
            
        	StringEntity entity = new StringEntity(jSON);
			entity.setContentType("application/json");
			
	        postRequest.setEntity(entity);
            HttpResponse response = httpClient.execute(postRequest);
            
            return response.getStatusLine().getStatusCode();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return 0;
		
	}
	
}
