package com.ijse.IJSEFinalpasan_pathiranage.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
    private List<Long> items;
    private List<Integer> quantities;
}
