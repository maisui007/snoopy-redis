package com.snoopy.redis.test;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by hnair20160706 on 2016/12/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/snoopy-spring-config.xml")
public class TestBaseCase  {
    protected static final Logger logger = LoggerFactory.getLogger("snoopy-redis-log");
    private long start;

    @Before
    public  void setUp(){
        logger.info("Snoopy-redis unit testing start.........");
        start = System.currentTimeMillis();
    }

    @After
    public void tearDown(){
        logger.info("Snoopy-redis unit testing end.........Time used:{}",(System.currentTimeMillis() - start) + ".ms");
    }

}
