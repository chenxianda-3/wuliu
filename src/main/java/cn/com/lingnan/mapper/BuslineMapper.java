package cn.com.lingnan.mapper;

import cn.com.lingnan.pojo.Busline;
import cn.com.lingnan.pojo.BuslineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuslineMapper {
    int countByExample(BuslineExample example);

    int deleteByExample(BuslineExample example);

    int deleteByPrimaryKey(String id);

    int insert(Busline record);

    int insertSelective(Busline record);

    List<Busline> selectByExample(BuslineExample example);

    Busline selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Busline record, @Param("example") BuslineExample example);

    int updateByExample(@Param("record") Busline record, @Param("example") BuslineExample example);

    int updateByPrimaryKeySelective(Busline record);

    int updateByPrimaryKey(Busline record);
}