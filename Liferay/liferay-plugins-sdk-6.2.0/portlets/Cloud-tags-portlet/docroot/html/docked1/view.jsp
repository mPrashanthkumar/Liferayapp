<%@page import="com.cloud.tags.common.CommonUtil"%>
<%@page import="com.cloud.tags.service.ImpressionsLocalServiceUtil"%>
<%@page import="com.cloud.tags.model.Impressions" %>

<%@ include file="/html/cloudtags/init.jsp"%>
<%
session.setAttribute("FROMTYPE", "DOCKED");
%>
<%-- <%
	String deviceName = StringPool.BLANK;
	String deviceType = StringPool.BLANK;
	String browserName = StringPool.BLANK;
	String deviceWidth = StringPool.BLANK;
	
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
	String loginUser = session.getAttribute("LOGIN-USER").toString();
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
%> --%>

<script language="JavaScript">
  if(window.location.search.indexOf("return_to")>0)
    window.location.href=window.location.search.substring(window.location.search.indexOf("return_to")+10);
    </script><script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
    </script><script type="text/javascript">
    function ctDeviceCallback(data)
    {
      if (data['status'] == 'undocked')
        {
          window.location = '/newundocked';
        }
      };
	  function clearSession(){
		var url = '/i-m-ready?p_p_id=emailnotification_WAR_Cloudtagsportlet&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_cacheability=cacheLevelPage&p_p_col_id=column-1&p_p_col_count=1&_emailnotification_WAR_Cloudtagsportlet_CMD=staffEndfromdocked&fromType=DOCKED';	
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
<div id="back" style="position:fixed;top:0px;left:0px;width:600px;height:912px;background:#ffffff">&nbsp;</div>

<div id="logo" style="position: absolute; top: 350px; left: 200px; width: 200px; height: 200px; background-image: url('http://ct-made-liferay-qa.s3.amazonaws.com/madehomelogo.png');background-size:100% 100%">&nbsp;</div>

<div id="undocked-instruction" style="width: 520px; height: 780px; background-image: url('http://ct-made-liferay-qa.s3.amazonaws.com/undocked.png');background-size:100% 100%"></div>


<script type="text/javascript">
	$(document).ready(function() {
    
    $("#undocked-instruction").hide();

    $("body").on("click", function() {
    	 	$("#logo").hide();
    	 	$("#back").hide();
            $("#undocked-instruction").show();
            setTimeout(function() {
                hide();
            }, 5000); // 5 seconds delay

        function hide() {
           $("#undocked-instruction").hide();
   	 		$("#logo").show();
   	 		$("#back").show();

        }


    });

});
</script>

