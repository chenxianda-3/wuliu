package cn.com.lingnan.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.lingnan.mapper.BuslineMapper;
import cn.com.lingnan.pojo.Busline;
import cn.com.lingnan.pojo.BuslineExample;
import cn.com.lingnan.pojo.BuslineExample.Criteria;
import cn.com.lingnan.service.BuslineService;
import cn.com.lingnan.utils.PageBean;

@Service(value="buslineService")
public class BuslineServiceImpl  implements BuslineService{
	@Autowired
	private  BuslineMapper buslineMapper;

	@Override
	public void save(Busline busline)  {
		Busline busline2 = buslineMapper.selectByPrimaryKey(busline.getId());
		if(busline2==null){
			buslineMapper.insertSelective(busline);
		}else{
			update(busline);
		}
		
	}

	@Override
	public void pageQuery(PageBean pageBean,Busline busline) {
		BuslineExample buslineExample = new BuslineExample();
		Criteria createCriteria = buslineExample.createCriteria();
		if(busline.getId()!=null && ""!=busline.getId() ){
			createCriteria.andIdLike(busline.getId()+"%");
		}
		if(busline.getName()!=null && ""!=busline.getName()){
			createCriteria.andNameLike("%"+busline.getName()+"%");
		}


		
		Page page = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
		List<Busline> buslines = buslineMapper.selectByExample(buslineExample);
		if (!buslines.isEmpty()) {
			pageBean.setRows(buslines);
		}else{
			pageBean.setRows(new ArrayList<Busline>());
		}
		pageBean.setTotal(page.getTotal());
	}

	@Override
	public void deleteBatch(String ids) {
		BuslineExample buslineExample = new BuslineExample();
		Criteria createCriteria = buslineExample.createCriteria();
		String[] split = ids.split(",");
		List<String> asList = Arrays.asList(split);
		createCriteria.andIdIn(asList);
		buslineMapper.deleteByExample(buslineExample);
		
	}

	@Override
	public Busline findById(String id) {
		
		return buslineMapper.selectByPrimaryKey(id);
	}
	
	
	@Override
	public List<Busline> findAll() {
		BuslineExample buslineExample = new BuslineExample();
		return buslineMapper.selectByExample(buslineExample);
	}

	@Override
	public int update(Busline busline) {
		return buslineMapper.updateByPrimaryKeySelective(busline);
		
	}
	

	@Override
	public List<Busline> findByOutcenter(String outCenter){
		BuslineExample buslineExample = new BuslineExample();
		Criteria createCriteria = buslineExample.createCriteria();
		createCriteria.andOutcenterLike("%"+outCenter+"%");
		return buslineMapper.selectByExample(buslineExample);
	}
	

}
