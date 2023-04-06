package com.ShopSphere.ShopSphere.Service.impl;

import com.ShopSphere.ShopSphere.Exception.ProductNotFoundException;
import com.ShopSphere.ShopSphere.Model.Item;
import com.ShopSphere.ShopSphere.Model.Product;
import com.ShopSphere.ShopSphere.Repository.ItemRepository;
import com.ShopSphere.ShopSphere.Repository.ProductRepository;
import com.ShopSphere.ShopSphere.ResponseDTO.ItemResponseDTO;
import com.ShopSphere.ShopSphere.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
//public class ItemServiceImp implements ItemService {
//
//@Autowired
//    ProductRepository productRepository;
//
//    @Override
//    public ItemResponseDTO viewItem(int productId) throws ProductNotFoundException {
//        Product product;
//        try {
//            product = productRepository.findById(productId).get();
//        }
//        catch (Exception e){
//            throw new ProductNotFoundException("Sorry..!! Invalid ProductID");
//        }
//        Item item= Item.builder()
//                .requiredQuantity(0)
//                .product(product)
//                .build();
//
//        product.setItem(item);
//        productRepository.save(product);
//
//        ItemResponseDTO itemResponseDTO = ItemResponseDTO.builder()
//                .price(product.getPrice())
//                .productCategory(product.getProductCategory())
//                .productName(product.getProductName())
//                .productStatus(product.getProductStatus())
//                .build();
//
//        return itemResponseDTO;
//
//    }
//}
@Service
public class ItemServiceImp implements ItemService {

@Autowired
    ProductRepository productRepository;

    @Override
    public ItemResponseDTO viewItem(int productId) throws ProductNotFoundException {

        Product product;
        try{
            product = productRepository.findById(productId).get();
        }
        catch (Exception e){
            throw new ProductNotFoundException("Sorry! Invalid product id.");
        }

        Item item = Item.builder()
                .requiredQuantity(0)
                .product(product)
                .build();

        // map item to product
        product.setItem(item);

        // save both item and product
        productRepository.save(product);

        // prepare the response dto
        ItemResponseDTO itemResponseDto = ItemResponseDTO.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .productCategory(product.getProductCategory())
                .productStatus(product.getProductStatus())
                .build();

        return itemResponseDto;
    }
}