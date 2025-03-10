package org.example.examen.repository;

import org.example.examen.models.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing Item entities.
 */
@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

    /**
     * Retrieves all items from the repository.
     *
     * @return a list of all items
     */
    public List<Item> findAll();

    /**
     * Finds an item by its ID.
     *
     * @param id the ID of the item
     * @return an Optional containing the item if found, or empty if not found
     */
    public Optional<Item> findById(String id);
}