package com.ShopSphere.ShopSphere.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CustomerRequestDTO {
    private String name;
    private int age;
    private String email;
    private String mobNo;


}
