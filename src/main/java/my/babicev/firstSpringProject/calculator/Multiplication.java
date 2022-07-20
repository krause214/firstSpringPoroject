package my.babicev.firstSpringProject.calculator;

import javafx.util.Pair;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.Random;

public class Multiplication implements CalcAction {
    Double varA = null;
    Double varB = null;
    Double varResult = null;
    ArrayList<Pair<Double, Double>> arrayPairsVars = new ArrayList<>();

    public Multiplication(Double varA, Double varB) {
        setVars(varA, varB);
    }

    @PostConstruct
    void setArrayPairsVars(){
        Random random = new Random();
        for (int i = 0; i < 3; i++){
            arrayPairsVars.add(new Pair<>(
                    random.nextDouble() + random.nextInt() % 100,
                    random.nextDouble() + random.nextInt() % 100));
        }
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
        System.out.println("Multiplication object destroyed!");
    }

    @Override
    public void randomVarsAction() {

    }

    @PreDestroy
    void preDestroy(){
        System.out.println("Multiplication destroyed!");
    }
}
