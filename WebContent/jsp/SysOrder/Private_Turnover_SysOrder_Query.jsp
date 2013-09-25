<jsp:directive.include file="/include/mainMenu.jsp" />
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body>
	<s:form action="publicInitateSysOrderAction" namespace="/sysOrder">
		<br>
		<table style="width: 100%">
			<tr>
				<td colspan="4">${ actionMessages[0] }${actionErrors[0]}</td>
			</tr>
			<tr>
				<td><order:buttons function="8a80cd8e40fd71240140fd7137da0001">
						<order:button name="查看订单" mode="single" location="other"></order:button>
						<order:button name="查看指示" mode="single" location="other"></order:button>
						<order:button name="查看原文" mode="single" location="other"></order:button>
					</order:buttons>
					</td>
			</tr>
			<tr>
				<td><display:table name="paginatedList" class="simple"
						requestURI="newOrderAction!query">
						<display:column property="orderPid"
							decorator="order.hq.common.displaytag.CheckBoxDecorator"
							style="width:3%;"
							title="<input type=checkbox class=checkbox name=cbAll onclick=changeCheckBoxAll(this,\"cbId\")>">
						</display:column>
						<display:column property="orderNo" title="订单编号" />
						<display:column property="operTime" title="下单时间"
							format="{0,date,yyyy-MM-dd HH:mm}" />
						<display:column property="submitTime" title="交稿时间"
							format="{0,date,yyy-MM-dd HH:mm}" />" />
						<display:column property="startLanguage.languageName" title="原文语种" />
						<display:column property="endLanguage.languageName" title="译文语种" />
						<display:column property="baseMasterFileCount" title="原文数量" />
						<display:column property="operUser.email" title="联系邮箱" />
						<display:column property="operUser.mobileTel" title="联系电话" />
					</display:table>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>
