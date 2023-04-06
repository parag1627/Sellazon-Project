package com.ShopSphere.ShopSphere.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SellerResponseDTO {
     private int sellerName;
     private String mobNo;
}
