package com.example.checkr.controller;

import com.example.checkr.DTO.CandidateDto;
import com.example.checkr.DTO.ReportInformationDto;
import com.example.checkr.service.ReportInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ReportInformationController {
    @Autowired
    private ReportInformationService reportInformationService;
    @PostMapping("/candidates/{candidateId}/reportInformation")
    public ResponseEntity<ReportInformationDto> saveCandidate(@PathVariable long candidateId,@RequestBody ReportInformationDto reportInformationDto)
    {
        return new ResponseEntity<>(reportInformationService.saveReportInformation(candidateId,reportInformationDto), HttpStatus.CREATED);
    }

    @PutMapping("/candidates/preadverseaction/{candidateId}/")
    public ResponseEntity<ReportInformationDto> UpdateCandidatePreAdverseAction(@PathVariable long candidateId, @RequestBody ReportInformationDto reportInformationDto)
    {
        return new ResponseEntity<>(reportInformationService.updateCandidatePreAdverseActionEngage(candidateId,reportInformationDto), HttpStatus.OK);
    }
    @PutMapping("/candidates/engage/{candidateId}/")
    public ResponseEntity<ReportInformationDto> UpdateCandidateEngage(@PathVariable long candidateId,@RequestBody ReportInformationDto reportInformationDto)
    {
        return new ResponseEntity<>(reportInformationService.updateCandidatePreAdverseActionEngage(candidateId,reportInformationDto), HttpStatus.OK);
    }
}
