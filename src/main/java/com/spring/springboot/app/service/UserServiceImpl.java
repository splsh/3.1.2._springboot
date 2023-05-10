package com.spring.springboot.app.service;

import com.spring.springboot.app.entity.User;
import com.spring.springboot.app.repo.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(long id) {
        return userRepository.findUserById(id);
    }
}
