package com.hnq.crawler.dao.mapper;

import com.hnq.crawler.dao.domain.Stock;
import com.hnq.crawler.dao.domain.StockCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface StockMapper {
    int countByExample(StockCriteria example);

    int deleteByExample(StockCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Stock record);

    int insertSelective(Stock record);

    List<Stock> selectByExampleWithBLOBsWithRowbounds(StockCriteria example, RowBounds rowBounds);

    List<Stock> selectByExampleWithBLOBs(StockCriteria example);

    List<Stock> selectByExampleWithRowbounds(StockCriteria example, RowBounds rowBounds);

    List<Stock> selectByExample(StockCriteria example);

    Stock selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Stock record, @Param("example") StockCriteria example);

    int updateByExampleWithBLOBs(@Param("record") Stock record, @Param("example") StockCriteria example);

    int updateByExample(@Param("record") Stock record, @Param("example") StockCriteria example);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKeyWithBLOBs(Stock record);

    int updateByPrimaryKey(Stock record);
}