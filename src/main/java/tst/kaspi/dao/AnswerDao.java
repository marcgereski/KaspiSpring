package tst.kaspi.dao;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import tst.kaspi.domain.Answer;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class AnswerDao {
    @Resource
    private SessionFactory sessionFactory;

    public List<Answer> getList() {
        @SuppressWarnings("unchecked")
        List<Answer> list = sessionFactory.openSession().createCriteria(Answer.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return list;
    }

    public void add(Answer answer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(answer);
        session.getTransaction().commit();
        session.close();
    }
}
