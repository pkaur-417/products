package com.api.products.service;

import com.api.products.entity.ProductsEntity;
import com.api.products.repo.ProductsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    private final ProductsRepository repository;

    public ProductsService(ProductsRepository repository){
        this.repository = repository;
    }


    public ProductsEntity saveProducts(ProductsEntity products){
        return repository.save(products);
    }

   public List<ProductsEntity> findProducts()
   {
       return repository.findAll();
   }

   public Optional<ProductsEntity> getProductById(Long id)
   {
       return repository.findById(id);
   }


   public ProductsEntity updateProduct(Long id, ProductsEntity product)
   {
       if(repository.existsById(id))
       {
           return repository.save(product);
       }
       return null;
   }

   public void deleteProduct(Long id)
   {
       repository.deleteById(id);
   }


}
