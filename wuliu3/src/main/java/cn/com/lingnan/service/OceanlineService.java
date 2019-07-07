package cn.com.lingnan.service;


import java.util.List;

import cn.com.lingnan.pojo.Oceanline;
import cn.com.lingnan.utils.PageBean;

public interface OceanlineService {

	public void save(Oceanline oceanline) ;

	public void deleteBatch(String ids);

	public Oceanline findById(String id);

	public int update(Oceanline oceanline);

	void pageQuery(PageBean pageBean, Oceanline oceanline);


	List<Oceanline> findAll();

	List<Oceanline> findByOutcenter(String outCenter);

}
