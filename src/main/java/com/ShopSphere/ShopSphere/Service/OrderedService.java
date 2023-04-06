package com.ShopSphere.ShopSphere.Service;

import com.ShopSphere.ShopSphere.Exception.CustomerNotFoundException;
import com.ShopSphere.ShopSphere.Exception.ProductNotFoundException;
import com.ShopSphere.ShopSphere.RequestDTO.OrderedRequestDto;
import com.ShopSphere.ShopSphere.ResponseDTO.OrderedResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface OrderedService {

    public OrderedResponseDto placeOrder(OrderedRequestDto orderedRequestDto) throws Exception;
}

