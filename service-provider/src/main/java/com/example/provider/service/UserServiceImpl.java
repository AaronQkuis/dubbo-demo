package com.example.provider.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.api.entity.User;
import com.example.api.service.UserService;
import com.example.provider.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.List;

@Slf4j
@DubboService(version = "1.0.0", group = "user")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User getUserById(Long id) {
        log.info("Getting user by id: {}", id);
        return this.baseMapper.selectById(id);
    }

    @Override
    public List<User> listAllUsers() {
        log.info("Listing all users");
        return this.baseMapper.selectList(null);
    }

    @Override
    public boolean createUser(User user) {
        log.info("Creating user: {}", user);
        return this.baseMapper.insert(user) > 0;
    }

    @Override
    public boolean updateUser(User user) {
        log.info("Updating user: {}", user);
        return this.baseMapper.updateById(user) > 0;
    }

    @Override
    public boolean deleteUser(Long id) {
        log.info("Deleting user: {}", id);
        return this.baseMapper.deleteById(id) > 0;
    }
}
