<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理定区/调度排班</title>
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
<script src="${pageContext.request.contextPath }/js/common/liandong.js"
	type="text/javascript"></script>
	
<script type="text/javascript">

$(function() {
	showPro();
	
	init("${pageContext.request.contextPath}/decidedzone/findBypage");
	/* showPro(); */
	
	$('#addWindow').window({
			width : 700,
			modal : true,
			shadow : true,
			closed : true,
			height : 550,
			resizable : false
		});
	
	
	//onclickup插件的初始化，提供上传时候的用户交互
	$("#button-import").upload({
		action:'${pageContext.request.contextPath}/decidedzone/importXls',
		name:'importFile',
		onSubmit:function () {
			var isImportUrl = "${pageContext.request.contextPath}/decidedzone/isImport";
			importExcWithprogress(isImportUrl,200,200);
		 },
		 onComplete:function (data) {
			 showCloseReload3(data);
		 }
		
	});
	//改变样式插件与easyui的样式有点冲突
	$("#button-import").parent().addClass("easyui-linkbutton l-btn l-btn-small l-btn-plain");
	
});	
	
	

//修改的时候回传数据
function doUpdate(findByIdUrl,updataByIdUrl) {
	var rows = $("#grid").datagrid("getSelections");
	var city;
	if (rows.length == 0 || rows.length > 1) {
		//没有选中记录，弹出提示
		$.messager.alert("提示信息", "有且需要选中一条记录", "warning");
	} else {
		var object = rows[0];//json对象
		var id = object.id;
		$("#addWindow").window("open");
		$('#formAdd').form("clear");
		showStaffName();
		$.ajax({
			type : "get",
			dataType : "json",
			url : findByIdUrl+ id + "",
			error : function() {
				alert("网络出现错误！");
			},
			success : function(data) {
				//成功则回显数据
				$('#formAdd').form('load',{
					id:data.id,
					"decidedzoneId" :data.decidedzoneId,
					"addresskey" :data.addresskey,
					"startnum" :data.startnum,
					"endnum" :data.endnum,
					"position" :data.position,
					"single":data.single,
					"name":data.name
				});
				$('#province').combobox('setValue', data.region.province);
				setInterval(function () { var city= $('#city').combobox('getValue'); if(null==city ||""==city){$('#city').combobox('setValue', data.region.city);}else{ return false;} }, 10);
				setInterval(function () { var district= $('#district').combobox('getValue'); if(null==district ||""==district){$('#district').combobox('setValue', data.region.district);}else{ return false;} }, 10);
				setInterval(function () { var staffname= $('#staffname').combobox('getValue'); if(null==staffname ||""==staffname){$('#staffname').combobox('setValue', data.staff.name);}else{ return false;} }, 10);

			}
		});
		$("#save").attr("onclick", "update('"+updataByIdUrl+"');");
		$("input[name='id']").css({
			display : "none"
		});
		$("#guanlianfenqu").css({
			display : "none"
		});
	}
}



function doDblClickRow(index,data){
	//将页面中table变为datagrid样式
	$('#association_subarea').datagrid( {
		fit : true,
		border : true,
		rownumbers : true,
		striped : true,
		url : "${pageContext.request.contextPath}/subarea/findByDecidedzoneId?decidedzoneId="+data.id,
		columns : [ [{
			field : 'id',
			title : '分拣编号',
			width : 120,
			align : 'center'
		},{
			field : 'province',
			title : '省',
			width : 120,
			align : 'center',
			formatter : function(data,row ,index){
			if(null!=row.region){
				return row.region.province;
							}else{
								return "无";
							}
			}
		}, {
			field : 'city',
			title : '市',
			width : 120,
			align : 'center',
			formatter : function(data,row ,index){
				if(null!=row.region){
					return row.region.city;
				}else{
					return "无";
				}
			}
		}, {
			field : 'district',
			title : '区',
			width : 120,
			align : 'center',
			formatter : function(data,row ,index){
			if(null!=row.region){
				return row.region.district;
							}else{
								return "无";
							}
			
			}
		}, {
			field : 'addresskey',
			title : '关键字',
			width : 120,
			align : 'center'
		}, {
			field : 'startnum',
			title : '起始号',
			width : 100,
			align : 'center'
		}, {
			field : 'endnum',
			title : '终止号',
			width : 100,
			align : 'center'
		} , {
			field : 'single',
			title : '单双号',
			width : 100,
			align : 'center'
		} , {
			field : 'position',
			title : '位置',
			width : 200,
			align : 'center'
		} ] ]
	});
	
	//创建展示客户数据的数据表格
	$('#association_customer').datagrid( {
		fit : true,
		border : true,
		rownumbers : true,
		striped : true,
		url : "${pageContext.request.contextPath}/decidedzone/findCustomersByDecidedzoneId?decidedzoneId="+data.id,
		columns : [[{
			field : 'id',
			title : '客户编号',
			width : 120,
			align : 'center'
		},{
			field : 'name',
			title : '客户名称',
			width : 120,
			align : 'center'
		}, {
			field : 'station',
			title : '所属单位',
			width : 120,
			align : 'center'
		}]]
	});
	
}

	
	
//添加的时候跳出窗口
function doAdd(addUrl) {
	//alert("增加...");
	$('#addWindow').window("open");
	$('#formAdd')[0].reset();
	showStaffName();
	$("#save").attr("onclick", "save('"+addUrl+"');");
	$("input[name='id']").css({
		display : "inline-block"
	});
	$("#guanlianfenqu").removeAttr("display");
}

function showStaffName(){
	
	$.ajax({
		 url : '/wuliu3/staff/findAll',
		 type: "POST",
		 dataType: 'json',  
	     success: function (json) {
			$('#staffname').combobox({
				data: json,  
				valueField:'id',
				textField:'name',
				editable:false

			});
		        			
		  }
	});
}

function otherQuery2(){
 	var formSerialize =$("#formQuery2").form().serializeArray();
 	var obj=serializeObject(formSerialize);
 	if(false==obj){
 		return false;
 	}
    $("#subareaGrid").datagrid('load',obj);

}


//将表单序列化
function serializeObject(formSerialize){
		var flag=0;
        var o={};
        $.each(formSerialize,function(index){
	   if(""!=this['value']){
		   flag = 1;
	   }
        o[this['name'] ]=this['value'];         
       });
       return o;
   } 


function save(saveUrl) {
	var rows = $("#subareaGrid").datagrid("getSelections");
	var ids=null;
	if (rows.length >0) {
		var array = new Array();
		//确定,发送请求
		//获取所有选中的取派员的id
		for (var i = 0; i < rows.length; i++) {
			var object = rows[i];//json对象
			var id = object.id;
			array.push(id);
		}
		ids = array.join(",");//1,2,3,4,5
	}
	
	$('#formAdd').form({
		url : saveUrl,
		onSubmit: function (param) {
			param.ids = ids
		    },
		error : function() {
			alert("网络出现错误！");
		},
		success : function(data) {
			showCloseReload(data);
		}
	});
	// submit the form    
	$('#formAdd').submit();
}

function doAssociations(){
	//获取当前数据表格所有选中的行，返回数组
	var rows = $("#grid").datagrid("getSelections");
	if(rows.length != 1){
		//弹出提示
		$.messager.alert("提示信息","请选择一个定区操作！","warning");
	}else{
		//选中了一个定区
		$('#customerWindow').window('open');
		//清理下拉框
		$("#noassociationSelect").empty();
		$("#associationSelect").empty();
		//发送ajax请求，请求定区Action，在定区Action中通过crm代理对象完成对于crm服务远程调用获取客户数据
		var url_1 = "${pageContext.request.contextPath }/decidedzone/findListNotAssociation";
		$.post(url_1,function(data){
			//遍历json数组
			for(var i=0;i<data.length;i++){
				var id = data[i].id;
				var name = data[i].name;
				var station = data[i].station;
				name = name + "(" + station + ")";
				$("#noassociationSelect").append("<option value='"+id+"'>"+name+"</option>");
			}
		});
		
		//发送ajax请求，请求定区Action，在定区Action中通过crm代理对象完成对于crm服务远程调用获取客户数据
		var url_2 = "${pageContext.request.contextPath }/decidedzone/findListHasAssociation";
		var decidedzoneId = rows[0].id;
		$.post(url_2,{"id":decidedzoneId},function(data){
			//遍历json数组
			for(var i=0;i<data.length;i++){
				var id = data[i].id;
				var name = data[i].name;
				var station = data[i].station;
				name = name + "(" + station + ")";
				$("#associationSelect").append("<option value='"+id+"'>"+name+"</option>");
			}
		});
	}
}


</script>	
</head>
<body class="easyui-layout" style="visibility:hidden;">

	 <div id="tb" style="padding:5px;height:auto">
 <table cellpadding="0" cellspacing="0" style="width: 100%">
    <tr >
      <td>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="doAdd('${pageContext.request.contextPath }/decidedzone/addDecidedzone?ids=')">新增</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="doUpdate('${pageContext.request.contextPath}/decidedzone/findById?id=','${pageContext.request.contextPath }/decidedzone/updateById')">修改</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="doDelete('${pageContext.request.contextPath }/decidedzone/deleteBatch?ids=')">删除</a>
        <a  href="#" id="button-import" class="easyui-linkbutton" data-options="iconCls:'icon-redo',plain:true" >导入</a>
    	<a  href="#"  class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true"  onclick="doExport('${pageContext.request.contextPath }/decidedzone/exportXls')">导出</a>
       	<a  href="#"  class="easyui-linkbutton" data-options="iconCls:'icon-sum',plain:true"  onclick="doAssociations()">关联客户</a>
       </td>
      </tr>
      <tr>
      <td style="margin-left: 0px;">
        <form id="formQuery"  class="easyui-linkbutton" data-options="plain:true" >
       <span style="margin-left: 0px">定区编号&nbsp;</span><input name="id" type="text" class="easyui-textbox easyui-numberbox" style="width:100px" data-options="validType:'number'"> 
        <span style="margin-left: 25px">省 &nbsp;</span><input name="province" type="text" class="easyui-textbox " style="width:100px" data-options="validType:'CHS'">  
        <span style="margin-left: 25px">市 &nbsp;</span><input name="city" type="text" class="easyui-textbox " style="width:100px" data-options="validType:'CHS'">  
        <span style="margin-left: 25px">区 &nbsp;</span><input name="district" type="text" class="easyui-textbox " style="width:100px" data-options="validType:'CHS'">  
        <span style="margin-left: 25px">定区名称 &nbsp;</span><input name="name" type="text" class="easyui-textbox " style="width:100px" data-options="validType:'CHS'">  
        <span style="margin-left: 25px">取派员名字 &nbsp;</span><input name="startnum" type="text" class="easyui-textbox " style="width:100px" data-options="validType:'name'">  
        </form>
        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:false" onclick="otherQuery()">查询</a> 
      </td>
      </tr>
    </table>
    </div>
    
    
   <div id="tb2" style="padding:5px;height:auto" >
 <table cellpadding="0" cellspacing="0" style="width: 100%">
      <tr>
      <td style="margin-left: 0px;">
        <form id="formQuery2"  class="easyui-linkbutton" data-options="plain:true" >
       <span style="margin-left: 0px">分拣编号&nbsp;</span><input name="id" type="text" class="easyui-textbox easyui-numberbox" style="width:100px" data-options="validType:'number'"> 
        <span style="margin-left: 15px">关键字 &nbsp;</span><input name="addresskey" type="text" class="easyui-textbox " style="width:100px" data-options="validType:'CHS'">  
        <span style="margin-left: 15px">位置 &nbsp;</span><input name="position" type="text" class="easyui-textbox " style="width:100px" data-options="validType:'CHS'">  
        </form>
        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:false" onclick="otherQuery2()">查询</a> 
      </td>
      </tr>
    </table>
    </div>
    
    
    


	<div region="center" border="false">
    	<table id="grid"  data-options="onDblClickRow: doDblClickRow">
    	<thead>
		<tr>
			<th field="xxx" data-options="checkbox : true" ></th>
			<th field="id" data-options="width : 120,title : '定区编号',align : 'center',checkbox : false" ></th>
			<th field="region.province" data-options="width : 120,title : '省',align : 'center',formatter:function(value,row,index){var data= row.region;if(null!=data){  return data.province;}else{return '无';}}" ></th>
			<th field="region.city" data-options="width : 120,title : '市',align : 'center',formatter:function(value,row,index){var data= row.region;if(null!=data){  return data.city;}else{return '无';}}" ></th>
			<th field="region.district" data-options="width : 120,title : '区',align : 'center',formatter:function(value,row,index){var data= row.region;if(null!=data){  return data.district;}else{return '无';}}"  ></th>
			<th field="name" data-options="width : 120,title : '定区名称',align : 'center'" ></th>
			<th field="staff.name" data-options="width : 200 ,title : '取派员名字',align : 'center',formatter:function(value,row,index){var data= row.staff;if(null!=data){  return data.name;}else{return '无';}}" ></th>
		</tr>
	  </thead>
    </table>
	</div>
	
	
	
	<div region="south" border="false" style="height:150px">
		<div id="tabs" fit="true" class="easyui-tabs">
			<div title="关联分区" id="subArea"
				style="width:100%;height:100%;overflow:hidden">
				<table id="association_subarea"></table>
			</div>	
			<div title="关联客户" id="customers"
				style="width:100%;height:100%;overflow:hidden">
				<table id="association_customer"></table>
			</div>	
		</div>
	</div>
	
	<!-- 添加 修改分区 -->
	<div class="easyui-window" title="定区添加修改" id="addWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px;">
		<div style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true" >保存</a>
			</div>
		</div>
		
		<div style="overflow:auto;padding:5px;" border="false">
			<form id="formAdd">
				<table class="table-edit" width="100%" align="center">
					<tr class="title">
						<td colspan="2">定区信息</td>
					</tr>
					<tr>
						<td>定区编码</td>
						<td><input type="text" name="id" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>省</td>
						<td><select id="province" name="region.province"     class="easyui-combobox easyui-validatebox" style="width:150px;"  required="true"> </select>  </td>
					</tr>
					<tr>
						<td>市</td>
						<td><select  id="city" name="region.city"    class="easyui-combobox easyui-validatebox" style="width:150px;"  required="true"> </select>   </td>
					</tr>
					<tr>
						<td>区</td>
						<td><select id="district" name="region.district"    class="easyui-combobox easyui-validatebox" style="width:150px;"  required="true" > </select>  </td>
					</tr>
					<tr>
						<td>定区名称</td>
						<td><input type="text" name="name" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>选择负责人</td>
						<td>
							<select  name="staffId"  id="staffname" 
    							 class="easyui-combobox easyui-validatebox" style="width:150px;"  required="true" >  </select>
						</td>
					</tr>
					<tr height="300" id="guanlianfenqu">
						<td valign="top">关联分区</td>
						<td>
							<table id="subareaGrid" style="width:580px;height:300px;"  class="easyui-datagrid" border="false"   data-options="url:'${pageContext.request.contextPath}/subarea/findBypage',fitColumns:true,singleSelect:false,pagination : true,	toolbar : '#tb2',pageSize : 4,pageList : [ 2,4,8]"  >
								<thead>  
							        <tr>  
							            <th field="xxx" data-options="checkbox : true" ></th>
										<th field="id" data-options="width : 120,title : '分拣编号',align : 'center',checkbox : false" ></th>
							            <th data-options="field:'addresskey',width:150">关键字</th>  
							            <th data-options="field:'position',width:200,align:'right'">位置</th>  
							        </tr>  
							    </thead> 
							</table>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	
	
	
	<!-- 关联客户窗口 -->
	<div class="easyui-window" title="关联客户窗口" id="customerWindow" collapsible="false" closed="true" minimizable="false" maximizable="false" style="top:20px;left:200px;width: 400px;height: 400px;">
		<div style="overflow:auto;padding:5px;" border="false">
			<form id="customerForm" action="" method="post">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="3">关联客户</td>
					</tr>
					<tr>
					<td>未关联相关定区客户</td>
					<td>操作</td>
					<td>已关联到本定区客户</td>
					</tr>
					<tr>
						<td>
							<input type="hidden" name="decidedzoneId" id="customerDecidedZoneId" />
							<select id="noassociationSelect" multiple="multiple" size="10"></select>
						</td>
						<td>
							<input type="button" value="》》" id="toRight"><br/>
							<input type="button" value="《《" id="toLeft">
								<script type="text/javascript">
								$(function(){
									//为左右移动按钮绑定事件
									$("#toRight").click(function(){
										$("#associationSelect").append($("#noassociationSelect option:selected"));
									});
									$("#toLeft").click(function(){
										$("#noassociationSelect").append($("#associationSelect option:selected"));
									});
									
									//为关联客户按钮绑定事件
									$("#associationBtn").click(function(){
										var rows = $("#grid").datagrid("getSelections");
										var id = rows[0].id;
										//为隐藏域（存放定区id）赋值
										$("input[name=decidedzoneId]").val(id);
										//提交表单之前，需要将右侧下拉框中所有的选项选中,为option添加一个selected属性
										$("#associationSelect option").attr("selected","selected");
										$('#customerForm').form({
											url : "${pageContext.request.contextPath }/decidedzone/assignCustomersToDecidedzone",
											error : function() {
												alert("网络出现错误！");
											},
											success : function(data) {
												showCloseReload(data);
											}
										});
										$("#customerForm").submit();
									});
								});
							</script>
						</td>
						<td>
							<select id="associationSelect" name="customerIds" multiple="multiple" size="10"></select>
						</td>
					</tr>
					<tr>
						<td colspan="3"><a id="associationBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">关联客户</a> </td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>