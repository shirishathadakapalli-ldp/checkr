package com.example.checkr.controller;

import com.example.checkr.DTO.CandidateDto;
import com.example.checkr.entity.Candidate;
import com.example.checkr.repository.CandidateRepo;
import com.example.checkr.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;
    @Autowired
    private CandidateRepo candidateRepo;
    @PostMapping("/candidates")
    public ResponseEntity<CandidateDto> saveCandidate(@RequestBody CandidateDto candidateDto)
    {
        return new ResponseEntity<>(candidateService.saveCandidate(candidateDto), HttpStatus.CREATED);
    }

    @GetMapping("/candidates")
    public ResponseEntity<List<CandidateDto>> getCandidatesList()
    {
        return new ResponseEntity<>(candidateService.getAllCandidates(),HttpStatus.OK);
    }
    @GetMapping("/candidates/{candidateId}")
    public ResponseEntity<CandidateDto> getCandidateById(@PathVariable long candidateId)
    {
        return new ResponseEntity<>(candidateService.getCandidateById(candidateId), HttpStatus.OK);
    }
    @PutMapping("/candidates/{candidateId}")
    public ResponseEntity<CandidateDto> UpdateCandidateDetailsById(@PathVariable long candidateId,@RequestBody CandidateDto candidateDto)
    {
       return new ResponseEntity<>(candidateService.updateCandidate(candidateId,candidateDto), HttpStatus.OK);
    }

    @DeleteMapping("/candidates/{candidateId}")
    public ResponseEntity<String> deleteCandidateDetailsById(@PathVariable long candidateId)
    {
            candidateService.deleteCandidateById(candidateId);
            return new ResponseEntity<>("Candidate Deleted Successfully",HttpStatus.OK);
    }
}
