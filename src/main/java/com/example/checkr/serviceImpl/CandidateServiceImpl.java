package com.example.checkr.serviceImpl;

import com.example.checkr.DTO.CandidateDto;
import com.example.checkr.entity.Candidate;
import com.example.checkr.exception.CandidateNotFound;
import com.example.checkr.repository.CandidateRepo;
import com.example.checkr.service.CandidateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidateServiceImpl implements CandidateService {

    //to convert entity to dto and dto to entity
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CandidateRepo candidateRepo;
    @Override
    public CandidateDto saveCandidate(CandidateDto candidateDto)
    {
        Candidate candidate=modelMapper.map(candidateDto,Candidate.class);
        Candidate savedCandidate= candidateRepo.save(candidate);
        return modelMapper.map(savedCandidate,CandidateDto.class);
    }

    @Override
    public List<CandidateDto> getAllCandidates() {
        List<Candidate> candidateList=candidateRepo.findAll();
        return candidateList.stream().map(candidate->modelMapper.map(candidate,CandidateDto.class)).
                collect(Collectors.toList());
    }

    @Override
    public CandidateDto getCandidateById(long candidateId) {
        Candidate candidate=candidateRepo.findById(candidateId).orElseThrow(
                ()-> new CandidateNotFound(String.format("Candidate Id %d Not Found",candidateId))
        );
        return modelMapper.map(candidate,CandidateDto.class);
    }

    @Override
    public CandidateDto updateCandidate(long candidateId, CandidateDto candidateDto) {
        Candidate convertedCandidate = modelMapper.map(candidateDto, Candidate.class);
        Optional<Candidate> candidate = candidateRepo.findById(candidateId);
        if (candidate.isPresent()) {
            candidate.get().setCandidateEmail(convertedCandidate.getCandidateEmail());
            candidate.get().setCandidatePhone(convertedCandidate.getCandidatePhone());
            candidate.get().setCandidateDob(convertedCandidate.getCandidateDob());
            candidate.get().setCandidateName(convertedCandidate.getCandidateName());
            candidate.get().setCandidateLocation(convertedCandidate.getCandidateLocation());
            candidate.get().setCandidateZipcode(convertedCandidate.getCandidateZipcode());
            candidate.get().setCandidateDriversLicence(convertedCandidate.getCandidateDriversLicence());
            candidate.get().setCandidateSocialSecurity(convertedCandidate.getCandidateSocialSecurity());
            candidateRepo.save(candidate.get());
        }
        return modelMapper.map(candidate, CandidateDto.class);
    }

    @Override
    public List<CandidateDto> searchCandidates(String query) {
        List<Candidate> candidateList=candidateRepo.searchCandidates(query);
        return candidateList.stream().map(candidate->modelMapper.map(candidate,CandidateDto.class)).
                collect(Collectors.toList());
    }

    @Override
    public Page<CandidateDto> getCandidatesWithPagination(int offset, int pageSize) {
        Page<Candidate> candidates= candidateRepo.findAll(PageRequest.of(offset,pageSize));
        return candidates.map(candidate -> modelMapper.map(candidate,CandidateDto.class));
    }

    @Override
    public void deleteCandidateById(long candidateId) {
        Optional<Candidate> candidate=candidateRepo.findById(candidateId);
        if(candidate.isPresent()) {
            candidateRepo.deleteById(candidateId);
        }
    }

}
