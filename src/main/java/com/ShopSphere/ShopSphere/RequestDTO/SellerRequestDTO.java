package com.ShopSphere.ShopSphere.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerRequestDTO {

    private String name;

    private int age;

    private String mobNo;

    private String email;

    private String panCard;

}
