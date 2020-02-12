package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;

import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule {

    private final static BigDecimal MIN_DISCOUNT = BigDecimal.valueOf(0);
    private final static BigDecimal MAX_DISCOUNT = BigDecimal.valueOf(100);
    private final static BigDecimal MIN_PRODUCT_PRICE = BigDecimal.valueOf(20);


    @Override
    public void validate(Product product) {
        checkNotNull(product);
        checkDiscountRange(product);
        checkDiscountApplicable(product);
    }

    private void checkDiscountRange(Product product) {
        if (product.getDiscount().compareTo(MIN_DISCOUNT) < 0 || product.getDiscount().compareTo(MAX_DISCOUNT) > 0) {
            throw new ProductValidationException(String.format("Product discount cannot be less than %s or greater than %s percent.", MIN_DISCOUNT, MAX_DISCOUNT));
        }
    }

    private void checkDiscountApplicable(Product product) {
        if (product.getPrice().compareTo(MIN_PRODUCT_PRICE) < 0) {
            throw new ProductValidationException(String.format("Cannot apply discount for a product with price less than 20. Current price is: '%s'", product.getPrice()));
        }
    }
}
