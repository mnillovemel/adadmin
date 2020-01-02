package com.mkd.adtools.utils;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

//redis
@Slf4j
public class RedisUtil {

	private static JedisPool jedisPool = null;
     /**
      */
     static {
         try {
             JedisPoolConfig config = new JedisPoolConfig();
             config.setMaxTotal(PropertiesUtil.getIntValue("redis.maxTotal"));
             config.setMaxIdle(PropertiesUtil.getIntValue("redis.maxIdle"));
             config.setMaxWaitMillis(PropertiesUtil.getIntValue("redis.maxWaitMillis"));
            
            
             config.setTestOnBorrow(PropertiesUtil.getBoobleanValue("redis.testOnBorrow"));
             jedisPool = new JedisPool(config,
            		 PropertiesUtil.getValue("redis.hosts"),
            		 PropertiesUtil.getIntValue("redis.port"),
            		 PropertiesUtil.getIntValue("redis.timeout"),
            		 PropertiesUtil.getValue("redis.password").equals("")?null: PropertiesUtil.getValue("redis.password"),
            		 PropertiesUtil.getIntValue("redis.database"));
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     /**
      * @return
      */
     public synchronized static Jedis getJedis() {
         try {
             if (jedisPool != null) {
                 Jedis resource = jedisPool.getResource();
                 return resource;
             } else {
                 return null;
             }
         } catch (Exception e) {
        	 e.printStackTrace();
             return null;
         }
     }
     /**
      * @param jedis
      */
    public static void returnResource(final Jedis jedis) {
    	try{
    		if (jedis != null) {
    				jedis.close();
            }
    	}catch(Exception e){
    		log.info("redis资源释放异常"+e);
    	}
     }
}
