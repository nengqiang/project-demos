package com.hnq.fly.dao.mapper;

import com.hnq.fly.dao.po.SysPermission;
import com.hnq.fly.dao.po.SysPermissionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysPermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    long countByExample(SysPermissionCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    int deleteByExample(SysPermissionCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    int insert(SysPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    int insertSelective(SysPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    List<SysPermission> selectByExampleWithRowbounds(SysPermissionCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    List<SysPermission> selectByExample(SysPermissionCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    SysPermission selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysPermission record, @Param("example") SysPermissionCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysPermission record, @Param("example") SysPermissionCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysPermission record);
}