<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加业务受理单</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<!-- 导入easyui类库 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/default.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui-validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.ocupload-1.1.2.js"></script>
<script
src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
type="text/javascript"></script>

<script src="${pageContext.request.contextPath }/js/common/crud.js"
	type="text/javascript"></script>

<script type="text/javascript">
	$(function(){
		$("body").css({visibility:"visible"});
	

		
		//页面加载完成后，为手机号输入框绑定离焦事件
		$("input[name=telephone]").blur(function(){
			//获取页面输入的手机号
			var telephone = this.value;
			//发送ajax请求，请求Action，在Action中远程掉调用crm服务，获取客户信息，用于页面回显
			$.post('${pageContext.request.contextPath }/noticebill/findCustomerByTelephone',{"telephone":telephone},function(data){
				if(data != null){
					//查询到了客户信息，可以进行页面回显
					var customerId = data.id;
					var customerName = data.name;
					var address = data.address;
					$("input[name=customerId]").val(customerId);
					$("input[name=customerName]").val(customerName);
					$("input[name=delegater]").val(customerName);
					$("input[name=pickaddress]").val(address);
				}else{
					//没有查询到客户信息，不能进行页面回显
					$("input[name=customerId]").val("");
					$("input[name=customerName]").val("");
					$("input[name=delegater]").val("");
					$("input[name=pickaddress]").val("");
				}
			});
		});
		
		
		
		
	});
	
	
	
	function showCloseReload(data){
		var message;
    	if("true"==data){
    		message="成功!!!";
    		$.messager.show({
	    		title:'提示消息',
	    		msg:message,
	    		timeout:4000,
	    		showType:'slide'
	    	});
    	}else if("login"==data){
    		message="请先登录";
    		$.messager.alert("错误信息",message,"error");
    	}else{
    		message="后台发生错误";
    		$.messager.alert("错误信息",message,"error");
    	}
		 
	}

	function  save(){
	      $.ajax({
              url: "${pageContext.request.contextPath}/noticebill/addNoticebill",
              type:"post",
              data:$("#noticebillForm").serialize(),
              error : function() {
  				alert("网络出现错误！");
  			},
  				success : function(data) {
  					showCloseReload(data)
  			}
          });
		
	}

</script>
</head>
<body class="easyui-layout" style="visibility:hidden;">
	<div region="north" style="height:31px;overflow:hidden;" split="false"
		border="false">
		<div class="datagrid-toolbar">
			<a id="save" icon="icon-save"  href="#"  class="easyui-linkbutton" onclick="save()"
				plain="true"  >新单</a>	
		</div>
	</div>
	<div region="center" style="overflow:auto;padding:5px;" border="false">
		<form id="noticebillForm"  method="post" action="${pageContext.request.contextPath}/noticebill/addNoticebill">
			<table class="table-edit" width="95%" align="center">
				<tr class="title">
					<td colspan="4">客户信息</td>
				</tr>
				<tr>
					<td>来电号码:</td>
					<td><input type="text" class="easyui-validatebox" name="telephone" data-options="validType:'mobile'"
						required="true" /></td>
					<td>客户编号:</td>
					<td><input type="text" class="easyui-validatebox"  name="customerId"  data-options="validType:'unnormal'"
						required="true" /></td>
				</tr>
				<tr>
					<td>客户姓名:</td>
					<td><input type="text" class="easyui-validatebox" name="customerName" data-options="validType:'name'"
						required="true" /></td>
					<td>联系人:</td>
					<td><input type="text" class="easyui-validatebox" name="delegater" data-options="validType:'name'"
						required="true" /></td>
				</tr>
				<tr class="title">
					<td colspan="4">货物信息</td>
				</tr>
				<tr>
					<td>品名:</td>
					<td><input type="text" class="easyui-validatebox" name="product" data-options="validType:'unnormal'"
						 /></td>
					<td>件数:</td>
					<td><input type="text" class="easyui-numberbox" name="num"
						 /></td>
				</tr>
				<tr>
					<td>重量(kg):</td>
					<td><input type="text" class="easyui-numberbox" name="weight"
						 /></td>
					<td>体积(m^3):</td>
					<td><input type="text" class="easyui-validatebox" name="volume" data-options="validType:'number'"
						 /></td>
				</tr>
				<tr>
					<td>取件地址</td>
					<td colspan="3"><input type="text" class="easyui-validatebox" name="pickaddress" data-options="validType:'unnormal'"
						required="true" size="200"/></td>
				</tr>
				<tr>
					<td>到达城市:</td>
					<td><input type="text" class="easyui-validatebox" name="arrivecity" data-options="validType:'unnormal'"
						required="true" /></td>
					<td>预约取件时间:</td>
					<td><input type="text" class="easyui-datetimebox" name="pickdate"
						data-options="required:true, editable:false" /></td>
				</tr>
				<tr>
					<td>备注:</td>
					<td colspan="3"><textarea rows="5" cols="80" type="text" class="easyui-validatebox" name="remark" data-options="validType:'unnormal'"
						 ></textarea></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>