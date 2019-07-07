package cn.com.lingnan.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.lingnan.pojo.Railwayline;
import cn.com.lingnan.service.RailwaylineService;
import cn.com.lingnan.utils.PageBean;

@Controller
@RequestMapping("/railwayline")
public class RailwaylineController {

	@Resource(name = "railwaylineService")
	private RailwaylineService railwaylineService;

	@RequestMapping("/findBypageUi")
	public String toFindBypageUi() {
		return "lineresource/railwayline";
	}

	/**
	 * 分页查询方法
	 */
	@RequestMapping("/findBypage")
	@ResponseBody
	public PageBean pageQuery(@RequestParam(required = true, defaultValue = "1") String page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") String pagesize, Railwayline railwayline,
			HttpServletRequest request) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pagesize));
		System.out.println(railwayline.toString());
		railwaylineService.pageQuery(pageBean, railwayline);
		return pageBean;
	}

	@RequestMapping("/findById")
	@ResponseBody
	public Railwayline findById(String id) {
		Railwayline railwayline = railwaylineService.findById(id);
		return railwayline;
	}

	@RequestMapping("/addRailwayline")
	@ResponseBody
	public boolean addRailwayline(Railwayline railwayline) throws Exception {
		try {
			railwaylineService.save(railwayline);
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
			railwaylineService.deleteBatch(ids);
			return true;
		} catch (Exception e) {
			System.out.println("aaa");
			return false;
		}
	}

	@RequestMapping("/updateById")
	@ResponseBody
	public boolean updateById(Railwayline railwayline) {
		try {
			// 判断有没有修改
			if (0 != railwaylineService.update(railwayline)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("aaa");
		}
		return false;
	}




	
	@RequestMapping("/findAll")
	@ResponseBody
	public  List<Railwayline> findAll(){
		return railwaylineService.findAll();
	}
	

}
