package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule {

    private final static BigDecimal MAX_DISCOUNT = BigDecimal.valueOf(100);

    @Override
    public void validate(Product product) {
        if (product.getDiscount().compareTo(MAX_DISCOUNT) > 0) {
            throw new ProductValidationException("Product discount cannot be greater than 100 percent.");
        }
    }
}
