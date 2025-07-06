package ru.monya.firstWebSB.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller

public class HomeController {
    @RequestMapping(value = "/home")
    public String home() {
        return "redirect:index3.html";
    }

    @RequestMapping("/other-page")
    public String otherPages1() {
        return "redirect:index2.html";
    }




}
//Это пиздец товарищи, - простая команда  redirect: перенаправляет на статические ресурсы при использовании шаблонов Thymeleaf.
// Два дня ушло, чтобы найти эту инфу,- в англоязычном интернете. А какого только говна не предлагали, - даже отдельный класс конфигурации создать