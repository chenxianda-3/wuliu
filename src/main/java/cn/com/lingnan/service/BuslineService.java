package cn.com.lingnan.service;


import java.util.List;

import cn.com.lingnan.pojo.Busline;
import cn.com.lingnan.utils.PageBean;

public interface BuslineService {

	public void save(Busline busline) ;

	public void deleteBatch(String ids);

	public Busline findById(String id);

	public int update(Busline busline);

	void pageQuery(PageBean pageBean, Busline busline);


	List<Busline> findAll();

	List<Busline> findByOutcenter(String outCenter);

}
