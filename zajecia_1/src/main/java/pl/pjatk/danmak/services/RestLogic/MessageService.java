package pl.pjatk.danmak.services.RestLogic;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public String responseEntity(String wartosc){
        if (wartosc != null){
            return wartosc;
        } else {
            return "Hello world";
        }
    }

}
