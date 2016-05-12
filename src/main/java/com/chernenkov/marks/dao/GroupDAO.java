package com.chernenkov.marks.dao;



import com.chernenkov.marks.domain.Group;

import java.util.List;

/**
 * Created by Andrey on 03.05.2016.
 */
public interface GroupDAO {
    void createGroup(Group group);
    void updateGroup(Group group);
    List<Group> getGroupList();
    Group getGroup(int id);
    void removeGroup(int id);
}
