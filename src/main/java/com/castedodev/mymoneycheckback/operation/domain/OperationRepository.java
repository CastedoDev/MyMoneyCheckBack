package com.castedodev.mymoneycheckback.operation.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface OperationRepository extends JpaRepository<Operation, String> {

    @Query(value = "SELECT * FROM operations WHERE date >= :from AND date <= :to AND user_id = :userId", nativeQuery = true)
    Page<Operation> getAllBetweenDates(@Param("from") LocalDate from, @Param("to") LocalDate to, @Param("userId") String userId, Pageable pageable);
}
