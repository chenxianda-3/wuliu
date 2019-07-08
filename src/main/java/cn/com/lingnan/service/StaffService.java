package cn.com.lingnan.service;


import java.util.List;

import cn.com.lingnan.exception.MyException;
import cn.com.lingnan.pojo.Staff;
import cn.com.lingnan.utils.PageBean;

public interface StaffService {

	public void save(Staff staff) ;

	public void deleteBatch(String ids);

	public Staff findById(String id);

	public int update(Staff staff);

	void pageQuery(PageBean pageBean, Staff staff);

	int saveBatch(List<Staff> staffList);

	List<Staff> findAll();

}
