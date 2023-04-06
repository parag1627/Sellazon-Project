package com.ShopSphere.ShopSphere.Service.impl;

import com.ShopSphere.ShopSphere.Convertor.ProductConvertor;
import com.ShopSphere.ShopSphere.Enum.ProductCategory;
import com.ShopSphere.ShopSphere.Exception.SellerNotFoundException;
import com.ShopSphere.ShopSphere.Model.Product;
import com.ShopSphere.ShopSphere.Model.Seller;
import com.ShopSphere.ShopSphere.Repository.ProductRepository;
import com.ShopSphere.ShopSphere.Repository.SellerRepository;
import com.ShopSphere.ShopSphere.RequestDTO.ProductRequestDTO;
import com.ShopSphere.ShopSphere.ResponseDTO.ProductResponseDTO;
import com.ShopSphere.ShopSphere.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;
    public ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO) throws SellerNotFoundException {
        Seller seller;
         try{
             seller =sellerRepository.findById(productRequestDTO.getSellerId()).get();
         }
         catch (Exception e){
              throw new SellerNotFoundException("Invalid Seller ID");
         }

        Product product = ProductConvertor.productRequestDtoToProduct(productRequestDTO);

        product.setSeller(seller);
       seller.getProductList().add(product);

       sellerRepository.save(seller);

     ProductResponseDTO productResponseDTO = ProductConvertor.productToProductResponseDto(product);


   return productResponseDTO;

    }

    @Override
    public List<ProductResponseDTO> getProductByCategory(ProductCategory productCategory){

        List<Product> products = productRepository.findAllByProductCategory(productCategory);

        // prepare a list of response dtos
        List<ProductResponseDTO> productResponseDtos = new ArrayList<>();
        for(Product product: products){
            ProductResponseDTO productResponseDto = ProductConvertor.productToProductResponseDto(product);
            productResponseDtos.add(productResponseDto);
        }

        return productResponseDtos;
    }
}
//    public List<ProductResponseDTO> getProductByCategory(ProductCategory productCategory) {
//        List<Product> products = productRepository.findAllByProductCategory(productCategory);
//
//        List<ProductResponseDTO>productResponseDTOS = new ArrayList<>();
//        for(Product product :products){
//            ProductResponseDTO productResponseDTO = ProductConvertor.productToProductResponseDto(product);
//        productResponseDTOS.add(productResponseDTO);
//        }
//        return productResponseDTOS;
//    }

