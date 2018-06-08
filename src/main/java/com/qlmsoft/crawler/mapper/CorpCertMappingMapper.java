package com.qlmsoft.crawler.mapper;

import com.qlmsoft.crawler.entity.CorpCertMapping;
import com.qlmsoft.crawler.entity.CorpCertMappingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CorpCertMappingMapper {
    long countByExample(CorpCertMappingExample example);

    int deleteByExample(CorpCertMappingExample example);

    int insert(CorpCertMapping record);

    int insertSelective(CorpCertMapping record);

    List<CorpCertMapping> selectByExampleWithRowbounds(CorpCertMappingExample example, RowBounds rowBounds);

    List<CorpCertMapping> selectByExample(CorpCertMappingExample example);

    int updateByExampleSelective(@Param("record") CorpCertMapping record, @Param("example") CorpCertMappingExample example);

    int updateByExample(@Param("record") CorpCertMapping record, @Param("example") CorpCertMappingExample example);
    
    List<CorpCertMapping> selectAll(String certType);
    
}