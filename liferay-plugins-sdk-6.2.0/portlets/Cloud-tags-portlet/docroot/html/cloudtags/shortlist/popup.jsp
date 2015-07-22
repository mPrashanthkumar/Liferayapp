<%@ include file="/html/cloudtags/init.jsp"%>


<portlet:actionURL var="deleteCart">
</portlet:actionURL>


<aui:form name="fm1" id="fm1" method="POST"  action="<%=deleteCart.toString() %>" inlineLabels="true" >

		<aui:layout>
			<aui:column >
				Are you sure you want to delete ?<br/>
				<aui:input name="submit" type="button"  value="No" label="" onclick="enddialog()" />
				<aui:input name="submit" type="submit"  value="Yes" label="" />
			</aui:column>
			</aui:layout>
		
</aui:form>
