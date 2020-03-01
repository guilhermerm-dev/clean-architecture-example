package com.clean.arch.example.entrypoint.rest;

import com.clean.arch.example.entrypoint.dto.ProductDto;
import com.clean.arch.example.usecase.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor

public class ProductController {

    private final CreateProduct createProduct;
    private final DeleteProduct deleteProduct;
    private final EditProduct editProduct;
    private final FindProductById findProductById;
    private final ListAllProducts listAllProducts;

//    @RequestMapping(value = "/products", method = RequestMethod.POST)
//    public void createProduct(ProductDto product) {
//    createProduct.createProduct(ProductConverter);
//    }

}
