package com.clean.arch.example.domain.port;

import com.clean.arch.example.domain.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {

    List<Product> listAllProducts();

    Product findProductById(int productId);

    void deleteProduct(int productId);

    void editProduct(Product product);

    void createProduct(Product product);
}
