package com.castedodev.mymoneycheckback.operation.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, String> {

    List<Operation> findByUserId(String userID);

    @Query(value = "SELECT * FROM operations WHERE date >= :from AND date <= :to AND user_id = :userId", nativeQuery = true)
    List<Operation> getAllBetweenDates(@Param("from") LocalDate from, @Param("to") LocalDate to, @Param("userId") String userId);
}
