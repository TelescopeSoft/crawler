package com.qlmsoft.crawler.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.qlmsoft.crawler.entity.CorpRegStaff;
import com.qlmsoft.crawler.entity.CorpRegStaffExample;
import com.qlmsoft.crawler.mohurd.bean.RegStaffVO;

public interface CorpRegStaffMapper {
    long countByExample(CorpRegStaffExample example);

    int deleteByExample(CorpRegStaffExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CorpRegStaff record);

    int insertSelective(CorpRegStaff record);

    List<CorpRegStaff> selectByExampleWithRowbounds(CorpRegStaffExample example, RowBounds rowBounds);

    List<CorpRegStaff> selectByExample(CorpRegStaffExample example);

    CorpRegStaff selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CorpRegStaff record, @Param("example") CorpRegStaffExample example);

    int updateByExample(@Param("record") CorpRegStaff record, @Param("example") CorpRegStaffExample example);

    int updateByPrimaryKeySelective(CorpRegStaff record);

    int updateByPrimaryKey(CorpRegStaff record);
 
    /**
     * 按名字跟身份证ID缩写查找身份证ID
     * @param record
     * @return
     */
    String selectIdCardByNameAndIdcard(RegStaffVO record);
    
}