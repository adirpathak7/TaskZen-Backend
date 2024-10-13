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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Aditya Pathak R
 */
@Entity
@Table(name = "company_project_tbl")
public class CompanyProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int company_project_id;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private CompanyMasterEntity companyMasterEntity;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private ClientMasterEntity clientMasterEntity;

    private String company_project_name;
    private String details;
    private String project_picture;

    @ManyToOne
    @JoinColumn(name = "skill_id", referencedColumnName = "skill_id")

    private String duration;
    private LocalDateTime created_at;

    public CompanyProjectEntity() {
    }

    public CompanyProjectEntity(int company_project_id, CompanyMasterEntity companyMasterEntity, ClientMasterEntity clientMasterEntity, String company_project_name, String details, String project_picture, String duration, LocalDateTime created_at) {
        this.company_project_id = company_project_id;
        this.companyMasterEntity = companyMasterEntity;
        this.clientMasterEntity = clientMasterEntity;
        this.company_project_name = company_project_name;
        this.details = details;
        this.project_picture = project_picture;
        this.duration = duration;
        this.created_at = created_at;
    }

    public int getCompany_project_id() {
        return company_project_id;
    }

    public void setCompany_project_id(int company_project_id) {
        this.company_project_id = company_project_id;
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

    public String getCompany_project_name() {
        return company_project_name;
    }

    public void setCompany_project_name(String company_project_name) {
        this.company_project_name = company_project_name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getProject_picture() {
        return project_picture;
    }

    public void setProject_picture(String project_picture) {
        this.project_picture = project_picture;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
