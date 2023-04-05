package com.icbt.bumblebeeapi.repo;

import com.icbt.bumblebeeapi.entity.Product;
import com.icbt.bumblebeeapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/17/2023
 */
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    List<Product> findByName(String name);

    @Query(value = "SELECT * FROM product", nativeQuery = true)
    List<Product> findAll();
}
