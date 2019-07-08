package cn.com.lingnan.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.lingnan.pojo.User;
import cn.com.lingnan.pojo.Workorder;
import cn.com.lingnan.service.WorkorderService;
import cn.com.lingnan.utils.PageBean;
import cn.com.lingnan.utils.UUIDUtils;

@Controller
@RequestMapping("/workorder")
public class WorkorderController {

	@Resource(name = "workorderService")
	private WorkorderService workorderService;

	@RequestMapping("/findBypageUi")
	public String toFindBypageUi() {
		return "diaodu/quickworkorder";
	}
	
	
	@RequestMapping("/findBypageUiNormal")
	public String findBypageUiNormal() {
		return "diaodu/workorder";
	}
	
	
	/**
	 * 分页查询方法
	 */
	@RequestMapping("/findBypage")
	@ResponseBody
	public PageBean pageQuery(@RequestParam(required = true, defaultValue = "1") String page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") String pagesize, Workorder workorder,
			HttpServletRequest request,HttpSession httpSession) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pagesize));
		User user = (User)httpSession.getAttribute("loginUser");
		if (user == null) {
			return null;
		}
		workorder.setStation(user.getStation());
		workorderService.pageQuery(pageBean, workorder);
		return pageBean;
	}

	@RequestMapping("/findById")
	@ResponseBody
	public Workorder findById(String id) {
		Workorder workorder = workorderService.findById(id);
		return workorder;
	}

	@RequestMapping("/addWorkorder")
	@ResponseBody
	public boolean addWorkorder(Workorder workorder,HttpSession httpSession) throws Exception {
		try {
			if (workorder.getId()==null) {
				workorder.setId(UUIDUtils.getId());
			}
			User user = (User)httpSession.getAttribute("loginUser");
			if (user == null) {
				return false;
			}
			workorder.setState("0");
			workorder.setStation(user.getStation());
			workorder.setUpdatetime(new  Timestamp(System.currentTimeMillis()));
			workorderService.save(workorder);
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
			workorderService.deleteBatch(ids);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("aaa");
			return false;
		}
	}

	@RequestMapping("/updateById")
	@ResponseBody
	public boolean updateById(Workorder workorder) {
		try {
			// 判断有没有修改
			if (0 != workorderService.update(workorder)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("aaa");
		}
		return false;
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
	public  List<Workorder> findAll(){
		return workorderService.findAll();
	}
	

}
