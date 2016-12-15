package com.snoopy.redis.major.dao.abstractbase;

import com.snoopy.redis.major.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * Created by hnair20160706 on 2016/12/15.
 */
public abstract class AbstractBaseRedisDao<k,v> implements IUserDao {
    @Autowired
    protected RedisTemplate<k,v> redisTemplate;

    public void setRedisTemplate(RedisTemplate<k, v> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    protected RedisSerializer<?> getRedisSericalizer(){
        return redisTemplate.getDefaultSerializer();
    }
}

