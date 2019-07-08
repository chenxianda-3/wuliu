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

import org.apache.commons.lang3.text.StrBuilder;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.com.lingnan.pojo.Customer;
import cn.com.lingnan.pojo.Decidedzone;
import cn.com.lingnan.pojo.Subarea;
import cn.com.lingnan.service.CustomerService;
import cn.com.lingnan.service.DecidedzoneService;
import cn.com.lingnan.utils.FileUtils;
import cn.com.lingnan.utils.POIUtil;
import cn.com.lingnan.utils.PageBean;

@Controller
@RequestMapping("/decidedzone")
public class DecidedzoneController {

	@Resource(name = "decidedzoneService")
	private DecidedzoneService decidedzoneService;
	
	@Resource(name = "customerService")
	private CustomerService customerService;
	

	@RequestMapping("/findBypageUi")
	public String toFindBypageUi() {
		return "base/decidedzone";
	}

	/**
	 * 分页查询方法
	 */
	@RequestMapping("/findBypage")
	@ResponseBody
	public PageBean pageQuery(@RequestParam(required = true, defaultValue = "1") String page,
			@RequestParam(value = "rows", required = true, defaultValue = "10") String pagesize, Decidedzone decidedzone,
			HttpServletRequest request) {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pagesize));
		System.out.println(decidedzone.toString());
		decidedzoneService.pageQuery(pageBean, decidedzone);
//		System.out.println(pageBean.toString());
		return pageBean;
	}

	@RequestMapping("/findById")
	@ResponseBody
	public Decidedzone findById(String id) {
		System.out.println(id);
		Decidedzone decidedzone = decidedzoneService.findById(id);
		System.out.println(decidedzone.toString());
		return decidedzone;
	}
	
	@RequestMapping("/findCustomersByDecidedzoneId")
	@ResponseBody
	   List<Customer> findCustomersByDecidedzoneId(String decidedzoneId){
		return customerService.findByDecidedzoneId(decidedzoneId);
	}
	
	
	

	@RequestMapping("/addDecidedzone")
	@ResponseBody
	public boolean addDecidedzone(Decidedzone decidedzone,String ids)  {
		System.out.println(decidedzone.toString());
		System.out.println(ids+"ccc");
		decidedzoneService.save(decidedzone,ids);
		return true;

	}
	
	//批量删除

	@RequestMapping("/deleteBatch")
	@ResponseBody
	public boolean deleteBatch(String ids) {
		try {
			decidedzoneService.deleteBatch(ids);
			return true;
		} catch (Exception e) {
			System.out.println("aaa");
			return false;
		}
	}

	@RequestMapping("/updateById")
	@ResponseBody
	public boolean updateById(Decidedzone decidedzone) {
		try {
			// 判断有没有修改
			if (0 != decidedzoneService.update(decidedzone)) {
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
		List<Decidedzone> decidedzoneList = new ArrayList<Decidedzone>();
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
				Decidedzone decidedzone = new Decidedzone(strings[0], strings[1], strings[2], strings[3]);
				System.out.println(decidedzone.toString());
				decidedzoneList.add(decidedzone);
				
			}
			int influence = decidedzoneService.saveBatch(decidedzoneList);
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
		List<Decidedzone> list = decidedzoneService.findAll();
		
		String[] excelHeader={"定区编号","分配取派员编号","所属区域编号","定区名称"};
		
		String[] excelHeadKey={"id","staffId","regionId","name"};
		HSSFWorkbook workbook = POIUtil.exportExcel(excelHeader, excelHeadKey, list);
		
		//第三步：使用输出流进行文件下载（一个流、两个头）
		String filename = "定区数据.xls";
		String contentType =httpSession.getServletContext().getMimeType(filename);
		ServletOutputStream out = httpServletResponse.getOutputStream();
		httpServletResponse.setContentType(contentType);
		
		//获取客户端浏览器类型
		String agent =httpServletRequest.getHeader("User-Agent");
		filename = FileUtils.encodeDownloadFilename(filename, agent);
		httpServletResponse.setHeader("content-disposition", "attachment;filename="+filename);
		workbook.write(out);
	}
	
	
	/**
	 * 远程调用crm服务，获取未关联到定区的客户
	 */
	@RequestMapping("/findListNotAssociation")
	@ResponseBody
	public List<Customer> findListNotAssociation(){
		return  customerService.findListNotAssociation();
	}
	
	/**
	 * 远程调用crm服务，获取已经关联到指定的定区的客户
	 */
	
	@RequestMapping("/findListHasAssociation")
	@ResponseBody
	public List<Customer> findListHasAssociation(String id){
		return  customerService.findListHasAssociation(id);
	}
	
	/**
	 * 远程调用crm服务，将客户关联到定区
	 */
	
	@RequestMapping("/assignCustomersToDecidedzone")
	@ResponseBody
	public String assignCustomersToDecidedzone(String decidedzoneId,String[] customerIds){
		System.out.println(decidedzoneId);
		for (String string : customerIds) {
			System.out.print(string+"  ");
		}
		if (decidedzoneId==null || decidedzoneId=="" || customerIds.length<=0) {
			return "false";
		}
		try {
			customerService.assignCustomersToDecidedzone(decidedzoneId, customerIds);
			return "true";
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return "false";
	}
	
	

}
