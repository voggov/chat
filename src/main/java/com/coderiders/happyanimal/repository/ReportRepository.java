package com.coderiders.happyanimal.repository;

import com.coderiders.happyanimal.model.Report;
import com.coderiders.happyanimal.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    Optional<Report> findById(Long id);

    Page<Report> findByDate(String tag, Pageable pageable);
    Page<Report> findByUserName(String userName, Pageable pageable);
    Page<Report> findAll(Pageable pageable);
    Page<Report> findAllByUser(User User, Pageable pageable);
}
