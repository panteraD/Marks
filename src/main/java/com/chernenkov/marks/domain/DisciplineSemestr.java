package com.chernenkov.marks.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Andrey on 29.04.2016.
 */
@Entity
@Table(name = "disciplines_semestr")
public class DisciplineSemestr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "discipline_id", nullable = false)
    private Discipline discipline;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "speciality_id", nullable = false)
    private Speciality speciality;

    @Column(name = "semestr", nullable = false)
    private int semestr;

    @OneToMany(mappedBy = "disciplineSemestr")
    private Set<DisciplineParam> disciplineParams;

    public Set<DisciplineParam> getDisciplineParams() {
        return disciplineParams;
    }

    public void setDisciplineParams(Set<DisciplineParam> disciplineParams) {
        this.disciplineParams = disciplineParams;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public int getSemestr() {
        return semestr;
    }

    public void setSemestr(int semestr) {
        this.semestr = semestr;
    }
}
