package com.sailu.controllers;

import com.sailu.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("home")
public class QuizController  extends AbstractController{

    @Autowired
    private UserDao userDao;


    static ArrayList<String> quizes = new ArrayList<>();

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Existing Users");
        model.addAttribute("users", userDao.findAll());
       /* model.addAttribute("title", "Welcome to my Site");*/

        return "home/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String dispalyNameForm(Model model){

        model.addAttribute("title","Add Person");
        return "home/add";

    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processNameForm(@RequestParam String quizName){

        quizes.add(quizName);

        return  "redirect:";

    }


}