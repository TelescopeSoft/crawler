package com.qlmsoft.crawler.mapper;

import com.qlmsoft.crawler.entity.CorpRegStaffCert;
import com.qlmsoft.crawler.entity.CorpRegStaffCertExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CorpRegStaffCertMapper {
    long countByExample(CorpRegStaffCertExample example);

    int deleteByExample(CorpRegStaffCertExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CorpRegStaffCert record);

    int insertSelective(CorpRegStaffCert record);

    List<CorpRegStaffCert> selectByExampleWithRowbounds(CorpRegStaffCertExample example, RowBounds rowBounds);

    List<CorpRegStaffCert> selectByExample(CorpRegStaffCertExample example);

    CorpRegStaffCert selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CorpRegStaffCert record, @Param("example") CorpRegStaffCertExample example);

    int updateByExample(@Param("record") CorpRegStaffCert record, @Param("example") CorpRegStaffCertExample example);

    int updateByPrimaryKeySelective(CorpRegStaffCert record);

    int updateByPrimaryKey(CorpRegStaffCert record);
}