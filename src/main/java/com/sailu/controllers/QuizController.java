package com.sailu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("home")
public class QuizController  extends AbstractController{

    static ArrayList<String> quizes = new ArrayList<>();

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("quizes", quizes);
        model.addAttribute("title", "My Quiz");

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