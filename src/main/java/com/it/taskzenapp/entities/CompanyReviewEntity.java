/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.it.taskzenapp.entities;

import java.time.LocalDateTime;
import javax.persistence.Entity;
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
@Table(name = "company_review_id")
public class CompanyReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int client_review_id;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private CompanyMasterEntity companyMasterEntity;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private ClientMasterEntity clientMasterEntity;

    private String comment;
    private int rating;
    private LocalDateTime created_at;

    public CompanyReviewEntity() {
    }

    public CompanyReviewEntity(int client_review_id, CompanyMasterEntity companyMasterEntity, ClientMasterEntity clientMasterEntity, String comment, int rating, LocalDateTime created_at) {
        this.client_review_id = client_review_id;
        this.companyMasterEntity = companyMasterEntity;
        this.clientMasterEntity = clientMasterEntity;
        this.comment = comment;
        this.rating = rating;
        this.created_at = created_at;
    }

    public int getClient_review_id() {
        return client_review_id;
    }

    public void setClient_review_id(int client_review_id) {
        this.client_review_id = client_review_id;
    }

    public CompanyMasterEntity getCompanyMasterEntity() {
        return companyMasterEntity;
    }

    public void setCompanyMasterEntity(CompanyMasterEntity companyMasterEntity) {
        this.companyMasterEntity = companyMasterEntity;
    }

    public ClientMasterEntity getClientMasterEntity() {
        return clientMasterEntity;
    }

    public void setClientMasterEntity(ClientMasterEntity clientMasterEntity) {
        this.clientMasterEntity = clientMasterEntity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
