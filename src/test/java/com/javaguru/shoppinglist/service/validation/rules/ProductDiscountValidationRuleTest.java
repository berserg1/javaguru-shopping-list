package com.javaguru.shoppinglist.service.validation.rules;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

public class ProductDiscountValidationRuleTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private ProductDiscountValidationRule victim = new ProductDiscountValidationRule();

    private Product input;
    private BigDecimal priceValidForDiscount = BigDecimal.valueOf(20);
    private BigDecimal priceNotValidForDiscount = BigDecimal.valueOf(19);

    //TODO: Probably should test Rule private methods separately and then check that validate() calls them

    @Test
    public void shouldValidateDiscountInRangeSuccessfully() {
        input = createProduct(priceValidForDiscount, BigDecimal.valueOf(10));
        victim.validate(input);
    }

    @Test
    public void shouldThrowExceptionWhenDiscountLessThenSpecified() {
        input = createProduct(priceValidForDiscount, BigDecimal.valueOf(-1));

        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product discount cannot be less than 0 or greater than 100 percent.");

        victim.validate(input);
    }

    @Test
    public void shouldThrowExceptionWhenDiscountMoreThenSpecified() {
        input = createProduct(priceValidForDiscount, BigDecimal.valueOf(101));

        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Product discount cannot be less than 0 or greater than 100 percent.");

        victim.validate(input);
    }

    @Test
    public void shouldThrowExceptionWhenDiscountNotApplicable() {
        input = createProduct(priceNotValidForDiscount, BigDecimal.valueOf(10));

        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage(String.format("Cannot apply discount for a product with price less than 20. Current price is: '%s'", input.getPrice()));

        victim.validate(input);
    }

    private Product createProduct(BigDecimal price, BigDecimal discount) {
        Product product = new Product();
        product.setPrice(price);
        product.setDiscount(discount);
        return product;
    }

}