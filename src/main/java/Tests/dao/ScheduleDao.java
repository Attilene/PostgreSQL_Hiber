package Tests.dao;

import Tests.models.Schedule;
import Tests.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ScheduleDao {
    public Schedule findScheduleById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Schedule.class, id);
    }

    public void save(Schedule schedule) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(schedule);
        tx1.commit();
        session.close();
    }

    public void update(Schedule schedule) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(schedule);
        tx1.commit();
        session.close();
    }

    public void delete(Schedule schedule) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(schedule);
        tx1.commit();
        session.close();
    }

    public List<Schedule> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return (List<Schedule>) session.createQuery("From Schedule").list();
    }
}
