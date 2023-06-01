package org.spring.dao;

import org.spring.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();

    public User loginUser(String email, String password);
    public void saveUser(User user);

    User getUserById(Long id);

    public void deleteUser(User user);
}
