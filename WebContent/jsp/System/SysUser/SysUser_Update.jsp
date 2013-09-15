<jsp:directive.include file="/include/mainMenu.jsp"/>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>用户修改</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>

<body>
    <s:form action="sysUserAction" namespace="/system" method="post">
    	<br>
    	<s:hidden name="page" />
    	<table align="center" class="tableForm">
    		<tr>
    			<td colspan="2">
    				${ actionMessages[0] }${actionErrors[0]}
    			</td>
    		</tr>
	    	<tr>
	     		<td>用户帐号:</td>
   				<td>
	        		<s:textfield name="sysUserVO.userPid" disabled="true" />
	        		<s:hidden name="sysUserVO.userPid" />
   				</td>
		    </tr>
	    	<tr>
	     		<td>用户名称:</td>
	        	<td><s:textfield name="sysUserVO.userName" /></td>
	        </tr>
	        <tr>
	        	<td>客户编号:</td>
	        	<td>
	        		<s:textfield name="sysUserVO.custNo" />
	        	</td>
	        </tr>
	    	<tr>
	     		<td>角色:</td>
	        	<td><s:select list="sysSectionVOs" listKey="sectionPid" listValue="sectionName" name="sysUserVO.sysSectionPid" /></td>
	        </tr>
	        <tr>
	        	<td>
	        		新密码:
	        	</td>
	        	<td>
	        		<s:textfield name="sysUserVO.password" />
	        	</td>
	        </tr>
	    	<tr>
	     		<td>备注:</td>
	        	<td><s:textfield name="sysUserVO.remark" /></td>
	        </tr>
	        <tr>
   				<td class="tdCenter" colspan="2">
   					<s:submit value="修  改" action="sysUserAction!update"  />&nbsp;&nbsp;
   					<s:submit value="返  回" action="sysUserAction!back"  />
   				</td>
	        </tr>
    	</table>
    	<br />
	</s:form>
</body>
</html>