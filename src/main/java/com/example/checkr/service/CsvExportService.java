package com.example.checkr.service;

import com.example.checkr.entity.Candidate;
import com.example.checkr.repository.CandidateRepo;
import com.example.checkr.repository.ReportInformationRepo;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Service
public class CsvExportService {

    private final CandidateRepo candidateRepo;
    private final ReportInformationRepo reportInformationRepo;

    public CsvExportService(CandidateRepo candidateRepo, ReportInformationRepo reportInformationRepo) {
        this.candidateRepo = candidateRepo;
        this.reportInformationRepo = reportInformationRepo;
    }

    public void writeCandidatesToCsv(PrintWriter writer) {
        List<Candidate> candidates=candidateRepo.findAll();
        try(CSVPrinter csvPrinter=new CSVPrinter(writer, CSVFormat.DEFAULT))
        {
            csvPrinter.printRecord("ID","Name","Email","DOB","Location","Phone","Zipcode");
            for (Candidate candidate: candidates)
            {
                csvPrinter.printRecord(candidate.getId(),candidate.getCandidateName(),candidate.getCandidateEmail(),
                        candidate.getCandidateDob(),candidate.getCandidateLocation(),candidate.getCandidatePhone(),candidate.getCandidateZipcode());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
