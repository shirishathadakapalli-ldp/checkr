package com.example.checkr.serviceImpl;

import com.example.checkr.DTO.CandidateDto;
import com.example.checkr.DTO.ReportInformationDto;
import com.example.checkr.entity.Candidate;
import com.example.checkr.entity.ReportInformation;
import com.example.checkr.repository.CandidateRepo;
import com.example.checkr.repository.ReportInformationRepo;
import com.example.checkr.service.ReportInformationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportInformationImpl implements ReportInformationService {
    @Autowired
    private  ModelMapper modelMapper;
    @Autowired
    private ReportInformationRepo reportInformationRepo;
    @Autowired
    private CandidateRepo candidateRepo;
    @Override
    public ReportInformationDto saveReportInformation(long candidateId, ReportInformationDto reportInformationDto)
    {
        Candidate candidate=candidateRepo.findById(candidateId).get();
        ReportInformation reportInformation=modelMapper.map(reportInformationDto, ReportInformation.class);
        reportInformation.setCandidate(candidate);
        ReportInformation savedreportInformation=reportInformationRepo.save(reportInformation);
        return modelMapper.map(savedreportInformation,ReportInformationDto.class);
    }

    @Override
    public ReportInformationDto updateCandidatePreAdverseActionEngage(long candidateId, ReportInformationDto reportInformationDto) {
        ReportInformation convertedReportInformation = modelMapper.map(reportInformationDto, ReportInformation.class);
        Optional<ReportInformation> reportInformation = Optional.ofNullable(reportInformationRepo.findReportInformationByCandidateId(candidateId));
        if (reportInformation.isPresent()) {
            reportInformation.get().setReportStatus(convertedReportInformation.getReportStatus());
            reportInformation.get().setReportAdjudication(convertedReportInformation.getReportAdjudication());
            reportInformationRepo.save(reportInformation.get());
        }
        return modelMapper.map(reportInformation, ReportInformationDto.class);
    }


}
