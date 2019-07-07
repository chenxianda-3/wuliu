package cn.com.lingnan.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.lingnan.pojo.Busline;
import cn.com.lingnan.service.BuslineService;
import cn.com.lingnan.utils.PageBean;

@Controller
@RequestMapping("/busline")
public class BuslineController {

	@Resource(name = "buslineService")
	private BuslineService buslineService;

	@RequestMapping("/findBypageUi")
	public String toFindBypageUi() {
		return "lineresource/busline";
	}

	/**
	 * 分页查询方法
	 */
	@RequestMapping("/findBypage")
	@ResponseBody
	public PageBean pageQuery(@RequestParam(required = true, defaultValue = "1") String page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") String pagesize, Busline busline,
			HttpServletRequest request) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pagesize));
		System.out.println(busline.toString());
		buslineService.pageQuery(pageBean, busline);
		return pageBean;
	}

	@RequestMapping("/findById")
	@ResponseBody
	public Busline findById(String id) {
		Busline busline = buslineService.findById(id);
		return busline;
	}

	@RequestMapping("/addBusline")
	@ResponseBody
	public boolean addBusline(Busline busline) throws Exception {
		try {
			buslineService.save(busline);
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
			buslineService.deleteBatch(ids);
			return true;
		} catch (Exception e) {
			System.out.println("aaa");
			return false;
		}
	}

	@RequestMapping("/updateById")
	@ResponseBody
	public boolean updateById(Busline busline) {
		try {
			// 判断有没有修改
			if (0 != buslineService.update(busline)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("aaa");
		}
		return false;
	}




	
	@RequestMapping("/findAll")
	@ResponseBody
	public  List<Busline> findAll(){
		return buslineService.findAll();
	}
	

}
