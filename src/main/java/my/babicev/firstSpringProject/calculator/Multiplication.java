package my.babicev.firstSpringProject.calculator;

public class Multiplication implements CalcAction {
    Double varA = null;
    Double varB = null;
    Double varResult = null;

    public Multiplication(Double varA, Double varB) {
        setVars(varA, varB);
    }

    @Override
    public void doAction() {
        varResult = varA * varB;
    }

    @Override
    public String getSymbol() {
        return "*";
    }

    @Override
    public String getResult() throws NullPointerException {
        try{
            return varResult.toString();
        }
        catch (NullPointerException e){
            doAction();
            return varResult.toString();
        }
    }

    @Override
    public void setVars(Double varA, Double varB) {
        this.varA = varA;
        this.varB = varB;
    }

    @Override
    public Double getA() {
        return varA;
    }

    @Override
    public Double getB() {
        return varB;
    }
}
