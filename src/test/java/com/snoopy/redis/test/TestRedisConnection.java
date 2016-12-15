package com.snoopy.redis.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

/**
 * Created by hnair20160706 on 2016/12/14.
 */
public class TestRedisConnection extends TestBaseCase{
    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Test
    public void testRedisCon(){
     JedisConnection jedisConnection = jedisConnectionFactory.getConnection();
        Jedis jedis = jedisConnection.getNativeConnection();
        System.out.println(jedis.get("name"));

    }
}
