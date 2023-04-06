package com.ShopSphere.ShopSphere.Service.impl;

import com.ShopSphere.ShopSphere.Exception.CustomerNotFoundException;
import com.ShopSphere.ShopSphere.Model.Card;
import com.ShopSphere.ShopSphere.Model.Customer;
import com.ShopSphere.ShopSphere.Repository.CustomerRepository;
import com.ShopSphere.ShopSphere.RequestDTO.CardRequestDTO;
import com.ShopSphere.ShopSphere.ResponseDTO.CardDto;
import com.ShopSphere.ShopSphere.ResponseDTO.CardResponseDTO;
import com.ShopSphere.ShopSphere.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CardServiceImp implements CardService {

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public CardResponseDTO addCards(CardRequestDTO cardRequestDTO) throws CustomerNotFoundException {
        Customer customer;
        try{
            customer= customerRepository.findById(cardRequestDTO.getCustomerId()).get();
        }
        catch (Exception e){
            throw  new CustomerNotFoundException("Invalid Customer Id");
        }


       Card card= Card.builder()
                .id(cardRequestDTO.getCustomerId())
                .cvv(cardRequestDTO.getCvv())
                .cardType(cardRequestDTO.getCardType())
                .cardNo(cardRequestDTO.getCardNo())
                .customer(customer)
                .build();

        customer.getCardList().add(card);

        customerRepository.save(customer);


        CardResponseDTO cardResponseDTO= new CardResponseDTO();
        cardResponseDTO.setName(customer.getName());

        //convert every card to cardDto

        List<CardDto> cardDtoList = new ArrayList<>();

        for(Card card1 : customer.getCardList()){
            CardDto cardDto = new CardDto();
            cardDto.setCardNo(card1.getCardNo());
            cardDto.setCardType(card1.getCardType());

            cardDtoList.add(cardDto);
        }
        cardResponseDTO.setCardDto(cardDtoList);

        return cardResponseDTO;

    }
}
