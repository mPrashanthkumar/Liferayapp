<%@page import="com.cloud.tags.common.CommonUtil"%>
<%@page import="com.cloud.tags.service.ImpressionsLocalServiceUtil"%>
<%@page import="com.cloud.tags.model.Impressions" %>

<%@ include file="/html/cloudtags/init.jsp"%>

<portlet:resourceURL var="deviceMacAddress">
	<portlet:param name="CMD" value="MACADDRESS"/>
</portlet:resourceURL>
<portlet:resourceURL var="userLogin">
	<portlet:param name="CMD" value="UNDOCKED"/>
</portlet:resourceURL>

<%
session.setAttribute("FROMTYPEUNDOC", "/undocked");
if(Validator.isNotNull(originalRequest.getParameter("from"))){
	session.setAttribute("DONTCLEARSESSION", "associate-page");	
}
if(Validator.isNotNull(originalRequest.getParameter("from"))){
	if(originalRequest.getParameter("from").contains("email-last")){
		session.removeAttribute("FIRST-EMAIL");
		session.setAttribute("CLEARSESSION-LAST", "TRUE");
		
	}
}


%>


<script>

function clearSession(){
	var url = '/i-m-ready?p_p_id=emailnotification_WAR_Cloudtagsportlet&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_cacheability=cacheLevelPage&p_p_col_id=column-1&p_p_col_count=1&_emailnotification_WAR_Cloudtagsportlet_CMD=undocked';	
	var xhr = new XMLHttpRequest();
	xhr.open("POST",url, true);
	xhr.send();
	
	xhr.onreadystatechange = function(e) {
		if (xhr.readyState == 4) {
			if(xhr.status == 200){
				//alert('success');
			}
		}
	};
  }
 clearSession();

	function getMacAddress(){
		//alert(document.getElementById('macAddress1'));
		var script   = document.createElement("script");
		  script.type  = "text/javascript";
		  script.src   = 'http://127.0.0.1:8080/wifi';
		  document.body.appendChild(script);		 
	}
	getMacAddress();


	function ctDeviceCallback(data) {
		 /*  if (data['status'] == 'docked') {
		    //window.location = '/docked';
		  } */
		  
		  if(data['wifi_mac'] != null){
			  devAddress = data['wifi_mac'];
			  //alert(macAddress);
			  	//document.getElementById('MacAddress').innerHTML = macAddress
			 	//undockedImpressions(macAddress);		  	 
			  	updateSessionWithMacAddress(devAddress);
			 // alert("2");
			  
		  }
	}
	
	function updateSessionWithMacAddress(devAddress){
		var url = "<%=deviceMacAddress%>"+"&macAddress="+devAddress;	
		var xhr = new XMLHttpRequest();
		xhr.open("GET",url, true);
		xhr.send();
		
		xhr.onreadystatechange = function(e) {
			if (xhr.readyState == 4) {
				if(xhr.status == 200){
					//alert('success');
					
				}
			}
		};
	}
	
	function undockedImpressions(){
		//alert("3");
		//getMacAddress();	
		//alert(macAddress1);
		var deviceName = WURFL.complete_device_name;
		var deviceType = WURFL.form_factor;

		var nVer = navigator.appVersion;
		var nAgt = navigator.userAgent;
		var browserName  = navigator.appName;
		var fullVersion  = ''+parseFloat(navigator.appVersion); 
		var majorVersion = parseInt(navigator.appVersion,10);
		var nameOffset,verOffset,ix;

		 //alert(macAddress);
		// In Opera, the true version is after "Opera" or after "Version"
		if ((verOffset=nAgt.indexOf("Opera"))!=-1) {
		 browserName = "Opera";
		 fullVersion = nAgt.substring(verOffset+6);
		 if ((verOffset=nAgt.indexOf("Version"))!=-1) 
		   fullVersion = nAgt.substring(verOffset+8);
		}
		// In MSIE, the true version is after "MSIE" in userAgent
		else if ((verOffset=nAgt.indexOf("MSIE"))!=-1) {
		 browserName = "Microsoft Internet Explorer";
		 fullVersion = nAgt.substring(verOffset+5);
		}
		// In Chrome, the true version is after "Chrome" 
		else if ((verOffset=nAgt.indexOf("Chrome"))!=-1) {
		 browserName = "Chrome";
		 fullVersion = nAgt.substring(verOffset+7);
		}
		// In Safari, the true version is after "Safari" or after "Version" 
		else if ((verOffset=nAgt.indexOf("Safari"))!=-1) {
		 browserName = "Safari";
		 fullVersion = nAgt.substring(verOffset+7);
		 if ((verOffset=nAgt.indexOf("Version"))!=-1) 
		   fullVersion = nAgt.substring(verOffset+8);
		}
		// In Firefox, the true version is after "Firefox" 
		else if ((verOffset=nAgt.indexOf("Firefox"))!=-1) {
		 browserName = "Firefox";
		 fullVersion = nAgt.substring(verOffset+8);
		}
		// In most other browsers, "name/version" is at the end of userAgent 
		else if ( (nameOffset=nAgt.lastIndexOf(' ')+1) < 
		          (verOffset=nAgt.lastIndexOf('/')) ) 
		{
		 browserName = nAgt.substring(nameOffset,verOffset);
		 fullVersion = nAgt.substring(verOffset+1);
		 if (browserName.toLowerCase()==browserName.toUpperCase()) {
		  browserName = navigator.appName;
		 }
		}
		// trim the fullVersion string at semicolon/space if present
		if ((ix=fullVersion.indexOf(";"))!=-1)
		   fullVersion=fullVersion.substring(0,ix);
		if ((ix=fullVersion.indexOf(" "))!=-1)
		   fullVersion=fullVersion.substring(0,ix);

		majorVersion = parseInt(''+fullVersion,10);
		if (isNaN(majorVersion)) {
		 fullVersion  = ''+parseFloat(navigator.appVersion); 
		 majorVersion = parseInt(navigator.appVersion,10);
		}

		 var swidth = screen.width;
		        var wiwidth = window.innerWidth;
		        var cwidth = document.getElementsByTagName("body")[0].clientWidth;
		var ua = navigator.userAgent,
		browser = {
		    iPad: /iPad/.test(ua),
		    iPhone: /iPhone/.test(ua),
		    Android4: /Android 4/.test(ua)
		};

		var browserName= browserName+''+majorVersion;
		var screenWidth= screen.width;
		//alert("in"+macAddress);
		var url = "<%=userLogin%>"+"&deviceName="+deviceName+"&deviceType="+deviceType+"&browserName="+browserName+"&screenWidth="+screenWidth;	
		//alert(url);
		

		var xhr = new XMLHttpRequest();
		xhr.open("GET",url, true);
		xhr.send();
		
		xhr.onreadystatechange = function(e) {
			if (xhr.readyState == 4) {
				if(xhr.status == 200){
					//alert('success');
				}
			}
		};
	  }

	undockedImpressions();
</script>

<img alt="" id="nextUnDocked" src="http://ct-made-liferay-qa.s3.amazonaws.com/undocked.png" style="width: 550px; height: 780px;" />
