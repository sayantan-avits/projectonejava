package com.example.projectone.repositories;

import com.example.projectone.model.BkTimeLogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface BkTimeLogRepository extends JpaRepository<BkTimeLogModel, Long> {


//    @Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)
//    User findByEmailAddress(String emailAddress);

//    //@Query(value = "SELECT o FROM bk_time_log o WHERE o.created_at BETWEEN :fromDateTime AND :toDateTime", nativeQuery = true)
    @Query(value = "SELECT * FROM bk_time_log  WHERE created_at >= ?1 AND created_at <= ?2", nativeQuery=true)
    List<BkTimeLogModel> findByDateRange( Date fromDateTime, Date toDateTime);

//    @Query(value = "SELECT o FROM bk_time_log o WHERE o.created_at BETWEEN ?1 AND ?2 ")
//    List<BkTimeLogModel> findByDateRange(Date fromDateTime,
//                                         Date toDateTime);
}
