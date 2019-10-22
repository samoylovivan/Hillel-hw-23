package ivan.samoylov.Dao;

import ivan.samoylov.Model.Group;
import ivan.samoylov.Model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentStorage implements Storage {

    private SessionFactory sessionFactory;
    public StudentStorage() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void close() {
        sessionFactory.close();
    }

    public int removeAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = String.format("DELETE FROM %s", Student.class.getSimpleName());
            Query query = session.createQuery(hql);
            int count = query.executeUpdate();
            transaction.commit();
            return count;
        }
    }


    public int removeUnit(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = String.format("DELETE FROM students WHERE id = :id ", Student.class);
            Query query = session
                    .createQuery(hql)
                    .setParameter("id", id);
            int retValue = query.executeUpdate();
            transaction.commit();
            return retValue;
        }
    }


    public int removeUnitByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = String.format("DELETE FROM students WHERE name = :name ", Student.class);
            Query query = session
                    .createQuery(hql)
                    .setParameter("name", name);
            int retValue = query.executeUpdate();
            transaction.commit();
            return retValue;
        }
    }


    public void addUnit(Object object) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
        }
    }


    public void updateUnit(Object object) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
        }
    }


    public Object getUnit(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("FROM students WHERE id = :id ", Student.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }
    }


    public List<Group> getAllUnits() {
//        try (Session session = sessionFactory.openSession()) {
//            return session.createQuery("FROM students", Student.class).list();
//        }
        return null;
    }
}
