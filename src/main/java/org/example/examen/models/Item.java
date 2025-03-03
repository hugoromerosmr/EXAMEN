package org.example.examen.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "item")
@Getter
@Setter
@AllArgsConstructor
public class Item {
    @Id
    private String _id;
    private String id;
    private String title;
    private double price;
    private String category;
    private String description;
    private double rate;
    private String count;
    private String image;
}
