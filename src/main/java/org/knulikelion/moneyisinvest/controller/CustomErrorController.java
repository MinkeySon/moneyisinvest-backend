package org.knulikelion.moneyisinvest.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handleError() {
        // https://moneyisinvest.kr/로 리디렉션
        return "redirect:https://moneyisinvest.kr/";
    }
}