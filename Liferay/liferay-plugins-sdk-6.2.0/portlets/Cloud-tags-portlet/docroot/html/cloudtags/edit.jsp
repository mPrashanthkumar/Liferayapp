
<%@ include file="/html/cloudtags/init.jsp"%>



<%
Designers  designers = null;
DesignersImages  image = null;

long designId =  ParamUtil.getLong(renderRequest, "designId");
try{
	designers = DesignersLocalServiceUtil.getDesigners(designId);
	image = DesignersImagesLocalServiceUtil.getByDesignId(designId);
} catch(Exception e){
	
}
%>
<portlet:renderURL var="backURL"></portlet:renderURL>

<portlet:actionURL var="createDesigner">
	<portlet:param name="<%=ActionRequest.ACTION_NAME %>" value="editProduct"/>
</portlet:actionURL>

<aui:form name="fm2" id="fm2" method="POST"  action="<%=createDesigner.toString() %>" enctype="multipart/form-data" inlineLabels="true">
	<aui:model-context bean="<%=designers%>"
					model="<%=Designers.class%>">
	<aui:input name="designId" type="hidden" label="designId" value='<%=""+designId %>' />
	<aui:layout>
		<aui:column cssClass="aui-w50" first="true">
			<aui:input name="name" type="text" label="Name">
				<aui:validator name="required" />
			</aui:input>
		</aui:column>
	</aui:layout>
	<aui:layout>
		<aui:column cssClass="aui-w50" first="true">
			<aui:input name="description" type="textarea" label="Editor's Notes" style="width: 624px; height: 88px;" />
		</aui:column>
	</aui:layout>
	<aui:layout>
		<aui:column cssClass="aui-w50" first="true">
			<aui:input name="saleprice" type="text" label="Price" />
		</aui:column>
	</aui:layout>
	<aui:layout>
		<aui:column cssClass="aui-w50" first="true">
			<aui:input name="public_url" type="text" label="Show URL" style="width: 624px;" />
		</aui:column>
	</aui:layout>
	
	</aui:model-context>
	
	<aui:layout>
		<%
			if(Validator.isNotNull(image)) {
		%>
		<aui:column >
			<img alt="" src="<%=image.getEntity_image1() %>" width="75">
		</aui:column>
		
		<%} %> <br/>
		<aui:column cssClass="aui-w50" first="true">
			<aui:input name="entity_image1" type="file" label="Image1" />
		</aui:column>
	</aui:layout>
	<aui:layout>
	
		<%
			if(Validator.isNotNull(image)) {
		%>
		<aui:column >
			<img alt="" src="<%=image.getEntity_image2() %>" width="75">
		</aui:column>
		
		<%} %> <br/>
		<aui:column cssClass="aui-w50" first="true">
			<aui:input name="entity_image2" type="file" label="Image2" />
		</aui:column>
	</aui:layout>
	<aui:layout>
		<%
			if(Validator.isNotNull(image)) {
		%>
		<aui:column >
			<img alt="" src="<%=image.getEntity_image3() %>" width="75">
		</aui:column>
		
		<%} %> <br/>
		<aui:column cssClass="aui-w50" first="true">
			<aui:input name="entity_image3" type="file" label="Image3"  />
		</aui:column>
	</aui:layout>
	<aui:layout>
	
		<%
			if(Validator.isNotNull(image)) {
		%>
		<aui:column >
			<img alt="" src="<%=image.getEntity_image4() %>" width="75">
		</aui:column>
		
		<%} %> <br/>
		<aui:column cssClass="aui-w50" first="true">
			<aui:input name="entity_image4" type="file" label="Image4" />
		</aui:column>
	</aui:layout>

	<aui:layout>
		<aui:column cssClass="aui-w50" first="true">
			<aui:input name="submit" type="submit"  value="Submit" />
		</aui:column>
	</aui:layout>
</aui:form>

<a href="<%=backURL.toString()%>">&raquo;Back</a>