package com.example.checkr.repository;

import com.example.checkr.DTO.CandidateDto;
import com.example.checkr.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate,Long> {
    @Query(value = "select * from candidate where candidate_name LIKE CONCAT('%',:query,'%') or" +
            " candidate_email LIKE CONCAT('%',:query,'%') or " +
            "candidate_location LIKE CONCAT('%',:query,'%')",nativeQuery = true)
    List<Candidate> searchCandidates(String query);

}
