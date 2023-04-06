package com.ShopSphere.ShopSphere.ResponseDTO;

import com.ShopSphere.ShopSphere.Enum.ProductCategory;
import com.ShopSphere.ShopSphere.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemResponseDTO {

    private String productName;

    private int price;

    private ProductCategory productCategory;

    private ProductStatus productStatus;

}
