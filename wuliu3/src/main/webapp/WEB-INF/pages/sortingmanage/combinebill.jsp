<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理取派员</title>
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


$(function() {
	
	init("${pageContext.request.contextPath}/combinebill/findBypage");
	
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
		action:'${pageContext.request.contextPath}/combinebill/importXls',
		name:'importFile',
		onSubmit:function () {
			var isImportUrl = "${pageContext.request.contextPath}/combinebill/isImport";
			importExcWithprogress(isImportUrl,200,200);
		 },
		 onComplete:function (data) {
			 showCloseReload3(data);
		 }
		
	});
	//改变样式插件与easyui的样式有点冲突
	$("#button-import").parent().addClass("easyui-linkbutton l-btn l-btn-small l-btn-plain");
	
});


function doDblClickRow(index,data){

	//创建展示客户数据的数据表格
	$('#association_combinedetails').datagrid( {
		fit : true,
		border : true,
		rownumbers : true,
		striped : true,
		url : "${pageContext.request.contextPath}/combinebill/findCombinedetailsByid?id="+data.id,
		columns : [[{
			field : 'workorderId',
			title : '工作单号',
			width : 120,
			align : 'center'
		},{
			field : 'combineorderId',
			title : '关联合包单',
			width : 120,
			align : 'center'
		}
		,{
			field : 'productname',
			title : '品名',
			width : 120,
			align : 'center'
		},{
			field : 'destination',
			title : '到达地',
			width : 120,
			align : 'center'
		},{
			field : 'jianshu',
			title : '件数',
			width : 120,
			align : 'center'
		},{
			field : 'vol',
			title : '体积',
			width : 120,
			align : 'center'
		},{
			field : 'weight',
			title : '重量',
			width : 120,
			align : 'center'
		},{
			field : 'timelimit',
			title : '到达时限',
			width : 120,
			align : 'center'
		},{
			field : 'peizai',
			title : '配载要求',
			width : 120,
			align : 'center'
		}
		]]
	});
	
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



function otherQuery2(){
 	var formSerialize =$("#formQuery2").form().serializeArray();
 	var obj=serializeObject(formSerialize);
 	if(false==obj){
 		return false;
 	}
    $("#subareaGrid").datagrid('load',obj);

}

</script>
</head>
<body class="easyui-layout"   style="visibility: hidden;" >

 <div id="tb" style="padding:5px;height:auto">
 <table cellpadding="0" cellspacing="0" style="width: 100%">
    <tr >
      <td>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="doAdd('${pageContext.request.contextPath }/combinebill/addCombinebill')">新增</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="doUpdate('${pageContext.request.contextPath}/combinebill/findById?id=','${pageContext.request.contextPath }/combinebill/updateById')">修改</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="doDelete('${pageContext.request.contextPath }/combinebill/deleteBatch?ids=')">删除合包</a>
        <a  href="#" id="button-import" class="easyui-linkbutton" data-options="iconCls:'icon-redo',plain:true" >导入数据</a>
      <form id="formQuery"  class="easyui-linkbutton" data-options="plain:true" >
       <span style="margin-left: 10px">合包号&nbsp;</span><input name="id" type="text" class="easyui-textbox easyui-numberbox" style="width:100px" data-options="validType:'length[0,32]',validType:'isBlank'"> 
        <span style="margin-left: 30px">合包人 &nbsp;</span><input name="combinepeople" type="text" class="easyui-textbox easyui-validatebox" style="width:100px" data-options="validType:'name'"> 
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
       <span style="margin-left: 0px">工作单号&nbsp;</span><input name="id" type="text" class="easyui-textbox easyui-numberbox" style="width:100px" data-options="validType:'number'"> 
        <span style="margin-left: 15px">寄件人地址 &nbsp;</span><input name="senderaddr" type="text" class="easyui-textbox " style="width:100px" >  
        <span style="margin-left: 15px">收件人地址 &nbsp;</span><input name="receiveraddr" type="text" class="easyui-textbox " style="width:100px" >  
        </form>
        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:false" onclick="otherQuery2()">查询</a> 
      </td>
      </tr>
    </table>
    </div> 
    
    

<div region="center" border="false">	
<table id="grid"  data-options="onDblClickRow: doDblClickRow" >
	<thead>
		<tr>
			<th field="xxx" data-options="checkbox : true" ></th>
			<th field="id" data-options="width : 120,title : '合包号',align : 'center',checkbox : false" ></th>
			<th field="combinepeople" data-options="width : 120,title : '合包人',align : 'center'" ></th>
			<th field="sealId" data-options="width : 120,title : '封签号',align : 'center',checkbox : false" ></th>
			<th field="destination" data-options="width : 120,title : '到达地',align : 'center'" ></th>
			<th field="count_destination" data-options="width : 120,title : '计算到达地',align : 'center'"  ></th>
			<th field="timelimit" data-options="width : 120,title : '送达时限',align : 'center'" ></th>
			<th field="piaoshu" data-options="width : 120,title : '总票数',align : 'center'" ></th>
			<th field="jiangshu" data-options="width : 120,title : '总件数',align : 'center',checkbox : false" ></th>
			<th field="weight" data-options="width : 120,title : '总重量',align : 'center'" ></th>
			<th field="vol" data-options="width : 120,title : '总体积',align : 'center'" ></th>
			<th field="status" data-options="width : 120,title : '状态',align : 'center',formatter : function(data, row, index) {if (data == '0') {return '已合包';}else {return '已拆包';}}"  ></th>
			<th field="peizai" data-options="width : 120,title : '配载要求',align : 'center'" ></th>
		</tr>
	</thead>
  </table>  
</div>  
  

	<div  region="south" border="false" style="height:150px;" >
	<div id="tabs" fit="true" class="easyui-tabs">
			<div title="合包明细" style="width:100%;height:100%;overflow:hidden">
				<table id="association_combinedetails"></table>
			</div>	
		</div>
	</div>
	
	
		<!-- 添加修改合包 -->
	<div class="easyui-window" title="合包添加修改" id="addWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px;">
		<div style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true" >保存</a>
			</div>
		</div>
		
		<div style="overflow:auto;padding:5px;" border="false">
			<form id="formAdd">
				<table class="table-edit" width="100%" align="center">
					<tr class="title">
						<td colspan="2">合包信息</td>
					</tr>
					<tr>
						<td>到达地</td>
						<td><input type="text" name="destination" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>送达时限</td>
						<td><input type="text" name="timelimit" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>总件数</td>
						<td><input type="text" name="jiangshu" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>总重量</td>
						<td><input type="text" name="weight" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>总体积</td>
						<td><input type="text" name="vol" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>配载要求</td>
						<td><input type="text" name="peizai" class="easyui-validatebox" required="true"/></td>
					</tr>
					
					<tr height="300" id="guanlianworkorder">
						<td valign="top">关联工作单</td>
						<td>
							<table id="subareaGrid" style="width:580px;height:300px;"  class="easyui-datagrid" border="false"   data-options="url:'${pageContext.request.contextPath}/workorder/findBypage',fitColumns:true,singleSelect:false,pagination : true,	toolbar : '#tb2',pageSize : 4,pageList : [ 2,4,8]"  >
								<thead>  
							        <tr>  
							            <th field="xxx" data-options="checkbox : true" ></th>
										<th field="id" data-options="width : 120,title : '工作单号',align : 'center',checkbox : false" ></th>
							            <th data-options="field:'sendername',width:120">寄件人姓名</th>  
							            <th data-options="field:'senderphone',width:120">寄件人电话</th>  
							            <th data-options="field:'senderaddr',width:120">寄件人地址</th>  
							            <th data-options="field:'receivername',width:120">收件人姓名</th>  
							            <th data-options="field:'receiverphone',width:120">收件人电话</th>  
							            <th data-options="field:'receiveraddr',width:120">收件人地址</th>  
							        </tr>  
							    </thead> 
							</table>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
	
	

	 
</body>
</html>
