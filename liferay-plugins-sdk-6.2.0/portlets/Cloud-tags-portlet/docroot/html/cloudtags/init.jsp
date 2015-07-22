<%@page import="com.cloud.tags.common.ImpressionTypes"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@page import="javax.portlet.PortletSession" %>
<%@page import="javax.portlet.RenderResponse"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="javax.portlet.ResourceURL"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="javax.portlet.PortletPreferences"%>

<%@page import="java.util.List"%>
<%@page import="com.cloud.tags.service.DesignersLocalServiceUtil"%>
<%@page import="com.cloud.tags.service.DesignersImagesLocalServiceUtil"%>

<%@page import="com.cloud.tags.model.Designers"%>
<%@page import="com.cloud.tags.model.DesignersImages"%>

<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<style>
<!--
#loadingmade {
			background:rgba(255,255,255,0.8);
			position: fixed;
			width:100%;
			height:100%;
			z-index:2000;
			text-align: center;
			padding-top: 250px;
			font-size: 2em;
			top:0px;
			display:none;
			}

		
#addedlike {
			background:rgba(255,255,255,0.8);
			position: fixed;
			width:100%;
			height:100%;
			z-index:2000;
			text-align: center;
			padding-top: 250px;
			font-size: 2em;
			top:0px;
			display:none;
			}
			
#removelist {
			background:rgba(255,255,255,0.8);
			position: fixed;
			width:100%;
			height:100%;
			z-index:2000;
			text-align: center;
			padding-top: 250px;
			font-size: 2em;
			top:0px;
			display:none;
			}
-->
</style>
<script src="<%=request.getContextPath() %>/js/jquery-1.10.1.min.js"></script>

<%
HttpServletRequest httpServletRequest =  PortalUtil.getHttpServletRequest(renderRequest);
HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(httpRequest);

boolean isProduction = false;

String serverName =  "";
try{
serverName =  originalRequest.getServerName();
System.out.println("server name >>>>>>> :   "+serverName);
}catch(Exception e){
	
}
if(serverName.equalsIgnoreCase("made.cloudtags.com"))
	isProduction= true;

String loginUserId = StringPool.BLANK;
if(Validator.isNotNull(session.getAttribute("LOGIN-USER"))){
	System.out.println("LOGIN-USER inside recommendations if");
	loginUserId = session.getAttribute("LOGIN-USER").toString();							
}
session.setAttribute(ImpressionTypes.IPADDRESS.toString(), originalRequest.getRemoteAddr());
String compId = Long.toString(themeDisplay.getCompanyId());
String remoteIpAddess= originalRequest.getRemoteAddr();

String completePathURL = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
if(!completePathURL.contains("/associate?")){	
System.out.println("Path>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+completePathURL);
session.setAttribute("HISTORY-PATH", completePathURL);
}

%>

<script>

function hide_loading() {
 $('#loading').hide();
 }
 // Is used
function show_loading() {
	// alert("1");
$('#loading').css('display','block');
$('#loading').css('z-index','10000');
$('#loading').fadeIn('fast');

}
</script>


<!--<aui:script>
function loadingmask(id){
	
	AUI().use( 'aui-loading-mask', function(A){
		
			if (A.one(id).loadingmask == null)
				A.one(id).plug(A.LoadingMask, { background: '#ffffff' });
			A.one(id).loadingmask.toggle();
		});
}


</aui:script>-->
	

