package com.hnq.fly.dao.mapper;

import com.hnq.fly.dao.po.SysUserRole;
import com.hnq.fly.dao.po.SysUserRoleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysUserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated
     */
    long countByExample(SysUserRoleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated
     */
    int deleteByExample(SysUserRoleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated
     */
    int insert(SysUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated
     */
    int insertSelective(SysUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated
     */
    List<SysUserRole> selectByExampleWithRowbounds(SysUserRoleCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated
     */
    List<SysUserRole> selectByExample(SysUserRoleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated
     */
    SysUserRole selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysUserRole record, @Param("example") SysUserRoleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysUserRole record, @Param("example") SysUserRoleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysUserRole record);
}