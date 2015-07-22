<%@ include file="/html/cloudtags/init.jsp"%>

<portlet:resourceURL var="addToCartURL">
</portlet:resourceURL>

<%
	Long  productId= 0l;
	Designers  object =null;
	try{
		productId = Long.parseLong( originalRequest.getParameter("designId"));
		object = DesignersLocalServiceUtil.getDesigners(productId);
		DesignersImages designersImage = DesignersImagesLocalServiceUtil.getByDesignId(object.getDesignId());
	
%>

		<div class="main">
			<div id="myGallery" style="height: 1086px;">
				<a href="<%=designersImage.getEntity_image1() %>"
					title="<%= object.getName()%>"> <img class="picture"
					src="<%=designersImage.getEntity_image1() %>" />
				</a>
				<%
					if(Validator.isNotNull(designersImage.getEntity_image2())) {
				%>
				<a href="<%=designersImage.getEntity_image2() %>"
					title="<%= object.getName()%>"> <img class="picture"
					src="<%=designersImage.getEntity_image2() %>" />
				</a>
		
				<%} if(Validator.isNotNull(designersImage.getEntity_image3())) { %>
		
				<a href="<%=designersImage.getEntity_image3() %>"
					title="<%= object.getName()%>"> <img class="picture"
					src="<%=designersImage.getEntity_image3() %>" />
				</a>
				<%} if(Validator.isNotNull(designersImage.getEntity_image4())) { %>
		
				<a href="<%=designersImage.getEntity_image4() %>"
					title="<%= object.getName()%>"> <img class="picture"
					src="<%=designersImage.getEntity_image4() %>" />
				</a>
		
				<%} %>
			</div>
		
			<div id="add-round" class="designer-view" style="display: block;">
				<img src="https://s3.amazonaws.com/ct-hn/addshort.png">
			</div>
		
			<div id="designer-box" style="display: block;">
				<div id="designer-content">
					<div class="gfont bold" id="designer-title"><%=object.getBrand()%></div>
					<span class="gfont" id="designer-description"
						style="display: inline;"><%=object.getName()%></span> <span
						class="gfont" id="designer-price">£<%=object.getSaleprice()%></span>
					<br>
					<br>
					<div data-target="#designer-details"
						class="collapse-button render-description-button gfont designer-view"
						style="display: block;">
						+ <span>Editor's Notes</span>
					</div>
					<div id="designer-details" class="collapse"><%=object.getDescription()%></div>
		
				</div>
		
			</div>
		</div>
			
	<%} catch(Exception e) {

	%>

	<div class="errorDialog">
		<h1>We're sorry, but something went wrong.</h1>
	</div>
	<%} %>

	<div class="gfont bold designer-view" id="rec-area"
		style="display: block;">
		<h2>- EDITOR'S RECOMMENDATIONS -</h2>
		<div id="recommendations">
			<%
			try{
				List<Designers> items = DesignersLocalServiceUtil.getByproductCode(object.getProductcode());
				int count =0;
				for(Designers designers : items) {
					
					if(designers.getDesignId() == productId ) continue;
					
					count ++;
					if(count>4) break;

					DesignersImages designersImages = DesignersImagesLocalServiceUtil.getByDesignId(designers.getDesignId());
					String URL = "/designers?designId=";

					URL = URL + designers.getDesignId();
				%>
				
				<div class="designer-list-item gfont"
					data-stretch="<%=designersImages.getEntity_image1() %>"
					style="background-image: url('<%=designersImages.getEntity_image1() %>'); background-position: 50% 50%;">
					<div class="designer-view" data-slug="<%=designers.getName() %>">
						<div class="designer-detail-list-page" style="display: block;">
							<h2><%= designers.getBrand()%></h2>
							<h3><%=designers.getName() %></h3>
							<h4>
								£<%=designers.getSaleprice() %></h4>
						</div>
					</div>
					<div class="view-buton-list-page" style="display: block;" onclick='clicked("<%=URL.toString() %>")' >View</div>
				</div>
				<% 
				
				
				} 
				
				} catch(Exception e){}
			
			%>

		</div>
		<div class="clear"></div>
	</div>




<aui:script>
AUI().ready(
  'aui-image-viewer-base','aui-carousel',
  function(B) {
    new B.ImageViewer(
      {
        caption: 'hello',
        captionFromTitle: true,
        links: '#myGallery a',
        preloadAllImages: true
      }
    ).render();
	
	new B.Carousel(
      {
        activeIndex: 'rand',
        contentBox: '#myGallery',
		centered:true,
        intervalTime: 3
      }
    ).render();
  }
);

</aui:script>

<aui:script use="node">
A.one('.collapse-button').on('click', function(event) {
	var el_1 = A.one('#designer-details');

	if(el_1) {
		if(el_1.getStyle ('display') == 'block')
         el_1.setStyle('display', 'none');
       else
          el_1.setStyle('display', 'block');
	 

	}
});

A.one('#add-round').on('click',function(event){

	loadingmask(".main");
	var url = '<%=addToCartURL.toString() +"&productId=" +productId %>';
	var xhr = new XMLHttpRequest();
	xhr.open("POST",url, true);
	xhr.send();
	
	
		xhr.onreadystatechange = function(e) {
				if (xhr.readyState == 4) {
					if(xhr.status == 200){
						location.href="/shortlist";
					}
				}
			}
	

});

</aui:script>

<script type="text/javascript">
	function clicked(url) {
	
		location.href=url;
	}
	
	var img = $("img.picture")[0];
	// Get my img elem
	var pic_real_width, pic_real_height;
	$("<img/>") // Make in memory copy of image to avoid css issues
	.attr("src", $(img).attr("src"))
	.load(function() {
       pic_real_width = this.width;  
       pic_real_height = this.height;
		var el_1 = $('#myGallery');
		
		if(el_1) {
	         el_1.css('height', pic_real_height +"px");
		}
	
   });	
	
</script>



