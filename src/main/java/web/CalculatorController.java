package web;

import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

	/**
	 * Computes a mathematical expression
	 * @param expression the input mathematical expression
	 * @return the result of the operation
	 */
    @RequestMapping("/calculate")
    public String performOperation(@RequestParam("expression") String expression) {
    	return CalculatorService.computeExpression(expression);
    }
}
