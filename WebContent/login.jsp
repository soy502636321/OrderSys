<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-tags.tld" prefix="s"%>
<html>
  <head>
    <title>汇泉翻译MIS</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<SCRIPT type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></SCRIPT>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow:hidden;
}
.STYLE3 {color: #528311; font-size: 12px; }
.STYLE4 {
	color: #42870a;
	font-size: 12px;
}
-->
</style>
</head>
<body>

<s:form action="loginAction" namespace="/login">

	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
    		<td bgcolor="#e5f6cf">&nbsp;</td>
  		</tr>
		<tr>
    		<td height="608" background="<%=request.getContextPath()%>/images/login_03.gif">
    			<table width="862" border="0" align="center" cellpadding="0" cellspacing="0">
      				<tr>
        				<td height="266" background="<%=request.getContextPath()%>/images/login_04.gif">&nbsp;<s:actionerror cssStyle="color:red;" /><s:actionmessage cssStyle="color:blue;" /></td>
      				</tr>
     	 			<tr>
        				<td height="95">
        					<table width="100%" border="0" cellspacing="0" cellpadding="0">
          						<tr>
            						<td width="424" height="95" background="<%=request.getContextPath()%>/images/login_06.gif">&nbsp;</td>
            						<td width="183" background="<%=request.getContextPath()%>/images/login_07.gif">
            							<table width="100%" border="0" cellspacing="0" cellpadding="0">
              								<tr>
                								<td width="21%" height="30">
                									<div align="center"><span class="STYLE3">用户</span></div>
                								</td>
                								<td width="79%" height="30">
                									<s:textfield name="userId" id="userId" cssStyle="height:18px; width:130px; border:solid 1px #cadcb2; font-size:12px; color:#81b432;" ></s:textfield>
                								</td>
              								</tr>
              								<tr>
              								<tr>
                								<td width="21%" height="30">
                									<div align="center"><span class="STYLE3">密码</span></div>
                								</td>
                								<td width="79%" height="30">
                									<s:password name="password" id="password" cssStyle="height:18px; width:130px; border:solid 1px #cadcb2; font-size:12px; color:#81b432;"></s:password>
                								</td>
              								</tr>
              								<tr>
                								<td height="30">&nbsp;</td>
               									<td height="30">
               										<s:submit value="登  录" action="loginAction!login" onClick="return vaildateLogin();"></s:submit>&nbsp;&nbsp;&nbsp;
				  									<s:reset value="重  置"></s:reset>
               									</td>
              								</tr>
            							</table>
            						</td>
            						<td width="255" background="<%=request.getContextPath()%>/images/login_08.gif">&nbsp;</td>
          						</tr>
        					</table>
        				</td>
      				</tr>
      				<tr>
        				<td height="247" valign="top" background="<%=request.getContextPath()%>/images/login_09.gif">
        					<table width="100%" border="0" cellspacing="0" cellpadding="0">
          						<tr>
            						<td width="22%" height="30">&nbsp;</td>
						            <td width="56%">&nbsp;</td>
						            <td width="22%">&nbsp;</td>
          						</tr>
          						<tr>
						            <td>&nbsp;</td>
						            <td height="30">
						            	<table width="100%" border="0" cellspacing="0" cellpadding="0">
						              		<tr>
					                			<td width="44%" height="20">&nbsp;</td>
					                			<td width="56%" class="STYLE4">版本 2013V7.0 </td>
					              			</tr>
					            		</table>
					            	</td>
            						<td>&nbsp;</td>
          						</tr>
        					</table>
        				</td>
      				</tr>
    			</table>
    		</td>
  		</tr>
  		<tr>
    		<td bgcolor="#a2d962">&nbsp;</td>
  		</tr>
	</table>
</s:form>
</body>

<script type="text/javascript">

function vaildateLogin(){
	//var userId=document.all("userId").value;
	var userId = $("#userId").val();
	var password = $("#password").val();
	var msg="";
	if(userId==""){
		msg+="用户名不能为空！\n";
	}
	if(password==""){
		msg+="密码不能为空！";
	}
	if(msg.length>0){
		alert(msg);
		return false;
	}

	return true;
}

</script>
</html>
