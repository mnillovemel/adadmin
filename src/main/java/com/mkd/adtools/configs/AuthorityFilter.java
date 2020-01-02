package com.mkd.adtools.configs;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.mkd.adtools.utils.JwtTokenUtil;
import com.mkd.adtools.utils.RedisUtil;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

/**
 * 过滤器
 * 作用：
 *  1、验证用户是否登录
 */
@WebFilter(urlPatterns = { "/ad/*" }, filterName = "AuthorityFilter")
@Slf4j
public class AuthorityFilter implements Filter { 

    private static final String filter = "AuthorityFilter";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化成功..........");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    	HttpServletRequest req = (HttpServletRequest) servletRequest ;
    	HttpServletResponse res =(HttpServletResponse)servletResponse ;
        boolean isFilter = false;
        
        String header = req.getHeader("Authorization");//header方式
        String token = null;
        if (header != null && header.startsWith("Bearer ")) {
            token = header.substring("Bearer ".length());
        }
        if(token==null){
            isFilter = false ;
        }
        else{
        	Jedis jedis = RedisUtil.getJedis();
            try{ 
                Claims c = JwtTokenUtil.getClaimsFromToken(token);
                System.out.println(c.get("userId"));
                String userId = String.valueOf(c.get("userId"));
                String token1 = jedis.hget("jwt:sysuser", userId) ;
                if(token1.equals(token)){
                    isFilter = true  ;
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            finally{
        		RedisUtil.returnResource(jedis);	
        	}
        }
     
        if(isFilter){
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else{
    		JSONObject obj = new JSONObject();
			obj.put("code", 401);
			obj.put("message", "token Invalid!");
			res.sendError(401, obj.toJSONString()); 
    	}
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁成功...........");
    }
}
