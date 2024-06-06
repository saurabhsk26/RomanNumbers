package com.saurabh.projects.romannumbercreator.controllers;

import com.saurabh.projects.romannumbercreator.services.NumericService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NumberController {
    NumericService numericService;

    public NumberController(NumericService numericService){
        this.numericService = numericService;
    }
    @GetMapping("/getRoman")
    @ResponseBody
    public String getRomanNumber(@RequestParam(name="numb",required = false) String number){
//        int numericNotation = Integer.parseInt(number);
        String romanNotation = numericService.convert2Roman(number);
        if(romanNotation.isBlank() || romanNotation.isEmpty()){
            return "No Proper Roman notation Generated.";
        }
        else {
            return romanNotation;
        }
    }
}
