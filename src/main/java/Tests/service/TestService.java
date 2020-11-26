package Tests.service;

import Tests.dao.TestDao;
import Tests.models.Test;

import java.util.List;

public class TestService {
    private final TestDao testDao = new TestDao();

    public TestService() {}

    public void saveTest(Test test) { testDao.save(test); }

    public void updateTest(Test test) { testDao.update(test); }

    public void deleteTest(Test test) { testDao.delete(test); }

    public List<Test> findAllTests() { return testDao.findAll(); }

    public Test findTest(int id) { return testDao.findTestById(id); }
}
