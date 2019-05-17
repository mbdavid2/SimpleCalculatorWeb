package web;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorControllerTest {

    @Autowired
    private CalculatorController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testAdd() throws Exception {
        String operation = "2+3";
        String result = controller.performOperation(operation);
        assert(result).equals("5.0");
    }

    @Test
    public void testSub() throws Exception {
        String operation = "2-3";
        String result = controller.performOperation(operation);
        assert(result).equals("-1.0");
    }

    @Test
    public void testMul() throws Exception {
        String operation = "2x3";
        String result = controller.performOperation(operation);
        assert(result).equals("6.0");
    }

    @Test
    public void testDiv() throws Exception {
        String operation = "4/2";
        String result = controller.performOperation(operation);
        assert(result).equals("2.0");
    }

    @Test
    public void testComplex() throws Exception {
        String operation = "10-3x(4/2 - 2)";
        String result = controller.performOperation(operation);
        assert(result).equals("10.0");
    }

    @Test
    public void testNegation() throws Exception {
        String operation = "2x3--4";
        String result = controller.performOperation(operation);
        assert(result).equals("10.0");
    }

    @Test
    public void testSyntaxError() throws Exception {
        String operation = "2*-*3";
        String result = controller.performOperation(operation);
        assert(result).equals("Syntax error");
    }
}