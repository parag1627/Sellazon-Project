package com.ShopSphere.ShopSphere.Service;

import com.ShopSphere.ShopSphere.Exception.ProductNotFoundException;
import com.ShopSphere.ShopSphere.ResponseDTO.ItemResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface ItemService {

    public ItemResponseDTO viewItem(int productId) throws ProductNotFoundException;
}
