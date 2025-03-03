package org.example.examen.repository;

import org.example.examen.models.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {


    List<Item> findByCategoryContainingIgnoreCase(String categoria);

    Optional<Item> findById(String id);

    long countByRateGreaterThan(double rate);


}
