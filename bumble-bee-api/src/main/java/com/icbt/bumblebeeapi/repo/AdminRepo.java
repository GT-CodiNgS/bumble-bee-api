package com.icbt.bumblebeeapi.repo;

import com.icbt.bumblebeeapi.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 4/3/2023
 */
@Repository
@EnableJpaRepositories
public interface AdminRepo extends JpaRepository<Admin, Integer> {
        Boolean existsAdminByUsernameAndPassword(String username,String password);
}
