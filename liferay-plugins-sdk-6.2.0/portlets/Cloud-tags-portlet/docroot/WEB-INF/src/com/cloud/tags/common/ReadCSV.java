package com.cloud.tags.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import au.com.bytecode.opencsv.CSVReader;

import com.cloud.tags.NoSuchDesignersImagesException;
import com.cloud.tags.model.Designers;
import com.cloud.tags.model.DesignersImages;
import com.cloud.tags.model.Recommendations;
import com.cloud.tags.service.DesignersImagesLocalServiceUtil;
import com.cloud.tags.service.DesignersLocalServiceUtil;
import com.cloud.tags.service.RecommendationsLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
/**
 * 
 * @author Mohammed Zaheer
 * @author Azam
 *
 */

public class ReadCSV {

	private final static Logger _log = Logger.getLogger(ReadCSV.class
			.getName());

	/**
	 * 
	 * @param csvFile
	 * @param userId
	 * @param companyId
	 * @param groupId
	 * @param portalURL
	 * @throws SystemException 
	 * @throws NoSuchDesignersImagesException 
	 */
	public static void parseCSV(File csvFile,  long userId, long companyId, long groupId,String portalURL){		


		CSVReader reader = null;
		// Made.com
		try {
			reader = new CSVReader(new FileReader(csvFile));
			String[] nextLine;
			int lineNumber = 0;
			while ((nextLine = reader.readNext()) != null) {
				if(lineNumber >= 1) {
					//System.out.println("nextLine[12]>>"+nextLine[12]);
					Designers designers = null;
					try {
						designers = DesignersLocalServiceUtil.getByCompanyId(companyId, nextLine[2]);
					} catch (SystemException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					if(Validator.isNull(designers)){
						designers=DesignersLocalServiceUtil.getInstance();


						designers.setName(nextLine[7]);
						designers.setProductTitle(nextLine[29]);
						designers.setBrand(nextLine[5]);
						designers.setDescription(nextLine[32]);
						designers.setShortDescription(nextLine[30]);

						designers.setPrice(nextLine[15]);
						designers.setSaleprice(nextLine[25]);
						designers.setPublic_url(nextLine[11]);
						designers.setCategory(nextLine[0]);

						designers.setSizes(nextLine[18]);
						designers.setColors(nextLine[20]);
						designers.setInstock(nextLine[14]);
						//designers.setParentid(nextLine[14]);
						designers.setRetailprice(nextLine[15]);
						designers.setProductcode(nextLine[3]);
						designers.setBarcode(nextLine[2]);
						designers.setMatchWith(nextLine[31]);

						designers.setCreateDate(new Date());
						designers.setModifiedDate(new Date());

						designers.setUserId(userId);
						designers.setCompanyId(companyId);
						designers.setGroupId(groupId);
						designers.setTimerDate(nextLine[23]);
						designers.setCtapp_shorturl(true);
						designers.setSlug(portalURL + "/designers?designId=" + designers.getDesignId()+"&from=NFC");

						try {
							designers = DesignersLocalServiceUtil.addDesigners(designers);
						} catch (SystemException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						DesignersImages designersImages = DesignersImagesLocalServiceUtil.getInstance();					

						designersImages.setDesignId(designers.getDesignId());				

						try {
							if(Validator.isNotNull(nextLine[33]))
								designersImages.setEntity_image1(CommonUtil.multiDimensions(nextLine[33], designers.getDesignId()  , designers.getCompanyId(),true));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}

						try {
							if(Validator.isNotNull(nextLine[34]))
								designersImages.setEntity_image2(CommonUtil.multiDimensions(nextLine[34], designers.getDesignId()  , designers.getCompanyId(),false));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}

						try {
							if(Validator.isNotNull(nextLine[35]))
								designersImages.setEntity_image3(CommonUtil.multiDimensions(nextLine[35], designers.getDesignId()  , designers.getCompanyId(),false));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}

						try {
							if(Validator.isNotNull(nextLine[36]))
								designersImages.setEntity_image4(CommonUtil.multiDimensions(nextLine[36], designers.getDesignId()  , designers.getCompanyId(),false));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}

						try {
							if(Validator.isNotNull(nextLine[37]))
								designersImages.setEntity_image5(CommonUtil.multiDimensions(nextLine[37], designers.getDesignId()  , designers.getCompanyId(),false));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}

						try {
							if(Validator.isNotNull(nextLine[38]))
								designersImages.setEntity_image6(CommonUtil.multiDimensions(nextLine[38], designers.getDesignId()  , designers.getCompanyId(),false));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}

						try {
							if(Validator.isNotNull(nextLine[39]))
								designersImages.setEntity_image7(CommonUtil.multiDimensions(nextLine[39], designers.getDesignId()  , designers.getCompanyId(),false));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}

						try {
							if(Validator.isNotNull(nextLine[40]))
								designersImages.setEntity_image8(CommonUtil.multiDimensions(nextLine[40], designers.getDesignId()  , designers.getCompanyId(),false));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}
						try {
							if(Validator.isNotNull(nextLine[41]))
								designersImages.setEntity_image9(CommonUtil.multiDimensions(nextLine[41], designers.getDesignId()  , designers.getCompanyId(),false));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}

						try {
							if(Validator.isNotNull(nextLine[42]))
								designersImages.setEntity_image10(CommonUtil.multiDimensions(nextLine[42], designers.getDesignId()  , designers.getCompanyId(),false));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}

						designersImages.setSmall_image_url(nextLine[10]);						
						try {
							DesignersImagesLocalServiceUtil.addDesignersImages(designersImages);
						} catch (SystemException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}else{						

						DesignersImages updateDesignersImages = null;
						try {
							updateDesignersImages = DesignersImagesLocalServiceUtil.getByDesignId(designers.getDesignId());
						} catch (NoSuchDesignersImagesException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SystemException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if(Validator.isNotNull(updateDesignersImages)){

							try {
								if(Validator.isNull(updateDesignersImages.getEntity_image1()))
									updateDesignersImages.setEntity_image1(CommonUtil.multiDimensions(nextLine[33], designers.getDesignId()  , designers.getCompanyId(),true));
							} catch (Exception e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
							}
							try {
								if(Validator.isNull(updateDesignersImages.getEntity_image2()))
									updateDesignersImages.setEntity_image2(CommonUtil.multiDimensions(nextLine[34], designers.getDesignId()  , designers.getCompanyId(),false));
							} catch (Exception e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
							}

							try {
								if(Validator.isNull(updateDesignersImages.getEntity_image3()))
									updateDesignersImages.setEntity_image3(CommonUtil.multiDimensions(nextLine[35], designers.getDesignId()  , designers.getCompanyId(),false));
							} catch (Exception e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
							}

							try {
								if(Validator.isNull(updateDesignersImages.getEntity_image4()))
									updateDesignersImages.setEntity_image4(CommonUtil.multiDimensions(nextLine[36], designers.getDesignId()  , designers.getCompanyId(),false));
							} catch (Exception e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
							}

							try {
								if(Validator.isNull(updateDesignersImages.getEntity_image5()))
									updateDesignersImages.setEntity_image5(CommonUtil.multiDimensions(nextLine[37], designers.getDesignId()  , designers.getCompanyId(),false));
							} catch (Exception e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
							}

							try {
								if(Validator.isNull(updateDesignersImages.getEntity_image6()))
									updateDesignersImages.setEntity_image6(CommonUtil.multiDimensions(nextLine[38], designers.getDesignId()  , designers.getCompanyId(),false));
							} catch (Exception e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
							}

							try {
								if(Validator.isNull(updateDesignersImages.getEntity_image7()))
									updateDesignersImages.setEntity_image7(CommonUtil.multiDimensions(nextLine[39], designers.getDesignId()  , designers.getCompanyId(),false));
							} catch (Exception e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
							}

							try {
								if(Validator.isNull(updateDesignersImages.getEntity_image8()))
									updateDesignersImages.setEntity_image8(CommonUtil.multiDimensions(nextLine[40], designers.getDesignId()  , designers.getCompanyId(),false));
							} catch (Exception e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
							}
							try {
								if(Validator.isNull(updateDesignersImages.getEntity_image9()))
									updateDesignersImages.setEntity_image9(CommonUtil.multiDimensions(nextLine[41], designers.getDesignId()  , designers.getCompanyId(),false));
							} catch (Exception e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
							}
							try {
								if(Validator.isNull(updateDesignersImages.getEntity_image10()))
									updateDesignersImages.setEntity_image10(CommonUtil.multiDimensions(nextLine[42], designers.getDesignId()  , designers.getCompanyId(),false));
							} catch (Exception e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
							}

							try {
								DesignersImagesLocalServiceUtil.updateDesignersImages(updateDesignersImages);
							} catch (SystemException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
					}

				}
				lineNumber++;
			}
		} catch (FileNotFoundException e1) {	
			_log.info("FileNotFoundException");

		} catch (IOException e) {
			_log.info("FileNotFoundException");
		}
		//Made.com-ends
	}

	/***
	 * Update designer is active field.
	 * If bar code of the designer is in temp_asi_designers then isactive is set to true(1 in db)
	 * else isactive is set to false (0 in db)
	 * 
	 * @param companyId
	 * @param userId
	 * @param groupId
	 */
	public static void updateActiveField(long companyId, long userId, long groupId){
		try {
			List<Designers> designers = DesignersLocalServiceUtil.getDesignerses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			Connection conn = null;

			Statement st = null;

			
			if(designers != null){
				try{

					conn = DataAccess.getConnection();
					st =  conn.createStatement();

					String sql = "select * from temp_designers where barcode=";

					for(Designers designer : designers){
						ResultSet rs = null;
						designer.setIsactive(false);
						try{
							System.out.println(sql+"'"+designer.getBarcode()+"'");
							rs = st.executeQuery(sql+"'"+designer.getBarcode()+"'");
							
							if(rs.next()) {
								System.out.println(designer.getBarcode() +" true");
								designer.setIsactive(true);
								DesignersLocalServiceUtil.updateDesigners(designer);
							}else{
								System.out.println(designer.getBarcode() +" false");
								designer.setIsactive(false);
								DesignersLocalServiceUtil.updateDesigners(designer);
							}
							
							
						}catch(Exception e){
							
						}finally{
							if(rs != null)
								try {
									rs.close();
								} catch (SQLException e1) {

								}
						}
					}


				}catch(Exception e){

				}finally{
					
					if(st != null)
						try {
							st.close();
						} catch (SQLException e) {

						}
					if(conn != null)
						try {
							conn.close();
						} catch (SQLException e) {

						}
				}

			}	
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public static void parseTempTable(long companyId, long userId, long groupId) throws SQLException{		


		CSVReader reader = null;
		Connection conn = null;
		Statement st = null;
		ResultSet res = null;
		// Made.com
		try {
			System.out.println("Inside parseDatabase >>>>>>");
			Designers designers = null;
			conn = DataAccess.getConnection();
			st = conn.createStatement();
			res = st.executeQuery("select * from temp_designers where name!='' and price!='0' and price!='' and isRead = 0;");

			while (res.next()) {
				//if(res.getString("barcode").equals("BBGPIG007ZTI-UK")){
				System.out.println(companyId+"res.getString(productcode)>>>>>"+res.getString("productcode"));
				try {

					designers = DesignersLocalServiceUtil.getByCompanyId(companyId,res.getString("productcode"));


				} catch (SystemException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if(Validator.isNull(designers)){
					System.out.println("----------------NEW PRODUCT-------------------------");
					designers=DesignersLocalServiceUtil.getInstance();


					designers.setName(res.getString("name"));
					designers.setProductTitle(res.getString("productTitle"));
					designers.setBrand(res.getString("brand"));
					designers.setDescription(res.getString("description"));
					designers.setShortDescription(res.getString("shortDescription"));

					designers.setPrice(res.getString("price"));
					designers.setSaleprice(res.getString("saleprice"));
					designers.setPublic_url(res.getString("public_url"));
					designers.setCategory(res.getString("category"));

					designers.setSizes(res.getString("sizes"));
					designers.setColors(res.getString("colors"));
					designers.setInstock(res.getString("instock"));
					//designers.setParentid(nextLine[14]);
					designers.setRetailprice(res.getString("retailprice"));
					designers.setProductcode(res.getString("productcode"));
					designers.setBarcode(res.getString("barcode"));
					designers.setMatchWith(res.getString("matchWith"));

					designers.setCreateDate(new Date());
					designers.setModifiedDate(new Date());

					designers.setUserId(userId);
					designers.setCompanyId(companyId);
					designers.setGroupId(groupId);
					designers.setTimerDate(res.getString("TimerDate"));
					designers.setCtapp_shorturl(true);
					
					designers.setLeft_description(res.getString("left_description"));
					designers.setRight_description(res.getString("right_description"));
					
					designers.setSlug("/designers?designId=" + designers.getDesignId()+"&from=NFC");

					try {
						designers = DesignersLocalServiceUtil.addDesigners(designers);
					} catch (SystemException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					DesignersImages designersImages = DesignersImagesLocalServiceUtil.getInstance();					

					designersImages.setDesignId(designers.getDesignId());				

					try {
						if(Validator.isNotNull(res.getString("entity_image1")))
							designersImages.setEntity_image1(CommonUtil.multiDimensions(res.getString("entity_image1"), designers.getDesignId()  , designers.getCompanyId(),true));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}

					try {
						if(Validator.isNotNull(res.getString("entity_image2")))
							designersImages.setEntity_image2(CommonUtil.multiDimensions(res.getString("entity_image2"), designers.getDesignId()  , designers.getCompanyId(),false));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}

					try {
						if(Validator.isNotNull(res.getString("entity_image3")))
							designersImages.setEntity_image3(CommonUtil.multiDimensions(res.getString("entity_image3"), designers.getDesignId()  , designers.getCompanyId(),false));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}

					try {
						if(Validator.isNotNull(res.getString("entity_image4")))
							designersImages.setEntity_image4(CommonUtil.multiDimensions(res.getString("entity_image4"), designers.getDesignId()  , designers.getCompanyId(),false));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}

					try {
						if(Validator.isNotNull(res.getString("entity_image5")))
							designersImages.setEntity_image5(CommonUtil.multiDimensions(res.getString("entity_image5"), designers.getDesignId()  , designers.getCompanyId(),false));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}

					try {
						if(Validator.isNotNull(res.getString("entity_image6")))
							designersImages.setEntity_image6(CommonUtil.multiDimensions(res.getString("entity_image6"), designers.getDesignId()  , designers.getCompanyId(),false));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}

					try {
						if(Validator.isNotNull(res.getString("entity_image7")))
							designersImages.setEntity_image7(CommonUtil.multiDimensions(res.getString("entity_image7"), designers.getDesignId()  , designers.getCompanyId(),false));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}

					try {
						if(Validator.isNotNull(res.getString("entity_image8")))
							designersImages.setEntity_image8(CommonUtil.multiDimensions(res.getString("entity_image8"), designers.getDesignId()  , designers.getCompanyId(),false));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
					try {
						if(Validator.isNotNull(res.getString("entity_image9")))
							designersImages.setEntity_image9(CommonUtil.multiDimensions(res.getString("entity_image9"), designers.getDesignId()  , designers.getCompanyId(),false));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}

					try {
						if(Validator.isNotNull(res.getString("entity_image10")))
							designersImages.setEntity_image10(CommonUtil.multiDimensions(res.getString("entity_image10"), designers.getDesignId()  , designers.getCompanyId(),false));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}

					designersImages.setSmall_image_url(res.getString("entity_image10"));						
					try {
						DesignersImagesLocalServiceUtil.addDesignersImages(designersImages);
					} catch (SystemException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String query = "UPDATE temp_designers SET isRead=? WHERE productcode= ?";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
					preparedStmt.setInt   (1, 1);
					preparedStmt.setString(2, res.getString("productcode"));

					// execute the java preparedstatement
					preparedStmt.executeUpdate();
					preparedStmt.close();
				}else{						

					designers.setName(res.getString("name"));
					designers.setProductTitle(res.getString("productTitle"));
					designers.setBrand(res.getString("brand"));
					designers.setDescription(res.getString("description"));
					designers.setShortDescription(res.getString("shortDescription"));

					designers.setPrice(res.getString("price"));
					designers.setSaleprice(res.getString("saleprice"));
					designers.setPublic_url(res.getString("public_url"));
					designers.setCategory(res.getString("category"));

					designers.setSizes(res.getString("sizes"));
					designers.setColors(res.getString("colors"));
					designers.setInstock(res.getString("instock"));
					//designers.setParentid(nextLine[14]);
					designers.setRetailprice(res.getString("retailprice"));
					designers.setProductcode(res.getString("productcode"));
					designers.setBarcode(res.getString("barcode"));
					designers.setMatchWith(res.getString("matchWith"));
					designers.setLeft_description(res.getString("left_description"));
					designers.setRight_description(res.getString("right_description"));

					designers.setModifiedDate(new Date());


					try {
						designers = DesignersLocalServiceUtil.updateDesigners(designers);
					} catch (SystemException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					DesignersImages updateDesignersImages = null;
					try {
						updateDesignersImages = DesignersImagesLocalServiceUtil.getByDesignId(designers.getDesignId());
					} catch (NoSuchDesignersImagesException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SystemException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(Validator.isNotNull(updateDesignersImages)){
						String path = "";
						String strPath = "";
						try {
							path = res.getString("entity_image1");
							strPath = path.substring(path.lastIndexOf("/")+1, path.length());
							//if(Validator.isNull(updateDesignersImages.getEntity_image1()) || !updateDesignersImages.getEntity_image1().contains(strPath))
							updateDesignersImages.setEntity_image1(CommonUtil.multiDimensions(res.getString("entity_image1"), designers.getDesignId()  , designers.getCompanyId(),true));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}
						try {
							path = res.getString("entity_image2");
							strPath = path.substring(path.lastIndexOf("/")+1, path.length());
							//if(Validator.isNull(updateDesignersImages.getEntity_image2()) || !updateDesignersImages.getEntity_image2().contains(strPath))
							updateDesignersImages.setEntity_image2(CommonUtil.multiDimensions(res.getString("entity_image2"), designers.getDesignId()  , designers.getCompanyId(),false));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}

						try {
							path = res.getString("entity_image3");
							strPath = path.substring(path.lastIndexOf("/")+1, path.length());
							//if(Validator.isNull(updateDesignersImages.getEntity_image3()) || !updateDesignersImages.getEntity_image3().contains(strPath))
							updateDesignersImages.setEntity_image3(CommonUtil.multiDimensions(res.getString("entity_image3"), designers.getDesignId()  , designers.getCompanyId(),false));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}

						try {
							path = res.getString("entity_image4");
							strPath = path.substring(path.lastIndexOf("/")+1, path.length());
							//if(Validator.isNull(updateDesignersImages.getEntity_image4()) || !updateDesignersImages.getEntity_image4().contains(strPath))
							updateDesignersImages.setEntity_image4(CommonUtil.multiDimensions(res.getString("entity_image4"), designers.getDesignId()  , designers.getCompanyId(),false));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}

						try {
							path = res.getString("entity_image5");
							strPath = path.substring(path.lastIndexOf("/")+1, path.length());
							//if(Validator.isNull(updateDesignersImages.getEntity_image5()) || !updateDesignersImages.getEntity_image5().contains(strPath))
							updateDesignersImages.setEntity_image5(CommonUtil.multiDimensions(res.getString("entity_image5"), designers.getDesignId()  , designers.getCompanyId(),false));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}

						try {
							path = res.getString("entity_image6");
							strPath = path.substring(path.lastIndexOf("/")+1, path.length());
							//if(Validator.isNull(updateDesignersImages.getEntity_image6()) || !updateDesignersImages.getEntity_image6().contains(strPath))
							updateDesignersImages.setEntity_image6(CommonUtil.multiDimensions(res.getString("entity_image6"), designers.getDesignId()  , designers.getCompanyId(),false));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}

						try {
							path = res.getString("entity_image7");
							strPath = path.substring(path.lastIndexOf("/")+1, path.length());
							//if(Validator.isNull(updateDesignersImages.getEntity_image7()) || !updateDesignersImages.getEntity_image7().contains(strPath))
							updateDesignersImages.setEntity_image7(CommonUtil.multiDimensions(res.getString("entity_image7"), designers.getDesignId()  , designers.getCompanyId(),false));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}

						try {
							path = res.getString("entity_image8");
							strPath = path.substring(path.lastIndexOf("/")+1, path.length());
							//if(Validator.isNull(updateDesignersImages.getEntity_image8()) || !updateDesignersImages.getEntity_image8().contains(strPath))
							updateDesignersImages.setEntity_image8(CommonUtil.multiDimensions(res.getString("entity_image8"), designers.getDesignId()  , designers.getCompanyId(),false));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}
						try {
							path = res.getString("entity_image9");
							strPath = path.substring(path.lastIndexOf("/")+1, path.length());
							//if(Validator.isNull(updateDesignersImages.getEntity_image9()) || !updateDesignersImages.getEntity_image9().contains(strPath))
							updateDesignersImages.setEntity_image9(CommonUtil.multiDimensions(res.getString("entity_image9"), designers.getDesignId()  , designers.getCompanyId(),false));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}
						try {
							path = res.getString("entity_image10");
							strPath = path.substring(path.lastIndexOf("/")+1, path.length());
							//if(Validator.isNull(updateDesignersImages.getEntity_image10()) || !updateDesignersImages.getEntity_image10().contains(strPath))
							updateDesignersImages.setEntity_image10(CommonUtil.multiDimensions(res.getString("entity_image10"), designers.getDesignId()  , designers.getCompanyId(),false));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}

						try {
							DesignersImagesLocalServiceUtil.updateDesignersImages(updateDesignersImages);
						} catch (SystemException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						String query = "UPDATE temp_designers SET isRead=? WHERE productcode= ?";
						PreparedStatement preparedStmt = conn.prepareStatement(query);
						preparedStmt.setInt   (1, 1);
						preparedStmt.setString(2, res.getString("productcode"));

						// execute the java preparedstatement
						preparedStmt.executeUpdate();
						preparedStmt.close();

					}
				}

				shortURLGeneration();

				// }
			}
		} //Made.com-ends
		catch (SQLException e3) {
			// TODO Auto-generated catch block
			res.close();
			st.close();
			conn.close();
			e3.printStackTrace();
		}finally {
            if(res != null)
				res.close();
			if(st != null)
				st.close();
			if(conn != null)
				conn.close();
        }


	}
	public static void shortURLGeneration(){
		try {
			List<Designers> designers = DesignersLocalServiceUtil.getDesignerses(0, DesignersLocalServiceUtil.getDesignersesCount());
			for(Designers desgn : designers){
				if(Validator.isNotNull(desgn)){
					String entityImage1 = StringPool.BLANK;
					DesignersImages designerImages = DesignersImagesLocalServiceUtil.getByDesignId(desgn.getDesignId());
					if(Validator.isNotNull(designerImages)){
						entityImage1= URLEncoder.encode(designerImages.getEntity_image1(),"UTF-8");
					}
					if(desgn.getCtapp_shorturl() && !desgn.getCtapp_shorturl_success()){
						//if(desgn.getDesignId() > 2341){

						/* Modified by viji to remove duplicate +"%26from=NFC" - 23-jan-2015 */
						//String urlStr = "http://ctapp.herokuapp.com/api/v1/short_urls_lr/md?token=mdLiferay&url=http://made.cloudtags.com:9090/designers?designId="+desgn.getDesignId()+"%26from=NFC"+"%26from=NFC&product_name="+URLEncoder.encode(desgn.getProductTitle(),"UTF-8")+"&product_image_1="+entityImage1+"&product_sku="+desgn.getBarcode();
						String urlStr = "http://ctapp.herokuapp.com/api/v1/short_urls_lr/md?token=mdLiferay&url=http://made.cloudtags.com:9090/designers?designId="+desgn.getDesignId()+"%26from=NFC&product_name="+URLEncoder.encode(desgn.getProductTitle(),"UTF-8")+"&product_image_1="+entityImage1+"&product_sku="+desgn.getBarcode();

						//String urlStr = "http://ctapp.herokuapp.com/api/v1/short_urls_lr/md?token=mdLiferay&url=http://cloudtags.com";
						String response = RestClientUtil.httpGet(urlStr);
						System.out.println(desgn.getDesignId()+"<<<<<"+urlStr+">>>>>>>"+response);
						if(Validator.isNotNull(response) && response.equalsIgnoreCase("true")){
							desgn.setCtapp_shorturl_success(true);
							DesignersLocalServiceUtil.updateDesigners(desgn);
						}
						//}
					}

				}
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchDesignersImagesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void parseDumpDataCSV(File csvFile,  long companyId) {		


		CSVReader reader = null;

		// Made.com
		try {
			reader = new CSVReader(new FileReader(csvFile));
			String[] nextLine;
			int lineNumber = 0;
			while ((nextLine = reader.readNext()) != null) {
				if(lineNumber >= 1) {
					//System.out.println("nextLine[12]>>"+nextLine[12]);
					Recommendations recommendation = RecommendationsLocalServiceUtil.getInstance();

					recommendation.set_type(Long.parseLong(nextLine[0]));
					recommendation.setDesigner1(nextLine[1]);
					recommendation.setDesigner2(nextLine[2]);
					recommendation.setPercentage(Double.parseDouble(nextLine[3]));
					recommendation.setCompanyId(companyId);


					try {
						recommendation = RecommendationsLocalServiceUtil.addRecommendations(recommendation);

					} catch (SystemException e) {
						_log.info("could not create records from CSV");
					}

				}
				lineNumber++;
			}
		} catch (FileNotFoundException e1) {	
			_log.info("FileNotFoundException");

		} catch (IOException e) {
			_log.info("FileNotFoundException");
		}
		//Made.com-ends

	}

	public static void updateShortURLDumpDataCSV(File csvFile,  long companyId) {		


		CSVReader reader = null;

		// Made.com
		try {
			reader = new CSVReader(new FileReader(csvFile));
			String[] nextLine;
			int lineNumber = 0;
			while ((nextLine = reader.readNext()) != null) {
				if(lineNumber >= 0) {

					Designers designer;

					if(Validator.isNotNull(nextLine[1])){


						try {
							designer = DesignersLocalServiceUtil.getByCompanyId(companyId,nextLine[1]);
							if(Validator.isNotNull(designer)){	
								System.out.println("****************************"+designer.getDesignId());
								designer.setCtapp_shorturl(true);
								designer = DesignersLocalServiceUtil.updateDesigners(designer);
							}
						} catch (SystemException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}


					}



				}
				lineNumber++;
			}
		} catch (FileNotFoundException e1) {	
			_log.info("FileNotFoundException");

		} catch (IOException e) {
			_log.info("FileNotFoundException");
		}
		//Made.com-ends

	}

}