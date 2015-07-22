<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.Collection"%>
<%@ include file="/html/cloudtags/init.jsp"%>

<portlet:renderURL var="popURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="jspPage" value="/html/cloudtags/shortlist/popup.jsp"/>
</portlet:renderURL>

<portlet:resourceURL var="removeCartList">
	<portlet:param name="CMD" value="remove"/>
</portlet:resourceURL>

<portlet:resourceURL var="endSessionURL">
	<portlet:param name="CMD" value="staffEnd"/>
</portlet:resourceURL>

	<div class="list-view" id="list-page-info"
		style="display: block; text-align: center;">
		<img src="https://s3.amazonaws.com/ct-hn/listpage.png" />
	</div>
	
	<div class="gfont bold designer-view" id="rec-area" style="display: block;">
	
	<h2> YOUR SHORTLIST </h2> 
		
	<div id="designer-list" style="display: block;">
	
		<%
		
			boolean isStaff = Boolean.parseBoolean( originalRequest.getParameter("staffShortList"));
		
			HashMap<Long, Designers> list = (HashMap<Long, Designers>) session
					.getAttribute("LIFERAY_SHARED_CARTLIST");
	
			if (Validator.isNotNull(list) && list.size() >0) {
				
				Collection<Designers> designers = list.values();
				
				for (Designers designers2 : designers) {
	
					DesignersImages designersImages = DesignersImagesLocalServiceUtil
							.getByDesignId(designers2.getDesignId());
					String URL = "/designers?designId=";
	
					URL = URL + designers2.getDesignId();
		%>
	
	<%-- 
		<div class="designer-list-item gfont"
			data-stretch="<%=designersImages.getEntity_image1()%>"
			style="background-image: url('<%=designersImages.getEntity_image1()%>'); background-position: 50% 50%;"
			id="yui_patched_v3_11_0_1_1387695527559_1346">
			<div class="designer-view" data-slug="piyush"
				id="yui_patched_v3_11_0_1_1387695527559_1345">
				<div class="designer-detail" style=""
					id="yui_patched_v3_11_0_1_1387695527559_1344">
					<h2><%=designers2.getName()%></h2>
					<h3><%=designers2.getBrand()%></h3>
					<h4>
						£
						<%=designers2.getSaleprice()%></h4>
					<h4>
						Product Code:
						<%=designers2.getProductcode()%></h4>
				</div>
			</div>
			<div class="view-buton" style="" onclick='clickedURL("<%=URL%>")'>View</div>
			<div class="remove-buton" style=""  onclick='removeFromSession("<%=designers2.getDesignId()%>")'>Remove</div>
		</div>
		 --%>
		
		<div class="designer-list-item gfont"
					data-stretch="<%=designersImages.getEntity_image1() %>"
					style="background-image: url('<%=designersImages.getEntity_image1() %>'); background-position: 50% 50%;">
					<div class="designer-view" data-slug="<%=designers2.getName() %>">
						<div class="designer-detail-list-page" style="display: block;">
							<h2><%= designers2.getBrand()%></h2>
							<h3><%=designers2.getName() %></h3>
							<h4>£<%=designers2.getSaleprice() %></h4>
								
							<h4>Product Code: <%=designers2.getProductcode()%></h4>
						
						</div>
					</div>
			<div class="view-buton" style="" onclick='clickedURL("<%=URL%>")'>View</div>
			<div class="remove-buton" style=""  onclick='removeFromSession("<%=designers2.getDesignId()%>")'>Remove</div>
		</div>
		
	
	
		<%
			} if(isStaff) {
		%>
		
			<div class="designer-list-item gfont shortlist" data-stretch="https://s3.amazonaws.com/ct-hn/readybutton.png" id="i_am_ready_button_staff" style="background-image: url(https://s3.amazonaws.com/ct-hn/shortlist_readybutton.png); background-position: 50% 50%;" >
		
			</div>
		
		
		<% } else { %>
		
			<div class="designer-list-item gfont shortlist"
				data-stretch="https://s3.amazonaws.com/ct-hn/readybutton.png"
				id="i_am_ready_button"
				style="background-image: url(https://s3.amazonaws.com/ct-hn/readybutton.png); background-position: 50% 50%;" onclick='clickedURL("/i-m-ready")' >&nbsp;
			</div>
		<%
			
			}
		} else {
		%>
	
		<div class="designer-list-item gfont emptyproduct"
			style="background-image: url(https://s3.amazonaws.com/ct-hn/emptyproduct.png); background-position: 50% 50%;">&nbsp;
		</div>
	
		<%
			}
		%>
	
	</div>
<div class="clear"></div>
</div>
<script>


	function clickedURL(url) {
		loadingmask("#designer-list");
		location.href=url;
	}
	
	
	
	function removeFromSession(id){
		loadingmask("#designer-list");

		var url = '<%=removeCartList.toString() +"&designId=" %>';
		url = url+id;
		var xhr = new XMLHttpRequest();
		xhr.open("POST",url, true);
		xhr.send();
		
		xhr.onreadystatechange = function(e) {
			if (xhr.readyState == 4) {
				if(xhr.status == 200){
					//need to chnage in future with portlet refersh
					location.href="/shortlist";
				}
			}
		}
		
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
	
	
	
</script>

<aui:script use="node">

A.one('#i_am_ready_button_staff').on('click',function(event) {

	loadingmask("#designer-list");
	var url = '<%=endSessionURL.toString()  %>';


	var xhr = new XMLHttpRequest();
		xhr.open("POST",url, true);
		xhr.send();
		
		
		xhr.onreadystatechange = function(e) {
			if (xhr.readyState == 4) {
			
				if(xhr.status == 200){
					//need to chnage in future with portlet refersh
					location.href="/shortlist";
				}
			}
		}

});

</aui:script>
