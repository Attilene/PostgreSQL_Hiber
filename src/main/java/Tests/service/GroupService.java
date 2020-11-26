package Tests.service;

import Tests.dao.GroupDao;
import Tests.models.Group;

import java.util.List;

public class GroupService {
    private final GroupDao groupDao = new GroupDao();

    public GroupService() {}

    public void saveGroup(Group group) { groupDao.save(group); }

    public void updateGroup(Group group) { groupDao.update(group); }

    public void deleteGroup(Group group) { groupDao.delete(group); }

    public List<Group> findAllGroups() { return groupDao.findAll(); }

    public Group findGroup(int id) { return groupDao.findGroupById(id); }
}
