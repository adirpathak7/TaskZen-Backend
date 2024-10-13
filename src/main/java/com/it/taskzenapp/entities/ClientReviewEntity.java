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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Aditya Pathak R
 */
@Entity
@Table(name = "client_review_tbl")
public class ClientReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int client_review_id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private ClientMasterEntity clientMasterEntity;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private CompanyMasterEntity companyMasterEntity;

    private String comment;
    private int rating;
    private LocalDateTime createdAt;

    public ClientReviewEntity() {
    }

    public ClientReviewEntity(int client_review_id, ClientMasterEntity clientMasterEntity, CompanyMasterEntity companyMasterEntity, String comment, int rating, LocalDateTime createdAt) {
        this.client_review_id = client_review_id;
        this.clientMasterEntity = clientMasterEntity;
        this.companyMasterEntity = companyMasterEntity;
        this.comment = comment;
        this.rating = rating;
        this.createdAt = createdAt;
    }

    public int getClient_review_id() {
        return client_review_id;
    }

    public void setClient_review_id(int client_review_id) {
        this.client_review_id = client_review_id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
