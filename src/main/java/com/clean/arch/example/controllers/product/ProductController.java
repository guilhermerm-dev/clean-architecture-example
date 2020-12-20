package com.clean.arch.example.controllers.product;

import com.clean.arch.example.controllers.presenters.ProductPresenter;
import com.clean.arch.example.controllers.dto.ProductDto;
import com.clean.arch.example.usecase.product.*;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@Log4j
@RequestMapping("/products")
public class ProductController {

    private final CreateProduct createProduct;
    private final DeleteProduct deleteProduct;
    private final EditProduct editProduct;
    private final FindProduct findProduct;
    private final ListProducts listProducts;

    @PostMapping()
    public void createProduct(@RequestBody ProductDto product) {
        log.info("Creating product");
        createProduct.execute(ProductPresenter.toDomain(product));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> listAllProducts() {
        log.info("Listing products");
        return ProductPresenter.toDtos(listProducts.execute());
    }

    @GetMapping(value = "/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto findProduct(@PathVariable(value = "code") int code) {
        log.info("Finding product");
        return ProductPresenter.toDto(findProduct.execute(code));
    }

    @PutMapping()
    public void editProduct(@RequestBody ProductDto product) {
        log.info("Editing product");
        editProduct.execute(ProductPresenter.toDomain(product));
    }

    @DeleteMapping(value = "/{code}")
    public void deleteProduct(@PathVariable(value = "code") int code) {
        log.info("Deleting product");
        deleteProduct.execute(code);
    }
}
