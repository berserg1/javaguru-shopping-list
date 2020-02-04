package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        if (product.getDiscount().compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new IllegalArgumentException("Product discount cannot be greater than 100 percent.");
        }
    }
}
