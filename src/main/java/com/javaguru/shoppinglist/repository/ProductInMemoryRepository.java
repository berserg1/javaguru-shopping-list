package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProductInMemoryRepository {

    private Long productIdSequence = 0L;
    private Map<Long, Product> products = new HashMap<>();

    public Product insert(Product product) {
        product.setId(productIdSequence);
        products.put(productIdSequence, product);
        productIdSequence++;
        return product;
    }

    public Product findById(Long id) {
        return products.get(id);
    }

    public Optional<Product> findByName(String name) {
        Optional<Product> product = products.values().stream()
                .filter(p -> p.getName().equals(name))
                .findFirst();
        return product;
    }
}
