package com.clean.arch.example.entrypoint.rest;

import com.clean.arch.example.entrypoint.converters.ProductConverter;
import com.clean.arch.example.entrypoint.dto.ProductDto;
import com.clean.arch.example.usecase.product.*;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final CreateProduct createProduct;
    private final DeleteProduct deleteProduct;
    private final EditProduct editProduct;
    private final FindOneProduct findOneProduct;
    private final ListAllProducts listAllProducts;

    @PostMapping()
    public void createProduct(@RequestBody ProductDto product) {
        createProduct.execute(ProductConverter.toDomain(product));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> listAllProducts() {
        return ProductConverter.toDtos(listAllProducts.execute());
    }

    @GetMapping(value = "/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto findOneProduct(@PathVariable(value = "code") int code) {
        return ProductConverter.toDto(findOneProduct.execute(code));
    }

    @PutMapping()
    public void editProduct(@RequestBody ProductDto product) {
        editProduct.execute(ProductConverter.toDomain(product));
    }

    @DeleteMapping(value = "/{code}")
    public void deleteProduct(@PathVariable(value = "code") int code) {
        deleteProduct.execute(code);
    }
}
