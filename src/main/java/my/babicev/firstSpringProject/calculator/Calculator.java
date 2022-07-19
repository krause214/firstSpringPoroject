package my.babicev.firstSpringProject.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component("calculator")
@Scope("singleton")
public class Calculator {
    private CalcAction calcAction;
    @Value("${calculator.accuracy}")
    private int accuracy;
    @Value("${calculator.calcName}")
    private String calcName;
    private ArrayList<CalcAction> actionList;
    @Autowired
    @Qualifier("subtractionBean")
    private Subtraction subtraction;
    @Autowired
    @Qualifier("additionBean")
    private Addition addition;

    public void setActionList(ArrayList<CalcAction> actionList) {
        this.actionList = actionList;
    }

    public Calculator() {
    }

    // IoC
    @Autowired
    public Calculator(@Qualifier("subtractionBean") CalcAction calcAction){
        this.calcAction = calcAction;
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

    public void setCalcAction(CalcAction calcAction) {
        this.calcAction = calcAction;
    }

    public void printString(){
        System.out.println(calcAction.getA() + " " + calcAction.getSymbol()
            + " " + calcAction.getB() + " = " + calcAction.getResult());
    }

    public void printString(TypeOfAction typeOfAction){
        Random random = new Random();
        int rand;
        switch (typeOfAction){
            case SUBTRACTION:
                rand = Math.abs(random.nextInt()) % subtraction.arrayPairsVars.size();
                subtraction.setVars(subtraction.arrayPairsVars.get(rand).getKey(),
                                    subtraction.arrayPairsVars.get(rand).getValue());
                subtraction.doAction();
                calcAction = subtraction;
                printString();
                break;
            case ADDITION:
                rand = Math.abs(random.nextInt()) % addition.arrayPairsVars.size();
                addition.setVars(addition.arrayPairsVars.get(rand).getKey(),
                                addition.arrayPairsVars.get(rand).getValue());
                addition.doAction();
                calcAction = addition;
                printString();
                break;
        }
    }

    public void printActionList(){
        for (CalcAction action : actionList) {
            System.out.println(action.getA() + " " + action.getSymbol()
                    + " " + action.getB() + " = " + action.getResult());
        }
    }
}
