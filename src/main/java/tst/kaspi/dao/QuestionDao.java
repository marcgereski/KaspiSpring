package tst.kaspi.dao;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import tst.kaspi.domain.Question;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class QuestionDao {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public void add(Question question) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(question);
        session.getTransaction().commit();
        session.close();
    }

    @Transactional
    public List<Question> getList() {
        @SuppressWarnings("unchecked")
        List<Question> list = (List<Question>) sessionFactory.openSession()
                .createCriteria(Question.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return list;
    }

    public Question get(Long id) {
        return (Question) sessionFactory.openSession().get(Question.class, id);
    }
}
