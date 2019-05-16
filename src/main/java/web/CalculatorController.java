package web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class CalculatorController {

    @GetMapping("/greeting")
    public String index() {
        return "Salu2";
    }

    @GetMapping("/calculate/{expression}")
    public String performAddOperation(@PathVariable("expression") String expression) {
    	String operationResult = CalculatorService.computeExpression(expression);
    	return operationResult;
    }
}
