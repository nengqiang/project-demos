package com.hnq.fly.dao.mapper;

import com.hnq.fly.dao.po.SysRolePermission;
import com.hnq.fly.dao.po.SysRolePermissionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysRolePermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated
     */
    long countByExample(SysRolePermissionCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated
     */
    int deleteByExample(SysRolePermissionCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated
     */
    int insert(SysRolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated
     */
    int insertSelective(SysRolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated
     */
    List<SysRolePermission> selectByExampleWithRowbounds(SysRolePermissionCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated
     */
    List<SysRolePermission> selectByExample(SysRolePermissionCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated
     */
    SysRolePermission selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysRolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysRolePermission record);
}