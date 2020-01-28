package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 0L;
        while (true) {
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        System.out.println("Enter product name: ");
                        String nameFromInput = scanner.nextLine();
                        String name = getNameFromInput(nameFromInput);
                        System.out.println("Enter product price: ");
                        BigDecimal priceFromInput = new BigDecimal(scanner.nextLine()).setScale(2, BigDecimal.ROUND_HALF_EVEN);
                        BigDecimal price = getPriceFromInput(priceFromInput);
                        System.out.println("Enter product category: ");
                        String category = scanner.nextLine();
                        System.out.println("Enter product description (optional) or press enter to skip: ");
                        String description = scanner.nextLine();
                        System.out.println("Enter product discount as a percentage: ");
                        Integer discountFromInput = scanner.nextInt();
                        BigDecimal discount = getDiscountFromInput(discountFromInput);
                        Product product = new Product();
                        product.setName(name);
                        product.setPrice(price);
                        product.setCategory(category);
                        product.setDescription(description);
                        product.setDiscount(discount);
                        product.setId(productIdSequence);
                        productRepository.put(productIdSequence, product);
                        productIdSequence++;
                        System.out.println("Result: " + product.getId());
                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        Product findProductResult = productRepository.get(id);
                        System.out.println(findProductResult.getName());
                    case 3:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
                System.out.println(e.getMessage());
            }
        }
    }

    private static BigDecimal getPriceFromInput(BigDecimal price) {
        while (price.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Price should be greater than zero. Please try again: ");
            price = new BigDecimal(scanner.nextLine()).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }
        return price;
    }

    private static String getNameFromInput(String name) {
        while (name.length() < 3 || name.length() > 32) {
            System.out.println("Name should contain between 3 and 32 characters. Please try again: ");
            name = scanner.nextLine();
        }
        return name;
    }

    private static BigDecimal getDiscountFromInput(Integer discount) {
        while (discount.compareTo(100) > 0) {
            System.out.println("Discount cannot be greater than 100 percent. Please try again: ");
            discount = scanner.nextInt();
        }
        return new BigDecimal(discount / (double) 100).setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }
}
