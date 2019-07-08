package cn.com.lingnan.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;

import cn.com.lingnan.pojo.Rukubill;
import cn.com.lingnan.pojo.Rukudetails;
import cn.com.lingnan.pojo.User;
import cn.com.lingnan.pojo.Combinedetails;
import cn.com.lingnan.service.RukubillService;
import cn.com.lingnan.utils.PageBean;
import cn.com.lingnan.utils.UUIDUtils;

@Controller
@RequestMapping("/rukubill")
public class RukubillController {

	@Resource(name = "rukubillService")
	private RukubillService rukubillService;

	@RequestMapping("/findBypageUi")
	public String toFindBypageUi() {
		return "sortingmanage/rukubill";
	}
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}


	/**
	 * 分页查询方法
	 */
	@RequestMapping("/findBypage")
	@ResponseBody
	public PageBean pageQuery(@RequestParam(required = true, defaultValue = "1") String page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") String pagesize, Rukubill rukubill,
			HttpServletRequest request,HttpSession httpSession) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pagesize));
		User user = (User)httpSession.getAttribute("loginUser");
		if (user == null) {
			return null;
		}
		rukubillService.pageQuery(pageBean, rukubill,user.getStation());
		return pageBean;
	}

	@RequestMapping("/findById")
	@ResponseBody
	public Rukubill findById(String id) {
		Rukubill rukubill = rukubillService.findById(id);
		return rukubill;
	}

	@RequestMapping("/addRukubill")
	@ResponseBody
	public String addRukubill(Rukubill rukubill,String inserted,HttpSession httpSession)  {
		System.out.println(inserted);
		System.out.println(rukubill.toString());
		User user = (User)httpSession.getAttribute("loginUser");
		if (user == null) {
			return "false";
		}
		try {
			rukubill.setJiehuopeople(user.getUsername());
			rukubill.setJiehuostation(user.getStation());
			rukubill.setId(UUIDUtils.getId());
			List<Rukudetails> listInserts = JSON.parseArray(inserted, Rukudetails.class);
			for (Rukudetails rukudetails : listInserts) {
				System.out.println(rukudetails);
			}
			rukubillService.save(rukubill, listInserts);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
		

	}
	
	//批量删除

	@RequestMapping("/deleteBatch")
	@ResponseBody
	public boolean deleteBatch(String ids) {
		try {
			rukubillService.deleteBatch(ids);
			return true;
		} catch (Exception e) {
			System.out.println("aaa");
			return false;
		}
	}

	@RequestMapping("/updateById")
	@ResponseBody
	public boolean updateById(Rukubill rukubill) {
		try {
			// 判断有没有修改
			if (0 != rukubillService.update(rukubill)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("aaa");
		}
		return false;
	}




	
	@RequestMapping("/findAll")
	@ResponseBody
	public  List<Rukubill> findAll(){
		return rukubillService.findAll();
	}
	
	
	@RequestMapping("/findRukudetailsByid")
	@ResponseBody
	public List<Rukudetails> findRukudetailsByid(String id) {
		List<Rukudetails> Rukudetails = rukubillService.findRukudetailsByid(id);
		return Rukudetails;
	}
	

}
