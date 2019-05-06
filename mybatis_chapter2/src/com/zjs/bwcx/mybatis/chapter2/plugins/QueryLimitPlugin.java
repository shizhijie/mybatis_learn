package com.zjs.bwcx.mybatis.chapter2.plugins;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

@Intercepts({@Signature(type=StatementHandler.class,//确定要拦截的对象
method="prepare",
args= {Connection.class,Integer.class})
})
public class QueryLimitPlugin implements Interceptor{
	
	//默认限制查询返回行数
	private int limit;
	
	private String dbType;
	
	//限制表中间别名，避免表重名所以起的怪一些
	private static final String LMT_TABLE_NAME = "limit_Table_Name_xxx";

	public Object intercept(Invocation invocation) throws Throwable {
		//取出被拦截对象
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
		//分离代理对象，从而形成多次代理，通过循环最原始的被代理类，MyBatis使用的是JDK代理
		while (metaObject.hasGetter("h")) {
			Object object = metaObject.getValue("h");
			metaObject = SystemMetaObject.forObject(object);
		}
		//分离最后一个代理对象的目标类
		while (metaObject.hasGetter("target")) {
			Object object = metaObject.getValue("target");
			metaObject = SystemMetaObject.forObject(object);
		}
		//取出即将要执行的sql
		String sql = (String) metaObject.getValue("delegate.boundSql.sql");
		String limitSql;
		//判断参数是不是MySql数据库且SQL有没有被重写过
		if ("mysql".equals(this.dbType) && sql.indexOf(LMT_TABLE_NAME) == -1) {
			//去掉前后空格
			sql.trim();
			//将参数写入SQL
			limitSql = "select * from (" + sql + ") " + LMT_TABLE_NAME + " limit " + limit;
			//重写要执行的SQL
			metaObject.setValue("delegate.boundSql.sql", limitSql);
		}
		//调用原来对象的方法，进入责任链的下一层级
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		//使用默认的mybatis提供的类生成代理对象
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		String strLimit = properties.getProperty("limit", "50");
		this.limit = Integer.parseInt(strLimit);
		//这里我们读取设置的数据库类型
		this.dbType = properties.getProperty("dbtype", "mysql");
	}

}
