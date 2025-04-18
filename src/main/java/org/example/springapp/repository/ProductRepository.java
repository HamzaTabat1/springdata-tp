package org.example.springapp.repository;

import org.example.springapp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.name like :x")
    List<Product> findByNameContains(@Param("x")String mc);

    /*List<Product> search(String mc);*/

    List<Product> findByPriceGreaterThan(double price);

    @Query("select p from Product p where p.price >:x")
    List<Product> searchByPrice(@Param("x")double price);
}
