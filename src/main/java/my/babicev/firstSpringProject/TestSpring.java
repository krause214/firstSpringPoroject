package my.babicev.firstSpringProject;

import my.babicev.firstSpringProject.calculator.Addition;
import my.babicev.firstSpringProject.calculator.CalcAction;
import my.babicev.firstSpringProject.calculator.Calculator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        //CalcAction calcBean = context.getBean("calcBean", CalcAction.class);
        //Calculator calculator = new Calculator(calcBean);
        Calculator calculator = context.getBean("calculatorBean", Calculator.class);
        calculator.printString();

        context.close();
    }
}
