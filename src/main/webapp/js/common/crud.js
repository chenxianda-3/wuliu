/**
 * 这个是一个easyui各个模块提高查增删改效率而抽取出来js文件
 */

	function showCloseReload(data){
		var message;
    	if("true"==data){
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
	    	$("#grid").datagrid("reload");
    	}else{
    		message="后台发生错误";
    		$.messager.alert("错误信息",message,"error");
    	}
		 
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
	    	$("#grid").datagrid("reload");
    	}else{
    		message="后台发生错误";
    		$.messager.alert("错误信息",message,"error");
    	}
		 
	}
	
	
	function showCloseReload3(data){
		var message;
    	if("true"!=data){
    		message=data;
    		$.messager.progress('close');
    		$.messager.alert("错误信息",message,"error");
    	}
		 
	}
	
	
	
	/**
	 * 导出excel（带进度条）
	 * @param exportExcelUrl
	 * @param scanTime 检测是否导出完毕请求间隔 单位毫秒
	 * @param interval 进度条更新间隔（每次更新进度10%）  单位毫秒  导出时间越长 请设置越大 200 对应2秒导出时间
	 */
	function importExcWithprogress(isImportUrl,scanTime,interval){
	    if(scanTime<1000 || scanTime == undefined){
	        scanTime = 1000;
	    }
	    $.messager.progress({
	        title:'导出中,请等待...',
	        msg:'导出进度：',
	        interval: interval
	    });
	    $.messager.progress('bar').progressbar({
	        onChange: function(value){
	            if(value == 100){
	                $.messager.show({
	                    title:'提示消息',
	                    msg:'导入成功',
	                    timeout:2000,
	                    showType:'fade',
	                    style:{
	                        top:'45%'
	                    }
	                });
	                $.messager.progress('close');
	                $("#grid").datagrid("reload");
	            }
	        }
	    });
	    var timer = setInterval(function(){
	         $.ajax({
	                url: isImportUrl+'?id='+Math.random(),
	                success: function(data){
	                    if("true"==data){
	                        $.messager.progress('bar').progressbar('setValue','100');
	                        clearInterval(timer);
	                    }
	                },
	                error:function(e){
	                    alert(e.responseText);
	                }
	            }); 
	          }, scanTime);
	}
	
	//添加的时候跳出窗口
	function doAdd(addUrl) {
		//alert("增加...");
		$('#addWindow').window("open");
		$('#formAdd')[0].reset();
		$("#save").attr("onclick", "save('"+addUrl+"');");
		$("input[name='id']").css({
			display : "inline-block"
		});
	}
	
	//修改的时候回传数据
	function doUpdate(findByIdUrl,updataByIdUrl) {
		var rows = $("#grid").datagrid("getSelections");
		if (rows.length == 0 || rows.length > 1) {
			//没有选中记录，弹出提示
			$.messager.alert("提示信息", "有且需要选中一条记录", "warning");
		} else {
			
			var object = rows[0];//json对象
			var id = object.id;
			$("#addWindow").window("open");
			$('#formAdd')[0].reset();
			$('#formAdd').form(
					'load',
					findByIdUrl+ id + "");
			$("#save").attr("onclick", "update('"+updataByIdUrl+"');");
			$("input[name='id']").css({
				display : "none"
			});
		}
	}
	
	
	function save(saveUrl) {
		$('#formAdd').form({
			url : saveUrl,
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
	
	function update(updataByIdUrl) {
		$('#formAdd').form({
			url : updataByIdUrl,
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
										var id = object.id;
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
		if(0==flag){
			$.messager.alert("错误信息","你还没有输入任何条件！","error");
			return false;
		}
	       return o;
	   }  

	
	function otherQuery(){
	 	var formSerialize =$("#formQuery").form().serializeArray();
	 	var obj=serializeObject(formSerialize);
	 	if(false==obj){
	 		return false;
	 	}
	    $("#grid").datagrid('load',obj);

	}

	//初始化界面
	function init(initUrl){
		// 先将body隐藏，再显示，不会出现页面刷新效果
		$("body").css({
			visibility : "visible"
		});
		
		$('#grid').datagrid({
			iconCls : 'icon-forward',
			fit : true,
			border : false,
			rownumbers : true,
			striped : true,
			pageSize : 10,
			pageList : [ 2, 10, 20, 50 ],
			pagination : true,
			toolbar : '#tb',
			url : initUrl,
			idField : 'id' ,
			// 如果没有数据，就增加提示
		 	onLoadSuccess:function(data){
				 if (data.total == 0) {
					 var columnLength = $('#grid').datagrid('getColumnFields').length; // 获取表格列数
						var body = $(this).data().datagrid.dc.body2;
						body.find('table tbody').append('<tr><td width="'+body.width()+'" style="height: 25px; padding:10px;text-align: left;"  colspan='+columnLength+'>没有任何结果数据显示！</td></tr>');
				 }
	 	    }
		});
		
		
		// 添加或者修改的窗口
		$('#addWindow').window({
			width : 500,
			modal : true,
			shadow : true,
			closed : true,
			height : 500,
			resizable : false
		});
	}
	
	//导出按钮对应的处理函数
	function doExport(Url){
		//发送请求，请求Action，进行文件下载
		window.location.href = Url;
	}
	
	