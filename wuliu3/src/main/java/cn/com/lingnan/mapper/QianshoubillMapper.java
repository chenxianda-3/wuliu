package cn.com.lingnan.mapper;

import cn.com.lingnan.pojo.Qianshoubill;
import cn.com.lingnan.pojo.QianshoubillExample;
import cn.com.lingnan.pojo.QianshoubillKey;
import cn.com.lingnan.pojo.Workorder;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QianshoubillMapper {
    int countByExample(QianshoubillExample example);

    int deleteByExample(QianshoubillExample example);

    int deleteByPrimaryKey(QianshoubillKey key);

    int insert(Qianshoubill record);

    int insertSelective(Qianshoubill record);

    List<Qianshoubill> selectByExample(QianshoubillExample example);

    Qianshoubill selectByPrimaryKey(QianshoubillKey key);

    int updateByExampleSelective(@Param("record") Qianshoubill record, @Param("example") QianshoubillExample example);

    int updateByExample(@Param("record") Qianshoubill record, @Param("example") QianshoubillExample example);

    int updateByPrimaryKeySelective(Qianshoubill record);

    int updateByPrimaryKey(Qianshoubill record);

}