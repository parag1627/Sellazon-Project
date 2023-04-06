package com.ShopSphere.ShopSphere.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RequestToFindAllSeller {

    private  int sellerId;
}
