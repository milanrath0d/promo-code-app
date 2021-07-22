package org.example.service;

import org.example.bean.Product;
import org.example.repository.ProductRepository;
import org.example.util.CurrencyConversionUtil;
import org.example.util.PromotionUtil;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Milan Rathod
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final RestTemplate restTemplate;

    public ProductService(ProductRepository productRepository, RestTemplate restTemplate) {
        this.productRepository = productRepository;
        this.restTemplate = restTemplate;
        fetchProducts();
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    private void fetchProducts() {

        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(
                "https://api.jsonbin.io/b/5d31a1c4536bb970455172ca/latest",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                });

        List<Product> products = responseEntity.getBody();

        if (products != null) {
            products.forEach(product -> {
                float convertedPrice = CurrencyConversionUtil.convert(product.getCurrency(), product.getPrice());
                product.setPrice(convertedPrice);
                PromotionUtil.applyDiscount(product);

            });
            productRepository.saveAll(products);
        }
    }

    private void applyCoupons() {

    }

}
