package com.bilgeadam.commentapp.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateRequestDto {

    private  String name;
    private  String surName;
    private  String email;
    private String password;
    private  String telephone;
    private LocalDate createdDate;
}
