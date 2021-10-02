package com.ghstudio.pairprogram.dao.repository;

import com.ghstudio.pairprogram.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * UserRepository 用户操作 Mapper 接口
 */
@Repository
@Mapper
public interface UserRepository {
    /**
     * getUserByUsername 根据用户名湖区用户
     *
     * @param username 用户名
     * @return user
     */
    User getUserByUsername(String username);

    /**
     * getUserByID 根据 id 获取用户
     *
     * @param id id
     * @return user
     */
    User getUserByID(int id);

    /**
     * queryUser 查询用户
     *
     * @param params 查询参数
     * @return List of user
     */
    List<User> queryUser(Map<String, Object> params);

    /**
     * getUserCount 获取用户总数
     *
     * @param params 查询参数
     * @return count
     */
    int getUserCount(Map<String, Object> params);

    /**
     * addUser 增加用户
     *
     * @param user 用户
     */
    void addUser(User user);

    /**
     * updateUser 更新用户
     *
     * @param user 用户
     */
    void updateUser(User user);

    /**
     * deleteUserById 根据 id 删除用户
     *
     * @param id 用户的 id
     */
    void deleteUserById(int id);
}
