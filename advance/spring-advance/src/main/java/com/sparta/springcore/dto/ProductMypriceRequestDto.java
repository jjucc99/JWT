package com.sparta.springcore.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@NoArgsConstructor
@Getter
@Setter
public class ProductMypriceRequestDto {
    private String title;
    private String image;
    private String link;
    private int lprice;
    private int myprice;
}
