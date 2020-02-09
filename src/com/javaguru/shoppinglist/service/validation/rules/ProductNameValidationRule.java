package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;

public class ProductNameValidationRule implements ProductValidationRule {

    private final static Integer MIN_NAME_LENGTH = 3;
    private final static Integer MAX_NAME_LENGTH = 32;

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getName().length() < MIN_NAME_LENGTH || product.getName().length() > MAX_NAME_LENGTH) {
            throw new ProductValidationException("Product name should contain between 3 and 32 characters.");
        }
    }
}
