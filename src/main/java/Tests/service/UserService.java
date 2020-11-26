package Tests.service;

import Tests.dao.UserDao;
import Tests.models.User;

import java.util.List;

public class UserService {
    private final UserDao userDao = new UserDao();

    public UserService() {}

    public void saveUser(User user) { userDao.save(user); }

    public void updateUser(User user) { userDao.update(user); }

    public void deleteUser(User user) { userDao.delete(user); }

    public List<User> findAllUsers() { return userDao.findAll(); }

    public User findUser(int id) { return userDao.findUserById(id); }
}
