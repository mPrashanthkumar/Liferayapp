<%@page import="com.cloud.tags.common.CommonUtil"%>
<%@page import="com.cloud.tags.service.ImpressionsLocalServiceUtil"%>
<%@page import="com.cloud.tags.model.Impressions" %>

<%@ include file="/html/cloudtags/init.jsp"%>

<link href="<%=request.getContextPath() %>/css/undocked.css?v=1" rel="stylesheet" type="text/css">

<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Kameron:400,700' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.11.2.min.js"></script>

<script>
function openInstructionPage(){
		
	$("#instruction").show();
	$("#new_main2").hide();
	
}
</script>

<portlet:resourceURL var="deviceMacAddress">
	<portlet:param name="CMD" value="MACADDRESS"/>
</portlet:resourceURL>
<portlet:resourceURL var="userLogin">
	<portlet:param name="CMD" value="UNDOCKED"/>
</portlet:resourceURL>
<portlet:resourceURL var="instructionPage">
	<portlet:param name="CMD" value="INSTRUCTION"/>
</portlet:resourceURL>
<portlet:resourceURL var="emailUserLogin">
	<portlet:param name="CMD" value="VALIDATEEMAIL"/>
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
String cssFromain = "Style='display:block;'";
String cssFroInstruction = "Style='display:none;'";
int instructions = 0;

if(Validator.isNotNull(originalRequest.getParameter("page"))){
	cssFromain = "Style='display:none;'";
	cssFroInstruction = "Style='display:block;'";
	instructions = 1;

}else{
	instructions = 0;
}

%>



<script>


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
		var url = "<%=userLogin+"&instructions="+instructions%>"+"&deviceName="+deviceName+"&deviceType="+deviceType+"&browserName="+browserName+"&screenWidth="+screenWidth;	
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
/*	
$.ajax({
    url: "http://127.0.0.1:8000/madetutorial.mp4",
    //dataType: "jsonp",
    success: function(data) {
       // console.log(data)
         // alert(data);
    },
    error: function(jqXHR, textStatus, errorThrown)
                    {
                        // Handle errors here
                        //alert('ERRORS: ' + textStatus);
						$("source").attr("src","https://ct-made-liferay-v2.s3.amazonaws.com/video/madetutorial12.mp4");
						$(".new_email video")[0].load();
                    }
});
*/
function displayScreen(){
    setTimeout(function() {
    $("#hide").hide(); },4000);
}
</script> 


<div id="new_main2" <%=cssFromain %>>

	<div class="new_symbol"><img src="<%=request.getContextPath() %>/images/made_symbol.jpg" alt="symbol"></div>
    	<div class="new_heading2">        	        
            Enter your email or<br/>
            touch any symbol with this<br/>
            device to get started.
        </div>
        
        	 <div class="new_email2" align="center">
        	 
        	 	           	    
           	    <div class="error_email" style="visibility:hidden">*Invalid Email ID</div>
                    
            <form>
            	<input id="email_field" type="email"  class="new_email_field" placeholder="     yourname@youremail.com" /><br/>
           		<input type="button" class="new_start" value="START" id="emailsend"/>
            </form> 

		</div>
</div>

<div class="cycle-slideshow" id="instruction" <%=cssFroInstruction %>>

 <div id="hide" style="position:absolute;left:0px;top:250px;width:585px;height:600px;z-index:2;background:#ffffff"></div>
 <div id="product_header">

	<div class="header_logo" id="header_logo"><img src="<%=request.getContextPath() %>/images/header_logo.jpg" alt="header_logo"></div>
    
</div>
<div id="new_main">

    	<div class="new_heading">
        	Touch the middle of this device<br/>
            to this symbol around the store.<br/>
            Build a list and share!
        </div>
        <div class="new_email" align="center">  
	         <video id="introduce-video-banner"  poster="<%=request.getContextPath() %>/images/poster.jpg" width="1200" height="1200" autoplay loop>
	    			<source src="http://127.0.0.1:8000/madetutorial.mp4" type='video/mp4' />
			 </video>
        </div>
        	 
</div><!--new_main-->

</div>





<!-- <img alt="" id="nextUnDocked" src="http://ct-made-liferay-qa.s3.amazonaws.com/instruction.jpg" style="width: 515px; height: 780px;margin-left:5%;display:none;" /> -->
 
<script>

$(document).ready(function() {
    $('input').keypress(function(e) {
        var code = (e.keyCode ? e.keyCode : e.which);        
        //if ( (code==13) || (code==10))
        if ( (code==13))
        {
        	saveEmail();
        	return false;
         }
    }
   );
});

	//$('#emailsend').on('click', function(event) {
		$('#emailsend').click( function(event) {
		saveEmail();
	<%--  var email = document.getElementById("email_field").value;
	 var atpos=email.indexOf("@");
	var dotpos=email.lastIndexOf(".");
	var el_1 = $('.error_email');
	var el_2 = $('#instruction');
	var el_5 = $('#email_field');
	var el_4 = $('#new_main2');
	
	

	 var emailExpression  =  /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

	if (!email.match(emailExpression))
	{
		//alert('Invalid Email');
			el_1.css('visibility', 'visible'); 
			el_5.css('border', '1px solid red !important'); 			
	
	    return false;
	}

	el_1.css('visibility', 'hidden');	
	displayScreen();
	el_2.css('display', 'block');
	el_4.css('display', 'none');
	var url = '<%=emailUserLogin.toString() +"&email=" %>';
	url = url+email;
	var xhr = new XMLHttpRequest();
	xhr.open("POST",url, true);
	xhr.send();
	xhr.onreadystatechange = function(e) {
				if (xhr.readyState == 4) {
					if(xhr.status == 200){
						el_1.css('visibility', 'hidden'); 						
						el_5.css('border', '1px solid black !important');
						
						
						var url1 = '<%=instructionPage.toString()%>';						
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
				}
			};		
	  --%>
});

	function saveEmail(){
		 var email = document.getElementById("email_field").value;
		 var atpos=email.indexOf("@");
		var dotpos=email.lastIndexOf(".");
		var el_1 = $('.error_email');
		var el_2 = $('#instruction');
		var el_5 = $('#email_field');
		var el_4 = $('#new_main2');
		
		

		 var emailExpression  =  /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

		if (!email.match(emailExpression))
		{
			//alert('Invalid Email');
				el_1.css('visibility', 'visible'); 
				el_5.css('border', '1px solid red !important'); 			
		
		    return false;
		}

		el_1.css('visibility', 'hidden');	
		displayScreen();
		el_2.css('display', 'block');
		el_4.css('display', 'none');
		var url = '<%=emailUserLogin.toString() +"&email=" %>';
		url = url+email;
		var xhr = new XMLHttpRequest();
		xhr.open("POST",url, true);
		xhr.send();
		xhr.onreadystatechange = function(e) {
					if (xhr.readyState == 4) {
						if(xhr.status == 200){
							el_1.css('visibility', 'hidden'); 						
							el_5.css('border', '1px solid black !important');
							
							
							var url1 = '<%=instructionPage.toString()%>';						
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
					}
				};	
		
	}
 /*$(function() {
    $( document ).ready(function() {
        setTimeout(function() {
        $("#hide").hide(); },2000);
    });
 });*/
 

</script>

<script type="text/javascript">
var insPage = '<%=instructions%>';
if(insPage == 1){
displayScreen();
}

if(<%=isProduction%> == true){
	 (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
		  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
		  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
		  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

		  ga('create', 'UA-36111687-3', 'auto');
		  ga('send', 'pageview');

}/*  else{
	alert('false');	
}  */



</script>

