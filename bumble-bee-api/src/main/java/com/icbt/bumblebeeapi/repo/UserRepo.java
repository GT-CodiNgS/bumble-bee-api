package com.icbt.bumblebeeapi.repo;
/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/2/2023
 */

import com.icbt.bumblebeeapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    boolean existsByNicNumber(String nicNumber);

    @Query(value = "SELECT * FROM USER WHERE id LIKE ?%\n" +
            "AND is_deleted=0", nativeQuery = true)
    List<User> findByIdLike(int value);

    @Query(value = "SELECT * FROM USER WHERE user_name LIKE %?%\n" +
            "AND is_deleted=0", nativeQuery = true)
    List<User> findByNameLike(String value);

    @Query(value = "SELECT * FROM USER WHERE address LIKE %?%\n" +
            "AND is_deleted=0", nativeQuery = true)
    List<User> findByAddressContaining(String value);

    @Query(value = "SELECT * FROM USER WHERE email LIKE %?%\n" +
            "AND is_deleted=0", nativeQuery = true)
    List<User> findByEmailLike(String value);

    @Query(value = "SELECT * FROM USER WHERE nic_number LIKE ?%\n" +
            "AND is_deleted=0", nativeQuery = true)
    List<User> findByNiclLike(String value);

    @Query(value = "SELECT * FROM USER WHERE is_deleted=?", nativeQuery = true)
    List<User> findByIsDeleted(int value);

    @Query(value = "SELECT * FROM USER WHERE amount LIKE ?%\n" +
            "AND is_deleted=0", nativeQuery = true)
    List<User> findByAmount(double value);


    @Query(value = "SELECT * FROM USER WHERE user_name LIKE %?%\n" +
            "OR email LIKE %?%\n" +
            "OR first_name LIKE %?%\n" +
            "OR last_name LIKE %?%\n" +
            "AND is_deleted=0"
            , nativeQuery = true)
    List<User> findByAny(String user_name, String email, String first_name, String last_name);

    @Query("SELECT u FROM User u WHERE u.verificationCode = ?1")
    public User findByVerificationCode(String code);

}
