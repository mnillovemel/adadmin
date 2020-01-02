package com.mkd.adtools.configs;

public enum UCode {
	SUC(0,"成功"),
	UNKNOWN(100,"未知错误"),//未知错误
	SYS(200,"系统错误");
	private int code ;
	private String msg ;
	private UCode(int code,String msg) {
		this.code = code ;
		this.msg = msg ;
	}
	public int getCode() {
		return this.code ;
	}
	public String getMsg() {
		return this.msg ;
	}
	
	public static void main(String[] args) {
		System.out.println(UCode.UNKNOWN.code);
	}
}
