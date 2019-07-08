package cn.com.lingnan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.lingnan.mapper.RoutelinebillMapper;
import cn.com.lingnan.pojo.Routelinebill;
import cn.com.lingnan.pojo.RoutelinebillExample;
import cn.com.lingnan.pojo.RoutelinebillExample.Criteria;
import cn.com.lingnan.service.RoutelinebillService;

@Service(value="routelinebillService")
public class RoutelinebillServiceImpl  implements RoutelinebillService{
	@Autowired
	private  RoutelinebillMapper routelinebillMapper;

	@Override
	public List<Routelinebill> findByStartCity(String startCity) {
		List<Routelinebill> routelinebills = routelinebillMapper.findByStartCity(startCity);
		return routelinebills;
	}

	@Override
	public List<Routelinebill> findLineByRoutebillId(String routebillId) {
		RoutelinebillExample routelinebillExample = new RoutelinebillExample();
		Criteria createCriteria = routelinebillExample.createCriteria();
		createCriteria.andRoutebillIdEqualTo(routebillId);
		List<Routelinebill> selectByExample = routelinebillMapper.selectByExample(routelinebillExample);
		return selectByExample;
	}
	
	

	
	

	

}
