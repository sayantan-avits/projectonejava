package com.example.projectone.repositories;

import com.example.projectone.model.BkTimeLogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface IBkTimeRepository extends JpaRepository<BkTimeLogModel, Long> {


//    @Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)
//    User findByEmailAddress(String emailAddress);
}