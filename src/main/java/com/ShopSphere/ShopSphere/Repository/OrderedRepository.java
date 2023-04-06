package com.ShopSphere.ShopSphere.Repository;

import com.ShopSphere.ShopSphere.Model.Ordered;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedRepository extends JpaRepository<Ordered,Integer> {
}
