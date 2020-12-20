package com.clean.arch.example.gateway;

import com.clean.arch.example.domain.entities.Product;
import com.clean.arch.example.gateway.presenters.ProductPresenter;
import com.clean.arch.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductGateway {

    @Autowired
    ProductRepository productRepository;

    public void createProduct(Product product) {
        productRepository.save(ProductPresenter.toProductTable(product));
    }

    public boolean checkIfProductAlreadyExists(int code, String name) {
        return productRepository.checkIfProductAlreadyExists(code, name);
    }

    public void editProduct(int code, String name, String description, int quantity, double price) {
        productRepository.editProduct(code, name, description, quantity, price);
    }

    public void deleteProduct(int code) {
        productRepository.deleteProduct(code);
    }

    public Product findProduct(int code) {
        return ProductPresenter.presentToDomain(productRepository.findProduct(code));
    }

    public List<Product> listProducts() {
        return ProductPresenter.presentToDomain(productRepository.listProducts());
    }
}
