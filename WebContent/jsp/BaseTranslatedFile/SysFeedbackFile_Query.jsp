<jsp:directive.include file="/include/mainMenu.jsp" />
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>译文列表</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body>
	<s:form action="baseTranslatedFileAction" namespace="/translatedFile">
		<br>
		<s:hidden name="baseTranslatedFileVO.sysOrderPid" />
		<table style="width: 100%">
			<tr>
				<td colspan="4">${ actionMessages[0] }${actionErrors[0]}</td>
			</tr>
			<tr>
				<td><order:buttons function="4028848c414eca6b01414eca75160001">
						<order:button name="增加译文" mode="all" location="this"></order:button>
						<order:button name="删除译文" mode="more" location="this"></order:button>
						<order:button name="下载译文" mode="more" location="other"></order:button>
					</order:buttons></td>
			</tr>
			<tr>
				<td><display:table name="paginatedList" class="simple"
						requestURI="newOrderAction!query">
						<display:column property="translatedFilePid"
							decorator="order.hq.common.displaytag.CheckBoxDecorator"
							style="width:3%;"
							title="<input type=checkbox class=checkbox name=cbAll onclick=changeCheckBoxAll(this,\"cbId\")>">
						</display:column>
						<display:column property="translatedFileName" title="原文件名字" />
						<display:column property="translatedFileSize" title="原文件大小" />
						<display:column property="operTime" title="上传日期"
							format="{0,date,yyyy-MM-dd HH:mm}" />
						<display:column property="operUser.userName" title="上传人" />
						<display:column property="downloadSize" title="下载次数" />
					</display:table>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>
