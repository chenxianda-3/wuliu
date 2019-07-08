<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工作单快速录入</title>
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
	
	init("${pageContext.request.contextPath}/qianshoubill/findBypage");
	
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
		action:'${pageContext.request.contextPath}/qianshoubill/importXls',
		name:'importFile',
		onSubmit:function () {
			var isImportUrl = "${pageContext.request.contextPath}/qianshoubill/isImport";
			importExcWithprogress(isImportUrl,200,200);
		 },
		 onComplete:function (data) {
			 showCloseReload3(data);
		 }
		
	});
	//改变样式插件与easyui的样式有点冲突
	$("#button-import").parent().addClass("easyui-linkbutton l-btn l-btn-small l-btn-plain");
	
});



function save(saveUrl) {
	var rows = $("#subareaGrid").datagrid("getSelections");
	var workorderIds=null;
	if (rows.length >0) {
		var array = new Array();
		//确定,发送请求
		//获取所有选中的取派员的id
		for (var i = 0; i < rows.length; i++) {
			var object = rows[i];//json对象
			var workorderId = object.workorderId;
			array.push(workorderId);
		}
		workorderIds = array.join(",");//1,2,3,4,5
	}
	
	$('#formAdd').form({
		url : saveUrl,
		onSubmit: function (param) {
			param.workorderIds = workorderIds
			param.type="0";
		    },
		error : function() {
			alert("网络出现错误！");
		},
		success : function(data) {
			showCloseReload(data);
			  $("#subareaGrid").datagrid('load',obj);
		}
	});
	// submit the form    
	$('#formAdd').submit();
}


function cancelsave(cancelsaveUrl) {
	var rows = $("#subareaGrid").datagrid("getSelections");
	var workorderIds=null;
	if (rows.length >0) {
		var array = new Array();
		//确定,发送请求
		//获取所有选中的取派员的id
		for (var i = 0; i < rows.length; i++) {
			var object = rows[i];//json对象
			var workorderId = object.workorderId;
			array.push(workorderId);
		}
		workorderIds = array.join(",");//1,2,3,4,5
	}
	
	$('#formAdd').form({
		url : cancelsaveUrl,
		onSubmit: function (param) {
			param.workorderIds = workorderIds
			param.type="1";
		    },
		error : function() {
			alert("网络出现错误！");
		},
		success : function(data) {
			showCloseReload(data);
			  $("#subareaGrid").datagrid('load',obj);
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
	
	function doDelete(deleteBatchUrl) {
		//获取数据表格中所有选中的行，返回数组对象
		var rows = $("#grid").datagrid("getSelections");
		if (rows.length == 0) {
			//没有选中记录，弹出提示
			$.messager.alert("提示信息", "请选择需要删除的条目！", "warning");
		} else {
			//选中了取派员,弹出确认框
			$.messager
					.confirm("删除确认","你确定要删除选中的条目吗？",
							function(r) {
								if (r) {

									var array = new Array();
									//确定,发送请求
									//获取所有选中的取派员的id
									for (var i = 0; i < rows.length; i++) {
										var object = rows[i];//json对象
										var id = object.workorderId;
										array.push(id);
									}
									var ids = array.join(",");//1,2,3,4,5
									$.ajax({
												type : "get",
												url : deleteBatchUrl+ ids,
												error : function() {
													alert("网络出现错误！");
												},
												success : function(data) {
													showCloseReload2(data);
													$("#subareaGrid").datagrid('load',obj);
												}
											});

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
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="doAdd('${pageContext.request.contextPath }/qianshoubill/addQianshoubill')">新增</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="doUpdate('${pageContext.request.contextPath}/qianshoubill/findById?id=','${pageContext.request.contextPath }/qianshoubill/updateById')">修改</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="doDelete('${pageContext.request.contextPath }/qianshoubill/deleteBatch?ids=')">删除签收单</a>
        <a  href="#" id="button-import" class="easyui-linkbutton" data-options="iconCls:'icon-redo',plain:true" >导入数据</a>
      <form id="formQuery"  class="easyui-linkbutton" data-options="plain:true" >
       <span style="margin-left: 10px">工作单号&nbsp;</span><input name="workorderId" type="text" class="easyui-textbox" style="width:100px"> 
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
        <span style="margin-left: 15px">工作单号&nbsp;</span><input name="workorderId" type="text" class="easyui-textbox " style="width:100px" >  
        </form>
        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:false" onclick="otherQuery2()">查询</a> 
      </td>
      </tr>
    </table>
    </div> 
	

<div region="center" border="false">	
<table id="grid"   >
	<thead>
		<tr>
			<th field="xxx" data-options="checkbox : true" ></th>
			<th field="workorderId" data-options="width : 120,title : '工作单号',align : 'center',checkbox : false" ></th>
			<th field="qianshoupeople" data-options="width : 120,title : '签收人',align : 'center'" ></th>
			<th field="staffId" data-options="width : 120,title : '派送员工号',align : 'center'" ></th>
			<th field="staffname" data-options="width : 120,title : '派送员名称',align : 'center'" ></th>
			<th field="deliveryunit" data-options="width : 120,title : '派件单位',align : 'center'"  ></th>
			<th field="qianshoutime" data-options="width : 120,title : '签收时间',align : 'center'" ></th>
			<th field="type" data-options="width : 120,title : '签收类型',align : 'center',formatter : function(data, row, index) {if (data == '0') {return '正常签收';}else if (data == '1') {return '取消签收';}else {return '无';}}" ></th>
		</tr>
	</thead>
  </table>  
</div>  
	
	
	
	
	

		<div class="easyui-window" title="签收单添加" id="addWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px;">
		<div style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				 <a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true" >签收</a>
     			 <a id="cancelsave" onclick="cancelsave('${pageContext.request.contextPath }/qianshoubill/addQianshoubill')" icon="icon-cancel" href="#" class="easyui-linkbutton" plain="true" >拒签</a>
			</div>
		</div>
		
		<div style="overflow:auto;padding:5px;" border="false">
			<form id="formAdd" method="post">
				<table class="table-edit" width="100%" align="center">
					<tr height="300" id="guanlianworkorder">
						<td valign="top">已入站工作单</td>
						<td>
							<table id="subareaGrid" style="width:580px;height:300px;"  class="easyui-datagrid" border="false"   data-options="url:'${pageContext.request.contextPath}/fendanbill/findFendanedToDeliveryunit',fitColumns:true,singleSelect:false,pagination : true,	toolbar : '#tb2',pageSize:10,pageList : [ 4,8,10]"  >
								<thead>  
							        <tr>  
							            <th field="" data-options="checkbox : true" ></th>
										<th field="workorderId" data-options="width : 120,title : '工作单号',align : 'center'" ></th>
										<th field="timelimit" data-options="width : 50,title : '送达时限',align : 'center'" ></th>
										<th field="address" data-options="width : 200,title : '货物地址',align : 'center'" ></th>
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