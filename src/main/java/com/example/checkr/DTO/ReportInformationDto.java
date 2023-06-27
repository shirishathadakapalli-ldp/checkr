package com.example.checkr.DTO;

import java.sql.Timestamp;

public class ReportInformationDto {
    private long id;
    private String reportStatus;
    private String reportAdjudication;
    private String reportPackage;
    private Timestamp reportCreatedDate;
    private Timestamp reportCompletedDate;
    private String reportTurnAroundTime;

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
}
