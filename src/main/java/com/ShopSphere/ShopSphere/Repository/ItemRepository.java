package com.ShopSphere.ShopSphere.Repository;

import com.ShopSphere.ShopSphere.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {

}
