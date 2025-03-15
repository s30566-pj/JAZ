package pl.pjatk.danmak.components;


import org.springframework.boot.context.properties.ConfigurationProperties;
import pl.pjatk.danmak.config.ConfigProperties;

public class Two {

    public Two(One one, ConfigProperties config) {
        System.out.println("Two");
        System.out.println("\n");
        System.out.println(config.getCredentials().getPassword());
        System.out.println(config.getLoginUrl());
        System.out.println(config.getCredentials().getUser());
        System.out.println("\n");
    }

    public void printMe(){
        System.out.println("Two");
        System.out.println("printMe");
    }

}
