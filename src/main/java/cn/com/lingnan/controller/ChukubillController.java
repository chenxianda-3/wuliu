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

import cn.com.lingnan.pojo.Chukubill;
import cn.com.lingnan.pojo.Chukudetails;
import cn.com.lingnan.pojo.User;
import cn.com.lingnan.service.ChukubillService;
import cn.com.lingnan.utils.PageBean;
import cn.com.lingnan.utils.UUIDUtils;

@Controller
@RequestMapping("/chukubill")
public class ChukubillController {

	@Resource(name = "chukubillService")
	private ChukubillService chukubillService;

	@RequestMapping("/findBypageUi")
	public String toFindBypageUi() {
		return "sortingmanage/chukubill";
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
			@RequestParam(value = "rows", required = true, defaultValue = "10") String pagesize, Chukubill chukubill,
			HttpServletRequest request,HttpSession httpSession) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pagesize));
		User user = (User)httpSession.getAttribute("loginUser");
		if (user == null) {
			return null;
		}
		chukubillService.pageQuery(pageBean, chukubill,user.getStation());
		return pageBean;
	}

	@RequestMapping("/findById")
	@ResponseBody
	public Chukubill findById(String id) {
		Chukubill chukubill = chukubillService.findById(id);
		return chukubill;
	}

	@RequestMapping("/addChukubill")
	@ResponseBody
	public boolean addChukubill(Chukubill chukubill,String workorderIds,HttpSession httpSession) throws Exception {
		try {
			User user = (User)httpSession.getAttribute("loginUser");
			if (user == null) {
				return false;
			}
			chukubill.setId(UUIDUtils.getId());
			chukubillService.save(chukubill, workorderIds,user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	//批量删除

	@RequestMapping("/deleteBatch")
	@ResponseBody
	public boolean deleteBatch(String ids) {
		try {
			chukubillService.deleteBatch(ids);
			return true;
		} catch (Exception e) {
			System.out.println("aaa");
			return false;
		}
	}

	@RequestMapping("/updateById")
	@ResponseBody
	public boolean updateById(Chukubill chukubill) {
		try {
			// 判断有没有修改
			if (0 != chukubillService.update(chukubill)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("aaa");
		}
		return false;
	}




	
	@RequestMapping("/findAll")
	@ResponseBody
	public  List<Chukubill> findAll(){
		return chukubillService.findAll();
	}
	
	
	@RequestMapping("/findChukudetailsByid")
	@ResponseBody
	public List<Chukudetails> findChukudetailsByid(String id) {
		if (id == null || id=="") {
			return null;
		}
		List<Chukudetails> Chukudetails = chukubillService.findChukudetailsByid(id);
		return Chukudetails;
	}
	

}
