package com.forezp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Autowired
    private HiService hiService;

    @RequestMapping("/hi")
    public String sayHi(@RequestParam(defaultValue = "forezp", required = false) String name){
        return hiService.sayHi(name);
    }
}
