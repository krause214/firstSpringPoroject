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
        //Calculator calculator = context.getBean("calculator", Calculator.class);
        //calculator.printString();
        //System.out.println(calculator.getAccuracy());
        //System.out.println(calculator.getCalcName());
        //calculator.printActionList();

        //singleton as default
        Calculator calculatorSingletonOne = context.getBean("calcBeanSingleton", Calculator.class);
        Calculator calculatorSingletonTwo = context.getBean("calcBeanSingleton", Calculator.class);
        System.out.println(calculatorSingletonOne.toString());
        System.out.println(calculatorSingletonTwo.toString());

        //prototype
        Calculator calculatorPrototypeOne = context.getBean("calcBeanPrototype", Calculator.class);
        Calculator calculatorPrototypeTwo = context.getBean("calcBeanPrototype", Calculator.class);
        System.out.println(calculatorPrototypeOne.toString());
        System.out.println(calculatorPrototypeTwo.toString());

        context.close();
    }
}
