package com.example.checkr.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ReportInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String reportStatus;
    private String reportAdjudication;
    private String reportPackage;
    private Timestamp reportCreatedDate;
    private Timestamp reportCompletedDate;
    private String reportTurnAroundTime;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

}
