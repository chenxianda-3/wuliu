package cn.com.lingnan.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.com.lingnan.pojo.Decidedzone;
import cn.com.lingnan.pojo.Region;
import cn.com.lingnan.pojo.Subarea;
import cn.com.lingnan.service.SubareaService;
import cn.com.lingnan.utils.FileUtils;
import cn.com.lingnan.utils.POIUtil;
import cn.com.lingnan.utils.PageBean;

@Controller
@RequestMapping("/subarea")
public class SubareaController {

	@Resource(name = "subareaService")
	private SubareaService subareaService;
	

	@RequestMapping("/findBypageUi")
	public String toFindBypageUi() {
		return "base/subarea";
	}

	/**
	 * 分页查询方法
	 */
	@RequestMapping("/findBypage")
	@ResponseBody
	public PageBean pageQuery(@RequestParam(required = true, defaultValue = "1") String page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") String pagesize, Subarea subarea,
			HttpServletRequest request) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pagesize));
		System.out.println(subarea.toString());
		subareaService.pageQuery(pageBean, subarea);
//		System.out.println(pageBean.toString());
		return pageBean;
	}

	@RequestMapping("/findById")
	@ResponseBody
	public Subarea findById(String id) {
		System.out.println(id);
		Subarea subarea = subareaService.findById(id);
		return subarea;
	}
	
	
	@RequestMapping("/findDecidedzoneBySSQ")
	@ResponseBody
	public List<Decidedzone> findDecidezoneBySSQ(Region region) {
		List<Decidedzone> decidedzones = subareaService.findDecidezoneBySSQ(region);
		return decidedzones;
	}
	
	
	
	@RequestMapping("/findByDecidedzoneId")
	@ResponseBody
	   List<Subarea> findByDecidedzoneId(String decidedzoneId){
		return subareaService.findByDecidedzoneId(decidedzoneId);
	}
	

	@RequestMapping("/addSubarea")
	@ResponseBody
	public boolean addSubarea(Subarea subarea) throws Exception {
		System.out.println(subarea.toString());
		try {
			subareaService.save(subarea);
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
			subareaService.deleteBatch(ids);
			return true;
		} catch (Exception e) {
			System.out.println("aaa");
			return false;
		}
	}

	@RequestMapping("/updateById")
	@ResponseBody
	public boolean updateById(Subarea subarea) {
		try {
			// 判断有没有修改
			if (0 != subareaService.updateById(subarea)) {
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
		List<Subarea> subareaList = new ArrayList<Subarea>();
		//判断上传的文件是否符合格式和上传的文件是否存在
		try {
			POIUtil.checkFile(importFile);
		} catch (IOException e1) {
			//回传错误信息
			return e1.getMessage();
		}
		try {
			List<String[]> list = POIUtil.readExcel(importFile); // 这里得到的是一个集合，里面的每一个元素是String[]数组
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				String[] strings = (String[]) iterator.next();
				Subarea subarea = new Subarea(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5],
						strings[6],strings[7]);
				System.out.println(subarea.toString());
				subareaList.add(subarea);
				
			}
			int influence = subareaService.saveBatch(subareaList);
			session.removeAttribute("importedFlag");
			//判断受影响的条数
			if (0==influence) {
				return "已经存在这些记录";
			}
		} catch (Exception e) {
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
	
	
	@RequestMapping("/exportXls")
	public void exportXls(HttpSession httpSession,HttpServletResponse httpServletResponse,HttpServletRequest  httpServletRequest) throws IOException{
		List<Subarea> list = subareaService.findAll();
		
		String[] excelHeader={"分区编号","所属定区编号","所属区域编号","关键词","位置","开始编号",
				"结束编号","单双号(0单双号，1单号，2双号)"};
		
		String[] excelHeadKey={"id","decidedzoneId","regionId","addresskey","position","startnum",
				"endnum","single"};
		HSSFWorkbook workbook = POIUtil.exportExcel(excelHeader, excelHeadKey, list);
		
		//第三步：使用输出流进行文件下载（一个流、两个头）
		String filename = "分区数据.xls";
		String contentType =httpSession.getServletContext().getMimeType(filename);
		ServletOutputStream out = httpServletResponse.getOutputStream();
		httpServletResponse.setContentType(contentType);
		
		//获取客户端浏览器类型
		String agent =httpServletRequest.getHeader("User-Agent");
		filename = FileUtils.encodeDownloadFilename(filename, agent);
		httpServletResponse.setHeader("content-disposition", "attachment;filename="+filename);
		workbook.write(out);
	}
	
	
	

}
