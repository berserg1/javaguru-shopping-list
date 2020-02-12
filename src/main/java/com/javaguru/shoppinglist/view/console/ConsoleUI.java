package com.javaguru.shoppinglist.view.console;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleUI {

    public void execute() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                ProductService productService = new ProductService();
                switch (userInput) {
                    case 1:
                        Product product = new Product();
                        System.out.println("Enter product name: ");
                        product.setName(scanner.nextLine());
                        System.out.println("Enter product price: ");
                        product.setPrice(new BigDecimal(scanner.nextLine()).setScale(2, BigDecimal.ROUND_HALF_EVEN));
                        System.out.println("Enter product category: ");
                        product.setCategory(scanner.nextLine());
                        System.out.println("Enter product description (optional) or press enter to skip: ");
                        product.setDescription(scanner.nextLine());
                        System.out.println("Enter product discount as a percentage: ");
                        product.setDiscount(new BigDecimal(scanner.nextLine()).setScale(2, BigDecimal.ROUND_HALF_EVEN));
                        long productId = productService.createProduct(product);
                        System.out.println(String.format("Product has been added to Database. Product id: %s", productId));
                        System.out.println("Result: " + product.getId());
                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        System.out.println(productService.getProduct(id).getName());
                    case 3:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
                System.out.println(e.getMessage());
            }
        }
    }
}
