package com.zjs.bwcx.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zjs.bwcx.mybatis.pojo.Role;

public interface RoleMapper {
	@Select("select * from sys_role where id=#{id}")
	public Role getRole(@Param("id") int id);
}
