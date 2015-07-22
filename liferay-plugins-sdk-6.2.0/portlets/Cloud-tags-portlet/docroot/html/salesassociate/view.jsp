<%@page import="com.cloud.tags.service.ImpressionsLocalServiceUtil"%>
<%@page import="com.cloud.tags.model.Impressions"%>
<%@page import="com.cloud.tags.common.CommonUtil"%>
<%@page import="com.cloud.tags.common.ImpressionTypes"%>
<%@ include file="/html/cloudtags/init.jsp"%>


<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Kameron:400,700' rel='stylesheet' type='text/css'>


<portlet:defineObjects />
<%
	String fronAssociate = StringPool.BLANK;
	String undockedPage = "/undocked";
	if (Validator.isNotNull(session.getAttribute("FROMTYPEUNDOC"))) {

		undockedPage = session.getAttribute("FROMTYPEUNDOC").toString();
	}

	if (Validator.isNotNull(session.getAttribute("HISTORY-PATH"))) {
		if (session.getAttribute("HISTORY-PATH").toString()
				.contains(undockedPage)
				&& !session.getAttribute("HISTORY-PATH").toString()
						.contains("=email-last")
				&& !session.getAttribute("HISTORY-PATH").toString()
						.contains("=associate-page")) {
			fronAssociate = session.getAttribute("HISTORY-PATH")
					.toString() + "?from=associate-page";
		} else if (session.getAttribute("HISTORY-PATH").toString()
				.contains("=email-last")) {
			fronAssociate = session.getAttribute("HISTORY-PATH")
					.toString()
					.replace("=email-last", "=associate-page");
		} else {
			fronAssociate = session.getAttribute("HISTORY-PATH")
					.toString();
		}
	} else if (Validator.isNull(fronAssociate)) {
		if(undockedPage.contains("?")){
			fronAssociate = undockedPage + "&from=associate-page";
		}else{
			fronAssociate = undockedPage + "?from=associate-page";
		}
		
	}
	fronAssociate = fronAssociate.replace("tion?from", "tion&from");
	
%>

<script>
  function yes_button() {
	 
    window.location = '<%=fronAssociate %>';
  }
  
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
<div id="yui_patched_v3_11_0_1_1401874580638_294"
	style="background: none repeat scroll 0px 0px rgb(255, 255, 255); position: relative;height:800px;width:600px">
	<div
		style="top: 0px; left: -8px; padding-top: 120px; position: relative; color:#333;"
		id="yui_patched_v3_11_0_1_1401874580638_306">
		<p
			style="text-transform: uppercase; text-align: center; font-weight: 600; font-family: 'Montserrat', sans-serif; font-size: 46px;">
			STAFF LOGIN</p>
	</div>
	<div style="left: -8px; position: relative; top: 0px; margin-top: 51px;"
		id="">
		<p
			style="text-transform: uppercase; text-align: center; font-weight: 400; font-family: 'Montserrat', sans-serif; font-size: 35px;">
			<%=httpServletRequest.getSession().getAttribute("LOGINSTAFF").toString()%></p>
	</div>
	<!-- <div id="header" style="position:absolute; top:0px; left:0px; width:1000px; height:340px;"> <p style="padding-top:105px; font-size:35px; text-align: center; "> is not logged in for this </p> </div> <div id="header" style="position:absolute; top:0px; left:0px; width:1000px; height:340px;"> <p style="padding-top:135px; font-size:35px; text-align: center; "> session </p> </div> -->
	<div style="top: -21px; left: -8px; position: relative;" id="">
		<p
			style="color: rgb(180, 180, 180); text-align: center; font-weight: 400; font-family: 'Kameron', serif; font-size: 35px; margin-top: 63px;">
			is now logged in for this</p>
	</div>
	<div style="top: -105px; left: -8px; position: relative;" id="">
		<p
			style="color: rgb(180, 180, 180); text-align: center; font-weight: 400; font-family: 'Kameron', serif; font-size: 38px; margin-top: 88px;">
			session.</p>
	</div>
	<div onclick="yes_button();"
		style="top: -107px; left: -8px; position: relative;" id="">
		<p
			style="text-align: center; font-size: 62px; font-weight: 400; font-family: 'Kameron', serif;">
		</p>
		<div style="background: none repeat scroll 0% 0% rgb(255, 230, 0); border-radius: 8px; color: rgb(255, 255, 255); font-family: 'Kameron', serif; position: absolute; text-align: center; width: auto; font-weight: normal; font-size: 40px; line-height: 30px; height: auto; padding: 25px; margin-left: 195px;" class="recommendation-types"  id="tab1">DISMISS</div>
		<p></p>
	</div>
</div>

<%
	String deviceName = StringPool.BLANK;
	String deviceType = StringPool.BLANK;
	String browserName = StringPool.BLANK;
	String deviceWidth = StringPool.BLANK;

	if (Validator.isNotNull(session.getAttribute("deviceName"))) {
		deviceName = session.getAttribute("deviceName").toString();
	}
	if (Validator.isNotNull(session.getAttribute("deviceType"))) {
		deviceType = session.getAttribute("deviceType").toString();
	}
	if (Validator.isNotNull(session.getAttribute("browserName"))) {
		browserName = session.getAttribute("browserName").toString();
	}
	if (Validator.isNotNull(session.getAttribute("deviceWidth"))) {
		deviceWidth = session.getAttribute("deviceWidth").toString();

	}
	String staffName = "";
	if (Validator.isNotNull(session.getAttribute("LOGINSTAFF")
			.toString())) {
		staffName = session.getAttribute("LOGINSTAFF").toString();
	}
	long storeId = CommonUtil.getStoreIdForDevice(session);
	try {
		Impressions impressions = ImpressionsLocalServiceUtil
				.addToImpressions(ImpressionTypes.STAFFPAGE.getValue(), staffName, "LOGIN",
						loginUserId,
						Long.toString(themeDisplay.getCompanyId()),
						originalRequest.getRemoteAddr(), deviceName,
						deviceType, deviceWidth, browserName, storeId);

		if (Validator.isNotNull(session.getAttribute("LOGINSTAFF"))
				&& impressions != null) {
			impressions.setStaffId(session.getAttribute("LOGINSTAFF")
					.toString());
			ImpressionsLocalServiceUtil.updateImpressions(impressions);
		}
	} catch (Exception e) {

	}
%>