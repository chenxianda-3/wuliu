package cn.com.lingnan.service;


import java.util.List;

import cn.com.lingnan.pojo.Airline;
import cn.com.lingnan.utils.PageBean;

public interface AirlineService {

	public void save(Airline airline) ;

	public void deleteBatch(String ids);

	public Airline findById(String id);

	public int update(Airline airline);

	void pageQuery(PageBean pageBean, Airline airline);


	List<Airline> findAll();

	List<Airline> findByOutcenter(String outCenter);

}
