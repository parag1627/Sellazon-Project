package com.ShopSphere.ShopSphere.Controller;

import com.ShopSphere.ShopSphere.RequestDTO.CustomerRequestDTO;
import com.ShopSphere.ShopSphere.Service.impl.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
@Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public String addCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        return customerService.addCustomer(customerRequestDTO);
    }

}
