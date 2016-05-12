package com.chernenkov.marks.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Andrey on 29.04.2016.
 */

@Entity
@Table(name = "discipline_params")
public class DisciplineParam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "discipline_semestr_id", nullable = false)
    private DisciplineSemestr disciplineSemestr;

    @Column(name = "actitity_name", nullable = false)
    private String activityName;

    @Column(name = "activity_max_quantity", nullable = false)
    private String activityMaxQuantity;

    @Column(name = "score_per_activity", nullable = false)
    private int scorePerActivity;

    @Column(name = "score_max", nullable = false)
    private int scoreMax;

    @OneToMany(mappedBy = "disciplineParam")
    private Set<StudentDisciplineSemestr> studentDisciplineSemestrSet;


    public Set<StudentDisciplineSemestr> getStudentDisciplineSemestrSet() {
        return studentDisciplineSemestrSet;
    }

    public void setStudentDisciplineSemestrSet(Set<StudentDisciplineSemestr> studentDisciplineSemestrSet) {
        this.studentDisciplineSemestrSet = studentDisciplineSemestrSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DisciplineSemestr getDisciplineSemestr() {
        return disciplineSemestr;
    }

    public void setDisciplineSemestr(DisciplineSemestr disciplineSemestr) {
        this.disciplineSemestr = disciplineSemestr;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityMaxQuantity() {
        return activityMaxQuantity;
    }

    public void setActivityMaxQuantity(String activityMaxQuantity) {
        this.activityMaxQuantity = activityMaxQuantity;
    }

    public int getScorePerActivity() {
        return scorePerActivity;
    }

    public void setScorePerActivity(int scorePerActivity) {
        this.scorePerActivity = scorePerActivity;
    }

    public int getScoreMax() {
        return scoreMax;
    }

    public void setScoreMax(int scoreMax) {
        this.scoreMax = scoreMax;
    }
}
