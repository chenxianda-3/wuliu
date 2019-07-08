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
	
	$('#association_peizaied').datagrid( {
		fit : true,
		border : true,
		rownumbers : true,
		pagination : true,
		pageSize : 20,
		pageList : [ 2, 20, 30, 50 ],
		toolbar : '#tb',
		striped : true,
		url : "${pageContext.request.contextPath}/peizaiinfo/findBypageOfPeizaied",
		columns : [ [{
			field : '',
			checkbox : true
		},{
			field : 'workorderId',
			title : '工作单号',
			width : 120,
			align : 'center'
		},{
			field : 'combineId',
			title : '合包号',
			width : 120,
			align : 'center'
		
		}, {
			field : 'operateunit',
			title : '操作单位',
			width : 120,
			align : 'center'
		}, {
			field : 'lineId',
			title : '航班车次',
			width : 120,
			align : 'center'
		}, {
			field : 'product',
			title : '品名',
			width : 100,
			align : 'center'
		}, {
			field : 'jiangshu',
			title : '件数',
			width : 100,
			align : 'center'
		} , {
			field : 'weight',
			title : '重量',
			width : 100,
			align : 'center'
		} , {
			field : 'endcity',
			title : '到达地',
			width : 100,
			align : 'center'
		} , {
			field : 'timelimit',
			title : '送达时限',
			width : 100,
			align : 'center'
		} , {
			field : 'peizai',
			title : '配载要求',
			width : 100,
			align : 'center'
		} , {
			field : 'shouhuopeople',
			title : '收货人',
			width : 100,
			align : 'center'
		} , {
			field : 'shouhuoaddress',
			title : '收货地址',
			width : 200,
			align : 'center'
		}, {
			field : 'peizaiway',
			title : '配载方式',
			width : 120,
			align : 'center',
			formatter : function(data,row ,index){
				if(row.peizaiway=="0"){
					return "航空";
				}else if (row.peizaiway=="0"){
					return "铁路";
				}else if (row.peizaiway=="1"){
					return "海运";
				}else if (row.peizaiway=="2"){
					return "航空";
				}else if (row.peizaiway=="3"){
					return "干线物流";
				}else if (row.peizaiway=="4"){
					return "支线物流";
				}
				else {
					return "无";
				}
			}
		} ] ]
	});
	
	//创建展示客户数据的数据表格
	$('#association_nopeizai').datagrid( {
		fit : true,
		border : true,
		rownumbers : true,
		pagination : true,
		toolbar : '#tb2',
		pageSize : 20,
		pageList : [ 2, 20, 30, 50 ],
		striped : true,
		url : "${pageContext.request.contextPath}/peizaiinfo/findBypageOfNoPeizai",
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
	
	// 站点线路资源菜单加载
	$.ajax({
		url : '${pageContext.request.contextPath}/peizaiinfo/findZtree',
		type : 'get',
		dataType : 'text',
		success : function(data) {
			if(null==data || ""==data){
				$.messager.alert("错误信息","请先登录","error");
			}
			
			 var zNodes = JSON.parse(data);
			 let treeObj=$.fn.zTree.init($("#lineresourceMenu"), setting, zNodes); 
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
	$('#tabs').tabs('select', '已配载'); 

	
	
}


function otherQuery(){
 	var formSerialize =$("#formQuery").form().serializeArray();
 	var obj=serializeObject(formSerialize);
 	if(false==obj){
 		return false;
 	}
    $("#association_peizaied").datagrid('load',obj);

}

function otherQuery2(){
 	var formSerialize =$("#formQuery2").form().serializeArray();
 	var obj=serializeObject(formSerialize);
 	if(false==obj){
 		return false;
 	}
    $("#association_nopeizai").datagrid('load',obj);

}

function  doHand(url){
	var treeObj = $.fn.zTree.getZTreeObj("lineresourceMenu");
	var nodes = treeObj.getSelectedNodes();
	//获取数据表格中所有选中的行，返回数组对象
	var rows = $("#association_nopeizai").datagrid("getSelections");
	if (rows.length == 0) {
		//没有选中记录，弹出提示
		$.messager.alert("提示信息", "请选择需要配载的条目！", "warning");
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
			url : url+ workorderIds+"&lineId="+nodes[0].id,
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
    	$("#association_nopeizai").datagrid("reload");
    	$("#association_peizaied").datagrid("reload");
	}else{
		message="后台发生错误";
		$.messager.alert("错误信息",message,"error");
	}
	 
}



function doDelete(deleteBatchUrl) {
	//获取数据表格中所有选中的行，返回数组对象
	var rows = $("#association_peizaied").datagrid("getSelections");
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
      <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="doDelete('${pageContext.request.contextPath }/peizaiinfo/deleteBatch?ids=')">取消配载</a>
      <form id="formQuery"  class="easyui-linkbutton" data-options="plain:true" >
       <span style="margin-left: 10px">工作单号&nbsp;</span><input name="workorderId" type="text" class="easyui-textbox " style="width:100px" > 
        <span style="margin-left: 30px">合包人 &nbsp;</span><input name="combineId" type="text" class="easyui-textbox " style="width:100px"> 
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
      	 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-blank',plain:true" onclick="doHand('${pageContext.request.contextPath }/peizaiinfo/handPeizai?workorderIds=')">手动配载</a>
       	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-blank',plain:true" onclick="doAuto('${pageContext.request.contextPath }/peizaiinfo/autoPeizai')">自动配载</a>
        <form id="formQuery2"  class="easyui-linkbutton" data-options="plain:true" >
         <span style="margin-left: 10px">工作单号&nbsp;</span><input name="workorderId" type="text" class="easyui-textbox " style="width:100px" > 
        <span style="margin-left: 30px">合包人 &nbsp;</span><input name="combineId" type="text" class="easyui-textbox " style="width:100px"> 
        </form>
        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:false" onclick="otherQuery2()">查询</a> 
      </td>
      </tr>
    </table>
    </div> 
    
    


	<div data-options="region:'west',split:true" style="width:300px">
	<ul id="lineresourceMenu" class="ztree"></ul>
	</div>
	<div data-options="region:'center'">
	
	<div id="tabs" fit="true" class="easyui-tabs">
		<div title="已配载" id="peizaied"
			style="width:100%;height:100%;overflow:hidden">
			<table id="association_peizaied"></table>
		</div>	
		<div title="待配载" id="nopeizai"
			style="width:100%;height:100%;overflow:hidden">
			<table id="association_nopeizai"></table>
		</div>	
	</div>
	</div>




	
	

	 
</body>
</html>
