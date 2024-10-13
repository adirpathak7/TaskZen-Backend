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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Aditya Pathak R
 */
@Entity
@Table(name = "client_education_tbl")
public class ClientEducationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int client_education_id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private ClientMasterEntity cleClientMasterEntity;

    private String university;
    private String course;
    private String start_date;
    private String end_date;
    private LocalDateTime createdAt;

    public ClientEducationEntity() {
    }

    public ClientEducationEntity(int client_education_id, ClientMasterEntity cleClientMasterEntity, String university, String course, String start_date, String end_date, LocalDateTime createdAt) {
        this.client_education_id = client_education_id;
        this.cleClientMasterEntity = cleClientMasterEntity;
        this.university = university;
        this.course = course;
        this.start_date = start_date;
        this.end_date = end_date;
        this.createdAt = createdAt;
    }

    public int getClient_education_id() {
        return client_education_id;
    }

    public void setClient_education_id(int client_education_id) {
        this.client_education_id = client_education_id;
    }

    public ClientMasterEntity getCleClientMasterEntity() {
        return cleClientMasterEntity;
    }

    public void setCleClientMasterEntity(ClientMasterEntity cleClientMasterEntity) {
        this.cleClientMasterEntity = cleClientMasterEntity;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
