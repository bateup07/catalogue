package com.barclays.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author matthewbateup
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    String index(){
        return "index";
    }

}