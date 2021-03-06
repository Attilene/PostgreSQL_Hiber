package Users_Autos.service;

import Users_Autos.dao.UserDao;
import Users_Autos.models.Auto;
import Users_Autos.models.User;

import java.util.List;

public class UserService {
    private final UserDao userDao = new UserDao();

    public UserService() {}

    public User findUser(int id) { return userDao.findUserById(id); }

    public void saveUser(User user) { userDao.save(user); }

    public void updateUser(User user) { userDao.update(user); }

    public void deleteUser(User user) { userDao.delete(user); }

    public List<User> findAllUsers() { return userDao.findAll(); }

    public Auto findAuto(int id) { return userDao.findAutoById(id); }

}
