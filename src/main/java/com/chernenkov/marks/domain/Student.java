package com.chernenkov.marks.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Andrey on 29.04.2016.
 */
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @Column(name = "record_book_number", nullable = false)
    private int recordBookNumber;


    //TODO: fix table name
    @Column(name = "start_year", nullable = false)
    private Date startYear;

    @Column(name = "end_year", nullable = false)
    private Date endYear;

    @OneToMany(mappedBy = "student")
    private Set<StudentDisciplineSemestr> studentDisciplineSemestrSet;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Set<StudentDisciplineSemestr> getStudentDisciplineSemestrSet() {
        return studentDisciplineSemestrSet;
    }

    public void setStudentDisciplineSemestrSet(Set<StudentDisciplineSemestr> studentDisciplineSemestrSet) {
        this.studentDisciplineSemestrSet = studentDisciplineSemestrSet;
    }

    public int getRecordBookNumber() {
        return recordBookNumber;
    }

    public void setRecordBookNumber(int recordBookNumber) {
        this.recordBookNumber = recordBookNumber;
    }

    public Date getStartYear() {
        return startYear;
    }

    public void setStartYear(Date startYear) {
        this.startYear = startYear;
    }

    public Date getEndYear() {
        return endYear;
    }

    public void setEndYear(Date endYear) {
        this.endYear = endYear;
    }
}
