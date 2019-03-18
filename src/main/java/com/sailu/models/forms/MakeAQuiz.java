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

    @NotNull
    @Size(min=1, message = "Question must not be empty")
    private String question;

    @NotNull
    @Size(min=3, max=15)
    private String option1;

    @NotNull
    @Size(min=3, max=15)
    private String option2;

    @NotNull
    @Size(min=3, max=15)
    private String option3;

    @NotNull
    @Size(min=3, max=15)
    private String answer;




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


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
