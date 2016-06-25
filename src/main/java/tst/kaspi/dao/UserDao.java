package tst.kaspi.dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tst.kaspi.domain.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<User> getList() {
        return getSession().createQuery("from tst.kaspi.domain.Role").list();
    }

    @Transactional
    public void add(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public User get(Long id) {
        return (User) sessionFactory.openSession().get(User.class, id);
    }

    public User get(String username) {
        String hql = "FROM tst.kaspi.domain.User u WHERE u.username = :name";
        Query query = sessionFactory.openSession().createQuery(hql);
        query.setString("name", username);
        return (User) query.uniqueResult();
    }

    public void update(User user) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.merge(user);
        session.getTransaction().commit();
        session.close();
    }


}
