package tst.kaspi.dao;


import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import tst.kaspi.domain.Category;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class CategoryDao {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Transactional
    public List<Category> getList() {
        @SuppressWarnings("unchecked")
        List<Category> list = (List<Category>) sessionFactory.openSession()/*getCurrentSession()*/
                .createCriteria(Category.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return list;
    }

    public Category get(Long id) {
        return (Category) sessionFactory.openSession().get(Category.class, id);
    }
}
