package com.coderiders.happyanimal.repository;

import com.coderiders.happyanimal.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long>, CrudRepository<Report, Long> {
    Optional<Report> findFirstById(Long id);

    List<Report> findByDate(String tag);

    List<Report> findByUserName(String userName);

    List<Report> findAll();
}
