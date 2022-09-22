package com.bilgeadam.commentapp.controller;

import com.bilgeadam.commentapp.repository.entity.ProductComment;
import com.bilgeadam.commentapp.service.ProductCommentService;
import com.bilgeadam.commentapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class ProductCommentController {

    private final ProductCommentService productCommentService;


    @GetMapping("/save")
    public ResponseEntity<ProductComment> save(String comment,String commentDate,Long productId,Long userId  ){

        ProductComment productComment=productCommentService.save(ProductComment.builder()
                        .comment(comment).commentDate(LocalDate.parse(commentDate))
                        .productId(productId).userId(userId)
                .build());

        return ResponseEntity.ok(productComment);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ProductComment>> findAll(){

        return ResponseEntity.ok(productCommentService.findAll());
    }


}
