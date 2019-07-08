package cn.com.lingnan.mapper;

import cn.com.lingnan.pojo.Decidedzone;
import cn.com.lingnan.pojo.DecidedzoneExample;
import cn.com.lingnan.pojo.Subarea;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DecidedzoneMapper {
    int countByExample(DecidedzoneExample example);

    int deleteByExample(DecidedzoneExample example);

    int deleteByPrimaryKey(String id);

    int insert(Decidedzone record);
    
    int insertBatch(List<Decidedzone> list);

    int insertSelective(Decidedzone record);

    List<Decidedzone> selectByExample(DecidedzoneExample example);
    
    List<Decidedzone> selectDecidedzone();

    Decidedzone selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Decidedzone record, @Param("example") DecidedzoneExample example);

    int updateByExample(@Param("record") Decidedzone record, @Param("example") DecidedzoneExample example);

    int updateByPrimaryKeySelective(Decidedzone record);

    int updateByPrimaryKey(Decidedzone record);
}