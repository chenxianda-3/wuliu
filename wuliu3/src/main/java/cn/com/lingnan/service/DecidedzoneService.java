package cn.com.lingnan.service;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.com.lingnan.pojo.Decidedzone;
import cn.com.lingnan.utils.PageBean;

public interface DecidedzoneService {


	public void deleteBatch(String ids);

	public Decidedzone findById(String id);

	public int update(Decidedzone decidedzone);

	void pageQuery(PageBean pageBean, Decidedzone decidedzone);

	int saveBatch(List<Decidedzone> decidedzoneList);

	List<Decidedzone> findByRegionId(String regionId);

	List<Decidedzone> findAll();

	void save(Decidedzone decidedzone, String ids) ;

	Decidedzone findByDecidedzoneName(String decidedzoneName);


}
