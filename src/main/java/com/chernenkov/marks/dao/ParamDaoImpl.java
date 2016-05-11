package com.chernenkov.marks.dao;

import com.chernenkov.marks.domain.Param;
import com.chernenkov.marks.domain.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class ParamDaoImpl extends AbstractDao implements ParamDao {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Param getParam(Integer attrId, String byWhat, String value) {
        Session session = getSessionFactory().openSession();
        User user = userDao.getUser(byWhat, value);
        Param param = (Param) session.createCriteria(Param.class).add(Restrictions.eq("user", user)).
                add(Restrictions.eq("attrId", attrId)).uniqueResult();
        session.close();

        return param;
    }

    @Override
    public void updateParam(Integer attrId, String byWhat, String value, String newValue) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Param param = getParam(attrId, byWhat, value);
            param.setValue(newValue);
            session.update(param);
            transaction.commit();
        } catch (HibernateException e) {
            if(transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

}
