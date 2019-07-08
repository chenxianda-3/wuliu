package cn.com.lingnan.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.lingnan.pojo.Airline;
import cn.com.lingnan.service.AirlineService;
import cn.com.lingnan.utils.PageBean;

@Controller
@RequestMapping("/airline")
public class AirlineController {

	@Resource(name = "airlineService")
	private AirlineService airlineService;

	@RequestMapping("/findBypageUi")
	public String toFindBypageUi() {
		return "lineresource/airline";
	}

	/**
	 * 分页查询方法
	 */
	@RequestMapping("/findBypage")
	@ResponseBody
	public PageBean pageQuery(@RequestParam(required = true, defaultValue = "1") String page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") String pagesize, Airline airline,
			HttpServletRequest request) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pagesize));
		System.out.println(airline.toString());
		airlineService.pageQuery(pageBean, airline);
		return pageBean;
	}

	@RequestMapping("/findById")
	@ResponseBody
	public Airline findById(String id) {
		Airline airline = airlineService.findById(id);
		return airline;
	}

	@RequestMapping("/addAirline")
	@ResponseBody
	public boolean addAirline(Airline airline) throws Exception {
		try {
			airlineService.save(airline);
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
			airlineService.deleteBatch(ids);
			return true;
		} catch (Exception e) {
			System.out.println("aaa");
			return false;
		}
	}

	@RequestMapping("/updateById")
	@ResponseBody
	public boolean updateById(Airline airline) {
		try {
			// 判断有没有修改
			if (0 != airlineService.update(airline)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("aaa");
		}
		return false;
	}




	
	@RequestMapping("/findAll")
	@ResponseBody
	public  List<Airline> findAll(){
		return airlineService.findAll();
	}
	

}
