package com.mkd.adtools.exception;

import net.sf.json.JSONObject;

public class AdException extends Exception {
	private static final long serialVersionUID = 1L;
	private int code ;
	private String error ;
	public AdException(int code,String error) {
		super(error) ;
		this.setCode(code) ;
		this.setError(error) ;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public JSONObject getErrorObj() {
		JSONObject obj  = new JSONObject();
		obj.put("code", this.code) ;
		obj.put("msg", this.error) ;
		return obj ;
	}
}
