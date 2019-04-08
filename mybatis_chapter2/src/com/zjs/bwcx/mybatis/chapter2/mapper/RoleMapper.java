package com.zjs.bwcx.mybatis.chapter2.mapper;

import org.apache.ibatis.annotations.Param;

import com.zjs.bwcx.mybatis.chapter2.po.Role;

public interface RoleMapper {
	public Role getRole(@Param("id") int id);
	public int deleteRole(@Param("id") int id);
	public int insertRole(Role role);
}
