<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>年华士达物流管理系统</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<!-- 导入easyui类库 -->
<link id="easyuiTheme" rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/default.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>
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
<script type="text/javascript">
	// 初始化ztree菜单
	$(function() {
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
		
		// 基础数据菜单加载
		$.ajax({
			url : '${pageContext.request.contextPath}/json/basedata.json',
			type : 'get',
			dataType : 'text',
			success : function(data) {
				var zNodes = eval("(" + data + ")");
				$.fn.zTree.init($("#basedataMenu"), setting, zNodes);
			},
			error : function(msg) {
				alert('菜单加载异常!');
			}
		});
		
		
		// 线路资源菜单加载
		$.ajax({
			url : '${pageContext.request.contextPath}/json/lineresource.json',
			type : 'get',
			dataType : 'text',
			success : function(data) {
				var zNodes = eval("(" + data + ")");
				$.fn.zTree.init($("#lineresource"), setting, zNodes);
			},
			error : function(msg) {
				alert('菜单加载异常!');
			}
		});
		

		// 路由分析菜单加载
		$.ajax({
			url : '${pageContext.request.contextPath}/json/route.json',
			type : 'get',
			dataType : 'text',
			success : function(data) {
				var zNodes = eval("(" + data + ")");
				$.fn.zTree.init($("#route"), setting, zNodes);
			},
			error : function(msg) {
				alert('菜单加载异常!');
			}
		});
		
		
		// 分拣管理加载
		$.ajax({
			url : '${pageContext.request.contextPath}/json/sortingmanage.json',
			type : 'get',
			dataType : 'text',
			success : function(data) {
				var zNodes = eval("(" + data + ")");
				$.fn.zTree.init($("#sortingmanage"), setting, zNodes);
			},
			error : function(msg) {
				alert('菜单加载异常!');
			}
		});
		
		//进出港管理
			$.ajax({
			url : '${pageContext.request.contextPath}/json/inoutportmanage.json',
			type : 'get',
			dataType : 'text',
			success : function(data) {
				var zNodes = eval("(" + data + ")");
				$.fn.zTree.init($("#inoutportmanage"), setting, zNodes);
			},
			error : function(msg) {
				alert('菜单加载异常!');
			}
		});
			
		
		// 受理菜单加载
		$.ajax({
			url : '${pageContext.request.contextPath}/json/shouli.json',
			type : 'get',
			dataType : 'text',
			success : function(data) {
				var zNodes = eval("(" + data + ")");
				$.fn.zTree.init($("#shouliMenu"), setting, zNodes);
			},
			error : function(msg) {
				alert('菜单加载异常!');
			}
		});
		
		
		// 调度菜单加载
		$.ajax({
			url : '${pageContext.request.contextPath}/json/diaodu.json',
			type : 'get',
			dataType : 'text',
			success : function(data) {
				var zNodes = eval("(" + data + ")");
				$.fn.zTree.init($("#diaoduMenu"), setting, zNodes);
			},
			error : function(msg) {
				alert('菜单加载异常!');
			}
		});
		
		// 签单管理菜单加载
		$.ajax({
			url : '${pageContext.request.contextPath}/json/qianshou.json',
			type : 'get',
			dataType : 'text',
			success : function(data) {
				var zNodes = eval("(" + data + ")");
				$.fn.zTree.init($("#qianshouMenu"), setting, zNodes);
			},
			error : function(msg) {
				alert('菜单加载异常!');
			}
		});
		
		
		// 统计单加载
		$.ajax({
			url : '${pageContext.request.contextPath}/json/tongji.json',
			type : 'get',
			dataType : 'text',
			success : function(data) {
				var zNodes = eval("(" + data + ")");
				$.fn.zTree.init($("#tongjiMenu"), setting, zNodes);
			},
			error : function(msg) {
				alert('菜单加载异常!');
			}
		});
		
		
		// 系统管理菜单加载
		$.ajax({
			url : '${pageContext.request.contextPath}/json/admin.json',
			type : 'get',
			dataType : 'text',
			success : function(data) {
				var zNodes = eval("(" + data + ")");
				$.fn.zTree.init($("#adminMenu"), setting, zNodes);
			},
			error : function(msg) {
				alert('菜单加载异常!');
			}
		});

		
		$("#btnCancel").click(function(){
			$('#editPwdWindow').window('close');
		});
		
		$("#btnEp").click(function(){
		
			var oldPass=$("#oldPass").val();
			var newPass=$("#newPass").val();
			var rePass =$("#rePass").val();
			if(oldPass.length<5 ||  newPass.length<5 || rePass.length<5   ){
				alert("密码的长度不应该少于五位！");
				return 0;
			}
			if(oldPass==newPass){
				alert("密码和之前定的相同啦！");
				return 0;
			}
			if(rePass!=newPass){
				alert("两次输入的密码不正确呢");
				return 0;
			}
			if(!confirm("确定修改密码？")){
				return 0;
			}
			$('#updatePassword').form({    
			    url:"${pageContext.request.contextPath}/edituser",    
			    error:function(){
			    	alert("提交失败");
			    },
			    success:function(data){    
			    	/*  var message= JSON.stringify(data);
			    	//修改失败
			    	var aaa="error1";
			    	alert(aaa==message);
			    	alert(message); */
			    	if("error1"==data){
			    		$("#updateError").html("请先登录！").css({ color: "#ff0000"});
			    	}else if("error3"==data){
			    		$("#updateError").html("修改失败！").css({ color: "#ff0000"});
			    	}else{
			    		 $.messager.show({
			    		title:'提示消息',
			    		msg:"修改成功！",
			    		timeout:3000,
			    		showType:'slide'
			    	});
			    	 $("#updateError").html("");
			    	// 关闭窗口:
			    	$("#editPwdWindow").window("close");
			    	// 重新加载数据: 
			    	}
			     
			    }    
			});    
			// submit the form    
			$('#updatePassword').submit();  
		});
	});

	function onClick(event, treeId, treeNode, clickFlag) {
		// 判断树菜单节点是否含有 page属性
		if (treeNode.page!=undefined && treeNode.page!= "") {
			var content = '<div style="width:100%;height:100%;overflow:hidden;">'
					+ '<iframe src="${pageContext.request.contextPath}'
					+treeNode.page
					+ '" scrolling="auto" style="width:100%;height:100%;border:0;" ></iframe></div>';
			if ($("#tabs").tabs('exists', treeNode.name)) {// 判断tab是否存在
				$('#tabs').tabs('select', treeNode.name); // 切换tab
				var tab = $('#tabs').tabs('getSelected'); 
				$('#tabs').tabs('update', {
				    tab: tab,
				    options: {
				        title: treeNode.name,
				        content: content
				    }
				});
			} else {
				// 开启一个新的tab页面
				$('#tabs').tabs('add', {
					title : treeNode.name,
					content : content,
					closable : true
				});
			}
		}
	}


	// 退出登录
	function logoutFun() {
		$.messager
		.confirm('系统提示','您确定要退出本次登录吗?',function(isConfirm) {
			if (isConfirm) {
				location.href = '${pageContext.request.contextPath }/logout';
			}
		});
	}
	// 修改密码
	function editPassword() {
		$('#editPwdWindow').window('open');
	}
	// 版权信息
	function showAbout(){
		$.messager.alert("年华士达v1.0","管理员邮箱: chenxianda@163.com");
	}
	

</script>
</head>
<body class="easyui-layout" data-options="fit:true" >
	<div data-options="region:'north',border:false"
		style="height:80px;padding:10px;background:url('./images/header_bg1.jpg')  right;">
		<div id="sessionInfoDiv"
			style="position: absolute;right: 5px;top:10px;">
			${loginUser.username} ，欢迎你！
		</div>
		<div style="position: absolute; right: 5px; bottom: 10px; ">
			<a href="javascript:void(0);" class="easyui-menubutton"
				data-options="menu:'#layout_north_kzmbMenu',iconCls:'icon-help'">控制面板</a>
		</div>
		<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
			<div onclick="editPassword();">修改密码</div>
			<div onclick="showAbout();">联系管理员</div>
			<div class="menu-sep"></div>
			<div onclick="logoutFun();">退出系统</div>
		</div>
	</div>
	<div data-options="region:'west',split:true,title:'菜单导航'"
		style="width:200px;">
		<div class="easyui-accordion" fit="true" border="false">
			<div title="基础数据" data-options="iconCls:'icon-mini-add'" style="overflow:auto;">
				<ul id="basedataMenu" class="ztree"></ul>
			</div>
			<div title="线路资源" data-options="iconCls:'icon-mini-add'" style="overflow:auto;">
				<ul id="lineresource" class="ztree"></ul>
			</div>
			<div title="路由分析" data-options="iconCls:'icon-mini-add'" style="overflow:auto;">
				<ul id="route" class="ztree"></ul>
			</div>
			<div title="分拣管理" data-options="iconCls:'icon-mini-add'" style="overflow:auto;">
				<ul id="sortingmanage" class="ztree"></ul>
			</div>
			<div title="进出港管理" data-options="iconCls:'icon-mini-add'" style="overflow:auto;">
				<ul id="inoutportmanage" class="ztree"></ul>
			</div>
			<div title=受理 data-options="iconCls:'icon-mini-add'" style="overflow:auto;">
				<ul id="shouliMenu" class="ztree"></ul>
			</div>
			<div title=调度  data-options="iconCls:'icon-mini-add'" style="overflow:auto;">
				<ul id="diaoduMenu" class="ztree"></ul>
			</div>
			<div title=签收管理 data-options="iconCls:'icon-mini-add',selected:true" style="overflow:auto;">
				<ul id="qianshouMenu" class="ztree"></ul>
			</div>
			<div title="统计" data-options="iconCls:'icon-mini-add'" style="overflow:auto;">
				<ul id="tongjiMenu" class="ztree"></ul>
			</div>
			<div title="系统管理" data-options="iconCls:'icon-mini-add'" style="overflow:auto">  
				<ul id="adminMenu" class="ztree"></ul>
			</div>
		</div>
	</div>
	<div data-options="region:'center'" style="padding:5px;background:#eee;"  >
		<div id="tabs" data-options="fit:true"  class="easyui-tabs" border="false">
			<div title="消息中心" id="subWarp"
				style="width:100%;height:100%;">
				
			</div>
		</div>
	</div>
	<div data-options="region:'south',border:false"
		style="height:50px;padding:10px;background:url('./images/header_bg1.jpg') no-repeat right;">
		<table style="width: 100%;">
			<tbody>
				<tr>
					<td style="width: 300px;">
						<div style="color: #999; font-size: 8pt;">
							年华士达 
						</div>
					</td>
					<td style="width: *;" class="co1"><span id="online"
						style="background: url(${pageContext.request.contextPath }/images/online.png) no-repeat left;padding-left:18px;margin-left:3px;font-size:8pt;color:#005590;">在线人数:1</span>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<!--修改密码窗口-->
    <div id="editPwdWindow" class="easyui-window" title="修改密码" collapsible="false" minimizable="false" modal="true" closed="true" resizable="false"
        maximizable="false" icon="icon-save"  style="width: 300px; height: 200px; padding: 5px;
        background: #fafafa">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
		<form id="updatePassword" method="post"  >
                <table cellpadding=3>
                   <tr>
                        <td>旧密码：</td>
                        <td><input id="oldPass"  name="oldPass" type="Password" class="txt01" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>新密码：</td>
                        <td><input id="newPass" name="newPass" type="Password" class="txt01" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>确认密码：</td>
                        <td><input id="rePass" name="rePass"  type="Password" class="txt01" /></td>
                        <td></td>
                    </tr>
                    <tr>
                     <td id="updateError" align="center" ></td>
                    </tr>
                </table>
    </form>
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" >确定</a> 
                <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
            </div>
        </div>
    </div>
</body>
</html>