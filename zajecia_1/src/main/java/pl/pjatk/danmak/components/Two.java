package pl.pjatk.danmak.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Two {
    @Autowired
    public Two(One one){
        System.out.println("Two");
    }

    public void printMe(){
        System.out.println("Two");
        System.out.println("printMe");
    }

}
