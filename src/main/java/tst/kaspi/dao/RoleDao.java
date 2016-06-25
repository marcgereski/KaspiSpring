package tst.kaspi.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tst.kaspi.domain.Role;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class RoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Role> list() {
        @SuppressWarnings("unchecked")
        List<Role> list = (List<Role>) sessionFactory.openSession()
                .createCriteria(Role.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return list;
    }

    public Role getRole(long id) {
        return  (Role) sessionFactory.getCurrentSession().get(Role.class, id);
    }

    public Role getRole(String value) {
        String hql = "FROM tst.kaspi.domain.Role r WHERE r.value = :r";
        Query query = sessionFactory.openSession().createQuery(hql);
        query.setString("r", value);
        return (Role)query.uniqueResult();
    }
}
