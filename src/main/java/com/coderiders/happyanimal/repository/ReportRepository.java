package com.coderiders.happyanimal.repository;

import com.coderiders.happyanimal.model.Report;
import com.coderiders.happyanimal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long>{
    Optional<Report> findById(Long id);

    List<Report> findByDate(String tag);

    List<Report> findByUserName(String userName);

    List<Report> findAll();

    List<Report> findAllByUser(User User);
}
