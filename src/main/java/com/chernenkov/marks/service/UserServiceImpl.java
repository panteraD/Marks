package com.chernenkov.marks.service;


import com.chernenkov.marks.common.Util;
import com.chernenkov.marks.dao.ParamDao;
import com.chernenkov.marks.dao.UserDao;
import com.chernenkov.marks.domain.Param;
import com.chernenkov.marks.domain.User;
import static com.chernenkov.marks.common.AttributeType.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private ParamDao paramDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User getUser(String byWhat, String fullName) {
        return userDao.getUser(byWhat, fullName);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public List<User> getIntersectingUsers(String currentUserName) {
        User currentUser = getUser(LOGIN, currentUserName);
        Param paramBeginCurrentUser = paramDao.getParam(BEGIN, LOGIN, currentUser.getLogin());
        Param paramEndCurrentUser = paramDao.getParam(END, LOGIN, currentUser.getLogin());
        Param paramAddressCurrentUser = paramDao.getParam(ADDRESS, LOGIN, currentUser.getLogin());

        List<User> intersectingUsers = new ArrayList<>();

        for (User users: getAllUsers()) {
            if(Objects.equals(users.getLogin(), currentUser.getLogin()))
                continue;
            Param paramBegin = paramDao.getParam(BEGIN, LOGIN, users.getLogin());
            Param paramEnd = paramDao.getParam(END, LOGIN, users.getLogin());
            Param paramAddress = paramDao.getParam(ADDRESS, LOGIN, users.getLogin());

            if(Util.isOverlap(paramBeginCurrentUser.getValue(), paramEndCurrentUser.getValue(),
                    paramBegin.getValue(), paramEnd.getValue()) ) {
                intersectingUsers.add(users);
            }
        }

        return intersectingUsers;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setParamDao(ParamDao paramDao) {
        this.paramDao = paramDao;
    }
}
