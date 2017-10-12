package com.atguigu.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisPoolTest {

	public static void main(String[] args)
	{
		JedisPool pool = JedisPoolUtils.getInstance();
		Jedis jedis = null;
		
		try 
		{
			jedis = pool.getResource();
			
			jedis.set("class0515","nbv5");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JedisPoolUtils.release(pool, jedis);
		}
	}

}
