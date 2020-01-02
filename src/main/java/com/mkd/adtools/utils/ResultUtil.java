package com.mkd.adtools.utils;

import com.mkd.adtools.configs.UCode;

import net.sf.json.JSONObject;

public class ResultUtil {
	public static JSONObject success(Object object) {
        JSONObject result = new JSONObject();
        result.put("code", UCode.SUC.getCode());
        result.put("msg",UCode.SUC.getMsg());
        result.put("data", object) ;
        return result;
    }

    public static JSONObject success() {
        return success(null);
    }

    public static JSONObject error(UCode code) {
    	JSONObject result = new JSONObject();
    	result.put("code", code.getCode());
        result.put("msg",code.getMsg());
        return result;
    }
    
    public static JSONObject error(String msg) {
    	JSONObject result = new JSONObject();
    	result.put("code", 300);
        result.put("msg",msg);
        return result;
    }
}
