package com.batch26.backend.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_m_division")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
     private Integer id;
     private Integer name;

     @OneToMany(mappedBy = "division")
     private List<Department> department;
     
    public Division(Integer id, Integer name) {
        this.id = id;
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getName() {
        return name;
    }
    public void setName(Integer name) {
        this.name = name;
    }

     
}
