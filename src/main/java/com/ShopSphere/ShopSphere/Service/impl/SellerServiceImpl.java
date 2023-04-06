package com.ShopSphere.ShopSphere.Service.impl;

import com.ShopSphere.ShopSphere.Convertor.SellerConvertor;
import com.ShopSphere.ShopSphere.Model.Seller;
import com.ShopSphere.ShopSphere.Repository.SellerRepository;
import com.ShopSphere.ShopSphere.RequestDTO.AllSellerRequestDTO;
import com.ShopSphere.ShopSphere.RequestDTO.SellerRequestDTO;
import com.ShopSphere.ShopSphere.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {


    @Autowired
    SellerRepository sellerRepository;
    public String addSeller(SellerRequestDTO sellerRequestDTO){
     Seller seller= SellerConvertor.sellerRequestDtoToSeller(sellerRequestDTO);

     sellerRepository.save(seller);

     return "Now..!!! You Are Eligible To ShopSphere World..!! ";

    }

     public List<AllSellerRequestDTO> getSeller(int age) {
        List<Seller> listAllSeller = sellerRepository.findByAge(age);

        List<AllSellerRequestDTO> AllSellers = new ArrayList<>();

        for(Seller s : listAllSeller){

            AllSellerRequestDTO allSeller = new AllSellerRequestDTO();
            allSeller.setName(s.getName());
            allSeller.setAge(s.getAge());
            AllSellers.add(allSeller);
        }
        return AllSellers;
     }

   // public SellerResponseDTO getSeller(RequestToFindAllSeller requestToFindAllSeller){
//        Seller seller = sellerRepository.findAll(requestToFindAllSeller.)
//
//        SellerResponseDTO sellerResponseDTO = new SellerResponseDTO();
//        sellerResponseDTO.setSellerName(requestToFindAllSeller.getSellerId());
//        sellerResponseDTO.setMobNo(sellerResponseDTO.getMobNo());
//
//        sellerRepository.save(seller);
//        return sellerResponseDTO;



}
