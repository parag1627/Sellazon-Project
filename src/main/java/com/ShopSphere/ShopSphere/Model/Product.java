package com.ShopSphere.ShopSphere.Model;

import com.ShopSphere.ShopSphere.Enum.ProductCategory;
import com.ShopSphere.ShopSphere.Enum.ProductStatus;
import jdk.jfr.Category;
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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String productName;
    private int price;

    private int quantity;

    @Enumerated(EnumType.STRING)
    ProductCategory productCategory;

@Enumerated(EnumType.STRING)
ProductStatus productStatus;

    @ManyToOne
    @JoinColumn
    Seller seller;

    @OneToOne(mappedBy = "product" ,cascade = CascadeType.ALL)
    Item item;
}
