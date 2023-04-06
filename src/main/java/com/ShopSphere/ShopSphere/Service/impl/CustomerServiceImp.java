package com.ShopSphere.ShopSphere.Service.impl;

import com.ShopSphere.ShopSphere.Convertor.CustomerConvertor;
import com.ShopSphere.ShopSphere.Model.Cart;
import com.ShopSphere.ShopSphere.Model.Customer;
import com.ShopSphere.ShopSphere.Repository.CustomerRepository;
import com.ShopSphere.ShopSphere.RequestDTO.CustomerRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements com.ShopSphere.ShopSphere.Service.impl.CustomerService {
@Autowired
    CustomerRepository customerRepository;
    public String addCustomer(CustomerRequestDTO customerRequestDTO){
        Customer customer= CustomerConvertor.CustomerRequestDtoToCustomer(customerRequestDTO);

        Cart cart= new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);

        customer.setCart(cart);

        customerRepository.save(customer);

        return "Welcome !!! to china Market...";

    }
}
