
package com.example.accessingdatajpa.repository;

import com.example.accessingdatajpa.model.Property;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PropertyRepository extends CrudRepository<Property, Long> {
    List<Property> findByAddress(String address);
    Property findById(long id);
}
