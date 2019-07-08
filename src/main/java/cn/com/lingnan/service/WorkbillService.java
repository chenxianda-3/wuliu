package cn.com.lingnan.service;


import java.util.List;

import cn.com.lingnan.pojo.Workbill;
import cn.com.lingnan.pojo.Workbill;
import cn.com.lingnan.utils.PageBean;

public interface WorkbillService {

	public void save(Workbill workbill) ;

	public void delete(String id);

	public Workbill findById(String id);

	public void update(Workbill workbill);

	List<Workbill> findAll();
	
	public String deleteBatch(String ids);
	
	void pageQuery(PageBean pageBean, Workbill workbill);

	int saveBatch(List<Workbill> workbillList);

	String attachBill(String id);

	public void diaoDuBypage(PageBean pageBean, Workbill workbill);

	void diaoDu(String ids);

	public void updateStaffId(Workbill workbill);

}
