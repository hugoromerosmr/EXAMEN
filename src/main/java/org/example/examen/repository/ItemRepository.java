package org.example.examen.repository;

import org.example.examen.models.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

    /**
     * Encuentra items por categoría, ignorando mayúsculas y minúsculas.
     *
     * @param categoria La categoría a buscar.
     * @return Una lista de items que pertenecen a la categoría especificada.
     */
    List<Item> findByCategoryContainingIgnoreCase(String categoria);

    /**
     * Encuentra un item por su ID.
     *
     * @param id El ID del item a encontrar.
     * @return Un Optional que contiene el item encontrado, o vacío si no se encuentra.
     */
    Optional<Item> findById(String id);

    /**
     * Cuenta el número de items con una puntuación mayor que el valor especificado.
     *
     * @param rate El umbral de puntuación.
     * @return El número de items con una puntuación mayor que el valor especificado.
     */
    long countByRateGreaterThan(double rate);
}