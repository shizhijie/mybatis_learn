package com.zjs.bwcx.mybatis.color_enum;

public enum Color {
	
	RED(1,"红"),
	YELLOW(2,"黄"),
	BLUE(3,"蓝色");
	
	
	private int code;
	private String name;
	private Color(int code, String name) {
		this.code = code;
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	
	public static Color getEnumByCode(int code) {
		for (Color color:Color.values()) {
			if (color.code==code) {
				return color;
			}
		}
		return null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCode(int code) {
		this.code = code;
	}
}
