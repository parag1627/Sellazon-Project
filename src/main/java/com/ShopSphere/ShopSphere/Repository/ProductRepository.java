package com.ShopSphere.ShopSphere.Repository;

import com.ShopSphere.ShopSphere.Enum.ProductCategory;
import com.ShopSphere.ShopSphere.Model.Product;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findAllByProductCategory(ProductCategory productCategory);
}
