package cn.com.lingnan.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.lingnan.mapper.RoutebillMapper;
import cn.com.lingnan.mapper.RoutelinebillMapper;
import cn.com.lingnan.pojo.Routebill;
import cn.com.lingnan.pojo.RoutebillExample;
import cn.com.lingnan.pojo.RoutebillExample.Criteria;
import cn.com.lingnan.pojo.Routelinebill;
import cn.com.lingnan.service.RoutebillService;
import cn.com.lingnan.service.RoutelinebillService;
import cn.com.lingnan.utils.PageBean;
import cn.com.lingnan.utils.UUIDUtils;

@Service(value="routebillService")
public class RoutebillServiceImpl  implements RoutebillService{
	@Autowired
	private  RoutebillMapper routebillMapper;
	
	@Autowired
	private  RoutelinebillMapper routelinebillMapper;
	
	@Resource(name = "routelinebillService")
	private RoutelinebillService routelinebillService;
	
	
	@Override
	@Transactional
	public List<Routebill> findByStartToEnd(Routelinebill routelinebill) {
		List<Routelinebill> findByStartCity = routelinebillService.findByStartCity(routelinebill.getStartstation());
		Routebill routebill = new Routebill();
		routebill.setStartcity(routelinebill.getStartstation());//如北京
		routebill.setEndcity(routelinebill.getEndstation());//湛江
		List<Routebill> results=new ArrayList<>();
		trial(findByStartCity, routebill, results);
		
		for (Iterator iterator = results.iterator(); iterator.hasNext();) {
			Routebill routebill1 = (Routebill) iterator.next();
			save(routebill1);
			for (Routelinebill routelinebill2 : routebill1.getRoutelinebills()) {
				routelinebill2.setRoutebillId(routebill1.getId());
				routelinebillMapper.insertSelective(routelinebill2);
			}
			
		}
		
		
		
		return results;
	}
	
	
	
	public  void  trial(List<Routelinebill> startline,Routebill result,List<Routebill> results){
		for (Iterator iterator = startline.iterator(); iterator.hasNext();) {
			Routebill result2 = (Routebill)result.clone();
			Routelinebill routelinebill = (Routelinebill) iterator.next();
			routelinebill.setId(UUIDUtils.getId());
			
			//保存路由起始时间
			if (routelinebill.getStartstation().equals(result2.getStartcity())) {
				result2.setStarttime(routelinebill.getStarttime());
				result2.setName(result2.getStartcity()+"-"+result2.getEndcity()+"(起始："+routelinebill.getLinename()+")");
				//每一次刚开始循环都清空
				
			}
			
			result2.setRouteprice(routelinebill.getLineprice()+result2.getRouteprice());
			result2.setMileage(routelinebill.getMileage()+result2.getMileage());
			result2.setSumDuration(routelinebill.getDuration()+result2.getSumDuration());
			result2.getRoutelinebills().add(routelinebill);
			
			//如果终点一致就存起来继续下一个遍历
			if (routelinebill.getEndstation().equals(result2.getEndcity())) {
				result2.setEndtime(routelinebill.getEndtime());
				result2.getTimelimit();
				result2.setId(UUIDUtils.getId());
				results.add(result2);
				continue;
			}
			
			
			//不一致就存到中转站中
			if (result2.getTransfernode1()==null) {
				result2.setTransfernode1(routelinebill.getEndstation());
			
			}else if (result2.getTransfernode2()==null) {
				result2.setTransfernode2(routelinebill.getEndstation());
	
			}else if (result2.getTransfernode3()==null) {
				result2.setTransfernode3(routelinebill.getEndstation());
			
			}else if (result2.getTransfernode4()==null) {
				result2.setTransfernode4(routelinebill.getEndstation());
			
			}else{
				continue;
			}
			
		
			
			List<Routelinebill> findByStartCity = routelinebillService.findByStartCity(routelinebill.getEndstation());
			if (findByStartCity == null) {
				continue;
			}
			
			trial(findByStartCity, result2, results);
		}
	}
	
	
	
	
	
	
	

	@Override
	public void save(Routebill routebill)  {
		Routebill routebill2 = routebillMapper.selectByPrimaryKey(routebill.getId());
		if(routebill2==null){
			routebillMapper.insertSelective(routebill);
		}else{
			update(routebill);
		}
		
	}

	@Override
	public void pageQuery(PageBean pageBean,Routebill routebill) {
		RoutebillExample routebillExample = new RoutebillExample();
		Criteria createCriteria = routebillExample.createCriteria();
		if(routebill.getStartcity()!=null && ""!=routebill.getStartcity() ){
			createCriteria.andStartcityLike(routebill.getStartcity()+"%");
		}
		if(routebill.getEndcity()!=null && ""!=routebill.getEndcity() ){
			createCriteria.andEndcityLike(routebill.getEndcity()+"%");
		}

		if(routebill.getTimelimit()!=null && ""!=routebill.getTimelimit() ){
			createCriteria.andTimelimitLike(routebill.getTimelimit()+"%");
		}




		createCriteria.andFlagEqualTo("1");
		Page page = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
		List<Routebill> routebills = routebillMapper.selectByExample(routebillExample);
		if (!routebills.isEmpty()) {
			pageBean.setRows(routebills);
		}else{
			pageBean.setRows(new ArrayList<Routebill>());
		}
		pageBean.setTotal(page.getTotal());
	}

	@Override
	public void deleteBatch(String ids) {
		RoutebillExample routebillExample = new RoutebillExample();
		Criteria createCriteria = routebillExample.createCriteria();
		String[] split = ids.split(",");
		List<String> asList = Arrays.asList(split);
		createCriteria.andIdIn(asList);
		Routebill routebill = new Routebill();
		routebill.setFlag("0");
		routebillMapper.updateByExampleSelective(routebill, routebillExample);		
	}

	@Override
	public Routebill findById(String id) {
		
		return routebillMapper.selectByPrimaryKey(id);
	}


	
	
	
	@Override
	public List<Routebill> findAll() {
		RoutebillExample routebillExample = new RoutebillExample();
		return routebillMapper.selectByExample(routebillExample);
	}

	
	
	@Override
	public int update(Routebill routebill) {
		return routebillMapper.updateByPrimaryKeySelective(routebill);
		
	}



	@Override
	public void tongBu(String id) {
		RoutebillExample routebillExample = new RoutebillExample();
		Criteria createCriteria = routebillExample.createCriteria();
		createCriteria.andIdEqualTo(id);
		Routebill routebill = new Routebill();
		routebill.setFlag("1");
		routebillMapper.updateByExampleSelective(routebill, routebillExample);
	}
	
	
	

	

}
