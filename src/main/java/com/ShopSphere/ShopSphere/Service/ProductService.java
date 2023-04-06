package com.ShopSphere.ShopSphere.Service;

import com.ShopSphere.ShopSphere.Enum.ProductCategory;
import com.ShopSphere.ShopSphere.Exception.SellerNotFoundException;
import com.ShopSphere.ShopSphere.RequestDTO.ProductRequestDTO;
import com.ShopSphere.ShopSphere.ResponseDTO.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    public ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO) throws SellerNotFoundException;

    public List<ProductResponseDTO> getProductByCategory(ProductCategory productCategory);
}
