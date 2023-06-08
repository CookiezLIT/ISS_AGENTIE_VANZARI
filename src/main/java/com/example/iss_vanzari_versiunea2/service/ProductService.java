package com.example.iss_vanzari_versiunea2.service;

import com.example.iss_vanzari_versiunea2.model.Product;
import com.example.iss_vanzari_versiunea2.repository.ProductRepository;

import java.util.List;

public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(String name, String countryOfOrigin, int quantity, float price) {
        Product product = new Product(name, countryOfOrigin, quantity, price);
        return productRepository.save(product);
    }

    public Product saveProductObject(Product p){
        return productRepository.save(p);
    }

    public Product findProductById(long id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProductById(long id) {
        Product product = productRepository.findById(id);
        if (product != null) {
            productRepository.delete(product);
        } else {
            // Handle case when product with the given ID doesn't exist
        }
    }


    // Function to add an order
    public void addOrder(String productName, int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity. Quantity must be greater than zero.");
            return;
        }

        Product product = productRepository.findByName(productName);
        if (product == null) {
            System.out.println("Product with name " + productName + " not found.");
            return;
        }

        if (product.getQuantity() < quantity) {
            System.out.println("Insufficient product quantity.");
            return;
        }

        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
    }


}
