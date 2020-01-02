package com.mkd.adtools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.mkd.adtools.bean.AdSysUser;
import com.mkd.adtools.service.AdService;
import com.mkd.adtools.service.UserService;
import com.mkd.adtools.utils.JwtTokenUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	public AdService adservice ;
	
	@Autowired
	public UserService userService ;
	
	@RequestMapping(value = "/admlogin", method = RequestMethod.GET)
	public JSONObject admLogin(AdSysUser sysUser) {
		log.info("username:"+sysUser.getUsername()+" password:"+sysUser.getPassword());
		JSONObject obj = new JSONObject();
		if (StringUtils.isEmpty(sysUser.getUsername()) || StringUtils.isEmpty(sysUser.getPassword())) {
			obj.put("code", 1);
			obj.put("msg", "账户名或者密码不能为空");
			return obj;
		}
		AdSysUser user = this.userService.selectSysUser(sysUser);
		if (user == null) {
			obj.put("code", 2);
			obj.put("msg", "账户名或者密码错误");
			return obj;
		}

		String token = JwtTokenUtil.generateToken(sysUser.getUsername(), user.getId() + "");
		System.out.println("token:" + token);
		this.userService.setSysUserToken(user.getId(), token);
		obj.put("msg", "登录成功");
		obj.put("code", 0);
		
		JSONObject r = new JSONObject();
		r.put("token", token);
		obj.put("data", r);
		return obj;
	}
}
