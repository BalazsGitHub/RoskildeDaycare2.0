package com.teletearbies.roskildedaycare.service;

import com.teletearbies.roskildedaycare.entity.WaitingList;
import com.teletearbies.roskildedaycare.repository.WaitingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WaitingListService {
    @Autowired private WaitingListRepository waitingListRepository;

    public void saveWaitingList(WaitingList waitingList) {
        waitingListRepository.save(waitingList);
    }

    public List <WaitingList> getFullWaitingList(){
        return (List<WaitingList>) waitingListRepository.findAll();
    }

    public WaitingList getWaitingList(Integer id) throws ChildrenNotFoundException{
        Optional <WaitingList> result = waitingListRepository.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new ChildrenNotFoundException("could not find child with id: " + id);
    }

    public void deleteChildrenFromWaitingList(Integer id) throws ChildrenNotFoundException {
        Long count = waitingListRepository.countById(id);
        if (count == null || count == 0)
        {
            throw new ChildrenNotFoundException("Could not find child with id "  + id);
        }

        waitingListRepository.deleteById(id);
    }
}
