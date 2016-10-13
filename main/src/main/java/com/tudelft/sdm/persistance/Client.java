package com.tudelft.sdm.persistance;

import com.tudelft.sdm.Application;
import io.swagger.model.ModelApiClient;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
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
    private Date created_at;

    @NotNull
    @Column(columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

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
        client.setCreatedAt(Application.dateFormat.format(this.created_at));
        client.setUpdatedAt(Application.dateFormat.format(this.updated_at));
        client.setRecords(this.records.parallelStream().map(Record::cast).collect(Collectors.toList()));
        return client;
    }
}
