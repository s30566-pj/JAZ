package pl.pjatk.danmak.components;

import org.springframework.stereotype.Component;

@Component
public class One {
    public One(){
        System.out.println("One");
    }

    public void printMe(){
        System.out.println("One");
        System.out.println("printMe");
    }
}
