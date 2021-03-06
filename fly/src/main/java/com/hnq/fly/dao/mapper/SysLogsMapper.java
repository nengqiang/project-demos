package com.hnq.fly.dao.mapper;

import com.hnq.fly.dao.po.SysLogs;
import com.hnq.fly.dao.po.SysLogsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysLogsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_logs
     *
     * @mbg.generated
     */
    long countByExample(SysLogsCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_logs
     *
     * @mbg.generated
     */
    int deleteByExample(SysLogsCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_logs
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_logs
     *
     * @mbg.generated
     */
    int insert(SysLogs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_logs
     *
     * @mbg.generated
     */
    int insertSelective(SysLogs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_logs
     *
     * @mbg.generated
     */
    List<SysLogs> selectByExampleWithRowbounds(SysLogsCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_logs
     *
     * @mbg.generated
     */
    List<SysLogs> selectByExample(SysLogsCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_logs
     *
     * @mbg.generated
     */
    SysLogs selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_logs
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysLogs record, @Param("example") SysLogsCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_logs
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysLogs record, @Param("example") SysLogsCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_logs
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysLogs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_logs
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysLogs record);
}