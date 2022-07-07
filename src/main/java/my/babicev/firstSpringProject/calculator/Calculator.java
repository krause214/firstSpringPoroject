package my.babicev.firstSpringProject.calculator;

public class Calculator {
    private CalcAction calcAction;
    private int accuracy;
    private String calcName;

    public Calculator() {
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public String getCalcName() {
        return calcName;
    }

    public void setCalcName(String calcName) {
        this.calcName = calcName;
    }

    // IoC
    public Calculator(CalcAction calcAction){
        this.calcAction = calcAction;
    }

    public void setCalcAction(CalcAction calcAction) {
        this.calcAction = calcAction;
    }

    public void printString(){
        System.out.println(calcAction.getA() + " " + calcAction.getSymbol()
            + " " + calcAction.getB() + " = " + calcAction.getResult());
    }
}
