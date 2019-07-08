<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理分区</title>
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
//是否reload的标志，如何是后台传回来的数据的话直接赋值不reload
$(function() {
	showPro();
	
	init("${pageContext.request.contextPath}/subarea/findBypage");
	/* showPro(); */
	//onclickup插件的初始化，提供上传时候的用户交互
	$("#button-import").upload({
		action:'${pageContext.request.contextPath}/subarea/importXls',
		name:'importFile',
		onSubmit:function () {
			var isImportUrl = "${pageContext.request.contextPath}/subarea/isImport";
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
		showPro2();
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
					"position" :data.position
				});
				$('#single').combobox('setValue', data.single);
				$('#province2').combobox('setValue', data.region.province);
				setInterval(function () { var city= $('#city2').combobox('getValue'); if(null==city ||""==city){$('#city2').combobox('setValue', data.region.city);}else{ return false;} }, 10);
				setInterval(function () { var district= $('#district2').combobox('getValue'); if(null==district ||""==district){$('#district2').combobox('setValue', data.region.district);}else{ return false;} }, 10);
				setInterval(function () { var decidedzone= $('#decidedzone2').combobox('getValue'); if(null==decidedzone ||""==decidedzone){$('#decidedzone2').combobox('setValue', data.decidedzone.name);}else{ return false;} }, 10);
				
				/* 	$('#district').combobox('setValue', data.region.district); */

			}
		});
		$("#save").attr("onclick", "update('"+updataByIdUrl+"');");
		$("input[name='id']").css({
			display : "none"
		});
	}
}
	
function doAdd(addUrl) {
	//alert("增加...");
	$('#addWindow').window("open");
	$('#formAdd')[0].reset();
	showPro2();
	$("#save").attr("onclick", "save('"+addUrl+"');");
	$("input[name='id']").css({
		display : "inline-block"
	});
}
	
</script>	
</head>



<body class="easyui-layout" style="visibility:hidden;">



 <div id="tb" style="padding:5px;height:auto">
 <table cellpadding="0" cellspacing="0" style="width: 100%">
    <tr >
      <td>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="doAdd('${pageContext.request.contextPath }/subarea/addSubarea')">新增</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="doUpdate('${pageContext.request.contextPath}/subarea/findById?id=','${pageContext.request.contextPath }/subarea/updateById')">修改</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="doDelete('${pageContext.request.contextPath }/subarea/deleteBatch?ids=')">删除</a>
        <a  href="#" id="button-import" class="easyui-linkbutton" data-options="iconCls:'icon-redo',plain:true" >导入</a>
     	<a  href="#"  class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true"  onclick="doExport('${pageContext.request.contextPath }/subarea/exportXls')">导出</a>
      </td>
      </tr>
      <tr>
      <td style="margin-left: 0px;">
        <form id="formQuery"  class="easyui-linkbutton" data-options="plain:true" >
       <span style="margin-left: 0px">分拣编号&nbsp;</span><input name="id" type="text" class="easyui-textbox " style="width:100px"> 
        <span style="margin-left: 25px">省 &nbsp;</span><select id="province" name="region.province" class="easyui-combobox easyui-validatebox" style="width:100px;"  required="true">   </select> 
        <span style="margin-left: 25px">市 &nbsp;</span><select id="city" name="region.city" class="easyui-combobox easyui-validatebox" style="width:100px;"  required="true" style="width:100px" >  </select> 
        <span style="margin-left: 25px">区 &nbsp;</span><select id="district" name="region.district" class="easyui-combobox easyui-validatebox" style="width:100px;"  required="true">  </select> 
        <span style="margin-left: 25px">关键字 &nbsp;</span><input name="addresskey" type="text" class="easyui-textbox " style="width:100px" data-options="validType:'CHS'">  
        <span style="margin-left: 25px">位置 &nbsp;</span><input name="position" type="text" class="easyui-textbox " style="width:100px" data-options="validType:'CHS'">  
        </form>
        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:false" onclick="otherQuery()">查询</a> 
      </td>
      </tr>
    </table>
    </div>




<table id="grid"  >
	<thead>
		<tr>
			<th field="xxx" data-options="checkbox : true" ></th>
			<th field="id" data-options="width : 120,title : '分拣编号',align : 'center',checkbox : false" ></th>
			<th field="region.province" data-options="width : 120,title : '省',align : 'center',formatter:function(value,row,index){var data= row.region;if(null!=data){  return data.province;}else{return '无';}}" ></th>
			<th field="region.city" data-options="width : 120,title : '市',align : 'center',formatter:function(value,row,index){var data= row.region;if(null!=data){  return data.city;}else{return '无';}}" ></th>
			<th field="region.district" data-options="width : 120,title : '区',align : 'center',formatter:function(value,row,index){var data= row.region;if(null!=data){  return data.district;}else{return '无';}}"  ></th>
			<th field="decidedzone.name" data-options="width : 120,title : '所属定区',align : 'center',formatter:function(value,row,index){var data= row.decidedzone;if(null!=data){  return data.name;}else{return '无';}}"  ></th>
			<th field="addresskey" data-options="width : 120,title : '关键字',align : 'center'" ></th>
			<th field="position" data-options="width : 200 ,title : '位置',align : 'center'" ></th>
		    <th field="startnum" data-options="width : 100 ,title : '起始号',align : 'center'" ></th>
		    <th field="endnum" data-options="width : 100 ,title : '终止号',align : 'center'" ></th>
		    <th field="single" data-options="width : 100 ,title : '单双号',align : 'center',formatter:function(value,row,index){var data= row.single;if(0==data){  return '单双号';} else if(1==data){return '单号';}else{return '双号';}}" ></th>
		
		</tr>
	</thead>
  </table>  
	
	
	
	<!-- 添加修改分区 -->
	<div class="easyui-window" title="分区添加或修改" id="addWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
		<div style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true" >保存</a>
			</div>
		</div>
		
		<div style="overflow:auto;padding:5px;" border="false">
			<form id="formAdd" >
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">分区信息</td>
					</tr>
					<tr>
						<td>分拣编码</td>
						<td><input type="text" name="id" class="easyui-validatebox" required="true" data-options="validType:'name'"/></td>
					</tr>
					<tr>
						<td>省</td>
						<td><select id="province2" name="region.province"     class="easyui-combobox easyui-validatebox" style="width:150px;"  required="true"> </select>  </td>
					</tr>
					<tr>
						<td>市</td>
						<td><select  id="city2" name="region.city"    class="easyui-combobox easyui-validatebox" style="width:150px;"  required="true"> </select>   </td>
					</tr>
					<tr>
						<td>区</td>
						<td><select id="district2" name="region.district"    class="easyui-combobox easyui-validatebox" style="width:150px;"  required="true" > </select>  </td>
					</tr>
						<tr>
						<td>所属定区</td>
						<td><select id="decidedzone2" name="decidedzoneId"    class="easyui-combobox easyui-validatebox" style="width:150px;"  required="true"> </select>  </td>
					</tr>
					<tr>
						<td>关键字</td>
						<td><input type="text" name="addresskey" class="easyui-validatebox" required="true" data-options="validType:'CHS'"/></td>
					</tr>
					<tr>
						<td>起始号</td>
						<td><input type="text" name="startnum" class="easyui-validatebox" required="true" data-options="validType:'number'"/></td>
					</tr>
					<tr>
						<td>终止号</td>
						<td><input type="text" name="endnum" class="easyui-validatebox" required="true" data-options="validType:'number'"/></td>
					</tr>
					<tr>
						<td>单双号</td>
						<td>
							<select class="easyui-combobox" name="single" id="single" style="width:150px;" required="true" data-options="validType:'CHS'">  
							    <option value="0">单双号</option>  
							    <option value="1">单号</option>  
							    <option value="2">双号</option>  
							</select> 
						</td>
					</tr>
					<tr>
						<td>位置信息</td>
						<td><input type="text" name="position" class="easyui-validatebox" required="true" style="width:250px;"/></td>
					</tr>
				</table>
			</form>
		</div>
	</div>


</body>
</html>