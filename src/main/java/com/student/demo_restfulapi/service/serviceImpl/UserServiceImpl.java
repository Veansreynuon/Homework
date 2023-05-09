package com.student.demo_restfulapi.service.serviceImpl;

import com.student.demo_restfulapi.model.User;
import com.student.demo_restfulapi.model.UserAccount;
import com.student.demo_restfulapi.repository.UserRepository;
import com.student.demo_restfulapi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
//    inject repository to pull data from database
    UserRepository userRepository;
    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public List<User> allUsers() {
        return userRepository.allUsers();
    }

    @Override
    public List<User> findUserByName() {
        return null;
    }

    @Override
    public User findUserByID(int id) {
    //    call from repository
        return userRepository.findUserByID(id);
    }

    @Override
    public int createNewUser(User user) {
        return userRepository.createNewUser(user);
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int removeUser(int id) {
        return 0;
    }

    @Override
    public List<UserAccount> getAllUserAccounts() {
        return userRepository.getAllUserAccounts();
    }
}
