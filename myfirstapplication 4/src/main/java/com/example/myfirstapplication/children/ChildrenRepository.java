package com.example.myfirstapplication.children;

import com.example.myfirstapplication.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildrenRepository extends CrudRepository<Children, Integer> {


}
