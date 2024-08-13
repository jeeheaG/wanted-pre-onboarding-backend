package com.ginger.myjobserver2024.domain.domain.job.repository;

import com.ginger.myjobserver2024.domain.domain.job.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

}
