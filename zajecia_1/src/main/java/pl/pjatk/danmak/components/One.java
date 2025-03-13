package pl.pjatk.danmak.components;


import org.springframework.beans.factory.annotation.Value;

public class One {
    public One(@Value("${my.custom.property:nie ma i nie będzie}") String value){
        System.out.println("One");
        System.out.println(value);
    }

    public void printMe(){
        System.out.println("One");
        System.out.println("printMe");
    }
}
