package com.ct.nimbus;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;

import javax.naming.NamingException;

import org.apache.log4j.Logger;



import com.cloud.tags.common.CommonUtil;
import com.cloud.tags.common.util.Constants;
import com.cloud.tags.model.Carts;
import com.cloud.tags.model.CartsDesigners;
import com.cloud.tags.service.CartsDesignersLocalServiceUtil;
import com.cloud.tags.service.CartsLocalServiceUtil;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.portlet.PortletProps;

/***
 * Nimbus Algorithm - RDBMS datasource
 * 
 *
 */
public class NimbusR {

	private final static Logger _log = Logger.getLogger(NimbusR.class.getName());

	Connection conn=null;
	int[] attributeId=null;
	int[] attributeMap=null;
	String[] attributeName=null;
	double[] attributeX=null;
	int[] designId=null;
	String[] productCode=null;
	String[] productName=null;
	String[][] productAttributes=null;
	int[][] productAttributeMap=null;
	String email=null;
	long userId=-1;
	int[] custAttributeId=null;
	double[] customerX=null;
	double[] customerP=null;
	Vector<Integer> index=null;
	Vector<Long> taps=new Vector<Long>();
	String finalProductCode="";
	String finalX="";
	String finalP="";
	// int numberOfRecommend=20;

	String dbName = "";

	Map<String,Product> designersMap = null;
	Map<Long,Product> designerMap = null;
	Map<Long, Map<String,String>> productAttributesMap = null;

	static Map<String,Double> attributesMap = new HashMap<String,Double>();

	Map<String,Double> customerXMap = new HashMap<String,Double>();
	Map<String,Double> customerPMap = new HashMap<String,Double>();


	void writeCustData() throws Exception {
		Date d1=new Date();
		if(conn==null || conn.isClosed()) {
			conn = DataAccess.getConnection();
		}
		Statement stmt=conn.createStatement();
		try{

			for(int i=0;i<custAttributeId.length;i++) {
				stmt.execute("update nimbus_user_preferences set x="+customerX[i]+", p="+customerP[i]+" where userId="+userId+" and attributeId="+custAttributeId[i]);
				finalX = Double.toString(customerX[i]);
				finalP = Double.toString(customerP[i]);
			}
			Date d2=new Date();
			_log.info("User preferences written to database in "+(d2.getTime()-d1.getTime())+" milliseconds.");
		}finally{
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
		}
	}


	List<String> displayRecommendations(int numOfRecommend, String category) throws Exception {
		Date d1=new Date();
		int[] productIndex=new int[productCode.length];
		double[] productScore=new double[productCode.length];

		double[] scoreIndex=new double[custAttributeId.length];
		for(int i=0;i<attributeId.length;i++) {
			int j=attributeMap[i];
			if(j>=0) {
				if(attributeX[i] > 0)
					scoreIndex[j]=customerX[j]/attributeX[i]*100;
				else 
					scoreIndex[j] = 0.0;
				if(scoreIndex[j]>200)
					scoreIndex[j]=200;
				//_log.info("scoreIndex[j] : "+ customerX[j] +" "+ attributeX[i] +" " + scoreIndex[j] + " "+ j);
			}
		}

		for(int i=0;i<productIndex.length;i++) {
			productIndex[i]=i;
			if(taps.contains(i)) {
				productScore[i]=0;
			} else {
				for(int j=0;j<3;j++) {
					int k=productAttributeMap[i][j];
					if(k>=0) {
						int l=attributeMap[k];
						if(l>=0)
							productScore[i]+=scoreIndex[l];
					}
				}
				productScore[i]+=Math.random();
			}
			//_log.info("productScore[i] : "+productScore[i]+" ");
		}

		for(int i=0;i<productIndex.length;i++) {
			for(int j=i+1;j<productIndex.length;j++) {
				if(productScore[i]<productScore[j]) {
					double d=productScore[i];
					productScore[i]=productScore[j];
					productScore[j]=d;
					int d2=productIndex[i];
					productIndex[i]=productIndex[j];
					productIndex[j]=d2;
				}
			}
		}
		finalProductCode="";
		List<String> productCodes = new ArrayList<String>();
		if(category == null || category.isEmpty()){
			for(int i=0;i<numOfRecommend;i++) {
				_log.info("Recommendation #"+(i+1)+": "+productCode[productIndex[i]]+" - "+productName[productIndex[i]]+" - Score: "+productScore[i]);
				//finalProductCode+=productIndex[i]+",";
				finalProductCode+=productCode[productIndex[i]]+",";
				productCodes.add(productCode[productIndex[i]]);
			}
		}else{

			int count = 0;
			int i = 0;
			while(count < numOfRecommend &&  i < productCode.length){
				Product product = designersMap.get(productCode[productIndex[i]]);
				if(product.getCategory().equalsIgnoreCase(category)){
					productCodes.add(productCode[productIndex[i]]);
					count++;
				}
				i++;
			}
		}


		Date d2=new Date();
		_log.info("Recommendations delivered in "+(d2.getTime()-d1.getTime())+" milliseconds.");

		return productCodes;
	}

	void filterProductsAdded(String session){
		List<CartsDesigners> cartDesigners = getCartProducts(session);
		for(CartsDesigners cartDesigner : cartDesigners){
			taps.add(cartDesigner.getDesignId());
		}
	}
	void tap(long selection, int R) throws Exception {
		_log.info("selection : "+selection);
		Date d1=new Date();
		taps.add(selection);
		Map<String,String> productAttributes = productAttributesMap.get(selection);
		if(productAttributes != null){
			for(int i=0;i<attributeId.length;i++) {
				double z=0;

				//for(int j=0;j<productAttributes[selection].length;j++)

				//if(productAttributes[selection][j].equals(attributeName[i]))
				//	z=1;
				for(String productAttribute : productAttributes.keySet()){
					if(productAttribute.equals(attributeName[i]))
						z=1;
				}
				int j=attributeMap[i];
				if(j>=0) {
					double k=customerP[j]/(customerP[j]+R);
					customerX[j]=customerX[j]+k*(z-customerX[j]);
					customerP[j]=customerP[j]*(1-k);
					//_log.info("tap customerX[j] : "+customerX[j] + " ");
				}
			}
		}
		Date d2=new Date();
		_log.info("Tap processed in "+(d2.getTime()-d1.getTime())+" milliseconds.");
	}


	int getSelection(String prductId) throws Exception {
		System.out.print("Enter a product number (1 to "+index.size()+") to simulate a product tap.  Enter 0 to search again, enter END to end the user session: ");
		String selection=prductId;
		if(selection.trim().toLowerCase().equals("end"))
			return -1;
		int code=-2;
		try {
			code=Integer.parseInt(selection);
			//_log.info("code : "+code);
			if(code>index.size() || code<0) code=-2;
		} catch(Exception e) {}
		if(code > 0 && code < index.size()){
			return index.elementAt(code-1);
		}
		else 
			return 0;

	}

	int productSearch(String searchTerm) throws Exception {
		int count=0;

		System.out.print("Enter product search term.  Enter END to end the user session: ");
		String search=searchTerm;
		_log.info("search term : "+searchTerm);
		if(search.equals("END")) return -1;

		index=new Vector<Integer>();

		for(int i=0;i<productCode.length;i++) {
			if(productCode[i].contains(search) || productName[i].toLowerCase().contains(search.toLowerCase())) {
				//System.out.print("  || index : "+i);
				index.add(i);
				count++;
				//_log.info(count+": "+productCode[i]+" - "+productName[i]);
			}
		}

		return count;
	}

	void readEmail(String emailAddress) throws Exception {

		if(conn==null || conn.isClosed()) {
			conn = DataAccess.getConnection();
		}

		ResultSet rs = null;
		Statement stmt=conn.createStatement();
		try{
			if(userId<0) {
				System.out.print("Enter customer e-mail address: ");
				email=emailAddress;
				rs=stmt.executeQuery("select userId from "+dbName+ "User_ where emailAddress='"+email+"'");
				if(rs.next()) {
					userId=rs.getInt(1);
				} else {
					_log.warn("E-mail address cannot be found.");
				}
			}
			if(rs != null){
				rs.close();
			}
			rs=stmt.executeQuery("select count(*) from "+dbName+ "nimbus_user_preferences where userId="+userId+" order by attributeId asc");

			int count=0;
			if(rs.next()){
				count = rs.getInt(1);
			}
			if(count > 0){
				custAttributeId=new int[count];
				customerX=new double[count];
				customerP=new double[count];
				if(rs != null)
					rs.close();
				rs=stmt.executeQuery("select attributeId,x,p from "+dbName+ "nimbus_user_preferences where userId="+userId+" order by attributeId asc");
				for(int i=0;i<custAttributeId.length;i++) {
					rs.next();
					custAttributeId[i]=rs.getInt(1);
					customerX[i]=rs.getDouble(2);
					customerP[i]=rs.getDouble(3);
				}

				attributeMap=new int[attributeId.length];

				for(int i=0;i<attributeId.length;i++) {
					attributeMap[i]=-1;
					for(int j=0;j<custAttributeId.length;j++)
						if(attributeId[i]==custAttributeId[j])
							attributeMap[i]=j;
				}
			}else{
				setAttiributesNewUser();
			}
		}finally{
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
		}

	}

	public  void init() throws Exception {
		Date d1=new Date();

		if(conn==null || conn.isClosed()) {
			conn = DataAccess.getConnection();
		}
		try{
			dbName = PortletProps.get(Constants.DB_NAME_PRPERTY);
			if(!dbName.isEmpty() )
				dbName=dbName+".";
		}catch(Exception e){

		}
		ResultSet rs= null;
		Statement stmt=conn.createStatement();
		try{
			rs=stmt.executeQuery("select count(*) from "+dbName+ "nimbus_attributes");

			int attributeCount = 0;
			if(rs.next())
				attributeCount=rs.getInt(1);
			attributeId=new int[attributeCount];
			attributeName=new String[attributeCount];
			attributeX=new double[attributeCount];


			if(rs != null)
				rs.close();
			rs=stmt.executeQuery("select attributeId,attributeName,defaultX from "+dbName+ "nimbus_attributes order by attributeId asc");
			for(int i=0;i<attributeCount;i++) {
				rs.next();
				attributeId[i]=rs.getInt(1);
				attributeName[i]=rs.getString(2);
				attributeX[i]=rs.getDouble(3);

				attributesMap.put(rs.getString(2), rs.getDouble(3));
			}

			rs=stmt.executeQuery("select count(*) from "+dbName+ "designers a,"+dbName+ "designers_images b where a.designId=b.designId and entity_image1<>'' and price<>'.00' and isactive=1");
			rs.next();
			int productCount=rs.getInt(1);
			System.out.println("Product count in Nimbus R : "+productCount);
			designId=new int[productCount];
			productCode=new String[productCount];
			productName=new String[productCount];
			productAttributes=new String[productCount][3];
			productAttributeMap=new int[productCount][3];
			designersMap =  new HashMap<String, Product>();
			designerMap = new HashMap<Long, Product>();

			productAttributesMap = new HashMap<Long, Map<String,String>>();
			rs=stmt.executeQuery("select a.designId,productCode,name,colors,productTitle,category from "+dbName+ "designers a,"+dbName+ "designers_images b where a.designId=b.designId and entity_image1<>'' and price<>'.00' and isactive=1");
			for(int i=0;i<productCount;i++) {

				Product product = new Product();
				rs.next();
				product.setDesignId(rs.getInt(1));
				product.setProductCode(rs.getString(2));
				product.setName(rs.getString(3));
				product.setColors(rs.getString(4));
				product.setProductTitle(rs.getString(5));
				product.setCategory(rs.getString(6));
				//product.setRangeType(rs.getString(7));

				Map<String, String> attributesMap = new HashMap<String, String>();

				attributesMap.put(rs.getString(4), "colors");
				attributesMap.put(rs.getString(5), "productTitle");
				attributesMap.put(rs.getString(6), "category");
				//attributesMap.put(rs.getString(7), "rangeType");

				designersMap.put(product.getProductCode(), product);

				designerMap.put(product.getDesignId(), product);

				productAttributesMap.put(product.getDesignId(),attributesMap);
				designId[i]=rs.getInt(1);
				productCode[i]=rs.getString(2);
				productName[i]=rs.getString(3);
				for(int j=0;j<3;j++) {
					productAttributes[i][j]=rs.getString(3+j);
					productAttributeMap[i][j]=-1;
					for(int k=0;k<attributeId.length;k++)
						if(attributeName[k].equals(productAttributes[i][j]))
							productAttributeMap[i][j]=k;
				}
			}
			Date d2=new Date();
			_log.info("Initialization complete in "+(d2.getTime()-d1.getTime())+" ms");
			_log.info(productAttributeMap.length +" : "+productCount);

		}finally{
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
		}

	}

	public  List<String> getNimbusResult(String email, String product_ids, String sessionId,
			int numOfRecommend, int R, String category) throws IOException,
			SQLException, NamingException {
		_log.info("getNimbusResult(String email, String product_ids)"); 
		List<String> recommendProdCodes = new ArrayList<String>();
		String loginUser = "";
		if(sessionId != null && !sessionId.isEmpty()){
			loginUser = sessionId;
		}else{
			UUID idOne = UUID.randomUUID();
			loginUser = idOne.toString();
		}
		String response = "";
		try {

			// For insialization
			init();

			readEmail(email);


			int results=productSearch("");

			if(!product_ids.isEmpty() ){
				String[] productItemIds  =  product_ids.split(",");
				for(String prodItem: productItemIds){
					/*if(results>0) {
						int selection=getSelection(prodItem);

						if(selection>0) {*/

					int selection = Integer.parseInt(prodItem);
					tap(selection, R);
					/*List<String> productCodes = displayRecommendations(numOfRecommend, category);
					if(productCodes != null)
						recommendProductCodes.addAll(productCodes);*/
					/*}
					} else {*/


					//}

					if(finalProductCode!=null && !finalProductCode.isEmpty()){
						response = finalProductCode.substring(0, finalProductCode.length()-1);
						_log.info("responseresponseresponse>>>>>>"+response);
						String xmpValues = "-"+finalX+"-"+finalP;
						/*DBUtil.addRecImpressions(prodItem, response, userId ,loginUser,xmpValues, deviceName, deviceType, 
								deviceWidth, browserName, ipAddress,from, storeDevMap );*/
						//DBUtil.addRecImpressions(prodItem, response, userId ,loginUser,xmpValues,recFrom);

					}
					//JSONObject meta = new JSONObject();	

				}

				recommendProdCodes = displayRecommendations(numOfRecommend, category);


				writeCustData();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return recommendProdCodes;
	}
	public  List<String> getNimbusResultSession(String session, String email, List<Long> product_ids, 
			long companyId, int numOfRecommend, int R, String category) throws IOException,
			SQLException, NamingException {
		_log.info("getNimbusResultSession(String session, String email,String product_ids)");
		String loginUser; 
		List<String> recommendProductCodes = new ArrayList<String>();
		if(session.isEmpty()){
			UUID idOne = UUID.randomUUID();		
			loginUser = idOne.toString();
		}else 
			loginUser = session;

		String response = "";
		try {

			// For initialization
			init();

			filterProductsAdded(session);

			//readSession(session);

			updateUserInfoForSession(session, email,  companyId, numOfRecommend, R,  category);

			//int results=productSearch("");
			if(!product_ids.isEmpty() ){
				//String[] productItemIds  =  product_ids.split(",");
				//for(String prodItem: productItemIds){
				for(Long selection: product_ids){
					/*if(results>0) {
						int selection=getSelection(prodItem);

						if(selection>0) {*/

					//int selection = Integer.parseInt(prodItem);
					tap(selection, R);
					/*List<String> productCodes = displayRecommendations(numOfRecommend, category);
					if(productCodes != null)
						recommendProductCodes.addAll(productCodes);*/
					/*}
					} else {*/


					//}

					if(finalProductCode!=null && !finalProductCode.isEmpty()){
						response = finalProductCode.substring(0, finalProductCode.length()-1);
						_log.info("responseresponseresponse>>>>>>"+response);								

					}				

				}

			}

			recommendProductCodes = displayRecommendations(numOfRecommend, category);


			writeCustDataSession(session);	

		} catch (Exception e) {
			e.printStackTrace();
		}

		//return response;
		return recommendProductCodes;
	}

	public  List<String> getNimbusResultSession(String session, String email, Long product_id, 
			long companyId, int numOfRecommend, int R, String category) throws IOException,
			SQLException, NamingException {
		_log.info("getNimbusResultSession(String session, String email,String product_ids)");
		String loginUser; 
		List<String> recommendProductCodes = new ArrayList<String>();
		if(session.isEmpty()){
			UUID idOne = UUID.randomUUID();		
			loginUser = idOne.toString();
		}else 
			loginUser = session;

		String response = "";
		try {

			// For insialization
			init();

			filterProductsAdded(session);

			//readSession(session);

			List<Long> product_Ids = new ArrayList<Long>();
			product_Ids.add(product_id);
			updateUserInfoForSession(session, email, companyId, numOfRecommend, R,  category);


			if(product_id != 0)
				tap(product_id, R);

			if(finalProductCode!=null && !finalProductCode.isEmpty()){
				response = finalProductCode.substring(0, finalProductCode.length()-1);
				_log.info("responseresponseresponse>>>>>>"+response);								

			}				

			recommendProductCodes = displayRecommendations(numOfRecommend, category);

			if(product_id != 0)
				writeCustDataSession(session);	

		} catch (Exception e) {
			e.printStackTrace();
		}

		//return response;
		return recommendProductCodes;
	}

	public  List<String> getRecommendation(String session, String email,  
			long companyId, int numOfRecommend, int R, String category) throws Exception {
		List<String> recommendProdCodes = new ArrayList<String>();
		// For initialization
		init();
		filterProductsAdded(session);
		/*if(email != null && !email.isEmpty())
			readEmail(email);
		else
			setAttiributesNewUser();*/
		updateUserInfoForSession(session, email, companyId, numOfRecommend, R,  category);
		recommendProdCodes = displayRecommendations(numOfRecommend, category);
		return recommendProdCodes;

	}

	void writeCustDataSession(String session) throws Exception {
		Date d1=new Date();
		if(conn==null || conn.isClosed()) {
			conn = DataAccess.getConnection();
		}

		Statement stmt=conn.createStatement();
		try{
			for(int i=0;i<custAttributeId.length;i++) {
				String sql = "update nimbus_user_preferences set x="+customerX[i]+", p="+customerP[i]+" where session_id="+session+" and attributeId="+custAttributeId[i];
				//_log.info("SQL : "+sql);
				stmt.execute("update nimbus_user_preferences set x="+customerX[i]+", p="+customerP[i]+" where session_id="+"'"+session+"'"+" and attributeId="+custAttributeId[i]);
				finalX = Double.toString(customerX[i]);
				finalP = Double.toString(customerP[i]);
			}
			Date d2=new Date();
			_log.info("User preferences written to database in "+(d2.getTime()-d1.getTime())+" milliseconds.");
		}finally{
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
		}
	}

	void updateUserInfoForSession(String session, String emailAddress, 			
			long companyId, int numOfRecommend, int R, String category) throws Exception{
		_log.info("updateUserInfoForSession(String session, String emailAddress)");
		if(conn==null || conn.isClosed()) {
			conn = DataAccess.getConnection();
		}

		Statement stmt=conn.createStatement();
		ResultSet rs = null;
		ResultSet res = null;
		try{
			if(emailAddress != null && !emailAddress.isEmpty()){
				_log.info("Email add : "+emailAddress);
				//while(userId<0) {			
				email=emailAddress;
				rs=stmt.executeQuery("select userId from "+dbName+ "User_ where emailAddress='"+email+"'");
				if(rs.next()) {
					userId=rs.getInt(1);
					int count= 0;
					res=stmt.executeQuery("select count(*) from "+dbName+ "nimbus_user_preferences where userId="+userId+" order by attributeId asc");
					if(res.next())
						count=res.getInt(1);

					_log.info("Count : "+count);
					if(count > 0){
						custAttributeId=new int[count];
						customerX=new double[count];
						customerP=new double[count];
						_log.info("user id : "+userId);
						ResultSet result =stmt.executeQuery("select attributeId,x,p from "+dbName+ "nimbus_user_preferences where userId="+userId+" order by attributeId asc");
						for(int i=0;i<count;i++) {
							result.next();
							//System.out.print(result.getInt(1) + " : ");
							custAttributeId[i]=result.getInt(1);
							customerX[i]=result.getDouble(2);
							customerP[i]=result.getDouble(3);
							//_log.info(custAttributeId[i] +" " +customerX[i] + " " + customerP[i]);
						}

						if(result != null)
							result.close();
						attributeMap=new int[attributeId.length];

						for(int i=0;i<attributeId.length;i++) {
							attributeMap[i]=-1;
							for(int j=0;j<custAttributeId.length;j++)
								if(attributeId[i]==custAttributeId[j])
									attributeMap[i]=j;
						}

						//int results=productSearch("");


						List<CartsDesigners> cartDesigners = getNewCartProducts(session);

						for(CartsDesigners cartDesigner : cartDesigners){
							//for(String prodItem: productItemIds){
							//if(results>0) {
							//if(!prodItem.isEmpty()){
							/*int selection=getSelection(prodItem);
									_log.info("selection "+selection);
									if(selection>0) {*/
							tap(cartDesigner.getCartDesignerId(), R);
							cartDesigner.setXPComputed(true);
							CartsDesignersLocalServiceUtil.updateCartsDesigners(cartDesigner);
							displayRecommendations(numOfRecommend, category);
							//}
							//}
							/*} else {

							writeCustData();				
						}*/
							if(finalProductCode!=null || finalProductCode==""){
								String response = finalProductCode.substring(0, finalProductCode.length()-1);
								_log.info("responseresponseresponse>>>>>>"+response);
								String xmpValues = "-"+finalX+"-"+finalP;
								//DBUtil.addRecImpressions(prodItem, response, userId ,session,xmpValues,recFrom );
								/*DBUtil.addRecImpressions(prodItem, response, userId ,session, xmpValues, deviceName, deviceType, 
									deviceWidth, browserName, ipAddress,from, storeDevMap );*/
							}

						}
						writeCustData();

						//delete session x and p after update 
						/*String sql = "delete FROM nimbus_user_preferences where userId = null && "
							+ "session_id = '"+session+"'";
					stmt = conn.createStatement();
					stmt.executeQuery(sql);*/

					} else {

						_log.info("in update email : email "+emailAddress+" userId : "+userId);
						stmt = conn.createStatement();
						String sql = "update "+dbName+"nimbus_user_preferences set userId = ? where session_id = ?";
						PreparedStatement pstmt =  conn.prepareStatement(sql);
						pstmt.setLong(1, userId);
						pstmt.setString(2,session);
						//pstmt.executeUpdate();
						stmt.execute("SET foreign_key_checks = 0");
						stmt.executeUpdate("update "+dbName+"nimbus_user_preferences set userId = "+userId +" where session_id = '"+session+"'");
						stmt.execute("SET foreign_key_checks = 1");
						stmt.close();
					}
				}else{
					_log.info("E-mail address cannot be found.");
					userId = CommonUtil.getUserByEmail(emailAddress, companyId);
					setAttiributesNewUser();
				}
				//rs.close();
				//}
			}else{
				readSession(session);
			}
		}finally{
			if(res != null)
				res.close();
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
		}

	}

	List<CartsDesigners> getCartProducts(String sessionId){
		List<CartsDesigners> cartDesigners = new ArrayList<>();

		try {
			/*List<Carts> carts = CartsLocalServiceUtil.findBySessionId(sessionId);

			long cartId = (carts != null && carts.size() > 0) ? 
					carts.get(0).getCartId() : 0;*/
			long cartId = getCartIdForSession(sessionId);
			if(cartId > 0)
				cartDesigners = CartsDesignersLocalServiceUtil.findByCartId(cartId);

		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		return cartDesigners;
	}

	List<CartsDesigners> getNewCartProducts(String sessionId){

		List<CartsDesigners> cartDesigners = new ArrayList<>();

		try {

			long cartId = getCartIdForSession(sessionId);
			if(cartId > 0)
				cartDesigners = CartsDesignersLocalServiceUtil
				.findByCartIdIsXPComputed(cartId);

		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		return cartDesigners;

	}

	long getCartIdForSession(String sessionId) throws SystemException{
		List<Carts> carts = CartsLocalServiceUtil.findBySessionId(sessionId);

		long cartId = (carts != null && carts.size() > 0) ? 
				carts.get(0).getCartId() : 0;

				return cartId;
	}

	void setAttiributesNewUser()throws Exception{		
		initCustomerAttributes();

		addUserPreferences("userId", Long.toString(userId));
	}

	void addUserPreferences(String userIdCol, String userId) throws Exception{
		if(conn==null || conn.isClosed()) {
			conn = DataAccess.getConnection();
		}
		try{
			//Statement stmt=conn.createStatement();
			String sql = "insert into nimbus_user_preferences (" + userIdCol+ ",x,p,attributeId) values (?,?,?,?)";
			for(int i=0;i<custAttributeId.length;i++) {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userId);
				pstmt.setDouble(2, customerX[i]);
				pstmt.setDouble(3, customerP[i]);
				pstmt.setDouble(4, attributeId[i]);
				pstmt.executeUpdate();
				pstmt.close();
				//_log.info("customerX[i] "+customerX[i]);
				//_log.info("insert into nimbus_user_preferences (" + userIdCol+ ",x,p) values ("+userId +","+ customerX[i]+","+customerP[i]+")");
				//stmt.execute("insert into nimbus_user_preferences (" + userIdCol+ ",x,p) values ("+userId +","+ customerX[i]+","+customerP[i]+")");
			}
		}finally{
			conn.close();
		}
	}

	void initCustomerAttributes(){
		attributeMap=new int[attributeId.length];
		custAttributeId=new int[attributeId.length];
		customerX=new double[attributeId.length];
		customerP=new double[attributeId.length];

		for(int i=0;i<attributeId.length;i++) {
			custAttributeId[i]=attributeId[i];
			customerX[i]=attributeX[i];
			customerP[i]=1.0;
			attributeMap[i] = i;
			//_log.info(customerX[i]+"  "+ customerP[i]);
		}	
	}

	void readSession(String session) throws Exception {
		_log.info("readSession(String session) : "+session);
		if(conn==null || conn.isClosed()) {
			conn = DataAccess.getConnection();
		}

		//Statement stmt=conn.createStatement();
		ResultSet res = null;
		String sql = "select count(*) from "+dbName+"nimbus_user_preferences where session_id=? order by attributeId asc";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		try{
			pstmt.setString(1, session);
			res = pstmt.executeQuery();
			//ResultSet res=stmt.executeQuery("select count(*) from "+dbName+ "nimbus_user_preferences where session_id="+session+" order by attributeId asc");
			res.next();
			int count=res.getInt(1);
			if(count > 0){
				custAttributeId=new int[count];
				customerX=new double[count];
				customerP=new double[count];
				sql = "select attributeId,x,p from "+dbName+ "nimbus_user_preferences where session_id=? order by attributeId asc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, session);
				if(res != null)
					res.close();
				res = pstmt.executeQuery();
				//res=stmt.executeQuery("select attributeId,x,p from "+dbName+ "nimbus_user_preferences where session_id="+session+" order by attributeId asc");
				for(int i=0;i<custAttributeId.length;i++) {
					res.next();
					custAttributeId[i]=res.getInt(1);
					customerX[i]=res.getDouble(2);
					customerP[i]=res.getDouble(3);
				}

				attributeMap=new int[attributeId.length];

				for(int i=0;i<attributeId.length;i++) {
					attributeMap[i]=-1;
					for(int j=0;j<custAttributeId.length;j++)
						if(attributeId[i]==custAttributeId[j])
							attributeMap[i]=j;
				}
			} else {
				_log.info("new session id.");
				setUserPreferencesSession(session);
			}
		}finally{
			if(res != null)
				res.close();
			if(pstmt != null)
				pstmt.close();
			if(conn != null)
				conn.close();
		}
	}

	void setUserPreferencesSession(String session) throws Exception{
		initCustomerAttributes();
		addUserPreferences("session_id", session);
	}


}
