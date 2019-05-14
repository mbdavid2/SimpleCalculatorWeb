package com.david.simplecalculator;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class CalculatorController {

    @RequestMapping("/greeting")
    public String index() {
        return "Salu2";
    }

    @RequestMapping("/{left}/{operation}/{right}")
    public String OperationRequest(@PathVariable("left") Integer left, @PathVariable("operation") String operation, @PathVariable("right") Integer right) {
       return CalculatorService.performMathOperation(left, operation, right);
    }
}