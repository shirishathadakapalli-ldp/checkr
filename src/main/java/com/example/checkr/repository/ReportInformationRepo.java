package com.example.checkr.repository;

import com.example.checkr.entity.ReportInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportInformationRepo extends JpaRepository<ReportInformation,Long> {
   @Query(value = "SELECT * FROM report_information WHERE candidate_id=:candidateId",nativeQuery = true)
    public  ReportInformation findReportInformationByCandidateId(long candidateId);
}
