package com.sailu.models.forms;

//Catageory

import javax.persistence.*;
/*import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;*/
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/*
import java.util.ArrayList;
import java.util.List;
*/
@Entity
public class Language {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1, message = "Topic must not be empty")
    private String name;


    @OneToMany
    @JoinColumn(name = "language_id")
    private List<Question> questions = new ArrayList<>();


    public Language(String name) {

        this.name = name;
    }

    public Language() {
    }

    public List<Question> getQuestions() {
        return questions;
    }

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

}