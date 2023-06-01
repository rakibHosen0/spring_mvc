package org.spring.service;

import org.spring.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public  User getUserById(Long id);
    public  void saveUser(User user);
    public void deleteUser(User user);

    public  User loginUser(String email, String password);
}
