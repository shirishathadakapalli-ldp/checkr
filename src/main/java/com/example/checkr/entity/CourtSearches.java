package com.example.checkr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class CourtSearches
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String courtSearchSearch;
    private String courtSearchStatus;
    private Timestamp courtSearchDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourtSearchSearch() {
        return courtSearchSearch;
    }

    public void setCourtSearchSearch(String courtSearchSearch) {
        this.courtSearchSearch = courtSearchSearch;
    }

    public String getCourtSearchStatus() {
        return courtSearchStatus;
    }

    public void setCourtSearchStatus(String courtSearchStatus) {
        this.courtSearchStatus = courtSearchStatus;
    }

    public Timestamp getCourtSearchDate() {
        return courtSearchDate;
    }

    public void setCourtSearchDate(Timestamp courtSearchDate) {
        this.courtSearchDate = courtSearchDate;
    }

    public CourtSearches(long id, String courtSearchSearch, String courtSearchStatus, Timestamp courtSearchDate) {
        this.id = id;
        this.courtSearchSearch = courtSearchSearch;
        this.courtSearchStatus = courtSearchStatus;
        this.courtSearchDate = courtSearchDate;
    }

    public CourtSearches() {
        super();
    }

    @Override
    public String toString() {
        return "CourtSearches{" +
                "id=" + id +
                ", courtSearchSearch='" + courtSearchSearch + '\'' +
                ", courtSearchStatus='" + courtSearchStatus + '\'' +
                ", courtSearchDate=" + courtSearchDate +
                '}';
    }
}
