<jsp:directive.include file="/include/mainMenu.jsp"/>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
  <head>
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>

<body>
    <s:form namespace="/system">
    	<s:hidden name="id"></s:hidden>
    	<br>
    	<table align="center" class="borderTable">
	    	<tr>
	     		<td>组织机构编码:</td>
   				<td>
   					<s:if test="isEdit">
	        			<s:property value="organId"></s:property>
   					</s:if>
   					<s:else>
	        			<s:textfield name="organId"></s:textfield>
   					</s:else>
   				</td>
		    </tr>
	    	<tr>
	     		<td>组织机构名称:</td>
	        	<td><s:textfield name="organName"></s:textfield></td>
	        </tr>
	        <tr>
	     		<td>上级组织机构:</td>
	        	<td><s:select list="organList" listKey="id" listValue="organName" name="parentId"></s:select></td>
	        </tr>
	    	<tr>
	     		<td>备注:</td>
	        	<td><s:textfield name="remark"></s:textfield></td>
	        </tr>
    	</table>
    	<br>
   		<table >
   			<tr>
   				<td class="tdCenter">
   					<s:submit value="保  存" action="organzationAction!save" ></s:submit>&nbsp;&nbsp;
   					<s:submit value="返  回" action="organzationAction!back" ></s:submit>
   				</td>
   			</tr>
   		</table>
	</s:form>
</body>
</html>