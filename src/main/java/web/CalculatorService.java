package web;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

import parserAntlr.CalculatorVisitorImpl;
import parserAntlr.CalculatorLexer;
import parserAntlr.CalculatorParser;

public class CalculatorService {

    private static ParseTree parseExpression(String expression) {
        CharStream input = CharStreams.fromString(expression);
        Lexer lexer = new CalculatorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokens);
        return parser.mainExpr();
    }

    public static String computeExpression(String expression) {
        ParseTree tree = parseExpression(expression);

        System.out.println("Input expression: " + expression);

        CalculatorVisitorImpl calculator = new CalculatorVisitorImpl();
        Double result = calculator.visit(tree);

        return result.toString();
    }
}
