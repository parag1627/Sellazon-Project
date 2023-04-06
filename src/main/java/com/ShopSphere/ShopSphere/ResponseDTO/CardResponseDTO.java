package com.ShopSphere.ShopSphere.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardResponseDTO {
     private String name;
     private List<CardDto> cardDto;



}
