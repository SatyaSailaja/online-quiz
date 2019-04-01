package com.sailu.models.forms;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


//Cheese
@Entity
public class Question {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1,message = "Question must not be empty")
    private String quiz;

    @NotNull
    @Size(min=1, message = "Option should not be empty")
    private String choice1;

    @NotNull
    @Size(min=1, message = "Option should not be empty")
    private String choice2;

    @NotNull
    @Size(min=1, message = "Option should not be empty")
    private String choice3;

    @NotNull
    @Size(min=1, message = "Option should not be empty")
    private String choice4;

    @NotNull
    @Size(min=1,message = "Answer should not be empty")
    private String answer;

    @ManyToOne
    private Language language;



    public Question(){ }

    public Question(String quiz, String choice1,String choice2,String choice3,String choice4,String answer) {
        this.quiz = quiz;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.answer  =  answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }


}

