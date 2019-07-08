package cn.com.lingnan.mapper;

import cn.com.lingnan.pojo.Chukubill;
import cn.com.lingnan.pojo.ChukubillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChukubillMapper {
    int countByExample(ChukubillExample example);

    int deleteByExample(ChukubillExample example);

    int deleteByPrimaryKey(String id);

    int insert(Chukubill record);

    int insertSelective(Chukubill record);

    List<Chukubill> selectByExample(ChukubillExample example);

    Chukubill selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Chukubill record, @Param("example") ChukubillExample example);

    int updateByExample(@Param("record") Chukubill record, @Param("example") ChukubillExample example);

    int updateByPrimaryKeySelective(Chukubill record);

    int updateByPrimaryKey(Chukubill record);
}