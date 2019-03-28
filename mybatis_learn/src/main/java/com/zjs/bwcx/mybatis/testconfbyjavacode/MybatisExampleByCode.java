package com.zjs.bwcx.mybatis.testconfbyjavacode;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.zjs.bwcx.mybatis.mapper.RoleMapper;
import com.zjs.bwcx.mybatis.pojo.Role;

public class MybatisExampleByCode {
	
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			SqlSessionFactory sqlSessionFactory = init();
			sqlSession = sqlSessionFactory.openSession();
			RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
			Role role = mapper.getRole(1);
			System.out.println(role);
		} finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
	}
	
	public static SqlSessionFactory init() {
		//构建数据库连接池
		PooledDataSource dataSource = new PooledDataSource();
		dataSource.setDriver("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/guns?serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("123");
		//构建数据库事物方式
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		//创建数据库运行环境
		Environment environment = new Environment("development", transactionFactory, dataSource);
		//构建Configuration对象
		Configuration configuration = new Configuration(environment);
		//注册一个mybatis上下文别名
		configuration.getTypeAliasRegistry().registerAlias("role",Role.class);
		//加入一个映射器
		configuration.addMapper(RoleMapper.class);
		//使用SqlSessionFactoryBuilder构建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		return sqlSessionFactory;
	}
}
