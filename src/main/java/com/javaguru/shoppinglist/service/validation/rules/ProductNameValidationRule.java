package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;

public class ProductNameValidationRule implements ProductValidationRule {

    private ProductInMemoryRepository repository = new ProductInMemoryRepository();

    private final static Integer MIN_NAME_LENGTH = 3;
    private final static Integer MAX_NAME_LENGTH = 32;

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        checkNameLength(product);
        checkNameUnique(product);
    }

    private void checkNameLength(Product product) {
        if (product.getName().length() < MIN_NAME_LENGTH || product.getName().length() > MAX_NAME_LENGTH) {
            throw new ProductValidationException(String.format("Product name should contain between %s and %s characters.", MIN_NAME_LENGTH, MAX_NAME_LENGTH));
        }
    }

    private void checkNameUnique(Product product) {
        if (repository.findByName(product.getName()).isPresent()) {
            throw new ProductValidationException(String.format("Product with name '%s' already exists", product.getName()));
        }
    }
}
