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

<script type="text/javascript">
	var editIndex ;//全局变量
	
	function doEdit(){
		if(editIndex != undefined){
			$("#grid").datagrid('endEdit',editIndex);
		}
		if(editIndex==undefined){
			//alert("快速添加电子单...");
			$("#grid").datagrid('insertRow',{
				index : 0,
				row : {}
			});
			$("#grid").datagrid('beginEdit',0);
			editIndex = 0;
		}
	}
	
	function doSave(){
		$("#grid").datagrid('endEdit',editIndex );
	}
	
	function doCancel(){
		if(editIndex!=undefined){
			$("#grid").datagrid('cancelEdit',editIndex);
			if($('#grid').datagrid('getRows')[editIndex].id == undefined){
				$("#grid").datagrid('deleteRow',editIndex);
			}
			editIndex = undefined;
		}
	}
	
	//工具栏
	var toolbar = [{
		id : 'button-add',	
		text : '新增一行',
		iconCls : 'icon-edit',
		handler : doEdit
	}, {
		id : 'button-cancel',
		text : '取消编辑',
		iconCls : 'icon-cancel',
		handler : doCancel
	}, {
		id : 'button-save',
		text : '保存',
		iconCls : 'icon-save',
		handler : doSave
	}];
	// 定义列
	var columns = [ [ {
		field : 'workorderId',
		title : '工作单号',
		width : 120,
		align : 'center',
		editor :{
			type : 'validatebox',
			options : {
				required: true
			}
		}
	}, {
		field : 'qianshoupeople',
		title : '签收人',
		width : 120,
		align : 'center',
		editor :{
			type : 'validatebox'
		}
	}, {
		field : 'staffId',
		title : '派送员工号',
		width : 120,
		align : 'center',
		editor :{
			type : 'validatebox'
		}
	}, {
		field : 'staffname',
		title : '派送员名称',
		width : 120,
		align : 'center',
		editor :{
			type : 'validatebox'
		}
	}, {
		field : 'deliveryunit',
		title : '派件单位',
		width : 120,
		align : 'center',
		editor :{
			type : 'validatebox',
			options : {
				required: true
			}
		}
	}, {
		field : 'qianshoutime',
		title : '签收时间',
		width : 120,
		align : 'center',
		editor :{
			type : 'datetimebox'
		}
	},
	{
		field : 'type',
		title : '签收类型',
		width : 120,
		align : 'center',
		editor :{
			type:'combobox',
			   options:{
               	data: [{'code':'0','name':'正常签收','selected':true},{'code':'1','name':'取消签收'}]  ,
                   valueField:'code',
                   textField:'name'
                   }
		},
		formatter : function(data, row, index) {
		{if (data == '0') {return '正常签收';}
		else if (data == '1') {return '取消签收';}
		else {return '无';}}
		}
		
	}
	] ];
	
	$(function(){
		// 先将body隐藏，再显示，不会出现页面刷新效果
		$("body").css({visibility:"visible"});
		
		// 收派标准数据表格
		$('#grid').datagrid( {
			iconCls : 'icon-forward',
			fit : true,
			border : true,
			striped : false,
			toolbar : toolbar,
			url :  "",
			idField : 'id',
			columns : columns,
			onAfterEdit : function(rowIndex, rowData, changes){
				console.info(rowData);
				editIndex = undefined;
				$.post('${pageContext.request.contextPath }/qianshoubill/addQianshoubillQuick',rowData,function(data){
					if(true!=data){
						$.messager.alert("提示信息","工作单信息录入失败！","error");
					}
				});
			}
		});
	});


	
</script>
</head>
<body class="easyui-layout" style="visibility:hidden;">



	<div region="center" border="false">
    	<table id="grid"></table>
	</div>
	
	
	
	
</body>
</html>