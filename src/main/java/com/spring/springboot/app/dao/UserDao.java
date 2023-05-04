package com.spring.springboot.app.dao;

import com.spring.springboot.app.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getUserList();

    void addUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    User getUserById(long id);
}
