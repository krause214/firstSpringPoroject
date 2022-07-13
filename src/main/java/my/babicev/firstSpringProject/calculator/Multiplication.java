package my.babicev.firstSpringProject.calculator;

public class Multiplication implements CalcAction {
    Double varA = null;
    Double varB = null;
    Double varResult = null;

/*    public Multiplication(Double varA, Double varB) {
        setVars(varA, varB);
    }*/

    private Multiplication(){};
    //factory method
    public static Multiplication getMultiplication(Double varA, Double varB) {
        Multiplication temp = new Multiplication();
        temp.varA = varA;
        temp.varB = varB;
        return temp;
    }

    @Override
    public void doAction() {
        varResult = varA * varB;
        System.out.println("The result of multiplication is received!");
    }

    @Override
    public String getSymbol() {
        return "*";
    }

    @Override
    public String getResult() {
        return varResult.toString();
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

    @Override
    public void doMyDestroy() {
        System.out.println("Multiplication object destroyed!");
    }
}
