package com.ShopSphere.ShopSphere.Service;

import com.ShopSphere.ShopSphere.RequestDTO.AllSellerRequestDTO;
import com.ShopSphere.ShopSphere.RequestDTO.SellerRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SellerService  {

    public String addSeller(SellerRequestDTO sellerRequestDTO);


    public List<AllSellerRequestDTO> getSeller(int age);
    // public SellerResponseDTO getSeller(RequestToFindAllSeller requestToFindAllSeller);

}
