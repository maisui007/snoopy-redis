package com.snoopy.redis.test;

import com.snoopy.redis.major.dao.IUserDao;
import com.snoopy.redis.major.vo.UserVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hnair20160706 on 2016/12/15.
 */
public class TestRedisUserVo extends TestBaseCase{
    @Autowired
    private IUserDao userDao;

    @Test
    public void testAddUserVo(){
        UserVo userVo = new UserVo();
        userVo.setId("0001");
        userVo.setName("snoopy");
        boolean result = userDao.add(userVo);
        Assert.assertTrue(result);
    }

    @Test
    public void testBatchAddUserVo(){
        List<UserVo> userVoList = new ArrayList<UserVo>();
        for (int i = 0; i < 50000; i++) {
            UserVo uservo = new UserVo();
            uservo.setId("0001"+i);
            uservo.setName("snoopy"+i);
            userVoList.add(uservo);
        }
        for (UserVo user: userVoList){
            userDao.add(user);
        }
    }

    @Test
    public void testBatchAddUserVoThroughPipeline(){
        List<UserVo> userVoList = new ArrayList<UserVo>();
        for (int i = 0; i < 50000; i++) {
            UserVo uservo = new UserVo();
            uservo.setId("0001"+i);
            uservo.setName("snoopy"+i);
            userVoList.add(uservo);
        }
        userDao.add(userVoList);

    }
    @Test
    public void testGetUserVo(){
        UserVo userVo = null;
//        userVo.setId("0001");
        userVo = userDao.get("0001");
        Assert.assertNotNull(userVo);
        System.out.println("UserVo field id is "+userVo.getId()+";name field is "+userVo.getName());
    }


}
