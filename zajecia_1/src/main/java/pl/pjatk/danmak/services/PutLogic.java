package pl.pjatk.danmak.services;


import org.springframework.stereotype.Service;

@Service
public class PutLogic {
    public String returnPut(String uno, String dos){
        return uno + ", " + dos;
    }
}
