package com.example.checkr.controller;

import com.example.checkr.util.APIResponse;
import com.example.checkr.DTO.CandidateDto;
import com.example.checkr.repository.CandidateRepo;
import com.example.checkr.service.CandidateService;
import com.example.checkr.service.CsvExportService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;
    @Autowired
    private CandidateRepo candidateRepo;

    private final CsvExportService csvExportService;

    public CandidateController(CsvExportService csvExportService) {
        this.csvExportService = csvExportService;
    }


    @PostMapping("/candidates")
    public ResponseEntity<CandidateDto> saveCandidate(@RequestBody CandidateDto candidateDto)
    {
        return new ResponseEntity<>(candidateService.saveCandidate(candidateDto), HttpStatus.CREATED);
    }

    @GetMapping("/candidates")
    public APIResponse<List<CandidateDto>> getCandidates()
    {
        return new APIResponse<>(candidateService.getAllCandidates().size(),candidateService.getAllCandidates());
    }
    @GetMapping("/candidates/{candidateId}")
    public ResponseEntity<CandidateDto> getCandidate(@PathVariable long candidateId)
    {
        return new ResponseEntity<>(candidateService.getCandidateById(candidateId), HttpStatus.OK);
    }
    @PutMapping("/candidates/{candidateId}")
    public ResponseEntity<CandidateDto> UpdateCandidate(@PathVariable long candidateId,@RequestBody CandidateDto candidateDto)
    {
       return new ResponseEntity<>(candidateService.updateCandidate(candidateId,candidateDto), HttpStatus.OK);
    }

    @GetMapping("/candidates/search")
    public ResponseEntity<List<CandidateDto>> searchCandidates(@RequestParam("query") String query)
    {
        return new ResponseEntity<>(candidateService.searchCandidates(query),HttpStatus.OK);
    }

    @GetMapping("/candidates/pagination/{offset}/{pageSize}")
    public APIResponse<Page<CandidateDto>> getCandidates(@PathVariable int offset,@PathVariable int pageSize)
    {
        Page<CandidateDto> candidatesWithPagination=candidateService.getCandidatesWithPagination(offset,pageSize);
        return new APIResponse<>(candidatesWithPagination.getSize(),candidatesWithPagination);
    }
    @GetMapping("/candidates/export")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.addHeader("Content-Disposition","attachment;filename=\"candidates.csv\"");
        csvExportService.writeCandidatesToCsv(response.getWriter());

    }

    @DeleteMapping("/candidates/{candidateId}")
    public ResponseEntity<String> deleteCandidateDetailsById(@PathVariable long candidateId)
    {
            candidateService.deleteCandidateById(candidateId);
            return new ResponseEntity<>("Candidate Deleted Successfully",HttpStatus.OK);
    }
}
