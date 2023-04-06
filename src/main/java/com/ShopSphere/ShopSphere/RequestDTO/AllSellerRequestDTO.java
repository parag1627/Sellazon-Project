package com.ShopSphere.ShopSphere.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllSellerRequestDTO {
    private String name;
    private int age;
}
