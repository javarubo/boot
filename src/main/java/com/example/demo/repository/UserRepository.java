package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User getById(long id);

    User getByUsernameAndPassword(String username, String password);



    void delete(User user);

    // User getByUsername(String username) ;

    Boolean existsByUsername(String username);



    @Query(nativeQuery = true, value = "select *from user where username=:paramUser  ")
    User getByUsername(@Param("paramUser") String username);


}

