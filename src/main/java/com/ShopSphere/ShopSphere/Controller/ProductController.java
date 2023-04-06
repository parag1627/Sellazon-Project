package com.ShopSphere.ShopSphere.Controller;

import com.ShopSphere.ShopSphere.Convertor.ProductConvertor;
import com.ShopSphere.ShopSphere.Enum.ProductCategory;
import com.ShopSphere.ShopSphere.Exception.SellerNotFoundException;
import com.ShopSphere.ShopSphere.RequestDTO.ProductRequestDTO;
import com.ShopSphere.ShopSphere.ResponseDTO.ProductResponseDTO;
import com.ShopSphere.ShopSphere.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductRequestDTO productRequestDTO) throws SellerNotFoundException {

        ProductResponseDTO productResponseDTO;
                try{
                productResponseDTO= productService.addProduct(productRequestDTO);
                }
                catch (Exception e){
                    return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
                }
       return new ResponseEntity(productResponseDTO,HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/category/{productCategory}")

    public List<ProductResponseDTO> getProductByCategory( @PathVariable("productCategory") ProductCategory productCategory){
        return productService.getProductByCategory(productCategory);
    }

}
