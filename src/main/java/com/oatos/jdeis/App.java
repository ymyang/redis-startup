package com.oatos.jdeis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
        	new Thread(new JedisTask(), "thread-a").start();
        	new Thread(new JedisTask(), "thread-b").start();
            while (true) {
				Thread.sleep(200);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }

    private static class JedisTask implements Runnable {

		public void run() {
			try {
				System.out.println( Thread.currentThread().getName());
	            JedisPoolConfig config = new JedisPoolConfig();
	            config.setMaxIdle(10);
	            config.setMaxTotal(20);
	            config.setMaxWaitMillis(1000);
	            config.setTestOnBorrow(true);
	            JedisPool pool = new JedisPool(config, "192.168.1.54", 6379);
	            Jedis jedis = pool.getResource();

	            jedis.psubscribe(new JedisListener(), "test.yang", "test.yang.*");
	 
	            while (true) {
					Thread.sleep(200);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
    	
    }
}
