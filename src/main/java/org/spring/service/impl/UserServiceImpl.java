package org.spring.service.impl;
import org.spring.dao.UserDao;
import org.spring.entity.User;
import org.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);

    }

    @Override
        public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }
    @Override
    public User updateUserById(Long id) {
        return userDao.updateUserById(id);
    }


    @Override
    public User loginUser(String email, String password) {
        return userDao.loginUser(email,password);
    }
}
