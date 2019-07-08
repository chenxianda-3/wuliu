package cn.com.lingnan.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.com.lingnan.pojo.Staff;
import cn.com.lingnan.service.StaffService;
import cn.com.lingnan.utils.POIUtil;
import cn.com.lingnan.utils.PageBean;

@Controller
@RequestMapping("/staff")
public class StaffController {

	@Resource(name = "staffService")
	private StaffService staffService;

	@RequestMapping("/findBypageUi")
	public String toFindBypageUi() {
		return "base/staff";
	}

	/**
	 * 分页查询方法
	 */
	@RequestMapping("/findBypage")
	@ResponseBody
	public PageBean pageQuery(@RequestParam(required = true, defaultValue = "1") String page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") String pagesize, Staff staff,
			HttpServletRequest request) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pagesize));
		System.out.println(staff.toString());
		staffService.pageQuery(pageBean, staff);
		return pageBean;
	}

	@RequestMapping("/findById")
	@ResponseBody
	public Staff findById(String id) {
		Staff staff = staffService.findById(id);
		return staff;
	}

	@RequestMapping("/addStaff")
	@ResponseBody
	public boolean addStaff(Staff staff) throws Exception {
		try {
			staff.setDeltag("0");
			staffService.save(staff);
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
	//批量删除

	@RequestMapping("/deleteBatch")
	@ResponseBody
	public boolean deleteBatch(String ids) {
		try {
			staffService.deleteBatch(ids);
			return true;
		} catch (Exception e) {
			System.out.println("aaa");
			return false;
		}
	}

	@RequestMapping("/updateById")
	@ResponseBody
	public boolean updateById(Staff staff) {
		try {
			// 判断有没有修改
			if (0 != staffService.update(staff)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("aaa");
		}
		return false;
	}



	@RequestMapping("/importXls")
	@ResponseBody
	public String importXls(MultipartFile importFile,HttpSession session) {
		session.setAttribute("importedFlag", "false");
		List<Staff> staffList = new ArrayList<Staff>();
		//判断上传的文件是否符合格式和上传的文件是否存在
		try {
			POIUtil.checkFile(importFile);
		} catch (IOException e1) {
			//回传错误信息
			return e1.getMessage();
		}
		try {
			List<String[]> list = POIUtil.readExcel(importFile); // 这里得到的是一个集合，里面的每一个元素是String[]数组
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				String[] strings = (String[]) iterator.next();
				Staff staff = new Staff(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5],
						strings[6]);
				System.out.println(staff.toString());
				staffList.add(staff);
				
			}
			int influence = staffService.saveBatch(staffList);
			session.removeAttribute("importedFlag");
			//判断受影响的条数
			if (0==influence) {
				return "已经存在这些记录";
			}
		} catch (Exception e) {
			return "插入失败";
		}
		return "true";
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
	public  List<Staff> findAll(){
		return staffService.findAll();
	}
	

}
