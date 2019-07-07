package cn.com.lingnan.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.lingnan.mapper.OceanlineMapper;
import cn.com.lingnan.pojo.Oceanline;
import cn.com.lingnan.pojo.OceanlineExample;
import cn.com.lingnan.pojo.OceanlineExample.Criteria;
import cn.com.lingnan.service.OceanlineService;
import cn.com.lingnan.utils.PageBean;

@Service(value="oceanlineService")
public class OceanlineServiceImpl  implements OceanlineService{
	@Autowired
	private  OceanlineMapper oceanlineMapper;

	@Override
	public void save(Oceanline oceanline)  {
		Oceanline oceanline2 = oceanlineMapper.selectByPrimaryKey(oceanline.getId());
		if(oceanline2==null){
			oceanlineMapper.insertSelective(oceanline);
		}else{
			update(oceanline);
		}
		
	}

	@Override
	public void pageQuery(PageBean pageBean,Oceanline oceanline) {
		OceanlineExample oceanlineExample = new OceanlineExample();
		Criteria createCriteria = oceanlineExample.createCriteria();
		if(oceanline.getId()!=null && ""!=oceanline.getId() ){
			createCriteria.andIdLike(oceanline.getId()+"%");
		}
		if(oceanline.getRoute()!=null && ""!=oceanline.getRoute()){
			createCriteria.andRouteLike("%"+oceanline.getRoute()+"%");
		}


		
		Page page = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
		List<Oceanline> oceanlines = oceanlineMapper.selectByExample(oceanlineExample);
		if (!oceanlines.isEmpty()) {
			pageBean.setRows(oceanlines);
		}else{
			pageBean.setRows(new ArrayList<Oceanline>());
		}
		pageBean.setTotal(page.getTotal());
	}

	@Override
	public void deleteBatch(String ids) {
		OceanlineExample oceanlineExample = new OceanlineExample();
		Criteria createCriteria = oceanlineExample.createCriteria();
		String[] split = ids.split(",");
		List<String> asList = Arrays.asList(split);
		createCriteria.andIdIn(asList);
		oceanlineMapper.deleteByExample(oceanlineExample);
		
	}

	@Override
	public Oceanline findById(String id) {
		
		return oceanlineMapper.selectByPrimaryKey(id);
	}
	
	
	@Override
	public List<Oceanline> findAll() {
		OceanlineExample oceanlineExample = new OceanlineExample();
		return oceanlineMapper.selectByExample(oceanlineExample);
	}

	@Override
	public int update(Oceanline oceanline) {
		return oceanlineMapper.updateByPrimaryKeySelective(oceanline);
		
	}
	

	@Override
	public List<Oceanline> findByOutcenter(String outCenter){
		OceanlineExample oceanlineExample = new OceanlineExample();
		Criteria createCriteria = oceanlineExample.createCriteria();
		createCriteria.andOutcenterLike("%"+outCenter+"%");
		return oceanlineMapper.selectByExample(oceanlineExample);
	}

}
