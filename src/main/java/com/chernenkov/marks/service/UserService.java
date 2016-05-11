package com.chernenkov.marks.service;



import com.chernenkov.marks.domain.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    User getUser(String byWhat, String value);

    List<User> getAllUsers();

    List<User> getIntersectingUsers(String currentUserName);

}
