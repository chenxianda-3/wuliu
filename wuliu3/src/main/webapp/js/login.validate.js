
$().ready(function() {
// 在键盘按下并释放及提交后验证提交表单
//	alert("aaa");
  $("#loginform").validate({
	  errorPlacement: function(error, element) {
	      error.appendTo(element.parent("div").next("div"));
	    },
	  rules: {
	      username: {
	        required: true,
	        minlength: 5
	      },
	      password: {
	        required: true,
	        minlength: 5
	      },
	      checkcode: {
	      	  required: true,
	          rangelength:[4,4]
	      }
	    },
	    messages: {
      username: {
        required: "请输入用户名",
        minlength: "用户名不能少于 5 个字符"
      },
      password: {
        required: "请输入密码",
        minlength: "密码长度不能小于 5 个字符"
      },
      checkcode: {
      	required: "请输入验证码",
        rangelength: "验证码为四个字符"
      }
      
	    }
	});
  

	
	
});


