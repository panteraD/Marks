package com.chernenkov.marks.domain;

import javax.persistence.*;

/**
 * Created by Andrey on 29.04.2016.
 */

@Entity
@Table(name = "students_discipline_semestr")
public class StudentDisciplineSemestr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "discipline_param_id", nullable = false)
    private DisciplineParam disciplineParam;

    @Column(name = "student_score", nullable = false)
    private int studentScore;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public DisciplineParam getDisciplineParam() {
        return disciplineParam;
    }

    public void setDisciplineParam(DisciplineParam disciplineParam) {
        this.disciplineParam = disciplineParam;
    }

    public int getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(int studentScore) {
        this.studentScore = studentScore;
    }
}
