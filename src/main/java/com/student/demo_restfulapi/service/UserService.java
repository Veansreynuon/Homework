package com.student.demo_restfulapi.service;

import com.student.demo_restfulapi.model.User;
import com.student.demo_restfulapi.model.UserAccount;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    List<User> findUserByName();
    User findUserByID(int id);
    int createNewUser(User user);
    int updateUser(User user);
    int removeUser(int id);

    @Select("select * from user_account_tb")
    List<UserAccount> getAllUserAccounts();
}
