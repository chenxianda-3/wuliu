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
	
	init("${pageContext.request.contextPath}/railwayline/findBypage");

	//onclickup插件的初始化，提供上传时候的用户交互
	$("#button-import").upload({
		action:'${pageContext.request.contextPath}/railwayline/importXls',
		name:'importFile',
		onSubmit:function () {
			var isImportUrl = "${pageContext.request.contextPath}/railwayline/isImport";
			importExcWithprogress(isImportUrl,200,200);
		 },
		 onComplete:function (data) {
			 showCloseReload3(data);
		 }
		
	});
	//改变样式插件与easyui的样式有点冲突
	$("#button-import").parent().addClass("easyui-linkbutton l-btn l-btn-small l-btn-plain");
	
});



</script>
</head>
<body   style="visibility: hidden;" >

 <div id="tb" style="padding:5px;height:auto">
 <table cellpadding="0" cellspacing="0" style="width: 100%">
    <tr >
      <td>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="doAdd('${pageContext.request.contextPath }/railwayline/addRailwayline')">新增</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="doUpdate('${pageContext.request.contextPath}/railwayline/findById?id=','${pageContext.request.contextPath }/railwayline/updateById')">修改</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="doDelete('${pageContext.request.contextPath }/railwayline/deleteBatch?ids=')">删除</a>
        <a  href="#" id="button-import" class="easyui-linkbutton" data-options="iconCls:'icon-redo',plain:true" >导入</a>
      <form id="formQuery"  class="easyui-linkbutton" data-options="plain:true" >
       <span style="margin-left: 10px">铁路线路编码&nbsp;</span><input name="id" type="text" class="easyui-textbox easyui-numberbox" style="width:100px" data-options="validType:'length[0,32]',validType:'isBlank'"> 
        <span style="margin-left: 30px">列车号 &nbsp;</span><input name="name" type="text" class="easyui-textbox easyui-validatebox" style="width:100px" data-options="validType:'name'"> 
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
			<th field="id" data-options="width : 120,title : '铁路线路编码',align : 'center',checkbox : false" ></th>
			<th field="trainnum" data-options="width : 120,title : '列车号',align : 'center'" ></th>
			<th field="transferpri" data-options="width : 120,title : '中转优先级',align : 'center',checkbox : false" ></th>
			<th field="directpri" data-options="width : 120,title : '直达优先级',align : 'center'" ></th>
			<th field="status" data-options="width : 120,title : '状态',align : 'center',formatter : function(data, row, index) {if (data == '0') {return '自由';}else if (data == '1') {return '分析';} else if (data == '2') {return '正式';}else if (data == '3') {return '分析作废';}else {return '正式作废';}}"  ></th>
			<th field="startcity" data-options="width : 120,title : '起始城市',align : 'center'" ></th>
			<th field="startstation" data-options="width : 120,title : '起始火车站',align : 'center'" ></th>
			<th field="outcenter" data-options="width : 120,title : '出港运转中心',align : 'center',checkbox : false" ></th>
			<th field="outpici" data-options="width : 120,title : '出港批次',align : 'center'" ></th>
			<th field="starttime" data-options="width : 120,title : '发时',align : 'center'" ></th>
			<th field="endtime" data-options="width : 120,title : '到时',align : 'center'"  ></th>
			<th field="tianshu" data-options="width : 120,title : '途径天数',align : 'center'" ></th>
			<th field="mileage" data-options="width : 120,title : '里程',align : 'center',checkbox : false" ></th>
			<th field="unitprice" data-options="width : 120,title : '成本单价',align : 'center',checkbox : false" ></th>
			<th field="inpici" data-options="width : 120,title : '进港批次',align : 'center'" ></th>
			<th field="intcenter" data-options="width : 120,title : '进港运转中心',align : 'center'" ></th>
			<th field="endcity" data-options="width : 120,title : '到达城市',align : 'center'"  ></th>
			<th field="endstation" data-options="width : 120,title : '到达火车站',align : 'center'"  ></th>
			<th field="transferpici" data-options="width : 120,title : '中转批次',align : 'center'" ></th>
			<th field="transfercenter" data-options="width : 120,title : '中转运转中心',align : 'center',checkbox : false" ></th>
			<th field="inputperson" data-options="width : 120,title : '录入人',align : 'center'"  ></th>
			<th field="inputtime" data-options="width : 120,title : '录入时间',align : 'center'" ></th>
		</tr>
	</thead>
  </table>  


	 
</body>
</html>
