package com.bilgeadam.commentapp.controller;

import com.bilgeadam.commentapp.repository.IProductRepository;
import com.bilgeadam.commentapp.repository.entity.Product;
import com.bilgeadam.commentapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

private  final ProductService productService;


    @GetMapping("/save")
public ResponseEntity<Product> save(String name, Double price, String expirationDate){
        Product product;
    if (expirationDate!=null){
        product=  Product.builder().name(name).price(price).expirationDate(LocalDate.parse(expirationDate)).build();
    }else{
        product=  Product.builder().name(name).price(price).build();}

    return  ResponseEntity.ok(productService.save(product));

}

@GetMapping("/findAll")
public  ResponseEntity<List<Product>> findAll(){
    return  ResponseEntity.ok(productService.findAll());
}




}



