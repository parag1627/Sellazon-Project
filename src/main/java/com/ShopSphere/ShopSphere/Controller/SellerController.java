package com.ShopSphere.ShopSphere.Controller;

import com.ShopSphere.ShopSphere.RequestDTO.AllSellerRequestDTO;
import com.ShopSphere.ShopSphere.RequestDTO.SellerRequestDTO;
import com.ShopSphere.ShopSphere.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/seller")
@RestController
public class SellerController {
    @Autowired
    SellerService sellerService;

    @PostMapping("/add")
    public String addSeller(@RequestBody SellerRequestDTO sellerRequestDTO){
        return sellerService.addSeller(sellerRequestDTO);
       // return "Seller has Been ADDED";
    }
    @GetMapping("/get")
    public List<AllSellerRequestDTO> getSeller(@RequestParam("age") int age){
        return sellerService.getSeller(age);
    }
}
