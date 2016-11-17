package com.tudelft.sdm.persistence;

import com.tudelft.sdm.Application;
import io.swagger.model.ApiRecord;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "records")
public class Record implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @Type(type="text")
    private String name;

    @NotNull
    @Type(type="text")
    private String value;

    @JoinColumn(name = "clientId")
    @ManyToOne
    private Client client;

    @NotNull
    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @NotNull
    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Record() {}

    public Record(ApiRecord record) {
        this.name = record.getKey();
        this.value = record.getValue();
    }

    public void merge(ApiRecord record) {
        this.name = record.getKey();
        this.value = record.getValue();
    }

    public ApiRecord cast() {
        ApiRecord record = new ApiRecord();
        record.setId(this.id.intValue());
        record.setKey(this.name);
        record.setValue(this.value);
        record.setCreatedAt(Application.dateFormat.format(this.createdAt));
        record.setUpdatedAt(Application.dateFormat.format(this.updatedAt));
        return record;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
