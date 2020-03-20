package com.clean.arch.example.entrypoint.rest;

import com.clean.arch.example.domain.entity.Product;
import com.clean.arch.example.entrypoint.converters.ProductConverter;
import com.clean.arch.example.entrypoint.dto.ProductDto;
import com.clean.arch.example.usecase.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor

public class ProductController {

    private final CreateProduct createProduct;
    private final DeleteProduct deleteProduct;
    private final EditProduct editProduct;
    private final FindProductById findProductById;
    private final ListAllProducts listAllProducts;

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public void createProduct(@RequestBody ProductDto product) {
        createProduct.execute(ProductConverter.toDomain(product));
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> listAllProducts() {
        return listAllProducts.execute();
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
    public Product findProductById(@RequestParam Integer productId) {
        return findProductById.execute(productId);
    }

    @RequestMapping(value = "/products", method = RequestMethod.PUT)
    public void editProduct(@RequestBody ProductDto product) {
        editProduct.execute(ProductConverter.toDomain(product));
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE)
    public void deleteProduct(@RequestParam Integer productId) {
        deleteProduct.execute(productId);
    }
}
