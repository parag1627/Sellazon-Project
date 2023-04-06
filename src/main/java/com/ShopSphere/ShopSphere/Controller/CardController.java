package com.ShopSphere.ShopSphere.Controller;

import com.ShopSphere.ShopSphere.Exception.CustomerNotFoundException;
import com.ShopSphere.ShopSphere.RequestDTO.CardRequestDTO;
import com.ShopSphere.ShopSphere.ResponseDTO.CardResponseDTO;
import com.ShopSphere.ShopSphere.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/card")
@RestController
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/add")
    public ResponseEntity addCards(@RequestBody  CardRequestDTO cardRequestDTO) {

        CardResponseDTO cardResponseDTO;
        try{
            cardResponseDTO=cardService.addCards(cardRequestDTO);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity(cardResponseDTO, HttpStatus.ACCEPTED);
    }
}
