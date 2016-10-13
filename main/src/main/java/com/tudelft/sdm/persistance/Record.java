package com.tudelft.sdm.persistance;

import com.tudelft.sdm.Application;
import io.swagger.model.ApiRecord;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "records")
public class Record implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String value;

    @JoinColumn(name = "clientId")
    @ManyToOne
    private Client client;

    @NotNull
    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @NotNull
    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    public Record() {}

    public Record(ApiRecord record) {
        this.name = record.getName();
        this.value = record.getValue();
    }

    public void merge(ApiRecord record) {
        this.name = record.getName();
        this.value = record.getValue();
    }

    public void merge(Record record) {
        this.name = record.getName();
        this.value = record.getValue();
    }

    public ApiRecord cast() {
        ApiRecord record = new ApiRecord();
        record.setId(this.id.intValue());
        record.setName(this.name);
        record.setValue(this.value);
        record.setCreatedAt(Application.dateFormat.format(this.created_at));
        record.setUpdatedAt(Application.dateFormat.format(this.updated_at));
        return record;
    }
}
