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

//    @RequestMapping("/{left}/{op}/{right}")
//    public String OperationRequest(@PathVariable("left") Integer left, @PathVariable("operation") String operation, @PathVariable("right") Integer right) {
//       return CalculatorService.performMathOperation(left, operation, right);
//    }

    @RequestMapping("/add/{left}/{right}")
    public String performAddOperation(@PathVariable("left") Integer left, @PathVariable("right") Integer right) {
    	Integer operationResult = CalculatorService.operationAdd(left, right);
    	return Integer.toString(operationResult);
    }

    @RequestMapping("/sub/{left}/{right}")
    public String performSubOperation(@PathVariable("left") Integer left, @PathVariable("right") Integer right) {
    	Integer operationResult = CalculatorService.operationSub(left, right);
    	return Integer.toString(operationResult);
    }

    @RequestMapping("/mul/{left}/{right}")
    public String performMulOperation(@PathVariable("left") Integer left, @PathVariable("right") Integer right) {
    	Integer operationResult = CalculatorService.operationMul(left, right);
    	return Integer.toString(operationResult);
    }

    @RequestMapping("/div/{left}/{right}")
    public String performDivOperation(@PathVariable("left") Integer left, @PathVariable("right") Integer right) {
    	if (right != 0) {
    		Integer operationResult = CalculatorService.operationDiv(left, right);
    		return Integer.toString(operationResult);
    	}
    	else {
            return "Error: division by 0";
        }
    }
}
