package com.teletearbies.roskildedaycare.repository;

import com.teletearbies.roskildedaycare.entity.Children;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


//A repository class is responsible for the data management

@Repository
public interface ChildrenRepository extends CrudRepository<Children, Integer> {
    public Long countById(Integer id);


}
