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
@Table(name = "client_experience_tbl")
public class ClientExperienceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int client_experience_id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private ClientMasterEntity clientMasterEntity;

    private String company_name;
    private String designation;
    private String starting_date;
    private LocalDateTime ending_date;
    private LocalDateTime createdAt;

    public ClientExperienceEntity() {
    }

    public ClientExperienceEntity(int client_experience_id, ClientMasterEntity clientMasterEntity, String company_name, String designation, String starting_date, LocalDateTime ending_date, LocalDateTime createdAt) {
        this.client_experience_id = client_experience_id;
        this.clientMasterEntity = clientMasterEntity;
        this.company_name = company_name;
        this.designation = designation;
        this.starting_date = starting_date;
        this.ending_date = ending_date;
        this.createdAt = createdAt;
    }

    public int getClient_experience_id() {
        return client_experience_id;
    }

    public void setClient_experience_id(int client_experience_id) {
        this.client_experience_id = client_experience_id;
    }

    public ClientMasterEntity getClientMasterEntity() {
        return clientMasterEntity;
    }

    public void setClientMasterEntity(ClientMasterEntity clientMasterEntity) {
        this.clientMasterEntity = clientMasterEntity;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getStarting_date() {
        return starting_date;
    }

    public void setStarting_date(String starting_date) {
        this.starting_date = starting_date;
    }

    public LocalDateTime getEnding_date() {
        return ending_date;
    }

    public void setEnding_date(LocalDateTime ending_date) {
        this.ending_date = ending_date;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
