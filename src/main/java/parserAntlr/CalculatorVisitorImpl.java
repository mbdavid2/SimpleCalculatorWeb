package parserAntlr;

public class CalculatorVisitorImpl extends CalculatorBaseVisitor<Double> {

    @Override
    public Double visitNumber(CalculatorParser.NumberContext ctx) {
        return Double.parseDouble(ctx.NUMBER().getText());
    }

    @Override
    public Double visitPar(CalculatorParser.ParContext ctx) {
        return this.visit(ctx.inside);
    }

    @Override
    public Double visitAdd(CalculatorParser.AddContext ctx) {
        Double a = this.visit(ctx.expr(0));
        Double b = this.visit(ctx.expr(1));
        return a + b;
    }

    @Override
    public Double visitSub(CalculatorParser.SubContext ctx) {
        Double a = this.visit(ctx.expr(0));
        Double b = this.visit(ctx.expr(1));
        return a - b;
    }

    @Override
    public Double visitMul(CalculatorParser.MulContext ctx) {
        Double a = this.visit(ctx.expr(0));
        Double b = this.visit(ctx.expr(1));
        return a * b;
    }

    @Override
    public Double visitDiv(CalculatorParser.DivContext ctx) {
        Double a = this.visit(ctx.expr(0));
        Double b = this.visit(ctx.expr(1));
        return a / b;
    }


}
