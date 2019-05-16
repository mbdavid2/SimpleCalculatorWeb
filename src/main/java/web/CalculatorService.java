package web;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import parserAntlr.CalculatorVisitorImpl;
import parserAntlr.CalculatorLexer;
import parserAntlr.CalculatorParser;
import parserAntlr.ErrorHandlerListener;

public class CalculatorService {

    private static ParseTree parseExpression(String expression) throws ParseCancellationException {
        CharStream input = CharStreams.fromString(expression);
        Lexer lexer = new CalculatorLexer(input);

        // Add custom error handler for the lexer
        lexer.removeErrorListeners();
        lexer.addErrorListener(new ErrorHandlerListener());


        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokens);

        // Add custom error handler for the parser
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorHandlerListener());

        return parser.mainExpr();
    }

    protected static String computeExpression(String expression) throws ParseCancellationException {
        try {
            ParseTree tree = parseExpression(expression);
            CalculatorVisitorImpl calculator = new CalculatorVisitorImpl();
            Double result = calculator.visit(tree);
            return result.toString();
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
}
