package cn.com.lingnan.mapper;

import cn.com.lingnan.pojo.Workbill;
import cn.com.lingnan.pojo.WorkbillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkbillMapper {
    int countByExample(WorkbillExample example);

    int deleteByExample(WorkbillExample example);

    int deleteByPrimaryKey(String id);

    int insert(Workbill record);

    int insertSelective(Workbill record);

    List<Workbill> selectByExample(WorkbillExample example);

    Workbill selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Workbill record, @Param("example") WorkbillExample example);

    int updateByExample(@Param("record") Workbill record, @Param("example") WorkbillExample example);

    int updateByPrimaryKeySelective(Workbill record);

    int updateByPrimaryKey(Workbill record);
    
	int insertBatch(List<Workbill> workbillList);


	List<Workbill> selectWorkbill(Workbill workbill);

	Workbill selectWorkbillById(String id);

	List<Workbill> selectDiaoDu(Workbill workbill);
    
}