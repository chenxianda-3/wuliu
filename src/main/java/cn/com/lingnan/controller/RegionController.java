package cn.com.lingnan.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.print.attribute.standard.PrinterState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.com.lingnan.pojo.Region;
import cn.com.lingnan.service.RegionService;
import cn.com.lingnan.utils.POIUtil;
import cn.com.lingnan.utils.PageBean;

@Controller
@RequestMapping("/region")
public class RegionController {

	@Resource(name = "regionService")
	private RegionService regionService;

	@RequestMapping("/findBypageUi")
	public String toFindBypageUi() {
		return "base/region";
	}

	/**
	 * 分页查询方法
	 */
	@RequestMapping("/findBypage")
	@ResponseBody
	public PageBean pageQuery(@RequestParam(required = true, defaultValue = "1") String page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") String pagesize, Region region,
			HttpServletRequest request) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pagesize));
		System.out.println(region.toString());
		regionService.pageQuery(pageBean, region);
		return pageBean;
	}

	@RequestMapping("/findById")
	@ResponseBody
	public Region findById(String id) {
		System.out.println("aaa");
		System.out.println(id);
		Region region = regionService.findById(id);
		return region;
	}

/*	@RequestMapping("/addRegion")
	@ResponseBody
	public boolean addRegion(Region region) throws Exception {
		try {
			regionService.save(region);
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	*/
	//批量删除

	@RequestMapping("/deleteBatch")
	@ResponseBody
	public boolean deleteBatch(String ids) {
		try {
			regionService.deleteBatch(ids);
			return true;
		} catch (Exception e) {
			System.out.println("aaa");
			return false;
		}
	}

	@RequestMapping("/updateById")
	@ResponseBody
	public boolean updateById(Region region) {
		try {
			// 判断有没有修改
			if (0 != regionService.update(region)) {
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
		List<Region> regionList = new ArrayList<Region>();
		//判断上传的文件是否符合格式和上传的文件是否存在
		try {
			POIUtil.checkFile(importFile);
		} catch (IOException e1) {
			//回传错误信息
			return e1.getMessage();
		}
		try {
			 regionList = POIUtil.readRegionExcel(importFile);
			int influence = regionService.saveBatch(regionList);
			session.removeAttribute("importedFlag");
			//判断受影响的条数
			if (0==influence) {
				return "已经存在这些记录";
			}
		} catch (Exception e) {
			e.printStackTrace();
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
	

}
