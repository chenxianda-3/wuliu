package cn.com.lingnan.mapper;

import cn.com.lingnan.pojo.Oceanline;
import cn.com.lingnan.pojo.OceanlineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OceanlineMapper {
    int countByExample(OceanlineExample example);

    int deleteByExample(OceanlineExample example);

    int deleteByPrimaryKey(String id);

    int insert(Oceanline record);

    int insertSelective(Oceanline record);

    List<Oceanline> selectByExample(OceanlineExample example);

    Oceanline selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Oceanline record, @Param("example") OceanlineExample example);

    int updateByExample(@Param("record") Oceanline record, @Param("example") OceanlineExample example);

    int updateByPrimaryKeySelective(Oceanline record);

    int updateByPrimaryKey(Oceanline record);
}