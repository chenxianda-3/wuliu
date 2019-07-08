package cn.com.lingnan.mapper;

import cn.com.lingnan.pojo.Combinebill;
import cn.com.lingnan.pojo.CombinebillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CombinebillMapper {
    int countByExample(CombinebillExample example);

    int deleteByExample(CombinebillExample example);

    int deleteByPrimaryKey(String id);

    int insert(Combinebill record);

    int insertSelective(Combinebill record);

    List<Combinebill> selectByExample(CombinebillExample example);

    Combinebill selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Combinebill record, @Param("example") CombinebillExample example);

    int updateByExample(@Param("record") Combinebill record, @Param("example") CombinebillExample example);

    int updateByPrimaryKeySelective(Combinebill record);

    int updateByPrimaryKey(Combinebill record);
}