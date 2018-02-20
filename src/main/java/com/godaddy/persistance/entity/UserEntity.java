package com.godaddy.persistance.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by sasha on 19.02.2018.
 */
@Table(name ="user")
@Entity
public class UserEntity {
    @Id
    @GeneratedValue
    private Long Id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PhoneEntity> phones;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PhoneEntity> getPhones() {
        return phones;
    }

    public void setPhones(Set<PhoneEntity> phones) {
        this.phones = phones;
    }
}
