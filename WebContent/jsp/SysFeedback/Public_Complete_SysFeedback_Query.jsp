<jsp:directive.include file="/include/mainMenu.jsp" />
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body>
	<s:form action="publicInitateSysFeedbackAction" namespace="/sysFeedback">
		<br>
		<table>
			<tr>
				<td colspan="4">${ actionMessages[0] }${actionErrors[0]}</td>
			</tr>
		</table>
		<br>
		<table style="width: 100%">
			<tr>
				<td>
					<s:submit value="查看指示" action="publicInitateSysOrderAction!findSysShow" />
				</td>
			</tr>
			<tr>
				<td>
					<display:table name="paginatedList" class="simple"
						requestURI="newOrderAction!query">
						<display:column property="feedbackPid"
							decorator="order.hq.common.displaytag.CheckBoxDecorator"
							style="width:3%;"
							title="<input type=checkbox class=checkbox name=cbAll onclick=changeCheckBoxAll(this,\"cbId\")>">
						</display:column>
						<display:column property="feedbackPid" title="指示编号" />
					</display:table>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>
