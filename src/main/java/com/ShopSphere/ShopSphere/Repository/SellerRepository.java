package com.ShopSphere.ShopSphere.Repository;

import com.ShopSphere.ShopSphere.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {
//    @Query(value = "select * from seller s where s.age=:age",nativeQuery = true)
//    List<Seller> getAllSeller (int age);
    List<Seller> findByAge(int age);
}
