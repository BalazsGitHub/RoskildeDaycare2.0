package com.example.myfirstapplication.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // repository is a place where all your DB functions are
public interface UserRepository extends CrudRepository<User, Integer> {

    public User findUserByUsername(String username);

}
