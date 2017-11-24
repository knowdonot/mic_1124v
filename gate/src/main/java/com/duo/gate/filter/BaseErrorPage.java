package com.duo.gate.filter;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class BaseErrorPage implements ErrorController {


    @Override
    public String getErrorPath() {
        System.out.println("----------error---------");
        return "500";
    }

    @RequestMapping
    public String error() {
        return getErrorPath();
    }

}