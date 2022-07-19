package my.babicev.firstSpringProject.calculator;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component("subtractionBean")
public class Subtraction implements CalcAction {
    Double varA = null;
    Double varB = null;
    Double varResult = null;
    ArrayList<Pair<Double, Double>> arrayPairsVars = new ArrayList<Pair<Double, Double>>();


    public Subtraction(@Value("10") Double varA, @Value("50") Double varB) {
        setVars(varA, varB);
        Random random = new Random();
        for (int i = 0; i < 3; i++){
            arrayPairsVars.add(new Pair<>(
                    random.nextDouble() + random.nextInt() % 100,
                    random.nextDouble() + random.nextInt() % 100));
        }
    }

    @Override
    public void doAction() {
        varResult = varA - varB;
        System.out.println("The result of subtraction is received!");
    }

    @Override
    public String getSymbol() {
        return "-";
    }

    @Override
    public String getResult() throws NullPointerException {
        try {
            return varResult.toString();
        } catch (NullPointerException e){
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

    @Override
    public void doMyDestroy() {
        System.out.println("Subtraction object destroyed!");
    }

    @Override
    public void randomVarsAction() {
        Random random = new Random();
        Pair<Double, Double> temp = arrayPairsVars.get(random.nextInt() % arrayPairsVars.size());
        varA = temp.getKey();
        varB = temp.getValue();
        doAction();
    }
}
