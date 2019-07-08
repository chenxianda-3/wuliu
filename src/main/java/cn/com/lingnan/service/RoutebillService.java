package cn.com.lingnan.service;


import java.util.List;

import cn.com.lingnan.pojo.Routebill;
import cn.com.lingnan.pojo.Routelinebill;
import cn.com.lingnan.utils.PageBean;

public interface RoutebillService {

	public void save(Routebill routebill) ;

	public void deleteBatch(String ids);

	public Routebill findById(String id);

	public int update(Routebill routebill);

	void pageQuery(PageBean pageBean, Routebill routebill);


	List<Routebill> findAll();

	List<Routebill> findByStartToEnd(Routelinebill routelinebill);

	public void tongBu(String id);

}
