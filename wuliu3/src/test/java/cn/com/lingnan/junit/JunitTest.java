package cn.com.lingnan.junit;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.lingnan.mapper.RoutelinebillMapper;
import cn.com.lingnan.mapper.UserMapper;
import cn.com.lingnan.pojo.Airline;
import cn.com.lingnan.pojo.Busline;
import cn.com.lingnan.pojo.Oceanline;
import cn.com.lingnan.pojo.Railwayline;
import cn.com.lingnan.pojo.Routebill;
import cn.com.lingnan.pojo.Routelinebill;
import cn.com.lingnan.pojo.Ztree;
import cn.com.lingnan.service.AirlineService;
import cn.com.lingnan.service.BuslineService;
import cn.com.lingnan.service.OceanlineService;
import cn.com.lingnan.service.RailwaylineService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JunitTest {

	@Autowired
	private UserMapper userMapper;
	
	
	
	@Resource(name = "airlineService")
	private AirlineService airlineService;
	
	@Resource(name = "buslineService")
	private BuslineService buslineService;
	
	@Resource(name = "railwaylineService")
	private RailwaylineService railwaylineService;
	
	@Resource(name = "oceanlineService")
	private OceanlineService oceanlineService;
	
	
	@Autowired 
	private   RoutelinebillMapper routelinebillMapper;
	

	@Test
	public void testMapper() throws Exception {
		
		List<Routelinebill> findByStartCity = routelinebillMapper.findByStartCity("北京");

		
		
		Routebill routebill = new Routebill();
		routebill.setStartcity("北京市");
		routebill.setEndcity("湛江市");
		
		List<Routebill> results=new ArrayList<>();
		
		trial(findByStartCity, routebill, results);
		
		for (Iterator iterator = results.iterator(); iterator.hasNext();) {
			Routebill routebill1 = (Routebill) iterator.next();
			System.out.println(routebill1.toString());
		}
		
		
	}
	
	

	
	
	
	public  void  trial(List<Routelinebill> startline,Routebill result,List<Routebill> results ){
		for (Iterator iterator = startline.iterator(); iterator.hasNext();) {
			Routebill result2 = (Routebill)result.clone();
			Routelinebill routelinebill = (Routelinebill) iterator.next();
			
			//保存路由起始时间
			if (routelinebill.getStartstation().equals(result2.getStartcity())) {
				result2.setStarttime(routelinebill.getStarttime());
			}
			
			result2.getRoutelinebills().add(routelinebill);
			//如果终点一致就存起来继续下一个遍历
			if (routelinebill.getEndstation().equals(result2.getEndcity())) {
				result2.setRouteprice(routelinebill.getLineprice()+result2.getRouteprice());
				result2.setMileage(routelinebill.getMileage()+result2.getMileage());
				result2.setEndtime(routelinebill.getEndtime());
				result2.setSumDuration(routelinebill.getDuration()+result2.getSumDuration());
				result2.getTimelimit();
				results.add(result2);
				continue;
			}
			
			
			//不一致就存到中转站中
			if (result2.getTransfernode1()==null) {
				result2.setTransfernode1(routelinebill.getEndstation());
				result2.setRouteprice(routelinebill.getLineprice()+result2.getRouteprice());
				result2.setMileage(routelinebill.getMileage()+result2.getMileage());
				result2.setSumDuration(routelinebill.getDuration()+result2.getSumDuration());
			}else if (result2.getTransfernode2()==null) {
				result2.setTransfernode2(routelinebill.getEndstation());
				result2.setRouteprice(routelinebill.getLineprice()+result2.getRouteprice());
				result2.setMileage(routelinebill.getMileage()+result2.getMileage());
				result2.setSumDuration(routelinebill.getDuration()+result2.getSumDuration());
			}else if (result2.getTransfernode3()==null) {
				result2.setTransfernode3(routelinebill.getEndstation());
				result2.setRouteprice(routelinebill.getLineprice()+result2.getRouteprice());
				result2.setMileage(routelinebill.getMileage()+result2.getMileage());
				result2.setSumDuration(routelinebill.getDuration()+result2.getSumDuration());
			}else if (result2.getTransfernode4()==null) {
				result2.setTransfernode4(routelinebill.getEndstation());
				result2.setRouteprice(routelinebill.getLineprice()+result2.getRouteprice());
				result2.setMileage(routelinebill.getMileage()+result2.getMileage());
				result2.setSumDuration(routelinebill.getDuration()+result2.getSumDuration());
			}else{
				continue;
			}
			
			List<Routelinebill> findByStartCity = routelinebillMapper.findByStartCity(routelinebill.getEndstation());
			if (findByStartCity == null) {
				continue;
			}
			
			trial(findByStartCity, result2, results);
		}
	}
	

	
	private static final long nd = 1000 * 24 * 60 * 60;
	private static final long nh = 1000 * 60 * 60;
	private static final long nm = 1000 * 60;

	
	public void  test1(Date parse1, Date parse2) {
		long time3=86400000;
		long time1= parse1.getTime();
		long time2 = parse2.getTime();
		long diff= time1>time2?time1-time2:time1-time2+time3;
		/*long hour = diff % nd / nh;
		long min = diff % nd % nh / nm;
		long sec = diff % nd % nh % nm / 1000;
		String str = hour + "小时" + min + "分钟" + sec + "秒";
		System.out.println(str);*/

		
	}
	
	
	@Test
	public void   testZtreeList(){
		List<Ztree> testZtree=null;
		try {
			testZtree = testZtree("马驹桥转运中心");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		for (Ztree ztree : testZtree) {
			System.out.println(ztree);
		}
	}
	
	
	
	
	public List<Ztree>  testZtree(String outCenter){
		List<Ztree> ztrees=new ArrayList<>();
		//添加班车线路
		Ztree buslineztree = new Ztree("12", "0", "班车线路", "");
		ztrees.add(buslineztree);
		List<Busline> busLines = buslineService.findByOutcenter(outCenter);
		int i=0;
		for (Busline busline : busLines) {
			ztrees.add(new Ztree("12"+i, "12", busline.getId()+" "+busline.getName(), ""));
			i++;
		}
		
		i=0;
		//添加航空线路
		Ztree airlineztree = new Ztree("13", "0", "航空线路", "");
		ztrees.add(airlineztree);
		List<Airline> airlines = airlineService.findByOutcenter(outCenter);
		for (Airline airline : airlines) {
			ztrees.add(new Ztree("13"+i, "13", airline.getFlightnum()+" "+airline.getStartairport()+"-"+airline.getEndair(), ""));
			i++;
		}
		
		
		i=0;
		//添加海运线路
		Ztree oceanlineztree = new Ztree("14", "0", "海运线路", "");
		ztrees.add(oceanlineztree);
		List<Oceanline> oceanlines = oceanlineService.findByOutcenter(outCenter);
		for (Oceanline oceanline : oceanlines) {
			ztrees.add(new Ztree("14"+i, "14", oceanline.getRoute()+" "+oceanline.getStartport()+"-"+oceanline.getEndport(), ""));
			i++;
		}
		
		
		i=0;
		//添加铁路线路
		Ztree   railwaylineztree= new Ztree("15", "0", "铁路线路", "");
		ztrees.add(railwaylineztree);
		List<Railwayline>  railwaylines= railwaylineService.findByOutcenter(outCenter);
		for (Railwayline railwayline : railwaylines) {
			ztrees.add(new Ztree("15"+i, "15", railwayline.getTrainnum()+" "+railwayline.getStartstation()+"-"+railwayline.getEndstation(), ""));
			i++;
		}
		
		return ztrees;
		
	}
	
	
	
	
	
}
