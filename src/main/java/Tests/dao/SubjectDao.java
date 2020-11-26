package Tests.dao;

import Tests.models.Subject;
import Tests.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SubjectDao {
    public Subject findSubjectById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Subject.class, id);
    }

    public void save(Subject subject) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(subject);
        tx1.commit();
        session.close();
    }

    public void update(Subject subject) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(subject);
        tx1.commit();
        session.close();
    }

    public void delete(Subject subject) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(subject);
        tx1.commit();
        session.close();
    }

    public List<Subject> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return (List<Subject>) session.createQuery("From Subject").list();
    }
}
