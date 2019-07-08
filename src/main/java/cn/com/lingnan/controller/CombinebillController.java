package cn.com.lingnan.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.lingnan.pojo.Combinebill;
import cn.com.lingnan.pojo.Combinedetails;
import cn.com.lingnan.service.CombinebillService;
import cn.com.lingnan.utils.PageBean;
import cn.com.lingnan.utils.UUIDUtils;

@Controller
@RequestMapping("/combinebill")
public class CombinebillController {

	@Resource(name = "combinebillService")
	private CombinebillService combinebillService;

	@RequestMapping("/findBypageUi")
	public String toFindBypageUi() {
		return "sortingmanage/combinebill";
	}

	/**
	 * 分页查询方法
	 */
	@RequestMapping("/findBypage")
	@ResponseBody
	public PageBean pageQuery(@RequestParam(required = true, defaultValue = "1") String page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") String pagesize, Combinebill combinebill,
			HttpServletRequest request) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pagesize));
		System.out.println(combinebill.toString());
		combinebillService.pageQuery(pageBean, combinebill);
		return pageBean;
	}

	@RequestMapping("/findById")
	@ResponseBody
	public Combinebill findById(String id) {
		Combinebill combinebill = combinebillService.findById(id);
		return combinebill;
	}

	@RequestMapping("/addCombinebill")
	@ResponseBody
	public boolean addCombinebill(Combinebill combinebill,String ids) throws Exception {
		try {
			combinebill.setId(UUIDUtils.getId());
			combinebillService.save(combinebill, ids);
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
			combinebillService.deleteBatch(ids);
			return true;
		} catch (Exception e) {
			System.out.println("aaa");
			return false;
		}
	}

	@RequestMapping("/updateById")
	@ResponseBody
	public boolean updateById(Combinebill combinebill) {
		try {
			// 判断有没有修改
			if (0 != combinebillService.update(combinebill)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("aaa");
		}
		return false;
	}




	
	@RequestMapping("/findAll")
	@ResponseBody
	public  List<Combinebill> findAll(){
		return combinebillService.findAll();
	}
	
	
	@RequestMapping("/findCombinedetailsByid")
	@ResponseBody
	public List<Combinedetails> findCombinedetailsByid(String id) {
		List<Combinedetails> combinedetails = combinebillService.findCombinedetailsByid(id);
		return combinedetails;
	}
	

}
