package com.chernenkov.marks.domain;

import javax.persistence.*;

/**
 * Created by Andrey on 12.05.2016.
 */
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "role_name")
    private String roleName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
