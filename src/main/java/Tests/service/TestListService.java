package Tests.service;

import Tests.dao.TestListDao;
import Tests.models.TestList;

import java.util.List;

public class TestListService {
    private final TestListDao testListDao = new TestListDao();

    public TestListService() {}

    public void saveTestList(TestList testList) { testListDao.save(testList); }

    public void updateTestList(TestList testList) { testListDao.update(testList); }

    public void deleteTestList(TestList testList) { testListDao.delete(testList); }

    public List<TestList> findAllTestLists() { return testListDao.findAll(); }

    public TestList findTestList(int id) { return testListDao.findTestListById(id); }
}
