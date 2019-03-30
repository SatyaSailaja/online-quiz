package com.sailu.controllers;


import com.sailu.models.User;
import com.sailu.models.data.LanguageDao;
import com.sailu.models.data.UserDao;
import com.sailu.models.forms.Language;
import com.sailu.models.forms.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("language")
public class LanguageController extends AbstractController{

    @Autowired
    private LanguageDao languageDao;


    @RequestMapping(value = "")
    public String index(Model model) {


        model.addAttribute("languages", languageDao.findAll());
        model.addAttribute("title", " Quiz Languages");

        return "language/index";
    }


    @RequestMapping(value = "add-lang", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Want to add a Topic!");
        model.addAttribute(new Language());

        return "language/add-lang";
    }

    @RequestMapping(value = "add-lang", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Language language, Errors errors) {

        if (errors.hasErrors()) {

            return "language/add-lang";
        }

        languageDao.save(language);

        return "redirect:";

    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String removeLang(Model model) {
        model.addAttribute("languages", languageDao.findAll());
        model.addAttribute("title", " Do you wanna delete a topic");
        return "language/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveLnag(@RequestParam int[] languagesIds) {

        for (int languageId : languagesIds) {
            languageDao.delete(languageId);
        }

        return "redirect:";
    }

}
