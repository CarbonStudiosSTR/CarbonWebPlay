package com.carbonstr.spring.model;

import javax.persistence.*;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="character")
public class Character {

    @Id
    @SequenceGenerator(name="character_seq", sequenceName="character_id_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="character_seq")
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name="account")
    private Account department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getDepartment() {
        return department;
    }

    public void setDepartment(Account department) {
        this.department = department;
    }
}
