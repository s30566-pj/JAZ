package pl.pjatk.danmak.components;

import org.springframework.stereotype.Component;

@Component
public class DeleteLogic {
    public int returnIfGood(String pathVariable){
        if (!pathVariable.isEmpty()){
            return 200;
        }
        return 204;
    }
}
