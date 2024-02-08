package com.ijse.IJSEFinalpasan_pathiranage.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
    private String name;
    private Double price;
    private Integer stock_qty;
    private String image;
    private Long categoryId;
}

