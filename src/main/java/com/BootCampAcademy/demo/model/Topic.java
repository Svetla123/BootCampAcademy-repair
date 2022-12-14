package com.BootCampAcademy.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table(name = "topics")
@Data
@EqualsAndHashCode(callSuper = true)
public class Topic extends AppModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private long Id;

    private String name;
    private String description;
    private String expectedHours;
    @OneToMany (mappedBy = "topic")
    @JsonIgnore
    private List<Meeting> meetings;
}
