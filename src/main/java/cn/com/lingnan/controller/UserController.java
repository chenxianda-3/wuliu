package cn.com.lingnan.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import cn.com.lingnan.pojo.User;
import cn.com.lingnan.service.UserService;

@Controller
public class UserController {
	

	@Resource(name="userService")
	private UserService userService;


//登录
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String getlogin(User user, String checkcode, Model model, HttpServletRequest request) {
		String validate = (String) request.getSession().getAttribute("key");
		if (checkcode != null && checkcode.equalsIgnoreCase(validate)) {
			// 输入的验证码正确
			User user2 = userService.login(user);
			if (user2 != null) {
				// 登录成功,将user对象放入session，跳转到首页
				request.getSession().setAttribute("loginUser", user2);
				return "common/index";
			} else
				model.addAttribute("msg", "用户名或者密码输入错误！");

		} else {
			// 输入的验证码错误,设置提示信息，跳转到登录页面
			model.addAttribute("msg", "输入的验证码错误！");
		}
		return "forward:/login.jsp";
	}
	
	
	
//注销
	@RequestMapping("/logout")
	public String logout(SessionStatus sessionStatus) {
		// 清除当前会话
		sessionStatus.setComplete();
		return "redirect:/login.jsp";
	}


	
	
//修改密码
	@RequestMapping(value="/edituser",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String editUser(String oldPass,String  newPass,String rePass, HttpSession session,Model model,HttpServletResponse response) {
		//获取session中的user对象
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser==null){
			return "error1";
		}
		System.out.println(oldPass+newPass+rePass);
		System.out.println(rePass==newPass);
		//判断传入的字段是否为空（二次检验），两次输入的密码是否相同,输入的旧密码是否正确，全部满足就修改密码
		if(oldPass!=null && newPass !=null && rePass!=null && rePass.equals(newPass) && oldPass.equals(loginUser.getPassword())){
			loginUser.setPassword(newPass);
			userService.updateByID(loginUser);
			return "error2";
		}
		return "error3";
}
}
