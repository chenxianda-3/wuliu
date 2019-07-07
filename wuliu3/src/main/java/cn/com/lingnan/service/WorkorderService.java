package cn.com.lingnan.service;


import java.util.List;

import cn.com.lingnan.pojo.Workorder;
import cn.com.lingnan.utils.PageBean;

public interface WorkorderService {

	public void save(Workorder workorder) ;

	public void deleteBatch(String ids);

	public Workorder findById(String id);

	public int update(Workorder workorder);

	void pageQuery(PageBean pageBean, Workorder workorder);


	List<Workorder> findAll();

}
