package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;

import java.math.BigDecimal;

public class ProductPriceValidationRule implements ProductValidationRule {

    private final static BigDecimal MIN_PRICE = BigDecimal.valueOf(0);

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getPrice().compareTo(MIN_PRICE) <= 0) {
            throw new ProductValidationException("Product price should be greater than zero.");
        }
    }
}