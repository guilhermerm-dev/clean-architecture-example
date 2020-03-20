package com.clean.arch.example.domain.port;

import com.clean.arch.example.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT product FROM Product product")
    List<Product> listAllProducts();

    @Query(value = "SELECT product FROM Product product WHERE product.Id = :productId")
    Product findProductById(int productId);

    @Query(value = "DELETE FROM store.product WHERE id = :productId", nativeQuery = true)
    void deleteProduct(int productId);

    @Query(value = "UPDATE store.product SET name = :name, description = :description, quantity = :quantity WHERE Id = :id", nativeQuery = true)
    void editProduct(Integer id, String name, String description, Integer quantity);

    @Query(value = "INSERT INTO store.product (id , \"name\" , description , quantity ) " +
            "VALUES (:id,:name,:description,:quantity);", nativeQuery = true)
    void createProduct(Integer id, String name, String description, Integer quantity);
}
