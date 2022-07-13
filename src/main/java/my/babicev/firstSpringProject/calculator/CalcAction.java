package my.babicev.firstSpringProject.calculator;

public interface CalcAction {
    void doAction();
    String getSymbol();
    String getResult() throws NullPointerException;
    void setVars(Double varA, Double varB);
    Double getA();
    Double getB();
    void doMyDestroy();
}
