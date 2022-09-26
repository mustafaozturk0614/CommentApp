package com.bilgeadam.commentapp.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/*
* favProductlar ekleyelim bunlarý id bazýnda tutacaðýz
* /* user ýd ve product ýd ile favaorulere urun ekleyen bir metot yazalým bunun da end pointini yazalým
*
* */
@Entity
@Table(name = "tbl_user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private   Long id;
    @Column(length = 50)
    private  String name;
    @Column(length = 50)
    private  String surName;
    @Column(length = 50)
    private  String email;
    @Column(length = 15)
    private String telephone;
    @Column(length = 32)
    private String password;
    @ElementCollection
    List<Long> favProducts;

}
