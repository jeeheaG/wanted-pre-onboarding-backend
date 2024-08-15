package com.ginger.myjobserver2024.domain.job.repository;

import com.ginger.myjobserver2024.domain.job.domain.Job;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    Slice<Job> findAllByOrderByCreatedAtDesc(Pageable pageable);

}
