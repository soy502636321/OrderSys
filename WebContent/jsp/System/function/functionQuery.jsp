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
	<s:form action="functionAction" namespace="/system">
	   	<br>
		<table>
	   		<tr>
	   			 <td>&nbsp;&nbsp;&nbsp;</td>
		   	  	 <td>功能名称:</td>
		         <td><s:textfield name="functionName" cssStyle="width:200;" ></s:textfield></td>
		         <td>&nbsp;&nbsp;&nbsp;
		         	<s:submit value="查  询" action="functionAction!query"></s:submit>&nbsp;&nbsp;&nbsp;
				  	<s:reset value="重  置"></s:reset>
		         </td>
	        </tr>
	    </table>
	    <br>
		<table>
  			<tr><td></td></tr>
  			<tr><td>
				<display:table name="functionList" pagesize="<%=pageSize %>" class="simple" requestURI="?">
					<display:column property="functionId" decorator="com.hq.common.displaytag.CheckBoxDecorator" style="width:3%;"
					    title="<input type=checkbox class=checkbox name=cbAll onclick=changeCheckBoxAll(this,\"cbId\")>">
					</display:column>
		 			<display:column property="functionId" title="功能编码"  sortable="true" style="width:300px"/>
		 			<display:column property="functionName" title="功能名称"  sortable="true" style="width:300px"/>
		 			<display:column property="parent.functionName" title="功能上级名称"  sortable="true" style="width:300px"/>
		 			<display:column property="functionUrl" title="功能Url"  sortable="true" style="width:300px"/>
		 			<display:column property="functionType" title="功能类型"  sortable="true" style="width:300px"/>
		 			<display:column property="remark" title="备注" sortable="true" style="width:400px"/>
			    </display:table>
    		</td></tr>
  		</table>
  		<table width="100%">
		    <tr>
			    <td class="tdCenter">
				    <s:submit value="添  加" action="functionAction!add" ></s:submit>&nbsp;&nbsp;
				    <input type="button" value="编  辑" onclick="return edit();">&nbsp;&nbsp;
				    <s:submit value="删  除" action="functionAction!del" ></s:submit>
			  	</td>
		 	</tr>
  		</table>
	</s:form>
</body>
<script type="text/javascript">
function edit(){
	if(singleSelect()){
		var value = getDefaultCheckValue();
		var form=document.forms[0];
		form.action="functionAction!edit.action?id="+value;  
		form.submit();
	}
}

</script>
</html>
