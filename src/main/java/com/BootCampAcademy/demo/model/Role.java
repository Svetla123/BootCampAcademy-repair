package com.BootCampAcademy.demo.model;

import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role extends AppModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private long Id;

    @Column(nullable = false)
    private String name;

    @OneToMany (mappedBy = "role")
    @JsonIgnore
    private List<AppUser> users;
}
