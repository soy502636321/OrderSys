<jsp:directive.include file="/include/mainMenu.jsp" />
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body>
	<s:form action="privateHandleSysFeedbackAction"
		namespace="/sysFeedback">
		<br>
		<table style="width: 100%">
			<tr>
				<td colspan="4">${ actionMessages[0] }${actionErrors[0]}</td>
			</tr>
			<tr>
				<td><order:buttons function="4028848c4153095e01415309658d0001">
						<order:button name="查看反馈" mode="single" location="other"></order:button>
						<order:button name="订单原文" mode="single" location="other"></order:button>
						<order:button name="订单译文" mode="single" location="other"></order:button>
					</order:buttons>
				</td>
			</tr>
			<tr>
				<td><display:table name="paginatedList" class="simple"
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
