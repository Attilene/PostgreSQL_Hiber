package Tests.service;

import Tests.dao.RoleDao;
import Tests.models.Role;

import java.util.List;

public class RoleService {
    private final RoleDao roleDao = new RoleDao();

    public RoleService() {}

    public void saveRole(Role role) { roleDao.save(role); }

    public void updateRole(Role role) { roleDao.update(role); }

    public void deleteRole(Role role) { roleDao.delete(role); }

    public List<Role> findAllRoles() { return roleDao.findAll(); }

    public Role findRole(int id) { return roleDao.findRoleById(id); }
}
