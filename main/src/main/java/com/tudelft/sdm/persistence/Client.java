package com.tudelft.sdm.persistence;

import com.tudelft.sdm.Application;
import io.swagger.model.ModelApiClient;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    private String fname;

    @NotNull
    private String lname;

    @NotNull
    private String email;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Record> records = new ArrayList<>();

    @NotNull
    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @NotNull
    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Client(){}

    public Client(ModelApiClient client) {
        this.fname = client.getFname();
        this.lname = client.getLname();
        this.email = client.getEmail();
    }

    public void merge(ModelApiClient client) {
        this.fname = client.getFname();
        this.lname = client.getLname();
        this.email = client.getEmail();
    }

    public ModelApiClient cast() {
        ModelApiClient client = new ModelApiClient();
        client.setId(this.id.intValue());
        client.setFname(this.fname);
        client.setLname(this.lname);
        client.setEmail(this.email);
        client.setCreatedAt(Application.dateFormat.format(this.createdAt));
        client.setUpdatedAt(Application.dateFormat.format(this.updatedAt));
        return client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
