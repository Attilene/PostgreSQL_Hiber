package Users_Autos.dao;

import Users_Autos.models.Auto;
import Users_Autos.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Users_Autos.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class AutoDao {

    public User findUserById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public void save(Auto auto) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(auto);
        tx1.commit();
        session.close();
    }

    public void update(Auto auto) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(auto);
        tx1.commit();
        session.close();
    }

    public void delete(Auto auto) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(auto);
        tx1.commit();
        session.close();
    }

    public Auto findAutoById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Auto.class, id);
    }

    public List<Auto> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return (List<Auto>) session.createQuery("From Auto").list();
    }
}
