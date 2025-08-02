package ru.monya.firstWebSB.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = "/home")
    public String home() {
        return "redirect:/homepage.html";
    }

    @RequestMapping("/howItsWas")
    public String howItsWas() {
        return "redirect:/how-its-was.html";
    }

    @RequestMapping("/springsecurity")
    public String springSecurity(HttpServletRequest request) {
        return "redirect:/spring-security.html";
    }
}
//Это п...ц товарищи, - простая команда  redirect: перенаправляет на статические ресурсы при использовании шаблонов Thymeleaf.
// Два дня ушло, чтобы найти эту инфу,- в англоязычном интернете. А чего только не предлагали, - даже отдельный класс конфигурации создать

//Еще фишка, без слэша после redirect: страница не обновляется в браузере в старой вкладе, - чтобы увидеть обновленную страницу нужно ввести адрес во вновь созданной вкладке, либо очистить кэш