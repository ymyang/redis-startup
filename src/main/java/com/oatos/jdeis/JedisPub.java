package com.oatos.jdeis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Hello world!
 *
 */
public class JedisPub 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(10);
            config.setMaxTotal(20);
            config.setMaxWaitMillis(1000);
            config.setTestOnBorrow(true);
            JedisPool pool = new JedisPool(config, "192.168.1.54", 6379);
            Jedis jedis = pool.getResource();
            
            for (int i = 0; i < 10; i++) {
            	jedis.publish("test.yang", "hello:" + i);
			}
            for (int i = 0; i < 10; i++) {
            	jedis.publish("test.yang." + i, "hello:" + i);
			}
            
            jedis.set("test.yang.key1", "Hello Redis!");
            System.out.println(jedis.get("test.yang.key1"));
 
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }
}
