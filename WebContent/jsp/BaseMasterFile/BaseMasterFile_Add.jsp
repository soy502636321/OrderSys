<jsp:directive.include file="/include/mainMenu.jsp" />
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body>
	<s:form action="baseMasterFileAction" namespace="/masterFile" method="post" enctype="multipart/form-data">
		<br>
		<s:hidden name="baseMasterFileVO.sysOrderPid" />
		<table style="margin: auto; width: 500px;">
			<tr>
				<td colspan="4">${ actionMessages[0] }${actionErrors[0]}</td>
			</tr>
			<tr>
				<td>译文文件(1)</td>
				<td><s:file name="upload" /></td>
			</tr>
			<tr>
				<td colspan="2"><s:submit value="上传原文"
						action="baseMasterFileAction!save" /> 
				<s:submit value="返回列表"
						action="baseMasterFileAction!back" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
