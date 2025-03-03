package org.example.examen.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Representa un item en la colección de MongoDB.
 */
@Document(collection = "item")
@Getter
@Setter
@AllArgsConstructor
public class Item {
    /**
     * El identificador único del item.
     */
    @Id
    private String _id;

    /**
     * El ID del item.
     */
    private String id;

    /**
     * El título del item.
     */
    private String title;

    /**
     * El precio del item.
     */
    private double price;

    /**
     * La categoría del item.
     */
    private String category;

    /**
     * La descripción del item.
     */
    private String description;

    /**
     * La puntuación del item.
     */
    private double rate;

    /**
     * La cantidad del item.
     */
    private String count;

    /**
     * La URL de la imagen del item.
     */
    private String image;
}