package com.example.checkr.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class ReportInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String reportStatus;
    private String reportAdjudication;
    private String reportPackage;
    private Timestamp reportCreatedDate;
    private Timestamp reportCompletedDate;
    private String reportTurnAroundTime;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="candidate_id")
    private Candidate candidate;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    public String getReportAdjudication() {
        return reportAdjudication;
    }

    public void setReportAdjudication(String reportAdjudication) {
        this.reportAdjudication = reportAdjudication;
    }

    public String getReportPackage() {
        return reportPackage;
    }

    public void setReportPackage(String reportPackage) {
        this.reportPackage = reportPackage;
    }

    public Timestamp getReportCreatedDate() {
        return reportCreatedDate;
    }

    public void setReportCreatedDate(Timestamp reportCreatedDate) {
        this.reportCreatedDate = reportCreatedDate;
    }

    public Timestamp getReportCompletedDate() {
        return reportCompletedDate;
    }

    public void setReportCompletedDate(Timestamp reportCompletedDate) {
        this.reportCompletedDate = reportCompletedDate;
    }

    public String getReportTurnAroundTime() {
        return reportTurnAroundTime;
    }

    public void setReportTurnAroundTime(String reportTurnAroundTime) {
        this.reportTurnAroundTime = reportTurnAroundTime;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public ReportInformation(long id, String reportStatus, String reportAdjudication, String reportPackage, Timestamp reportCreatedDate, Timestamp reportCompletedDate, String reportTurnAroundTime) {
        this.id = id;
        this.reportStatus = reportStatus;
        this.reportAdjudication = reportAdjudication;
        this.reportPackage = reportPackage;
        this.reportCreatedDate = reportCreatedDate;
        this.reportCompletedDate = reportCompletedDate;
        this.reportTurnAroundTime = reportTurnAroundTime;
    }

    public ReportInformation() {
        super();
    }

    @Override
    public String toString() {
        return "ReportInformation{" +
                "id=" + id +
                ", reportStatus='" + reportStatus + '\'' +
                ", reportAdjudication='" + reportAdjudication + '\'' +
                ", reportPackage='" + reportPackage + '\'' +
                ", reportCreatedDate=" + reportCreatedDate +
                ", reportCompletedDate=" + reportCompletedDate +
                ", reportTurnAroundTime='" + reportTurnAroundTime + '\'' +
                '}';
    }
}
