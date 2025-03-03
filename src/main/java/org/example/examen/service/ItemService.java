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

    /**
     * Encuentra un item por su ID.
     *
     * @param id El ID del item a encontrar.
     * @return Un Optional que contiene el item encontrado, o vacío si no se encuentra.
     */
    public Optional<Item> findById(String id) {
        return itemRepository.findById(id);
    }

    /**
     * Cuenta el número total de items.
     *
     * @return Una cadena que representa el número total de items.
     */
    public String countItems() {
        return "Total de items: " + itemRepository.count();
    }

    /**
     * Cuenta el número de items con una puntuación mayor que el valor especificado.
     *
     * @param rate El umbral de puntuación.
     * @return Una cadena que representa el número de items con una puntuación mayor que el valor especificado.
     */
    public String countItemsPuntuados(double rate) {
        return "Total de items puntuados: " + itemRepository.countByRateGreaterThan(rate);
    }
}