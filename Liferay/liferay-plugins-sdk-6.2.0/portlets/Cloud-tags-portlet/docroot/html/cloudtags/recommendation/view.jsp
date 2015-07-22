<%@page import="com.cloud.tags.common.util.Constants"%>
<%@page import="java.util.Collection"%>
<%@page import="com.cloud.tags.service.CartsDesignersLocalServiceUtil"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.cloud.tags.model.CartsDesigners"%>
<%@page import="com.cloud.tags.service.CustomerImagesLocalServiceUtil"%>
<%@page import="com.cloud.tags.model.CustomerImages"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.cloud.tags.common.CommonUtil"%>
<%@page import="com.cloud.tags.service.ImpressionsLocalServiceUtil"%>
<%@page import="com.cloud.tags.service.RecommendationsLocalServiceUtil"%>
<%@page import="com.cloud.tags.model.Recommendations"%>
<%@page import="com.cloud.tags.model.Impressions"%>

<%@ include file="/html/cloudtags/init.jsp"%>

<portlet:resourceURL var="addToCartURL">
	<portlet:param name="CMD" value="ADDED2CART"/>
</portlet:resourceURL>
<portlet:resourceURL var="likedCartURL">
	<portlet:param name="CMD" value="LIKED"/>
</portlet:resourceURL>

<portlet:resourceURL var="sendEmailURL">
	<portlet:param name="CMD" value="sendEmail"/>
</portlet:resourceURL>

<portlet:resourceURL var="staffShortlist">
	<portlet:param name="CMD" value="staffUsers"/>
</portlet:resourceURL>

<portlet:resourceURL var="endSessionURL">
	<portlet:param name="CMD" value="staffEndfromdocked"/>
</portlet:resourceURL>

<portlet:resourceURL var="removeCartList">
	<portlet:param name="CMD" value="remove"/>
</portlet:resourceURL>

<portlet:resourceURL var="productDetails">
	<portlet:param name="CMD" value="getproduct"/>
</portlet:resourceURL>

<portlet:resourceURL var="productDetailsURL">
	<portlet:param name="CMD" value="productDetails"/>
</portlet:resourceURL>

<portlet:resourceURL var="relatedItemsURL">
	<portlet:param name="CMD" value="relatedItems"/>
</portlet:resourceURL>
<portlet:resourceURL var="GeneralImpress">
	<portlet:param name="CMD" value="generalImpress"/>
</portlet:resourceURL>

<%
if(Validator.isNotNull(session.getAttribute("DONTCLEARSESSION"))){
	session.setAttribute("DONTCLEARSESSION", "");	
}
%>

<link href="<%=request.getContextPath() %>/css/made-common.css?v=1" rel="stylesheet" type="text/css">
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Kameron:400,700' rel='stylesheet' type='text/css'>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jquery.mobile-1.4.5.min.css">
<link href="<%=request.getContextPath()%>/SpryAssets/SpryTabbedPanels.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.ui.touch-punch.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.touchwipe.1.1.1.js"></script>
<script src="<%=request.getContextPath()%>/SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>


<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/jcarousel.connected-carousels.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/jcarousel.responsive.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.jcarousel.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jcarousel.connected-carousels.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jcarousel.responsive.js"></script>

<script>
function overlayClear(){
	$("#clear").css("display","none");
	$("#finish").css("display","block");	
	$("#email_container_overlay").hide();
	$("#email_container").hide();	
	$('body').css('position','fixed');
	$('body').css('overflow-y','scroll');
	$('body').css('overflow-x','hidden');
	//alert("<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>");
}
show_loading();
$(".carousel-stage").jcarousel({ animation: 1000 });
$(".carousel-navigation").jcarousel({ animation: 1000 });

</script>


  <%
  boolean tabs1 = false;
  boolean tabs2 = false;
  
  boolean showPopup = true;
  boolean showWow = false;
Log _log = LogFactoryUtil.getLog(RecommendationsLocalServiceUtil.class);

	Long  productId= 0l;
	Designers  object =null;
	try{
		
		productId = Long.parseLong( originalRequest.getParameter("designId"));
		object = DesignersLocalServiceUtil.getDesigners(productId);
		DesignersImages designersImage = DesignersImagesLocalServiceUtil.getByDesignId(object.getDesignId());
		String tapped = "TAPPED";
		if(Validator.isNotNull(originalRequest.getParameter("from"))){
			System.out.println(originalRequest.getParameter("from").toString());
			tapped +="-"+originalRequest.getParameter("from").toString(); 
			
		}else{
			tapped +="-WALL";
		}
		String deviceName = StringPool.BLANK;
		String deviceType = StringPool.BLANK;
		String browserName = StringPool.BLANK;
		String deviceWidth = StringPool.BLANK;
		
		if(Validator.isNotNull(session.getAttribute("deviceName"))){
			deviceName = session.getAttribute("deviceName").toString();
		}
		if(Validator.isNotNull(session.getAttribute("deviceType"))){
			deviceType = session.getAttribute("deviceType").toString();
		}
		if(Validator.isNotNull(session.getAttribute("browserName"))){
			browserName = session.getAttribute("browserName").toString();
		}
		long storeDevId = CommonUtil.getStoreIdForDevice(session);
		if(Validator.isNotNull(session.getAttribute("deviceWidth"))){
			deviceWidth = session.getAttribute("deviceWidth").toString();
		}
		Impressions impressions = ImpressionsLocalServiceUtil.addToImpressions("PRODUCT", productId.toString(), 
				tapped,loginUserId , Long.toString(themeDisplay.getCompanyId()),
				originalRequest.getRemoteAddr(),deviceName,deviceType,deviceWidth,browserName,storeDevId);
		if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressions != null){
			System.out.println("LOGINSTAFF inside recommendations view");
			impressions.setStaffId(session.getAttribute("LOGINSTAFF").toString());
			ImpressionsLocalServiceUtil.updateImpressions(impressions);
		}
		System.out.println("themeDisplay.getCompanyId()>>"+Long.toString(themeDisplay.getCompanyId()));
		int maximges = 1;
		CommonUtil.addToCart(productId, session, themeDisplay, originalRequest);
		
		
		
		String param = originalRequest.getParameter("from");
		
		showPopup =  (param != null && param.equalsIgnoreCase("RECOMMENDATION"))? false : true;
		
		session.setAttribute(Constants.PREV_SEL_PROD, productId);
		HashMap<Long, Designers> cartList = null;
		if (Validator.isNotNull(session.getAttribute("LIFERAY_SHARED_CARTLIST"))) {

			cartList = (HashMap<Long, Designers>) session
					.getAttribute("LIFERAY_SHARED_CARTLIST");

		} else {

			cartList = new HashMap<Long, Designers>();
		}
		
		//showWow =  CommonUtil.showWOW(session);
%>
<%-- <script type="text/javascript">
var url = '<%=addToCartURL.toString() +"&productId=" +productId %>';
var xhr = new XMLHttpRequest();
xhr.open("POST",url, true);
xhr.send();
 			xhr.onreadystatechange = function(e) {
			if (xhr.readyState == 4) {
				if(xhr.status == 200){
				
					
				}
			}
		};
</script>--%>
<div id="main_all" style="-webkit-overflow-scrolling: touch;">
  
<div id="loading" class='loading'>Loading...</div>
<div id="added" class='loading'>Added To List</div>
<div id="removed" class='loading'>Removed From List</div>



<div id="email_container_overlay" onclick="overlayClear();"></div>
<div id="email_container">

	<div class="email_heading">SEND THIS LIST TO YOUR INBOX<br/>OR EMAIL A FRIEND</div>
    
    <form>
    <div class="error" id="error-invalid" style="visibility:hidden;">*Invalid Email ID</div>
     <div class="error" id="error-zero-products" style="visibility:hidden;left:20%;">Please add at least one product for sending email. </div>
    	<input  type="email"  id="<portlet:namespace/>email" class="email_field" 
    	<%if(Validator.isNotNull(session.getAttribute("FIRST-EMAIL"))) { %>
    	placeholder="<%=session.getAttribute("FIRST-EMAIL")%>" value="<%=session.getAttribute("FIRST-EMAIL")%>" 
    	<%}
    	else{
    		%>
    		placeholder="yourname@youremail.com" 
    		<%
    	}
    	%>
    	
    	/>
        <div class="email_btn" id="emailsend">SEND</div>
    </form>
    
    <div id="email_close"></div>
    
    <div class="thankyou_heading">THANK YOU!</div>
    <div class="thankyou_btn" onclick="removeFromSession();">CLEAR SESSION</div>
    <div id="thankyou_close" onclick='overlayClear()'></div>

</div><!--email_container-->


            



<div id="myPopup_main"></div>
<div class="save_btn" id="save">SAVE TO MY LIST</div>
<div style="display: block;background:#ccc; color:#666;" class="save_btn" id="saveOnLoad">SAVED TO MY LIST</div>
<div class="close" id="close"><a href="#"><img src="<%=request.getContextPath() %>/images/close.png" alt="close"></a></div>
<div id="myPopup">
	<div class="product_slider_main">    
    	<div class="product_slider_heading_main">
        
              
               <div class="product_slider_heading_left"><%=object.getProductTitle()%></div>
              <div class="product_slider_heading_left_content"><%=object.getShortDescription().replaceAll("</br>", "") %></div>
              
              <div class="product_slider_heading_right">&pound;<%=object.getPrice()%></div>
          
          
        </div><!--product_slider_heading_main-->
        
        
        	<div class="product_slider">
            
            
            <div class="connected-carousels">
                <div class="stage">
                    <div class="carousel carousel-stage">
                        <ul>
                        	<%if(Validator.isNotNull(designersImage.getEntity_image1())) { %>
                            <li><div class="product-slider-image" style="background:url(<%=designersImage.getEntity_image1() %>) no-repeat; background-size:contain; background-position:0% 40%;"></div></li>
                            <%}if(Validator.isNotNull(designersImage.getEntity_image2())) { %>
                            <li><div class="product-slider-image" style="background:url(<%=designersImage.getEntity_image2() %>) no-repeat; background-size:contain; background-position:0% 40%;"></div></li>
                             <%}if(Validator.isNotNull(designersImage.getEntity_image3())) { %>
                            <li><div class="product-slider-image" style="background:url(<%=designersImage.getEntity_image3() %>) no-repeat; background-size:contain; background-position:0% 40%;"></div></li>
                             <%}if(Validator.isNotNull(designersImage.getEntity_image4())) { %>
                            <li><div class="product-slider-image" style="background:url(<%=designersImage.getEntity_image4() %>) no-repeat; background-size:contain; background-position:0% 40%;"></div></li>
                             <%}if(Validator.isNotNull(designersImage.getEntity_image5())) { %>
                            <li><div class="product-slider-image" style="background:url(<%=designersImage.getEntity_image5() %>) no-repeat; background-size:contain; background-position:0% 40%;"></div></li>
                             <%}if(Validator.isNotNull(designersImage.getEntity_image6())) { %>
                            <li><div class="product-slider-image" style="background:url(<%=designersImage.getEntity_image6() %>) no-repeat; background-size:contain; background-position:0% 40%;"></div></li>
                             <%}if(Validator.isNotNull(designersImage.getEntity_image7())) { %>
                            <li><div class="product-slider-image" style="background:url(<%=designersImage.getEntity_image7() %>) no-repeat; background-size:contain; background-position:0% 40%;"></div></li>
                             <%}if(Validator.isNotNull(designersImage.getEntity_image8())) { %>
                            <li><div class="product-slider-image" style="background:url(<%=designersImage.getEntity_image8() %>) no-repeat; background-size:contain; background-position:0% 40%;"></div></li>
                             <%}if(Validator.isNotNull(designersImage.getEntity_image9())) { %>
                            <li><div class="product-slider-image" style="background:url(<%=designersImage.getEntity_image9() %>) no-repeat; background-size:contain; background-position:0% 40%;"></div></li>
                             <%}if(Validator.isNotNull(designersImage.getEntity_image10())) { %>
                            <li><div class="product-slider-image" style="background:url(<%=designersImage.getEntity_image10() %>) no-repeat; background-size:contain; background-position:0% 40%;"></div></li>
                             <%}%>
                        </ul>
                    </div>
                    
                </div>

                <div class="navigation">

                    <div class="carousel carousel-navigation">
                        <ul>
                        	<%if(Validator.isNotNull(designersImage.getEntity_image1())) { %>
                            <li><div id="im1" class="slider-square" style="background:url(<%=designersImage.getEntity_image1().replace(PortletProps.get("main.image.dimension"),PortletProps.get("small.image.dimension"))%>) no-repeat; background-size:contain; background-position:0%;"></div></li>
                            <%}if(Validator.isNotNull(designersImage.getEntity_image2())) { %>
                            <li><div id="im2" class="slider-square" style="background:url(<%=designersImage.getEntity_image2().replace(PortletProps.get("main.image.dimension"),PortletProps.get("small.image.dimension"))%>) no-repeat; background-size:contain; background-position:0%;"></div></li>
                            <%}if(Validator.isNotNull(designersImage.getEntity_image3())) { %>
                            <li><div id="im3" class="slider-square" style="background:url(<%=designersImage.getEntity_image3().replace(PortletProps.get("main.image.dimension"),PortletProps.get("small.image.dimension"))%>) no-repeat; background-size:contain; background-position:0%;"></div></li>
                            <%}if(Validator.isNotNull(designersImage.getEntity_image4())) { %>
                            <li><div id="im4" class="slider-square" style="background:url(<%=designersImage.getEntity_image4().replace(PortletProps.get("main.image.dimension"),PortletProps.get("small.image.dimension"))%>) no-repeat; background-size:contain; background-position:0%;"></div></li>
                            <%}if(Validator.isNotNull(designersImage.getEntity_image5())) { %>
                            <li><div id="im5" class="slider-square" style="background:url(<%=designersImage.getEntity_image5().replace(PortletProps.get("main.image.dimension"),PortletProps.get("small.image.dimension"))%>) no-repeat; background-size:contain; background-position:0%;"></div></li>
                             <%}if(Validator.isNotNull(designersImage.getEntity_image6())) { %>
                            <li><div id="im6" class="slider-square" style="background:url(<%=designersImage.getEntity_image6().replace(PortletProps.get("main.image.dimension"),PortletProps.get("small.image.dimension"))%>) no-repeat; background-size:contain; background-position:0%;"></div></li>
                             <%}if(Validator.isNotNull(designersImage.getEntity_image7())) { %>
                            <li><div id="im7" class="slider-square" style="background:url(<%=designersImage.getEntity_image7().replace(PortletProps.get("main.image.dimension"),PortletProps.get("small.image.dimension"))%>) no-repeat; background-size:contain; background-position:0%;"></div></li>
                             <%}if(Validator.isNotNull(designersImage.getEntity_image8())) { %>
                            <li><div id="im8" class="slider-square" style="background:url(<%=designersImage.getEntity_image8().replace(PortletProps.get("main.image.dimension"),PortletProps.get("small.image.dimension"))%>) no-repeat; background-size:contain; background-position:0%;"></div></li>
                             <%}if(Validator.isNotNull(designersImage.getEntity_image9())) { %>
                            <li><div id="im9" class="slider-square" style="background:url(<%=designersImage.getEntity_image9().replace(PortletProps.get("main.image.dimension"),PortletProps.get("small.image.dimension"))%>) no-repeat; background-size:contain; background-position:0%;"></div></li>
                             <%}if(Validator.isNotNull(designersImage.getEntity_image10())) { %>
                            <li><div id="im10" class="slider-square" style="background:url(<%=designersImage.getEntity_image10().replace(PortletProps.get("main.image.dimension"),PortletProps.get("small.image.dimension"))%>) no-repeat; background-size:contain; background-position:0%;"></div></li>
                             <%}%>
                        </ul>
                    </div>
                </div>
            </div>
         		
         		
         		<div id="left" class="prev-stage"> 
                    <img src="<%=request.getContextPath() %>/images/arrow-left.png" height="40" width="40"> 
                </div> 
            
                <div id="right" class="next-stage"> 
                    <img src="<%=request.getContextPath() %>/images/arrow-right.png" height="40" width="40"> 
                </div>
            
            	
            
            </div><!--product_slider-->
        
        
        
    </div><!--product_slider_main-->
    
    
    <div class="product_description_block">

		<div id="TabbedPanels1" class="TabbedPanels">
            <ul class="TabbedPanelsTabGroup">
              <li class="TabbedPanelsTab" tabindex="0">Details</li>
              <li class="TabbedPanelsTab" tabindex="0">Collection</li>
              <li class="TabbedPanelsTab" tabindex="0">Colour</li>
            </ul>
            <div class="TabbedPanelsContentGroup">
            	 <% 
              
              String padding1 = "padding:8% 0% 42% 0%;";
             
              if(Validator.isNotNull(object.getLeft_description()) && Validator.isNotNull(object.getRight_description())){
            	  System.out.println("inside ");
            	  padding1 = "padding:8% 0% 25% 0%;";
              }
              %>
              <div class="TabbedPanelsContent" id="DetailsTabbedPanel" style="<%=padding1%>">
              
              	<div class="details_content_block" style="text-align:left; padding-left:0;">
                	
                    <div class="details_content_heading">Description</div>
                    <div class="details_content">
                    	<%=object.getLeft_description() %>
                    </div>
                    <div class="details_content_heading">Next batch order</div>                 
                    <div class="details_content">
                         <div class="details_content" style="width: 100%; display: inline-block;"><span id="countdown1">1 days</span> - <span id="countdown2">12:01</span> </div>
                    </div>
                    
                </div><!--details_content1-->
                
                
                <div class="details_content_block" style="text-align:right; padding-right:0;">
                
                	<div class="details_content_heading">Dimensions</div>
                    <div class="details_content">
                    	<%=object.getRight_description() %>
                    </div>
                
                </div><!--details_content2-->
                
              </div><!--Details_block-->
              
              <% 
              List<Recommendations> listRecomm = null;
              String padding = "padding:8% 0% 42% 0%;";
              try{
               listRecomm = RecommendationsLocalServiceUtil.getByDesigner1(3, object.getBarcode(), object.getCompanyId());
              }catch(Exception e){
              }
              if(listRecomm != null && listRecomm.size() > 3 ){
            	  System.out.println("inside ");
            	  padding = "padding:8% 0% 25% 0%;";
              }
              %>
              <%if(listRecomm.size()!=0){ %>
              <div align="center" class="TabbedPanelsContent" id="CollectionTabbedPanel" style="<%=padding %>">
              	<%
				try{
					//List<Recommendations> listRecomm = RecommendationsLocalServiceUtil.getByDesigner1(3, object.getBarcode(), object.getCompanyId());
					//List<Designers> itemsByColor = DesignersLocalServiceUtil.getByCompanyId(themeDisplay.getCompanyId())
					System.out.println(object.getBarcode()+">>>>>>>>>>>>>>>>>>>>>>>>"+listRecomm.size());
					int count =0;
					
					for(Recommendations recommendations : listRecomm) {
						Designers designers = DesignersLocalServiceUtil.getByCompanyId(recommendations.getCompanyId(), recommendations.getDesigner2());
						if((designers.getDesignId() == productId ) || (cartList != null && cartList.containsKey(designers.getDesignId())))
							continue;
						
				if(designers != null && designers.isIsactive()){
						tabs1 = true;
						count ++;
						if(count>6) break;
						//if(count>3) break;
						DesignersImages designersImages = DesignersImagesLocalServiceUtil.getByDesignId(designers.getDesignId());
						String URL = "/designers?designId=";
	
						URL = URL + designers.getDesignId();
				%>
                <div id="collection<%=designers.getDesignId() %>" onclick="getProductDetails('<%=designers.getDesignId()%>', true,'<%=ImpressionTypes.COLLECTIONS %>');" align="center" class="collection_image" style="background:url(<%=designersImages.getEntity_image1().replace(PortletProps.get("main.image.dimension"),PortletProps.get("list.page.dimension")) %>) no-repeat; background-size:contain; background-position:50% 0;"></div>
                <% 		
					}
				} 
				
				} catch(Exception e){}
			
			%>
              </div><!--Collection_block-->
              <%} %>
              <%
              	listRecomm = null;
              	padding = "padding:8% 0% 42% 0%;";
              	try{
              		
              		listRecomm = RecommendationsLocalServiceUtil.getByDesigner1(4, object.getBarcode(), object.getCompanyId());           		              		
              		
              	}catch(Exception e){
              		
              	}
              	if(listRecomm != null && listRecomm.size() > 3 ){
                	  padding = "padding:8% 0% 25% 0%;";
                  }
              %>
               <%if(listRecomm.size()!=0){ %>
              <div align="center" class="TabbedPanelsContent" id="ColourTabbedPanel" style="<%=padding %>">
              	<%
				try{
					 //listRecomm = RecommendationsLocalServiceUtil.getByDesigner1(4, object.getBarcode(), object.getCompanyId());
					//List<Designers> itemsByColor = DesignersLocalServiceUtil.getByCompanyId(themeDisplay.getCompanyId())
					System.out.println(object.getBarcode()+">>>>>>>>>>>>>>>>>>>>>>>>"+listRecomm.size());
					int count =0;
					for(Recommendations recommendations : listRecomm) {
						Designers designers = DesignersLocalServiceUtil.getByCompanyId(recommendations.getCompanyId(), recommendations.getDesigner2());

						if((designers.getDesignId() == productId ) || (cartList != null && cartList.containsKey(designers.getDesignId())))
							continue;
						//if(object.getColors().equalsIgnoreCase(designers.getColors())){
						
						//if(count>3) break;
						if(designers != null && designers.isIsactive()){
							tabs2 = true;
							count ++;
							if(count>6) break;
						DesignersImages designersImages = DesignersImagesLocalServiceUtil.getByDesignId(designers.getDesignId());
						String URL = "/designers?designId=";
	
						URL = URL + designers.getDesignId();
				%>
                   <div id="color<%=designers.getDesignId() %>" class="color_image" onclick="getProductDetails('<%=designers.getDesignId()%>', true,'<%=ImpressionTypes.COLOURS %>');" style="background:url(<%=recommendations.getColor_image() %>) no-repeat; background-size:cover;border:2px solid #ccc;"></div>
                   <% 		
					}
				} 
				
				} catch(Exception e){}
			
			%>
              </div><!--Color_Block-->
              <%} %>
            </div>
        </div>
    
  	</div><!--product_description_block-->
  
</div><!--popup_main-->








<div id="remove_main" style="display:none;"></div>
<div id="remove" style="display:none;">

	<div class="remove_heading">
    	Are you sure you want to remove this product from your list?
    </div>
    
    <div class="remove_yes">YES</div>
    <div class="remove_no">NO</div>
  
  <div class="remove_close"><a href="#"><img src="<%=request.getContextPath() %>/images/close.png" alt="close"></a></div>

</div><!--Note_Popup-->



<div data-role="popup" id="hints" data-overlay-theme="b">

	<div class="hints_image"><img src="<%=request.getContextPath() %>/images/hints.jpg" alt="hints"></div>
  
  <div class="hints_close"><a href="#" data-rel="back"><img src="<%=request.getContextPath() %>/images/close.png" alt="close"></a></div>
  <a href="#" data-rel="back"><div class="hints_close_btn">CLOSE</div></a>

</div><!--hints_popup-->







<div id="DragandDrop_main" style="width:100%; height:auto; float:left; overflow-x: hidden !important;">

<div id="product_header">

	<div class="header_logo" id="header_logo"><img src="<%=request.getContextPath() %>/images/header_logo.jpg" alt="header_logo"></div>
    <div class="header_email" id="header_email"><img src="<%=request.getContextPath() %>/images/header_email.jpg" alt="header_email"></div>
    
</div>

<div class="cart_top" id="droppable">
	<div class="cart_top_heading">MY LIST</div>
    
    	<!--<div class="cart_list_block">-->
        
        <ul id="trash" class="cart_list_block">
        <%
        	//	System.out.println("generateshortURL>>>>"+generateshortURL);
        	String desigIdsForHilight = StringPool.BLANK;
        	boolean isStaff = Boolean.parseBoolean( originalRequest.getParameter("staffShortList"));
        	boolean showCongratsMsg = true;
        		
        	/*HashMap<Long, Designers> list = (HashMap<Long, Designers>) session
        			.getAttribute("LIFERAY_SHARED_CARTLIST");*/
        			try{
        		HashMap<Long, CartsDesigners> list = (HashMap<Long, CartsDesigners>) session
        	.getAttribute("LIFERAY_SHARED_CARTDESIGNERS");
        		
        			if (Validator.isNull(list) || list.size() > 1)
        				showCongratsMsg = false;
        			if (Validator.isNotNull(list) && list.size() > 0) {

        				//Map<Long, Designers> map = new TreeMap<Long, Designers>(list).descendingMap();
        				System.out.println("cart list ----------- > "
        						+ list.size());
        				String style = StringPool.BLANK;
        				if (list.size() >= 3) {
        					style = "style='padding-bottom: 120px;'";
        				}
        %>
							
					<div id="lastRecommendation" style="display:none"><%=list.size() %></div>	
					
					<div id="prevProduct" style="display:none"><%=productId %></div>					
	   	
					<%
					Map<Long, CartsDesigners> map = new TreeMap<Long, CartsDesigners>(list).descendingMap();
					Map<Long, CartsDesigners> mapnew = new HashMap<Long, CartsDesigners>();
					Map<Long, CartsDesigners> mapadded = new HashMap<Long, CartsDesigners>();
					 Set set2 = map.entrySet();
			         Iterator iterator2 = set2.iterator();
			         while(iterator2.hasNext()) {
			        	 Map.Entry me2 = (Map.Entry)iterator2.next();
			           
			              CartsDesigners cartsDesigners = (CartsDesigners)me2.getValue();			              
			              CartsDesigners cartsDesigner1 = CartsDesignersLocalServiceUtil.getCartsDesigners(cartsDesigners.getCartDesignerId());			              
			              if(cartsDesigner1.isFavorite()){
			             	 mapnew.put(cartsDesigners.getCartDesignerId(), cartsDesigners);
			             	 System.out.println("Liked Product:>>>>>>"+cartsDesigners.getCartDesignerId());
			              }else{
			            	  mapadded.put(cartsDesigners.getCartDesignerId(), cartsDesigners);
			            	  System.out.println("Added Product:>>>>>>"+cartsDesigners.getCartDesignerId());
			              }
			       
			         
			         }
			         mapnew = new TreeMap<Long, CartsDesigners>(mapnew).descendingMap();
			         mapadded = new TreeMap<Long, CartsDesigners>(mapadded).descendingMap();
			         
			        // mapnew.putAll(mapadded);
			         
			         
				Collection<CartsDesigners> designers = CommonUtil.mergelikedAdded(mapnew, mapadded).values();
				
				
				for (CartsDesigners designers3 : designers) {					
									
				System.out.print("CartsDesignersCartsDesignersCartsDesigners######>>>"+designers3.getCartDesignerId());
					Designers designers2 = DesignersLocalServiceUtil.getDesigners(designers3.getDesignId());
						
						DesignersImages designersImages = DesignersImagesLocalServiceUtil
								.getByDesignId(designers2.getDesignId());
						String URL = "/designers?designId=";
		
						URL = URL + designers2.getDesignId();
						int last = 1;
						String cssForDetailsRem = "";
						if(designers2.getDesignId() == productId){
							cssForDetailsRem = "style='display:block;'";
						}else{
							cssForDetailsRem = "style='display:none;'";
						}
						desigIdsForHilight+=designers2.getDesignId()+",";
					
		%>
        	<li id="record<%=designers2.getDesignId() %>">
                
            <div class="cart_list" id="cart_li<%=designers2.getDesignId() %>" onclick="loadPopup('<%=designers2.getDesignId()%>');">
            
            	<div class="cart_list_image" style="background:url(<%=designersImages.getEntity_image1().replace(PortletProps.get("main.image.dimension"),PortletProps.get("list.page.dimension")) %>) no-repeat; background-size:contain; background-position:0% 40%;">
            	<div class="cart_remove" <%=cssForDetailsRem %> id="cart_re<%=designers2.getDesignId() %>"><img src="<%=request.getContextPath() %>/images/remove.png" alt="note" onclick='removeProductConfirmPopUp("<%=designers2.getDesignId()%>","<%=last %>")'></div></div>
            	
            	<div class="cart_list_main_content">
                <div class="cart_list_image_heading"><%=designers2.getProductTitle() %></div>
                
                <div class="cart_list_image_heading"><%=designers2.getShortDescription().replaceAll("</br>", "")%></div>
                </div>
                
                <a id="popup" href="#myPopup"><div class="cart_list_highlight_btn" id="details_highlight<%=designers2.getDesignId() %>" onclick="getProductDetails('<%=designers2.getDesignId()%>', false,'<%=ImpressionTypes.SHORTLIST %>');" <%=cssForDetailsRem %>>DETAILS</div></a>
                
            </div>
            
            </li><!--cart_list1-->
            	<%
				
					}
				
				}	
		}catch(Exception e){
			session.invalidate();
			%>
			<script>
			//alert(">>>>>>>>>>>>>>>>>");
			window.location = '/docked';
			</script>
			<%
		
			}
		%>
            
            
             <li id="add_item"><div class="cart_list_add">
            	<a id="popup" href="#hints" data-rel="popup" data-position-to="window" data-transition="none"><div class="cart_list_image" style="background:url(<%=request.getContextPath() %>/images/add_item.jpg) no-repeat; background-size:contain;"></div></a>
                
            </div></li><!--cart_list2-->
            
            <%if(showCongratsMsg){ %>
            <li id="congrats"><div class="cart_list_congrats">
            	
                <div class="cart_instruction_heading">CONGRATS!</div>
                
                	<div class="cart_instruction">
                        You have added<br/>
                       	an item to your list.<br/><br/>
                        
                        Touch this device<br/>
                        to another symbol<br/> 
                        or select an item<br/>
                        from the area<br/>
						below.
                    </div>
            </div></li><!--cart_list3-->
            <%} %>
           <%--  <%if(showWow) {%> --%>
	            <li id="wow"><div class="cart_list_wow">
	           	
	               <div class="cart_instruction_heading">WOW!</div>
	               
	               	<div class="cart_instruction">
	                       Quite a list you have<br/>
	                      here! Take it home<br/>
	                       via email.<br/>
	                   </div>
	                   
	                   <div class="wow_btn">EMAIL MY LIST</div>
	           </div></li><!--cart_list4-->
           <%--  <%} %> --%>
            
      </ul>
        
        <!--</div>--><!--cart_list_block-->
        
</div><!--cart_top-->

<div id="highLightDesigners" style="display:none"><%=desigIdsForHilight %></div>	


<div class="cart_top" id="droppable">
	<div class="cart_top_heading">RELATED TO THIS ITEM</div>
    
    	<!--<div class="cart_list_block">-->
        
        <ul id="trash1" class="cart_list_block_bottom">
			<div class="spinner" style="display:none;"></div>
        	<%
        		try{
        				List<Recommendations> listRecomm1 = RecommendationsLocalServiceUtil.getByDesigner1(1, object.getBarcode(), object.getCompanyId());
        				//List<Designers> itemsByColor = DesignersLocalServiceUtil.getByCompanyId(themeDisplay.getCompanyId())
        				System.out.println(object.getBarcode()+">>>>>>>>>>>>>>>>>>>>>>>>"+listRecomm.size());
        				int count =0;
        				for(Recommendations recommendations : listRecomm1) {
        					Designers designers = DesignersLocalServiceUtil.getByCompanyId(recommendations.getCompanyId(), recommendations.getDesigner2());
        					if((designers.getDesignId() == productId) || 
        							(cartList != null && cartList.containsKey(designers.getDesignId()))) continue;
        					//if(object.getColors().equalsIgnoreCase(designers.getColors())){
        					
        					//if(count>6) break;
        					
        					if(count>=3) break;
        					if(designers != null && designers.isIsactive()){
        						DesignersImages designersImages = DesignersImagesLocalServiceUtil
        								.getByDesignId(designers.getDesignId());
        						String URL = "/designers?designId=";

        						URL = URL + designers.getDesignId();
        						count++;
        	%>
        	<li><div id="record-div<%= designers.getDesignId()%>" class="cart_list_bottom" onclick="getProductDetails('<%=designers.getDesignId()%>', true,'<%=ImpressionTypes.RELATED%>');">
        	<%-- <div class="cart_list_bottom" onclick="viewProductDetails('<%=designers.getDesignId()%>');"> --%>
            	<div class="cart_list_image" style="background:url(<%=designersImages.getEntity_image1().replace(PortletProps.get("main.image.dimension"),PortletProps.get("list.page.dimension")) %>) no-repeat; background-size:contain; background-position:0% 40%;"></div>
            </div></li><!--cart_list1-->
            
             <% 		
					//}
						}
				} 
				
				} catch(Exception e){}
			
			%>
            
           
            
      </ul>
        
<!--cart_list_block-->
        
</div><!--cart_mid-->






<div class="cart_top" id="droppable" style="border:0;">
	<!-- <div class="cart_top_heading">OTHER IDEAS</div> -->
	<div class="cart_top_heading">Our Edit</div>
    
    	<!--<div class="cart_list_block">-->
        
        <ul id="trash2" class="cart_list_block_bottom">
			<div class="spinner2" style="display:none;"></div>
        	<%
				try{
					List<Recommendations> listRecomm2 = RecommendationsLocalServiceUtil.getByDesigner1(2, object.getBarcode(), object.getCompanyId());
					//List<Designers> itemsByColor = DesignersLocalServiceUtil.getByCompanyId(themeDisplay.getCompanyId())
					System.out.println(object.getBarcode()+">>>>>>>>>>>>>>>>>>>>>>>>"+listRecomm.size());
					int count =0;
					for(Recommendations recommendations : listRecomm2) {
						Designers designers = DesignersLocalServiceUtil.getByCompanyId(recommendations.getCompanyId(), recommendations.getDesigner2());
						if((designers.getDesignId() == productId ) || 
								(cartList != null && cartList.containsKey(designers.getDesignId())))continue;
						//if(object.getColors().equalsIgnoreCase(designers.getColors())){
						
						//if(count>6) break;
	
						if(count>=3) break;
						if(designers != null && designers.isIsactive()){
							DesignersImages designersImages = DesignersImagesLocalServiceUtil.getByDesignId(designers.getDesignId());
							String URL = "/designers?designId=";
		
							URL = URL + designers.getDesignId();
							count ++;
				%>
        	<li><div id="record-div<%= designers.getDesignId()%>" class="cart_list_bottom" onclick="getProductDetails('<%=designers.getDesignId()%>', true,'<%=ImpressionTypes.OUREDIT%>');">
        	<%-- <div class="cart_list_bottom" onclick="viewProductDetails('<%=designers.getDesignId()%>');"> --%>
            	<div class="cart_list_image" style="background:url(<%=designersImages.getEntity_image1().replace(PortletProps.get("main.image.dimension"),PortletProps.get("list.page.dimension")) %>) no-repeat; background-size:contain; background-position:0% 40%;"></div>
            </div></li><!--cart_list1-->
              <% 		
					//}
						}
				} 
				
				} catch(Exception e){}
			
			%>
            
          
            
            
      </ul>
        
<!--cart_list_block-->
        
</div><!--cart_bottom-->


</div><!--DragandDrop_main-->



</div><!--main_all-->

<%} catch(Exception e) {
		_log.error(e);

	%>
	  <div class="mainerrordiv">
	<div class="section">
      <h1>Error</h1>
      <div class="article"> 
        <p>An error occurred in the application and your page could not be served.</p>
        <a href="/undocked">Click Here to Return</a>
      </div> 
      </div>
      </div>
      <script type="text/javascript">
	      setTimeout( function(){
		   //hide_loading();
		 }, 500 );
	</script>
	<%} %>
	
<div class="finish_overlay"></div>
<div id="finish" class="finish_btn">I'M FINISHED</div>
<div id="clear" class="finish_btn" onclick="removeFromSession();" style="z-index:2000;">CLEAR SESSION</div>



<script type="text/javascript" src="<%=request.getContextPath() %>/js/made-common.js"></script>

<script>

show_loading();
function removeProductConfirmPopUp(id,last){
	
	$("#myPopup").hide();
	$("#close").hide();
	$("#remove_main").show();
	$("#remove").show();
	
	$('body').css('position','fixed');
	$('body').css('overflow-y','hidden');
	$('body').css('overflow-x','hidden');
	
	$(".remove_yes").attr("onclick","removeProdFromSession("+id+","+last+")");
}
function removeProdFromSession(id,last){
	show_removed();
	$("#myPopup").hide();
	$("#close").hide();
	$("#remove_main").hide();
	$("#remove").hide();
	$("#wow").hide();
	$("#myPopup_main").hide();
	$("#saveOnLoad").hide();
	$('body').css('position','fixed');
	$('body').css('overflow-y','scroll');
	$('body').css('overflow-x','hidden');
	
	var x=document.getElementById("lastRecommendation");
	document.getElementById("lastRecommendation").innerHTML = x.innerHTML-last;
	var lastRecommendation = x.innerHTML-last;
	 $('#removelist').fadeIn('fast');
	var url = '<%=removeCartList.toString() +"&designId=" %>';
	url = url+id;
	var xhr = new XMLHttpRequest();
	xhr.open("GET",url, true);
	xhr.send();
	
	xhr.onreadystatechange = function(e) {
		if (xhr.readyState == 4) {
			if(xhr.status == 200){
				//need to chnage in future with portlet refersh
				setTimeout(function(){						
					//$('#record'+id).hide();
					$("li").remove('#record'+id);
					var addedProdDe = '';
					var addedDs = $("#highLightDesigners").html();
					addedDs = addedDs.replace(id+",","");
					addedDs = addedDs.replace(",,",",");
					//addedDs = addedDs.substring(0, addedDs.length - 1);
					/*var myarray = addedDs.split(',');
					for(var i = 0; i < myarray.length; i++)
					{
					  if(id!= myarray[i]){
						  addedProdDe = myarray[i]+','+addedProdDe;
					  }
					}*/
					//alert(addedDs);
					var last_element = addedDs.split(',');
					//alert(last_element[0]);
					$("#highLightDesigners").html(addedDs);
					$("#cart_li"+last_element[0]).click();
					hide_removed();
					if($("#highLightDesigners").html() == '' || $("#highLightDesigners").html() == null){
						//alert('Redirect');
						location.href="/undocked?page=notification&from=associate-page";
					}
					
					//remove_popup_close();
				}, 1000);
			}
		}
	};
	
	if($("#lastRecommendation").html() == 0){
		$("#congrats").hide();
		$(".email_btn").css('background','#ccc');
		$(".email_btn").css('color','#666');
		$(".email_btn").prop("onclick", false);
		
		$(".email_field").prop('disabled', true);		
		$("#error-invalid").css('visibility','hidden');
		$("#error-zero-products").css('visibility','visible');
		
		
	}
}
//$('#emailsend').on('click', function(event) {
	$('#emailsend').click( function(event) {
	sendMail();
	<%-- if($("#lastRecommendation").html() != 0){
	

	 var email = document.getElementById("<portlet:namespace/>email").value;
	
	var el_1 = $('#error-invalid');
	
	

	 var emailExpression  =  /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

	if (!email.match(emailExpression))
	{
	
			el_1.css('visibility', 'visible'); 
			//el_5.css('border-color', '#FF0000'); 			
	
	    return false;
	}

	el_1.css('visibility', 'hidden');
	$(".email_heading").hide();
	$(".email_field").hide();
	$(".email_btn").hide();
	$("#email_close").hide();
	
	$(".thankyou_heading").show();
	$(".thankyou_btn").show();
	$("#thankyou_close").show();
	$("#finish").hide();
	$("#clear").show();
	
	var url = '<%=sendEmailURL.toString() +"&email=" %>';
	url = url+email;
	var xhr = new XMLHttpRequest();
	xhr.open("GET",url, true);
	xhr.send();
	xhr.onreadystatechange = function(e) {
		if (xhr.readyState == 4) {
			if(xhr.status == 200){
				/*$(".email_heading").hide();
				$(".email_field").hide();
				$(".email_btn").hide();
				$("#email_close").hide();
				
				$(".thankyou_heading").show();
				$(".thankyou_btn").show();
				$("#thankyou_close").show();
				$("#finish").hide();
				$("#clear").show();*/
				
			}
		}
	};
	//el_8.css('display', 'block');
	 
	
	
		
	}	 --%>
});

function sendMail(){	
	if($("#lastRecommendation").html() != 0){
		var email = document.getElementById("<portlet:namespace/>email").value;		
		var el_1 = $('#error-invalid');
		var emailExpression  =  /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if (!email.match(emailExpression)){		
				el_1.css('visibility', 'visible'); 
				//el_5.css('border-color', '#FF0000'); 				
		    return false;
		}
		el_1.css('visibility', 'hidden');
		$(".email_heading").hide();
		$(".email_field").hide();
		$(".email_btn").hide();
		$("#email_close").hide();
		
		$(".thankyou_heading").show();
		$(".thankyou_btn").show();
		$("#thankyou_close").show();
		$("#finish").hide();
		$("#clear").show();
		
		var url = '<%=sendEmailURL.toString() +"&email=" %>';
		url = url+email;
		var xhr = new XMLHttpRequest();
		xhr.open("GET",url, true);
		xhr.send();
		xhr.onreadystatechange = function(e) {
			if (xhr.readyState == 4) {
				if(xhr.status == 200){
					/*$(".email_heading").hide();
					$(".email_field").hide();
					$(".email_btn").hide();
					$("#email_close").hide();
					
					$(".thankyou_heading").show();
					$(".thankyou_btn").show();
					$("#thankyou_close").show();
					$("#finish").hide();
					$("#clear").show();*/
					
				}
			}
		};
		//el_8.css('display', 'block');
		 
		
		
			
		}	
}

function countdown() {
    var d=new Date();
    var n=7-d.getDay();
    if(n==7) n==0;
    if(n==1)
        document.getElementById("countdown1").innerHTML="1 day";
    else
        document.getElementById("countdown1").innerHTML=n+" days";
    var time="";
    if(23-d.getHours()<10) time="0"+(23-d.getHours())+":";
    else time=(23-d.getHours())+":";
    if(59-d.getMinutes()<10) time=time+"0"+(59-d.getMinutes())+":";
    else time=time+(59-d.getMinutes())+":";
    if(59-d.getSeconds()<10) time=time+"0"+(59-d.getSeconds());
    else time=time+(59-d.getSeconds());
    document.getElementById("countdown2").innerHTML=time;
    setTimeout("countdown()",1000);
}
countdown();
	function clicked(url) {
		
		location.href=url+"&from=RECOMMENDATION";
	}
	
function clicked1(url, from) {
		
		location.href=url+"&from="+from;
	}
	
	function removeFromSession(){
		//show_loading();
		window.location = '/undocked';
	}
	//alert($("#lastRecommendation").html());
	
	
 var count=$("#lastRecommendation").html();
 	
 function changeText2(){		
	 if(count >= 2){
		 $("#congrats").hide();	
		 //$("#wow").hide();	
	 }else if(count < 2){
		 $("#congrats").show();
		 $("#wow").hide();
		  generalImpressions('<%=ImpressionTypes.CONGRATS.getValue()%>','<%=ImpressionTypes.SUCCESS.getValue()%>','<%=ImpressionTypes.MESSAGE.getValue()%>');

	 }
	 if(count!=1 && (((count - 1)%3)==0)){
		 //alert("WOW");
			// $(".cart_instruction_heading").html("WOW");
			 $("#congrats").hide();
			 $("#wow").show();	 
			  generalImpressions('<%=ImpressionTypes.WOW.getValue()%>','<%=ImpressionTypes.SUCCESS.getValue()%>','<%=ImpressionTypes.MESSAGE.getValue()%>');

	}else{
		$("#wow").hide();
	}
	 
 }
 changeText2();
 function closeProductPopUp(){
		$("#myPopup_main").hide();
		$("#myPopup").hide();
		$("#close").hide();
		$("#save").hide();
		$("#saveOnLoad").hide();
		$('body').css('position','fixed');
		$('body').css('overflow-y','scroll');
		$('body').css('overflow-x','hidden');
	}
 function getProductDetails(designId, displaySave, viewFrom){
	
	 show_loading();
	 if ($("#record"+designId).length > 0){
		// alert('Exist');
		 	displaySave = false;
		 }else{
			// alert('Not Exist');
			 displaySave = true;
		 }
	 
	
		$('body').css('position','fixed');
		$('body').css('overflow-y','hidden');
		$('body').css('overflow-x','hidden');
		$("#saveOnLoad").hide();
	 var url = '<%=productDetails.toString() +"&designId=" %>';
		url = url+designId+"&viewFrom="+viewFrom;
		var xhr = new XMLHttpRequest();
		xhr.open("GET",url, true);
		xhr.send();
		
		//alert(displaySave + "  "+ (displaySave == "true"));
		
		xhr.onreadystatechange = function(e) {
			if (xhr.readyState == 4) {
				if(xhr.status == 200){
					//alert(xhr.responseText);
					$("#myPopup").html(xhr.responseText);
					//$("#save").attr("onclick","clicked('/designers?designId="+designId+"');");
						var tabsCounts1 = $("ul.TabbedPanelsTabGroup li").length;
						if(tabsCounts1 == 1){
							$(".TabbedPanelsTab").css('width','100%').css('text-align','center').css('padding-right','0').css('padding-left','0');
						}else if(tabsCounts1 == 2){
							$(".TabbedPanelsTab").css('width','49.5%').css('text-align','center').css('padding-right','0').css('padding-left','0');
						}else if(tabsCounts1 == 3){
							$(".TabbedPanelsTab").css('width','33%').css('text-align','center').css('padding-right','0').css('padding-left','0');
						}
	
						function swipe_left_main() 
							{
								$('.carousel-stage').jcarousel('scroll', '+=1');
							}
						function swipe_right_main() 
							{
								$('.carousel-stage').jcarousel('scroll', '-=1');
							}
							
						function swipe_left_thumb() 
							{
								$('.carousel-navigation').jcarousel('scroll', '+=1');
							}
						function swipe_right_thumb() 
							{
								$('.carousel-navigation').jcarousel('scroll', '-=1');
							}
							
						function swipe_left_customer() 
							{
								$('.jcarousel').jcarousel('scroll', '+=1');
							}
						function swipe_right_customer() 
							{
								$('.jcarousel').jcarousel('scroll', '-=1');
							}	
								
						$('.carousel-stage').touchwipe({
						  wipeLeft: function() {
						   swipe_left_main();
						  },
						  wipeRight: function() {
							swipe_right_main();
						  },
						  min_move_x: 20,
						  min_move_y: 20,
						  preventDefaultEvents: false
						});
						
						
						$('.carousel-navigation').touchwipe({
						  wipeLeft: function() {
						   swipe_left_thumb();
						  },
						  wipeRight: function() {
							swipe_right_thumb();
						  },
						  min_move_x: 20,
						  min_move_y: 20,
						  preventDefaultEvents: false
						});
						
						$('.jcarousel').touchwipe({
						  wipeLeft: function() {
						   swipe_left_customer();
						  },
						  wipeRight: function() {
							swipe_right_customer();
						  },
						  min_move_x: 20,
						  min_move_y: 20,
						  preventDefaultEvents: false
						});
						

					$("#save").attr("onclick","addToCart('"+designId+"');");					
					$("#myPopup_main").show();
					$("#myPopup").show();
					$("#close").show();
					
					if(displaySave){
					$("#save").show();
					}else{
						$("#save").hide();
					}
				
					if($(window).width() > 768){

						// Hide all but first tab content on larger viewports
						$('.accordion__content:not(:first)').hide();

						// Activate first tab
						$('.accordion__title:first-child').addClass('active');

						} else {
						  
						// Hide all content items on narrow viewports
						$('.accordion__content').hide();
						};

						// Wrap a div around content to create a scrolling container which we're going to use on narrow viewports
						$( ".accordion__content" ).wrapInner( "<div class='overflow-scrolling'></div>" );

						// The clicking action
						$('.accordion__title').on('click', function() {
						$('.accordion__content').hide();
						$(this).next().show().prev().addClass('active').siblings().removeClass('active');
						});
						var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
						
						 // This is the connector function.
					    // It connects one item from the navigation carousel to one item from the
					    // stage carousel.
					    // The default behaviour is, to connect items with the same index from both
					    // carousels. This might _not_ work with circular carousels!
					    var connector = function(itemNavigation, carouselStage) {
					        return carouselStage.jcarousel('items').eq(itemNavigation.index());
					    };

					    $(function() {
					        // Setup the carousels. Adjust the options for both carousels here.
					        var carouselStage      = $('.carousel-stage').jcarousel();
					        var carouselNavigation = $('.carousel-navigation').jcarousel();

					        // We loop through the items of the navigation carousel and set it up
					        // as a control for an item from the stage carousel.
					        carouselNavigation.jcarousel('items').each(function() {
					            var item = $(this);

					            // This is where we actually connect to items.
					            var target = connector(item, carouselStage);

					            item
					                .on('jcarouselcontrol:active', function() {
					                    carouselNavigation.jcarousel('scrollIntoView', this);
					                    item.addClass('active');
					                })
					                .on('jcarouselcontrol:inactive', function() {
					                    item.removeClass('active');
					                })
					                .jcarouselControl({
					                    target: target,
					                    carousel: carouselStage
					                });
					        });

					        // Setup controls for the stage carousel
					        $('#left')
					            .on('jcarouselcontrol:inactive', function() {
					                $(this).addClass('inactive');
					            })
					            .on('jcarouselcontrol:active', function() {
					                $(this).removeClass('inactive');
					            })
					            .jcarouselControl({
					                target: '-=1'
					            });

					        $('#right')
					            .on('jcarouselcontrol:inactive', function() {
					                $(this).addClass('inactive');
					            })
					            .on('jcarouselcontrol:active', function() {
					                $(this).removeClass('inactive');
					            })
					            .jcarouselControl({
					                target: '+=1'
					            });

									                      

					        // Setup controls for the navigation carousel
					        $('.prev-navigation')
					            .on('jcarouselcontrol:inactive', function() {
					                $(this).addClass('inactive');
					            })
					            .on('jcarouselcontrol:active', function() {
					                $(this).removeClass('inactive');
					            })
					            .jcarouselControl({
					                target: '-=1'
					            });

					        $('.next-navigation')
					            .on('jcarouselcontrol:inactive', function() {
					                $(this).addClass('inactive');
					            })
					            .on('jcarouselcontrol:active', function() {
					                $(this).removeClass('inactive');
					            })
					            .jcarouselControl({
					                target: '+=1'
					            });
					    });
					    $("#myPopup_main").show();
						$("#myPopup").show();
						$("#close").show();
						
					    hide_loading();
				}
			}
		};
		
 }
	
	
	
	function addToCart(productId){
		show_added();
		$('body').css('position','fixed');
		$('body').css('overflow-y','hidden');
		$('body').css('overflow-x','hidden');
		//alert(productId);
		$("#save").hide();
		var actDesignerIdD = '<%=object.getDesignId()%>';
		var url = "<%=addToCartURL.toString() +"&productId=" %>" + productId;
		var xhr = new XMLHttpRequest();
		xhr.open("GET",url, true);
		xhr.send();
		 			
		xhr.onreadystatechange = function(e) {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						var fronNfcLoad = false;
						if ((actDesignerIdD == productId) && ($("#record"+productId).length > 0)){
							fronNfcLoad = true;
						}
						if(!fronNfcLoad){
						//alert("success");
						var data = JSON.parse(xhr.responseText);
						var viewedFrom = '<%=ImpressionTypes.SHORTLIST%>';
						//alert(data);
						//alert(Object.keys(data).length > 0);
						if(Object.keys(data).length > 0){
							//alert(data.ourEdit);
							//alert(data.relatedItems);
							/* var li  = document.createElement('li');
							li.setAttribute("id", "record"+productId); */
							var addedDs = $("#highLightDesigners").html();
							addedDs = productId+','+addedDs;
							$("#highLightDesigners").html(addedDs);
							var newItem = "<li id=\"record"+productId+"\">" ;
							  newItem +=  "<div class=\"cart_list\" id=\"cart_li"+productId+"\" onclick=\"loadPopup(" + productId +");\" >";
							  newItem +=  " <div class=\"cart_list_image\" style=\"background:url(";
							newItem += data.image1;
							newItem +=  ") no-repeat; background-size:contain; background-position:0% 40%;\"> <div class=\"cart_remove\" id=\"cart_re"+productId +"\"> <img src=\"<%=request.getContextPath() %>/images/remove.png\" alt=\"note\"";
							
							newItem += "onclick='removeProductConfirmPopUp("+productId+",1)'></div></div>";
							newItem += "<div class=\"cart_list_main_content\"><div class=\"cart_list_image_heading\">"+data.pTitle+"</div>";
							newItem += "<div class=\"cart_list_image_heading\">"+data.shortDesc+"</div></div>";
							newItem += "<a id=\"popup\" href=\"#myPopup\"><div class=\"cart_list_highlight_btn\" id=\"details_highlight"+productId+"\" onclick=\"getProductDetails("+productId+", false,'"+viewedFrom+"');\">DETAILS</div></a> </div>";
							newItem +=  "</li>";
							
							$("#add_item").before(newItem);
							$(".cart_remove").hide();
							$(".cart_list_highlight_btn").hide();
							$(".cart_list").attr("style","");
							//alert('---------');
							var cartItems = data.cartSize;
							//alert("cartItems"+cartItems);
							$("#lastRecommendation").html(cartItems);
							if(cartItems > 1){
								 $("#congrats").hide();	
								 if(((cartItems-1)%3) == 0 ){
									 $("#wow").show();
									  generalImpressions('<%=ImpressionTypes.WOW.getValue()%>','<%=ImpressionTypes.SUCCESS.getValue()%>','<%=ImpressionTypes.MESSAGE.getValue()%>');

								 } else{
									 $("#wow").hide();
								 } 
							}
							if(cartItems >0){
								$(".email_btn").css('background','#f2e701');
								$(".email_btn").css('color','#000');
								$(".email_field").prop('disabled', false);
								$("#error-zero-products").css('visibility','hidden');
							}
												
							updateRelItems(productId);
														
							var preId= $("#prevProduct").html();
							/* "<%= (Validator.isNotNull(session.getAttribute(Constants.PREV_SEL_PROD)) ? session.getAttribute(Constants.PREV_SEL_PROD) : productId)%>";//$("#preId").val(); */
							//alert("pre Id"+preId);
							//alert("current Id"+productId);
							if(preId==productId){
							//alert("same");
							}else{
							$("#cart_li"+preId).css('border','');
							$("#cart_li"+preId).css('border-top-right-radius','');
							$("#cart_re"+preId).hide();
							$("#details_highlight"+preId).hide();
							$("#cart_re"+preId).hide();
							//alert("heyyy");
							}
							
							$("#cart_li"+productId).css('border','#dddee0 solid 1px');
							$("#cart_li"+productId).css('border-top-right-radius','14px');
							$("#cart_re"+productId).show();
							$("#details_highlight"+productId).show();
							
							$("#prevProduct").html(productId);
							
							
					    }
											
						}
						closeProductPopUp();
						 hide_added();
					}
				}
			};
		
	}
	
	
	function productDetails(){
	 }
	
	function loadPopup(designId){
		
		//var preId= "<%= (Validator.isNotNull(session.getAttribute(Constants.PREV_SEL_PROD)) ? session.getAttribute(Constants.PREV_SEL_PROD) : productId)%>";//$("#preId").val();
		var preId= $("#prevProduct").html();
		//alert("pre Id"+preId);
		//alert("current Id"+designId);
		if(preId==designId){
		//alert("same");
		}else{
		$("#cart_li"+preId).css('border','');
		$("#cart_li"+preId).css('border-top-right-radius','');
		$("#cart_re"+preId).hide();
		$("#details_highlight"+preId).hide();
		//alert("heyyy");
		}
		
		$("#cart_li"+designId).css('border','#dddee0 solid 1px');
		$("#cart_li"+designId).css('border-top-right-radius','14px');
		$("#cart_re"+designId).show();
		$("#details_highlight"+designId).show();
		$("#myPopup_main").hide();
		$("#myPopup").hide();
		$("#close").hide();
		$("#prevProduct").html(designId);
		$("#saveOnLoad").hide();
		updateRelItems(designId);
		
	}
	
	function updateRelItems(designId){	
		//alert("????");
		//$("#trash1").empty();
		//$("#trash2").empty();
		//$(".spinner").show();
		//$(".spinner2").show();
		
		var viewedFromRelated = '<%=ImpressionTypes.RELATED%>';
		var viewedFromOurEdit = '<%=ImpressionTypes.OUREDIT%>';
		var url = '<%=relatedItemsURL.toString() +"&designId=" %>';
		 
		url = url+ designId;
		var xhr = new XMLHttpRequest();
		xhr.open("GET",url, true);
		xhr.send();
		
		xhr.onreadystatechange = function(e) {
			if (xhr.readyState == 4) {
				if(xhr.status == 200){
					var data = JSON.parse(xhr.responseText);
					
					if(Object.keys(data).length > 0){
					var relatedItems = data.relatedItems;//JSON.stringify(data.relatedItems);
					//alert("relatedItems : "+relatedItems);
					var ourEdit = data.ourEdit;//JSON.stringify(data.ourEdit);
					//alert("ourEdit : "+ourEdit);
					
					
					var relItemLi = "";
					//alert(relatedItems.length);
					for (var obj in relatedItems) {
						
						var key = relatedItems[obj];
						relItemLi += "<div class=\"spinner\" style=\"display:none;\"></div><li id=\"record-rel"+key.designId+"\">" ;
						relItemLi += "<div class=\"cart_list_bottom\" onclick=\"getProductDetails(" +key.designId +", true,'"+viewedFromRelated+"');\">";
						relItemLi += "<div class=\"cart_list_image\" style=\"background:url("+key.image1;
						relItemLi += ") no-repeat; background-size:contain; background-position:0% 40%;\"></div>";
						relItemLi += "</div></li><!--cart_list1-->";
					}
					//alert('relItemLi'+relItemLi);
					$('#trash1').empty();
					$('#trash1').html(relItemLi);
					
					var ourEditLi = "";
					for (var obj in ourEdit) {
						var key = ourEdit[obj];
						
						ourEditLi += "<div class=\"spinner2\" style=\"display:none;\"></div><li id=\"record-our"+key.designId+"\">" ;
						ourEditLi += "<div class=\"cart_list_bottom\" onclick=\"getProductDetails(" +key.designId +", true,'"+viewedFromOurEdit+"');\">";
						ourEditLi += "<div class=\"cart_list_image\" style=\"background:url("+key.image1;
						ourEditLi += ") no-repeat; background-size:contain; background-position:0% 40%;\"></div>";
						ourEditLi += "</div></li><!--cart_list1-->";
					}
					$('#trash2').empty();
					$('#trash2').html(ourEditLi);
					//$(".spinner").hide();
					//$(".spinner2").hide();
					}
					
				}
			}
		};
	}
	
	function showHighlight(){
		
		//var preId= "<%= (Validator.isNotNull(session.getAttribute(Constants.PREV_SEL_PROD)) ? session.getAttribute(Constants.PREV_SEL_PROD) : productId)%>";//$("#preId").val();
		//alert("pre Id"+preId);
		var preId= $("#prevProduct").html();
		var designId = "<%=productId %>";
		//alert("current Id"+designId);
		if(preId==designId){
		//alert("same");
		}else{
		$("#cart_li"+preId).css('border','#dddee0 solid 0px');
		$("#cart_li"+preId).css('border-top-right-radius','0px');
		$("#cart_re"+preId).hide();
		$("#details_highlight"+preId).hide();
		//alert("heyyy");
		}
		var detId = "#details_highlight"+designId;
		$("#cart_li"+designId).css('border','#dddee0 solid 1px');
		$("#cart_li"+designId).css('border-top-right-radius','14px');
		$("#cart_re"+designId).show();
		$(detId).attr('style','display: block');
		
		$("#details_highlight"+designId).show();
		
		/* $("#myPopup_main").hide();
		$("#myPopup").hide();
		$("#close").hide(); */

		
	}
	showHighlight();
		
	function generalImpressions(impType,ImpId,ImpAction){
			var url1 = '<%=GeneralImpress.toString()%>';	
			url1 = url1+"&impType="+impType+"&impId="+ImpId+"&impAction="+ImpAction;
			var xhr1 = new XMLHttpRequest();
			xhr1.open("POST",url1, true);
			xhr1.send();
			xhr1.onreadystatechange = function(e) {
						if (xhr1.readyState == 4) {
							if(xhr1.status == 200){
								
							}
						}
					};
		}

		$( "#hints" ).popup({
		  afteropen: function( e) {
			  generalImpressions('<%=ImpressionTypes.ADDITEM.getValue()%>','<%=ImpressionTypes.SUCCESS.getValue()%>','<%=ImpressionTypes.TUTORIAL.getValue()%>');
		   $('body').css('position','fixed');
		   $('body').css('overflow-y','hidden');
		   $('body').css('overflow-x','hidden');
		  },
		  afterclose: function(e) {
		   $('body').css('position','fixed');
		   $('body').css('overflow-y','scroll');
		   $('body').css('overflow-x','hidden');
		  }  
		});
		
		

		 window.onload = function(e){
			 var tabsCountD = 3;
			 	var tabsCollection = '<%=tabs1%>';
			 	var tabsColour = '<%=tabs2%>';
			 	if(tabsCollection == 'false'){
					//alert(1);
			 		$(".TabbedPanelsTabGroup li:contains(Collection)").remove();
			 		--tabsCountD;
			 	}
			 	if(tabsColour == 'false'){
					//alert(2);
			 		$(".TabbedPanelsTabGroup li:contains(Colour)").remove();
			 		--tabsCountD;
			 	}
			 	
			 	//alert(tabsCollection);
				//alert(tabsCountD);
				if(tabsCountD == 1){
					$(".TabbedPanelsTab").css('width','100%').css('text-align','center').css('padding-right','0').css('padding-left','0');
				}else if(tabsCountD == 2){
					$(".TabbedPanelsTab").css('width','49.5%').css('text-align','center').css('padding-right','0').css('padding-left','0');
				}else if(tabsCountD == 3){
					$(".TabbedPanelsTab").css('width','33%').css('text-align','center').css('padding-right','0').css('padding-left','0');
				}
				var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
				
				hide_loading();
			 	$("#save").css("display","block");
			 	$("#save").attr("onclick","addToCart('<%=object.getDesignId()%>');");
			    $('body').css('position','fixed');
				$('body').css('overflow-y','hidden');
				$('body').css('overflow-x','hidden');
			};
		
			$(document).ready(function() {
			    $('input').keypress(function(e) {
			        var code = (e.keyCode ? e.keyCode : e.which);        
			        //if ( (code==13) || (code==10))
			        if ( (code==13))
			        {
			        	sendMail();
			        	return false;
			         }
			    }
			   );
			});
</script>

<script type="text/javascript">

if(<%=isProduction%> == true){
	//alert('true');
	 (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
		  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
		  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
		  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

		  ga('create', 'UA-36111687-3', 'auto');
		  ga('send', 'pageview');

}



</script>