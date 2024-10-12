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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Aditya Pathak R
 */
@Entity
@Table(name = "company_mst_tbl")
public class CompanyMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int company_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    private String contact;
    private String profile_picture;
    private String country;
    private String establish;
    private String industry;

    @Enumerated(EnumType.STRING)
    private Company_Status company_status;
    private LocalDateTime created_at;

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEstablish() {
        return establish;
    }

    public void setEstablish(String establish) {
        this.establish = establish;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Company_Status getCompany_status() {
        return company_status;
    }

    public void setCompany_status(Company_Status company_status) {
        this.company_status = company_status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public CompanyMasterEntity(int company_id, UserEntity userEntity, String contact, String profile_picture, String country, String establish, String industry, Company_Status company_status, LocalDateTime created_at) {
        this.company_id = company_id;
        this.userEntity = userEntity;
        this.contact = contact;
        this.profile_picture = profile_picture;
        this.country = country;
        this.establish = establish;
        this.industry = industry;
        this.company_status = company_status;
        this.created_at = created_at;
    }

    public enum Company_Status {
        active("active"), inactive("inactive");

        private final String value;

        Company_Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
