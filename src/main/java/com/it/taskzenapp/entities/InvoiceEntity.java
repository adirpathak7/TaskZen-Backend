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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Aditya Pathak R
 */
@Entity
@Table(name = "invoice_tbl")
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int invoice_id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private ClientMasterEntity clientMasterEntity;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private CompanyMasterEntity companyMasterEntity;

    @OneToMany
    @JoinColumn(name = "client_project_id", referencedColumnName = "client_project_id")
    private ClientProjectEntity clientProjectEntity;

    @OneToMany
    @JoinColumn(name = "company_project_id", referencedColumnName = "company_project_id")
    private CompanyProjectEntity companyProjectEntity;

    @OneToMany
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id")
    private PaymentEntity paymentEntity;

    @OneToMany
    @JoinColumn(name = "start_date", referencedColumnName = "start_date")
    @JoinColumn(name = "end_date", referencedColumnName = "end_date")
    private ContractEntity contractEntity;

    private LocalDateTime created_at;

    public InvoiceEntity() {
    }

    public InvoiceEntity(int invoice_id, ClientMasterEntity clientMasterEntity, CompanyMasterEntity companyMasterEntity, ClientProjectEntity clientProjectEntity, CompanyProjectEntity companyProjectEntity, PaymentEntity paymentEntity, ContractEntity contractEntity, LocalDateTime created_at) {
        this.invoice_id = invoice_id;
        this.clientMasterEntity = clientMasterEntity;
        this.companyMasterEntity = companyMasterEntity;
        this.clientProjectEntity = clientProjectEntity;
        this.companyProjectEntity = companyProjectEntity;
        this.paymentEntity = paymentEntity;
        this.contractEntity = contractEntity;
        this.created_at = created_at;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
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

    public ClientProjectEntity getClientProjectEntity() {
        return clientProjectEntity;
    }

    public void setClientProjectEntity(ClientProjectEntity clientProjectEntity) {
        this.clientProjectEntity = clientProjectEntity;
    }

    public CompanyProjectEntity getCompanyProjectEntity() {
        return companyProjectEntity;
    }

    public void setCompanyProjectEntity(CompanyProjectEntity companyProjectEntity) {
        this.companyProjectEntity = companyProjectEntity;
    }

    public PaymentEntity getPaymentEntity() {
        return paymentEntity;
    }

    public void setPaymentEntity(PaymentEntity paymentEntity) {
        this.paymentEntity = paymentEntity;
    }

    public ContractEntity getContractEntity() {
        return contractEntity;
    }

    public void setContractEntity(ContractEntity contractEntity) {
        this.contractEntity = contractEntity;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
