package my.babicev.firstSpringProject;

import my.babicev.firstSpringProject.calculator.Addition;
import my.babicev.firstSpringProject.calculator.CalcAction;
import my.babicev.firstSpringProject.calculator.Calculator;
import my.babicev.firstSpringProject.calculator.Multiplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        //Calculator calculator = context.getBean("calculator", Calculator.class);
        //calculator.printString();
        //System.out.println(calculator.getAccuracy());
        //System.out.println(calculator.getCalcName());
        //calculator.printActionList();

        //init-method for singleton only one time
        Addition multiSingleton = context.getBean("calcInitAndDestroySingleton", Addition.class);
        Addition multiSingletonTwo = context.getBean("calcInitAndDestroySingleton", Addition.class);

        //destroy-method for prototype is not called
        Multiplication multiPrototype = context.getBean("calcInitAndDestroyPrototype", Multiplication.class);
        Multiplication multiPrototypeTwo = context.getBean("calcInitAndDestroyPrototype", Multiplication.class);

        context.close();
    }
}
