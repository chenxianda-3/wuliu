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

$(function (){
	init("${pageContext.request.contextPath}/routebill/findByStartToEnd");
});



function otherQuery(){
 	var formSerialize =$("#formQuery").form().serializeArray();
 	var obj=serializeObject(formSerialize);
 	if(false==obj){
 		return false;
 	}
 	$("#grid").datagrid('load',obj);

    

}


function doDblClickRow(index,data){

	//创建展示客户数据的数据表格
	$('#association_routelinebill').datagrid( {
		fit : true,
		border : true,
		rownumbers : true,
		striped : true,
		url : "${pageContext.request.contextPath}/routebill/findLineByRoutebillId?id="+data.id,
		columns : [[{
			field : 'id',
			title : '路由线路表编号',
			width : 120,
			align : 'center'
		},{
			field : 'linename',
			title : '线路名称',
			width : 120,
			align : 'center'
		}
		,{
			field : 'startstation',
			title : '开始站',
			width : 120,
			align : 'center'
		},{
			field : 'endstation',
			title : '结束站',
			width : 120,
			align : 'center'
		},{
			field : 'starttime',
			title : '开始时间',
			width : 120,
			align : 'center'
		},{
			field : 'endtime',
			title : '结束时间',
			width : 120,
			align : 'center'
		},{
			field : 'lineprice',
			title : '线路成本单价',
			width : 120,
			align : 'center'
		},{
			field : 'mileage',
			title : '里程',
			width : 120,
			align : 'center'
		},{
			field : 'tianshu',
			title : '途径天数',
			width : 120,
			align : 'center'
		}
		, {
			field : 'pici',
			title : '批次',
			width : 120,
			align : 'center'
		}]]
	});
	
}

function doUpdate(url) {
	var rows = $("#grid").datagrid("getSelections");
	if (rows.length == 0 || rows.length > 1) {
		//没有选中记录，弹出提示
		$.messager.alert("提示信息", "有且需要选中一条记录", "warning");
	} else {
		var object = rows[0];//json对象
		var id = object.id;
		
		$.ajax({
			type : "get",
			url : url+ id,
			error : function() {
				alert("网络出现错误！");
			},
			success : function(data) {
				showCloseReload(data);
			}
		});
		
	}
	
		
		
}



</script>
</head>
<body  class="easyui-layout"  style="visibility: hidden;" >

 <div id="tb" style="padding:5px;height:auto">
 <table cellpadding="0" cellspacing="0" style="width: 100%">
    <tr >
      <td>
        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:false" onclick="doUpdate('${pageContext.request.contextPath }/routebill/tongBu?id=')">同步</a> 
      <form id="formQuery"  class="easyui-linkbutton" data-options="plain:true" >
       <span style="margin-left: 10px">发站省&nbsp;</span><input name="" type="text" class="easyui-textbox" style="width:100px" > 
        <span style="margin-left: 10px">发站市&nbsp;</span><input name="startstation" type="text" class="easyui-textbox" style="width:100px" >
        <span style="margin-left: 10px">发站区&nbsp;</span><input name="" type="text" class="easyui-textbox" style="width:100px" >
        <span style="margin-left: 10px">到站省&nbsp;</span><input name="" type="text" class="easyui-textbox" style="width:100px" >
        <span style="margin-left: 10px">到站市&nbsp;</span><input name="endstation" type="text" class="easyui-textbox" style="width:100px" >
        <span style="margin-left: 10px">到站区&nbsp;</span><input name="" type="text" class="easyui-textbox" style="width:100px" >
        <span style="margin-left: 10px">路由时限&nbsp;</span><select name="tianshus" type="text"  class="easyui-combobox"  multiple="multiple" style="width:100px" > <option value="1">一天</option><option value="2">两天</option><option value="3">三天</option><option value="4">四天</option></select>
        </form>
        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:false" onclick="otherQuery()">查询</a> 
      </td>
      </tr>
    </table>
    </div>



<div region="center" border="false">
<table id="grid"  data-options="onDblClickRow: doDblClickRow,remoteSort:false,multiSort:false"  >
	<thead>
		<tr>
			<th field="xxx" data-options="checkbox : true" ></th>
			<th field="id" data-options="title : '独立节点路由编号',hidden:true,align : 'center',checkbox : false" ></th>
			<th field="name" data-options="width : 200,title : '独立节点路由名称',align : 'center'" ></th>
			<th field="timelimit" data-options="width : 120,title : '时限(天)',align : 'center',sortable:'true'" ></th>
			
			<th field="sumDuration" data-options="width : 120,title : '用时(小时)',align : 'center',sortable:'true',formatter : function(data, row, index) {if (data !=null) {
		var nd = 1000 * 24 * 60 * 60;
		var nh = 1000 * 60 * 60;
		var nm = 1000 * 60;
		var day = data / nd;
		var hour = data / nh;
		var min = data % nd % nh / nm;
		var sec = data % nd % nh % nm / 1000;
		return hour;} else {return '无';}} " ></th>
			<th field="mileage" data-options="width : 120,title : '里程（公里）',align : 'center',sortable:'true'" ></th>
			<th field="routeprice" data-options="width : 120,title : '路由成本（元）',align : 'center',sortable:'true'" ></th>
			<th field="startcity" data-options="width : 120,title : '发站市',align : 'center'" ></th>
			<th field="endcity" data-options="width : 120,title : '到站市',align : 'center',checkbox : false" ></th>
			<th field="transfernode1" data-options="width : 120,title : '中转节点1',align : 'center'"  ></th>
			<th field="transfernode2" data-options="width : 120,title : '中转节点2',align : 'center'" ></th>
			<th field="transfernode3" data-options="width : 120,title : '中转节点3',align : 'center',checkbox : false" ></th>
			<th field="transfernode4" data-options="width : 120,title : '中转节点4',align : 'center',checkbox : false" ></th>
			<th field="weight" data-options="width : 120,title : '承载实际重量',align : 'center'"  ></th>
			<th field="vol" data-options="width : 120,title : '承载实际体积',align : 'center'"  ></th>
		</tr>
	</thead>
  </table>  
</div>


	<div  region="south" border="false" style="height:150px;" >
	<div id="tabs" fit="true" class="easyui-tabs">
			<div title="途径路线" style="width:100%;height:100%;overflow:hidden">
				<table id="association_routelinebill"></table>
			</div>	
		</div>
	</div>
	 
</body>
</html>
