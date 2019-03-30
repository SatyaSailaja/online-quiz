package com.sailu.models.forms;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class MakeAQuiz {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String subjectName;


    public MakeAQuiz(String subjectName) {

        this.setSubjectName(subjectName);

    }
    public MakeAQuiz(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }



}
