package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductInMemoryRepository repository;

    @InjectMocks
    private ProductService victim;

    @Test
    public void shouldFindProductById() {
        when(repository.findById(10L)).thenReturn(createProduct());

        Product actualProduct = victim.getProduct(10L);

        assertEquals(createProduct().getId(), actualProduct.getId());
    }

    private Product createProduct() {
        Product product = new Product();
        product.setId(10L);
        product.setName("Test Product");
        product.setCategory("Test Category");
        product.setDescription("Test Product Description");
        product.setPrice(BigDecimal.valueOf(100));
        product.setDiscount(BigDecimal.valueOf(0));
        return product;
    }
}