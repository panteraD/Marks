package com.chernenkov.marks.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Andrey on 29.04.2016.
 */
@Entity
@Table(name = "disciplines")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "teacher_id",  nullable = false)
    private Teacher teacher;

    @Column(name = "study_plan_code", nullable = false)
    private int studyPlanCode;

    @OneToMany(mappedBy = "discipline")
    private Set<DisciplineSemestr> disciplineSemestrs;

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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getStudyPlanCode() {
        return studyPlanCode;
    }

    public void setStudyPlanCode(int studyPlanCode) {
        this.studyPlanCode = studyPlanCode;
    }

    public Set<DisciplineSemestr> getDisciplineSemestrs() {
        return disciplineSemestrs;
    }

    public void setDisciplineSemestrs(Set<DisciplineSemestr> disciplineSemestrs) {
        this.disciplineSemestrs = disciplineSemestrs;
    }
}
