package com.bilgeadam.commentapp.service;

import com.bilgeadam.commentapp.repository.IProductRepository;
import com.bilgeadam.commentapp.repository.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

private final IProductRepository productRepository;



public Product save(Product product){
    return productRepository.save(product);
}


public List<Product> findAll(){
    return  productRepository.findAll();
}






}
