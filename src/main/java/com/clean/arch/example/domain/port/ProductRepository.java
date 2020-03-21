package com.clean.arch.example.domain.port;

import com.clean.arch.example.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT product FROM Product product WHERE is_deleted = false")
    List<Product> listAllProducts();

    @Query(value = "SELECT product FROM Product product WHERE product.Id = :productId and is_deleted = false")
    Product findProductById(int productId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE store.product SET is_Deleted = true WHERE id = :productId", nativeQuery = true)
    void deleteProduct(int productId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE store.product SET name = :name, description = :description, quantity = :quantity" +
            ", updated_date = clock_timestamp() WHERE Id = :id", nativeQuery = true)
    void editProduct(int id, String name, String description, int quantity);

    @Query(value = "SELECT EXISTS(SELECT 1 FROM store.product WHERE code = :productCode and " +
            "TRIM(LOWER(\"name\")) = TRIM(LOWER(:name)) and is_Deleted = false)", nativeQuery = true)
    boolean checkIfExistProduct(int productCode, String name);
}
