/**
 * 实现省市区联动
 */

	function showPro(){
		$.ajax({
			url : '/wuliu3/json/pca-code.json',
			 dataType: 'json',  
		     success: function (jsonstr) {  
				$('#province').combobox({
					data: jsonstr,  
					valueField:'name',
					textField:'name',
					editable:false,
					onLoadSuccess:function (data){
						var data = $('#province').combobox('getData');					
						if(data.length>0){
							$('#province').combobox('select',null);
						}
					},
					onChange : function(newValue, oldValue) {			
						if (newValue) {
							showCity(newValue)
							$("#city").combobox("clear")
							$("#district").combobox("clear")		
						}
					}
				});
		     }
		});
	}

	function showCity(newProvince){				
		$.ajax({
			 url : '/wuliu3/json/pca-code.json',
			 dataType: 'json',  
		     success: function (json) {
		     	
		     	var cityJson = json;
		     	//console.log(JSON.stringify(cityJson))
		     	$.each(cityJson, function(i, val) {
		        	if(val.name == newProvince){ //判断省份的code 是否与省份的val 相同
	        			//console.log(JSON.stringify(val))
	        			val.childs.unshift({  
				            /*'code': '',*/  
				            'name': '请选择城市..'  
				        });
	        			$('#city').combobox({
							data: val.childs,  
							valueField:'name',
							textField:'name',
							editable:false,
							onChange : function(newCity, oldCity) {
								//console.log(newValue, oldValue)
								if (newCity) {				
									showCounty(String(newProvince),String(newCity))
								}
							}							
						});
	        			
	        		}
		        })		     	
		     }
		})			
				
	}


	function showCounty(newProvince,newCity){
				
		$.ajax({
			 url : '/wuliu3/json/pca-code.json',
			 dataType: 'json',  
		     success: function (json) {
		     	var cityJson = json;
		     	$.each(cityJson, function(i, val) {

		     		if(val.name == newProvince){
		     			var pro_childs =  val.childs;
		     			$.each(pro_childs, function(j, proVal) {// 然后 省份循环 寻找与省份对应的城市

			     			if(proVal.name == newCity){ //判断省份的name 是否与省份的name 相同
			     				proVal.childs.unshift({  
						           /* 'code': '',*/  
						            'name': '请选择区/县..'  
						        });
			        			$('#district').combobox({
									data: proVal.childs,  
									valueField:'name',
									textField:'name',
									editable:false
		
								});
			        			
			        		}
			     		})
		     		}
		     		
		        	
		        })		     	
		     }
		})			
				
	}
	
	function showPro2(){
		$.ajax({
			url : '/wuliu3/json/pca-code.json',
			 dataType: 'json',  
		     success: function (jsonstr) {  
				$('#province2').combobox({
					data: jsonstr,  
					valueField:'name',
					textField:'name',
					editable:false,
					onLoadSuccess:function (data){
						var data = $('#province2').combobox('getData');					
						if(data.length>0){
							$('#province2').combobox('select',null);
						}
					},
					onChange : function(newValue, oldValue) {			
						if (newValue) {
							showCity2(newValue)
							$("#city2").combobox("clear")
							$("#district2").combobox("clear")		
						}
					}
				});
		     }
		});
	}

	function showCity2(newProvince){				
		$.ajax({
			 url : '/wuliu3/json/pca-code.json',
			 dataType: 'json',  
		     success: function (json) {
		     	
		     	var cityJson = json;
		     	//console.log(JSON.stringify(cityJson))
		     	$.each(cityJson, function(i, val) {
		        	if(val.name == newProvince){ //判断省份的code 是否与省份的val 相同
	        			//console.log(JSON.stringify(val))
	        			val.childs.unshift({  
				            /*'code': '',*/  
				            'name': '请选择城市..'  
				        });
	        			$('#city2').combobox({
							data: val.childs,  
							valueField:'name',
							textField:'name',
							editable:false,
							onChange : function(newCity, oldCity) {
								//console.log(newValue, oldValue)
								if (newCity) {				
									showCounty2(String(newProvince),String(newCity))
								}
							}							
						});
	        			
	        		}
		        })		     	
		     }
		})			
				
	}


	function showCounty2(newProvince,newCity){
				
		$.ajax({
			 url : '/wuliu3/json/pca-code.json',
			 dataType: 'json',  
		     success: function (json) {
		     	var cityJson = json;
		     	$.each(cityJson, function(i, val) {

		     		if(val.name == newProvince){
		     			var pro_childs =  val.childs;
		     			$.each(pro_childs, function(j, proVal) {// 然后 省份循环 寻找与省份对应的城市

			     			if(proVal.name == newCity){ //判断省份的name 是否与省份的name 相同
			     				proVal.childs.unshift({  
						           /* 'code': '',*/  
						            'name': '请选择区/县..'  
						        });
			        			$('#district2').combobox({
									data: proVal.childs,  
									valueField:'name',
									textField:'name',
									editable:false,
									onChange : function(newCounty, oldCounty) {
										//console.log(newValue, oldValue)
										if (newCity) {				
											showDecidedzone2(String(newProvince),String(newCity),String(newCounty))
										}
									}	
		
								});
			        			
			        		}
			     		})
		     		}
		     		
		        	
		        })		     	
		     }
		})			
				
	}
	
	
	function showDecidedzone2(newProvince,newCity,newCounty){
		
		$.ajax({
			 url : '/wuliu3/subarea/findDecidedzoneBySSQ',
			 type: "POST",
			 data: {"province":newProvince,"city":newCity,"district":newCounty},
			 dataType: 'json',  
		     success: function (json) {
				$('#decidedzone2').combobox({
					data: json,  
					valueField:'id',
					textField:'name',
					editable:false
	
				});
			        			
			  }
		});
}
	