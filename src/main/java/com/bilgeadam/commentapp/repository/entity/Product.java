package com.bilgeadam.commentapp.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Locale;

@Table(name = "tbl_product")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private  double price;
    private LocalDate expirationDate;


}
