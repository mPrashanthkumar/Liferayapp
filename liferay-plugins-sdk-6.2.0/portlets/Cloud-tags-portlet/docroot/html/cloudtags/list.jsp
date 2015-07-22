<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.cloud.tags.common.CommonUtil"%>
<%@ include file="/html/cloudtags/init.jsp"%>

<portlet:renderURL var="renderURL"></portlet:renderURL>



<portlet:renderURL var="addDesigner">
	<portlet:param name="jspPage" value="/html/cloudtags/view.jsp"/>
</portlet:renderURL>


<portlet:actionURL var="uploadCSV">
	<portlet:param name="<%=ActionRequest.ACTION_NAME %>" value="uploadCSV"/>
</portlet:actionURL>

<portlet:actionURL var="generateProductionShortURL">
	<portlet:param name="<%=ActionRequest.ACTION_NAME %>" value="generateProductionShortURL"/>
</portlet:actionURL>

<portlet:actionURL var="updateDesignerActive">
	<portlet:param name="<%=ActionRequest.ACTION_NAME %>" value="updateDesignerActive"/>
</portlet:actionURL>

<%
	System.out.println("uploadCSV.toString()>>>>"+uploadCSV.toString());
    PortletURL editURL = renderResponse.createRenderURL();
	editURL.setParameter("CMD", "edit");
	editURL.setParameter("jspPage", "/html/cloudtags/edit.jsp");
	
	PortletURL deleteURL = renderResponse.createRenderURL();
	deleteURL.setParameter("CMD", "delete");
%>


<fieldset>
	<legend>Bulk upload of Product Feed</legend>

<aui:form name="fm1" id="fm1" method="POST"  action="<%=uploadCSV.toString() %>" enctype="multipart/form-data" inlineLabels="true">

	<aui:layout>
		<aui:column cssClass="aui-w50" first="true">
			<aui:input name="csvfile" type="file" label="Upload CSV" />
		</aui:column>
	
	
		<aui:column cssClass="aui-w50" first="true">
			<aui:input name="submit" type="submit"  value="Submit" />
		</aui:column>
	</aui:layout>
</aui:form>
<aui:form name="fm4" id="fm4" method="POST"  action="<%=generateProductionShortURL.toString() %>" inlineLabels="true">

	<aui:layout>
		
		<aui:column cssClass="aui-w50" first="true">
			<aui:input name="submit" type="submit"  value="Submit" />
		</aui:column>
	</aui:layout>
</aui:form>

<aui:form name="fm4" id="fm4" method="POST"  action="<%=updateDesignerActive.toString() %>" inlineLabels="true">

	<aui:layout>
		
		<aui:column cssClass="aui-w50" first="true">
			<aui:input name="submit" type="submit"  value="Submit" label="Update Designers"/>
		</aui:column>
	</aui:layout>
</aui:form>
</fieldset>

<fieldset>

<legend>Add New Product</legend>
	<aui:form name="newEntity" method="post" action="<%=addDesigner.toString()%>">
		<aui:layout>
			<aui:column columnWidth="35">
				<aui:input type="submit" name="searchButton" label="" value="New Entity" />
			</aui:column>
		</aui:layout>
	</aui:form>
</fieldset>

<%
	//Azam's code
	//List<Designers> items = DesignersLocalServiceUtil.getDesignerses(0, DesignersLocalServiceUtil.getDesignersesCount());
	List<Designers> items = DesignersLocalServiceUtil.getByCompanyId(themeDisplay.getCompanyId());
		PortletURL deleteProduct = renderResponse.createRenderURL();
		deleteProduct.setParameter("CMD","delete");
%>

<liferay-ui:search-container 
	delta="10" emptyResultsMessage="Sorry. There are no items to display.">

	<liferay-ui:search-container-results total="<%= items.size() %>"
		results="<%= ListUtil.subList(items, searchContainer.getStart(), searchContainer.getEnd()) %>" />

	<liferay-ui:search-container-row modelVar="item" className="com.cloud.tags.model.Designers">
		<liferay-ui:search-container-column-text name="Image">
			<%
			 String imageURL = "";
			   try{
				   imageURL = DesignersImagesLocalServiceUtil.getByDesignId(item.getDesignId()).getSmall_image_url();
				   
			   }catch(Exception e){}
			   
			   editURL.setParameter("designId", ""+item.getDesignId());
			   
			%>
			
			<img src="<%=imageURL %>" width="70" height="70" />
		</liferay-ui:search-container-column-text>
		<%
		String productURL = themeDisplay.getPortalURL() + "/designers?designId="+ item.getDesignId();
		String tinyURL = CommonUtil.getTiyURL(productURL, PortletProps.get("bitly.login.id"), PortletProps.get("bitly.login.key"));
		%>
		<liferay-ui:search-container-column-text name="Name" property="name"
			href="<%= editURL.toString() %>" />
		<liferay-ui:search-container-column-text name="Tag URL"  >
			<a href='<%=tinyURL %>' target="_blank" > <%=tinyURL %>  </a>			
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Direct URL" >
			<a href='<%=productURL %>' target="_blank" > <%=productURL %>  </a>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Delete" >
		
			<%
				deleteURL.setParameter("designId", ""+item.getDesignId());
			%>
			<aui:form method="POST" action="<%=deleteURL.toString() %>">
				<aui:input name="delete" value="Delete" type="submit" label =""/>
			</aui:form>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</liferay-ui:search-container>

