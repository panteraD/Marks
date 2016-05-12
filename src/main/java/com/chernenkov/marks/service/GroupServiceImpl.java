package com.chernenkov.marks.service;


import com.chernenkov.marks.dao.GroupDAO;
import com.chernenkov.marks.domain.Group;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Andrey on 03.05.2016.
 */
@Service
public class GroupServiceImpl implements  GroupService {
    private GroupDAO groupDAO;

    public void setGroupDAO(GroupDAO groupDAO){
        this.groupDAO = groupDAO;
    }

    @Transactional
    public void createGroup(Group group) {
        this.groupDAO.createGroup(group);
    }

    @Transactional
    public void updateGroup(Group group) {
        this.groupDAO.updateGroup(group);
    }

    @Transactional
    public List<Group> getGroupList() {
        return this.groupDAO.getGroupList();
    }

    @Transactional
    public Group getGroup(int id) {
        return this.groupDAO.getGroup(id);
    }

    @Transactional
    public void removeGroup(int id) {
        this.groupDAO.removeGroup(id);
    }
}
