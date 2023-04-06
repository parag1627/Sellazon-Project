package com.ShopSphere.ShopSphere.RequestDTO;

import com.ShopSphere.ShopSphere.Enum.ProductCategory;
import com.ShopSphere.ShopSphere.Enum.ProductStatus;
import com.ShopSphere.ShopSphere.Model.Seller;
import com.ShopSphere.ShopSphere.Service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequestDTO {

    private int price;

    private String productName;

    private ProductCategory productCategory;


    private  int quantity;


    private ProductStatus productStatus;

    private int sellerId;
}
