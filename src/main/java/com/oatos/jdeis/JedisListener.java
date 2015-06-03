package com.oatos.jdeis;

import redis.clients.jedis.JedisPubSub;

public class JedisListener extends JedisPubSub {

	@Override
	public void onMessage(String channel, String message) {
		System.out.println(Thread.currentThread().getName() + ":" + channel + ":" + message);
	}

	@Override
	public void onPMessage(String pattern, String channel, String message) {
		System.out.println(Thread.currentThread().getName() + ":" + pattern + ":" + channel + ":" + message);
	}

	@Override
	public void onPSubscribe(String pattern, int subscribedChannels) {
		// TODO Auto-generated method stub
		super.onPSubscribe(pattern, subscribedChannels);
	}

	@Override
	public void onPUnsubscribe(String pattern, int subscribedChannels) {
		// TODO Auto-generated method stub
		super.onPUnsubscribe(pattern, subscribedChannels);
	}

	@Override
	public void onSubscribe(String channel, int subscribedChannels) {
		// TODO Auto-generated method stub
		super.onSubscribe(channel, subscribedChannels);
	}

	@Override
	public void onUnsubscribe(String channel, int subscribedChannels) {
		// TODO Auto-generated method stub
		super.onUnsubscribe(channel, subscribedChannels);
	}

}
