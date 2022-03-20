package com.example.myfirstapplication.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findUserById(int id) {
        return userRepository.findById(id).get();
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User getUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

}
