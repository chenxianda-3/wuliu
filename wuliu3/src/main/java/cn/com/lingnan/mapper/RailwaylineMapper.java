package cn.com.lingnan.mapper;

import cn.com.lingnan.pojo.Railwayline;
import cn.com.lingnan.pojo.RailwaylineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RailwaylineMapper {
    int countByExample(RailwaylineExample example);

    int deleteByExample(RailwaylineExample example);

    int deleteByPrimaryKey(String id);

    int insert(Railwayline record);

    int insertSelective(Railwayline record);

    List<Railwayline> selectByExample(RailwaylineExample example);

    Railwayline selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Railwayline record, @Param("example") RailwaylineExample example);

    int updateByExample(@Param("record") Railwayline record, @Param("example") RailwaylineExample example);

    int updateByPrimaryKeySelective(Railwayline record);

    int updateByPrimaryKey(Railwayline record);
}