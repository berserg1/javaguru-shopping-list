package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;

public class ProductNameValidationRule implements ProductValidationRule {
    
    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getName().length() < 3 || product.getName().length() > 32) {
            throw new IllegalArgumentException("Product name should contain between 3 and 32 characters.");
        }
    }
}
