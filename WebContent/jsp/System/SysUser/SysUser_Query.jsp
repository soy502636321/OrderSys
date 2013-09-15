<jsp:directive.include file="/include/mainMenu.jsp" />
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body>
	<s:form action="sysUserAction" namespace="/system">
		<br>
		<table>
			<tr>
				<td colspan="4">${ actionMessages[0] }${actionErrors[0]}</td>
			</tr>
		</table>
		<br>
		<table class="borderTable">
			<tr>
				<td>
					<table>
						<tr>
							<td>用户帐号:</td>
							<td><s:textfield name="sysUserVO.userPid" /></td>
							<td>用户名称:</td>
							<td><s:textfield name="sysUserVO.userName" /></td>
							<td>客户编号:</td>
							<td><s:textfield name="sysUserVO.custNo" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<s:submit value="查询" action="sysUserAction!query" />
					<s:submit value="增加用户" action="sysUserAction!add" />
					<s:submit value="修改用户" action="sysUserAction!edit" onclick="return powerSingleSelect(this, false);" />
					<s:submit value="删除用户" action="sysUserAction!delete" onclick="return powerMoreSelect(this, false)" />
				</td>
			</tr>
			<tr>
				<td><display:table name="paginatedList" class="simple" requestURI="?">
						<display:column property="userPid"
							decorator="order.hq.common.displaytag.CheckBoxDecorator"
							style="width:3%;"
							title="<input type=checkbox class=checkbox name=cbAll onclick=changeCheckBoxAll(this,\"cbId\")>">
					</display:column>
						<display:column property="userPid" title="用户帐号" />
						<display:column property="userName" title="用户名称" />
						<display:column property="sysSection.sectionName" title="角色名称" />
						<display:column property="custNo" title="客户编号" />
						<display:column property="remark" title="备注" />
					</display:table>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>
