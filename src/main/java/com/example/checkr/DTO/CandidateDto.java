package com.example.checkr.DTO;

import java.sql.Timestamp;
import java.util.Date;

public class CandidateDto {
    private long id;
    private String candidateName;
    private String candidateEmail;
    private Date candidateDob ;
    private String candidatePhone ;
    private String candidateZipcode;
    private String candidateSocialSecurity;
    private String candidateDriversLicence;
    private String candidateLocation;
    private Timestamp candidateCreatedDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateEmail() {
        return candidateEmail;
    }

    public void setCandidateEmail(String candidateEmail) {
        this.candidateEmail = candidateEmail;
    }

    public Date getCandidateDob() {
        return candidateDob;
    }

    public void setCandidateDob(Date candidateDob) {
        this.candidateDob = candidateDob;
    }

    public String getCandidatePhone() {
        return candidatePhone;
    }

    public void setCandidatePhone(String candidatePhone) {
        this.candidatePhone = candidatePhone;
    }

    public String getCandidateZipcode() {
        return candidateZipcode;
    }

    public void setCandidateZipcode(String candidateZipcode) {
        this.candidateZipcode = candidateZipcode;
    }

    public String getCandidateSocialSecurity() {
        return candidateSocialSecurity;
    }

    public void setCandidateSocialSecurity(String candidateSocialSecurity) {
        this.candidateSocialSecurity = candidateSocialSecurity;
    }

    public String getCandidateDriversLicence() {
        return candidateDriversLicence;
    }

    public void setCandidateDriversLicence(String candidateDriversLicence) {
        this.candidateDriversLicence = candidateDriversLicence;
    }

    public String getCandidateLocation() {
        return candidateLocation;
    }

    public void setCandidateLocation(String candidateLocation) {
        this.candidateLocation = candidateLocation;
    }

    public Timestamp getCandidateCreatedDate() {
        return candidateCreatedDate;
    }

    public void setCandidateCreatedDate(Timestamp candidateCreatedDate) {
        this.candidateCreatedDate = candidateCreatedDate;
    }
}
