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
	<s:form action="userAction" namespace="/user">
	   	<br>
		<table>
	   		<tr>
	   			 <td>&nbsp;&nbsp;&nbsp;</td>
		   	  	 <td>用户名称:</td>
		         <td><s:textfield name="userName" cssStyle="width:200;" ></s:textfield></td>
		         <td>&nbsp;&nbsp;&nbsp;
		         	<s:submit value="查  询" action="userAction!query"></s:submit>&nbsp;&nbsp;&nbsp;
				  	<s:reset value="重  置"></s:reset>
		         </td>
	        </tr>
	    </table>
	    <br>
		<table class="borderTable">
  			<tr><td></td></tr>
  			<tr><td>
				<display:table name="userList" pagesize="<%=pageSize %>" class="simple" requestURI="?">
					<display:column property="userId" decorator="com.hq.common.displaytag.CheckBoxDecorator" style="width:3%;"
					    title="<input type=checkbox class=checkbox name=cbAll onclick=changeCheckBoxAll(this,\"cbId\")>">
					</display:column>
		 			<display:column property="userId" title="用户编号"  sortable="true" style="width:300px"/>
		 			<display:column property="userName" title="用户名称"  sortable="true" style="width:300px"/>
		 			<display:column property="sysSection.sectionName" title="部门名称"  sortable="true" style="width:300px"/>
		 			<display:column property="remark" title="备注" sortable="true" style="width:400px"/>
		 			<display:column />
			    </display:table>
    		</td></tr>
  		</table>
  		<table width="100%">
		    <tr>
			    <td class="tdCenter">
				    <s:submit value="添  加" action="sectionAction!add" ></s:submit>&nbsp;&nbsp;
				    <input type="button" value="编  辑" onclick="return edit();">&nbsp;&nbsp;
				    <s:submit value="删  除" action="sectionAction!del" ></s:submit>
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
		form.action="userAction!edit.action?id="+value;  
		form.submit();
	}
}

</script>
</html>
