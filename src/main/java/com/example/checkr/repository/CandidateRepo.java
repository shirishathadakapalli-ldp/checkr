package com.example.checkr.repository;

import com.example.checkr.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepo extends JpaRepository<Candidate,Long> {
}
