package org.example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Milan Rathod
 */
@Document(collection = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String product;

    private String category;

    private int inventory;

    private double rating;

    private String currency;

    private float price;

    private String origin;

    // private float discountedPrice;

}
