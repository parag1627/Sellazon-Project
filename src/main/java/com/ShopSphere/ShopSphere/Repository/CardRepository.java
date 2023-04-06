package com.ShopSphere.ShopSphere.Repository;

import com.ShopSphere.ShopSphere.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
}
