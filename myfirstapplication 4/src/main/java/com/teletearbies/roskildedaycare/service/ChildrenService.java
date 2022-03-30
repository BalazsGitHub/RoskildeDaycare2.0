package com.teletearbies.roskildedaycare.service;

import com.teletearbies.roskildedaycare.repository.ChildrenRepository;
import com.teletearbies.roskildedaycare.entity.Children;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//The only jobs of the service is to delete, update, retrieve data

@Service
public class ChildrenService {

    //It uses the repository methods, even though we did not specify in the interface.

    //Autowiring is the same as to be implementing the Children repository interface.
    //Basically @Autowired makes it possible for you to instantiate classes / implementation without extending the interface, or creating a new object of a class
    //It is a way to access the methods from the repository which extends the Crud interface



   @Autowired private ChildrenRepository childrenRepository;


    public void saveChildren(Children children) {
        childrenRepository.save(children);
    }



    public List<Children> getAllChildren() {
        return (List<Children>) childrenRepository.findAll();
    }

    public Children getChildren(Integer id) throws ChildrenNotFoundException {
          Optional<Children> result = childrenRepository.findById(id);
          if (result.isPresent()) {
              return result.get();
          }
          throw new ChildrenNotFoundException("Could not find any Child with id: " + id);
    }

    public void deleteChildren(Integer id) throws ChildrenNotFoundException {
        Long count = childrenRepository.countById(id);
        if (count == null || count == 0)
        {
            throw new ChildrenNotFoundException("Could not find child with id "  + id);
        }

        childrenRepository.deleteById(id);
    }
}
