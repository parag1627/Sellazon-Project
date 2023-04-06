package com.ShopSphere.ShopSphere.Service;

import com.ShopSphere.ShopSphere.Exception.CustomerNotFoundException;
import com.ShopSphere.ShopSphere.RequestDTO.CardRequestDTO;
import com.ShopSphere.ShopSphere.ResponseDTO.CardResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface CardService {
    public CardResponseDTO addCards(CardRequestDTO cardRequestDTO) throws CustomerNotFoundException;
}
