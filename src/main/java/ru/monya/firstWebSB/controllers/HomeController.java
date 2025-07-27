package ru.monya.firstWebSB.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller

public class HomeController {
    @RequestMapping(value = "/home")
    public String home() {
        return "redirect://homePage.html";
    }

    @RequestMapping("/other-page")
    public String otherPages1() {
        return "redirect://index2.html";
    }




}
//Это пиздец товарищи, - простая команда  redirect: перенаправляет на статические ресурсы при использовании шаблонов Thymeleaf.
// Два дня ушло, чтобы найти эту инфу,- в англоязычном интернете. А какого только говна не предлагали, - даже отдельный класс конфигурации создать

//Еще фишка без двух косых после  redirect: страница не обновляется в браузере с в старой вкладе, - чтобы увидеть обновленную страницу нужно ввести адрес во вновь созданной вкладке