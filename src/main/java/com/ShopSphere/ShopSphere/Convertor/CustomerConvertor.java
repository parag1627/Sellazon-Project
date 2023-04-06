package com.ShopSphere.ShopSphere.Convertor;

import com.ShopSphere.ShopSphere.Model.Customer;
import com.ShopSphere.ShopSphere.RequestDTO.CustomerRequestDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerConvertor {

    public static Customer CustomerRequestDtoToCustomer (CustomerRequestDTO customerRequestDTO){
        return Customer.builder()
                .name(customerRequestDTO.getName())
                .age(customerRequestDTO.getAge())
                .mobNo(customerRequestDTO.getMobNo())
                .email(customerRequestDTO.getEmail())
                .build();
    }
}
