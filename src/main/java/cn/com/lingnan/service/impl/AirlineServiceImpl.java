package cn.com.lingnan.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.lingnan.mapper.AirlineMapper;
import cn.com.lingnan.pojo.Airline;
import cn.com.lingnan.pojo.AirlineExample;
import cn.com.lingnan.pojo.AirlineExample.Criteria;
import cn.com.lingnan.service.AirlineService;
import cn.com.lingnan.utils.PageBean;

@Service(value="airlineService")
public class AirlineServiceImpl  implements AirlineService{
	@Autowired
	private  AirlineMapper airlineMapper;

	@Override
	public void save(Airline airline)  {
		Airline airline2 = airlineMapper.selectByPrimaryKey(airline.getId());
		if(airline2==null){
			airlineMapper.insertSelective(airline);
		}else{
			update(airline);
		}
		
	}

	@Override
	public void pageQuery(PageBean pageBean,Airline airline) {
		AirlineExample airlineExample = new AirlineExample();
		Criteria createCriteria = airlineExample.createCriteria();
		if(airline.getId()!=null && ""!=airline.getId() ){
			createCriteria.andIdLike(airline.getId()+"%");
		}
		if(airline.getFlightnum()!=null && ""!=airline.getFlightnum()){
			createCriteria.andFlightnumLike("%"+airline.getFlightnum()+"%");
		}


		
		Page page = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
		List<Airline> airlines = airlineMapper.selectByExample(airlineExample);
		if (!airlines.isEmpty()) {
			pageBean.setRows(airlines);
		}else{
			pageBean.setRows(new ArrayList<Airline>());
		}
		pageBean.setTotal(page.getTotal());
	}

	@Override
	public void deleteBatch(String ids) {
		AirlineExample airlineExample = new AirlineExample();
		Criteria createCriteria = airlineExample.createCriteria();
		String[] split = ids.split(",");
		List<String> asList = Arrays.asList(split);
		createCriteria.andIdIn(asList);
		airlineMapper.deleteByExample(airlineExample);
		
	}

	@Override
	public Airline findById(String id) {
		
		return airlineMapper.selectByPrimaryKey(id);
	}
	
	
	@Override
	public List<Airline> findAll() {
		AirlineExample airlineExample = new AirlineExample();
		return airlineMapper.selectByExample(airlineExample);
	}

	@Override
	public int update(Airline airline) {
		return airlineMapper.updateByPrimaryKeySelective(airline);
		
	}
	

	@Override
	public List<Airline> findByOutcenter(String outCenter){
		AirlineExample airlineExample = new AirlineExample();
		Criteria createCriteria = airlineExample.createCriteria();
		createCriteria.andOutcenterLike("%"+outCenter+"%");
		return airlineMapper.selectByExample(airlineExample);
	}
	

}
