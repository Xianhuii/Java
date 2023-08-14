package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.example.entity.User;

import java.util.List;

public interface UserMapper {
    int createUser(User user);
    List<User> queryUser(User user);
    int delUser(Long id);

    int updateUser(User user);
}
