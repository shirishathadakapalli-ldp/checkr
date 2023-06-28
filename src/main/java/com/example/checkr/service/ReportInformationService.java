package com.example.checkr.service;

import com.example.checkr.DTO.CandidateDto;
import com.example.checkr.DTO.ReportInformationDto;
import org.springframework.stereotype.Service;

@Service
public interface ReportInformationService {
    public ReportInformationDto saveReportInformation(long candidateId, ReportInformationDto reportInformationDto);

    ReportInformationDto updateCandidatePreAdverseActionEngage(long candidateId, ReportInformationDto reportInformationDto);
}
