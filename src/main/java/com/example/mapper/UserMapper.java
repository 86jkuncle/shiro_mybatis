package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 * @date 2019/9/16 10:12
 */
@Repository
public interface UserMapper {
    User findByName(@Param("name") String name);
}
