package com.mkd.adtools.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkd.adtools.bean.AdSysUser;
import com.mkd.adtools.mapper.UserMapper;
import com.mkd.adtools.utils.RedisUtil;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
@Service
@Slf4j
public class UserService {
	
	@Autowired
	public UserMapper userMapper ;
	public AdSysUser selectSysUser(AdSysUser sysUser) {
		return this.userMapper.selectSysUser(sysUser) ;
	}
	
    public void setSysUserToken(Integer userId,String token){
    	Jedis jedis = RedisUtil.getJedis();
    	try{
    		jedis.hset("jwt:sysuser", userId+"",token) ;	
    	}
    	finally{
    		RedisUtil.returnResource(jedis);	
    	}
    }
    
    public String getSysUserByToken(String userId){
    	Jedis jedis = RedisUtil.getJedis();
    	try{
    		return jedis.hget("jwt:sysuser", userId) ;
    	}
    	finally{
    		RedisUtil.returnResource(jedis);	
    	}
    }
}
