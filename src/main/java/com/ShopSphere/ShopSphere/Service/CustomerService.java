package com.ShopSphere.ShopSphere.Service.impl;

import com.ShopSphere.ShopSphere.RequestDTO.CustomerRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    public String addCustomer(CustomerRequestDTO customerRequestDTO);
}
