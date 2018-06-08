package com.qlmsoft.crawler.mapper;

import com.qlmsoft.crawler.entity.CorpCert;
import com.qlmsoft.crawler.entity.CorpCertExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CorpCertMapper {
    long countByExample(CorpCertExample example);

    int deleteByExample(CorpCertExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CorpCert record);

    int insertSelective(CorpCert record);

    List<CorpCert> selectByExampleWithRowbounds(CorpCertExample example, RowBounds rowBounds);

    List<CorpCert> selectByExample(CorpCertExample example);

    CorpCert selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CorpCert record, @Param("example") CorpCertExample example);

    int updateByExample(@Param("record") CorpCert record, @Param("example") CorpCertExample example);

    int updateByPrimaryKeySelective(CorpCert record);

    int updateByPrimaryKey(CorpCert record);
}