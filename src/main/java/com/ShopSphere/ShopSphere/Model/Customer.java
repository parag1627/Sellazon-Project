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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private int age;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String mobNo;

   @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<Card> cardList = new ArrayList<>();

   @OneToOne(mappedBy = "customer" ,cascade = CascadeType.ALL)
    Cart cart;

   @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
    List<Ordered> orderedList= new ArrayList<>();

}
