package Tests.utils;

import Tests.models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Answer.class);
                configuration.addAnnotatedClass(Group.class);
                configuration.addAnnotatedClass(Question.class);
                configuration.addAnnotatedClass(Role.class);
                configuration.addAnnotatedClass(Schedule.class);
                configuration.addAnnotatedClass(Student_Answer.class);
                configuration.addAnnotatedClass(Subject.class);
                configuration.addAnnotatedClass(Test.class);
                configuration.addAnnotatedClass(Test_List.class);
                configuration.addAnnotatedClass(User.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
        return sessionFactory;
    }
}
