package com.sailu.controllers;

import com.sailu.models.data.MakeAQuizDao;
import com.sailu.models.forms.MakeAQuiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("makeaquiz")
public class MakeAQuizController {

    @Autowired
    private MakeAQuizDao makeAQuizDao;


    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("makeaquizs", makeAQuizDao.findAll());
        model.addAttribute("title", "My Quizes");

        return "makeaquiz/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayMakeAQuizForm(Model model) {
        model.addAttribute("title", "Add Subject");
        return "makeaquiz/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processMakeAQuizForm(@ModelAttribute MakeAQuiz newMakeAQuiz) {
        makeAQuizDao.save(newMakeAQuiz);
        return "redirect:view/" + newMakeAQuiz.getId();
    }


    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String view(Model model, @PathVariable int id) {

        MakeAQuiz makeAQuiz = makeAQuizDao.findOne(id);

        model.addAttribute("title", makeAQuiz.getSubjectName());
        model.addAttribute("menu", makeAQuiz);
        return "menu/view";
    }

    @RequestMapping(value = "add-question/{subjectId}", method = RequestMethod.GET)
    public String addQuestions(Model model, @PathVariable int subjectId) {

        MakeAQuiz makeAQuiz = makeAQuizDao.findOne(subjectId);

        model.addAttribute("title", "Add item to menu: " + makeAQuiz.getSubjectName());


        return "menu/add-question";
    }

}





