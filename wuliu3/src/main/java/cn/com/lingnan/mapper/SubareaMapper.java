package cn.com.lingnan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.lingnan.pojo.Subarea;
import cn.com.lingnan.pojo.SubareaExample;

public interface SubareaMapper {
    int countByExample(SubareaExample example);

    int deleteByExample(SubareaExample example);

    int deleteByPrimaryKey(String id);

    int insert(Subarea record);

    int insertSelective(Subarea record);
    
    int insertBatch(List<Subarea> list);

    List<Subarea> selectByExample(SubareaExample example);
    
    List<Subarea> selectSubarea(Subarea record);

    Subarea selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Subarea record, @Param("example") SubareaExample example);

    int updateByExample(@Param("record") Subarea record, @Param("example") SubareaExample example);

    int updateByPrimaryKeySelective(Subarea record);

    int updateByPrimaryKey(Subarea record);
}