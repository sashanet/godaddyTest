package com.godaddy.persistance.entity;

import javax.persistence.*;

/**
 * Created by sasha on 20.02.2018.
 */
@Table(name ="phones")
@Entity
public class PhoneEntity {

    @Id
    private String phone;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
