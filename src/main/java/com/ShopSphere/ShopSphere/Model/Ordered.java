package com.ShopSphere.ShopSphere.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ordered {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    private Date orderDate;

    private int total;
    private String cardUsedForPayment;

    private int deliveryCharge;

    @ManyToOne
    @JoinColumn
    Customer customer;

    @OneToMany(mappedBy = "ordered" ,cascade = CascadeType.ALL)
    List<Item> OrderedItemList = new ArrayList<>();
}
