package com.ShopSphere.ShopSphere.Service;

import com.ShopSphere.ShopSphere.Exception.CustomerNotFoundException;
import com.ShopSphere.ShopSphere.RequestDTO.OrderedRequestDto;
import com.ShopSphere.ShopSphere.ResponseDTO.OrderedResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {

    public String addToCard(OrderedRequestDto orderedRequestDto) throws Exception;
    public List<OrderedResponseDto> checkOutCart(int customerId) throws CustomerNotFoundException;

}
