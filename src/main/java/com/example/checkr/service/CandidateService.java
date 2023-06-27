package com.example.checkr.service;

import com.example.checkr.DTO.CandidateDto;
import com.example.checkr.entity.Candidate;

import java.util.List;

public interface CandidateService {
    CandidateDto saveCandidate(CandidateDto candidateDto);
    List<CandidateDto> getAllCandidates();

    CandidateDto getCandidateById(long candidateId);
    CandidateDto updateCandidate(long candidateId,CandidateDto candidateDto);
    void deleteCandidateById(long candidateId);
}
