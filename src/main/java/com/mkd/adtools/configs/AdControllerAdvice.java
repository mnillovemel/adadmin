package com.mkd.adtools.configs;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mkd.adtools.exception.AdException;
import com.mkd.adtools.utils.ResultUtil;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
@Slf4j
@ControllerAdvice
public class AdControllerAdvice {

	/**
	 * 全局异常捕捉处
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public JSONObject errorHandler(Exception ex) {
		log.error(ex.getMessage());
		return ResultUtil.error(ex.getMessage());
	}
	@ResponseBody
	@ExceptionHandler(value = AdException.class)
	public JSONObject myErrorHandler(AdException ex) {
		JSONObject obj = new JSONObject();
		obj.put("code", ex.getCode());
		obj.put("msg", ex.getError());
		return obj;
	}
}
