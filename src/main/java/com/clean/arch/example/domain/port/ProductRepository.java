package com.clean.arch.example.domain.port;

import com.clean.arch.example.domain.entity.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> listAllProducts();

    Product findProductById(int productId);

    void deleteProduct(int productId);

    void editProduct();

    void createProduct();
}
