package cn.com.lingnan.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.lingnan.pojo.Oceanline;
import cn.com.lingnan.service.OceanlineService;
import cn.com.lingnan.utils.PageBean;

@Controller
@RequestMapping("/oceanline")
public class OceanlineController {

	@Resource(name = "oceanlineService")
	private OceanlineService oceanlineService;

	@RequestMapping("/findBypageUi")
	public String toFindBypageUi() {
		return "lineresource/oceanline";
	}

	/**
	 * 分页查询方法
	 */
	@RequestMapping("/findBypage")
	@ResponseBody
	public PageBean pageQuery(@RequestParam(required = true, defaultValue = "1") String page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") String pagesize, Oceanline oceanline,
			HttpServletRequest request) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pagesize));
		System.out.println(oceanline.toString());
		oceanlineService.pageQuery(pageBean, oceanline);
		return pageBean;
	}

	@RequestMapping("/findById")
	@ResponseBody
	public Oceanline findById(String id) {
		Oceanline oceanline = oceanlineService.findById(id);
		return oceanline;
	}

	@RequestMapping("/addOceanline")
	@ResponseBody
	public boolean addOceanline(Oceanline oceanline) throws Exception {
		try {
			oceanlineService.save(oceanline);
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
			oceanlineService.deleteBatch(ids);
			return true;
		} catch (Exception e) {
			System.out.println("aaa");
			return false;
		}
	}

	@RequestMapping("/updateById")
	@ResponseBody
	public boolean updateById(Oceanline oceanline) {
		try {
			// 判断有没有修改
			if (0 != oceanlineService.update(oceanline)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("aaa");
		}
		return false;
	}




	
	@RequestMapping("/findAll")
	@ResponseBody
	public  List<Oceanline> findAll(){
		return oceanlineService.findAll();
	}
	

}
