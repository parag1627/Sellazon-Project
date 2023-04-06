package com.ShopSphere.ShopSphere.Convertor;

import com.ShopSphere.ShopSphere.Model.Seller;
import com.ShopSphere.ShopSphere.RequestDTO.SellerRequestDTO;

public class SellerConvertor {

    public static Seller sellerRequestDtoToSeller(SellerRequestDTO sellerRequestDTO){
        return  Seller.builder()
                .mobNo(sellerRequestDTO.getMobNo())
                .name(sellerRequestDTO.getName())
                .email(sellerRequestDTO.getEmail())
                .panCard(sellerRequestDTO.getPanCard())
                .age(sellerRequestDTO.getAge())
                .build();
    }
}
