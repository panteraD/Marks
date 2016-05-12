package com.chernenkov.marks.dao;


import com.chernenkov.marks.domain.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Andrey on 03.05.2016.
 */
public class GroupDAOImpl extends AbstractDao implements GroupDAO {
    private static final Logger logger = LoggerFactory.getLogger(GroupDAOImpl.class);

    public void createGroup(Group group) {
        Session session = getSessionFactory().openSession();
        session.persist(group);
        session.close();
        logger.info("Group saved successfully, details:" + group);
    }

    public void updateGroup(Group group) {
        Session session = getSessionFactory().openSession();
        session.update(group);
        session.close();
        logger.info("Group updated successfully, details:" + group);
    }

    @SuppressWarnings("unchecked")
    public List<Group> getGroupList() {
        Session session = getSessionFactory().openSession();
        List<Group> groupList = session.createQuery("from Group").list();
        for(Group group: groupList){
            logger.info("Group list"+group);
        }
        session.close();
        return groupList;
    }

    public Group getGroup(int id) {
        Session session = getSessionFactory().openSession();
        Group group = (Group)session.load(Group.class, new Integer(id));
        session.close();
        logger.info("Group loaded");
        return group;
    }

    public void removeGroup(int id) {
        Session session = getSessionFactory().openSession();
        Group group = (Group) session.load(Group.class, new Integer(id));
        if(null!= group){
            session.delete(group);
        }
        logger.info("Group deleted successfully" + group);
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public SessionFactory getSessionFactory() {
        return super.getSessionFactory();
    }
}
