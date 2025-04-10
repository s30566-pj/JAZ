package pl.pjatk.danmak.components;

import org.springframework.stereotype.Component;

@Component
public class PutLogic {
    public String returnPut(String uno, String dos){
        return uno + ", " + dos;
    }
}
