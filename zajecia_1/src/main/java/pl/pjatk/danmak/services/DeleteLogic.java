package pl.pjatk.danmak.services;

import org.springframework.stereotype.Service;

@Service
public class DeleteLogic {
    public int returnIfGood(String pathVariable){
        if (!pathVariable.isEmpty()){
            return 200;
        }
        return 204;
    }
}
