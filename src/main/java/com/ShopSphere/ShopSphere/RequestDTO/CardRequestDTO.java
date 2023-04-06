package com.ShopSphere.ShopSphere.RequestDTO;

import com.ShopSphere.ShopSphere.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardRequestDTO {

    private int customerId;
    private String cardNo;
    private int cvv;
    private CardType cardType;
}
