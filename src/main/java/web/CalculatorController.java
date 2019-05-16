package web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class CalculatorController {

    @RequestMapping("/greeting")
    public String index() {
        return "Salu2";
    }

    @PostMapping("/{expression}")
    public String performAddOperation(@PathVariable("expression") String expression) {
    	String operationResult = CalculatorService.computeExpression(expression);
    	return operationResult;
    }
}
