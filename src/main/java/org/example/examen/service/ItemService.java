/**
 * Service class for managing items.
 */
package org.example.examen.service;

import org.example.examen.models.Item;
import org.example.examen.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing items.
 */
@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    /**
     * Retrieves all items.
     *
     * @return a list of all items
     */
    public List<Item> obtenerTodos() {
        return itemRepository.findAll();
    }

    /**
     * Finds an item by its ID.
     *
     * @param id the ID of the item
     * @return an Optional containing the item if found, or empty if not found
     */
    public Optional<Item> findById(String id) {
        return itemRepository.findById(id);
    }
}