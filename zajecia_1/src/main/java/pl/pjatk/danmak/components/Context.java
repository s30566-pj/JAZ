package pl.pjatk.danmak.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;


public class Context {
    One one;
    Two two;
    @Autowired
    public Context(ApplicationContext applicationContext){
        one = applicationContext.getBean("one", One.class); //małe litery w nazwie!!!!
        two = applicationContext.getBean("two", Two.class);
        one.printMe();
        two.printMe();
    }

}
