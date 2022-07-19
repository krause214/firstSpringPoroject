package my.babicev.firstSpringProject.calculator;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component("multiplicationBean")
public class Multiplication implements CalcAction {
    Double varA = null;
    Double varB = null;
    Double varResult = null;
    ArrayList<Pair<Double, Double>> arrayPairsVars = new ArrayList<>();

    public Multiplication(@Value("10") Double varA, @Value("13") Double varB) {
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

    @Override
    public void randomVarsAction() {

    }
}
