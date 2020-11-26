package Tests.dao;

import Tests.models.StudentAnswer;
import Tests.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentAnswerDao {
    public StudentAnswer findStudentAnswerById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(StudentAnswer.class, id);
    }

    public void save(StudentAnswer studentAnswer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(studentAnswer);
        tx1.commit();
        session.close();
    }

    public void update(StudentAnswer studentAnswer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(studentAnswer);
        tx1.commit();
        session.close();
    }

    public void delete(StudentAnswer studentAnswer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(studentAnswer);
        tx1.commit();
        session.close();
    }

    public List<StudentAnswer> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return (List<StudentAnswer>) session.createQuery("From StudentAnswer").list();
    }
}
