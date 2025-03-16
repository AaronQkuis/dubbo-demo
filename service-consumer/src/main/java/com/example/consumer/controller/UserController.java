package com.example.consumer.controller;

import com.example.api.common.i18n.ApiResultI18n;
import com.example.api.entity.User;
import com.example.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@Api(tags = "用户请求")
public class UserController {

    @DubboReference(version = "1.0.0", group = "user", check = false)
    private UserService userService;

    @ApiOperation("根据id获取用户")
    @GetMapping("/{id}")
    public ApiResultI18n<User> getUser(@PathVariable Long id) {
        log.info("Getting user with id: {}", id);
        return ApiResultI18n.success(userService.getUserById(id));
    }

    @ApiOperation("获取所有用户")
    @GetMapping("/list")
    public ApiResultI18n<List<User>> listUsers() {
        log.info("Listing all users");
        return ApiResultI18n.success(userService.listAllUsers());
    }

    @ApiOperation("创建用户")
    @PostMapping("/create")
    public ApiResultI18n<Boolean> createUser(@RequestBody User user) {
        log.info("Creating user: {}", user);
        return ApiResultI18n.success(userService.createUser(user));
    }

    @ApiOperation("更新用户信息")
    @PutMapping("/update")
    public ApiResultI18n<Boolean> updateUser(@RequestBody User user) {
        log.info("Updating user: {}", user);
        return ApiResultI18n.success(userService.updateUser(user));
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/{id}")
    public ApiResultI18n<Boolean> deleteUser(@PathVariable Long id) {
        log.info("Deleting user with id: {}", id);
        return ApiResultI18n.success(userService.deleteUser(id));
    }
}