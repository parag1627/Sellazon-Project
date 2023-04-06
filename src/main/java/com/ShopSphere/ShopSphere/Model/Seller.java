package com.ShopSphere.ShopSphere.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String name;
    private int age;

    @Column(unique = true)
    private String mobNo;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String panCard;

    @OneToMany(mappedBy = "seller" ,cascade = CascadeType.ALL)
    List<Product> productList = new ArrayList<>();

}
