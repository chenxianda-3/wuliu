package cn.com.lingnan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.lingnan.pojo.Deliveryunit;
import cn.com.lingnan.pojo.Fendanbill;
import cn.com.lingnan.pojo.Rukudetails;
import cn.com.lingnan.pojo.User;
import cn.com.lingnan.pojo.Ztree;
import cn.com.lingnan.service.DeliveryunitService;
import cn.com.lingnan.service.FendanbillService;
import cn.com.lingnan.utils.PageBean;

@Controller
@RequestMapping("/fendanbill")
public class FendanbillController {

	@Resource(name = "fendanbillService")
	private FendanbillService fendanbillService;
	
	@Resource(name = "deliveryunitService")
	private DeliveryunitService deliveryunitService;

	@RequestMapping("/findBypageUi")
	public String toFindBypageUi() {
		return "inoutportmanage/fendanbill";
	}

	/**
	 * 分页查询方法
	 */
	@RequestMapping("/findBypageOfFendaned")
	@ResponseBody
	public PageBean pageQueryOfFendaned(@RequestParam(required = true, defaultValue = "1") String page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") String pagesize, Fendanbill fendanbill,
			HttpServletRequest request,HttpServletResponse response,HttpSession httpSession) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pagesize));
		User user = (User)httpSession.getAttribute("loginUser");
		if (user == null) {
			return null;
		}
		fendanbill.setTransfercenter(user.getStation());
		fendanbillService.pageQueryOfFendaned(pageBean, fendanbill);
		return pageBean;
	}
	
	
	
	@RequestMapping("/findBypageOfNoFendan")
	@ResponseBody
	public PageBean pageQueryNoFendan(@RequestParam(required = true, defaultValue = "1") String page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") String pagesize, Rukudetails rukudetails,
			HttpServletRequest request,HttpServletResponse response,HttpSession httpSession) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pagesize));
		User user = (User)httpSession.getAttribute("loginUser");
		if (user == null) {
			return null;
		}
		
		System.out.println(rukudetails.toString());
		fendanbillService.pageQueryOfNoFendan(pageBean, rukudetails,user.getStation());
		return pageBean;
	}
	
	
	
	@RequestMapping("/findFendanedToDeliveryunit")
	@ResponseBody
	public PageBean findFendanedToDeliveryunit(@RequestParam(required = true, defaultValue = "1") String page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") String pagesize, Fendanbill fendanbill,
			HttpServletRequest request,HttpServletResponse response,HttpSession httpSession) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pagesize));
		User user = (User)httpSession.getAttribute("loginUser");
		if (user == null) {
			return null;
		}
		fendanbillService.findFendanedToDeliveryunit(pageBean, fendanbill,user);
		return pageBean;
	}
	

	@RequestMapping("/findById")
	@ResponseBody
	public Fendanbill findById(String id,HttpSession httpSession) {
		User user = (User)httpSession.getAttribute("loginUser");
		if (user == null) {
			return null;
		}
		Fendanbill fendanbill = fendanbillService.findByIdAndStation(id, user.getStation());
		return fendanbill;
	}

	@RequestMapping("/handFendan")
	@ResponseBody
	public boolean handFendan(String workorderIds,String deliveryunitId,HttpSession httpSession) throws Exception {
		
		try {
			User user = (User)httpSession.getAttribute("loginUser");
			if (user == null) {
				return false;
			}
			fendanbillService.handFendan(workorderIds,deliveryunitId,user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	
	
	//批量删除

	@RequestMapping("/deleteBatch")
	@ResponseBody
	public boolean deleteBatch(String ids,HttpSession httpSession) {
		try {	
		User user = (User)httpSession.getAttribute("loginUser");
		if (user == null) {
			return false;
		}
		System.out.println(ids);
			fendanbillService.deleteBatch(ids,user);
			return true;
		} catch (Exception e) {
			System.out.println("aaa");
			return false;
		}
	}

	@RequestMapping("/updateById")
	@ResponseBody
	public boolean updateById(Fendanbill fendanbill) {
		try {
			// 判断有没有修改
			if (0 != fendanbillService.update(fendanbill)) {
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
	public  List<Fendanbill> findAll(){
		return fendanbillService.findAll();
	}
	
	@RequestMapping("/findZtree")
	@ResponseBody
	public List<Ztree>  findZtree(String transfercenter,HttpSession httpSession){
		List<Ztree> ztrees=new ArrayList<>();
		User user = (User)httpSession.getAttribute("loginUser");
		if (user == null) {
			return null;
		}
		
		//添加班车线路
		Ztree parent = new Ztree("0", "",user.getStation(), "");
		transfercenter=user.getStation();
		Ztree deliveryunitztree = new Ztree("12", "0", "派送单位", "");
		ztrees.add(parent);
		ztrees.add(deliveryunitztree);
		List<Deliveryunit> deliveryunit = deliveryunitService.findByTransfercenter(transfercenter);
		for (Deliveryunit deliveryunit2 : deliveryunit) {
			ztrees.add(new Ztree(deliveryunit2.getId(), "12", deliveryunit2.getName(), ""));
		}
		
		return ztrees;
		
	}
	
	
	

}
