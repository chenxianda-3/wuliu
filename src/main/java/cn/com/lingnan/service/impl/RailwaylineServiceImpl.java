package cn.com.lingnan.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.lingnan.mapper.RailwaylineMapper;
import cn.com.lingnan.pojo.Railwayline;
import cn.com.lingnan.pojo.RailwaylineExample;
import cn.com.lingnan.pojo.RailwaylineExample.Criteria;
import cn.com.lingnan.service.RailwaylineService;
import cn.com.lingnan.utils.PageBean;

@Service(value="railwaylineService")
public class RailwaylineServiceImpl  implements RailwaylineService{
	@Autowired
	private  RailwaylineMapper railwaylineMapper;

	@Override
	public void save(Railwayline railwayline)  {
		Railwayline railwayline2 = railwaylineMapper.selectByPrimaryKey(railwayline.getId());
		if(railwayline2==null){
			railwaylineMapper.insertSelective(railwayline);
		}else{
			update(railwayline);
		}
		
	}

	@Override
	public void pageQuery(PageBean pageBean,Railwayline railwayline) {
		RailwaylineExample railwaylineExample = new RailwaylineExample();
		Criteria createCriteria = railwaylineExample.createCriteria();
		if(railwayline.getId()!=null && ""!=railwayline.getId() ){
			createCriteria.andIdLike(railwayline.getId()+"%");
		}
		if(railwayline.getTrainnum()!=null && ""!=railwayline.getTrainnum()){
			createCriteria.andTrainnumLike("%"+railwayline.getTrainnum()+"%");
		}


		
		Page page = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
		List<Railwayline> railwaylines = railwaylineMapper.selectByExample(railwaylineExample);
		if (!railwaylines.isEmpty()) {
			pageBean.setRows(railwaylines);
		}else{
			pageBean.setRows(new ArrayList<Railwayline>());
		}
		pageBean.setTotal(page.getTotal());
	}

	@Override
	public void deleteBatch(String ids) {
		RailwaylineExample railwaylineExample = new RailwaylineExample();
		Criteria createCriteria = railwaylineExample.createCriteria();
		String[] split = ids.split(",");
		List<String> asList = Arrays.asList(split);
		createCriteria.andIdIn(asList);
		railwaylineMapper.deleteByExample(railwaylineExample);
		
	}

	@Override
	public Railwayline findById(String id) {
		
		return railwaylineMapper.selectByPrimaryKey(id);
	}
	
	
	@Override
	public List<Railwayline> findAll() {
		RailwaylineExample railwaylineExample = new RailwaylineExample();
		return railwaylineMapper.selectByExample(railwaylineExample);
	}

	@Override
	public int update(Railwayline railwayline) {
		return railwaylineMapper.updateByPrimaryKeySelective(railwayline);
		
	}
	
	@Override
	public List<Railwayline> findByOutcenter(String outCenter){
		RailwaylineExample railwaylineExample = new RailwaylineExample();
		Criteria createCriteria = railwaylineExample.createCriteria();
		createCriteria.andOutcenterLike("%"+outCenter+"%");
		return railwaylineMapper.selectByExample(railwaylineExample);
	}
	

}
