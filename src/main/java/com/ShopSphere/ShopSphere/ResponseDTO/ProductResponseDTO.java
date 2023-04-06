package com.ShopSphere.ShopSphere.ResponseDTO;

import com.ShopSphere.ShopSphere.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDTO {
    private String productName;

    private int price;

    private int quantity;

    private ProductStatus productStatus;


}
