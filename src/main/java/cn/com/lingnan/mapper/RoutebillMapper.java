package cn.com.lingnan.mapper;

import cn.com.lingnan.pojo.Routebill;
import cn.com.lingnan.pojo.RoutebillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoutebillMapper {
    int countByExample(RoutebillExample example);

    int deleteByExample(RoutebillExample example);

    int deleteByPrimaryKey(String id);

    int insert(Routebill record);

    int insertSelective(Routebill record);

    List<Routebill> selectByExample(RoutebillExample example);

    Routebill selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Routebill record, @Param("example") RoutebillExample example);

    int updateByExample(@Param("record") Routebill record, @Param("example") RoutebillExample example);

    int updateByPrimaryKeySelective(Routebill record);

    int updateByPrimaryKey(Routebill record);
    
    void  cascadeSave (Routebill routebill);
}