package cn.com.lingnan.mapper;

import cn.com.lingnan.pojo.Routelinebill;
import cn.com.lingnan.pojo.RoutelinebillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoutelinebillMapper {
    int countByExample(RoutelinebillExample example);

    int deleteByExample(RoutelinebillExample example);

    int insert(Routelinebill record);

    int insertSelective(Routelinebill record);

    List<Routelinebill> selectByExample(RoutelinebillExample example);

    int updateByExampleSelective(@Param("record") Routelinebill record, @Param("example") RoutelinebillExample example);

    int updateByExample(@Param("record") Routelinebill record, @Param("example") RoutelinebillExample example);

	List<Routelinebill> findByStartCity(String startCity);
	
	Routelinebill findByIdInAll(String id);
}