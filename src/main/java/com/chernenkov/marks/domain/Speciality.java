package com.chernenkov.marks.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Andrey on 29.04.2016.
 */

@Entity
@Table(name = "specialities")
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "speciality_name", nullable = false)
    private String specialityName;

    @OneToMany(mappedBy = "speciality", targetEntity = Group.class)
    private Set<Group> groups;

    @OneToMany(mappedBy = "speciality", targetEntity = DisciplineSemestr.class)
    private Set<DisciplineSemestr> disciplineSemestrSet;

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<DisciplineSemestr> getDisciplineSemestrSet() {
        return disciplineSemestrSet;
    }

    public void setDisciplineSemestrSet(Set<DisciplineSemestr> disciplineSemestrSet) {
        this.disciplineSemestrSet = disciplineSemestrSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    @Override
    public String toString() {
        return specialityName;
    }
}
