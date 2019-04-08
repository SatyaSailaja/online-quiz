package com.sailu.controllers;


import com.sailu.models.data.LanguageDao;
import com.sailu.models.data.QuestionDao;

import com.sailu.models.forms.Language;
import com.sailu.models.forms.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
@RequestMapping("takeaquiz")
public class TakeAQuizController extends AbstractController {

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private LanguageDao languageDao;


    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("languages", languageDao.findAll());
        model.addAttribute("title", " Quiz Languages");

        return "takeaquiz/index";
    }

    @RequestMapping(value = "view-questions/{id}")
    public String viewQuestions(Model model, @PathVariable int id) {


        Language language = languageDao.findOne(id);

        model.addAttribute("title", language.getName());
        model.addAttribute("questions", language.getQuestions());
       /* System.out.println("*******************************************************");


        for(Question question: language.getQuestions()){
            System.out.println("The Question is :" + question.getQuiz());
            System.out.println("The Answer is :" + question.getAnswer());
        }

        System.out.println("*******************************************************");

*/
        return "takeaquiz/view-questions";
    }

    @RequestMapping(value = "result", method = RequestMethod.POST)
    public String  processViewQuestions(Model model, @RequestParam HashMap<String,String> choices) {

        model.addAttribute("title", "Quiz Result");

        HashMap<String,String> questionSets = new HashMap<String,String>();
        List<String> quizQuestions = new ArrayList<String>();

        int count = 0;
        int j =0;


       for (String stringKey : choices.keySet()) {
           // intIds.add(Integer.parseInt(stringKey));
           Question questions = questionDao.findOne(Integer.parseInt(stringKey));
           questionSets.put(String.valueOf(questions.getId()), questions.getAnswer());
           quizQuestions.add(questions.getQuiz());
           System.out.println(quizQuestions);
       }

       for (Map.Entry<String,String> entry : choices.entrySet()){
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
            System.out.println("Actual Answer :"+questionSets.get(entry.getKey()));
            if(questionSets.get(entry.getKey()).equals(entry.getValue())){
                count++;

            }
             j = quizQuestions.size();

        }
        System.out.println(j);
        model.addAttribute("count","Score :" + count +"/"+j);
        model.addAttribute("choices",choices);
        model.addAttribute("questionSets",questionSets);
        model.addAttribute("quizQuestions",quizQuestions);




        return "takeaquiz/result";
    }

}