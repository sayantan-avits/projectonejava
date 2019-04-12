package com.example.projectone.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bk_time_log")//@NamedQuery(name = "bk_time_log.findByDateRange", query = "SELECT o FROM bk_time_log o WHERE o.created_at BETWEEN ?1 AND ?2")//"SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(?1)")
@EntityListeners(AuditingEntityListener.class)

public class BkTimeLogModel {
    @Id
    private String id;


    @Column(name="created_at", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    private String t1,t2,t3,t4,t5,t6;
    private String reqst_type,plantid,lineid,prodid,bk_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }
    public Date getCreateAt() {
        return createdAt;
    }
    /*public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }*/

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public String getT3() {
        return t3;
    }

    public void setT3(String t3) {
        this.t3 = t3;
    }

    public String getT4() {
        return t4;
    }

    public void setT4(String t4) {
        this.t4 = t4;
    }

    public String getT5() {
        return t5;
    }

    public void setT5(String t5) {
        this.t5 = t5;
    }

    public String getT6() {
        return t6;
    }

    public void setT6(String t6) {
        this.t6 = t6;
    }

    public String getReqst_type() {
        return reqst_type;
    }

    public void setReqst_type(String reqst_type) {
        this.reqst_type = reqst_type;
    }

    public String getPlantid() {
        return plantid;
    }

    public void setPlantid(String plantid) {
        this.plantid = plantid;
    }

    public String getLineid() {
        return lineid;
    }

    public void setLineid(String lineid) {
        this.lineid = lineid;
    }

    public String getProdid() {
        return prodid;
    }

    public void setProdid(String prodid) {
        this.prodid = prodid;
    }

    public String getBk_time() {
        return bk_time;
    }

    public void setBk_time(String bk_time) {
        this.bk_time = bk_time;
    }
}
