package my.babicev.firstSpringProject;

import my.babicev.firstSpringProject.calculator.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Calculator calculator = context.getBean("calculator", Calculator.class);
        //calculator.printString(TypeOfAction.SUBTRACTION);
        //calculator.printString(TypeOfAction.ADDITION);

        calculator.printString();
        System.out.println(calculator.getCalcName());
        System.out.println(calculator.getAccuracy());
        context.close();
    }
}
