<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@ include file="/html/cloudtags/init.jsp"%>

<portlet:resourceURL var="sendEmailURL">
	<portlet:param name="CMD" value="sendEmail"/>
</portlet:resourceURL>

<portlet:resourceURL var="staffShortlist">
	<portlet:param name="CMD" value="staffUsers"/>
</portlet:resourceURL>



<div class="emailsend_not_sent" id="toemail">
	<div class="now-view email-details">
		<img src="https://s3.amazonaws.com/ct-hn/person.png" />
		<p>
			Time to find the perfect match!<br /> Hand this tablet to a Style
			Advisor
		</p>

		<p>
			They will bring your shortlist to the<br /> fitting room in the
			correct sizes
		</p>
		<img src="https://s3.amazonaws.com/ct-hn/heart.png" />
	</div>

	<div id="email-input-box">
		<p class="email-error" style="display: none;">Sorry, it looks like
			this email is invalid.</p>
		<p style="color:#fff;display:none;" class="email-success">Your list has been sent to <br> your email!</p>
				
			<aui:input name="email" required="true" placeholder="Your email address"  value='<%= themeDisplay.isSignedIn() ? themeDisplay.getUser().getEmailAddress() : "" %>' />	
		<p id="emailsend_shortlist">
			Send yourself this shortlist to look over<br /> when you get home
		</p>
		<img id="emailsend"
			src="https://s3.amazonaws.com/ct-hn/sendshortlist.png" /><br /> <br />
		<br /> <br />
		
		
		<aui:select name="styleAdvisor" label="Select the style Advisor">
				
				<%
					try{
				
					Role role  = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "Staff Users");
				
					List<User> users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
					
					for(User staff : users) {
				%>
					<aui:option value="<%=staff.getUserId() %>"><%=staff.getFullName() %></aui:option>
				
				<%		}
					}
					catch(Exception e) {} 
				%>
		</aui:select>
		
		<a href="#" id="associate"><img
			id="associate"
			src="https://s3.amazonaws.com/ct-hn/staff-shortlist.png"
			title="staff_shortlist" /> </a><br /> <br /> <br /> &nbsp;
	</div>
	&nbsp;

	<div class="later-view" style="display: none;">&nbsp;</div>
</div>


<aui:script use="node">
	A.one('#emailsend').on('click', function(event) {

	 var email = document.getElementById("<portlet:namespace/>email").value;
	 var atpos=email.indexOf("@");
	var dotpos=email.lastIndexOf(".");
	var el_1 = A.one('.email-error');
	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=email.length)
	{
		if(el_1) {
			el_1.setStyle('display', 'block'); 
		}
	    return false;
	}

	el_1.setStyle('display', 'none');
	var url = '<%=sendEmailURL.toString() +"&email=" %>';
	url = url+email;
	var xhr = new XMLHttpRequest();
	xhr.open("POST",url, true);
	xhr.send();
	var sucessEmail = A.one('.email-success');
	sucessEmail.setStyle('display', 'block'); 
	
	
});


A.one('#associate').on('click',function(event) {

		loadingmask("#toemail");
	
	var staffusers = document.getElementById("<portlet:namespace/>styleAdvisor").value;
	
	var url = '<%=staffShortlist.toString() +"&staffusers="  %>' +staffusers;
	var xhr = new XMLHttpRequest();
	xhr.open("POST",url, true);
	
	xhr.send();
	
	
		xhr.onreadystatechange = function(e) {
				if (xhr.readyState == 4) {
					if(xhr.status == 200){
						location.href="/shortlist?staffShortList=true";
					}
				}
			}
	
	
});

</aui:script>
