/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.it.taskzenapp.entities;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Aditya Pathak R
 */
@Entity
@Table(name = "bid_tbl")
public class BidEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bid_id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private ClientMasterEntity clientMasterEntity;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private CompanyMasterEntity companyMasterEntity;

    @ManyToOne
    @JoinColumn(name = "company_post_id", referencedColumnName = "company_post_id")
    private CompanyPostEntity companyPostEntity;

    private String bid_amount;
    private String proposal;

    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime created_at;

    public BidEntity() {
    }

    public BidEntity(int bid_id, ClientMasterEntity clientMasterEntity, CompanyMasterEntity companyMasterEntity, String bid_amount, String proposal, Status status, LocalDateTime created_at) {
        this.bid_id = bid_id;
        this.clientMasterEntity = clientMasterEntity;
        this.companyMasterEntity = companyMasterEntity;
        this.bid_amount = bid_amount;
        this.proposal = proposal;
        this.status = status;
        this.created_at = created_at;
    }

    public int getBid_id() {
        return bid_id;
    }

    public void setBid_id(int bid_id) {
        this.bid_id = bid_id;
    }

    public ClientMasterEntity getClientMasterEntity() {
        return clientMasterEntity;
    }

    public void setClientMasterEntity(ClientMasterEntity clientMasterEntity) {
        this.clientMasterEntity = clientMasterEntity;
    }

    public CompanyMasterEntity getCompanyMasterEntity() {
        return companyMasterEntity;
    }

    public void setCompanyMasterEntity(CompanyMasterEntity companyMasterEntity) {
        this.companyMasterEntity = companyMasterEntity;
    }

    public String getBid_amount() {
        return bid_amount;
    }

    public void setBid_amount(String bid_amount) {
        this.bid_amount = bid_amount;
    }

    public String getProposal() {
        return proposal;
    }

    public void setProposal(String proposal) {
        this.proposal = proposal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public enum Status {
        submitted("submitted"), accepted("accepted"), rejected("rejected");

        private final String value;

        Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
