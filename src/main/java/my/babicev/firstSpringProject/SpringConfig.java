package my.babicev.firstSpringProject;

import my.babicev.firstSpringProject.calculator.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;

@Configuration
@PropertySource("classpath:calculator.properties")
public class SpringConfig {
    @Bean
    @Scope("singleton")
    public Calculator calculator(){
        return new Calculator(actionListBean());
    }

    @Bean
    public ArrayList<CalcAction> actionListBean(){
        ArrayList<CalcAction> actionList = new ArrayList<>();
        actionList.add(multiplicationBean());
        actionList.add(subtractionBean());
        actionList.add(additionBean());
        return actionList;
    }

    @Bean
    public Multiplication multiplicationBean(){
        return new Multiplication(9d, 6d);
    }

    @Bean
    public Subtraction subtractionBean(){
        return new Subtraction(15d, 16d);
    }

    @Bean
    public Addition additionBean(){
        return new Addition(10d, 12d);
    }
}
