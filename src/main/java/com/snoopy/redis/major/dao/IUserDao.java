package com.snoopy.redis.major.dao;

import com.snoopy.redis.major.vo.UserVo;

import java.util.List;

/**
 * Created by hnair20160706 on 2016/12/15.
 */
public interface IUserDao {

    /***
     * @Description add
     * @param userVo
     * @return
     */
    boolean add(UserVo userVo);

    /***
     * @Description batch add
     * @param userVoList
     * @return
     */
    boolean add(List<UserVo> userVoList);

    /***
     * @Description delete
     * @param key
     */
    void delete(String key);

    /***
     * @Description batch delete
     * @param userVoList
     */
    void delete(List<UserVo> userVoList);

    /***
     * @Description edit UserVo
     * @param userVo
     * @return
     */
    boolean update(UserVo userVo);

    /***
     * @Description get value by key
     * @param key
     * @return
     */
    UserVo get(String key);




}
