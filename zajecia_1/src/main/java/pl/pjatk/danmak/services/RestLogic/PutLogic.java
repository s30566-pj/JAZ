package pl.pjatk.danmak.services.RestLogic;


import org.springframework.stereotype.Service;

@Service
public class PutLogic {
    public String returnPut(String uno, String dos){
        return uno + ", " + dos;
    }
}
