package com.ShopSphere.ShopSphere.Service.impl;

import com.ShopSphere.ShopSphere.Enum.ProductStatus;
import com.ShopSphere.ShopSphere.Exception.CustomerNotFoundException;
import com.ShopSphere.ShopSphere.Exception.ProductNotFoundException;
import com.ShopSphere.ShopSphere.Model.*;
import com.ShopSphere.ShopSphere.Repository.CustomerRepository;
import com.ShopSphere.ShopSphere.Repository.ProductRepository;
import com.ShopSphere.ShopSphere.RequestDTO.CustomerRequestDTO;
import com.ShopSphere.ShopSphere.RequestDTO.OrderedRequestDto;
import com.ShopSphere.ShopSphere.ResponseDTO.OrderedResponseDto;
import com.ShopSphere.ShopSphere.Service.OrderedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

import javax.tools.JavaFileManager;

@Service
@Slf4j

public class OrderedServiceImp implements OrderedService {
  @Autowired
    CustomerRepository customerRepository;

  @Autowired
    ProductRepository productRepository;

  @Autowired
  private JavaMailSender emailSender;
    public OrderedResponseDto placeOrder(OrderedRequestDto orderedRequestDto) throws Exception {
      Customer customer;
      try {
          customer= customerRepository.findById(orderedRequestDto.getCustomerId()).get();
      }
      catch (Exception e){
          throw new CustomerNotFoundException("Invalid Customer ID..!!!");
      }
        Product product;
      try {
          product= productRepository.findById(orderedRequestDto.getProductId()).get();
      }
      catch (Exception e){
          throw new ProductNotFoundException("Invalid Product ID..!!!");
      }
      if(product.getQuantity() < orderedRequestDto.getRequiredQuantity()){
          throw new Exception("Sorry..Required Quantity is more");
      }
      Ordered order= new Ordered();
        order.setTotal(orderedRequestDto.getRequiredQuantity() * product.getPrice());
        order.setDeliveryCharge(40);

        Card card = customer.getCardList().get(0);

        String cardNo ="";
        for(int i=0;i<card.getCardNo().length()-4;i++)
            cardNo+='X';
            cardNo+=card.getCardNo().substring(card.getCardNo().length()-4);
            order.setCardUsedForPayment(cardNo);

        Item item = new Item();
        item.setRequiredQuantity(orderedRequestDto.getRequiredQuantity());
        item.setProduct(product);
        item.setOrdered(order);
        order.getOrderedItemList().add(item);
        order.setCustomer(customer);

        int leftQuantity = product.getQuantity()-orderedRequestDto.getRequiredQuantity();
        if(leftQuantity<=0)
            product.setProductStatus(ProductStatus.OUT_OF_STOCK);
        product.setQuantity(leftQuantity);

        customer.getOrderedList().add(order);
        Customer savedCustomer = customerRepository.save(customer);
        Ordered savedOrder = savedCustomer.getOrderedList().get(savedCustomer.getOrderedList().size()-1);

        //prepare response DTO
        OrderedResponseDto orderResponseDto = OrderedResponseDto.builder()
                .productName(product.getProductName())
                .orderDate(savedOrder.getOrderDate())
                .quantityOrdered(orderedRequestDto.getRequiredQuantity())
                .cardUsedForPayment(cardNo)
                .itemPrice(product.getPrice())
                .totalCost(order.getTotal())
                .deliveryCharge(40)
                .build();


        // send an email
        String text = "Congrats your order with total value "+order.getTotal()+" has been placed";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("backendavengers@gmail.com");
        message.setTo(customer.getEmail());
        message.setSubject("Order Placed Notification");
        message.setText(text);
        emailSender.send(message);

        return orderResponseDto;
   }
}