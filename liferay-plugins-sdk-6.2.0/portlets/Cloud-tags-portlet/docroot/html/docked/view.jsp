<%@ include file="/html/cloudtags/init.jsp"%>
<%@page import="com.cloud.tags.common.ImpressionTypes"%>
<%@page import="com.cloud.tags.common.CommonUtil"%>
<%@page import="com.cloud.tags.service.ImpressionsLocalServiceUtil"%>
<%@page import="com.cloud.tags.model.Impressions" %>

<link href="<%=request.getContextPath()%>/css/made-common.css" rel="stylesheet" type="text/css">
<%
session.setAttribute("FROMTYPE", ImpressionTypes.DOCKED.getValue());
String impress = ImpressionTypes.DOCKED.getValue();
%>
<script>
function clearSession(){
	var impression = '<%=impress%>';
		var url = '/i-m-ready?p_p_id=emailnotification_WAR_Cloudtagsportlet&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_cacheability=cacheLevelPage&p_p_col_id=column-1&p_p_col_count=1&_emailnotification_WAR_Cloudtagsportlet_CMD=staffEndfromdocked&fromType=' + impression;	
		var xhr = new XMLHttpRequest();
		xhr.open("POST",url, true);
		xhr.send();
		
		xhr.onreadystatechange = function(e) {
			if (xhr.readyState == 4) {
				if(xhr.status == 200){
					
				}
			}
		};
	  }
	  
</script>
<%
try{
	String firstEmail = StringPool.BLANK;
	System.out.println(">>>>"+loginUserId);
if(Validator.isNotNull(session.getAttribute("FIRST-EMAIL"))) {
	firstEmail =  session.getAttribute("FIRST-EMAIL").toString();
	}
List<Impressions> sendEmailCheck = ImpressionsLocalServiceUtil.getByImpressionTypeAction("EMAIL-NOTIFICATION", "SENDMAIL", loginUserId, Long.toString(themeDisplay.getCompanyId()));

List<Impressions> sendEmailCheck1 = ImpressionsLocalServiceUtil.getByImpressionTypeAction(ImpressionTypes.EMAIL_NOTIFICATION.toString(), ImpressionTypes.SEND_MAIL.toString(), loginUserId, Long.toString(themeDisplay.getCompanyId()));
System.out.println("sendEmailCheck1.size()>>>"+sendEmailCheck1.size());
System.out.println("sendEmailCheck.size()>>>"+sendEmailCheck.size());
System.out.println("firstEmail>>>"+firstEmail);
if(sendEmailCheck.size() == 0 && Validator.isNotNull(firstEmail)){
	%>
	<script>
		var url = '/designers?p_p_id=recommendation_WAR_Cloudtagsportlet&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_cacheability=cacheLevelPage&p_p_col_id=column-1&p_p_col_count=1&_recommendation_WAR_Cloudtagsportlet_CMD=sendEmail&email=';
		url = url+'<%=firstEmail%>';
		//alert(url);
		var xhr = new XMLHttpRequest();
		xhr.open("POST",url, true);
		xhr.send();
		xhr.onreadystatechange = function(e) {
			if (xhr.readyState == 4) {
				if(xhr.status == 200){
					clearSession();
				}
			}
		};
	</script>
	<%
}else{
	%>
	<script>
	clearSession();
	</script>
	<%
}
System.out.println(sendEmailCheck.size()+firstEmail);
}catch(Exception e){
}
%>


 <%
	String deviceName = StringPool.BLANK;
	String deviceType = StringPool.BLANK;
	String browserName = StringPool.BLANK;
	String deviceWidth = StringPool.BLANK;
	String loginUser = StringPool.BLANK;
	
	if(Validator.isNotNull(session.getAttribute("deviceName"))){
		deviceName = session.getAttribute("deviceName").toString();
	}
	if(Validator.isNotNull(session.getAttribute("deviceType"))){
		deviceType = session.getAttribute("deviceType").toString();
	}
	if(Validator.isNotNull(session.getAttribute("browserName"))){
		browserName = session.getAttribute("browserName").toString();
	}
	if(Validator.isNotNull(session.getAttribute("deviceWidth"))){
		deviceWidth = session.getAttribute("deviceWidth").toString();
	}
	if(Validator.isNotNull(session.getAttribute("LOGIN-USER"))){
	loginUser = session.getAttribute("LOGIN-USER").toString();
	}
	long storeId = CommonUtil.getStoreIdForDevice(session);
	try{
		Impressions impressions = ImpressionsLocalServiceUtil.addToImpressions("DOCKED", loginUser, "DOCKED",
				loginUser , Long.toString(themeDisplay.getCompanyId()), 
				PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr(),
				deviceName,deviceType,deviceWidth,browserName, storeId);

		if(Validator.isNotNull(session.getAttribute("LOGINSTAFF")) && impressions != null){
			impressions.setStaffId(session.getAttribute("LOGINSTAFF").toString());
			ImpressionsLocalServiceUtil.updateImpressions(impressions);
		}
	}catch(Exception e){
	
	}
%> 

<script language="JavaScript">
  if(window.location.search.indexOf("return_to")>0)
    window.location.href=window.location.search.substring(window.location.search.indexOf("return_to")+10);
    </script><script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
    </script><script type="text/javascript">
    function ctDeviceCallback(data)
    {
      if (data['status'] == 'undocked')
        {
          window.location = '/undocked';
        }
      };
	  
      function check_dock() {
        var randomNum = Math.ceil(Math.random() * 999999);
        var script   = document.createElement("script");
        script.type  = "text/javascript";
        script.src   = 'http://127.0.0.1:8080/status?' + randomNum;
        document.body.appendChild(script);
        setTimeout(function(){check_dock();},4000);
      }

      //check_dock();
      </script>
 
 <div class="cycle-slideshow">
    <div id="front-image"></div>
</div>
 
