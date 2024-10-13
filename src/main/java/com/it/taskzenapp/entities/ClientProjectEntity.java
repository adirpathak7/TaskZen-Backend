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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Aditya Pathak R
 */
@Entity
@Table(name = "client_project_tbl")
public class ClientProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int client_project_id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private ClientMasterEntity clientMasterEntity;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private CompanyMasterEntity companyMasterEntity;

    private String client_project_name;
    private String details;
    private String project_link;
    private String client_project_github_link;
    private String client_project_linkedin_link;
    private LocalDateTime createdAt;

    public ClientProjectEntity() {
    }

    public ClientProjectEntity(int client_project_id, ClientMasterEntity clientMasterEntity, CompanyMasterEntity companyMasterEntity, String client_project_name, String details, String project_link, String client_project_github_link, String client_project_linkedin_link, LocalDateTime createdAt) {
        this.client_project_id = client_project_id;
        this.clientMasterEntity = clientMasterEntity;
        this.companyMasterEntity = companyMasterEntity;
        this.client_project_name = client_project_name;
        this.details = details;
        this.project_link = project_link;
        this.client_project_github_link = client_project_github_link;
        this.client_project_linkedin_link = client_project_linkedin_link;
        this.createdAt = createdAt;
    }

    public int getClient_project_id() {
        return client_project_id;
    }

    public void setClient_project_id(int client_project_id) {
        this.client_project_id = client_project_id;
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

    public String getClient_project_name() {
        return client_project_name;
    }

    public void setClient_project_name(String client_project_name) {
        this.client_project_name = client_project_name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getProject_link() {
        return project_link;
    }

    public void setProject_link(String project_link) {
        this.project_link = project_link;
    }

    public String getClient_project_github_link() {
        return client_project_github_link;
    }

    public void setClient_project_github_link(String client_project_github_link) {
        this.client_project_github_link = client_project_github_link;
    }

    public String getClient_project_linkedin_link() {
        return client_project_linkedin_link;
    }

    public void setClient_project_linkedin_link(String client_project_linkedin_link) {
        this.client_project_linkedin_link = client_project_linkedin_link;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
