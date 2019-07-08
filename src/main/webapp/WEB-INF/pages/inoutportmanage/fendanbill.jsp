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
<!-- 导入ztree类库 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/js/ztree/zTreeStyle.css"
	type="text/css" />
<script
	src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.all-3.5.js"
	type="text/javascript"></script>
	
<script
src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
type="text/javascript"></script>

<script src="${pageContext.request.contextPath }/js/common/crud.js"
	type="text/javascript"></script>
<script type="text/javascript">


$(function (){
	$("body").css({
		visibility : "visible"
	});
	
	$('#association_fendaned').datagrid( {
		fit : true,
		border : true,
		rownumbers : true,
		pagination : true,
		pageSize : 20,
		pageList : [ 2, 20, 30, 50 ],
		toolbar : '#tb',
		striped : true,
		url : "${pageContext.request.contextPath}/fendanbill/findBypageOfFendaned",
		columns : [ [{
			field : '',
			checkbox : true
		},{
			field : 'workorderId',
			title : '工作单号',
			width : 120,
			align : 'center'
		},{
			field : 'transfercenter',
			title : '运转中心名称',
			width : 120,
			align : 'center'
		
		}, {
			field : 'deliveryunitId',
			title : '派送单位编号',
			width : 120,
			align : 'center'
		}, {
			field : 'timelimit',
			title : '送达时限',
			width : 100,
			align : 'center'
		}, {
			field : 'inpici',
			title : '进港分拨批次',
			width : 100,
			align : 'center'
		} , {
			field : 'address',
			title : '货物地址',
			width : 100,
			align : 'center'
		} , {
			field : 'status',
			title : '货物状态',
			width : 100,
			align : 'center'
		} , {
			field : 'fendantime',
			title : '分单时间',
			width : 100,
			align : 'center'
		} , {
			field : 'fendanpeople',
			title : '分单人',
			width : 100,
			align : 'center'
		} ] ]
	});
	
	//创建展示客户数据的数据表格
	$('#association_nofendan').datagrid( {
		fit : true,
		border : true,
		rownumbers : true,
		pagination : true,
		toolbar : '#tb2',
		pageSize : 20,
		pageList : [ 2, 20, 30, 50 ],
		striped : true,
		url : "${pageContext.request.contextPath}/fendanbill/findBypageOfNoFendan",
		columns : [[{
			field : '',
			checkbox : true
		},{
			field : 'workorderId',
			title : '工作单号',
			width : 120,
			align : 'center'
		},{
			field : 'combinebillId',
			title : '合包号',
			width : 120,
			align : 'center'
		},{
			field : 'weight',
			title : '重量',
			width : 120,
			align : 'center'
		},{
			field : 'workorder.receiveraddr',
			title : '到达地址',
			width : 200,
			align : 'center',
			formatter:function(value,row,index){
				var data= row.workorder;
				if(null!=data){
					return data.receiveraddr;
				}else{
				return '无';}
				}
		}, {
			field : 'chukubillId',
			title : '关联出库交接单号',
			width : 120,
			align : 'center'
		}]]
	});
	
	
	
	var setting = {
			data : {
				simpleData : { // 简单数据 
					enable : true
				}
			},
			callback : {
				onClick : onClick
			}
		};
	
	// 派送单位菜单加载
	$.ajax({
		url : '${pageContext.request.contextPath}/fendanbill/findZtree',
		type : 'get',
		dataType : 'text',
		success : function(data) {
			if(null==data || ""==data){
				$.messager.alert("错误信息","请先登录","error");
			}
			
			 var zNodes = JSON.parse(data);
			 let treeObj=$.fn.zTree.init($("#deliveryunitMenu"), setting, zNodes); 
			 treeObj.expandAll(true);    //默认展开
			 var nodes = treeObj.getNodes();  
			 if (nodes.length > 0) {
			     var node = treeObj.selectNode(nodes[0]);//默认选中根节点
			 }
		
		},
		error : function(msg) {
			alert('菜单加载异常!');
		}
	});
	
	
	
	
});


function onClick(event, treeId, treeNode, clickFlag) {
	var treeObj = $.fn.zTree.getZTreeObj("deliveryunitMenu");
	var nodes = treeObj.getSelectedNodes();
	$("#association_fendaned").datagrid('load',{    
	    deliveryunitId: nodes[0].id   
	});
	$('#tabs').tabs('select', '已分单'); 
	
}


function otherQuery(){
 	var formSerialize =$("#formQuery").form().serializeArray();
 	var obj=serializeObject(formSerialize);
 	if(false==obj){
 		return false;
 	}
    $("#association_fendaned").datagrid('load',obj);

}

function otherQuery2(){
 	var formSerialize =$("#formQuery2").form().serializeArray();
 	var obj=serializeObject(formSerialize);
 	if(false==obj){
 		return false;
 	}
    $("#association_nofendan").datagrid('load',obj);

}

function  doHand(url){
	var treeObj = $.fn.zTree.getZTreeObj("deliveryunitMenu");
	var nodes = treeObj.getSelectedNodes();
	//获取数据表格中所有选中的行，返回数组对象
	var rows = $("#association_nofendan").datagrid("getSelections");
	if (rows.length == 0) {
		//没有选中记录，弹出提示
		$.messager.alert("提示信息", "请选择需要分单的条目！", "warning");
	} else {
		var array = new Array();
		//确定,发送请求
		//获取所有选中的取派员的id
		for (var i = 0; i < rows.length; i++) {
			var object = rows[i];//json对象
			var workorderId = object.workorderId;
			array.push(workorderId);
		}
		var workorderIds = array.join(",");//1,2,3,4,5
		$.ajax({
			type : "get",
			url : url+ workorderIds+"&deliveryunitId="+nodes[0].id,
			error : function() {
				alert("网络出现错误！");
			},
			success : function(data) {
				showCloseReload2(data);
			}
		});
	}
}


function doAuto(url){
	$.ajax({
		type : "get",
		url : url,
		error : function() {
			alert("网络出现错误！");
		},
		success : function(data) {
			showCloseReload2(data);
		}
	});
}


function showCloseReload2(data){
	var message;
	if(true==data){
		message="成功!!!";
		$.messager.show({
    		title:'提示消息',
    		msg:message,
    		timeout:4000,
    		showType:'slide'
    	});
    	// 关闭窗口:
    	$("#addWindow").window("close");
    	// 重新加载数据:
    	$("#association_nofendan").datagrid("reload");
    	$("#association_fendaned").datagrid("reload");
	}else{
		message="后台发生错误";
		$.messager.alert("错误信息",message,"error");
	}
	 
}



function doDelete(deleteBatchUrl) {
	//获取数据表格中所有选中的行，返回数组对象
	var rows = $("#association_fendaned").datagrid("getSelections");
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
											}
										});

							}
						});
	}
}


</script>
</head>
<body class="easyui-layout"   style="visibility: hidden;" >

 <div id="tb" style="padding:5px;height:auto">
 <table cellpadding="0" cellspacing="0" style="width: 100%">
    <tr >
      <td>
      <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="doDelete('${pageContext.request.contextPath }/fendanbill/deleteBatch?ids=')">取消分单</a>
      <form id="formQuery"  class="easyui-linkbutton" data-options="plain:true" >
       <span style="margin-left: 10px">工作单号&nbsp;</span><input name="workorderId" type="text" class="easyui-textbox " style="width:100px" > 
        <span style="margin-left: 30px">分单人 &nbsp;</span><input name="fendanpeople" type="text" class="easyui-textbox " style="width:100px"> 
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
      	 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-blank',plain:true" onclick="doHand('${pageContext.request.contextPath }/fendanbill/handFendan?workorderIds=')">手动分单</a>
       	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-blank',plain:true" onclick="doAuto('${pageContext.request.contextPath }/fendanbill/autoFendan')">自动分单</a>
        <form id="formQuery2"  class="easyui-linkbutton" data-options="plain:true" >
         <span style="margin-left: 10px">工作单号&nbsp;</span><input name="workorderId" type="text" class="easyui-textbox " style="width:100px" > 
        </form>
        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:false" onclick="otherQuery2()">查询</a> 
      </td>
      </tr>
    </table>
    </div> 
    
    


	<div data-options="region:'west',split:true" style="width:300px">
	<ul id="deliveryunitMenu" class="ztree"></ul>
	</div>
	<div data-options="region:'center'">
	
	<div id="tabs" fit="true" class="easyui-tabs">
		<div title="已分单" id="fendaned"
			style="width:100%;height:100%;overflow:hidden">
			<table id="association_fendaned"></table>
		</div>	
		<div title="待分单" id="nofendan"
			style="width:100%;height:100%;overflow:hidden">
			<table id="association_nofendan"></table>
		</div>	
	</div>
	</div>




	
	

	 
</body>
</html>
