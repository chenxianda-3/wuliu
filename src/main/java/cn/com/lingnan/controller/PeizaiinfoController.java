package cn.com.lingnan.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.print.DocFlavor.STRING;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.lingnan.pojo.Airline;
import cn.com.lingnan.pojo.Busline;
import cn.com.lingnan.pojo.Oceanline;
import cn.com.lingnan.pojo.Peizaiinfo;
import cn.com.lingnan.pojo.Railwayline;
import cn.com.lingnan.pojo.Rukudetails;
import cn.com.lingnan.pojo.User;
import cn.com.lingnan.pojo.Ztree;
import cn.com.lingnan.service.AirlineService;
import cn.com.lingnan.service.BuslineService;
import cn.com.lingnan.service.OceanlineService;
import cn.com.lingnan.service.PeizaiinfoService;
import cn.com.lingnan.service.RailwaylineService;
import cn.com.lingnan.utils.PageBean;

@Controller
@RequestMapping("/peizaiinfo")
public class PeizaiinfoController {

	@Resource(name = "peizaiinfoService")
	private PeizaiinfoService peizaiinfoService;
	
	@Resource(name = "airlineService")
	private AirlineService airlineService;
	
	@Resource(name = "buslineService")
	private BuslineService buslineService;
	
	@Resource(name = "railwaylineService")
	private RailwaylineService railwaylineService;
	
	@Resource(name = "oceanlineService")
	private OceanlineService oceanlineService;
	

	@RequestMapping("/findBypageUi")
	public String toFindBypageUi() {
		return "inoutportmanage/peizaiinfo";
	}

	/**
	 * 分页查询方法
	 */
	@RequestMapping("/findBypageOfPeizaied")
	@ResponseBody
	public PageBean pageQueryOfPeizaied(@RequestParam(required = true, defaultValue = "1") String page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") String pagesize, Peizaiinfo peizaiinfo,
			HttpServletRequest request,HttpServletResponse response,HttpSession httpSession) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pagesize));
		User user = (User)httpSession.getAttribute("loginUser");
		if (user == null) {
			return null;
		}
		peizaiinfo.setOperateunit(user.getStation());
		peizaiinfoService.pageQueryOfPeizaied(pageBean, peizaiinfo);
		return pageBean;
	}
	
	
	
	@RequestMapping("/findBypageOfNoPeizai")
	@ResponseBody
	public PageBean pageQueryNoPeizai(@RequestParam(required = true, defaultValue = "1") String page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") String pagesize, Rukudetails rukudetails,
			HttpServletRequest request,HttpServletResponse response,HttpSession httpSession) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pagesize));
		User user = (User)httpSession.getAttribute("loginUser");
		if (user == null) {
			return null;
		}
		
		System.out.println(rukudetails.toString());
		peizaiinfoService.pageQueryOfNoPeizai(pageBean, rukudetails,user.getStation());
		return pageBean;
	}
	
	
	

	@RequestMapping("/findById")
	@ResponseBody
	public Peizaiinfo findById(String id,HttpSession httpSession) {
		User user = (User)httpSession.getAttribute("loginUser");
		if (user == null) {
			return null;
		}
		Peizaiinfo peizaiinfo = peizaiinfoService.findByIdAndStation(id, user.getStation());
		return peizaiinfo;
	}

	@RequestMapping("/handPeizai")
	@ResponseBody
	public boolean handPeizai(String workorderIds,String lineId,HttpSession httpSession) throws Exception {
		
		try {
			User user = (User)httpSession.getAttribute("loginUser");
			if (user == null) {
				return false;
			}
			peizaiinfoService.handPeizai(workorderIds,lineId,user.getStation());
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
	
	@RequestMapping("/autoPeizai")
	@ResponseBody
	public boolean autoPeizai(HttpSession httpSession)  {
		
		
		try {
			User user = (User)httpSession.getAttribute("loginUser");
			if (user == null) {
				return false;
			}
			peizaiinfoService.autoPeizai(user.getStation());
			return true;
		} catch (Exception e) {
			System.out.println("aaa");
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
			peizaiinfoService.deleteBatch(ids,user);
			return true;
		} catch (Exception e) {
			System.out.println("aaa");
			return false;
		}
	}

	@RequestMapping("/updateById")
	@ResponseBody
	public boolean updateById(Peizaiinfo peizaiinfo) {
		try {
			// 判断有没有修改
			if (0 != peizaiinfoService.update(peizaiinfo)) {
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
	public  List<Peizaiinfo> findAll(){
		return peizaiinfoService.findAll();
	}
	
	@RequestMapping("/findZtree")
	@ResponseBody
	public List<Ztree>  findZtree(String outCenter,HttpSession httpSession){
		List<Ztree> ztrees=new ArrayList<>();
		User user = (User)httpSession.getAttribute("loginUser");
		if (user == null) {
			return null;
		}
		
		//添加班车线路
		Ztree parent = new Ztree("0", "",user.getStation(), "");
		outCenter=user.getStation();
		Ztree buslineztree = new Ztree("12", "0", "班车线路", "");
		ztrees.add(parent);
		ztrees.add(buslineztree);
		List<Busline> busLines = buslineService.findByOutcenter(outCenter);
		int i=0;
		for (Busline busline : busLines) {
			ztrees.add(new Ztree(busline.getId(), "12", busline.getId()+" "+busline.getName(), ""));
			i++;
		}
		
		i=0;
		//添加航空线路
		Ztree airlineztree = new Ztree("13", "0", "航空线路", "");
		ztrees.add(airlineztree);
		List<Airline> airlines = airlineService.findByOutcenter(outCenter);
		for (Airline airline : airlines) {
			ztrees.add(new Ztree(airline.getId(), "13", airline.getFlightnum()+" "+airline.getStartairport()+"-"+airline.getEndair(), ""));
			i++;
		}
		
		
		i=0;
		//添加海运线路
		Ztree oceanlineztree = new Ztree("14", "0", "海运线路", "");
		ztrees.add(oceanlineztree);
		List<Oceanline> oceanlines = oceanlineService.findByOutcenter(outCenter);
		for (Oceanline oceanline : oceanlines) {
			ztrees.add(new Ztree(oceanline.getId(), "14", oceanline.getRoute()+" "+oceanline.getStartport()+"-"+oceanline.getEndport(), ""));
			i++;
		}
		
		
		i=0;
		//添加铁路线路
		Ztree   railwaylineztree= new Ztree("15", "0", "铁路线路", "");
		ztrees.add(railwaylineztree);
		List<Railwayline>  railwaylines= railwaylineService.findByOutcenter(outCenter);
		for (Railwayline railwayline : railwaylines) {
			ztrees.add(new Ztree(railwayline.getId(), "15", railwayline.getTrainnum()+" "+railwayline.getStartstation()+"-"+railwayline.getEndstation(), ""));
			i++;
		}
		
		return ztrees;
		
	}
	
	
	

}
