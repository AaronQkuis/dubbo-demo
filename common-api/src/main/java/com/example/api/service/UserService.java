package com.example.api.service;

import com.example.api.entity.User;
import java.util.List;

public interface UserService {
    /**
     * 根据ID获取用户
     */
    User getUserById(Long id);

    /**
     * 获取所有用户
     */
    List<User> listAllUsers();

    /**
     * 创建用户
     */
    boolean createUser(User user);

    /**
     * 更新用户
     */
    boolean updateUser(User user);

    /**
     * 删除用户
     */
    boolean deleteUser(Long id);
}