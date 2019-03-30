
package com.sailu.controllers;


import com.sailu.models.data.LanguageDao;
import com.sailu.models.data.QuestionDao;
import com.sailu.models.forms.Language;
import com.sailu.models.forms.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("question")
public class QuestionController extends AbstractController {

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private LanguageDao languageDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("questions", questionDao.findAll());
        model.addAttribute("title", " Quiz Questions");

        return "question/index";
    }

    @RequestMapping(value = "add-question", method = RequestMethod.GET)
    public String displayAddQuestion(Model model) {
        model.addAttribute("title", " Add a Question!");
        model.addAttribute(new Question());
        model.addAttribute("languages", languageDao.findAll());

        return "question/add-question";
    }

    @RequestMapping(value = "add-question", method = RequestMethod.POST)
    public String processAddQuestion(@ModelAttribute @Valid Question newQuestion, Errors errors, @RequestParam int languageId, Model model) {

        if (errors.hasErrors()) {

            return "question/add-question";
        }
        Language language = languageDao.findOne(languageId);
        newQuestion.setLanguage(language);
        questionDao.save(newQuestion);
        return "redirect:";
    }

}
