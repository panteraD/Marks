package com.chernenkov.marks.dao;


import com.chernenkov.marks.domain.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    User getUser(String byWhat, String value);

    List<User> getAllUsers();
}
