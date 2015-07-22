<%@page import="com.cloud.tags.common.CommonUtil"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.cloud.tags.model.CartsDesigners"%>
<%@page import="com.cloud.tags.service.CartsDesignersLocalServiceUtil"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.Collection"%>
<%@ include file="/html/cloudtags/init.jsp"%>
<link href='http://fonts.googleapis.com/css?family=Kameron:400,700|Montserrat:400,700' rel='stylesheet' type='text/css'>

<portlet:renderURL var="popURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="jspPage" value="/html/cloudtags/shortlist/popup.jsp"/>
</portlet:renderURL>

<portlet:resourceURL var="removeCartList">
	<portlet:param name="CMD" value="remove"/>
</portlet:resourceURL>


<portlet:resourceURL var="endSessionURL">
	<portlet:param name="CMD" value="staffEnd"/>
</portlet:resourceURL>
<script type="text/javascript">
show_loading();
function check_dock() {
  var randomNum = Math.ceil(Math.random() * 999999);
  var script   = document.createElement("script");
  script.type  = "text/javascript";
  script.src   = 'http://127.0.0.1:8080/status?' + randomNum;  
  document.body.appendChild(script);
  setTimeout(function(){check_dock();},4000);
}

function ctDeviceCallback(data) {
  if (data['status'] == 'docked') {
    window.location = '/docked';
  }
}
//check_dock();
</script>
<style>
<!--
#designer-list {
   background-color: #ffffff;
   min-height: 650px;
   height: auto;
   margin-top: 34px;
   padding:0px;
}
-->
</style>


<div style="position: relative; width: 250px; background-image: url('<%=request.getContextPath()%>/images/made/madelogo.png'); background-repeat: no-repeat; top: 23px; left: 22px; background-size: 100% auto; height: 68px;" id="logo"></div>
<div style="left: 0px; width: 600px; height: 1px; background: none repeat scroll 0% 0% rgb(0, 0, 0); position: relative; top: 34px;" id="divider"></div>
	
          <div id="removelist" class='gfont'>Removed From List</div>
          <div id="list-page-info" class="list-view" style="display: none;">      
			<div style="position:absolute; top:135px; left:0px; width:600px; height:60px; background:#ffffff; font-family:futurabook; font-size:50px; color:#4a4a4a; text-align:center; vertical-align:middle; line-height:60px" id="line1">Hold tablet against</div>
			<div style="position:absolute; top:206px; left:0px; width:600px; height:60px; background:#ffffff; font-family:futurabook; font-size:50px; color:#4a4a4a; text-align:center; vertical-align:middle; line-height:60px" id="line2">marker until it beeps</div>
			<div style="left: 140px; top: 292px;position: absolute;width: 300px; height: 280px;" id="icon">
				 <img height="300" width="300" src="http://made.cloudtags.com:9090/documents/11205/0/madehomelogo.png"/>			
			</div>
    	</div>	
   
	
		<%
	//	System.out.println("generateshortURL>>>>"+generateshortURL);
		
			boolean isStaff = Boolean.parseBoolean( originalRequest.getParameter("staffShortList"));
		
			/*HashMap<Long, Designers> list = (HashMap<Long, Designers>) session
					.getAttribute("LIFERAY_SHARED_CARTLIST");*/
					try{
		HashMap<Long, CartsDesigners> list = (HashMap<Long, CartsDesigners>) session
			.getAttribute("LIFERAY_SHARED_CARTDESIGNERS");
			
			if (Validator.isNotNull(list) && list.size() >0) {
				//Map<Long, Designers> map = new TreeMap<Long, Designers>(list).descendingMap();
			
					String style =StringPool.BLANK;
					if(list.size()>=3){
						style = "style='padding-bottom: 120px;'";
						}
					%>
					<div id="designer-list" <%=style %>>
					
					<div id="lastRecommendation" style="display:none"><%=list.size() %></div>					
	   	
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
						
					
		%>
	
		<div id="record<%=designers2.getDesignId() %>" style="margin-bottom:2px;width: 600px; padding-top:0px; height: 200px; background-color: rgb(255, 255, 255);">
		<div class="" onclick='removeFromSession("<%=designers2.getDesignId()%>","<%=last %>")' style="float: right; background-size: 100% auto; left: -10px; position: relative; top: 152px;">
			<img width="40" height="40" src="<%=request.getContextPath()%>/images/made/x.png">
		</div>
		<div class="" onclick='clickedURL("<%=URL%>")'
					data-stretch="<%=designersImages.getEntity_image1() %>"
					style="background-image: url('<%=designersImages.getEntity_image1() %>');float:left; background-repeat: no-repeat;background-size: 100% 100%;width:310px;height:200px;font-family:Montserrat">
						
		</div>
		<div style="padding-top:20px;padding-left:345px">
			<span id="title" style="font-family: Montserrat; position: relative; word-wrap: break-word; text-transform: uppercase; font-size: 32px; line-height: 32px;"><%=designers2.getProductTitle() %></span> <br> 
			<span id="shortdiscription" style="position: relative;font-family: Kameron; font-size: 20px; line-height: 24px;word-wrap: break-word;"><%if(designers2.getShortDescription().length()>61){ %><%=designers2.getShortDescription().substring(0, 61)%>...<%}else{ %><%=designers2.getShortDescription()%><%} %></span> 
			<br>
			<span id="price" style="position: relative; font-family: Kameron; font-size: 20px;">£<%=designers2.getPrice()%></span> 
	</div>
		
		
		</div>
		<div style="left: 0px; width: 600px; height: 2px; background-color: #E4E4E4; background: none repeat scroll 0% 0% rgb(228, 228, 228); position: relative; top: 0px;" id="dividerbar<%=designers2.getDesignId() %>"></div>	
		<%
					//}
					}
				%>
				</div>
				<%
				}	
		}catch(Exception e){
			System.out.println(e.getMessage());		
			session.invalidate();
		%>
		<script type="text/javascript">
			$('#list-page-info').show();
		</script>		
		
		<%
			}
		%>


	
<nav role="navigation" id="navigation" class="sort-pages modify-pages navbar site-navigation"> 
				<div id="link2"  onclick="window.history.back()" style="text-align:center;position:absolute;left:200px;width:80px;height:80px;background:#d0d0d0;border-radius:8px">
					<img width="60" height="60" style="margin-top:10px" src="<%=request.getContextPath()%>/images/made/icon5.png"/>	
				</div>
				
				<div id="link3" onclick="window.location='/i-m-ready'" style="text-align:center;position:absolute;left:300px;width:80px;height:80px;background:#d0d0d0;border-radius:8px">
					<img width="60" height="60" style="margin-top:10px" src="<%=request.getContextPath()%>/images/made/icon6.png"/>	
				</div>
				
			

</nav>
<div class="clear"></div>

<script>


	function clickedURL(url) {
		//loadingmask("#designer-list");
		location.href=url+"&from=LISTPAGE";
	}
	
	
	
	function removeFromSession(id,last){
		var x=document.getElementById("lastRecommendation");
		document.getElementById("lastRecommendation").innerHTML = x.innerHTML-last;
		var lastRecommendation = x.innerHTML-last;
		 $('#removelist').fadeIn('fast');
		var url = '<%=removeCartList.toString() +"&designId=" %>';
		url = url+id;
		var xhr = new XMLHttpRequest();
		xhr.open("POST",url, true);
		xhr.send();
		
		xhr.onreadystatechange = function(e) {
			if (xhr.readyState == 4) {
				if(xhr.status == 200){
					//need to chnage in future with portlet refersh
					setTimeout(function(){						
						$('#record'+id).hide();	
						$('#dividerbar'+id).hide();						
						$('#removelist').hide();
						if(lastRecommendation == -1){
							$('#list-page-info').show();	
						}
					}, 1000);
				}
			}
		};
		
	}
	

	function confirmDialog(){
			var url ='<%= popURL%>';
			 Liferay.Util.openWindow(
				{
					dialog: {
						width: 250,
						centered: true,
						destroyOnClose: true,
						id:'<portlet:namespace />metadata'
					},
					id: '<portlet:namespace />cartListSelector',
					title: 'Delete Cart List',
					uri: url
					
				}
			); 
			 
		}
	
	setTimeout( function(){
	 	   hide_loading();
	 	 }, 2000 );
</script>