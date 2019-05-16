package web;

import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @RequestMapping("/calculate")
    public String performAddOperation(@RequestParam("expression") String expression) {
    	return CalculatorService.computeExpression(expression);
    }
}
