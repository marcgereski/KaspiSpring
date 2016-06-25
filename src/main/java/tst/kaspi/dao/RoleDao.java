package tst.kaspi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tst.kaspi.domain.Role;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<Role> getList() {
        return getSession().createQuery("from tst.kaspi.domain.Role").list();
    }
}
