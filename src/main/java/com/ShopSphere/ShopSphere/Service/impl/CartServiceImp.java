package com.ShopSphere.ShopSphere.Service.impl;

import com.ShopSphere.ShopSphere.Enum.ProductStatus;
import com.ShopSphere.ShopSphere.Exception.CustomerNotFoundException;
import com.ShopSphere.ShopSphere.Exception.ProductNotFoundException;
import com.ShopSphere.ShopSphere.Model.*;
import com.ShopSphere.ShopSphere.Repository.CustomerRepository;
import com.ShopSphere.ShopSphere.Repository.ProductRepository;
import com.ShopSphere.ShopSphere.RequestDTO.OrderedRequestDto;
import com.ShopSphere.ShopSphere.ResponseDTO.OrderedResponseDto;
import com.ShopSphere.ShopSphere.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImp implements CartService {


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    JavaMailSender emailSender;

    public String addToCard(OrderedRequestDto orderedRequestDto) throws Exception {
        Customer customer;
        try{
            customer = customerRepository.findById(orderedRequestDto.getCustomerId()).get();
        }
        catch(Exception e){
            throw new CustomerNotFoundException("Invalid Customer id !!!");
        }

        Product product;
        try{
            product = productRepository.findById(orderedRequestDto.getProductId()).get();
        }
        catch (Exception e){
            throw new ProductNotFoundException("Invalid Product Id");
        }

        if(product.getQuantity()<orderedRequestDto.getRequiredQuantity()){
            throw new Exception("Sorry! Required quantity not available");
        }

        Cart cart = customer.getCart();

        int newCost = cart.getCartTotal() + orderedRequestDto.getRequiredQuantity()*product.getPrice();
        cart.setCartTotal(newCost);

        // Add item to current cart
        Item item = new Item();
        item.setRequiredQuantity(orderedRequestDto.getRequiredQuantity());
        item.setCart(cart);
        item.setProduct(product);
        cart.getItemList().add(item);

        customerRepository.save(customer);

        return "Item has been added to your Cart!!";
    }
    public List<OrderedResponseDto> checkOutCart(int customerId) throws CustomerNotFoundException {

        Customer customer;
        try{
            customer = customerRepository.findById(customerId).get();
        }
        catch(Exception e){
            throw new CustomerNotFoundException("Invalid Customer id !!!");
        }

        List<OrderedResponseDto> orderResponseDtos = new ArrayList<>();
        int totalCost = customer.getCart().getCartTotal();
        Cart cart = customer.getCart();
        for(Item item: cart.getItemList()){
            Ordered order = new Ordered();
            order.setTotal(item.getRequiredQuantity()*item.getProduct().getPrice());
            order.setDeliveryCharge(0);
            order.setCustomer(customer);
            order.getOrderedItemList().add(item);

            Card card = customer.getCardList().get(0);
            String cardNo = "";
            for(int i=0;i<card.getCardNo().length()-4;i++)
                cardNo += 'X';
            cardNo += card.getCardNo().substring(card.getCardNo().length()-4);
            order.setCardUsedForPayment(cardNo);

            int leftQuantity = item.getProduct().getQuantity()-item.getRequiredQuantity();
            if(leftQuantity<=0)
                item.getProduct().setProductStatus(ProductStatus.OUT_OF_STOCK);
            item.getProduct().setQuantity(leftQuantity);

            customer.getOrderedList().add(order);

            // prepare response dto
            OrderedResponseDto orderResponseDto = OrderedResponseDto.builder()
                    .productName(item.getProduct().getProductName())
                    .orderDate(order.getOrderDate())
                    .quantityOrdered(item.getRequiredQuantity())
                    .cardUsedForPayment(cardNo)
                    .itemPrice(item.getProduct().getPrice())
                    .totalCost(order.getTotal())
                    .deliveryCharge(0)
                    .build();

            orderResponseDtos.add(orderResponseDto);
        }

        cart.setItemList(new ArrayList<>());
        cart.setCartTotal(0);
        customerRepository.save(customer);

        String text = "Congrats your order with total value "+totalCost+" has been placed";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("backendavengers@gmail.com");
        message.setTo(customer.getEmail());
        message.setSubject("Order Placed from China Market");
        message.setText(text);
        emailSender.send(message);

       return orderResponseDtos;
    }
}



