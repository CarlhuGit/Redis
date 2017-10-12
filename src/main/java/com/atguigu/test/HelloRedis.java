package com.atguigu.test;

import redis.clients.jedis.Jedis;

public class HelloRedis {

	public static void main(String[] args){
		Jedis jedis = new Jedis("192.168.6.239",6379);
		System.out.println("*********"+jedis.ping());
		/**/
		System.out.println(jedis.get("class0515"));
	}

}
