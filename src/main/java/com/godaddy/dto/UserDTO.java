package com.godaddy.dto;

import java.util.Set;

/**
 * Created by sasha on 20.02.2018.
 */
public class UserDTO {
    private String name;

    private Set<String> phones;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }
}
