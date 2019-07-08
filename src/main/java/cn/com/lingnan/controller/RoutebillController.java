package cn.com.lingnan.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.lingnan.pojo.Routebill;
import cn.com.lingnan.pojo.Routelinebill;
import cn.com.lingnan.service.RoutebillService;
import cn.com.lingnan.service.RoutelinebillService;
import cn.com.lingnan.utils.PageBean;

@Controller
@RequestMapping("/routebill")
public class RoutebillController {

	@Resource(name = "routebillService")
	private RoutebillService routebillService;
	
	@Resource(name = "routelinebillService")
	private RoutelinebillService routelinebillService;

	@RequestMapping("/findBypageUi")
	public String toFindBypageUi() {
		return "route/routebill";
	}
	
	
	@RequestMapping("/findByTrial")
	public String findByTrial() {
		return "route/routeTrial";
	}
	
	@RequestMapping("/findByStartToEnd")
	@ResponseBody
	public  PageBean findByStartToEnd(@RequestParam(required = true, defaultValue = "1") String page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") String pagesize,Routelinebill routelinebill){
		System.out.println(routelinebill.toString());
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pagesize));
		if (routelinebill.getStartstation()==null || routelinebill.getStartstation()=="" || routelinebill.getEndstation()==null || routelinebill.getEndstation()=="") {
			pageBean.setRows(null);
			pageBean.setTotal(0);
		}else{
			List<Routebill> findByStartToEnd = routebillService.findByStartToEnd(routelinebill);
			pageBean.setRows(findByStartToEnd);
			pageBean.setTotal(findByStartToEnd.size());
		}
		
		return pageBean;
	}
	

	/**
	 * 分页查询方法
	 */
	@RequestMapping("/findBypage")
	@ResponseBody
	public PageBean pageQuery(@RequestParam(required = true, defaultValue = "1") String page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") String pagesize, Routebill routebill,
			HttpServletRequest request) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pagesize));
		System.out.println(routebill.toString());
		routebillService.pageQuery(pageBean, routebill);
		return pageBean;
	}

	@RequestMapping("/findById")
	@ResponseBody
	public Routebill findById(String id) {
		Routebill routebill = routebillService.findById(id);
		return routebill;
	}
	
	
	@RequestMapping("/tongBu")
	@ResponseBody
	public String tongBu(String id) {
		System.out.println(id);
		try {
			routebillService.tongBu(id);
			return "true";
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return "false";
		}
		
	}
	
	
	
	
	@RequestMapping("/findLineByRoutebillId")
	@ResponseBody
	public List<Routelinebill> findLineByRoutebillId(String id){
		return routelinebillService.findLineByRoutebillId(id);
	}
	
	

	@RequestMapping("/addRoutebill")
	@ResponseBody
	public boolean addRoutebill(Routebill routebill) throws Exception {
		try {
			routebillService.save(routebill);
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
	//批量删除

	@RequestMapping("/deleteBatch")
	@ResponseBody
	public boolean deleteBatch(String ids) {
		System.out.println(ids);
		try {
			routebillService.deleteBatch(ids);
			return true;
		} catch (Exception e) {
			System.out.println("aaa");
			return false;
		}
	}

	@RequestMapping("/updateById")
	@ResponseBody
	public boolean updateById(Routebill routebill) {
		try {
			// 判断有没有修改
			if (0 != routebillService.update(routebill)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("aaa");
		}
		return false;
	}




	
	@RequestMapping("/findAll")
	@ResponseBody
	public  List<Routebill> findAll(){
		return routebillService.findAll();
	}
	

}
