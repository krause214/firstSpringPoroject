package my.babicev.firstSpringProject;

import my.babicev.firstSpringProject.calculator.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        Calculator calculator = context.getBean("calculator", Calculator.class);
        //calculator.printString(TypeOfAction.SUBTRACTION);
        //calculator.printString(TypeOfAction.ADDITION);

        System.out.println(calculator.getCalcName());
        System.out.println(calculator.getAccuracy());
        context.close();
    }
}
