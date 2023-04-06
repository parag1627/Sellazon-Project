package com.ShopSphere.ShopSphere.Convertor;

import com.ShopSphere.ShopSphere.Enum.ProductStatus;
import com.ShopSphere.ShopSphere.Model.Product;
import com.ShopSphere.ShopSphere.RequestDTO.ProductRequestDTO;
import com.ShopSphere.ShopSphere.ResponseDTO.ProductResponseDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductConvertor {

    public static Product productRequestDtoToProduct(ProductRequestDTO productRequestDTO){
       return Product.builder()
               .productName(productRequestDTO.getProductName())
               .price(productRequestDTO.getPrice())
               .quantity(productRequestDTO.getQuantity())
               .productCategory(productRequestDTO.getProductCategory())
               .productStatus(ProductStatus.AVAILABLE)

                .build();
    }
    public static ProductResponseDTO productToProductResponseDto(Product product){
       return   ProductResponseDTO.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .productStatus(product.getProductStatus())
               .quantity(product.getQuantity())
                .build();
    }

}
