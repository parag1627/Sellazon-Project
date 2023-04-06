package com.ShopSphere.ShopSphere.Controller;

import com.ShopSphere.ShopSphere.Repository.OrderedRepository;
import com.ShopSphere.ShopSphere.RequestDTO.OrderedRequestDto;
import com.ShopSphere.ShopSphere.ResponseDTO.OrderedResponseDto;
import com.ShopSphere.ShopSphere.Service.OrderedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderedController {

    @Autowired
    OrderedService orderedService;
    @Autowired
    OrderedRepository orderedRepository;


    @PostMapping("/place")
    public ResponseEntity placeOrder(@RequestBody OrderedRequestDto orderRequestDto){

        OrderedResponseDto orderResponseDto;
        try{
            orderResponseDto = orderedService.placeOrder(orderRequestDto);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(orderResponseDto,HttpStatus.ACCEPTED);
    }
}
