package com.example.checkr.repository;

import com.example.checkr.entity.ReportInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportInformationRepo extends JpaRepository<ReportInformation,Long> {
}
