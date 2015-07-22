<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/portal/init.jsp" %>

<portlet:defineObjects />

<style>

.mainerrordiv {
	background-color: white;
	color: #333333;
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 36px;
	line-height: 18px;
	font-size: 14px;
  }
.section {
	margin-bottom: 36px;
	color: #222222;
  }
.section h1 {
    font-size: 26px;
    background-color: #dad8e4;
    padding: 18px 22px 15px 22px;
    margin: 0;
    overflow: hidden;
  }
.article {
    border: 4px solid #dad8e4;
    padding: 24px 18px 18px 18px;
    font-size: 14px;
  }
  
</style>

<%
String portletTitle = HtmlUtil.escape(PortalUtil.getPortletTitle(renderResponse));

if (portletTitle == null) {
	portletTitle = LanguageUtil.get(pageContext, "portlet");
}
%>

<div class="mainerrordiv">
	<div class="section">
	    <h1>Error</h1>
	    <div class="article"> 
	      <p>An error occurred in the application and your page could not be served.</p>
	      <a href="/docked">Click Here to Return</a>
	    </div> 
    </div>
</div>

