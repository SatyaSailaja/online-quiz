package com.sailu.controllers;


import com.sailu.models.data.LanguageDao;
import com.sailu.models.data.QuestionDao;
import com.sailu.models.forms.Language;
import com.sailu.models.forms.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("takeaquiz")
public class TakeAQuizController extends AbstractController{
    @Autowired
    private LanguageDao languageDao;

    @Autowired
    private QuestionDao questionDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("languages", languageDao.findAll());
        model.addAttribute("title", " Quiz Languages");

        return "takeaquiz/index";
    }
    @RequestMapping(value = "view-questions/{id}", method = RequestMethod.GET)
    public String viewQuestions(Model model, @PathVariable int id) {


       Question question = questionDao.findOne(id);
        model.addAttribute("question", question.getQuiz());



        return "takeaquiz/view-questions";
    }

}
