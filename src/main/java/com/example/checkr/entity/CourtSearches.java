package com.example.checkr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CourtSearches
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String courtSearchSearch;
    private String courtSearchStatus;
    private Timestamp courtSearchDate;

}
