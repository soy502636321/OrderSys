<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-tags.tld" prefix="s"%>
<jsp:directive.page import="order.hq.util.DateUtil"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	color: #43860c;
	font-size: 12px;
}
-->
</style>

  </head>
  
<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed;">
		<tr>
    		<td height="9" style="line-height:9px; background-image:url(images/main_04.gif)">
				<table width="97" height="9" border="0" cellspacing="0" cellpadding="0" background="images/main_01.gif"></table>
   	 		</td>
  		</tr>
	  	<tr>
	    	<td height="47" background="images/main_09.gif">
	    		<table width="100%" border="0" cellspacing="0" cellpadding="0">
	      			<tr>
	        			<td width="38" height="47" background="images/main_06.gif">&nbsp;</td>
	        			<td width="59">
	        				<table width="100%" border="0" cellspacing="0" cellpadding="0">
				          		<tr>
				            		<td height="29" background="images/main_07.gif">&nbsp;</td>
				          		</tr>
				          		<tr>
				            		<td height="18" background="images/main_14.gif">
				            			<table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed;">
				              				<tr>
				                				<td style="width:1px;">&nbsp;</td>
				               			 		<td ><span class="STYLE1">${userName}</span></td>
				              				</tr>
				            			</table>
				            		</td>
				          		</tr>
				        	</table>
	        			</td>
				        <td width="155" background="images/main_08.gif">&nbsp;</td>
				        <td>
				        	<table width="100%" border="0" cellspacing="0" cellpadding="0">
				          		<tr>
				            		<td height="23" valign="bottom">
				            			<img src="images/main_12_2.gif" width="162" height="22" border="0" usemap="#Map" />
				            		</td>
				          		</tr>
				        	</table>
				        </td>
				        <td width="200" background="images/main_11.gif">
				        	<table width="100%" border="0" cellspacing="0" cellpadding="0">
				          		<tr>
				            		<td width="11%" height="23">&nbsp;</td>
				            		<td width="89%" valign="bottom"><span class="STYLE1">日期：<%=DateUtil.getDateAndWeek()%></span></td>
				          		</tr>
				        	</table>
				        </td>
					</tr>
			   	</table>
  			</td>
  		</tr>
 		<tr>
    		<td height="5" style="line-height:5px; background-image:url(images/main_18.gif)">
    			<table width="100%" border="0" cellspacing="0" cellpadding="0">
      				<tr>
        				<td width="180" background="images/main_16.gif"  style="line-height:5px;">&nbsp;</td>
       			 		<td>&nbsp;</td>
      				</tr>
    			</table>
    		</td>
  		</tr>
	</table>

	<map name="Map" id="Map">
		<area shape="rect" coords="3,2,99,20" href="#11" />
		<area shape="rect" coords="109,1,156,23" href="<%=request.getContextPath()+"/login.jsp"%>" target="_top"/>
	</map>
	
</body>
</html>
