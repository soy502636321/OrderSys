<jsp:directive.include file="/include/mainMenu.jsp" />
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body>
	<s:form action="publicInitateSysFeedbackAction"
		namespace="/sysFeedback">
		<br>
		<table style="width: 100%">
			<tr>
				<td colspan="4">${ actionMessages[0] }${actionErrors[0]}</td>
			</tr>
			<tr>
				<td><order:buttons function="8a80c97b4120bee5014120befc9d0001">
						<order:button name="处理反馈" mode="more" location="this"></order:button>
						<order:button name="查看指示" mode="single" location="other"></order:button>
						<order:button name="接受订单" mode="more" location="this"></order:button>
						<order:button name="作废订单" mode="more" location="this"></order:button>
						<order:button name="查看原文" mode="single" location="other"></order:button>
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
