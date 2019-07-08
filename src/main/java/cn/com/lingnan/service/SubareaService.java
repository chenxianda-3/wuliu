package cn.com.lingnan.service;


import java.util.List;

import cn.com.lingnan.pojo.Decidedzone;
import cn.com.lingnan.pojo.Region;
import cn.com.lingnan.pojo.Subarea;
import cn.com.lingnan.utils.PageBean;

public interface SubareaService {

	public void save(Subarea subarea) ;

	public void deleteBatch(String ids);

	public Subarea findById(String id);
	
	
	public List<Subarea> findByDecidedzoneId(String decidedzoneId);

	public int update(Subarea subarea);

	void pageQuery(PageBean pageBean, Subarea subarea);

	int saveBatch(List<Subarea> subareaList);

	List<Decidedzone> findDecidezoneBySSQ(Region region);

	int updateById(Subarea subarea);

	List<Subarea> findAll();

}
