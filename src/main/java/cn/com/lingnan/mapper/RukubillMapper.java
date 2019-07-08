package cn.com.lingnan.mapper;

import cn.com.lingnan.pojo.Rukubill;
import cn.com.lingnan.pojo.RukubillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RukubillMapper {
    int countByExample(RukubillExample example);

    int deleteByExample(RukubillExample example);

    int deleteByPrimaryKey(String id);

    int insert(Rukubill record);

    int insertSelective(Rukubill record);

    List<Rukubill> selectByExample(RukubillExample example);

    Rukubill selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Rukubill record, @Param("example") RukubillExample example);

    int updateByExample(@Param("record") Rukubill record, @Param("example") RukubillExample example);

    int updateByPrimaryKeySelective(Rukubill record);

    int updateByPrimaryKey(Rukubill record);
}