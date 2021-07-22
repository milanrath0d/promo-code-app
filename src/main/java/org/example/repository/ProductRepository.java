package org.example.repository;

import org.example.bean.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Milan Rathod
 */
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
