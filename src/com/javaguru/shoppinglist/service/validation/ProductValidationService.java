package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.rules.ProductDiscountValidationRule;
import com.javaguru.shoppinglist.service.validation.rules.ProductNameValidationRule;
import com.javaguru.shoppinglist.service.validation.rules.ProductPriceValidationRule;
import com.javaguru.shoppinglist.service.validation.rules.ProductValidationRule;

import java.util.ArrayList;
import java.util.List;

public class ProductValidationService {

    private List<ProductValidationRule> rules = new ArrayList<>();

    public ProductValidationService() {
        rules.add(new ProductNameValidationRule());
        rules.add(new ProductPriceValidationRule());
        rules.add(new ProductDiscountValidationRule());
    }

    public void validate(Product product) {
        rules.forEach(r -> r.validate(product));
    }
}
