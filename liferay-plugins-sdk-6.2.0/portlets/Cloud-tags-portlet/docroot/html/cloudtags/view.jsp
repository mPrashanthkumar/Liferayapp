
<%@ include file="/html/cloudtags/init.jsp"%>

<portlet:actionURL var="createDesigner">
	<portlet:param name="<%=ActionRequest.ACTION_NAME %>" value="addDesigner"/>
</portlet:actionURL>

<portlet:renderURL var="backURL"></portlet:renderURL>

<aui:form name="fm2" id="fm2" method="POST"  action="<%=createDesigner.toString() %>" enctype="multipart/form-data" inlineLabels="true">

	<aui:layout>
		<aui:column cssClass="aui-w50" first="true">
			<aui:input name="name" type="text" label="Name">
				<aui:validator name="required" />
			</aui:input>
		</aui:column>
	</aui:layout>
	<aui:layout>
		<aui:column cssClass="aui-w50" first="true">
			<aui:input name="description" type="textarea" label="Editor's Notes" />
		</aui:column>
	</aui:layout>
	<aui:layout>
		<aui:column cssClass="aui-w50" first="true">
			<aui:input name="price" type="text" label="Price" />
		</aui:column>
	</aui:layout>
	<aui:layout>
		<aui:column cssClass="aui-w50" first="true">
			<aui:input name="show_url" type="text" label="Show URL" />
		</aui:column>
	</aui:layout>
	<aui:layout>
		<aui:column cssClass="aui-w50" first="true">
			<aui:input name="entity_image1" type="file" label="Image1" />
		</aui:column>
	</aui:layout>
	<aui:layout>
		<aui:column cssClass="aui-w50" first="true">
			<aui:input name="entity_image2" type="file" label="Image2" />
		</aui:column>
	</aui:layout>
	<aui:layout>
		<aui:column cssClass="aui-w50" first="true">
			<aui:input name="entity_image3" type="file" label="Image3"  />
		</aui:column>
	</aui:layout>
	<aui:layout>
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