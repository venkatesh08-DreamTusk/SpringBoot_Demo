package com.DreamTusk.venkatesh.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    //@RequestMapping(value = "/",method = RequestMethod.GET)
    @GetMapping("/")
    public String add(){
        return "DreamTusk Technologies  ";
    }

}
