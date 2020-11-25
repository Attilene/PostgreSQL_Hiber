package Users_Autos.service;

import Users_Autos.dao.AutoDao;
import Users_Autos.models.Auto;
import Users_Autos.models.User;

import java.util.List;

public class AutoService {
    private final AutoDao autoDao = new AutoDao();

    public AutoService() {}

    public User findUser(int id) { return autoDao.findUserById(id); }

    public void saveAuto(Auto auto) { autoDao.save(auto); }

    public void updateAuto(Auto auto) { autoDao.update(auto); }

    public void deleteAuto(Auto auto) { autoDao.delete(auto); }

    public List<Auto> findAllUsers() { return autoDao.findAll(); }

    public Auto findAuto(int id) { return autoDao.findAutoById(id); }

}
