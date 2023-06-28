package com.example.checkr.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="candidate")
public class Candidate
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
