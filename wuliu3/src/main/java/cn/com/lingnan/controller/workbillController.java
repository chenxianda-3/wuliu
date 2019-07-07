package cn.com.lingnan.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.com.lingnan.mapper.WorkbillMapper;
import cn.com.lingnan.pojo.User;
import cn.com.lingnan.pojo.Workbill;
import cn.com.lingnan.service.WorkbillService;
import cn.com.lingnan.utils.POIUtil;
import cn.com.lingnan.utils.PageBean;

@Controller
@RequestMapping("/workbill")
public class workbillController {

	@Resource(name = "workbillService")
	private WorkbillService workbillService;

	@RequestMapping("/findBypageUi")
	public String toFindBypageUi() {
		return "shouli/workbill";
	}
	
	
	@RequestMapping("/diaoDu")
	public String diaoDu() {
		return "diaodu/diaodu";
	}
	
	@RequestMapping("/chaTai")
	public String chaTai() {
		return "diaodu/chatai";
	}
	

@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}


	/**
	 * 分页查询方法
	 */
	@RequestMapping("/findBypage")
	@ResponseBody
	public PageBean pageQuery(@RequestParam(required = true, defaultValue = "1") String page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") String pagesize, Workbill workbill,
			HttpServletRequest request,HttpSession httpSession) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pagesize));
		System.out.println(workbill.toString());
		User user = (User)httpSession.getAttribute("loginUser");
		if (user == null) {
			return null;
		}
		workbill.setStation(user.getStation());
		workbillService.pageQuery(pageBean, workbill);
		return pageBean;
	}
	
	
	@RequestMapping("/diaoDuBypage")
	@ResponseBody
	public PageBean diaoDuBypage(@RequestParam(required = true, defaultValue = "1") String page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") String pagesize, Workbill workbill,
			HttpServletRequest request,HttpSession httpSession) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pagesize));
		System.out.println(workbill.toString());
		User user = (User)httpSession.getAttribute("loginUser");
		if (user == null) {
			return null;
		}
		workbill.setStation(user.getStation());
		workbillService.diaoDuBypage(pageBean, workbill);
		return pageBean;
	}

	@RequestMapping("/findById")
	@ResponseBody
	public Workbill findById(String id) {
		Workbill workbill = workbillService.findById(id);
		return workbill;
	}
	
	
	@RequestMapping("/attachWorkbill")
	@ResponseBody
	public  String attachWorkbill(String id){
		try {
			String attachBill = workbillService.attachBill(id);
			return attachBill;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return "false";
		}
	}
	
	

	@RequestMapping("/addWorkbill")
	@ResponseBody
	public boolean addWorkbill(Workbill workbill) throws Exception {
		try {
			workbillService.save(workbill);
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
	//批量删除

	@RequestMapping("/deleteBatch")
	@ResponseBody
	public String deleteBatch(String ids) {
		try {
			String deleteBatch = workbillService.deleteBatch(ids);
			return deleteBatch;
		} catch (Exception e) {
			System.out.println("aaa");
			return "false";
		}
	}
	
	
	
	//批量重发

	@RequestMapping("/diaoDuBatch")
	@ResponseBody
	public String diaoDuBatch(String ids) {
		try {
			workbillService.diaoDu(ids);
			return "true";
		} catch (Exception e) {
			System.out.println("aaa");
			return "false";
		}
	}
	

	@RequestMapping("/updateById")
	@ResponseBody
	public String updateById(Workbill workbill) {
		try {
			// 判断有没有修改
			System.out.println(workbill.toString());
			workbillService.update(workbill);
				return "true";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "false";
	}

	@RequestMapping("/updateStaffId")
	@ResponseBody
	public String updateStaffId(Workbill workbill) {
		try {
			// 判断有没有修改
			System.out.println(workbill.toString());
			workbillService.updateStaffId(workbill);
				return "true";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "false";
	}


	
	//提供上传是否完成的依据，ajax
	@RequestMapping("/isImport")
	@ResponseBody
	public String isImport(HttpSession session){
		Object importFlag = session.getAttribute("importedFlag");
		if (importFlag != null) {
			return "false";
		}else{
			return "true";
		}
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public  List<Workbill> findAll(){
		return workbillService.findAll();
	}
	

}
