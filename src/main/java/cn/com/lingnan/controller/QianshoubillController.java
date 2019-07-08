package cn.com.lingnan.controller;

import java.sql.Timestamp;
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

import cn.com.lingnan.pojo.Qianshoubill;
import cn.com.lingnan.pojo.User;
import cn.com.lingnan.pojo.Qianshoubill;
import cn.com.lingnan.service.QianshoubillService;
import cn.com.lingnan.utils.PageBean;
import cn.com.lingnan.utils.UUIDUtils;

@Controller
@RequestMapping("/qianshoubill")
public class QianshoubillController {

	@Resource(name = "qianshoubillService")
	private QianshoubillService qianshoubillService;

	@RequestMapping("/findBypageUi")
	public String toFindBypageUi() {
		return "qianshou/qianshoubill";
	}
	
	
	@RequestMapping("/findBypageUiOfQuick")
	public String findBypageUiOfQuick() {
		return "qianshou/quickqianshoubill";
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
			@RequestParam(value = "rows", required = true, defaultValue = "10") String pagesize, Qianshoubill qianshoubill,
			HttpServletRequest request,HttpSession httpSession) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pagesize));
		User user = (User)httpSession.getAttribute("loginUser");
		if (user == null) {
			return null;
		}
		qianshoubillService.pageQuery(pageBean, qianshoubill,user.getStation());
		return pageBean;
	}

	@RequestMapping("/findById")
	@ResponseBody
	public Qianshoubill findById(String id,HttpSession httpSession) {
			User user = (User)httpSession.getAttribute("loginUser");
			if (user == null) {
				return null;
			}
		Qianshoubill qianshoubill = qianshoubillService.findById(id,user);
		return qianshoubill;
	}

	@RequestMapping("/addQianshoubill")
	@ResponseBody
	public boolean addQianshoubill(Qianshoubill qianshoubill,String workorderIds,String type,HttpSession httpSession) throws Exception {
		try {
			User user = (User)httpSession.getAttribute("loginUser");
			if (user == null) {
				return false;
			}
			qianshoubillService.save(workorderIds,user,type);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	
	
	@RequestMapping("/addQianshoubillQuick")
	@ResponseBody
	public boolean addQianshoubillQuick(Qianshoubill qianshoubill,HttpSession httpSession) throws Exception {
		try {
		
			User user = (User)httpSession.getAttribute("loginUser");
			if (user == null) {
				return false;
			}
			
			boolean saveQuick = qianshoubillService.saveQuick(qianshoubill,user);
			return saveQuick;
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
			qianshoubillService.deleteBatch(ids);
			return true;
		} catch (Exception e) {
			System.out.println("aaa");
			return false;
		}
	}

	@RequestMapping("/updateById")
	@ResponseBody
	public boolean updateById(Qianshoubill qianshoubill) {
		try {
			// 判断有没有修改
			if (0 != qianshoubillService.update(qianshoubill)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("aaa");
		}
		return false;
	}




	
	@RequestMapping("/findAll")
	@ResponseBody
	public  List<Qianshoubill> findAll(){
		return qianshoubillService.findAll();
	}
	
	

}
