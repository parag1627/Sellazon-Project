package com.ShopSphere.ShopSphere.Controller;

import com.ShopSphere.ShopSphere.Repository.CartRepository;
import com.ShopSphere.ShopSphere.Repository.CustomerRepository;
import com.ShopSphere.ShopSphere.RequestDTO.OrderedRequestDto;
import com.ShopSphere.ShopSphere.ResponseDTO.OrderedResponseDto;
import com.ShopSphere.ShopSphere.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    CartService cartService;
    @Autowired
    CartRepository cartRepository;

       @PostMapping("add")
    public String addToCart(@RequestBody OrderedRequestDto orderedRequestDto){

           String response="";
           try {
               cartService.addToCard(orderedRequestDto);
           }
           catch (Exception e){
               return e.getMessage();
           }
           return response;
       }
       @PostMapping("/checkout/{customerId}")
    public ResponseEntity checkOutCart(@PathVariable("customerId") int customerId){
           List<OrderedResponseDto> orderedResponseDtos;
           try {
               orderedResponseDtos= cartService.checkOutCart(customerId);
           }
           catch (Exception e){
               return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
           }
           return new ResponseEntity(orderedResponseDtos,HttpStatus.ACCEPTED);
}

}