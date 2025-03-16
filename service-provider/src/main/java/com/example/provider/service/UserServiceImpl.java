package com.example.provider.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.api.entity.User;
import com.example.api.service.UserService;
import com.example.provider.mapper.UserMapper;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

@Slf4j
@DubboService(version = "1.0.0", group = "user")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final Counter requestCounter;
    private final MeterRegistry meterRegistry;
    private final Random random = new Random();

    @Autowired
    public UserServiceImpl(Counter requestCounter, MeterRegistry meterRegistry) {
        this.requestCounter = requestCounter;
        this.meterRegistry = meterRegistry;
    }

    @Override
    public User getUserById(Long id) {
        // 增加请求计数器
        requestCounter.increment();
        log.info("Getting user by id: {}", id);
        return this.baseMapper.selectById(id);
    }

    @Override
    public List<User> listAllUsers() {
        // 增加请求计数器
        requestCounter.increment();
        log.info("Listing all users");
        return this.baseMapper.selectList(null);
    }

    @Override
    public boolean createUser(User user) {
        // 增加请求计数器
        requestCounter.increment();
        log.info("Creating user: {}", user);
        return this.baseMapper.insert(user) > 0;
    }

    @Override
    public boolean updateUser(User user) {
        // 增加请求计数器
        requestCounter.increment();
        log.info("Updating user: {}", user);
        return this.baseMapper.updateById(user) > 0;
    }

    @Override
    public boolean deleteUser(Long id) {
        // 增加请求计数器
        requestCounter.increment();
        log.info("Deleting user: {}", id);
        return this.baseMapper.deleteById(id) > 0;
    }
}
