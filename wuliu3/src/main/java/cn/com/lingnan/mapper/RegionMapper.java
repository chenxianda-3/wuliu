package cn.com.lingnan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.lingnan.pojo.Region;
import cn.com.lingnan.pojo.RegionExample;

public interface RegionMapper {
    int countByExample(RegionExample example);

    int deleteByExample(RegionExample example);

    int deleteByPrimaryKey(String id);

    int insert(Region record);

    int insertSelective(Region record);
    
    int insertBatch(List<Region> list);

    List<Region> selectByExample(RegionExample example);

    Region selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Region record, @Param("example") RegionExample example);

    int updateByExample(@Param("record") Region record, @Param("example") RegionExample example);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);
}