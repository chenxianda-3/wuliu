package cn.com.lingnan.mapper;

import cn.com.lingnan.pojo.Airline;
import cn.com.lingnan.pojo.AirlineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AirlineMapper {
    int countByExample(AirlineExample example);

    int deleteByExample(AirlineExample example);

    int deleteByPrimaryKey(String id);

    int insert(Airline record);

    int insertSelective(Airline record);

    List<Airline> selectByExample(AirlineExample example);

    Airline selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Airline record, @Param("example") AirlineExample example);

    int updateByExample(@Param("record") Airline record, @Param("example") AirlineExample example);

    int updateByPrimaryKeySelective(Airline record);

    int updateByPrimaryKey(Airline record);
}