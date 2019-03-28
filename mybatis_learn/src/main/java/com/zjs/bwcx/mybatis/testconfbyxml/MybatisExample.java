package com.zjs.bwcx.mybatis.testconfbyxml;

import org.apache.ibatis.session.SqlSession;

import com.zjs.bwcx.mybatis.mapper.RoleMapper;
import com.zjs.bwcx.mybatis.pojo.Role;
import com.zjs.bwcx.mybatis.utils.MyBatisUtil;

public class MybatisExample {
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
			RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
			Role role = mapper.getRole(1);
			System.out.println(role);
		} finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
	}
}