package com.zjs.bwcx.mybatis.utils;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory sqlSessionFactory = null;
	public static SqlSessionFactory getSqlSessionFactory() {
		Reader inputStream = null;
		if (sqlSessionFactory==null) {
			try {
				String resource = "mybatis_config.xml";
				inputStream = Resources.getResourceAsReader(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (Exception e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return sqlSessionFactory;
	}
}
