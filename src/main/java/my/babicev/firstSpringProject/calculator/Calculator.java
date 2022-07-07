package my.babicev.firstSpringProject.calculator;

public class Calculator {
    private CalcAction calcAction;

    // IoC
    public Calculator(CalcAction calcAction){
        this.calcAction = calcAction;
    }

    public void printString(){
        System.out.println(calcAction.getA() + " " + calcAction.getSymbol()
            + " " + calcAction.getB() + " = " + calcAction.getResult());
    }
}
