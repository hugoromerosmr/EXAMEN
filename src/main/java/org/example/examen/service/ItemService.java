package org.example.examen.service;

import org.example.examen.models.Item;
import org.example.examen.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Optional<Item> findById(String id) {
        return itemRepository.findById(id);
    }

    public String countItems() {
        return "Total de items: " + itemRepository.count();
    }

    public String countItemsPuntuados(double rate) {
        return "Total de items puntuados: " + itemRepository.countByRateGreaterThan(rate);
    }



}
