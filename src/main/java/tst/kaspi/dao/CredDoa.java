package tst.kaspi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import tst.kaspi.domain.Credential;

import javax.annotation.Resource;


@Repository
public class CredDoa {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;


    public String getPass(Long userId) {
        Credential c = (Credential) sessionFactory.openSession()
                .get(Credential.class, userId);
        return c.getPass();
    }

    public Credential get(Long userId) {
        return (Credential) sessionFactory.openSession()
                .get(Credential.class, userId);
    }

    public void add(Credential credential) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(credential);
        session.getTransaction().commit();
        session.close();
    }
}
