<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@ include file="/html/cloudtags/init.jsp"%>

<link href='http://fonts.googleapis.com/css?family=Kameron:400,700|Montserrat:400,700' rel='stylesheet' type='text/css'>


<portlet:resourceURL var="sendEmailURL">
	<portlet:param name="CMD" value="sendEmail"/>
</portlet:resourceURL>

<portlet:resourceURL var="staffShortlist">
	<portlet:param name="CMD" value="staffUsers"/>
</portlet:resourceURL>

<portlet:resourceURL var="endSessionURL">
	<portlet:param name="CMD" value="staffEndfromdocked"/>
</portlet:resourceURL>
<%
String emailAddress = StringPool.BLANK;
if(Validator.isNotNull(session.getAttribute("FIRST-EMAIL"))){
	emailAddress = session.getAttribute("FIRST-EMAIL").toString();
}

String undockedPage = "/undocked";
System.out.println(">>>>>>>>>>>>>>>>>>>>>?????????????????????????????????"+session.getAttribute("FROMTYPEUNDOC"));
if(Validator.isNotNull(session.getAttribute("FROMTYPEUNDOC"))){
	
	undockedPage = session.getAttribute("FROMTYPEUNDOC").toString();	
}
%>
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
<%--<div id="logo" style="position:absolute;top:10px;left:20px;width:250px;height:68px;background-image:url('<%=request.getContextPath()%>/images/made/madelogo.png');background-repeat:no-repeat;background-size:100% auto;"></div> --%>
<div style="position: relative; width: 250px; background-image: url('<%=request.getContextPath()%>/images/made/madelogo.png'); background-repeat: no-repeat; top: 23px; left: 22px; background-size: 100% auto; height: 68px;" id="logo"></div>
<%-- <div id="divider" style="position:absolute;left:0px;top:90px;width:600px;height:1px;background:#000000"></div>--%>
<div style="left: 0px; width: 600px; height: 1px; background: none repeat scroll 0% 0% rgb(0, 0, 0); position: relative; top: 34px;" id="divider"></div>
		
			    
<style>
<!--
.aui label{
display:none;
}
#load_email_error {
   color: #FF0000;
   font-size: 16px;
   height: 20px;
   line-height: 20px;
   margin-left: 200px;
   margin-top: 51px;
   width: 293px;
}
.aui input:focus:invalid:focus{
    border-color: #7B7B7B;
    box-shadow: 0 0 0 #FFFFFF;
}
.field .focus{
text-decoration:none ! important;
}
-->
</style>

<div class="emailsend_not_sent" id="toemail">
	<%--<div id="text1" class="maintext1" style="display: block;position:absolute;left:0px;top:100px;width:550px;height:80px;font-family:Kameron;font-size:40px;line-height:40px;text-align:center;color:#000000">Enter in your details<br> and we'll email your <br>curated list.</div> --%>
   <div style="height: 80px; font-family: Kameron; color: rgb(0, 0, 0); position: relative; top: 75px; line-height: 80px; left: 130px; font-size: 40px; width: 400px;" class="maintext1" id="text1">Enter in your details</div>
   <div style="height: 80px; font-family: Kameron; color: rgb(0, 0, 0); position: relative; top: 45px; line-height: 80px; left: 130px; font-size: 40px; width: 400px;" class="maintext2" id="text2">and we'll email your</div>
   <div style="height: 80px; font-family: Kameron; color: rgb(0, 0, 0); position: relative; top: 15px; line-height: 80px; left: 197px; font-size: 40px; width: 400px;" class="maintext3" id="text4">curated list.</div>
    
    <%-- <div id="text3" style="position:absolute;left:0px;top:100px;width:550px;height:80px;font-family:Kameron;font-size:40px;line-height:40px;text-align:center;color:#000000">
   
    	<p class="email-error" style="display: none;">Sorry, it looks like this email is invalid.</p>
		<p style="color:#000000;display:none;" class="email-success">Your list has been sent to <br> your email!</p>
	
    </div>--%>	
	<div class="for-reset">
	
	<%--<aui:input name="name" class="madelocal" style="text-decoration:none ! important;;font-family: Kameron; font-size: 25px; line-height: 30px; text-align: left; color: rgb(0, 0, 0); border-style: solid; border-color: rgb(123, 123, 123); border-width: 1px; border-radius: 4px;  padding: 20px; position: relative; top: 34px; left: 155px; width: 325px;" placeholder="Enter your Name"  value='<%= themeDisplay.isSignedIn() ? themeDisplay.getUser().getFullName() : "" %>' /> --%>
	<aui:input name="middleName" class="text" style="text-decoration:none ! important;font-family: Kameron; font-size: 25px; line-height: 30px; text-align: left; color: rgb(0, 0, 0); border-style: solid; border-color: rgb(123, 123, 123); border-width: 1px; border-radius: 4px;  padding: 20px; position: relative; top: 34px; left: 155px; width: 325px;" placeholder="Enter your Name"  value='<%= themeDisplay.isSignedIn() ? themeDisplay.getUser().getFullName() : "" %>'/>
	<span id="load_email_error" class="email-error" style="visibility: hidden;">Sorry, it looks like this email is invalid.</span>
	
	<aui:input  name="email" style="font-family: Kameron; font-size: 25px; line-height: 30px; text-align: left; color: rgb(0, 0, 0); border-style: solid; border-color: rgb(123, 123, 123); border-width: 1px; border-radius: 4px; padding: 20px; position: relative; width: 325px; left: 155px; top: 0px;text-decoration:none" required="true" placeholder="Enter your Email Address" type="email" value='<%= emailAddress%>' />	
	<%--<div id="text4" style="position:absolute;left:10px;top:210px;width:200px;height:45px;font-family:Kameron;font-size:45px;line-height:45px;text-align:left;color:#000000">Name</div> --%>
    <div style="font-family: Kameron; color: rgb(0, 0, 0); text-align: left; position: relative; font-size: 22px; left: 63px; width: 54px; top: -180px;" id="text4">Name</div>
    <%--<div id="text5" style="position:absolute;left:10px;top:310px;width:200px;height:45px;font-family:Kameron;font-size:45px;line-height:45px;text-align:left;color:#000000">Email</div> --%>
    <div style=" font-family: Kameron; text-align: left; color: rgb(0, 0, 0); position: relative; width: 54px; font-size: 22px; left: 63px; top: -134px;" id="text5">Email*</div>
    
    
    <%--<div id="emailsend" style="position: absolute; background: none repeat scroll 0% 0% rgb(255, 230, 0); color: rgb(255, 255, 255); font-family: Montserrat; text-align: center; border-radius: 12px; height: 100px; font-size: 50px; width: 350px; top: 430px; line-height: 100px; left: 100px;">SUBMIT</div> --%>
    <div id="emailsend" style="position: relative; background: none repeat scroll 0% 0% rgb(255, 230, 0); color: rgb(255, 255, 255); font-family: Montserrat; border-radius: 12px; height: 75px; font-size: 35px; line-height: 77px; left: 130px; width: 360px; text-align: center; top:-51px" id="emailsend">SUBMIT</div>
    </div>
    
    			<a href="#dialog-confirm" style="text-decoration:none" rel="facebox">
    <div class="reset" style="position: relative;display:none;text-decoration:none; background: none repeat scroll 0% 0% rgb(255, 230, 0); color: rgb(255, 255, 255); font-family: Montserrat; border-radius: 12px; height: 75px; font-size: 35px; line-height: 77px; left: 130px; width: 330px; text-align: center;top:200px">RESET</div>
    </a>
    	
	</div>	


<script>
function no_button() {
  // returns user to the staff shortlist.
	window.location = '/shortlist';
}


function removeFromSession(){
	show_loading();
	window.location = '<%=undockedPage%>?from=email-last';
}

</script>
<div id="dialog-confirm" title="Confirm?" style="text-align: center; width:500px ; height:350px;display:none">
<div id="text11" class="maintext11" style="height: 80px; font-family: Kameron; color: rgb(0, 0, 0); position: relative; top: 75px; line-height: 40px; font-size: 40px; width: 490px; left: 55px;">Your e-mail has been sent.</div>  
<div id="text22" class="maintext22" style="height: 80px; font-family: Kameron; color: rgb(0, 0, 0); position: relative; top: 45px; line-height: 40px; font-size: 40px; width: 490px; left: 55px;">Would you like to reset the</div>
<div id="text44" class="maintext33" style="height: 80px; font-family: Kameron; color: rgb(0, 0, 0); position: relative; top: 15px; line-height: 40px; font-size: 40px; width: 490px; left: 55px;">tablet?</div>

<div  style="position: relative; background: none repeat scroll 0% 0% grey; font-family: Montserrat; border-radius: 12px; height: 75px; font-size: 35px; line-height: 77px; width: 160px; text-align: center; top: 60px; left: 110px; color: rgb(255, 255, 255);" onclick="no_button();">No</div>
<div  style="position: relative; background: none repeat scroll 0% 0% rgb(255, 230, 0); color: rgb(255, 255, 255); font-family: Montserrat; border-radius: 12px; height: 75px; font-size: 35px; line-height: 77px; width: 160px; text-align: center; top: -15px; left: 330px;" onclick="removeFromSession();">Yes</div> 
    
</div>
<aui:script use="node">
	A.one('#emailsend').on('click', function(event) {

	 var email = document.getElementById("<portlet:namespace/>email").value;
	 var atpos=email.indexOf("@");
	var dotpos=email.lastIndexOf(".");
	var el_1 = A.one('.email-error');
	var el_2 = A.one('.maintext1');	
	var el_3 = A.one('.for-reset');
	var el_4 = A.one('.reset');	
	var el_5 = A.one('#<portlet:namespace/>email');
	var el_6 = A.one('.maintext2');
	var el_7 = A.one('.maintext3');
	var el_8 = A.one('#dialog-confirm');	
	

	 var emailExpression  =  /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

	if (!email.match(emailExpression))
	{
		if(el_1) {
			el_1.setStyle('visibility', 'visible'); 
			el_5.setStyle('border-color', '#FF0000'); 			
		}
	    return false;
	}

	el_1.setStyle('visibility', 'hidden');
	el_2.setStyle('display', 'none');
	el_3.setStyle('display', 'none');
	el_6.setStyle('display', 'none');
	el_7.setStyle('display', 'none');
	var url = '<%=sendEmailURL.toString() +"&email=" %>';
	url = url+email;
	var xhr = new XMLHttpRequest();
	xhr.open("POST",url, true);
	xhr.send();
	el_8.setStyle('display', 'block');
	
	
		
	
});


</aui:script>
<script type="text/javascript">
document.getElementById("<portlet:namespace />middleName").style.textDecoration='none';
setTimeout( function(){
	   hide_loading();
	 }, 2000 );
<!--

//-->
</script>
