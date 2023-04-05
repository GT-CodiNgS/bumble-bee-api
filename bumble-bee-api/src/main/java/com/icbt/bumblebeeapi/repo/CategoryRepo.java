package com.icbt.bumblebeeapi.repo;

import com.icbt.bumblebeeapi.entity.Category;
import com.icbt.bumblebeeapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/17/2023
 */
@Repository
@EnableJpaRepositories
public interface CategoryRepo extends JpaRepository<Category, Integer> {

    List<Category> findByName(String name);
}
