package cn.com.lingnan.service;


import java.util.List;

import cn.com.lingnan.pojo.Region;
import cn.com.lingnan.utils.PageBean;

public interface RegionService {

	public void save(Region region) ;

	public void deleteBatch(String ids);

	public Region findById(String id);

	public int update(Region region);

	void pageQuery(PageBean pageBean, Region region);

	int saveBatch(List<Region> regionList);

	String findBySSQ(Region region);

	List<Region> findAll();

}
