package cn.com.lingnan.service;


import java.util.List;

import cn.com.lingnan.pojo.Railwayline;
import cn.com.lingnan.utils.PageBean;

public interface RailwaylineService {

	public void save(Railwayline railwayline) ;

	public void deleteBatch(String ids);

	public Railwayline findById(String id);

	public int update(Railwayline railwayline);

	void pageQuery(PageBean pageBean, Railwayline railwayline);


	List<Railwayline> findAll();

	List<Railwayline> findByOutcenter(String outCenter);

}
