package web;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

import parserAntlr.CalculatorVisitorImpl;
import parserAntlr.CalculatorLexer;
import parserAntlr.CalculatorParser;

public class CalculatorVisitorMain {
    public static void main(String[] args) {
        CharStream input = CharStreams.fromString("2+3*(2+1)");
        Lexer lexer = new CalculatorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree tree = parser.mainExpr();

        CalculatorVisitorImpl calculator = new CalculatorVisitorImpl();
        System.out.println("Result: " + calculator.visit(tree));
    }
}
