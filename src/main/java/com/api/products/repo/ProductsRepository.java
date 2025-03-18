package com.api.products.repo;

import com.api.products.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<ProductsEntity, Long>{
}
