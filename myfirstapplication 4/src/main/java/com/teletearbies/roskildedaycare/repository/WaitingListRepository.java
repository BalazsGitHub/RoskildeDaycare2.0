package com.teletearbies.roskildedaycare.repository;

import com.teletearbies.roskildedaycare.entity.WaitingList;
import org.springframework.data.repository.CrudRepository;

public interface WaitingListRepository extends CrudRepository<WaitingList, Integer> {

    public Long countById(Integer id);
}

