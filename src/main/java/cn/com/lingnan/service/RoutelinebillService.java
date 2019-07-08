package cn.com.lingnan.service;


import java.util.List;

import cn.com.lingnan.pojo.Routebill;
import cn.com.lingnan.pojo.Routelinebill;

public interface RoutelinebillService {



	List<Routelinebill> findByStartCity(String startCity);
	
	
	List<Routelinebill> findLineByRoutebillId(String routebillId);
}
