package com.clean.arch.example.domain.port;

import com.clean.arch.example.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> listAllProducts();

    Product findProductById(int productId);

    void deleteProduct(int productId);

    void editProduct(Product product);

    void createProduct(Product product);
}
