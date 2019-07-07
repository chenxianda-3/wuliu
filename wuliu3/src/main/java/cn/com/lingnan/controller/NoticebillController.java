package cn.com.lingnan.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.lingnan.pojo.Customer;
import cn.com.lingnan.pojo.Noticebill;
import cn.com.lingnan.pojo.User;
import cn.com.lingnan.service.CustomerService;
import cn.com.lingnan.service.NoticebillService;
import cn.com.lingnan.utils.UUIDUtils;

@Controller
@RequestMapping("/noticebill")
public class NoticebillController {

	@Resource(name = "noticebillService")
	private NoticebillService noticebillService;

	@Resource(name = "customerService")
	private CustomerService customerService;
	
	

@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	
	@RequestMapping("/findBypageUi")
	public String toFindBypageUi() {
		return "shouli/noticebill_add";
	}

	@RequestMapping("/findNoticebill")
	public String findNoticebill() {
		return "shouli/noticebill";
	}
	

	
	
	@RequestMapping("/addNoticebill")
	@ResponseBody
	public String addNoticebill(Noticebill noticebill ,HttpSession httpSession,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception {
		
		
		System.out.println(noticebill.toString());
		try {
			User user = (User)httpSession.getAttribute("loginUser");
			if (user == null) {
				return "login";
			}else{
				noticebill.setUserId(user.getId());
				noticebill.setId(UUIDUtils.getId());
				noticebill.setStation(user.getStation());
				noticebillService.save(noticebill);
				return "true";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}

	}
	
	@RequestMapping("/findCustomerByTelephone")
	@ResponseBody
	public Customer findCustomerByTelephone(String telephone) {
		return customerService.findCustomerByTelephone(telephone);
	}
	
	
	
	
	

}
