package com.chernenkov.marks.service;



import com.chernenkov.marks.domain.Group;

import java.util.List;


public interface GroupService {
    void createGroup(Group group);
    void updateGroup(Group group);
    List<Group> getGroupList();
    Group getGroup(int id);
    void removeGroup(int id);
}
