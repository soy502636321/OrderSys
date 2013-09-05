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
    	<br>
    	<table align="center">
    		<tr>
    			<td colspan="2"><s:actionerror cssStyle="color:red;" /><s:actionmessage cssStyle="color:blue;" /></td>
    		</tr>
	    	<tr>
	     		<td>功能编码:</td>
   				<td>
   					<s:if test="isEdit">
	        			<s:property value="functionId"></s:property>
   					</s:if>
   					<s:else>
	        			<s:textfield name="functionId"></s:textfield>
   					</s:else>
   				</td>
		    </tr>
    		
	    	<tr>
	     		<td>功能名称:</td>
	        	<td><s:textfield name="functionName"></s:textfield></td>
	        </tr>
	        
	        <tr>
	     		<td>上级功能:</td>
	        	<td><s:select list="functionList" listKey="functionId" listValue="functionName" name="parentId" headerKey="  " headerValue="-- 请选择 --"></s:select></td>
	        </tr>
	        
	    	<tr>
	     		<td>功能URL:</td>
	        	<td><s:textfield name="functionUrl" size="50"></s:textfield></td>
	        </tr>
	        
	    	<tr>
	     		<td>功能类型:</td>
	        	<td><s:radio list="%{#{'01':'菜单','02':'按钮'}}" theme="simple"  name="functionType"></s:radio></td>
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
   					<s:submit value="保  存" action="functionAction!save" ></s:submit>&nbsp;&nbsp;
   					<s:submit value="返  回" action="functionAction!back" ></s:submit>
   				</td>
   			</tr>
   		</table>
	</s:form>
</body>
</html>