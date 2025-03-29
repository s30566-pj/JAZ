package pl.pjatk.danmak.services;

import org.springframework.stereotype.Service;
import pl.pjatk.danmak.components.Car;

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
