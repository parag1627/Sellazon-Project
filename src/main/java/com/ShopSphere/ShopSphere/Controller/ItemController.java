package com.ShopSphere.ShopSphere.Controller;

import com.ShopSphere.ShopSphere.Exception.ProductNotFoundException;
import com.ShopSphere.ShopSphere.Repository.ItemRepository;
import com.ShopSphere.ShopSphere.ResponseDTO.ItemResponseDTO;
import com.ShopSphere.ShopSphere.Service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

//@RestController
//@RequestMapping("/item")
//public class ItemController {
//
//    @Autowired
//    ItemService itemService;
//    @Autowired
//    private ItemRepository itemRepository;
//
//    @GetMapping("/view/{productId}")
//    public ResponseEntity viewItem(@PathVariable("productId") int productId){
//
//        ItemResponseDto itemResponseDto;
//        try{
//            itemResponseDto = itemService.viewItem(productId);
//        } catch (ProductNotFoundException e) {
//            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//
//        return new ResponseEntity(itemResponseDto,HttpStatus.ACCEPTED);
//    }
//}
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/view/{productId}")
    public ResponseEntity viewItem(@PathVariable("productId") int productId){
   ItemResponseDTO itemResponseDTO;
   try {
       itemResponseDTO= itemService.viewItem(productId);
   } catch (ProductNotFoundException e) {
       return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
   }
       return  new ResponseEntity(itemResponseDTO,HttpStatus.ACCEPTED);
   }
}
