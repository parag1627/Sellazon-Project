package com.ShopSphere.ShopSphere.Model;

import com.ShopSphere.ShopSphere.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String cardNo;

    private int cvv;

    @Enumerated(EnumType.STRING)
     CardType cardType;

    @ManyToOne
    @JoinColumn
    Customer customer;
}
