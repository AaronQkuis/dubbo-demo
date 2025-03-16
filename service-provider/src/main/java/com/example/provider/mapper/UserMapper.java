package com.example.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.api.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}

