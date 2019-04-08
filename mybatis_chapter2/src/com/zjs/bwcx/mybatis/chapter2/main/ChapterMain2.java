package com.zjs.bwcx.mybatis.chapter2.main;

import org.apache.ibatis.session.SqlSession;

import com.zjs.bwcx.mybatis.chapter2.mapper.RoleMapper;
import com.zjs.bwcx.mybatis.chapter2.po.Role;
import com.zjs.bwcx.mybatis.chapter2.util.SqlSessionFactoryUtil;

public class ChapterMain2 {
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtil.openSqlSession();
			RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
			Role role = new Role();
			role.setNum(3);
			role.setPid(1);
			role.setName("zjs");
			role.setDeptid(26);
			role.setTips("temp1");
			role.setVersion(1);
			mapper.insertRole(role);
			mapper.deleteRole(12);
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			sqlSession.rollback();
		}finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
	}
}
