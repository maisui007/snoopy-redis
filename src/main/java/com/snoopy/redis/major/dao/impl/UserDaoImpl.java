package com.snoopy.redis.major.dao.impl;

import com.snoopy.redis.major.dao.abstractbase.AbstractBaseRedisDao;
import com.snoopy.redis.major.vo.UserVo;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hnair20160706 on 2016/12/15.
 */
public class UserDaoImpl extends AbstractBaseRedisDao<String,UserVo> {
    public boolean add(final UserVo userVo) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<Object> serializer = (RedisSerializer<Object>) getRedisSericalizer();
                byte[] key = serializer.serialize(userVo.getId());
                byte[] name = serializer.serialize(userVo.getName());
                return connection.setNX(key,name);
            }
        });
        return result;
    }

    public boolean add(final List<UserVo> userVoList) {
        Assert.notEmpty(userVoList);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<Object> serializer = (RedisSerializer<Object>) getRedisSericalizer();
                for (UserVo userVo : userVoList){
                    byte[] key = serializer.serialize(userVo.getId());
                    byte[] name = serializer.serialize(userVo.getName());
                    connection.setNX(key,name);
                }
                return true;
            }
        },false,true);
        return result;
    }

    public void delete(String key) {
        redisTemplate.delete(key);

    }

    public void delete(List<UserVo> userVoList) {
        List<String> list = new ArrayList<String>();
        for (UserVo userVo : userVoList){
            list.add(userVo.getId());
        }
        redisTemplate.delete(list);
    }

    public boolean update(final UserVo userVo) {
        String key = userVo.getId();
        if (get(key) == null){
            throw  new NullPointerException("数据行不存在，key = "+key);
        }
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<Object> serializer = (RedisSerializer<Object>) getRedisSericalizer();
                byte[] key = serializer.serialize(userVo.getId());
                byte[] name = serializer.serialize(userVo.getName());
                connection.set(key,name);
                return true;
            }
        });



        return result;
    }

    public UserVo get(final String key) {
        UserVo userVo = redisTemplate.execute(new RedisCallback<UserVo>() {
            public UserVo doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<Object> serializer = (RedisSerializer<Object>) getRedisSericalizer();
                byte[] keyId = serializer.serialize(key);
                byte[] value = connection.get(keyId);
                if (value == null){
                    return  null;
                }
                String name = (String) serializer.deserialize(value);
                return new UserVo(key,name,null);
            }
        });
        return userVo;
    }
}
