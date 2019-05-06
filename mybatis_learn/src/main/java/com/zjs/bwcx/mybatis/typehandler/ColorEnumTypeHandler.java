package com.zjs.bwcx.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.zjs.bwcx.mybatis.color_enum.Color;

public class ColorEnumTypeHandler implements TypeHandler<Color>{

	public void setParameter(PreparedStatement ps, int i, Color parameter, JdbcType jdbcType) throws SQLException {
		ps.setInt(i, parameter.getCode());
	}

	public Color getResult(ResultSet rs, String columnName) throws SQLException {
		int result = rs.getInt(columnName);
		return Color.getEnumByCode(result);
	}

	public Color getResult(ResultSet rs, int columnIndex) throws SQLException {
		int result = rs.getInt(columnIndex);
		return Color.getEnumByCode(result);
	}

	public Color getResult(CallableStatement cs, int columnIndex) throws SQLException {
		int result = cs.getInt(columnIndex);
		return Color.getEnumByCode(result);
	}

}
