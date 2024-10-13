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
@Table(name = "company_post_tbl")
public class CompanyPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int company_post_id;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private CompanyMasterEntity companyMasterEntity;

    @ManyToOne
    @JoinColumn(name = "skill_id", referencedColumnName = "skill_id")
    private SkillsEntity skillsEntity;

    private String project_picture;
    private String title;
    private String description;
    private String required_skills;
    private String budget;
    private String start_date;
    private String end_date;

    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime created_at;

    public CompanyPostEntity() {
    }

    public CompanyPostEntity(int company_post_id, CompanyMasterEntity companyMasterEntity, SkillsEntity skillsEntity, String project_picture, String title, String description, String required_skills, String budget, String start_date, String end_date, Status status, LocalDateTime created_at) {
        this.company_post_id = company_post_id;
        this.companyMasterEntity = companyMasterEntity;
        this.skillsEntity = skillsEntity;
        this.project_picture = project_picture;
        this.title = title;
        this.description = description;
        this.required_skills = required_skills;
        this.budget = budget;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
        this.created_at = created_at;
    }

    public int getCompany_post_id() {
        return company_post_id;
    }

    public void setCompany_post_id(int company_post_id) {
        this.company_post_id = company_post_id;
    }

    public CompanyMasterEntity getCompanyMasterEntity() {
        return companyMasterEntity;
    }

    public void setCompanyMasterEntity(CompanyMasterEntity companyMasterEntity) {
        this.companyMasterEntity = companyMasterEntity;
    }

    public SkillsEntity getSkillsEntity() {
        return skillsEntity;
    }

    public void setSkillsEntity(SkillsEntity skillsEntity) {
        this.skillsEntity = skillsEntity;
    }

    public String getProject_picture() {
        return project_picture;
    }

    public void setProject_picture(String project_picture) {
        this.project_picture = project_picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequired_skills() {
        return required_skills;
    }

    public void setRequired_skills(String required_skills) {
        this.required_skills = required_skills;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
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
        opened("opened"), closed("closed"), inProgress("inProgress"), completed("completed"), rejected("rejected");

        private final String value;

        Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
