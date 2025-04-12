package pl.pjatk.danmak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import pl.pjatk.danmak.components.One;
import pl.pjatk.danmak.components.Two;


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
