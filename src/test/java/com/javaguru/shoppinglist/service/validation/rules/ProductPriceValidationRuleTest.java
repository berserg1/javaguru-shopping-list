package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

public class ProductPriceValidationRuleTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private ProductPriceValidationRule victim = new ProductPriceValidationRule();

    private Product input;

    @Test
    public void shouldValidateCorrectInputSuccessfully() {
        input = createProduct(BigDecimal.valueOf(10));
        victim.validate(input);
    }

    @Test
    public void shouldThrowExceptionWhenInputInvalid() {
        input = createProduct(BigDecimal.valueOf(-10));

        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product price should be greater than zero.");

        victim.validate(input);
    }

    private Product createProduct(BigDecimal price) {
        Product product = new Product();
        product.setPrice(price);
        return product;
    }

}