package Tests.dao;

import Tests.models.TestList;
import Tests.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TestListDao {
    public TestList findTestListById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(TestList.class, id);
    }

    public void save(TestList testList) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(testList);
        tx1.commit();
        session.close();
    }

    public void update(TestList testList) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(testList);
        tx1.commit();
        session.close();
    }

    public void delete(TestList testList) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(testList);
        tx1.commit();
        session.close();
    }

    public List<TestList> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return (List<TestList>) session.createQuery("From TestList").list();
    }
}
