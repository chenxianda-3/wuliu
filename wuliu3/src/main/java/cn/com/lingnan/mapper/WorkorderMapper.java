package cn.com.lingnan.mapper;

import cn.com.lingnan.pojo.Workorder;
import cn.com.lingnan.pojo.WorkorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkorderMapper {
    int countByExample(WorkorderExample example);

    int deleteByExample(WorkorderExample example);

    int deleteByPrimaryKey(String id);

    int insert(Workorder record);

    int insertSelective(Workorder record);

    List<Workorder> selectByExample(WorkorderExample example);

    Workorder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Workorder record, @Param("example") WorkorderExample example);

    int updateByExample(@Param("record") Workorder record, @Param("example") WorkorderExample example);

    int updateByPrimaryKeySelective(Workorder record);

    int updateByPrimaryKey(Workorder record);
}