package com.atguigu.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtils {
	private static volatile JedisPool JedisPool = null;
	
	private JedisPoolUtils() {}
	
	public static JedisPool getInstance()
	{
		//DCL = double check lock
		if(null == JedisPool)
		{
			synchronized (JedisPoolUtils.class) 
			{
				if(null == JedisPool)
				{
					JedisPoolConfig poolConfig = new JedisPoolConfig();
					poolConfig.setMaxActive(100);
					poolConfig.setMaxIdle(32);
					poolConfig.setMaxWait(100 * 1000);
					poolConfig.setTestOnBorrow(true);
					
					JedisPool = new JedisPool(poolConfig, "192.168.6.239", 6379);
				}
			}
		}
		return JedisPool;
	}

	
	public static void release(JedisPool JedisPool ,Jedis jedis)
	{
		if(null != jedis) 
		{
			JedisPool.returnResourceObject(jedis);
		}
	}
}

